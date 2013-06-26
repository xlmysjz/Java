package WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


/*
 这个脚本表现的是把一个元素条目拖到一个div框中 
 网址是 http://koyoz.com/demo/html/drag-drop/drag-drop.html
  
 */


public class DragAndDrop9
{
	private static String Url = "http://koyoz.com/demo/html/drag-drop/drag-drop.html";
	private static WebDriver cdr;
	
	public static void InitBowser()//初始化chrome浏览器
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\eclipse\\chromedriver.exe");
		cdr = new ChromeDriver();
		cdr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		cdr.get(Url);//打开chrome浏览器
	}
	
	
	public static void main(String[] args)
	{
		
		InitBowser();
		//首先new出要拖入的页面元素对象和目标对象，然后进行拖入
		//WebElement element = cdr.findElement(By.id("item1"));//这是要拖入的那个元素
		WebElement target = cdr.findElement(By.id("drop"));//这是要拖入到的div那个框
		
		Actions action = new Actions(cdr);//建立一个鼠标对象
		//利用循环将item拖入到div那个框里
		
		String Id = "item";
		for(int i = 1;i <= 6;i++)
		{
			String item = Id+i;
			(action.dragAndDrop(cdr.findElement(By.id(item)), target)).perform();
		}//38

		
	}

}
