package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MyTest {
WebDriver driver;
    
    @Parameters({"Browser"})
    @BeforeTest
    public void setBrowser(String Browser)
    {
      if(Browser.equals("firefox"))
      {
	  System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");
	  driver = new FirefoxDriver();
      }
      else
      {
	  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\eclipse\\chromedriver.exe");
	  driver = new ChromeDriver();
      }
    }
    
    @Parameters({"Url","keyword"})
    @Test
    public void search(String Url,String keyword)
    {
	driver.get(Url);
	WebElement element = driver.findElement(By.id("kw"));
	element.sendKeys(keyword);
	element.submit();
	
	Assert.assertTrue(driver.getTitle().contains(keyword), "the title is wrong");
	driver.quit();
    }
}
