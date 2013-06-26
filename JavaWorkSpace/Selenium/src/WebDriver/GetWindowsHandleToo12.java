package WebDriver;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
��Ҫ�� handle ���л� ���ð�������� GetWindowsHandle7 һ����ֻ�����ܽ���һ�¸�handle�ķ���

//��һ�ŷ���
Set<String> handlers = driver.getWindowHandles();//�õ�ȫ�����ڵľ��
String crrHandle = driver.getWindowHandle();//�õ���ǰ�Ĵ��ھ��
for(String h:handlers)
	{
		if(crrHandle.equals(h))
		{
			continue;
		}
	WebDriver win = driver.switchTo().window(h);
	System.out.println("��ҳtitle����Ϊ��"+win.getTitle()+"\n��ҳURLΪ��"+win.getCurrentUrl());
	}
	driver.findElement(By.id("kw")).sendKeys("�л����´��ں������");

-------------------------------
�ڶ��ַ���
//�õ���ǰ���ڵľ��
String currentWindow = chromeDriver.getWindowHandle();
System.out.println("ԭʼ��ҳtitleΪ��"+chromeDriver.getTitle());//��ӡ��ǰ���ڵ� title
		
//�õ���ǰ���д��ڵľ��
Set<String>handls = chromeDriver.getWindowHandles();
Iterator<String> it = handls.iterator();
while(it.hasNext())
{
	Iterator��Java��������򵥵�ʵ�� ��
	next()��������е���һ��Ԫ�أ���һ�ε���ʱ���ؼ��ϵĵ�һ��Ԫ�أ��������
	hasNext()�Ǽ�鼯�����Ƿ���Ԫ�أ�һ������whileѭ�����ж�����У��еĻ�����true��û�з���false��

	if(currentWindow == it.next())//��һ�ε��� next���������صĻ���ԭ����title������continue ��һ��title�Ļ�ȡ,��������ifע�͵�������ӡ����ҳ���title
	{
		continue;
	}
			
	WebDriver window = chromeDriver.switchTo().window(it.next());//�л����µĴ���
	System.out.println("��ǰtitleΪ��"+window.getTitle()+",��ǰUrlΪ��"+window.getCurrentUrl());
			
}
 */

public class GetWindowsHandleToo12
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");// ����firefox��·��
		WebDriver driver = new FirefoxDriver();

		String Url = "X:\\JavaWorkSpace\\Selenium\\TestPopUp.html";//html�����ŵ�·��
		driver.get(Url);
		driver.findElement(By.id("baidu")).click();
		
		Set<String> handlers = driver.getWindowHandles();//�õ�ȫ�����ڵľ��
		String crrHandle = driver.getWindowHandle();//�õ���ǰ�Ĵ��ھ��
		for(String h:handlers)
		{
			if(crrHandle.equals(h))
			{
				continue;
			}
			/*else
			{
				crrHandle = h;
			}*/
			WebDriver win = driver.switchTo().window(h);
			System.out.println("��ҳtitle����Ϊ��"+win.getTitle()+"\n��ҳURLΪ��"+win.getCurrentUrl());
		}
		driver.findElement(By.id("kw")).sendKeys("�л����´��ں������");

	}

}
