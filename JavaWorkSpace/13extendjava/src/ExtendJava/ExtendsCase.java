package ExtendJava;
class Array
{
	private int temp[];//整形数组
	private int foot;//定义添加位置
	public Array(int len)
	{
		if(len>0)
		{
			this.temp = new int[len];
		}
		else
		{
			this.temp = new int[1];//最少维持空间是1
		}
		
	}
	public boolean add(int i)//增加元素
	{
		if(this.foot<this.temp.length)//还有空间
		{
			this.temp[foot] = i;//增加元素
			this.foot++;//修改脚标
			return true;
		}
		else
		{
			return false;
		}
	}
	public int[] getArray()
	{
		return this.temp;
	}

};

class SortArray extends Array//排序类
{
	public SortArray(int len)
	{
		super(len);
	}
	public int[] getArrat()
	{
		java.util.Arrays.sort(super.getArray());//排序操作
		return super.getArray();
	}
}

class ReverseArray extends Array//反转操作类
{
	public ReverseArray(int len)
	{
		super(len);
	}
	public int[] getArray()
	{
		int t[] = new int[super.getArray().length];//开辟一个新的数组
		int count = t.length-1;
		for(int x = 0;x<t.length;x++)
		{
			t[count] = super.getArray()[x];//数组反转
			count--;
		}
		return t;
	}
}
public class ExtendsCase
{
	public static void print(int i[])
	{
		for(int x = 0;x<i.length;x++)
		{
			System.out.print(i[x]+"、");
		}
	}
	
	public static void main(String[] args)
	{
		ReverseArray a = new ReverseArray(5);//开辟5个空间大小
		System.out.print(a.add(34)+"\t");
		System.out.print(a.add(6)+"\t");
		System.out.print(a.add(55)+"\t");
		System.out.print(a.add(47)+"\t");
		System.out.print(a.add(3)+"\t");
		System.out.print(a.add(30)+"\t");
		
		print(a.getArray());
		
		System.out.println(" ");
		//020605_【第6章：面向对象（高级）】_抽象类的基本概念
	}

}
