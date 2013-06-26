package MyJavaStatic;

class Demo
{
	private String name;
	private static int count = 0;//所有对象共享此属性
	public Demo()
	{
		count++;
		System.out.println("产生了"+count+"个对象");
	}
	public Demo(String name)
	{
		this.name = name;
	}
}
public class javastaticpro1
{

	public static void main(String[] args)
	{
		//使用static可以统计一个类到底产生了多少个实例化对象
		new Demo();
		new Demo();
		new Demo();

	}

}
