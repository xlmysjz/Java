package MyJavaMethods;

public class JavaMethods
{

	public static void printInfo()//void û�з���ֵ
	{
		char c[] = {'H','e','l','l','w','o','r','d'};
		for(int i = 0;i<c.length;i++)
		{
			System.out.print(c[i]);
		}
	}
	
	public static int addOne(int x,int y)//�з���ֵ //���÷���
	{
		int sum=0;
		sum = x+y;
		return sum;
	}
	public static float addTwo(float x,float y)//�з���ֵ //���÷���
	{
		float sum = 0f;
		sum = x+y;
		return sum;
	}
	
	public static int add(int x,int y)//��������
	{
		int sum=0;
		sum = x+y;
		return sum;
	}
	public static int add(int x,int y,int z)//��������
	{
		int sum=0;
		sum = x+y+z;
		return sum;
	}
	public static float add(float x,float y)//��������
	{
		float sum = 0f;
		sum = x+y;
		return sum;
	}
	
	public static int sum(int num)//�ݹ����
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
	
	public static void fun(int x[])//���մ�ӡ����
	{
		x[0] = 6;//�޸������е�Ԫ��
	}
	
	public static void print(int x[])//���մ�ӡ���� //�������ô���
	{
		for(int i = 0;i<x.length;i++)
		{
			System.out.print(x[i]+"��");
		}
	}
	public static  int[] fun1()//����һ������ //�������ô���
	{
		int ss[] = {1,2,4,5,6};
		return ss;
	}
	
	//����1 ����
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
	public static void print1(int temp[])//��ӡ����1��������
	{
		for(int i = 0;i<temp.length;i++)
		{
			System.out.print(temp[i]+"\t");
		}
	}
	
	public static void copy(int s[],int s1,int r[],int s2,int len)//����2 ���鿽��
	{//�����ֱ��ʾ��Դ�������ƣ�Դ���鿪ʼ�㣬Ŀ�������ƣ�Ŀ�����鿪ʼ�㣬��������
		for(int i = 0;i<len;i++)
		{
			r[s2+i] = s[s1+i];
		}
	}
	
	public static void fun2(int ... arg)//�ɱ������foreach
	{//���еĿɱ��������֮�������������ʽ���������ģ�����ֱ�Ӱ����������ʽ���ּ���
		for(int i : arg)//Ҳ����д�ɣ�for(int i = 0;i<arg.length;i++)
		{
			System.out.print(i+"��");//Ҳ����д��arg[i]+"��"
		}
		
	}
	
	public static void main(String[] args)
	{
		//printInfo();
		
		/*//���÷���
		int one = addOne(10,20);
		float two = addTwo(10.3f,12.3f);
		System.out.println("addOne�ļ�����Ϊ��"+one);
		System.out.println("addTwo�ļ�����Ϊ��"+two);
		*/
		
		/*//��������
		int one = add(10,20);
		float two = add(10.3f,12.3f);
		int three = add(4,5,6);
		System.out.println("add�ļ�����Ϊ��"+one);
		System.out.println("add�ļ�����Ϊ��"+two);
		System.out.println("add�ļ�����Ϊ��"+three);
		*/
		
		//�ݹ����
		//System.out.println("��������"+sum(100));
		
		//010403_����4�£������뷽����_��������ô���
		/*
		int temp[] = {1,3,5};//���մ�ӡ����
		fun(temp);
		for(int i = 0;i<temp.length;i++)
		{
			System.out.print(temp[i]+"��");
		}
		*/
		
		/*
		int tem1[] = fun1();//ͨ������ʵ�������� //�������ô���
		print(tem1);//�������ô���
		*/
		
		/*
		//����1 ����
		int score[] = {2,44,55,63,1};
		int age[] = {34,43,22,11,56};
		sort(score);//����
		print1(score);//��ӡ����
		System.out.println("\n---------------");
		sort(age);//����
		print1(age);//��ӡ����
		
		System.out.println("\n---------------");
		java.util.Arrays.sort(score);//��������java���Դ�������
		print1(age);//��ӡ����
		*/
		
		/*
		//����2 ���鿽��
		int t1[] = {1,2,3,4,5};
		int t2[] = {11,3,44,6,78,55,4,33,3,45,33,2,11,68};
		copy(t1,2,t2,4,3);//���ÿ�������
		print(t2);
		System.out.println("\n---------------");
		System.arraycopy(t1, 1, t2, 1, 3);//��������java���Դ��Ŀ�������
		print(t2);
		*/
		//010404_����4�£������뷽����_Java�����Զ������֧��
		
		
		System.out.print("�����ݲ��� fun2():");//�ɱ���� //foreach���
		fun2();//û�д��ݲ���
		System.out.print("\n���ڴ��ݲ��� fun2(1):");
		fun2(1);//���ݲ���
		System.out.print("\n����������� fun2(1,2,3,4,5):");
		fun2(1,2,3,4,5);
		

		
	}

}
