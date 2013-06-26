package JavaTest1;

import java.text.SimpleDateFormat;
import java.util.Date;

class MyPerson
{
	private String name;
	private int age;
	private MyBook book;
	public MyPerson(String name,int age)
	{
		this.setAge(age);
		this.setName(name);
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public MyBook getBook()
	{
		return book;
	}
	public void setBook(MyBook book)
	{
		this.book = book;
	}
}

class MyBook
{
	private String title;
	private float price;
	MyPerson person;
	public MyBook(String title,float price)
	{
		this.setPrice(price);
		this.setTitle(title);
	}
	
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public float getPrice()
	{
		return price;
	}
	public void setPrice(float price)
	{
		this.price = price;
	}
	
	public MyPerson getPerson()
	{
		return person;
	}
	public void setPerson(MyPerson person)
	{
		this.person = person;
	}
}
public class RefDemo5
{

	
	public static void main(String[] args)
	{
		MyPerson per = new MyPerson("张三",30);
		MyBook bk = new MyBook("java SE核心教程",90.0f);
		//继续向下写




	}

}
