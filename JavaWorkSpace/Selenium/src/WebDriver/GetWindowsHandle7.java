package WebDriver;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1.如果点击一个链接，就会在新页面打开链接， 这段代码表示的就是如何得到打开的那个新页面
2. html编写的脚本是：
<html>
	<head>
		<title>Test PopUp Windows</title>
	</head>
	<body>
		<a id="baidu" href="http://www.baidu.com/" target="_blank">点击后新页面打开百度窗口</a>
	</body>
</html>
该脚本在快盘 X:/JavaWorkSpace/Selenium/TestPopUp.html 已存在

 */
public class GetWindowsHandle7
{

	
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\eclipse\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		String Url = "X:/JavaWorkSpace/Selenium/TestPopUp.html";//html代码存放的路径
		chromeDriver.get(Url);
		
		chromeDriver.findElement(By.id("baidu")).click();//点击页面里的链接就会在新页面打开一个网页
		//得到当前窗口的句柄
		String currentWindow = chromeDriver.getWindowHandle();
		System.out.println("原始网页title为："+chromeDriver.getTitle());//打印当前窗口的 title
		
		//得到当前所有窗口的句柄
		Set<String>handls = chromeDriver.getWindowHandles();
		Iterator<String> it = handls.iterator();
		while(it.hasNext())
		{
			/*
			Iterator是Java迭代器最简单的实现 ，
			next()获得序列中的下一个元素，第一次调用时返回集合的第一个元素，依次向后，
			hasNext()是检查集合中是否还有元素，一般用在while循环的判断语句中，有的话返回true，没有返回false。
			 */
			if(currentWindow == it.next())//第一次调用 next（），返回的还是原窗口title，所以continue 下一个title的获取,如果把这个if注释掉，将打印所有页面的title
			{
				continue;
			}
			
			WebDriver window = chromeDriver.switchTo().window(it.next());//切换到新的窗口
			System.out.println("当前title为："+window.getTitle()+",当前Url为："+window.getCurrentUrl());
			
		}
		chromeDriver.findElement(By.id("kw")).sendKeys("切换到新窗口后的输入");//查看一下在新窗口能否输入内容
		
		/*
		1.selenium webdriver.pdf作者添加： 捕获或者说定位弹出窗口的关键在于获得弹出窗口的句柄。（句柄，我的理解是浏览器窗口的一个唯一标识，
		记得以前玩"按键精灵"也有这玩样。
		
		2.如果想回到以前的窗口定位元素，那么再调用1次switch_to.window方法，传入之前窗口的句柄(currentWindow)既可达到目
	的。
		 */

	}


}
