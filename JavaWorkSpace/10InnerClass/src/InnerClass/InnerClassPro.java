package InnerClass;
class Outer
{
	private static String info = "Hello Word";//定义外部类的私有属性
	
	static class Inner//定义内部类
	{
		public void print()//定义内部类的方法
		{
			System.out.println(info);//直接访问外部类的私有属性
		}
		
	}
	
	public void fun()
	{
		new Inner().print();//通过内部类的实例化对象调用方法
		
	}

}
public class InnerClassPro
{

	
	public static void main(String[] args)
	{
		new Outer().fun();//调用外部类的fun()方法
		
		/*
		Outer out = new Outer();// 外部类实例化对象
		Outer.Inner in =out.new Inner();//实例化内部类
		in.print();//调用内部类的方法
		*/
		
		//020516_〖第5章：面向对象基础〗_实例讲解—系统登陆
	}

}
