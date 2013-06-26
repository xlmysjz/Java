package webdriverupload;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
/*
By.xpath("//a[contains(@title,'xlmmll@sohu.com')]") 
 这个脚本是搜狐邮箱的上传附件脚本，这个脚本里将上传两个image图片
 使用第三方软件 autoit  目录X:\JavaWorkSpace\Selenium 下面的 upload.exe是使用autoit编译成的 exe可执行文件
 在图片路径为 D:\test\56.jpg
 里面的代码为：
 
WinWait("[Class:#32770]", "", 5)
WinActivate("[Class:#32770]")
ControlFocus( "[Class:#32770]", "", "[CLASS:Edit; INSTANCE:1]" )         
Send("D:\test\56.jpg") 

ControlClick("[Class:#32770]", "打开(O)", "取消 ")
Send("!O")

 */
public class EmailUpload
{

    private static WebDriver fdr;
    private static String URL = "http://mail.sohu.com/";
    
    public void InitBrowser()//初始化浏览器
    {
	System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
	fdr = new FirefoxDriver();
	fdr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	fdr.get(URL);
	fdr.manage().window().maximize();//是浏览器最大化
    }
    
    public void Login()//登录邮箱
    {
	WebElement userEle = fdr.findElement(By.id("username"));//用户名
	userEle.clear();
	userEle.sendKeys("xlm.-_y");
	
	WebElement passEle = fdr.findElement(By.id("password"));//密码
	passEle.clear();
	passEle.sendKeys("123456");
	
	fdr.findElement(By.id("login_img")).click();//登录邮箱
    }
    
    public void UploadImage()
    {
	fdr.findElement(By.id("write_mail")).click();//点击写信，进入到发邮件的页面
	
	fdr.findElement(By.xpath("//a[contains(@title,'xlmmll@sohu.com')]")).click();//这个也可以By.xpath("//a[@title='xlm_y@sohu.com']")
	
	/*
	//搜狐邮箱的 邮件地址选择还未搞定
	Actions action = new Actions(fdr);
	action.clickAndHold(fdr.findElement(By.xpath("//[@id='filter_address_table']/tbody/tr/td"))).perform();
	action.release(fdr.findElement(By.xpath("//[@id='filter_address_table']/tbody/tr/td"))).perform();
	//action.doubleClick(fdr.findElement(By.xpath("//[@id='filter_address_table']/tbody/tr/td"))).perform();
	
	//fdr.findElement(By.xpath("[@id='filter_address_table']/tbody/tr/td")).click();
	*/
	fdr.findElement(By.id("compose.subject")).sendKeys("这是我发的测试邮件");//输入主题
	
	WebElement writeEmail = fdr.switchTo().frame(fdr.findElement(By.id("htmlEditor"))).findElement(By.xpath("/html/body"));
	writeEmail.sendKeys("这是邮件内容");
	fdr.switchTo().defaultContent();
	
	//上传第一张Image图片
	fdr.findElement(By.id("uploader")).click();//找到上传附件的那个id
	try
	{
	    Runtime.getRuntime().exec("X:\\JavaWorkSpace\\Selenium\\upload.exe");//使用java方法调用 autoit的exe文件
	    //注意，进行这个操作时，将输入法改为默认英文输入状态
	} catch (IOException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	try
	{
	    Thread.sleep(5000);
	} catch (InterruptedException e1)
	{
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}
	
	//上传第二张Image图片
	fdr.findElement(By.id("uploader")).click();//找到上传附件的那个id
	try
	{
	    Runtime.getRuntime().exec("X:\\JavaWorkSpace\\Selenium\\upload1.exe");//使用java方法调用 autoit的exe文件
	    //注意，进行这个操作时，将输入法改为默认英文输入状态
	} catch (IOException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	try
	{
	    Thread.sleep(5000);
	} catch (InterruptedException e1)
	{
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}
	
	fdr.findElement(By.xpath("//input[@class='button s_send_mail btn3']")).click();//发送邮件
	
    }

}
