package WebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
����һ������table����񣩵����ӣ�����δ��뱣��Ϊ xx.html �򿪾Ϳ��Կ���Ч����

HTML����Ϊ��

<html>
    <head>
        <title>Table</title>
        
    </head>
    <body>
        <table border="1" id="myTable">
<tr>
<th>HeadingA(1 ,1)</th>
<th>HeadingB(1 ,2)</th>
<th>HeadingC(1 ,3)</th>
</tr>
<tr>
<td>2, 1</td>
<td>2, 2</td>
<td>2, 3</td>
</tr>
<tr>
<td>3, 1</td>
<td>3, 2</td>
<td>3, 3</td>
</tr>
</table>
    </body>
</html>

 */
public class Test_table15
{
    private WebDriver driver;  
    Test_table15(WebDriver driver)
    {  
	this.driver = driver;  
    }
    
    public String getCellText(By by,String tableCellAddress)
    {  
        //�õ�tableԪ�ض���  
        WebElement table = driver.findElement(by);  
        //����Ҫ���ҵĵ�Ԫ��λ���ַ������зֽ⣬�õ����Ӧ�С��С�  
        int index = tableCellAddress.trim().indexOf('.');  
        int row =  Integer.parseInt(tableCellAddress.substring(0, index));  
        int cell = Integer.parseInt(tableCellAddress.substring(index+1));  
        //�õ�table���������ж��󣬲��õ���Ҫ��ѯ���ж���  
        List<WebElement> rows = table.findElements(By.tagName("tr"));  
        WebElement theRow = rows.get(row);  
        //����getCell�����õ���Ӧ���ж���Ȼ��õ�Ҫ��ѯ���ı���  
        String text = getCell(theRow, cell).getText();  
        return text;  
   } 
    
    private WebElement getCell(WebElement Row,int cell){  
        List<WebElement> cells;  
        WebElement target = null;  
        //��������"<th>"��"<td>"���ֱ�ǩ�����Էֿ�����  
        if(Row.findElements(By.tagName("th")).size()>0){  
           cells = Row.findElements(By.tagName("th"));  
           target = cells.get(cell);  
        }  
        if(Row.findElements(By.tagName("td")).size()>0){  
           cells = Row.findElements(By.tagName("td"));  
           target = cells.get(cell);  
        }  
       return target;       
   }

    
    public static void main(String[] args)
    {
	String url = "X:\\JavaWorkSpace\\Selenium\\table.html";
	//��chrome
	WebDriver dr = new ChromeDriver();
	dr.get(url);
	
	Test_table15 table = new Test_table15(dr);  
	System.out.println(table.getCellText(By.id("myTable"), "0.2")); 
	System.out.println(table.getCellText(By.id("myTable"), "2.1")); 
	        
	dr.quit();

    }

}
