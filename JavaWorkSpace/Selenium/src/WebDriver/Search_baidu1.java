package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


/*
�򿪰ٶȵ�¼ҳ�棬����webdriver��������
 */
public class Search_baidu1
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");// ����firefox��·��
		WebDriver driver = new FirefoxDriver();//����firefox�����ʵ��
		
		driver.get("http://www.baidu.cn");//�򿪰ٶ�
		WebElement element = driver.findElement(By.id("kw"));//����id����  input��Dom����id����ʹ��firebug�鿴������name���ҿ������룺name("wd")��
		element.sendKeys("webdriver");//�������������Ҫ���ҵ����ݣ�webdriver
		element.submit();//������ٶ�һ�¡��Ǹ���ť
		try
		{
			Thread.sleep(3000);//������������ҳ��ͣ��3000����
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		driver.quit();//�����ҳ�˳�
		

	}

}
