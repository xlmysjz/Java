package WebDriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
本脚本是：如何处理alert、confirm、prompt对话框

<html>
	<head>
		<title>Alert</title>
	</head>
	
	<body>
		<input id="alert" value="alert" type="button" onclick="alert('欢迎！请按确认继续')"/>
		<input id="confirm" value="confirm" type="button" onclick="confirm('确定吗？')"/>
		<input id="prompt" value="prompt" type="button" onclick="var name = prompt('请输入你的名字');document.write(name)"/>
	</body>

</html>
以上html代码在页面上显示了三个按钮，点击他们分别弹出alert、confirm、prompt对话框。如果在prompt
对话框中输入文字点击确定之后，将会刷新页面，显示出这些文字 。

该脚本在快盘 X:/JavaWorkSpace/Selenium/Dialogs.html 已存在
 */
public class AlertConfirmPrompt8
{

	
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\eclipse\\chromedriver.exe");
		WebDriver cdr = new ChromeDriver();
		String Url = "X:/JavaWorkSpace/Selenium/Dialogs.html";
		
		cdr.get(Url);
		//点击第一个按钮,输出对话框上面的文字，然后关闭
		cdr.findElement(By.id("alert")).click();//点击 alert按钮
		Alert alert = cdr.switchTo().alert();//切换到该 alert窗口
		String text = alert.getText();
		System.out.println(text);//输入alert上面的文字
		Thread.sleep(3000);
		alert.dismiss();//关闭窗口
		
		//点击第二个按钮，输出对话框上面的文字，然后点击确定
		cdr.findElement(By.id("confirm")).click();//点击 confirm 按钮
		Alert confirm = cdr.switchTo().alert();//切换到 confirm 按钮上
		String text1 = confirm.getText();//得到确认窗口上面的文字
		System.out.println(text1);
		Thread.sleep(3000);
		confirm.accept();//点击确定
		
		//点击第三个按钮，输入一段文字，然后点击确定，
		cdr.findElement(By.id("prompt")).click();//点击prompt按钮
		Alert prompt = cdr.switchTo().alert();//切换到prompt上
		String text2 = prompt.getText();//输出上面的文字
		System.out.println(text2);
		Thread.sleep(3000);
		prompt.sendKeys("selenium2.x就是Webdriver");
		Thread.sleep(3000);
		prompt.accept();//点击确定按钮
		
		cdr.quit();
		
		/*作者标注：
		 从以上代码可以看出dr.switchTo().alert();这句可以得到alert\confirm\prompt对话框的对象，然后运用其方法
		对它进行操作。对话框操作的主要方法有：
 		getText() 得到它的文本值
		accept() 相当于点击它的"确认"
		dismiss() 相当于点击"取消"或者叉掉对话框
		sendKeys() 输入值，这个alert\confirm没有对话框就不能用了，不然会报错。
		 */
		//31

	}

}
