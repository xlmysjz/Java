package WebDriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
���ű��ǣ���δ���alert��confirm��prompt�Ի���

<html>
	<head>
		<title>Alert</title>
	</head>
	
	<body>
		<input id="alert" value="alert" type="button" onclick="alert('��ӭ���밴ȷ�ϼ���')"/>
		<input id="confirm" value="confirm" type="button" onclick="confirm('ȷ����')"/>
		<input id="prompt" value="prompt" type="button" onclick="var name = prompt('�������������');document.write(name)"/>
	</body>

</html>
����html������ҳ������ʾ��������ť��������Ƿֱ𵯳�alert��confirm��prompt�Ի��������prompt
�Ի������������ֵ��ȷ��֮�󣬽���ˢ��ҳ�棬��ʾ����Щ���� ��

�ýű��ڿ��� X:/JavaWorkSpace/Selenium/Dialogs.html �Ѵ���
 */
public class AlertConfirmPrompt8
{

	
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\eclipse\\chromedriver.exe");
		WebDriver cdr = new ChromeDriver();
		String Url = "X:/JavaWorkSpace/Selenium/Dialogs.html";
		
		cdr.get(Url);
		//�����һ����ť,����Ի�����������֣�Ȼ��ر�
		cdr.findElement(By.id("alert")).click();//��� alert��ť
		Alert alert = cdr.switchTo().alert();//�л����� alert����
		String text = alert.getText();
		System.out.println(text);//����alert���������
		Thread.sleep(3000);
		alert.dismiss();//�رմ���
		
		//����ڶ�����ť������Ի�����������֣�Ȼ����ȷ��
		cdr.findElement(By.id("confirm")).click();//��� confirm ��ť
		Alert confirm = cdr.switchTo().alert();//�л��� confirm ��ť��
		String text1 = confirm.getText();//�õ�ȷ�ϴ������������
		System.out.println(text1);
		Thread.sleep(3000);
		confirm.accept();//���ȷ��
		
		//�����������ť������һ�����֣�Ȼ����ȷ����
		cdr.findElement(By.id("prompt")).click();//���prompt��ť
		Alert prompt = cdr.switchTo().alert();//�л���prompt��
		String text2 = prompt.getText();//������������
		System.out.println(text2);
		Thread.sleep(3000);
		prompt.sendKeys("selenium2.x����Webdriver");
		Thread.sleep(3000);
		prompt.accept();//���ȷ����ť
		
		cdr.quit();
		
		/*���߱�ע��
		 �����ϴ�����Կ���dr.switchTo().alert();�����Եõ�alert\confirm\prompt�Ի���Ķ���Ȼ�������䷽��
		�������в������Ի����������Ҫ�����У�
 		getText() �õ������ı�ֵ
		accept() �൱�ڵ������"ȷ��"
		dismiss() �൱�ڵ��"ȡ��"���߲���Ի���
		sendKeys() ����ֵ�����alert\confirmû�жԻ���Ͳ������ˣ���Ȼ�ᱨ��
		 */
		//31

	}

}
