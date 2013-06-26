package ticketsearch;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/*
����Qunar��Ʊ��ҳhttp://flight.qunar.com��
ѡ�񡰵��̡������������������У�ѡ��today+7�պ�����ڣ�
�㡰����������ת����Ʊ���������б�ҳ��
 */

public class QuestionOne
{
    private static WebDriver fdr;
    private static String Url = "http://flight.qunar.com";
    
    public static void initBrowser()//�������ʼ��
    {
	System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");//����firefox�����
	fdr = new FirefoxDriver();//firefox�����ʵ����
	fdr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//���Եȴ�������10s
	fdr.get(Url);
	fdr.manage().window().maximize();//��������
	
    }
    
    public static void search() throws Exception//������������������
    {
	fdr.findElement(By.id("searchTypeSng")).click();//ѡ����ڻ�Ʊ��ĵ�ѡ
	fdr.findElement(By.name("fromCity")).sendKeys("����");//�����������
	fdr.findElement(By.name("toCity")).sendKeys("����");//�����������
	
	WebElement SelectTmes = fdr.findElement(By.name("fromDate"));
	
	//��ȡcalendarʵ��;   
        Calendar calendar = Calendar.getInstance(); 
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE,7);//��ǰʱ��+7
	Date dates = calendar.getTime();
	
	SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
	String date_str= date_format.format(dates); //��ʽ������  
        System.out.println(date_str); 
        
        SelectTmes.clear();//�������ѡ���
        SelectTmes.sendKeys(date_str);//���뵱ǰʱ��+7�������
        
        fdr.findElement(By.xpath("//span[@class='startSth']/button")).click();//���������ť
        
        Thread.sleep(30000); //ͣ��30000���룬�ĵ�Ҫ��ͣ��1���ӣ�����ĳ�60000����
        
        
        
        //Assert.assertTrue(fdr.findElement(By.xpath("//span[@class='dec']/b[4]")).getText().contains("��������"),"������δ����");
        //Assert.assertTrue(fdr.findElement(By.xpath("//[@id='progTip']/span")).getText().contains("��������"),"������δ����");
        
        if(fdr.findElement(By.tagName("body")).getText().contains("��������"))//��֤ҳ���ϳ��֡���������������
        {
            System.out.println("��ʾ����������");
        }
        else
        {
            System.out.println("δ�ҵ�");
        }
        
    }
    
    public static void bookingTicket()
    {
	
	List<WebElement> ele = fdr.findElements(By.tagName("a"));//�ҵ�����aԪ��
	
	List list = new ArrayList();
	for(WebElement e:ele)
	{
	    if(e.getAttribute("id").contains("openwrapperbtnXI"))//aԪ�� ��������openwrapperbtnXI��id
	    {
		list.add(e.getAttribute("id"));//��ȡ�������а���openwrapperbtnXI��id��ŵ�list��
		System.out.println(e.getAttribute("id"));//��ӡ���а���openwrapperbtnXI��id
		
	    }
	}
	Random r = new Random();//���һ������
	int num = r.nextInt(list.size());
	
	fdr.findElement(By.id((String) list.get(num))).click();//�����ȡ����ID�����Ʊ
	System.out.println("���ѡȡ�ĺ���Ϊ��"+list.get(num));//��ӡ��������ID
	
    }

    
    public static void main(String[] args) throws Exception
    {
	initBrowser();//��ʼ�������
	search();//����������������֤��������
	bookingTicket();
    }

}
