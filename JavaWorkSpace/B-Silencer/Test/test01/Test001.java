/**
 * 
 */
/**
 * @author Administrator
 *
 */
package test01;

import java.io.File;

import org.openqa.selenium.WebElement;

import com.broada.spring.AutoTest;
import com.broada.spring.K;

public class Test001 {
    
    public static void main(String args[]){
        AutoTest autoTest = new AutoTest();
//        String userdir = System.getProperty("user.dir");
        String pf = ".\\Test\\test01\\百度首页.yaml";
        String inf = ".\\Test\\test01\\百度数据.xlsx";
        File pageFile = new File(pf);
        autoTest.loadData(pageFile, inf);
        autoTest.openUrl();
        autoTest.input("百度输入框", "input001");
//        WebElement we = (WebElement) autoTest.executeJavaScript("var inp = document.getElementById('kw'); return inp;");
//        we.sendKeys("WebElement");
        autoTest.sleep(3000);
//        autoTest.click("百度提交按钮");
        autoTest.sendKeys(K.ENTER);
        autoTest.sleep(7000);
        autoTest.close();
       
    }
}