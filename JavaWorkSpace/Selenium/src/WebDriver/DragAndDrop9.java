package WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


/*
 ����ű����ֵ��ǰ�һ��Ԫ����Ŀ�ϵ�һ��div���� 
 ��ַ�� http://koyoz.com/demo/html/drag-drop/drag-drop.html
  
 */


public class DragAndDrop9
{
	private static String Url = "http://koyoz.com/demo/html/drag-drop/drag-drop.html";
	private static WebDriver cdr;
	
	public static void InitBowser()//��ʼ��chrome�����
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\eclipse\\chromedriver.exe");
		cdr = new ChromeDriver();
		cdr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		cdr.get(Url);//��chrome�����
	}
	
	
	public static void main(String[] args)
	{
		
		InitBowser();
		//����new��Ҫ�����ҳ��Ԫ�ض����Ŀ�����Ȼ���������
		//WebElement element = cdr.findElement(By.id("item1"));//����Ҫ������Ǹ�Ԫ��
		WebElement target = cdr.findElement(By.id("drop"));//����Ҫ���뵽��div�Ǹ���
		
		Actions action = new Actions(cdr);//����һ��������
		//����ѭ����item���뵽div�Ǹ�����
		
		String Id = "item";
		for(int i = 1;i <= 6;i++)
		{
			String item = Id+i;
			(action.dragAndDrop(cdr.findElement(By.id(item)), target)).perform();
		}//38

		
	}

}
