package WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


/*
���ͼ��̲���
 */
public class MouseAndKeybroard_Actions11
{
	private static WebDriver fdr;
	private static String Url = "http://www.baidu.com";
	
	public static void InitBrowser()
	{
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");// ����firefox��·��
		fdr = new FirefoxDriver();
		fdr.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//�������Եȴ�
	}
	
	public static void main(String[] args)
	{
		InitBrowser();
		fdr.get(Url);
		
		Actions action = new Actions(fdr);//��������¼�
		WebElement element = fdr.findElement(By.cssSelector("input[id=\"kw\"]"));//�ҵ��ٶȵ��Ǹ�������
		WebElement element1 = fdr.findElement(By.cssSelector("input[class=\"s_btn\"]"));//�ҵ��ٶȵ��Ǹ� �ٶ�һ�� �İ�ť
		action.sendKeys(element, "selenium").perform();//����������������Ϣ
		action.moveToElement(element1);//����ƶ��� �ٶ�һ�� �Ǹ���ť��
		action.click().perform();//��� �ٶ�һ�� �Ǹ���ť
		fdr.quit();
		//43
		
		
	}

}
