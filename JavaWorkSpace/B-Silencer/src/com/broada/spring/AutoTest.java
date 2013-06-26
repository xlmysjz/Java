package com.broada.spring;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.broada.spring.condition.ExceptElement;
import com.broada.spring.condition.ExceptFrame;
import com.broada.spring.condition.ExceptWindow;
import com.broada.utils.Utils;
import com.spring.core.ElementData;
import com.spring.core.InputData;
import com.spring.core.Messages;

public class AutoTest extends Utils {
    /**
     * 浏览器类型
     */
    private int browserID;
    /**
     * 驱动浏览器
     */
    private WebDriver browser;
    /**
     * yaml文件的hash数据
     */
    private ElementData trace;
    /**
     * 输入数据
     */
    private InputData inputData;
    /**
     * 日志控制
     */
    private Log log;
    /**
     * 页面元素文件
     */
    private File pageFile;
    /**
     * 本次执行过程中窗口的ID记录列表
     */
    private ArrayList<String> windowsList;
    /**
     * 最原始窗口句柄
     */
    private String winHandle;
    /**
     * 当前浏览器
     */
    private WebDriver currentBrowser;
    /**
     * 等待时间
     */
    private int maxWaitfor = Utils.TIME_OUT;

    /**
     * 该构造方法是用以默认选择IE为启动
     */
    public AutoTest() {
        this(0);
    }

    /**
     * 设置浏览器类型 Chrome -1， IE 0， ff 1
     */
    public AutoTest(int browserID) {
        this.browserID = browserID;
        this.log = LogFactory.getLog(AutoTest.class.getName());
        this.windowsList = new ArrayList<String>();
    }

    /**
     * 加载文件
     * 
     * @param pageFile
     *            页面元素文件
     * @param inputFile
     *            输入数据文件
     * @param expectFile
     *            期望值文件
     */
    public void loadData(File pageFile, String inputFile) {
        initBrowser();
        this.pageFile = pageFile;
        this.trace = new ElementData(pageFile, this.browser, this.log);
        this.inputData = new InputData(inputFile, this.log);
        if (inputData.getFlag() != "0") { //$NON-NLS-1$
            this.log.error(Messages.getString("AutoTest.loadDatafile") + inputFile //$NON-NLS-1$
                    + Messages.getString("AutoTest.fail")); //$NON-NLS-1$
            this.close();
        } else {
            this.log.info(Messages.getString("AutoTest.loadDatafile") + " " + inputFile //$NON-NLS-1$ //$NON-NLS-2$
                    + Messages.getString("AutoTest.finish")); //$NON-NLS-1$
        }
        if (this.trace.getDataHash() == null) {
            this.log.error(Messages.getString("AutoTest.loadYamlfile") //$NON-NLS-1$
                    + pageFile.getAbsolutePath()
                    + Messages.getString("AutoTest.fail")); //$NON-NLS-1$
            this.close();
        } else {
            this.log.info(Messages.getString("AutoTest.loadYamlfile") //$NON-NLS-1$
                    + pageFile.getAbsolutePath()
                    + Messages.getString("AutoTest.finish")); //$NON-NLS-1$
        }
    }

    /**
     * 打开Yaml中的URL 使用该方法，必须在yaml文件中配置URL
     */
    public void openUrl() {
        this.trace.openURL();
        this.winHandle = this.browser.getWindowHandle();
        this.windowsList.add(winHandle);
    }

    /**
     * 打开用户自定义URL
     * 
     * @param url
     */
    public void openUrl(String url) {
        this.browser.get(url);
    }

    /**
     * 在指定时间内循环等待，直到对象可见，超时之后直接抛出对象不可见异常信息。
     * 
     * @param element
     *            the WebElement to be judged
     * @param timeout
     *            timeout setting in seconds
     */
    protected void waitUntilElementVisible(WebElement element, int timeout) {
        long start = System.currentTimeMillis();
        boolean isDisplayed = false;
        while (!isDisplayed
                && ((System.currentTimeMillis() - start) < timeout * 1000)) {
            isDisplayed = (element == null) ? false : element.isDisplayed();
        }
        if (!isDisplayed) {
            String error = "当前元素在" + timeout + "秒里不能识别";
            this.log.error(error);
            this.screenShot(error);
            this.close();
        }
    }

    /**
     * 在指定时间内循环等待，直到对象可见，使用用户指定的默认超时设置。
     * 
     * @param element
     *            the WebElement to be judged
     */
    protected void waitUntilElementVisible(WebElement element) {
        waitUntilElementVisible(element, maxWaitfor);
    }

    /**
     * 点击定位到Key的元素
     * 
     * @param key
     *            在yaml文件中的元素
     */
    public void click(String key) {
        try {
            this.getElement(key).click();
        } catch (StaleElementReferenceException sere) {
            String error = "通过" + key + "获取的元素" + this.getElementDes(key)
                    + "无法识别";
            this.log.error(error);
            this.screenShot(error);
            this.close();
        }
        this.log.info(Messages.getString("AutoTest.click") + this.getElementDes(key)); //$NON-NLS-1$
    }

    /**
     * 点击元素，该元素是通过javascript获得
     * 
     * 本方法，主要是用来点击一些元素不在可见区域或者是一些特殊要求的元素 eg: 点击百度提交按钮 String jscode=
     * "var inp = document.getElementById('su'); return inp;";
     * 
     * autoTest.clickByJavaScript(jscode);
     * 
     * @param jscode
     */
    public void clickByJavaScript(String jscode) {
        WebElement jelement = this.getElementByJavaScript(jscode);
        jelement.click();
    }

    /**
     * 通过javaScript获取输入框或者文本框，然后向输入框输入给定的内容
     * 
     * @param jscode
     *            定位输入框或者文本框的javascript脚本
     * @param value
     *            需要输入的数据
     */
    public void inputByJavaScript(String jscode, String value) {
        WebElement jelement = this.getElementByJavaScript(jscode);
        jelement.sendKeys(value);
    }

    /**
     * 在等到指定对象可见之后在该对象上做清理操作，一般用于输入框和选择框。
     * 
     * @param key
     *            在yaml文件中的元素
     */
    public void clear(String key) {
        WebElement element = this.getElement(key);
        try {
            waitUntilElementVisible(element);
        } catch (ElementNotVisibleException e) {
            log.error(this.getElementDes(key) + "在当前页面上不可见");
            this.close();
        }
        try {
            element.clear();
        } catch (Exception e) {
            log.error(this.getElementDes(key) + "clear 操作失败");
            this.close();
        }
    }

    public void clearByXpath(String xpath) {
        WebElement element = this.getElementByXpath(xpath, "清空或者取消选择");
        try {
            waitUntilElementVisible(element);
        } catch (ElementNotVisibleException e) {
            log.error("通过" + xpath + "定位的元素在当前页面上不可见");

            this.close();
        }
        element.clear();
    }

    /**
     * 单击元素
     * 
     * @param element
     */
    public void click(WebElement element) {
        element.click();
    }

    /**
     * 右键点击元素
     * 
     * @param key
     *            在yaml文件中的元素
     */
    public void rightClick(String key) {
        Actions act = new Actions(this.browser);
        WebElement we = this.getElement(key);
        act.contextClick(we).perform();
    }

    /**
     * 双击定位到key的元素
     * 
     * @param key
     *            在yaml文件中的元素
     */
    public void doubleClick(String key) {
        Actions act = new Actions(this.browser);
        WebElement element = this.getElement(key);
        act.doubleClick(element).perform();
        this.log.info("双击" + this.getElementDes(key));
    }

    public void doubleClick(WebElement element) {
        Actions act = this.getActions();
        this.log.info("执行鼠标双击");
        act.doubleClick(element).perform();
    }

    /**
     * 获取Yaml文件中指定key的元素
     * 
     * @param key
     *            在yaml文件中的元素
     * @return
     */
    public WebElement getElement(String key) {
        WebElement element = this.trace.getData(key);
        try {
            this.waitUntilElementVisible(element);
        } catch (ElementNotVisibleException ene) {
            this.log.error(Messages.getString("AutoTest.getElment") + key //$NON-NLS-1$
                    + Messages.getString("AutoTest.fail")); //$NON-NLS-1$
            String message = "获取元素" + key + "失败";
            this.screenShot(message);
            this.close();
        }
        return element;
    }

    /**
     * 通过JavaScript获取元素 eg: String jscode=
     * "var inp = document.getElementById('kw'); return inp;";
     * 
     * WebElement we = autoTest.getElementByJavaScript(jscode);
     * we.sendKeys("WebElement");
     * 
     * @param jscode
     * @return
     */
    public WebElement getElementByJavaScript(String jscode) {
        WebElement jelement = null;
        jelement = (WebElement) this.executeJavaScript(jscode);
        return jelement;

    }

    private void screenShot(String message) {
        String title = getDate() + message;
        String mess = title + "." + "png";
        this.log.error("请查看抓图文件: " + Messages.getString("pngs")
                + File.separator + mess);
        SpringCapture.screenShot(browser, title);
    }

    /**
     * 根据提供xpath获取当前页面上的元素 主要用于提供参数化的元素
     * 
     * @param xpath
     * @return
     */
    public WebElement getElementByXpath(String xpath, String des) {
        WebElement we = null;
        if (xpath == null || xpath.length() == 0) {
            this.log.error("xpath为空。定位元素失败");
        } else {
            try {
                WebDriverWait wait = new WebDriverWait(this.browser, 30);
                By by = By.xpath(xpath);
                ExceptElement ee = new ExceptElement(by);
                we = wait.until(ee);
                this.log.info(des + "成功");
            } catch (TimeoutException nee) {
                this.log.error("通过xpath:" + xpath + des + "失败");
                String message = "通过xpath" + des;
                this.screenShot(message);
                this.close();
            }
        }
        return we;
    }

    /**
     * 获取当前元素的描述信息
     * 
     * @param key
     *            在yaml文件中的元素
     * @return
     */
    @SuppressWarnings("rawtypes")
    private String getElementDes(String key) {
        HashMap hm = this.trace.getDataHash();
        HashMap currentElement = (HashMap) hm.get(key);
        return (String) currentElement.get("des"); //$NON-NLS-1$
    }

    /**
     * 向定位到key的输入框中输入excel提供数据
     * 
     * @param key
     *            在yaml文件中的元素
     * @param inputKey
     *            通过读取excel获取数据
     */
    public void input(String key, String inputKey) {
        String value = this.getInputData(inputKey);
        this.getElement(key).sendKeys(value);
        this.log.info(this.getElementDes(key) + Messages.getString("input") //$NON-NLS-1$
                + "\"" + value + "\"");
    }

    /**
     * 获取Excel中通过inputkey标示的输入数据
     * 
     * @param inputKey
     * @return
     */
    public String getInputData(String inputKey) {
        String value = this.inputData.getInputData(inputKey);
        return value;
    }

    /**
     * 向定位到key的输入框中直接输入数据
     * 
     * @param key
     *            在yaml文件中的元素
     * @param value
     *            输入的数据
     */
    public void input2(String key, String value) {
        this.getElement(key).sendKeys(value);
        this.log.info(this.getElementDes(key) + Messages.getString("input") //$NON-NLS-1$
                + "\"" + value + "\"");
    }

    /**
     * 初始化浏览器 0 IE 1 ff
     */
    private void initBrowser() {
        switch (browserID) {
        case 0:
            this.browser = Browser.getIeBrowser();
            this.log.info(Messages.getString("AutoTest.ieStart")); //$NON-NLS-1$
            break;
        case 1:
            this.browser = Browser.getFirefoxBrowser();
            this.log.info(Messages.getString("AutoTest.ffstart")); //$NON-NLS-1$
            break;
        default:
            this.log.error(Messages.getString("AutoTest.browserModel") + this.browserID //$NON-NLS-1$
                    + Messages.getString("AutoTest.errorBroweser")); //$NON-NLS-1$
            this.log.error(Messages.getString("AutoTest.run") //$NON-NLS-1$
                    + Messages.getString("AutoTest.fail")); //$NON-NLS-1$
            System.exit(0);
            break;
        }
        this.currentBrowser = browser;
        this.browser.manage().window().maximize();
    }

    /**
     * 设置浏览器句柄
     * 
     * @param browser
     */
    public void setBrowser(WebDriver browser) {
        this.browser = browser;
    }

    /**
     * 获取当前的浏览器句柄
     * 
     * @return
     */
    public WebDriver getBrowser() {
        return this.browser;
    }

    /**
     * 页面等待
     * 
     * @param millis
     */
    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
            this.log.info(Messages.getString("AutoTest.pageWait") + millis //$NON-NLS-1$
                    + Messages.getString("AutoTest.millis")); //$NON-NLS-1$
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 窗口关闭
     */
    public void close() {
        if (this.browser != null) {
            this.browser.quit();
            this.log.info(Messages.getString("AutoTest.endtip")); //$NON-NLS-1$
        }
    }

    /**
     * 切换frame或者Iframe
     * 
     * @param key
     *            在yaml文件中存储的frame
     */
    public void selectFrame(String key) {
        Object ov = this.trace.getFrame(key);
        if (ov == null) {
            this.log.error(Messages.getString("AutoTest.swFail")); //$NON-NLS-1$
            this.close();
        }
        WebDriverWait wait = new WebDriverWait(this.browser, TIME_OUT);
        if (ov instanceof String) {
            try {
                ExceptFrame ef = new ExceptFrame(ov);
                wait.until(ef);
                // this.browser.switchTo().frame(IdOrName);
            } catch (TimeoutException nfe) {
                this.log.error(Messages.getString("AutoTest.swFile") + this.pageFile + Messages.getString("AutoTest.ffame") //$NON-NLS-1$ //$NON-NLS-2$
                        + key);
                String title = getDate() + "获取Frame " + key + "失败";
                String mess = title + "." + "png";
                this.log.error("请查看抓图文件: " + Messages.getString("pngs")
                        + File.separator + mess);
                SpringCapture.screenShot(browser, title);
                this.close();
            }
        } else {
            try {
                ExceptFrame ef = new ExceptFrame(ov);
                wait.until(ef);
            } catch (TimeoutException nfe) {
                this.log.error(Messages.getString("AutoTest.swFile") + this.pageFile + Messages.getString("AutoTest.ffame") //$NON-NLS-1$ //$NON-NLS-2$
                        + key);
                String title = Utils.getDate() + "获取Frame " + key + "失败";
                String mess = title + "." + "png";
                this.log.error("请查看抓图文件: " + Messages.getString("pngs")
                        + File.separator + mess);
                SpringCapture.screenShot(browser, title);
                this.close();
            }
        }
    }

    /**
     * 切换至frame
     * 
     * @param par
     */
    public void selectFrame(Object par) {
        WebDriverWait wait = new WebDriverWait(this.browser, TIME_OUT);
        this.sleep(4000);
        boolean isOk = true;
        if (par instanceof Integer) {
            try {
                Integer it = (Integer) par;
                ExceptFrame ef = new ExceptFrame(par);
                wait.until(ef);
                it++;
                this.log.info("切换至第" + it + "frame");
            } catch (TimeoutException nfe) {
                isOk = false;
            }
        } else {
            try {
                ExceptFrame ef = new ExceptFrame(par);
                wait.until(ef);
                this.log.info("切换至 frame '" + par + "'");
            } catch (TimeoutException nfe) {
                isOk = false;
            }
        }
        if (!isOk) {
            String error = "切换至 frame'" + par + "'失败";
            this.log.error(error);
            this.screenShot(error);
            this.close();
        }
    }

    /**
     * 在当前的浏览器中，执行Java script脚本
     * 
     * eg: 百度输入框中输入数据
     * autoTest.executeJS("document.getElementById('kw').value='WebElement';");
     * 其他： 如果是链接中的javascript，在href中的如<a
     * href="javascript:__doPostBack('Xbutton1','')"> 可以通过执行js
     * 为：__doPostBack('Xbutton1','')
     * 
     * @param js
     * @return
     */
    public Object executeJavaScript(String js) {
        WebDriver wd = this.getBrowser();
        try {
            return ((JavascriptExecutor) wd).executeScript(js);
        } catch (Exception e) {
            String error = "页面执行Java Script" + js + "有误!";
            this.log.error(error);
            this.screenShot("页面执行Java Script有误");
            this.close();

        }
        return null;
    }

    /**
     * 获取日志控制
     * 
     * @return
     */
    public Log getLog() {
        return this.log;
    }

    /**
     * 通过数据文件提供的数据，将动作元素sourcekey的元素拖拽到目标targetKey的位置 释放。
     * 
     * @param soureceKey
     *            被拖动动作元素
     * @param targetKey
     *            目标元素
     */
    public void dragAndDrop(String soureceKey, String targetKey) {
        WebElement source = this.getElement(soureceKey);
        WebElement target = this.getElement(targetKey);
        Actions acts = this.getActions();
        acts.dragAndDrop(source, target).perform();
    }

    /**
     * 将元素source拖拽到target的元素里，并释放
     * 
     * @param source
     * @param target
     */
    public void dragAndDrop(WebElement source, WebElement target) {
        Actions acts = this.getActions();
        acts.dragAndDrop(source, target).perform();
    }

    /**
     * 添加新的句柄
     * 
     * @param windowHandle
     */
    public void addHandle(String windowHandle) {
        if (windowHandle == null || windowHandle.length() == 0) {
            this.log.error("当前提供的window的句柄为空");
            return;
        }
        if (this.windowsList.contains(windowHandle)) {
            this.log.error("窗口句柄已经添加");
            return;
        }
        this.windowsList.add(windowHandle);
    }

    /**
     * 切换至最新弹出的窗口
     */
    public void selectNewWindow() {
        this.sleep(3000);
        browser.getWindowHandles();
        Set<String> aWins = browser.getWindowHandles();
        for (String id : aWins) {
            if (this.windowsList.indexOf(id) == -1) {
                currentBrowser = this.selectWindow(browser, id);
                this.log.info("切换至最新窗口");
                this.windowsList.add(id);
                break;
            }
        }
    }

    /**
     * 切换至指定的窗口win
     * 
     * @param win
     */
    public void selectWindow(String win) {
        this.selectWindow(this.browser, win);
    }

    private WebDriver selectWindow(WebDriver driver, String newId) {
        WebDriver d = null;
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT);
        ExceptWindow ew = new ExceptWindow(newId);
        this.sleep(3000);
        try {
            d = wait.until(ew);
        } catch (TimeoutException te) {
            String message = "切换窗口至窗口失败";
            this.log.error(message);
            this.screenShot(message);
            return null;
        }
        this.log.info("切换窗口窗口成功");
        return d;
    }

    /**
     * 切换至原来的主要窗口
     */
    public void selectMainWindow() {
        this.selectWindow(currentBrowser, winHandle);
        this.log.info("切换至主窗口");
    }

    /**
     * 关闭进程IEDriverServer
     */
    public void killProcessIEServer() {
        try {
            Runtime rt = Runtime.getRuntime();
            Process pr = rt.exec("cmd /c tskill IEDriverServer");
            try {
                pr.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取动作 将要对元素的单击，双击等
     * 
     * @see {org.openqa.selenium.interactions.Actions.Actions(WebDriver driver)}
     * 
     * @return
     */
    private Actions getActions() {
        return new Actions(this.browser);
    }

    /**
     * 记录日志-info
     * 
     * @param message
     */
    public void log(String message) {
        this.log.info(message);
    }

    protected boolean alertExists(int seconds) {
        long start = System.currentTimeMillis();
        while ((System.currentTimeMillis() - start) < seconds * 1000) {
            try {
                this.browser.switchTo().alert();
                return true;
            } catch (NoAlertPresentException ne) {
            } catch (Exception e) {
                this.log.error("当前没有可以切换的警告提示框 ");
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    /**
     * 判断指定的对象是否存在。
     * 
     * @param key
     *            yaml文件定位元素的key
     */
    public boolean elementExists(String key) {
        boolean exist = true;
        try {
            exist = this.getElement(key) == null ? true : false;
        } catch (Exception e) {
            exist = false;
        }
        return exist;
    }

    public void browserRefresh() {
        try {
            this.browser.navigate().refresh();
        } catch (Exception e) {
            String error = "刷新页面有误!";
            this.log.error(error);
            this.screenShot(error);
            this.close();
        }
    }

    /**
     * 按照指定序号选择yaml文件中的key元素下拉列表中的选项。
     * 
     * @param key
     *            yaml文件定位元素的key
     * @param index
     *            需要选择的选项的索引值
     */
    public void selectItemByIndex(String key, int index) {
        WebElement element = this.getElement(key);
        try {
            this.waitUntilElementVisible(element);
        } catch (Exception e) {
            log.error(e);
            this.close();
        }
        Select select = null;
        try {
            select = new Select(element);
        } catch (UnexpectedTagNameException utne) {
            this.log.error("通过" + key + "获取的元素" + this.getElementDes(key)
                    + ",不是HTML表单的下落列表");
            this.close();
        }
        try {
            select.selectByIndex(index);
        } catch (NoSuchElementException nee) {
            this.log.error("控件" + this.getElementDes(key) + ",不能通过索引" + index
                    + "获取Options的值");
            this.close();
        }
    }

    /**
     * 按照指定序号选择给定xpath的下拉列表中的选项。
     * 
     * @param xpath
     *            String 定位下拉列表的xpath
     * @param index
     *            int 需要索引选型值的索引
     */
    public void selectXpathItemByIndex(String xpath, int index) {
        WebElement element = this.getElementByXpath(xpath, "定位列表框");
        try {
            this.waitUntilElementVisible(element);
        } catch (Exception e) {
            String error = "当前元素不可见";
            log.error("当前元素不可见");
            this.screenShot(error);
            this.close();
        }
        Select select = null;
        try {
            select = new Select(element);
        } catch (UnexpectedTagNameException utne) {
            String error = "当前元素不是HTML表单的下拉列表";
            this.log.error(error);
            this.screenShot(error);
            this.close();
        }
        try {
            select.selectByIndex(index);
        } catch (NoSuchElementException nee) {
            String error = "给定控件不能通过索引" + index + "获取Options的值";
            this.log.error(error);
            this.screenShot(error);
            this.close();
        }
    }

    /**
     * 按照指定选项的实际值（不是可见文本值，而是对象的“value”属性的值）选择下拉列表中的选项。
     * 
     * @param key
     *            yaml文件定位元素的key
     * 
     * @param itemValue
     */
    public void selectItemByValue(String key, String itemValue) {
        WebElement element = this.getElement(key);
        try {
            this.waitUntilElementVisible(element);
        } catch (Exception e) {
            String error = "当前元素不可见";
            log.error("当前元素不可见");
            this.screenShot(error);
            this.close();
        }
        Select select = null;
        try {
            select = new Select(element);
        } catch (UnexpectedTagNameException utne) {
            this.log.error("通过" + key + "获取的元素" + this.getElementDes(key)
                    + ",不是HTML表单的下落列表");
            String error = "当前元素不是HTML表单的下拉列表";
            this.screenShot(error);
            this.close();
        }
        try {
            select.selectByValue(itemValue);
        } catch (NoSuchElementException nee) {
            this.log.error("控件" + this.getElementDes(key) + ",不能通过选项值"
                    + itemValue + "选择该控件");
            String error = "给定控件不能通过" + itemValue + "获取Options的值";
            this.screenShot(error);
            this.close();
        }
    }

    /**
     * 按照给定的xpath定位到下拉列表，并通过指定选项的实际值（不是可见文本值，而是对象的“value”属性的值）选择下拉列表中的选项。
     * 
     * @param xpath
     *            自定义定位元素的xpath
     * @param itemValue
     *            选项值
     */
    public void selectComboxItemValue(String xpath, String itemValue) {
        WebElement element = this.getElementByXpath(xpath, "下拉列表控件");
        try {
            this.waitUntilElementVisible(element);
        } catch (Exception e) {
            String error = "当前元素不可见";
            log.error("当前元素不可见");
            this.screenShot(error);
            this.close();
        }
        Select select = null;
        try {
            select = new Select(element);
        } catch (UnexpectedTagNameException utne) {
            this.log.error("通过" + xpath + "定位的元素不是HTML表单的下落列表");
            String error = "当前元素不是HTML表单的下拉列表";
            this.screenShot(error);
            this.close();
        }
        try {
            select.selectByValue(itemValue);
        } catch (NoSuchElementException nee) {
            this.log.error("下拉列表控件,不能通过选型值" + itemValue + "选择该控件");
            String error = "给定控件不能通过" + itemValue + "获取Options的值";
            this.screenShot(error);
            this.close();
        }
    }
    /**
     * 模拟键盘键入相关数据
     * 
     * keysToSend,可以是单一，也可以是组合键
     * eg:
     *    单一参数:xx.sendKeys(K.ENTER); //xx为AutoTest 对象
     *    多个参数:xx.sendkeys(K.ALT,K.ENTER);//xx为AutoTest 对象
     *   
     * @param keysToSend
     */
    public void sendKeys(CharSequence... keysToSend){
        try{
            this.getActions().sendKeys(keysToSend).perform();
            R:for (CharSequence cs : keysToSend) {
                for (K k :K.values()) {
                    if (cs.equals(k)){
                        this.log.info("模拟键盘键入"+k.name());
                        break R;
                    }
                }
            }
        }catch (Exception e) {
            this.log.error("键盘操作失败");
            this.log.error(e);
        }
        
    }
}
