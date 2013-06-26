package com.spring.core;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.broada.spring.condition.ExceptElement;
import com.broada.utils.Utils;

/**
 * 
 * @author chingsir
 * 
 */
public class ElementData extends Utils {
    @SuppressWarnings("rawtypes")
    private HashMap hm;
    private WebDriver browser;
    private Log log;
    private File file;

    public ElementData(File f, WebDriver browser, Log log) {
        this.browser = browser;
        this.log = log;
        this.file = f;
        YamlReader yr = new YamlReader(f, log);
        this.hm = yr.getDataMap();
        // getDataHash();
    }

    @SuppressWarnings("rawtypes")
    public HashMap getDataHash() {
        if (hm == null) {
            this.log.error("文件 " + this.file.getAbsolutePath()
                    + "相关元素有误，或文件为空，或文件不存在");
            this.browser.quit();
            return null;
        }

        return this.hm;
    }

    @SuppressWarnings("rawtypes")
    public WebElement getData(String key) {
        HashMap op = (HashMap) hm.get(key);
        WebElement element = null;
        String selecter = null;
        Object keyID = "id";
        Object keyXpath = "xpath";
        Object keyName = "name";
        if (op == null) {
            this.log.error("在元素文件: " + this.file.getName() + "中：");
            this.log.error("元素 " + key + "不存在，");
            return null;
        }
        WebDriverWait wait = new WebDriverWait(this.browser, TIME_OUT);
        By by = null;
        if (op.containsKey(keyID)) {
            selecter = (String) op.get(keyID);
            try {
                by = By.id(selecter);
                ExceptElement ee = new ExceptElement(by);
                element = wait.until(ee);
            } catch (TimeoutException ne) {
                this.log.error("在元素文件: " + this.file.getName() + "中：");
                this.log.error("当前元素 " + key + "通过ID: " + selecter + " 定位失败!");
            }
        } else if (op.containsKey(keyXpath)) {
            selecter = (String) op.get(keyXpath);
            try {
                by = By.xpath(selecter);
                ExceptElement ee = new ExceptElement(by);
                element = wait.until(ee);
            } catch (TimeoutException ne) {
                this.log.error("在元素文件: " + this.file.getName() + "中：");
                this.log.error("元素 " + key + "通过xpath:" + selecter + "无法定位");
            }
        } else if (op.containsKey(keyName)) {
            selecter = (String) op.get(keyName);
            try {
                by = By.name(selecter);
                ExceptElement ee = new ExceptElement(by);
                element = wait.until(ee);
            } catch (TimeoutException ne) {
                this.log.error("在元素文件: " + this.file.getName() + "中：");
                this.log.error("元素 " + key + "通过name:" + selecter + "无法定位");
            }
        } else {
            this.log.error("在元素文件: " + this.file.getName() + "中：");
            this.log.error("元素 " + key + "不存在，或者不是用id, name或者xpath定位！");
            this.browser.quit();
            return null;
        }

        return element;
    }

    public void openURL() {
        String Url = (String) hm.get("URL");
        if (Url == null || Url.length() == 0) {
            this.log.error("当前页面指定的URL为空，请查看文件 " + this.file.getAbsolutePath());
            this.browser.quit();
            // System.exit(0);
        } else {
            this.log.info("启动页面URL：" + Url);
        }
        this.browser.get(Url);
    }

    @SuppressWarnings("rawtypes")
    public Object getFrame(String framekey) {
        HashMap hf = (HashMap) this.hm.get(framekey);
        Object keyID = "id";
        Object keyName = "Name";
        Object keyIndex = "index";
        if (hf == null) {
            this.log.error("在元素文件: " + this.file.getName() + "中：");
            this.log.error("元素 " + framekey + "不存在，");
            return null;
        }
        if (hf.containsKey(keyID)) {
            return (String) hf.get(keyID);

        } else if (hf.containsKey(keyName)) {
            return (String) hf.get(keyName);

        } else if (hf.containsKey(keyIndex)) {
            String value = (String) hf.get(keyID);
            Integer iv = -1;
            try {
                iv = Integer.parseInt(value);
            } catch (NumberFormatException e) {
                this.log.error("在文件" + this.file.getAbsolutePath() + "的frame元素"
                        + framekey + "采用index定位的数值，是非整数类型");
                return null;
            }
            return iv;
        }
        return null;
    }
}
