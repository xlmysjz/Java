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
 ����ű����Ѻ�������ϴ������ű�������ű��ｫ�ϴ�����imageͼƬ
 ʹ�õ�������� autoit  Ŀ¼X:\JavaWorkSpace\Selenium ����� upload.exe��ʹ��autoit����ɵ� exe��ִ���ļ�
 ��ͼƬ·��Ϊ D:\test\56.jpg
 ����Ĵ���Ϊ��
 
WinWait("[Class:#32770]", "", 5)
WinActivate("[Class:#32770]")
ControlFocus( "[Class:#32770]", "", "[CLASS:Edit; INSTANCE:1]" )         
Send("D:\test\56.jpg") 

ControlClick("[Class:#32770]", "��(O)", "ȡ�� ")
Send("!O")

 */
public class EmailUpload
{

    private static WebDriver fdr;
    private static String URL = "http://mail.sohu.com/";
    
    public void InitBrowser()//��ʼ�������
    {
	System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
	fdr = new FirefoxDriver();
	fdr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	fdr.get(URL);
	fdr.manage().window().maximize();//����������
    }
    
    public void Login()//��¼����
    {
	WebElement userEle = fdr.findElement(By.id("username"));//�û���
	userEle.clear();
	userEle.sendKeys("xlm.-_y");
	
	WebElement passEle = fdr.findElement(By.id("password"));//����
	passEle.clear();
	passEle.sendKeys("123456");
	
	fdr.findElement(By.id("login_img")).click();//��¼����
    }
    
    public void UploadImage()
    {
	fdr.findElement(By.id("write_mail")).click();//���д�ţ����뵽���ʼ���ҳ��
	
	fdr.findElement(By.xpath("//a[contains(@title,'xlmmll@sohu.com')]")).click();//���Ҳ����By.xpath("//a[@title='xlm_y@sohu.com']")
	
	/*
	//�Ѻ������ �ʼ���ַѡ��δ�㶨
	Actions action = new Actions(fdr);
	action.clickAndHold(fdr.findElement(By.xpath("//[@id='filter_address_table']/tbody/tr/td"))).perform();
	action.release(fdr.findElement(By.xpath("//[@id='filter_address_table']/tbody/tr/td"))).perform();
	//action.doubleClick(fdr.findElement(By.xpath("//[@id='filter_address_table']/tbody/tr/td"))).perform();
	
	//fdr.findElement(By.xpath("[@id='filter_address_table']/tbody/tr/td")).click();
	*/
	fdr.findElement(By.id("compose.subject")).sendKeys("�����ҷ��Ĳ����ʼ�");//��������
	
	WebElement writeEmail = fdr.switchTo().frame(fdr.findElement(By.id("htmlEditor"))).findElement(By.xpath("/html/body"));
	writeEmail.sendKeys("�����ʼ�����");
	fdr.switchTo().defaultContent();
	
	//�ϴ���һ��ImageͼƬ
	fdr.findElement(By.id("uploader")).click();//�ҵ��ϴ��������Ǹ�id
	try
	{
	    Runtime.getRuntime().exec("X:\\JavaWorkSpace\\Selenium\\upload.exe");//ʹ��java�������� autoit��exe�ļ�
	    //ע�⣬�����������ʱ�������뷨��ΪĬ��Ӣ������״̬
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
	
	//�ϴ��ڶ���ImageͼƬ
	fdr.findElement(By.id("uploader")).click();//�ҵ��ϴ��������Ǹ�id
	try
	{
	    Runtime.getRuntime().exec("X:\\JavaWorkSpace\\Selenium\\upload1.exe");//ʹ��java�������� autoit��exe�ļ�
	    //ע�⣬�����������ʱ�������뷨��ΪĬ��Ӣ������״̬
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
	
	fdr.findElement(By.xpath("//input[@class='button s_send_mail btn3']")).click();//�����ʼ�
	
    }

}
