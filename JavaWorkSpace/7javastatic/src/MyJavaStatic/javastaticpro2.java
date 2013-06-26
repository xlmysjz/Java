package MyJavaStatic;

class Demo1
{
	private String name;
	private static int count = 0;//所有对象共享此属性
	public Demo1()
	{
		count++;//对象产生就自增
		this.name = "Demo1:"+count;//自动进行编号
	}
	public Demo1(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
}

public class javastaticpro2
{

	public static void main(String[] args)
	{
		System.out.println(new Demo1().getName());
		System.out.println(new Demo1("xx").getName());
		System.out.println(new Demo1().getName());
		System.out.println(new Demo1("ll").getName());
		System.out.println(new Demo1().getName());
		//020513_【第5章：面向对象基础】_构造方法私有化
	}

}
