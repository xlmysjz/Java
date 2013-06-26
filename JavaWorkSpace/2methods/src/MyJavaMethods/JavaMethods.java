package MyJavaMethods;

public class JavaMethods
{

	public static void printInfo()//void 没有返回值
	{
		char c[] = {'H','e','l','l','w','o','r','d'};
		for(int i = 0;i<c.length;i++)
		{
			System.out.print(c[i]);
		}
	}
	
	public static int addOne(int x,int y)//有返回值 //调用方法
	{
		int sum=0;
		sum = x+y;
		return sum;
	}
	public static float addTwo(float x,float y)//有返回值 //调用方法
	{
		float sum = 0f;
		sum = x+y;
		return sum;
	}
	
	public static int add(int x,int y)//方法重载
	{
		int sum=0;
		sum = x+y;
		return sum;
	}
	public static int add(int x,int y,int z)//方法重载
	{
		int sum=0;
		sum = x+y+z;
		return sum;
	}
	public static float add(float x,float y)//方法重载
	{
		float sum = 0f;
		sum = x+y;
		return sum;
	}
	
	public static int sum(int num)//递归操作
	{
		if(num == 1)
		{
			return 1;
			
		}
		else
		{
			return num+sum(num-1);
		}
	}
	
	public static void fun(int x[])//接收打印数组
	{
		x[0] = 6;//修改数组中的元素
	}
	
	public static void print(int x[])//接收打印数组 //数组引用传递
	{
		for(int i = 0;i<x.length;i++)
		{
			System.out.print(x[i]+"、");
		}
	}
	public static  int[] fun1()//返回一个数组 //数组引用传递
	{
		int ss[] = {1,2,4,5,6};
		return ss;
	}
	
	//例子1 排序
	public static void sort(int temp[])
	{
		for(int i = 0;i<temp.length;i++)
		{
			for(int j = 0;j<temp.length;j++)
			{
				if(temp[i]<temp[j])
				{
					int x = temp[i];
					temp[i] = temp[j];
					temp[j] = x;
				}
			}
		}
	}
	public static void print1(int temp[])//打印例子1数组内容
	{
		for(int i = 0;i<temp.length;i++)
		{
			System.out.print(temp[i]+"\t");
		}
	}
	
	public static void copy(int s[],int s1,int r[],int s2,int len)//例子2 数组拷贝
	{//参数分别表示：源数组名称，源数组开始点，目标组名称，目标数组开始点，拷贝长度
		for(int i = 0;i<len;i++)
		{
			r[s2+i] = s[s1+i];
		}
	}
	
	public static void fun2(int ... arg)//可变参数和foreach
	{//所有的可变参数接受之后都是以数组的形式保存下来的，所以直接按照数组的形式接手即可
		for(int i : arg)//也可以写成：for(int i = 0;i<arg.length;i++)
		{
			System.out.print(i+"、");//也可以写成arg[i]+"、"
		}
		
	}
	
	public static void main(String[] args)
	{
		//printInfo();
		
		/*//调用方法
		int one = addOne(10,20);
		float two = addTwo(10.3f,12.3f);
		System.out.println("addOne的计算结果为："+one);
		System.out.println("addTwo的计算结果为："+two);
		*/
		
		/*//方法重载
		int one = add(10,20);
		float two = add(10.3f,12.3f);
		int three = add(4,5,6);
		System.out.println("add的计算结果为："+one);
		System.out.println("add的计算结果为："+two);
		System.out.println("add的计算结果为："+three);
		*/
		
		//递归操作
		//System.out.println("计算结果："+sum(100));
		
		//010403_【第4章：数组与方法】_数组的引用传递
		/*
		int temp[] = {1,3,5};//接收打印数组
		fun(temp);
		for(int i = 0;i<temp.length;i++)
		{
			System.out.print(temp[i]+"、");
		}
		*/
		
		/*
		int tem1[] = fun1();//通过方法实例化数组 //数组引用传递
		print(tem1);//数组引用传递
		*/
		
		/*
		//例子1 排序
		int score[] = {2,44,55,63,1};
		int age[] = {34,43,22,11,56};
		sort(score);//排序
		print1(score);//打印数组
		System.out.println("\n---------------");
		sort(age);//排序
		print1(age);//打印数组
		
		System.out.println("\n---------------");
		java.util.Arrays.sort(score);//这个语句是java里自带的排序
		print1(age);//打印数组
		*/
		
		/*
		//例子2 数组拷贝
		int t1[] = {1,2,3,4,5};
		int t2[] = {11,3,44,6,78,55,4,33,3,45,33,2,11,68};
		copy(t1,2,t2,4,3);//调用拷贝方法
		print(t2);
		System.out.println("\n---------------");
		System.arraycopy(t1, 1, t2, 1, 3);//这个语句是java里自带的拷贝方法
		print(t2);
		*/
		//010404_【第4章：数组与方法】_Java新特性对数组的支持
		
		
		System.out.print("不传递参数 fun2():");//可变参数 //foreach输出
		fun2();//没有传递参数
		System.out.print("\n现在传递参数 fun2(1):");
		fun2(1);//传递参数
		System.out.print("\n传递五个参数 fun2(1,2,3,4,5):");
		fun2(1,2,3,4,5);
		

		
	}

}
