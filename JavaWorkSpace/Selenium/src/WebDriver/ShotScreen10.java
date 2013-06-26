package WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


/*
本脚本写的是 截图 功能
 */
public class ShotScreen10
{
	private static WebDriver cdr;
	private final static String Url="http://www.topka.cn";
	
	
	public static void InitBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\eclipse\\chromedriver.exe");
		cdr = new ChromeDriver();
		cdr.get(Url);
		
		cdr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//浏览器等待
	}
	
	//这是封装的截图的方法
	public static void takeScreenShot(String name)
	{  
	        File scrFile = ((TakesScreenshot)cdr).getScreenshotAs(OutputType.FILE);  
	        try {  
	                FileUtils.copyFile(scrFile, new File("c:\\Learning\\"+ name+".jpg"));  
	            } catch (IOException e) {  
	        	
	                e.printStackTrace();  
	            }  
	}  
	
	public static void main(String[] args) throws IOException
	{
		InitBrowser();
		
		/*(new WebDriverWait(cdr,10)).until(new ExpectedCondition<WebElement>(){//
			public WebElement apply(WebDriver d)
			{
				return d.findElement(By.linkText("邮箱登录>>"));
			}
		});
		
		File ScreenShotFile=((TakesScreenshot) cdr).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ScreenShotFile, new File("C:\\Users\\Administrator\\Desktop\\Image\\test.png"));
		cdr.quit();*/
		
		
		
		//takeScreenShot("aa");//这是直接调用的那个封装的方法
		
		
		//更严谨一些的方法
		String dir_name="C:\\ScreenShot";//定义截图存放的目录名称
		File f = new File(dir_name);
		if(!(f.isDirectory()))//如果C盘下不存在ScreenShot目录，则新建一个
		{
			f.mkdir();
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss");
		String time = sdf.format(new Date());//格式化当前时间
		
		File ScreenshotImage = ((TakesScreenshot) cdr).getScreenshotAs(OutputType.FILE);//执行屏幕截图
		FileUtils.copyFile(ScreenshotImage, new File(dir_name,time+".png"));
		
		cdr.quit();
		
		
		
	}

}
