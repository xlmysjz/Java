package WebDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateHomeWork3
{
	private static String LoginUrl = "http://topka.cn";//��¼����
	
	public  String getDate()
	{
		Date date = new Date();//�������ڶ���
		DateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String NowDate = dateformat.format(date);
		return NowDate;
		
	}

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");// ����firefox��·��
		WebDriver driver = new FirefoxDriver();//����firefox�����ʵ��
		driver.get(LoginUrl);//��topka��¼ҳ��

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

		WebElement elementHW = driver.findElement(By.xpath("//body[@id='J_connect']/div[4]/div/div[2]/div[1]/ul/li[4]/a"));//��λ д��ҵ �Ǹ���ť
		elementHW.click();//��� д��ҵ�Ǹ���ť
		/*
		 �����ҳд��ҵ�Ǹ�ͼ��Ҳ�����˶�λ���������⣬By.className��By.cssSelector()����ȫ��ʧЧ��
		 ʹ��xpathҲ�����˺�һ��û�гɹ����ٴ�ѯ�ʸ��ˣ�ʹ��xpath�������ڽ����
		 */
		Thread.sleep(3000);//ͣ��3000����
		
		WebElement HWTitle = driver.findElement(By.xpath("//input[@id='shuo_title']"));//��д��ҵҳ�棬ʹ��xpath��λ��ҵ������Dom
		HWTitle.clear();//�Ƚ��������������һ��
		CreateHomeWork3 topkaHW = new CreateHomeWork3();//������Ķ���
		HWTitle.sendKeys("�����Զ����ű����ɵı���"+topkaHW.getDate());//������ҵ��������+ʱ��
		
		WebElement HWContent = driver.findElement(By.xpath("//textarea[@id='shuo_content']"));//��д��ҵҳ�棬ʹ��xpath��λ��ҵ���ݿ��Dom
		HWContent.clear();//�Ƚ������������һ��
		HWContent.sendKeys("���ǽű��Զ����������");
		
		/*
		 �������޷���λ��Ƭ�Ǹ�flash��ť�����޷��ϴ�ͼƬ
		 
		 */
		Thread.sleep(10000);//ͣ��3000����
		driver.findElement(By.id("feed_post_btn")).click();
		
		
		
		//ҳ����ת���������driver.get("http://www.topka.cn")������������ĳ����ť����ת����ҳ�棬������Thread.sleep()�����Է���ס
		//elementHW = driver.findElement(By.xpath("//body[@id='J_connect']/div[4]/div/div[2]/div[1]/ul/li[4]/a"));

	}

}
