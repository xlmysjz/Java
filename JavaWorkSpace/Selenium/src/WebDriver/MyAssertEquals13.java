package WebDriver;

import static org.testng.AssertJUnit.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/*
使用 assertEquals 验证是否相等
 */
public class MyAssertEquals13
{


	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\eclipse\\chromedriver.exe");
		WebDriver cdr = new ChromeDriver();
		
		cdr.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		cdr.get("http://www.topka.cn");
		//以下是在登录页面的操作
		
		WebElement ElementLogin = cdr.findElement(By.linkText("登录"));//查找右上角 登录 链接
		ElementLogin.click();
		
		WebElement ElEmail = cdr.findElement(By.id("login_email"));//邮箱输入框查找
		ElEmail.clear();//先清一下邮箱输入框里的内容
		ElEmail.sendKeys("111111@sina.com");//向邮箱输入框输入 111111@sina.com
		
		WebElement ElPWD = cdr.findElement(By.cssSelector("input[id=\"login_password\"]"));//查找密码输入框
		ElPWD.clear();
		ElPWD.sendKeys("123456");
		
		WebElement ElSub = cdr.findElement(By.xpath("//input[@id='login']"));//查找登录按钮
		ElSub.click();//登录
		
		Thread.sleep(3);
		
		cdr.get("http://topka.cn/zuoye/4f8fdd2660e368be460000bf");
		WebElement title = cdr.findElement(By.xpath("//div[@id='main']/div[1]/dl/dd/div/div[1]")); 
		
		System.out.println(title.getText());//输出标题的文字
		assertEquals("英菲尼迪2010款 EX25 尊雅版 车身外观",title.getText());//验证标题是否相等
		// 可以将 英菲尼迪2010款 EX25 尊雅版 车身外观 改为 111 验证一下 就知道结果了
		
		cdr.quit();

	}

}
