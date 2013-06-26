package DuiXiangArray;

class Person
{
	private String name;
	public Person(String name)//构造方法设置内容
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;//取得姓名
	}
}
public class DuiXiangArrayPro
{

	public static void main(String[] args)
	{
		Person per[] = new Person[3];//开辟了三个空间大小的数组
		for(int x = 0;x<per.length;x++)
		{
			System.out.print(per[x]+"、");//因为只是开辟好空间，所以都是默认值
		}
		
		System.out.println(" ");
		
		// 分别为数组中的每个元素动态初始化
		per[0] = new Person("张三");//动态实例化元素
		per[1] = new Person("李四");
		per[2] = new Person("王五");
		System.out.println("==========对象实例化==========");
		for(int x = 0;x<per.length;x++)
		{
			System.out.print(per[x].getName()+"、");
		}
		System.out.println("  ");
		System.out.println(" ---------分割线---------\n");
		System.out.println(" 上面是动态初始化，下面是静态初始化,两张方法都可以\n");
		System.out.println("---------分割线---------");
		// 声明一个对象数组，里面有三个对象，分别为数组中的每个元素静态初始化
		Person per1[] = {new Person("张三"),new Person("李四"),new Person("王五")};
		for(int y = 0;y<per.length;y++)
		{
			System.out.print(per[y].getName()+"、");
		}
		//020515_【第5章：面向对象基础】_内部类
	}

}
