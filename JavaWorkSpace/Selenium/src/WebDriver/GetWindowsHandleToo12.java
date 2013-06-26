package WebDriver;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
主要是 handle 的切换 跟该包下类里的 GetWindowsHandle7 一样，只不过总结了一下该handle的方法

//第一张方法
Set<String> handlers = driver.getWindowHandles();//得到全部窗口的句柄
String crrHandle = driver.getWindowHandle();//得到当前的窗口句柄
for(String h:handlers)
	{
		if(crrHandle.equals(h))
		{
			continue;
		}
	WebDriver win = driver.switchTo().window(h);
	System.out.println("网页title名称为："+win.getTitle()+"\n网页URL为："+win.getCurrentUrl());
	}
	driver.findElement(By.id("kw")).sendKeys("切换到新窗口后的输入");

-------------------------------
第二种方法
//得到当前窗口的句柄
String currentWindow = chromeDriver.getWindowHandle();
System.out.println("原始网页title为："+chromeDriver.getTitle());//打印当前窗口的 title
		
//得到当前所有窗口的句柄
Set<String>handls = chromeDriver.getWindowHandles();
Iterator<String> it = handls.iterator();
while(it.hasNext())
{
	Iterator是Java迭代器最简单的实现 ，
	next()获得序列中的下一个元素，第一次调用时返回集合的第一个元素，依次向后，
	hasNext()是检查集合中是否还有元素，一般用在while循环的判断语句中，有的话返回true，没有返回false。

	if(currentWindow == it.next())//第一次调用 next（），返回的还是原窗口title，所以continue 下一个title的获取,如果把这个if注释掉，将打印所有页面的title
	{
		continue;
	}
			
	WebDriver window = chromeDriver.switchTo().window(it.next());//切换到新的窗口
	System.out.println("当前title为："+window.getTitle()+",当前Url为："+window.getCurrentUrl());
			
}
 */

public class GetWindowsHandleToo12
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");// 设置firefox的路径
		WebDriver driver = new FirefoxDriver();

		String Url = "X:\\JavaWorkSpace\\Selenium\\TestPopUp.html";//html代码存放的路径
		driver.get(Url);
		driver.findElement(By.id("baidu")).click();
		
		Set<String> handlers = driver.getWindowHandles();//得到全部窗口的句柄
		String crrHandle = driver.getWindowHandle();//得到当前的窗口句柄
		for(String h:handlers)
		{
			if(crrHandle.equals(h))
			{
				continue;
			}
			/*else
			{
				crrHandle = h;
			}*/
			WebDriver win = driver.switchTo().window(h);
			System.out.println("网页title名称为："+win.getTitle()+"\n网页URL为："+win.getCurrentUrl());
		}
		driver.findElement(By.id("kw")).sendKeys("切换到新窗口后的输入");

	}

}
