package MyJava;

public class TestJava
{


	public static void main(String[] args)
	{
		/*
		int num=10;
		num=30;
		System.out.println("num*num为："+num*num);//
		
		int max=Integer.MAX_VALUE;//求出int的最大值
		System.out.println("求出int的最大值："+max);//最大值
		System.out.println("求出int的最大值："+(max+1));//最大值加1变为int的最小值
		System.out.println("求出int的最大值："+((long)max+1));//数据类型转换 int 转换为 long
		*/
		
		/*
		char ch1='a';
		char ch2=97;//通过数字定义字符变量
		System.out.println("ch1="+ch1);
		System.out.println("ch2="+ch2);
		
		char ch3='\"';//字符转义是一个 引号"
		char ch4='\\';//通字符转义为一个\
		System.out.println("ch3="+ch3);
		System.out.println("ch4="+ch4);
		System.out.println("\"helloword!\"");
		*/
		
		/*
		float num=3.0f;//定义一个浮点型变量
		System.out.println("两个小数相乘"+num*num);
		*/
		
		/*
		boolean flag=true;
		System.out.println("falg="+flag);
		*/
		
		/*
		String str="yyy";
		int x=30;
		str=str+x;
		System.out.println("str="+str);
		该看010302_【第3章：Java基础程序设计】_运算符、表达式与语句05:30
		*/
		
		/*// 运算符
		 if(5>2)
		{
			System.out.println("条件成立：5>2");
			
		}
		if(true)
		{
			System.out.println("直接写的 true");
		}
		if((3+6)==(3-6))
		{
			System.out.println("这是不可能成立的");
		} 
		 */
		
		/*// ++ -- 表达式
		int a=3,b=3;
		int x=6,y=6;
		System.out.println("a="+a);
		System.out.println("\t a++="+(a++)+",a="+a);//先计算后自增
		System.out.println("b="+b);
		System.out.println("\t ++b="+(++b)+",b="+b);//先自增后计算
		
		System.out.println("x="+x);
		System.out.println("\t x--="+(x--)+",x="+x);//先计算后自减
		System.out.println("y="+y);
		System.out.println("\t --y="+(--y)+",y="+y);//先自减后计算
		*/
		
		/*
		boolean a = true;
		boolean b = false;
		System.out.println("a || b="+(a || b));
		System.out.println("a | b="+(a | b));
		System.out.println("a && b="+(a && b));
		System.out.println("a & b="+(a & b));
		
		int score = 50;
		if((score<0)||(score>100))
		{
			System.out.println("输入的成绩错误");
		}
		if((score<60)&&(score>49))
		{
			System.out.println("准备补考");
		}
		System.out.println(3+5+4*6+7);
		010303_【第3章：Java基础程序设计】_判断与循环语句
		*/
		
		/*
		//if语句
		int x = 3;
		int y = 10;
		System.out.println("====开始比较====");
		if(x>y)
		{
			System.out.println("x比y大");
		}
		if(x<y)
		{
			System.out.println("x比y小");
		}
		
		System.out.println("====开始完成====");
		
		//if else
		int r = 3;
		if(r%2==1)
		{
			System.out.println("r是奇数");
		}
		else
		{
			System.out.println("r是偶数");
		}
		
		//三目运算符
		int max = 0;
		int u = 3;
		int i = 10;
		max = u>i?u:i;
		System.out.println("最大值为："+max);
		
		
		//if  else if 语句
		int w = 3;
		if(w==1)
		{
			System.out.println("w的值为："+w);
		}
		else if(w==2)
		{
			System.out.println("w的值为："+w);
		}
		else if(w==3)
		{
			System.out.println("w的值为："+w);
		}
		else
		{
			System.out.println("w的值为不是1 2 3中的数字：");
		}
			
		
		
		//switch语句
		int t = 3;
		int y = 6;
		char oper = '+';
		switch(oper)
		{
			case'+':
			{
				System.out.println("t+y="+(t+y));
				break;
			}
			case'-':
			{
				System.out.println("t-y="+(t-y));
				break;
			}
			case'*':
			{
				System.out.println("t*y="+(t*y));
				break;
			}
			case'/':
			{
				System.out.println("t/y="+(t/y));
				break;
			}
			default:
			{
				System.out.println("未知的操作");
				break;
			}
			
		}
		*/
		
		/*
		//while循环
		int x = 1;
		int sum = 0;
		while(x<=10)
		{
			sum +=x;
			x++;
		}
		System.out.println("1-10累加的结果为："+sum);
		
		
		//do while 循环
		
		int x = 1;
		int sum = 0;
		do
		{
			sum = sum+x;
			x++;
		}while(x<=10);
		System.out.println("1-10累加的结果为："+sum);
		
		
		//for循环
		int sum = 0;
		for(int x = 1;x<=10;x++)
		{
			sum = sum+x;
		}
		System.out.println("1-10累加的结果为："+sum);
		
		
		//九九乘法表
		for(int i = 1;i<=9;i++)
		{
			for(int j = 1;j<=i;j++)
			{
				System.out.print(i+"*"+j+"="+(i*j)+"\t");
			}
			System.out.println();
		}
		*/
		
		
		/*//一维数组
		int score[] = null;
		score = new int[3];
		System.out.println("score[0]="+score[0]);
		System.out.println("score[1]="+score[1]);
		System.out.println("score[2]="+score[2]);
		
		for(int i = 0;i<3;i++)
		{
			System.out.println("score["+i+"]="+score[i]);
		}
		//取得数组长度
		int score[] = null;
		score = new int[3];
		System.out.println("数组长度为："+score.length);
		
		
		//数组的静态初始化
		int score[] = {3,4,67,78,99,};
		for(int i = 0;i<score.length;i++)
		{
			System.out.println("score["+i+"]="+score[i]);
		}
		
		//例子1 求出数组中的最大和最小值
		int score[] = {3,44,55,35,54,44,22};
		int max = 0;
		int min = 0;
		max = min = score[0];//把第一个元素的内容赋值给 max 和 min
		for(int x = 0;x<score.length;x++)
		{
			if(score[x]>max)//依次判断后续元素是否比max大
			{
				max=score[x];//如果大，则修改max的内容
			}
			if(score[x]<min)//依次判断后续的元素是否比min小
			{
				min = score[x];//如果小，则修改min的内容
			}
		}
		System.out.println("最大值："+max);
		System.out.println("最小值："+min);
		
		
		//010401_【第4章：数组与方法】_数组的定义及使用30:55
		
		//例子2 排序 ,了解其基本操作
		
		int score[] = {3,44,55,35,54,44,22};
		for(int i = 0;i<score.length;i++)
		{
			for(int j = 0;j<score.length;j++)
			{
				if(score[i]<score[j])//交换位置
				{
					int tem = score[i];
					score[i] = score[j];
					score[j] = tem;
				}
			}
		}
		for(int i = 0;i<score.length;i++)
		{
			System.out.print(score[i]+"\t");
		}
		
		
		//二维数组
		int  score[][] = new int[4][3];//声明并实例化数组
		score[0][1] = 30;
		score[1][0] = 31;
		score[2][2] = 32;
		score[3][1] = 33;
		score[1][1] = 30;
		
		for(int i = 0;i<score.length;i++)
		{
			for(int j = 0;j<score[i].length;j++)
			{
				System.out.print(score[i][j]+"\t");
			}
			System.out.println(" ");
		}
		
		*/
		//010402_【第4章：数组与方法】_方法的声明及使用
		
				
		
		
		
	}

}
