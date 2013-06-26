package WebDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateHomeWork3
{
	private static String LoginUrl = "http://topka.cn";//登录链接
	
	public  String getDate()
	{
		Date date = new Date();//创建日期对象
		DateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String NowDate = dateformat.format(date);
		return NowDate;
		
	}

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");// 设置firefox的路径
		WebDriver driver = new FirefoxDriver();//创建firefox浏览器实例
		driver.get(LoginUrl);//打开topka登录页面

		Thread.sleep(3000);//打开http://www.topka.cn页面后，停留3000毫秒

		
		Thread.sleep(3000);//进入登陆页面后，停留3000毫秒
		
		//以下是在登录页面的操作
		
		WebElement ElementLogin = driver.findElement(By.linkText("登录"));//查找右上角 登录 链接
		ElementLogin.click();
		
		WebElement ElEmail = driver.findElement(By.id("login_email"));//邮箱输入框查找
		ElEmail.clear();//先清一下邮箱输入框里的内容
		ElEmail.sendKeys("111111@sina.com");//向邮箱输入框输入 111111@sina.com
		
		WebElement ElPWD = driver.findElement(By.cssSelector("input[id=\"login_password\"]"));//查找密码输入框
		ElPWD.clear();
		ElPWD.sendKeys("123456");
		
		WebElement ElSub = driver.findElement(By.xpath("//input[@id='login']"));//查找登录按钮
		ElSub.click();//登录
		
		Thread.sleep(3000);//登陆平台后，停留3000毫秒

		WebElement elementHW = driver.findElement(By.xpath("//body[@id='J_connect']/div[4]/div/div[2]/div[1]/ul/li[4]/a"));//定位 写作业 那个按钮
		elementHW.click();//点击 写作业那个按钮
		/*
		 点击首页写作业那个图标也遇到了定位不到的问题，By.className，By.cssSelector()方法全部失效，
		 使用xpath也折腾了好一会没有成功，再次询问高人，使用xpath方法终于解决。
		 */
		Thread.sleep(3000);//停留3000毫秒
		
		WebElement HWTitle = driver.findElement(By.xpath("//input[@id='shuo_title']"));//在写作业页面，使用xpath定位作业标题框的Dom
		HWTitle.clear();//先将标题里的内容清一下
		CreateHomeWork3 topkaHW = new CreateHomeWork3();//创建类的对象
		HWTitle.sendKeys("这是自动化脚本生成的标题"+topkaHW.getDate());//输入作业标题名称+时间
		
		WebElement HWContent = driver.findElement(By.xpath("//textarea[@id='shuo_content']"));//在写作业页面，使用xpath定位作业内容框的Dom
		HWContent.clear();//先将内容输入框清一下
		HWContent.sendKeys("这是脚本自动输入的内容");
		
		/*
		 到这里无法定位照片那个flash按钮所以无法上传图片
		 
		 */
		Thread.sleep(10000);//停留3000毫秒
		driver.findElement(By.id("feed_post_btn")).click();
		
		
		
		//页面跳转，如调用了driver.get("http://www.topka.cn")方法，或点击了某个按钮后跳转的新页面，最后调用Thread.sleep()方法以防卡住
		//elementHW = driver.findElement(By.xpath("//body[@id='J_connect']/div[4]/div/div[2]/div[1]/ul/li[4]/a"));

	}

}
