package InterfacePro;//接口
interface A// 定义接口A
{
	public static final String AUTHOR = "徐";//全局常量
	public abstract void print();//抽象方法
	public abstract String getInfo();//抽象方法
}
//接口的使用中也必须有子类，子类必须覆写全部抽象方法 implements关键字实现，一个子类可以同时实现多个接口

interface B//定义接口B
{
	public void say();
}

class X implements A,B//X类同时实现A和B两个接口
{
	public void say()
	{
		System.out.println("hello");
	}

	
	public void print()
	{
		System.out.println("作者："+AUTHOR);
	}

	public String getInfo()
	{
		
		return "word";
	}
	
};
public class InterfaceProJava
{
	
	public static void main(String[] args)
	{
		X x = new X();//实例化子类对象
		x.say();
		x.print();

	}

}
