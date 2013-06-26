package GouZhaoPrivate;

class Singleton
{
	private static Singleton instance = new Singleton();//进行私有化的构造方法，能在内部产生本类的实例化对象
	public static Singleton getInstance()
	{
		return instance;
	}
	private Singleton()//将构造方法进行私有化封装
	{
			
	}
	public void print()
	{
		System.out.println("hello word");
	}
}

public class JavaGouZhaoPrivate
{

	
	public static void main(String[] args)
	{
		//Singleton s1 = new Singleton();//错误，被私有化构造方法的 Singleton类，不能再外部直接实例化
		Singleton s2 = null;
		s2 = Singleton.getInstance();//取得实例化对象
		s2.print();//调用方法
		//020514_【第5章：面向对象基础】_对象数组
		
		
	}

}
