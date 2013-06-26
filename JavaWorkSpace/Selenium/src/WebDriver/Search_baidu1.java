package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


/*
打开百度登录页面，输入webdriver进行搜索
 */
public class Search_baidu1
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");// 设置firefox的路径
		WebDriver driver = new FirefoxDriver();//创建firefox浏览器实例
		
		driver.get("http://www.baidu.cn");//打开百度
		WebElement element = driver.findElement(By.id("kw"));//按照id查找  input的Dom，该id可以使用firebug查看（按照name查找可以输入：name("wd")）
		element.sendKeys("webdriver");//向输入框中输入要查找的内容：webdriver
		element.submit();//点击“百度一下”那个按钮
		try
		{
			Thread.sleep(3000);//在搜索的内容页面停留3000毫秒
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		driver.quit();//最后网页退出
		

	}

}
