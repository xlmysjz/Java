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
就是设置一个元素的焦点，如在百度首页 图片处右键 
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
	 //查找你需要设置焦点的元素
	 WebElement button = driver.findElement(By.xpath("//*[@id='nv']/a[5]"));
	 //对该元素进行右击操作
	 action.contextClick(button).perform();
	 //按ESC键返回，设置焦点成功
	 robot.keyPress(KeyEvent.VK_ESCAPE);//把这句话注释掉 就可以看到在焦点处的右键操作了
     }
    
    public static void main(String[] args)
    {
	setUp();
	start();

    }

}
