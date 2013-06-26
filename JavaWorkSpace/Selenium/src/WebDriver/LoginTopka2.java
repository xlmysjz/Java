package WebDriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.interactions.Actions;

public class LoginTopka2
{

	
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");// ����firefox��·��
		WebDriver driver = new FirefoxDriver();//����firefox�����ʵ��
		driver.get("http://www.topka.cn");//��topka��¼ҳ��

		Thread.sleep(3000);//��http://www.topka.cnҳ���ͣ��3000����

		
		Thread.sleep(3000);//�����½ҳ���ͣ��3000����
		
		//�������ڵ�¼ҳ��Ĳ���
		
		WebElement ElementLogin = driver.findElement(By.linkText("��¼"));//�������Ͻ� ��¼ ����
		ElementLogin.click();
		
		WebElement ElEmail = driver.findElement(By.id("login_email"));//������������
		ElEmail.clear();//����һ������������������
		ElEmail.sendKeys("111111@sina.com");//��������������� 111111@sina.com
		
		WebElement ElPWD = driver.findElement(By.cssSelector("input[id=\"login_password\"]"));//�������������
		ElPWD.clear();
		ElPWD.sendKeys("123456");
		
		WebElement ElSub = driver.findElement(By.xpath("//input[@id='login']"));//���ҵ�¼��ť
		ElSub.click();//��¼
		
		Thread.sleep(3000);//��½ƽ̨��ͣ��3000����

		Actions action = new Actions(driver);//����һ������¼�
		action.moveToElement(driver.findElement(By.xpath("//div[@class='fr ml_15 pos_pare mod_userbox J_user_menu']"))).perform();
		/*
		 ������δ���������ƶ������Ͻǣ��ܹ����������˵������������õ���By.xpath()����
		 ������˺ô�ľ���һ��ʼʹ�� By.className��By.cssSelector()������Ҳ�����������ƶ������ϽǺ��Զ���ʾ�����˵�������δ����Ը
		 �����̸��˺�ʹ��By.xpath()�������ɹ���
		 */
		
		WebElement ElementQuit =driver.findElement(By.linkText("�˳��ʺ�"));//�ҵ������˵����˳����Ǹ�����
		ElementQuit.click();//������˳�ƽ̨
		//ע���������������Ͻ��˳��˻����Ǹ����ӣ�������ֱ�ӹر�����������Ҫֱ�ӹر��������ֱ���ڴ�������¼�֮ǰ����driver.quit();�Ϳ�����
		
		//ҳ����ת���������driver.get("http://www.topka.cn")������������ĳ����ť����ת����ҳ�棬������Thread.sleep()�����Է���ס
	}

}
