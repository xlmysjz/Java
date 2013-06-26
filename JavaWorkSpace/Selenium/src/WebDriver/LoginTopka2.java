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
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");// 设置firefox的路径
		WebDriver driver = new FirefoxDriver();//创建firefox浏览器实例
		driver.get("http://www.topka.cn");//打开topka登录页面

		Thread.sleep(3000);//打开http://www.topka.cn页面后，停留3000毫秒

		
		Thread.sleep(3000);//进入登陆页面后，停留3000毫秒
		
		//以下是在登录页面的操作
		
		WebElement ElementLogin = driver.findElement(By.linkText("登录"));//查找右上角 登录 链接
		ElementLogin.click();
		
		WebElement ElEmail = driver.findElement(By.id("login_email"));//邮箱输入框查找
		ElEmail.clear();//先清一下邮箱输入框里的内容
		ElEmail.sendKeys("111111@sina.com");//向邮箱输入框输入 111111@sina.com
		
		WebElement ElPWD = driver.findElement(By.cssSelector("input[id=\"login_password\"]"));//查找密码输入框
		ElPWD.clear();
		ElPWD.sendKeys("123456");
		
		WebElement ElSub = driver.findElement(By.xpath("//input[@id='login']"));//查找登录按钮
		ElSub.click();//登录
		
		Thread.sleep(3000);//登陆平台后，停留3000毫秒

		Actions action = new Actions(driver);//创建一个鼠标事件
		action.moveToElement(driver.findElement(By.xpath("//div[@class='fr ml_15 pos_pare mod_userbox J_user_menu']"))).perform();
		/*
		 上面这段代码是鼠标移动到右上角，能够弹出下拉菜单的区域，这里用的是By.xpath()方法
		 这里费了好大的劲，一开始使用 By.className，By.cssSelector()方法，也是想如果鼠标移动到右上角后自动显示下拉菜单，但都未能如愿
		 最后请教高人后，使用By.xpath()方法，成功。
		 */
		
		WebElement ElementQuit =driver.findElement(By.linkText("退出帐号"));//找到下拉菜单里退出的那个链接
		ElementQuit.click();//点击后退出平台
		//注意这里点击的是右上角退出账户的那个链接，并不是直接关闭浏览器，如果要直接关闭浏览器，直接在创建鼠标事件之前调用driver.quit();就可以了
		
		//页面跳转，如调用了driver.get("http://www.topka.cn")方法，或点击了某个按钮后跳转的新页面，最后调用Thread.sleep()方法以防卡住
	}

}
