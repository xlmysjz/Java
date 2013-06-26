package WebDriver;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
����������ѡ��Ԫ�� select

��½hao123���˺ţ�opentesting@163.com 
���룺opentest


//������������ ���������
final JavascriptExecutor js = (JavascriptExecutor)cdr;
js.executeScript("history.back();");//��������ˣ����ǵ��������ϵ� �����Ǹ�����
//���ǶԻ��˵ķ�װ ��ʱֻҪд�� backBrowser(cdr)������
public static void backBrowser(WebDriver driver)
	{
		final JavascriptExecutor js = (JavascriptExecutor)driver;
		s.executeScript("history.back();");
	} 
 */
public class MySelectElement14
{

	private static WebDriver cdr;
	private static String Url = "http://www.hao123.com";

	public static  void InitBrowser()
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\eclipse\\chromedriver.exe");
		//cdr = new ChromeDriver();
		
		System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");
		cdr = new FirefoxDriver();
		cdr.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		cdr.get(Url);
	}
	
	public static void LoginHao123() throws Exception//hao123���Ͻǵ�¼
	{
	    	
		cdr.findElement(By.linkText("��¼")).click();//�����¼��ť
		
		
		//�����û���������
		cdr.findElement(By.xpath("//input[@id='pass_login_username_0']")).clear();
		cdr.findElement(By.xpath("//input[@id='pass_login_username_0']")).sendKeys("opentesting@163.com");//�����û���
		
		cdr.findElement(By.id("pass_login_password_0")).clear();//������������
		cdr.findElement(By.id("pass_login_password_0")).sendKeys("opentest");//��������
		
		//�����¼��ť
		
		WebElement checkbox = cdr.findElement(By.id("pass_login_rem_0"));
		checkbox.click();//���������Ҽ���һ����ȥ���ˡ���ס�ҵĵ�¼״̬���Ĺ�ѡ
		if(checkbox.isEnabled())//��֤�Ƿ� ȥ���˹�ѡ
		{
			System.out.println("��ס�ҵĵ�¼״̬ �����ѡ�ѱ�ȥ��");
		}
		else
		{
			System.out.println("�����ѡ��δȥ��");
		}
		Thread.sleep(1000);
		cdr.findElement(By.xpath("//input[@id='pass_login_input_submit_0']")).click();//�����¼��ť
	}
	
	public static void LoginEmail(String username,String Pwd) throws Exception//��¼tom����
	{
		
		//�������� �û��� �� ����
		WebElement mailUserName = cdr.findElement(By.id("mailUserName"));
		mailUserName.clear();
		mailUserName.sendKeys(username);//�������� �û���
		Thread.sleep(1000);
		
		cdr.findElement(By.xpath("//label[@class='js_selectLabel g_icon mailselect']")).click();//�������ѡ���
		cdr.findElement(By.xpath("//ul/li[text()='@sohu.com']")).click();//ѡ��sohu���� 
		
		WebElement mailPWD = cdr.findElement(By.id("mailPassWord"));
		mailPWD.clear();
		mailPWD.sendKeys(Pwd);//������������
		
		cdr.findElement(By.id("mailsubmit")).click();
		
		
	}
	
	public static void CheckEmailLogin() throws Exception//��֤�����Ƿ��¼�ɹ�
	{
		
		//�������ַ���������
		/*String currWin = cdr.getWindowHandle();//�õ�һ��ʼ��handle��Ҳ����hao123��handle
		System.out.println("��ǰtitle�ǣ�"+cdr.getTitle());//��ӡ hao123��title
		
		Set<String> handles = cdr.getWindowHandles();//�õ�ȫ���� handle
		Iterator<String> it = handles.iterator();//����ÿһ�� handle
		while(it.hasNext())
		{
			if(it.next()==currWin)
			{
				continue;
			}
			
			cdr.switchTo().window(it.next());//�л����ʼ��Ǹ��������
		}
		
		WebElement emailName = cdr.findElement(By.xpath("//div[@id='nav_left']/b"));
		System.out.println(emailName.getText());//��ӡ��¼����û���
		assertEquals("xlm.-_y@sohu.com",emailName.getText());//��֤������������͵�¼����û����Ƿ�һ��
		
		Thread.sleep(3000);
		cdr.findElement(By.linkText("�˳�")).click();//�˳�����
		
		cdr.close();//����ҳ�����ҳ�ر�
		
		cdr.switchTo().window(currWin);
		cdr.quit();*/
		
	    
		
		
		Set<String> handlers = cdr.getWindowHandles();//�õ�ȫ�����ھ��
		String currHandler = cdr.getWindowHandle();//һ��ʼ��hao123�ľ��
		for(String mailHandler:handlers)
		{
			if(currHandler.equals(mailHandler))//�������hao123�ľ���ͼ���ѭ����ֻ���ҵ��ʼ��ľ��
			{
				continue;
			}
			cdr.switchTo().window(mailHandler);//�л���email���ҳ��
			System.out.println("�л���email�ʼ�handle���title�ǣ�"+cdr.getTitle());
		}
		
		WebElement emailName = cdr.findElement(By.xpath("//div[@id='nav_left']/b"));
		System.out.println(emailName.getText());//��ӡ��¼����û���
		assertEquals("xlm.-_y@sohu.com",emailName.getText());//��֤������������͵�¼����û����Ƿ�һ��
		assertEquals("������ - �Ѻ�",cdr.getTitle());//��֤title  ��������Ǹ� ��һ����֤�Ϳ�����
		
		
		
		
		Thread.sleep(3000);
		cdr.findElement(By.linkText("�˳�")).click();//�˳�����
		
		/*
		//��λ������<input>��ǩ��Ԫ�أ�Ȼ��������ǵ�id
		List<WebElement> ele = cdr.findElements(By.tagName("input"));
		for(WebElement e:ele)
		{
		    System.out.println(e.getAttribute("id"));
		}*/
		
		
		
		
		//������������ ��������ˣ��ò�������ע�͵�
		Thread.sleep(1000);
		final JavascriptExecutor js = (JavascriptExecutor)cdr;
        js.executeScript("history.back();");//��������ˣ����ǵ��������ϵ� �����Ǹ�����
        /*//���ǶԻ��˵ķ�װ ��ʱֻҪд�� backBrowser(cdr)������
          public static void backBrowser(WebDriver driver)
          {
          	final JavascriptExecutor js = (JavascriptExecutor)driver;
            s.executeScript("history.back();");
        } 
         */
		
        Thread.sleep(3000);
		cdr.close();//����ҳ�����ҳ�ر�
		
		
		cdr.switchTo().window(currHandler);
		System.out.println("�л���hao123��ҳ��handle��,title�ǣ�"+cdr.getTitle());
		cdr.quit();//hao123��ҳ�ر�
	}
	public static void main(String[] args) throws Exception
	{
		InitBrowser();
		//LoginHao123();
		
		LoginEmail("xlm.-_y","123456");
		CheckEmailLogin();

	}

}
