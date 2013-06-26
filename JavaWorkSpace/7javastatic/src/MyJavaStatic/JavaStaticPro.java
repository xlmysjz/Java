package MyJavaStatic;

class Person
{
	private String name;
	private int age;
	private static String country = "A城";//使用static定义城市属性
	
	public static void setCountry(String c)//使用static 后可以使用类名称 Persong直接调用
	{
		country = c;
	}
	public static String getCountry()
	{
		return country;
	}
	public Person(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	public void info()
	{
		System.out.println("姓名："+this.name+",年龄："+this.age+",城市"+country);
	}
}
public class JavaStaticPro
{

	public static void main(String[] args)
	{
		Person p1 = new Person("张三",30);
		Person p2 = new Person("李四",20);
		Person p3 = new Person("王五",18);
		System.out.println("城市修改之前");
		p1.info();
		p2.info();
		p3.info();
			
		System.out.println("城市修改之后");
		Person.setCountry("B城") ;//p1.setCountry("B城");也可以，但是最好使用 第一种//调用静态方法修改static属性内容
		p1.info();//修改一个对象的country属性，则其他对象的country属性内容全部改变，证明此属性是所有对象共享的。
		p2.info();
		p3.info();
		//注意：使用static方法，不能调用非static的属性或方法
		
	}

}
