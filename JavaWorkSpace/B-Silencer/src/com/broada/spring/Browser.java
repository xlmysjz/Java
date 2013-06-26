package com.broada.spring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
/**
 * Browser
 * @author chingsir
 *
 */
 final class Browser {
    
    /**
     * ʹ��IE�����
     * @return
     */
     static WebDriver getIeBrowser(){
        String dir_name = ".\\plugin\\IEDriverServer.exe"; 
        System.setProperty("webdriver.ie.driver",dir_name);
        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();   
        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);   
        WebDriver ie = new InternetExplorerDriver(ieCapabilities);
        return ie;
    }
    /**
     * ʹ��Firefox�����
     * @return
     */
     static WebDriver getFirefoxBrowser(){
       WebDriver ff = new FirefoxDriver();
       return ff;
    }
}
