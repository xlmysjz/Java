package JavaTest1;

public class JavaPractice1
{

	public static int add(int x,int y)
	{
		int tem;
		tem = x+y;
		return tem;
	}
	public static int add(int x,int y,int z)
	{
		int tem;
		tem = x+y+z;
		return tem;
	}
	public static void main(String[] args)
	{
		/*
		int max = 0;
		int x = 4;
		int y = 9;
		max = x>y ? x:y;
		System.out.println("最大值为："+max);
		*/
		//49
		/*
		int x = 1;
		int sum = 0;
		while(x<=100)
		{
			sum = sum+x;
			x++;
			
		}
		System.out.println(sum);
		*/
		//60
		/*
		for(int i=1;i<=9;i++)
		{
			for(int y=1;y<=i;y++)
			{
				System.out.print(i+"*"+y+"="+(i*y)+"\t");
			}
			System.out.println();

		}*/
		/*
		int arry[] = new int[3];
		for(int i = 0;i<3;i++)
		{
			arry[i] = i*2+1;
		}
		for(int i=0;i<3;i++)
		{
			System.out.println(arry[i]);
		}*/
		//65
		
		/*
		int score[]  = {34,56,6,89,100,456};
		int max = 0;
		int min = 0;
		max = score[0];
		min = score[0];
		for(int i = 0;i<score.length;i++)
		{
			if(score[i]>max)
			{
				max = score[i];
			}
			if(score[i]<min)
			{
				min = score[i];
			}
		}
		System.out.println("数组里最大的数为："+max);
		System.out.println("数组里最小的数为："+min);
		*/
		/*
		int a[] = {6,23,546,88,333,666,890}; //数组按照从小到大排序
		int tem = 0;
		for(int i = 1;i<a.length;i++)
		{
			for(int y = 0;y<a.length;y++)
			{
				if(a[i]<a[y])
				{
					tem = a[i];
					a[i] = a[y];
					a[y] = tem;
				}
			}

		}
		for(int c = 0;c<a.length;c++)
		{
			System.out.print(a[c]+"\t");
		}
		*/
		/*
		int one = add(5,6);
		int two = add(7,8,9);
		System.out.println(one);
		System.out.println(two);
		*/
		int a[] ={0,1,2,3,4,5,6};
		int b[] = {7,8,9,10,11,12,13,14,15,16};
		System.arraycopy(a, 2, b, 3, 5);
		for(int i = 0;i<b.length;i++)
		{
			System.out.print(b[i]+"\t");
		}

	}

}
