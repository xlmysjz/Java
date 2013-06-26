package MyJavaThis;

class Person
{
	private String name;
	private int age;
	public Person()
	{
		System.out.println("新对象实例化");
	}
	public Person(String name)
	{
		this();//调用本类中的无惨构造方法（只能放在构造函数的首行，还要有一个构造类中无this调用的构造方法）
		this.name = name;
		
	}
	public Person(String name,int age)
	{
		this(name);//调用有一个参数的构造方法（只能放在构造函数的首行，还要有一个构造类中无this调用的构造方法）
		this.age = age;
	}
	
	public String getInfo()
	{
		return "姓名:"+name+",年龄:"+age;
	}
	public boolean compare(Person per)
	{
		//调用此方法时里面存在两个对象：当前对象，传入的对象
		Person p1 = this;//当前的对象，就表示per1
		Person p2 = per;//传递进来的对象，就表示per2
		if(p1 == p2)//判断是不是同一个对象，用地址比较
		{
			return true;
		}
		if(p1.name.equals(p2.name) && p1.age==p2.age)//范例1 string使用 equal比较，int型使用 == 比较
		{
			return true;//两个对象相同
		}
		else
		{
			return false;//两个对象不相同
		}
	}
	public void setName(String name)//范例1
	{
		this.name = name;
	}
	public void setAge(int age)//范例1
	{
		this.age = age;
	}
	public String getName()//范例1
	{
		return this.name;
	}
	public int getAge()//范例1
	{
		return this.age;
	}
	
}
public class JavaThisPro
{

	public static void main(String[] args)
	{
		//Person per = new Person("张三",30);//使用 this（）调用
		//System.out.println(per.getInfo());
		
		//范例1
		Person per1 = new Person("李四",30);//声明两个对象，内容完全
		Person per2 = new Person("李四",30);//声明两个对象，内容完全
		
		if(per1.compare(per2))
		{
			System.out.println("两个对象相等");
		}
		else
		{
			System.out.println("两个对象不相等");
		}
		//020510_【第5章：面向对象基础】_static关键字
	}

}
