package WebDriver;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1.������һ�����ӣ��ͻ�����ҳ������ӣ� ��δ����ʾ�ľ�����εõ��򿪵��Ǹ���ҳ��
2. html��д�Ľű��ǣ�
<html>
	<head>
		<title>Test PopUp Windows</title>
	</head>
	<body>
		<a id="baidu" href="http://www.baidu.com/" target="_blank">�������ҳ��򿪰ٶȴ���</a>
	</body>
</html>
�ýű��ڿ��� X:/JavaWorkSpace/Selenium/TestPopUp.html �Ѵ���

 */
public class GetWindowsHandle7
{

	
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\eclipse\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		String Url = "X:/JavaWorkSpace/Selenium/TestPopUp.html";//html�����ŵ�·��
		chromeDriver.get(Url);
		
		chromeDriver.findElement(By.id("baidu")).click();//���ҳ��������Ӿͻ�����ҳ���һ����ҳ
		//�õ���ǰ���ڵľ��
		String currentWindow = chromeDriver.getWindowHandle();
		System.out.println("ԭʼ��ҳtitleΪ��"+chromeDriver.getTitle());//��ӡ��ǰ���ڵ� title
		
		//�õ���ǰ���д��ڵľ��
		Set<String>handls = chromeDriver.getWindowHandles();
		Iterator<String> it = handls.iterator();
		while(it.hasNext())
		{
			/*
			Iterator��Java��������򵥵�ʵ�� ��
			next()��������е���һ��Ԫ�أ���һ�ε���ʱ���ؼ��ϵĵ�һ��Ԫ�أ��������
			hasNext()�Ǽ�鼯�����Ƿ���Ԫ�أ�һ������whileѭ�����ж�����У��еĻ�����true��û�з���false��
			 */
			if(currentWindow == it.next())//��һ�ε��� next���������صĻ���ԭ����title������continue ��һ��title�Ļ�ȡ,��������ifע�͵�������ӡ����ҳ���title
			{
				continue;
			}
			
			WebDriver window = chromeDriver.switchTo().window(it.next());//�л����µĴ���
			System.out.println("��ǰtitleΪ��"+window.getTitle()+",��ǰUrlΪ��"+window.getCurrentUrl());
			
		}
		chromeDriver.findElement(By.id("kw")).sendKeys("�л����´��ں������");//�鿴һ�����´����ܷ���������
		
		/*
		1.selenium webdriver.pdf������ӣ� �������˵��λ�������ڵĹؼ����ڻ�õ������ڵľ������������ҵ��������������ڵ�һ��Ψһ��ʶ��
		�ǵ���ǰ��"��������"Ҳ����������
		
		2.�����ص���ǰ�Ĵ��ڶ�λԪ�أ���ô�ٵ���1��switch_to.window����������֮ǰ���ڵľ��(currentWindow)�ȿɴﵽĿ
	�ġ�
		 */

	}


}
