package WebDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 //主要是在页面中增加一个cookie，然后遍历页面的所有cookies，并输入他们的注意属性。最后就是三张删除cookie的方法
 */
public class GetCookie6
{
	private static WebDriver ChromeDriver;
	private static String Url = "http://www.51.com";
	
	public static void InitBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\eclipse\\chromedriver.exe");//设置chrome浏览器驱动chromedriver，这个exe文件要单独下载
		ChromeDriver = new ChromeDriver();//创建chrome浏览器实例
		ChromeDriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);//浏览器超时等待,等待指定的WebElement加载完毕
		
		ChromeDriver.get(Url);

	}
	
	public static void main(String[] args) throws Exception
	{
		InitBrowser();
		
		//以下是cookie的操作
		Cookie cookie = new Cookie("name","value");//增加一个name = "name",value = "value"的cookie
		ChromeDriver.manage().addCookie(cookie);
		
		
		
		//得到当前页面下所有的cookie，并且输出它们的所在域、name、value、有效日期和路径
		Set<Cookie>cookies = ChromeDriver.manage().getCookies();
		System.out.println(String.format("Domain->name->value->expiry->path"));
		for(Cookie c:cookies)
		{
			System.out.println(String.format("%s->%s->%s->%s->%s",c.getDomain(),c.getName(),c.getValue(),c.getExpiry(),c.getPath()));
			
		}
		
		//删除cookie
		ChromeDriver.manage().deleteCookieNamed("CookieName");//第一种通过cookie的name
		ChromeDriver.manage().deleteCookie(cookie);//第二种通过Cookie对象
		ChromeDriver.manage().deleteAllCookies();//第三种全部删除
		
		
		ChromeDriver.close();
		
		
		

	}

}
