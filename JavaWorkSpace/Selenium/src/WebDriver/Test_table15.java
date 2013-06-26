package WebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
这是一个处理table（表格）的例子，将这段代码保存为 xx.html 打开就可以看到效果了

HTML代码为：

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
        //得到table元素对象  
        WebElement table = driver.findElement(by);  
        //对所要查找的单元格位置字符串进行分解，得到其对应行、列。  
        int index = tableCellAddress.trim().indexOf('.');  
        int row =  Integer.parseInt(tableCellAddress.substring(0, index));  
        int cell = Integer.parseInt(tableCellAddress.substring(index+1));  
        //得到table表中所有行对象，并得到所要查询的行对象。  
        List<WebElement> rows = table.findElements(By.tagName("tr"));  
        WebElement theRow = rows.get(row);  
        //调用getCell方法得到对应的列对象，然后得到要查询的文本。  
        String text = getCell(theRow, cell).getText();  
        return text;  
   } 
    
    private WebElement getCell(WebElement Row,int cell){  
        List<WebElement> cells;  
        WebElement target = null;  
        //列里面有"<th>"、"<td>"两种标签，所以分开处理。  
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
	//打开chrome
	WebDriver dr = new ChromeDriver();
	dr.get(url);
	
	Test_table15 table = new Test_table15(dr);  
	System.out.println(table.getCellText(By.id("myTable"), "0.2")); 
	System.out.println(table.getCellText(By.id("myTable"), "2.1")); 
	        
	dr.quit();

    }

}
