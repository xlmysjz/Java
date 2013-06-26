package WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


/*
鼠标和键盘操作
 */
public class MouseAndKeybroard_Actions11
{
	private static WebDriver fdr;
	private static String Url = "http://www.baidu.com";
	
	public static void InitBrowser()
	{
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");// 设置firefox的路径
		fdr = new FirefoxDriver();
		fdr.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//设置隐性等待
	}
	
	public static void main(String[] args)
	{
		InitBrowser();
		fdr.get(Url);
		
		Actions action = new Actions(fdr);//建立鼠标事件
		WebElement element = fdr.findElement(By.cssSelector("input[id=\"kw\"]"));//找到百度的那个搜索框
		WebElement element1 = fdr.findElement(By.cssSelector("input[class=\"s_btn\"]"));//找到百度的那个 百度一下 的按钮
		action.sendKeys(element, "selenium").perform();//想搜索框里输入信息
		action.moveToElement(element1);//鼠标移动到 百度一下 那个按钮上
		action.click().perform();//点击 百度一下 那个按钮
		fdr.quit();
		//43
		
		
	}

}
