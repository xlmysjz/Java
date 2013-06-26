package MyYingyongAndChandi;
class Demo
{
	int temp = 30;//第一道范例
	
}
class Demo3
{
	String str3 = "hello";//第三道范例
}

class Person//一对一关系
{
	private String name;//人的姓名
	private int age;//人的年龄
	private Book book;//一个人有一本书
	
	private Person child;//进一步深化一对一关系，一个人有一本书
	
	public Person(String name,int age)
	{
		this.setName(name);
		this.setAge(age);
	}
	
	public void setName(String n)
	{
		name = n;
	}
	public void setAge(int a)
	{
		age = a;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	
	public void setBook(Book b)
	{
		book = b;
	}
	
	public Book getBook()
	{
		return book;
	}
	
	public void setChild(Person c)//进一步神人一对一关系
	{
		child = c;
	}
	public Person getChild()
	{
		return child;
	}
	
};
class Book//一对一关系
{
	private String title;//书的标题
	private float price;//书的价格
	private Person person;//一本书属于一个人
	
	public Book(String title,float price)
	{
		this.setTitle(title);
		this.setPrice(price);
	}
	
	public void setTitle(String str)
	{
		title = str;
	}
	public void setPrice(float p)
	{
		price = p;
	}
	public String getTitle()
	{
		return title;
	}
	public float getPrice()
	{
		return price;
	}
	
	public void setPerson(Person p)
	{
		person = p;
	}
	public Person getPerson()
	{
		return person;
	}

};

public class JavaYingyongAndChandi
{
	
	public static void fun1(Demo d2)//第一道范例
	{
		d2.temp = 1000;
	}
	
	public static void fun2(String str2)//第二道范例
	{
		str2 = "word";
	}
	public static void fun3(Demo3 d3)//第三道范例
	{
		d3.str3 = "MLDN";
	}
	
	public static void main(String[] args)
	{
		/* //第一道范例
		Demo d1 = new Demo();//实例化Demo对象，里面的temp=30
		d1.temp = 50;//修改temp属性的内容
		System.out.println("fun1()方法调用前，temp的值为："+d1.temp);
		fun1(d1);
		System.out.println("fun1()方法调用之后，temp的值为："+d1.temp);
		*/
		
		/*//第二道范例
		String str1 = "hello";
		System.out.println("fun()2方法调用前的值为："+str1);
		fun2(str1);
		System.out.println("fun()2方法调用之后的值为："+str1);
		*/
		
		/*//第三道范例
		Demo3 d = new Demo3();//实例化Demo对象，里面的temp=30
		d.str3 = "word";//修改temp属性的内容
		System.out.println("fun()3方法调用前，str3的值为："+d.str3);
		fun3(d);
		System.out.println("fun()3方法调用之后，str3的值为："+d.str3);
		*/
		
		//一对一关系
		Person per = new Person("张三",30);
		Book bk = new Book("java教程",80.5f);
		per.setBook(bk);//设置两个对象间的关系，一个人有一本书
		bk.setPerson(per);//设置两个对象间的关系，一本书属于一个人；
		System.out.println("从人找到书，姓名："+per.getName()+",年龄"+per.getAge()+",书名:"+
		                   per.getBook().getTitle()+",价格"+per.getBook().getPrice());//可以通过人找到书
		System.out.println("从书找到人，书名："+bk.getTitle()+",价格："+bk.getPrice()+",姓名："+
		                   bk.getPerson().getName()+",年龄："+bk.getPerson().getAge());//通过书找到所有人
		
		//通过人找到孩子，并找到孩子拥有的书
		Person child = new Person("小张",10);
		Book b = new Book("一千零一夜",100.5f);
		child.setBook(b);//设置对象间的关系，一个孩子有一本书
		per.setChild(child);//设置对象间的关系,一个人有一个孩子
		b.setPerson(child);//设置对象间的关系，一本书属于一个孩子
		
		System.out.println(per.getName()+"的孩子"+",姓名是："+per.getChild().getName()+
							",年龄是："+per.getChild().getAge()+",书名是："+per.getChild().getBook().getTitle()+
							",书的价格是："+per.getChild().getBook().getPrice());
		
		//020509_【第5章：面向对象基础】_this关键字
		
	}

}
