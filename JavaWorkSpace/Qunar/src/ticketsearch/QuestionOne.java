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
访问Qunar机票首页http://flight.qunar.com，
选择“单程”，输入出发、到达城市，选择today+7日后的日期，
点“搜索”，跳转到机票单程搜索列表页。
 */

public class QuestionOne
{
    private static WebDriver fdr;
    private static String Url = "http://flight.qunar.com";
    
    public static void initBrowser()//浏览器初始化
    {
	System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");//设置firefox浏览器
	fdr = new FirefoxDriver();//firefox浏览器实例化
	fdr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//隐性等待，设置10s
	fdr.get(Url);
	fdr.manage().window().maximize();//浏览器最大化
	
    }
    
    public static void search() throws Exception//输入条件，进行搜索
    {
	fdr.findElement(By.id("searchTypeSng")).click();//选择国内机票里的单选
	fdr.findElement(By.name("fromCity")).sendKeys("北京");//输入出发城市
	fdr.findElement(By.name("toCity")).sendKeys("深圳");//输入出发城市
	
	WebElement SelectTmes = fdr.findElement(By.name("fromDate"));
	
	//获取calendar实例;   
        Calendar calendar = Calendar.getInstance(); 
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE,7);//当前时间+7
	Date dates = calendar.getTime();
	
	SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
	String date_str= date_format.format(dates); //格式化日期  
        System.out.println(date_str); 
        
        SelectTmes.clear();//清空日期选择框
        SelectTmes.sendKeys(date_str);//输入当前时间+7天的日期
        
        fdr.findElement(By.xpath("//span[@class='startSth']/button")).click();//点击搜索按钮
        
        Thread.sleep(30000); //停留30000毫秒，文档要求停留1分钟，这里改成60000即可
        
        
        
        //Assert.assertTrue(fdr.findElement(By.xpath("//span[@class='dec']/b[4]")).getText().contains("搜索结束"),"搜索还未结束");
        //Assert.assertTrue(fdr.findElement(By.xpath("//[@id='progTip']/span")).getText().contains("搜索结束"),"搜索还未结束");
        
        if(fdr.findElement(By.tagName("body")).getText().contains("搜索结束"))//验证页面上出现“搜索结束”字体
        {
            System.out.println("显示了搜索结束");
        }
        else
        {
            System.out.println("未找到");
        }
        
    }
    
    public static void bookingTicket()
    {
	
	List<WebElement> ele = fdr.findElements(By.tagName("a"));//找到所有a元素
	
	List list = new ArrayList();
	for(WebElement e:ele)
	{
	    if(e.getAttribute("id").contains("openwrapperbtnXI"))//a元素 包含所有openwrapperbtnXI的id
	    {
		list.add(e.getAttribute("id"));//将取到的所有包含openwrapperbtnXI的id存放到list中
		System.out.println(e.getAttribute("id"));//打印所有包含openwrapperbtnXI的id
		
	    }
	}
	Random r = new Random();//随机一个数字
	int num = r.nextInt(list.size());
	
	fdr.findElement(By.id((String) list.get(num))).click();//对随机取到的ID点击订票
	System.out.println("随机选取的航班为："+list.get(num));//打印随机航班的ID
	
    }

    
    public static void main(String[] args) throws Exception
    {
	initBrowser();//初始化浏览器
	search();//按照条件搜索并验证搜索结束
	bookingTicket();
    }

}
