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
     * ���������
     */
    private int browserID;
    /**
     * ���������
     */
    private WebDriver browser;
    /**
     * yaml�ļ���hash����
     */
    private ElementData trace;
    /**
     * ��������
     */
    private InputData inputData;
    /**
     * ��־����
     */
    private Log log;
    /**
     * ҳ��Ԫ���ļ�
     */
    private File pageFile;
    /**
     * ����ִ�й����д��ڵ�ID��¼�б�
     */
    private ArrayList<String> windowsList;
    /**
     * ��ԭʼ���ھ��
     */
    private String winHandle;
    /**
     * ��ǰ�����
     */
    private WebDriver currentBrowser;
    /**
     * �ȴ�ʱ��
     */
    private int maxWaitfor = Utils.TIME_OUT;

    /**
     * �ù��췽��������Ĭ��ѡ��IEΪ����
     */
    public AutoTest() {
        this(0);
    }

    /**
     * ������������� Chrome -1�� IE 0�� ff 1
     */
    public AutoTest(int browserID) {
        this.browserID = browserID;
        this.log = LogFactory.getLog(AutoTest.class.getName());
        this.windowsList = new ArrayList<String>();
    }

    /**
     * �����ļ�
     * 
     * @param pageFile
     *            ҳ��Ԫ���ļ�
     * @param inputFile
     *            ���������ļ�
     * @param expectFile
     *            ����ֵ�ļ�
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
     * ��Yaml�е�URL ʹ�ø÷�����������yaml�ļ�������URL
     */
    public void openUrl() {
        this.trace.openURL();
        this.winHandle = this.browser.getWindowHandle();
        this.windowsList.add(winHandle);
    }

    /**
     * ���û��Զ���URL
     * 
     * @param url
     */
    public void openUrl(String url) {
        this.browser.get(url);
    }

    /**
     * ��ָ��ʱ����ѭ���ȴ���ֱ������ɼ�����ʱ֮��ֱ���׳����󲻿ɼ��쳣��Ϣ��
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
            String error = "��ǰԪ����" + timeout + "���ﲻ��ʶ��";
            this.log.error(error);
            this.screenShot(error);
            this.close();
        }
    }

    /**
     * ��ָ��ʱ����ѭ���ȴ���ֱ������ɼ���ʹ���û�ָ����Ĭ�ϳ�ʱ���á�
     * 
     * @param element
     *            the WebElement to be judged
     */
    protected void waitUntilElementVisible(WebElement element) {
        waitUntilElementVisible(element, maxWaitfor);
    }

    /**
     * �����λ��Key��Ԫ��
     * 
     * @param key
     *            ��yaml�ļ��е�Ԫ��
     */
    public void click(String key) {
        try {
            this.getElement(key).click();
        } catch (StaleElementReferenceException sere) {
            String error = "ͨ��" + key + "��ȡ��Ԫ��" + this.getElementDes(key)
                    + "�޷�ʶ��";
            this.log.error(error);
            this.screenShot(error);
            this.close();
        }
        this.log.info(Messages.getString("AutoTest.click") + this.getElementDes(key)); //$NON-NLS-1$
    }

    /**
     * ���Ԫ�أ���Ԫ����ͨ��javascript���
     * 
     * ����������Ҫ���������һЩԪ�ز��ڿɼ����������һЩ����Ҫ���Ԫ�� eg: ����ٶ��ύ��ť String jscode=
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
     * ͨ��javaScript��ȡ���������ı���Ȼ����������������������
     * 
     * @param jscode
     *            ��λ���������ı����javascript�ű�
     * @param value
     *            ��Ҫ���������
     */
    public void inputByJavaScript(String jscode, String value) {
        WebElement jelement = this.getElementByJavaScript(jscode);
        jelement.sendKeys(value);
    }

    /**
     * �ڵȵ�ָ������ɼ�֮���ڸö����������������һ������������ѡ���
     * 
     * @param key
     *            ��yaml�ļ��е�Ԫ��
     */
    public void clear(String key) {
        WebElement element = this.getElement(key);
        try {
            waitUntilElementVisible(element);
        } catch (ElementNotVisibleException e) {
            log.error(this.getElementDes(key) + "�ڵ�ǰҳ���ϲ��ɼ�");
            this.close();
        }
        try {
            element.clear();
        } catch (Exception e) {
            log.error(this.getElementDes(key) + "clear ����ʧ��");
            this.close();
        }
    }

    public void clearByXpath(String xpath) {
        WebElement element = this.getElementByXpath(xpath, "��ջ���ȡ��ѡ��");
        try {
            waitUntilElementVisible(element);
        } catch (ElementNotVisibleException e) {
            log.error("ͨ��" + xpath + "��λ��Ԫ���ڵ�ǰҳ���ϲ��ɼ�");

            this.close();
        }
        element.clear();
    }

    /**
     * ����Ԫ��
     * 
     * @param element
     */
    public void click(WebElement element) {
        element.click();
    }

    /**
     * �Ҽ����Ԫ��
     * 
     * @param key
     *            ��yaml�ļ��е�Ԫ��
     */
    public void rightClick(String key) {
        Actions act = new Actions(this.browser);
        WebElement we = this.getElement(key);
        act.contextClick(we).perform();
    }

    /**
     * ˫����λ��key��Ԫ��
     * 
     * @param key
     *            ��yaml�ļ��е�Ԫ��
     */
    public void doubleClick(String key) {
        Actions act = new Actions(this.browser);
        WebElement element = this.getElement(key);
        act.doubleClick(element).perform();
        this.log.info("˫��" + this.getElementDes(key));
    }

    public void doubleClick(WebElement element) {
        Actions act = this.getActions();
        this.log.info("ִ�����˫��");
        act.doubleClick(element).perform();
    }

    /**
     * ��ȡYaml�ļ���ָ��key��Ԫ��
     * 
     * @param key
     *            ��yaml�ļ��е�Ԫ��
     * @return
     */
    public WebElement getElement(String key) {
        WebElement element = this.trace.getData(key);
        try {
            this.waitUntilElementVisible(element);
        } catch (ElementNotVisibleException ene) {
            this.log.error(Messages.getString("AutoTest.getElment") + key //$NON-NLS-1$
                    + Messages.getString("AutoTest.fail")); //$NON-NLS-1$
            String message = "��ȡԪ��" + key + "ʧ��";
            this.screenShot(message);
            this.close();
        }
        return element;
    }

    /**
     * ͨ��JavaScript��ȡԪ�� eg: String jscode=
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
        this.log.error("��鿴ץͼ�ļ�: " + Messages.getString("pngs")
                + File.separator + mess);
        SpringCapture.screenShot(browser, title);
    }

    /**
     * �����ṩxpath��ȡ��ǰҳ���ϵ�Ԫ�� ��Ҫ�����ṩ��������Ԫ��
     * 
     * @param xpath
     * @return
     */
    public WebElement getElementByXpath(String xpath, String des) {
        WebElement we = null;
        if (xpath == null || xpath.length() == 0) {
            this.log.error("xpathΪ�ա���λԪ��ʧ��");
        } else {
            try {
                WebDriverWait wait = new WebDriverWait(this.browser, 30);
                By by = By.xpath(xpath);
                ExceptElement ee = new ExceptElement(by);
                we = wait.until(ee);
                this.log.info(des + "�ɹ�");
            } catch (TimeoutException nee) {
                this.log.error("ͨ��xpath:" + xpath + des + "ʧ��");
                String message = "ͨ��xpath" + des;
                this.screenShot(message);
                this.close();
            }
        }
        return we;
    }

    /**
     * ��ȡ��ǰԪ�ص�������Ϣ
     * 
     * @param key
     *            ��yaml�ļ��е�Ԫ��
     * @return
     */
    @SuppressWarnings("rawtypes")
    private String getElementDes(String key) {
        HashMap hm = this.trace.getDataHash();
        HashMap currentElement = (HashMap) hm.get(key);
        return (String) currentElement.get("des"); //$NON-NLS-1$
    }

    /**
     * ��λ��key�������������excel�ṩ����
     * 
     * @param key
     *            ��yaml�ļ��е�Ԫ��
     * @param inputKey
     *            ͨ����ȡexcel��ȡ����
     */
    public void input(String key, String inputKey) {
        String value = this.getInputData(inputKey);
        this.getElement(key).sendKeys(value);
        this.log.info(this.getElementDes(key) + Messages.getString("input") //$NON-NLS-1$
                + "\"" + value + "\"");
    }

    /**
     * ��ȡExcel��ͨ��inputkey��ʾ����������
     * 
     * @param inputKey
     * @return
     */
    public String getInputData(String inputKey) {
        String value = this.inputData.getInputData(inputKey);
        return value;
    }

    /**
     * ��λ��key���������ֱ����������
     * 
     * @param key
     *            ��yaml�ļ��е�Ԫ��
     * @param value
     *            ���������
     */
    public void input2(String key, String value) {
        this.getElement(key).sendKeys(value);
        this.log.info(this.getElementDes(key) + Messages.getString("input") //$NON-NLS-1$
                + "\"" + value + "\"");
    }

    /**
     * ��ʼ������� 0 IE 1 ff
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
     * ������������
     * 
     * @param browser
     */
    public void setBrowser(WebDriver browser) {
        this.browser = browser;
    }

    /**
     * ��ȡ��ǰ����������
     * 
     * @return
     */
    public WebDriver getBrowser() {
        return this.browser;
    }

    /**
     * ҳ��ȴ�
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
     * ���ڹر�
     */
    public void close() {
        if (this.browser != null) {
            this.browser.quit();
            this.log.info(Messages.getString("AutoTest.endtip")); //$NON-NLS-1$
        }
    }

    /**
     * �л�frame����Iframe
     * 
     * @param key
     *            ��yaml�ļ��д洢��frame
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
                String title = getDate() + "��ȡFrame " + key + "ʧ��";
                String mess = title + "." + "png";
                this.log.error("��鿴ץͼ�ļ�: " + Messages.getString("pngs")
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
                String title = Utils.getDate() + "��ȡFrame " + key + "ʧ��";
                String mess = title + "." + "png";
                this.log.error("��鿴ץͼ�ļ�: " + Messages.getString("pngs")
                        + File.separator + mess);
                SpringCapture.screenShot(browser, title);
                this.close();
            }
        }
    }

    /**
     * �л���frame
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
                this.log.info("�л�����" + it + "frame");
            } catch (TimeoutException nfe) {
                isOk = false;
            }
        } else {
            try {
                ExceptFrame ef = new ExceptFrame(par);
                wait.until(ef);
                this.log.info("�л��� frame '" + par + "'");
            } catch (TimeoutException nfe) {
                isOk = false;
            }
        }
        if (!isOk) {
            String error = "�л��� frame'" + par + "'ʧ��";
            this.log.error(error);
            this.screenShot(error);
            this.close();
        }
    }

    /**
     * �ڵ�ǰ��������У�ִ��Java script�ű�
     * 
     * eg: �ٶ����������������
     * autoTest.executeJS("document.getElementById('kw').value='WebElement';");
     * ������ ����������е�javascript����href�е���<a
     * href="javascript:__doPostBack('Xbutton1','')"> ����ͨ��ִ��js
     * Ϊ��__doPostBack('Xbutton1','')
     * 
     * @param js
     * @return
     */
    public Object executeJavaScript(String js) {
        WebDriver wd = this.getBrowser();
        try {
            return ((JavascriptExecutor) wd).executeScript(js);
        } catch (Exception e) {
            String error = "ҳ��ִ��Java Script" + js + "����!";
            this.log.error(error);
            this.screenShot("ҳ��ִ��Java Script����");
            this.close();

        }
        return null;
    }

    /**
     * ��ȡ��־����
     * 
     * @return
     */
    public Log getLog() {
        return this.log;
    }

    /**
     * ͨ�������ļ��ṩ�����ݣ�������Ԫ��sourcekey��Ԫ����ק��Ŀ��targetKey��λ�� �ͷš�
     * 
     * @param soureceKey
     *            ���϶�����Ԫ��
     * @param targetKey
     *            Ŀ��Ԫ��
     */
    public void dragAndDrop(String soureceKey, String targetKey) {
        WebElement source = this.getElement(soureceKey);
        WebElement target = this.getElement(targetKey);
        Actions acts = this.getActions();
        acts.dragAndDrop(source, target).perform();
    }

    /**
     * ��Ԫ��source��ק��target��Ԫ������ͷ�
     * 
     * @param source
     * @param target
     */
    public void dragAndDrop(WebElement source, WebElement target) {
        Actions acts = this.getActions();
        acts.dragAndDrop(source, target).perform();
    }

    /**
     * ����µľ��
     * 
     * @param windowHandle
     */
    public void addHandle(String windowHandle) {
        if (windowHandle == null || windowHandle.length() == 0) {
            this.log.error("��ǰ�ṩ��window�ľ��Ϊ��");
            return;
        }
        if (this.windowsList.contains(windowHandle)) {
            this.log.error("���ھ���Ѿ����");
            return;
        }
        this.windowsList.add(windowHandle);
    }

    /**
     * �л������µ����Ĵ���
     */
    public void selectNewWindow() {
        this.sleep(3000);
        browser.getWindowHandles();
        Set<String> aWins = browser.getWindowHandles();
        for (String id : aWins) {
            if (this.windowsList.indexOf(id) == -1) {
                currentBrowser = this.selectWindow(browser, id);
                this.log.info("�л������´���");
                this.windowsList.add(id);
                break;
            }
        }
    }

    /**
     * �л���ָ���Ĵ���win
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
            String message = "�л�����������ʧ��";
            this.log.error(message);
            this.screenShot(message);
            return null;
        }
        this.log.info("�л����ڴ��ڳɹ�");
        return d;
    }

    /**
     * �л���ԭ������Ҫ����
     */
    public void selectMainWindow() {
        this.selectWindow(currentBrowser, winHandle);
        this.log.info("�л���������");
    }

    /**
     * �رս���IEDriverServer
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
     * ��ȡ���� ��Ҫ��Ԫ�صĵ�����˫����
     * 
     * @see {org.openqa.selenium.interactions.Actions.Actions(WebDriver driver)}
     * 
     * @return
     */
    private Actions getActions() {
        return new Actions(this.browser);
    }

    /**
     * ��¼��־-info
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
                this.log.error("��ǰû�п����л��ľ�����ʾ�� ");
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    /**
     * �ж�ָ���Ķ����Ƿ���ڡ�
     * 
     * @param key
     *            yaml�ļ���λԪ�ص�key
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
            String error = "ˢ��ҳ������!";
            this.log.error(error);
            this.screenShot(error);
            this.close();
        }
    }

    /**
     * ����ָ�����ѡ��yaml�ļ��е�keyԪ�������б��е�ѡ�
     * 
     * @param key
     *            yaml�ļ���λԪ�ص�key
     * @param index
     *            ��Ҫѡ���ѡ�������ֵ
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
            this.log.error("ͨ��" + key + "��ȡ��Ԫ��" + this.getElementDes(key)
                    + ",����HTML���������б�");
            this.close();
        }
        try {
            select.selectByIndex(index);
        } catch (NoSuchElementException nee) {
            this.log.error("�ؼ�" + this.getElementDes(key) + ",����ͨ������" + index
                    + "��ȡOptions��ֵ");
            this.close();
        }
    }

    /**
     * ����ָ�����ѡ�����xpath�������б��е�ѡ�
     * 
     * @param xpath
     *            String ��λ�����б��xpath
     * @param index
     *            int ��Ҫ����ѡ��ֵ������
     */
    public void selectXpathItemByIndex(String xpath, int index) {
        WebElement element = this.getElementByXpath(xpath, "��λ�б��");
        try {
            this.waitUntilElementVisible(element);
        } catch (Exception e) {
            String error = "��ǰԪ�ز��ɼ�";
            log.error("��ǰԪ�ز��ɼ�");
            this.screenShot(error);
            this.close();
        }
        Select select = null;
        try {
            select = new Select(element);
        } catch (UnexpectedTagNameException utne) {
            String error = "��ǰԪ�ز���HTML���������б�";
            this.log.error(error);
            this.screenShot(error);
            this.close();
        }
        try {
            select.selectByIndex(index);
        } catch (NoSuchElementException nee) {
            String error = "�����ؼ�����ͨ������" + index + "��ȡOptions��ֵ";
            this.log.error(error);
            this.screenShot(error);
            this.close();
        }
    }

    /**
     * ����ָ��ѡ���ʵ��ֵ�����ǿɼ��ı�ֵ�����Ƕ���ġ�value�����Ե�ֵ��ѡ�������б��е�ѡ�
     * 
     * @param key
     *            yaml�ļ���λԪ�ص�key
     * 
     * @param itemValue
     */
    public void selectItemByValue(String key, String itemValue) {
        WebElement element = this.getElement(key);
        try {
            this.waitUntilElementVisible(element);
        } catch (Exception e) {
            String error = "��ǰԪ�ز��ɼ�";
            log.error("��ǰԪ�ز��ɼ�");
            this.screenShot(error);
            this.close();
        }
        Select select = null;
        try {
            select = new Select(element);
        } catch (UnexpectedTagNameException utne) {
            this.log.error("ͨ��" + key + "��ȡ��Ԫ��" + this.getElementDes(key)
                    + ",����HTML���������б�");
            String error = "��ǰԪ�ز���HTML���������б�";
            this.screenShot(error);
            this.close();
        }
        try {
            select.selectByValue(itemValue);
        } catch (NoSuchElementException nee) {
            this.log.error("�ؼ�" + this.getElementDes(key) + ",����ͨ��ѡ��ֵ"
                    + itemValue + "ѡ��ÿؼ�");
            String error = "�����ؼ�����ͨ��" + itemValue + "��ȡOptions��ֵ";
            this.screenShot(error);
            this.close();
        }
    }

    /**
     * ���ո�����xpath��λ�������б���ͨ��ָ��ѡ���ʵ��ֵ�����ǿɼ��ı�ֵ�����Ƕ���ġ�value�����Ե�ֵ��ѡ�������б��е�ѡ�
     * 
     * @param xpath
     *            �Զ��嶨λԪ�ص�xpath
     * @param itemValue
     *            ѡ��ֵ
     */
    public void selectComboxItemValue(String xpath, String itemValue) {
        WebElement element = this.getElementByXpath(xpath, "�����б�ؼ�");
        try {
            this.waitUntilElementVisible(element);
        } catch (Exception e) {
            String error = "��ǰԪ�ز��ɼ�";
            log.error("��ǰԪ�ز��ɼ�");
            this.screenShot(error);
            this.close();
        }
        Select select = null;
        try {
            select = new Select(element);
        } catch (UnexpectedTagNameException utne) {
            this.log.error("ͨ��" + xpath + "��λ��Ԫ�ز���HTML���������б�");
            String error = "��ǰԪ�ز���HTML���������б�";
            this.screenShot(error);
            this.close();
        }
        try {
            select.selectByValue(itemValue);
        } catch (NoSuchElementException nee) {
            this.log.error("�����б�ؼ�,����ͨ��ѡ��ֵ" + itemValue + "ѡ��ÿؼ�");
            String error = "�����ؼ�����ͨ��" + itemValue + "��ȡOptions��ֵ";
            this.screenShot(error);
            this.close();
        }
    }
    /**
     * ģ����̼����������
     * 
     * keysToSend,�����ǵ�һ��Ҳ��������ϼ�
     * eg:
     *    ��һ����:xx.sendKeys(K.ENTER); //xxΪAutoTest ����
     *    �������:xx.sendkeys(K.ALT,K.ENTER);//xxΪAutoTest ����
     *   
     * @param keysToSend
     */
    public void sendKeys(CharSequence... keysToSend){
        try{
            this.getActions().sendKeys(keysToSend).perform();
            R:for (CharSequence cs : keysToSend) {
                for (K k :K.values()) {
                    if (cs.equals(k)){
                        this.log.info("ģ����̼���"+k.name());
                        break R;
                    }
                }
            }
        }catch (Exception e) {
            this.log.error("���̲���ʧ��");
            this.log.error(e);
        }
        
    }
}
