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
        String pf = ".\\Test\\test01\\�ٶ���ҳ.yaml";
        String inf = ".\\Test\\test01\\�ٶ�����.xlsx";
        File pageFile = new File(pf);
        autoTest.loadData(pageFile, inf);
        autoTest.openUrl();
        autoTest.input("�ٶ������", "input001");
//        WebElement we = (WebElement) autoTest.executeJavaScript("var inp = document.getElementById('kw'); return inp;");
//        we.sendKeys("WebElement");
        autoTest.sleep(3000);
//        autoTest.click("�ٶ��ύ��ť");
        autoTest.sendKeys(K.ENTER);
        autoTest.sleep(7000);
        autoTest.close();
       
    }
}