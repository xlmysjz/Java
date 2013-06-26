package WebDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TopkaCreateActivity4
{
	private static String LoginUrl = "http://topka.cn";//��¼����
	public static WebDriver driver;
	
	public static String getDate()//��ȡ��ǰʱ��
	{
		Date date = new Date();//�������ڶ���
		DateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String NowDate = dateformat.format(date);
		return NowDate;
	}
	public static void InitBrowser() throws Exception//���������ʵ��
	{
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");// ����firefox��·��
		driver = new FirefoxDriver();//����firefox�����ʵ��
		driver.get(LoginUrl);//��topka��¼ҳ��
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);//���ó�ʱ��ֵ
		//Thread.sleep(3000);//��http://www.topka.cnҳ���ͣ��3000����
	}

	public static void main(String[] args) throws Exception
	{
		InitBrowser();//��ʼ�������
		
		
		//�������ڵ�¼ҳ��Ĳ���
		WebElement ElementLogin = driver.findElement(By.linkText("��¼"));//�������Ͻ� ��¼ ����
		ElementLogin.click();
		
		Thread.sleep(3000);//�����½ҳ���ͣ��3000����
		
		WebElement ElEmail = driver.findElement(By.id("login_email"));//������������
		ElEmail.clear();//����һ������������������
		ElEmail.sendKeys("111111@sina.com");//��������������� 111111@sina.com
		
		WebElement ElPWD = driver.findElement(By.cssSelector("input[id=\"login_password\"]"));//�������������
		ElPWD.clear();
		ElPWD.sendKeys("123456");
		
		WebElement ElSub = driver.findElement(By.xpath("//input[@id='login']"));//���ҵ�¼��ť
		ElSub.click();//��¼

		//�����ǵ�����ǩ��������Ľű�
		driver.findElement(By.linkText("�")).click();//��¼���� ��ҳ-� ��ǩ
		Thread.sleep(3000);//ͣ��3000����
		
		driver.findElement(By.id("issue_act_btn")).click();//ʹ��id��λ ���� �Ǹ���ť�����
		Thread.sleep(3000);//ͣ��3000����
		driver.findElement(By.xpath("//div[@id='work_post_content']/ul/li[2]/a")).click();//�ڻ����ҳ�涨λ �ۻ� �Ǹ����͵Ļ�������
		Thread.sleep(8000);//ͣ��8000����
		//�������ڴ����ʱ��Ԫ�ص�����
		driver.findElement(By.xpath("//input[@id='activityName']")).sendKeys("�����Զ����ű������Ļ"+getDate());//��λ�����,����������
		
		JavascriptExecutor Exec = (JavascriptExecutor) driver;//ʹ��JS���û��ʼʱ��ؼ�
		String js = "document.getElementById('startDate').removeAttribute('readonly');"+
					"document.getElementById('startDate').setAttribute('value','2013-01-20');"+//���������������յ�����
					"document.getElementById('startTimeHours').removeAttribute('readonly');"+
					"document.getElementById('startTimeHours').setAttribute('value','22ʱ');"+//����������Сʱ������
					"document.getElementById('startTimeMinutes').removeAttribute('readonly');"+
					"document.getElementById('startTimeMinutes').setAttribute('value','55��');"+//�������Ƿ��ӵ�����
					//�����ǻ�Ŀ�ʼʱ�����ã�ʱ��Ϊ2013-01-20 22ʱ  55��
					
					 "document.getElementById('endDate').removeAttribute('readonly');"+
					 "document.getElementById('endDate').setAttribute('value','2013-12-20');"+
					 "document.getElementById('endTimeHours').removeAttribute('readonly');"+
					 "document.getElementById('endTimeHours').setAttribute('value','06ʱ');"+
					 "document.getElementById('endTimeMinutes').removeAttribute('readonly');"+
					 "document.getElementById('endTimeMinutes').setAttribute('value','10��');"+
					 //�����ǻ����ʱ�����ã�ʱ��Ϊ2013-12-20 06ʱ 10��
					 
					 "document.getElementById('closeDate').removeAttribute('readonly');"+
					 "document.getElementById('closeDate').setAttribute('value','2013-12-19');"+
					 "document.getElementById('closeTimeHours').removeAttribute('readonly');"+
					 "document.getElementById('closeTimeHours').setAttribute('value','22ʱ');"+
					 "document.getElementById('closeTimeMinutes').removeAttribute('readonly');"+
					 "document.getElementById('closeTimeMinutes').setAttribute('value','50��');";
					 //�����ǻ������ֹ���ã�ʱ��Ϊ2013-12-19 22ʱ 50��
		Exec.executeScript(js);//ִ��JS�����������õ�����ȫ������ʱ��ؼ������
		
		driver.findElement(By.xpath("//div[@class='place_menub']/a")).click();//��λ����� ��������
		Thread.sleep(2000);//ͣ��2000����
		driver.findElement(By.xpath("//div[@class='place_menu_box']/dl[1]/dd[3]/a")).click();//��λ��ѡ��ӱ�����
		Thread.sleep(2000);//ͣ��2000����
		
		//���� ��ص�
		JavascriptExecutor Execinput = (JavascriptExecutor) driver;
		String JsInput = "document.getElementById('otherPosInput').removeAttribute('autocomplete');"+
					"document.getElementById('otherPosInput').setAttribute('value','�й��ӱ�ʡʯ��ׯ�Ŷ�����������·ʯ��ׯ������ѧ');";//ʹ��JS�Ի�ص㸳ֵ
		Execinput.executeScript(JsInput);//JSִ��
		
		/*//ʹ������ķ���Ҳ����ʵ�ֶԻ�ص�������������ݵĲ��������Ǹ�ֵʱ�и��Զ���ѯ�����������������ݲ���������Ӧ
		 ִ�к���� ��ͼ��ע ��ť���ʱ�޷�Ӧ�����������ʹ��JS��ֵ
		WebElement ElPlace = driver.findElement(By.xpath("//input[@id='otherPosInput']"));//��λ��ص������
		ElPlace.clear();//��һ��������������
		ElPlace.sendKeys("ʯ��ׯ");//��ص����� һ��ģ����ַ
		*/
		//Thread.sleep(1000);//ͣ��1000����
		/*
		WebElement subm = driver.findElement(By.xpath("//body/div[4]/div[1]/div/div[1]/ul/li[5]/div/a"));//��λ ��ͼ��ע ��ť
		subm.click();//���  ��ͼ��ע ��ť
		Thread.sleep(3000);//ͣ��3000����
		*/
		/*
		//�����ص㴰��
		JavascriptExecutor ExecSearch = (JavascriptExecutor) driver;//ʹ��JS���û��ʼʱ��ؼ�
		String JsSearch = "document.getElementById('place_key_word').removeAttribute('autocomplete');"+
					"document.getElementById('place_key_word').setAttribute('value','�й��ӱ�ʡʯ��ׯ�Ŷ�����������·ʯ��ׯ������ѧ');";
		ExecSearch.executeScript(JsSearch);//JSִ��
		*/
		/*
		//ʹ������ķ���Ҳ����ʵ�ֶԻ�ص�������������ݵĲ��������Ǹ�ֵʱ�и��Զ���ѯ�����������������ݲ���������Ӧ
		// ִ�к���� ������ͼ ��ť���ʱ�޷�Ӧ�����������ʹ��JS��ֵ
		WebElement InputSearch = driver.findElement(By.xpath("//input[@id='place_key_word']"));//��λ������ͼ�������
		InputSearch.clear();
		InputSearch.sendKeys("�й��ӱ�ʡʯ��ׯ�Ŷ�����������·ʯ��ׯ������ѧ");//��������ͼ�����������ϸ��ַ
		
		Thread.sleep(2000);//ͣ��2000����
		driver.findElement(By.id("searchMapBtn")).click();//���������ͼ��ť
		Thread.sleep(2000);//ͣ��2000����
		driver.findElement(By.id("setMapSave")).click();//�����ص���� ���� �����б�ע
		Thread.sleep(3000);//ͣ��3000����
		*/
		
		WebElement SelectRadio = driver.findElement(By.xpath("//input[@id='cost1']"));//��λ����� Ԫ/�� ���Ǹ���ѡ��
		SelectRadio.click();//ѡ��  Ԫ/�� ���Ǹ���ѡ��
		driver.findElement(By.xpath("//input[@id='cost']")).sendKeys("365.36");//���� ��� 365.36
		//�˵������� ѡ������Լ���������
		driver.findElement(By.xpath("//body/div[4]/div[1]/div/div[1]/ul/li[8]/div/div/div[1]/span[1]/span")).click();//��λ������˵�����ϵı���
		Thread.sleep(2000);//ͣ��2000����
		driver.findElement(By.xpath("//body/div[10]/div/div[1]/div/img[2]")).click();//ѡ��һ���������ڶ��� ���� ���Ǹ�����
		Thread.sleep(1000);//ͣ��1000����
		
		//*������䣺������iframe���������ֱ��ʹ��driver.findElement(������λԪ�أ���Ҫʹ��driver.switchTo().frame ���л������frame  Ȼ���ٶ�λ���ı������
		WebElement InputBox = driver.switchTo().frame(driver.findElement(By.id("ke_edit_iframe"))).findElement(By.id("eiframe_body"));//��˵���������������
		InputBox.sendKeys("���ǻ˵����������ϴ��뱾�λ�йص�ͼƬ������μӱ��λ��ע������ȡ�");//���������������  eiframe_body
		Thread.sleep(1000);
		driver.switchTo().defaultContent();//����frame,�Ա������λҳ������Ԫ��
		
		//�����
		driver.findElement(By.xpath("//body/div[4]/div[1]/div/div[2]/div[2]/div[1]/div/a[3]")).click();//���������� �޶�Ϊ ��ť
		Thread.sleep(1000);//ͣ��1000����
		driver.findElement(By.id("min_cnt")).sendKeys("5");//��������޸�Ϊ 5
		driver.findElement(By.id("max_cnt")).clear();//������������������ ��ֵ
		driver.findElement(By.id("max_cnt")).sendKeys("100");//��������޸�Ϊ100
		driver.findElement(By.id("eve_cnt")).sendKeys("3");//ÿ���ޱ���Ϊ3��
		//��ѡ������
		driver.findElement(By.xpath("//body/div[4]/div[1]/div/div[2]/div[3]/div[1]/div/a[3]")).click();//��λ������������� �Զ��� ��ť
		Thread.sleep(2000);//ͣ��2000����
		driver.findElement(By.xpath("//input[@id='form_item_phone']")).click();//��λ����ѡ �ֻ���
		driver.findElement(By.id("form_item_pn")).click();//��λ����ѡ ���ƺ�
		Thread.sleep(1000);//ͣ��1000����
		//�ύ�
		driver.findElement(By.id("submit")).click();
		Thread.sleep(6000);//������ɹ���ͣ��6000����
		driver.findElement(By.xpath("//body/div[9]/div[1]/a")).click();//�ر��������һ��μӴ���
		Thread.sleep(3000);//������ɹ���ͣ��3000����
		
		//�������˳���½ƽ̨����
		Actions action = new Actions(driver);//����һ������¼�
		action.moveToElement(driver.findElement(By.xpath("//div[@class='fr ml_15 pos_pare mod_userbox J_user_menu']"))).perform();
		/*
		 ������δ���������ƶ������Ͻǣ��ܹ����������˵������������õ���By.xpath()����
		 ������˺ܴ�Ĺ�ʱ��һ��ʼʹ�� By.className��By.cssSelector()������Ҳ��Ҫ�ﵽ����ƶ������ϽǺ��Զ���ʾ�����˵���Ч��������δ����Ը��
		 �����̸��˺�ʹ��By.xpath()�������ɹ���
		 */
		Thread.sleep(2000);//������ɹ���ͣ��2000����
		WebElement ElementQuit =driver.findElement(By.linkText("�˳��ʺ�"));//�ҵ������˵����˳����Ǹ�����
		ElementQuit.click();//������˳�ƽ̨
		//ע���������������Ͻ��˳��˻����Ǹ����ӣ�������ֱ�ӹر�����������Ҫֱ�ӹر��������ֱ�ӵ���driver.quit()�Ϳ�����
		
		
		/*ע��
		1.�ϴ�ͼƬ���磺ͷ���Ǹ���ť��flash��Ŀǰselenium�ﱾ�����޷���λ��ֻ�����������������磺autoit����ʵ��ͼƬ�ϴ���
		˭����Ȥ�����о�һ��autoit��
		2.�����ۻ��Ǹ�����ͼ��ע����ť���ű���û���漰��˭����Ȥ����дһ�������ַ��������ͼ��ע���ٽ��е�ַ��λ�Ĳ�����
		3.������ҳ����ת����ť����¼��� ��Ҫ���� Thread.sleep()��ֹҳ�濨ס��
		4.��ʹ��By.id By.name�޷���λʱ��ʹ��By.xpath����λ��Ϊ���㡣
		 */
	}

}