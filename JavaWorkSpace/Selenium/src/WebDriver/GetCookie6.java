package WebDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 //��Ҫ����ҳ��������һ��cookie��Ȼ�����ҳ�������cookies�����������ǵ�ע�����ԡ�����������ɾ��cookie�ķ���
 */
public class GetCookie6
{
	private static WebDriver ChromeDriver;
	private static String Url = "http://www.51.com";
	
	public static void InitBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\eclipse\\chromedriver.exe");//����chrome���������chromedriver�����exe�ļ�Ҫ��������
		ChromeDriver = new ChromeDriver();//����chrome�����ʵ��
		ChromeDriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);//�������ʱ�ȴ�,�ȴ�ָ����WebElement�������
		
		ChromeDriver.get(Url);

	}
	
	public static void main(String[] args) throws Exception
	{
		InitBrowser();
		
		//������cookie�Ĳ���
		Cookie cookie = new Cookie("name","value");//����һ��name = "name",value = "value"��cookie
		ChromeDriver.manage().addCookie(cookie);
		
		
		
		//�õ���ǰҳ�������е�cookie������������ǵ�������name��value����Ч���ں�·��
		Set<Cookie>cookies = ChromeDriver.manage().getCookies();
		System.out.println(String.format("Domain->name->value->expiry->path"));
		for(Cookie c:cookies)
		{
			System.out.println(String.format("%s->%s->%s->%s->%s",c.getDomain(),c.getName(),c.getValue(),c.getExpiry(),c.getPath()));
			
		}
		
		//ɾ��cookie
		ChromeDriver.manage().deleteCookieNamed("CookieName");//��һ��ͨ��cookie��name
		ChromeDriver.manage().deleteCookie(cookie);//�ڶ���ͨ��Cookie����
		ChromeDriver.manage().deleteAllCookies();//������ȫ��ɾ��
		
		
		ChromeDriver.close();
		
		
		

	}

}
