package InterfacePro;
//接口中的抽象方法可以不加人 abstract ，而抽象类中的抽象方法必须有abstract关键字
//一个类只能继承一个父类，但是可以同时实现多个接口
//一个接口可以同时继承多个接口，以实现接口的多继承
//接口和抽象类一样，都必须依靠子类
//一个抽象类可以实现多个接口，但是一个接口不能继承一个抽象类
interface A1// 定义接口A
{
	public static final String AUTHOR = "徐";//全局常量
	public  abstract void printA();//抽象方法
}

interface B1// 定义接口A
{
	public  void printB();//抽象方法
}

interface C1 extends A1,B1//一个接口可以同时继承多个接口
{
	public void printC();
}

class X1 implements C1
{


	public void printA()
	{
		System.out.println("A hello");
		
	}
	
	public void printB()
	{
		System.out.println("B haha");
		
	}
	
	public void printC()
	{
		System.out.println("C wowo");
		
	}

}

public class myinterfacepro
{

	public static void main(String[] args)
	{
		X1 x1 = new X1();//实例化子类对象
		x1.printA();
		x1.printB();
		x1.printC();
		
		//020607_【第6章：面向对象（高级）】_对象的多态性
	}

}
