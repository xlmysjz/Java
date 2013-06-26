package AbstractPro;

import java.util.Random;
//接口中的抽象方法可以不加人 abstract ，而抽象类中的抽象方法必须有abstract关键字

abstract class A
{
	public static final String FLAG="xu";//全局常量
	private String name="徐";//定义一个普通的属性
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	public abstract void print();//定义抽象方法
};
class B extends A //抽象类必须有子类，子类必须覆写抽象类的全部抽象方法
{
	public void print()
	{
		System.out.println("FLAG = "+FLAG);
		System.out.println("姓名 = "+super.getName());
	}

}

public class AbstractJava
{
	
	public static void main(String[] args)
	{
		B b = new B();
		b.print();
		//020609_【第6章：面向对象（高级）】_抽象类与接口的应用

		
		
	}

}
