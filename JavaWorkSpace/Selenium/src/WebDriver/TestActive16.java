package WebDriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
/*
��������һ��Ԫ�صĽ��㣬���ڰٶ���ҳ ͼƬ���Ҽ� 
 */

public class TestActive16
{
     private static WebDriver driver = null;
     private static Actions action = null;
     private static Robot robot = null;

     //@BeforeMethod
     public static void setUp()
     {
	 try {
	     	robot = new Robot();
	     }
	 catch (AWTException e)
	 {
	     e.printStackTrace();
	 }

	 System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
	 FirefoxProfile file = new FirefoxProfile();
	 DesiredCapabilities ds = DesiredCapabilities.firefox();
	 ds.setCapability(FirefoxDriver.PROFILE, file);
	 driver = new FirefoxDriver(ds);
	 action = new Actions(driver);
     }
     //@AfterMethod
     public static void tearDown()
     {
     }

     //@Test
     public static void start()
     {
	 driver.get("http://www.baidu.com");
	 driver.manage().window().maximize();
	 //��������Ҫ���ý����Ԫ��
	 WebElement button = driver.findElement(By.xpath("//*[@id='nv']/a[5]"));
	 //�Ը�Ԫ�ؽ����һ�����
	 action.contextClick(button).perform();
	 //��ESC�����أ����ý���ɹ�
	 robot.keyPress(KeyEvent.VK_ESCAPE);//����仰ע�͵� �Ϳ��Կ����ڽ��㴦���Ҽ�������
     }
    
    public static void main(String[] args)
    {
	setUp();
	start();

    }

}
