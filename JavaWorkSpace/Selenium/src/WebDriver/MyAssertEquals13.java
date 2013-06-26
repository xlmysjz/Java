package WebDriver;

import static org.testng.AssertJUnit.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/*
ʹ�� assertEquals ��֤�Ƿ����
 */
public class MyAssertEquals13
{


	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\eclipse\\chromedriver.exe");
		WebDriver cdr = new ChromeDriver();
		
		cdr.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		cdr.get("http://www.topka.cn");
		//�������ڵ�¼ҳ��Ĳ���
		
		WebElement ElementLogin = cdr.findElement(By.linkText("��¼"));//�������Ͻ� ��¼ ����
		ElementLogin.click();
		
		WebElement ElEmail = cdr.findElement(By.id("login_email"));//������������
		ElEmail.clear();//����һ������������������
		ElEmail.sendKeys("111111@sina.com");//��������������� 111111@sina.com
		
		WebElement ElPWD = cdr.findElement(By.cssSelector("input[id=\"login_password\"]"));//�������������
		ElPWD.clear();
		ElPWD.sendKeys("123456");
		
		WebElement ElSub = cdr.findElement(By.xpath("//input[@id='login']"));//���ҵ�¼��ť
		ElSub.click();//��¼
		
		Thread.sleep(3);
		
		cdr.get("http://topka.cn/zuoye/4f8fdd2660e368be460000bf");
		WebElement title = cdr.findElement(By.xpath("//div[@id='main']/div[1]/dl/dd/div/div[1]")); 
		
		System.out.println(title.getText());//������������
		assertEquals("Ӣ�����2010�� EX25 ���Ű� �������",title.getText());//��֤�����Ƿ����
		// ���Խ� Ӣ�����2010�� EX25 ���Ű� ������� ��Ϊ 111 ��֤һ�� ��֪�������
		
		cdr.quit();

	}

}
