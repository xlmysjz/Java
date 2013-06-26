package WebDriver;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PersonalSetup5
{
	private static WebDriver ChromeDriver;
	private static String Url = "http://topka.cn";
	
	public static void InitBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\eclipse\\chromedriver.exe");//����chrome���������chromedriver�����exe�ļ�Ҫ��������
		ChromeDriver = new ChromeDriver();//����chrome�����ʵ��
		ChromeDriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);//�������ʱ�ȴ�,�ȴ�ָ����WebElement�������
		
		ChromeDriver.get(Url);

	}
	public static WebElement WaitLoad(final WebElement element)//��װ�����غ�ҳ����� 
	{
		WebDriverWait wait = new WebDriverWait(ChromeDriver,20);
		return wait.until(new ExpectedCondition<WebElement>()
				{
					//@verride
					public WebElement apply(WebDriver d)
					{
						return element;
					}
				});
	}
	/*
	// ͬ�ϣ�����ֱ���ڷ�����д��
	 WebDriverWait wait = new WebDriverWait(dr,10);
	        wait.until(new ExpectedCondition<WebElement>(){
	        @Override
	            public WebElement apply(WebDriver d) {
	                return d.findElement(By.className("red_box"));
	    }
	        });
	*/

	public static void main(String[] args) throws Exception
	{
		InitBrowser();
		Thread.sleep(3000);//����ע�͵�
		WaitLoad(ChromeDriver.findElement(By.linkText("��¼"))).click();//���ܵȴ�ҳ��Ԫ�ؼ������
		//ChromeDriver.findElement(By.linkText("�����¼>>")).click();
		
		WebElement ElementLogin = ChromeDriver.findElement(By.linkText("��¼"));//�������Ͻ� ��¼ ����
		ElementLogin.click();
		
		WebElement ElEmail = ChromeDriver.findElement(By.id("login_email"));//������������
		ElEmail.clear();//����һ������������������
		ElEmail.sendKeys("111111@sina.com");//��������������� 111111@sina.com
		
		
		/*
		WebElement eLogin = ChromeDriver.findElement(By.className("reg_pr90"));//�õ����������� label
		List<WebElement> el = eLogin.findElements(By.tagName("label"));
		for(WebElement c:el)
		{
			System.out.println(c.getText());
		}
		*/
		WebElement ElPWD = ChromeDriver.findElement(By.cssSelector("input[id=\"login_password\"]"));//�������������
		ElPWD.clear();
		ElPWD.sendKeys("123456");
		
		//�����¼��ť
		WebElement ElSub = ChromeDriver.findElement(By.xpath("//input[@id='login']"));//���ҵ�¼��ť
		ElSub.click();//��¼
		Thread.sleep(3000);//��½ƽ̨��ͣ��3000����
		
		/*
		List<WebElement> element = ChromeDriver.findElements(By.tagName("input"));//��ӡinput���id����
		for(WebElement e:element)
		{
			System.out.println(e.getAttribute("id"));
		}*/
		Actions action = new Actions(ChromeDriver);
		action.moveToElement(ChromeDriver.findElement(By.xpath("//div[@class='fr ml_15 pos_pare mod_userbox J_user_menu']"))).perform();//�ƶ������Ͻ���ʾ�����˵�

		ChromeDriver.findElement(By.linkText("��������")).click();//�����������
		
		WaitLoad(ChromeDriver.findElement(By.linkText("������Ϣ")));//���ܵȴ� ��������-������Ϣ �ı�ǩ��ʾ
		
		//�����������˵���ѡ��
		Select select = new Select(ChromeDriver.findElement(By.id("areaid_province")));
		select.selectByValue("120000");//ѡ�����
		
		Select selectArea = new Select(ChromeDriver.findElement(By.id("areaid_city")));
		selectArea.selectByValue("120107");//ѡ�����������
		
		ChromeDriver.findElement(By.id("modify_user_submit")).click();//����
		Thread.sleep(3000);//����3��
		
		ChromeDriver.quit();//ֱ�ӹر�chrome�����
		//21
	}

}