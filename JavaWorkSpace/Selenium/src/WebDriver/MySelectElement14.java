package WebDriver;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
从下拉框里选择元素 select

登陆hao123的账号：opentesting@163.com 
密码：opentest


//下面这三句是 浏览器回退
final JavascriptExecutor js = (JavascriptExecutor)cdr;
js.executeScript("history.back();");//浏览器回退，就是点击浏览器上的 回退那个后退
//这是对回退的封装 用时只要写成 backBrowser(cdr)就行了
public static void backBrowser(WebDriver driver)
	{
		final JavascriptExecutor js = (JavascriptExecutor)driver;
		s.executeScript("history.back();");
	} 
 */
public class MySelectElement14
{

	private static WebDriver cdr;
	private static String Url = "http://www.hao123.com";

	public static  void InitBrowser()
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\eclipse\\chromedriver.exe");
		//cdr = new ChromeDriver();
		
		System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");
		cdr = new FirefoxDriver();
		cdr.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		cdr.get(Url);
	}
	
	public static void LoginHao123() throws Exception//hao123右上角登录
	{
	    	
		cdr.findElement(By.linkText("登录")).click();//点击登录按钮
		
		
		//输入用户名和密码
		cdr.findElement(By.xpath("//input[@id='pass_login_username_0']")).clear();
		cdr.findElement(By.xpath("//input[@id='pass_login_username_0']")).sendKeys("opentesting@163.com");//输入用户名
		
		cdr.findElement(By.id("pass_login_password_0")).clear();//清空密码输入框
		cdr.findElement(By.id("pass_login_password_0")).sendKeys("opentest");//输入密码
		
		//点击登录按钮
		
		WebElement checkbox = cdr.findElement(By.id("pass_login_rem_0"));
		checkbox.click();//这两行是我加了一步，去掉了“记住我的登录状态”的勾选
		if(checkbox.isEnabled())//验证是否 去掉了勾选
		{
			System.out.println("记住我的登录状态 这个勾选已被去除");
		}
		else
		{
			System.out.println("这个勾选还未去除");
		}
		Thread.sleep(1000);
		cdr.findElement(By.xpath("//input[@id='pass_login_input_submit_0']")).click();//点击登录按钮
	}
	
	public static void LoginEmail(String username,String Pwd) throws Exception//登录tom邮箱
	{
		
		//输入邮箱 用户名 和 密码
		WebElement mailUserName = cdr.findElement(By.id("mailUserName"));
		mailUserName.clear();
		mailUserName.sendKeys(username);//输入邮箱 用户名
		Thread.sleep(1000);
		
		cdr.findElement(By.xpath("//label[@class='js_selectLabel g_icon mailselect']")).click();//点击邮箱选择框
		cdr.findElement(By.xpath("//ul/li[text()='@sohu.com']")).click();//选择sohu邮箱 
		
		WebElement mailPWD = cdr.findElement(By.id("mailPassWord"));
		mailPWD.clear();
		mailPWD.sendKeys(Pwd);//输入邮箱密码
		
		cdr.findElement(By.id("mailsubmit")).click();
		
		
	}
	
	public static void CheckEmailLogin() throws Exception//验证邮箱是否登录成功
	{
		
		//以下两种方法都可以
		/*String currWin = cdr.getWindowHandle();//得到一开始的handle，也就是hao123的handle
		System.out.println("当前title是："+cdr.getTitle());//打印 hao123的title
		
		Set<String> handles = cdr.getWindowHandles();//得到全部的 handle
		Iterator<String> it = handles.iterator();//迭代每一个 handle
		while(it.hasNext())
		{
			if(it.next()==currWin)
			{
				continue;
			}
			
			cdr.switchTo().window(it.next());//切换到邮件那个句柄窗口
		}
		
		WebElement emailName = cdr.findElement(By.xpath("//div[@id='nav_left']/b"));
		System.out.println(emailName.getText());//打印登录后的用户名
		assertEquals("xlm.-_y@sohu.com",emailName.getText());//验证输入的邮箱名和登录后的用户名是否一致
		
		Thread.sleep(3000);
		cdr.findElement(By.linkText("退出")).click();//退出邮箱
		
		cdr.close();//邮箱页面的网页关闭
		
		cdr.switchTo().window(currWin);
		cdr.quit();*/
		
	    
		
		
		Set<String> handlers = cdr.getWindowHandles();//得到全部窗口句柄
		String currHandler = cdr.getWindowHandle();//一开始的hao123的句柄
		for(String mailHandler:handlers)
		{
			if(currHandler.equals(mailHandler))//如果还是hao123的句柄就继续循环，只到找到邮件的句柄
			{
				continue;
			}
			cdr.switchTo().window(mailHandler);//切换至email句柄页面
			System.out.println("切换到email邮件handle后的title是："+cdr.getTitle());
		}
		
		WebElement emailName = cdr.findElement(By.xpath("//div[@id='nav_left']/b"));
		System.out.println(emailName.getText());//打印登录后的用户名
		assertEquals("xlm.-_y@sohu.com",emailName.getText());//验证输入的邮箱名和登录后的用户名是否一致
		assertEquals("闪电邮 - 搜狐",cdr.getTitle());//验证title  与上面的那个 有一个验证就可以了
		
		
		
		
		Thread.sleep(3000);
		cdr.findElement(By.linkText("退出")).click();//退出邮箱
		
		/*
		//定位到所有<input>标签的元素，然后输出他们的id
		List<WebElement> ele = cdr.findElements(By.tagName("input"));
		for(WebElement e:ele)
		{
		    System.out.println(e.getAttribute("id"));
		}*/
		
		
		
		
		//下面这三句是 浏览器回退，用不到可以注释掉
		Thread.sleep(1000);
		final JavascriptExecutor js = (JavascriptExecutor)cdr;
        js.executeScript("history.back();");//浏览器回退，就是点击浏览器上的 回退那个后退
        /*//这是对回退的封装 用时只要写成 backBrowser(cdr)就行了
          public static void backBrowser(WebDriver driver)
          {
          	final JavascriptExecutor js = (JavascriptExecutor)driver;
            s.executeScript("history.back();");
        } 
         */
		
        Thread.sleep(3000);
		cdr.close();//邮箱页面的网页关闭
		
		
		cdr.switchTo().window(currHandler);
		System.out.println("切换到hao123网页的handle后,title是："+cdr.getTitle());
		cdr.quit();//hao123网页关闭
	}
	public static void main(String[] args) throws Exception
	{
		InitBrowser();
		//LoginHao123();
		
		LoginEmail("xlm.-_y","123456");
		CheckEmailLogin();

	}

}
