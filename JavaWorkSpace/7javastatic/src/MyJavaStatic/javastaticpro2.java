package MyJavaStatic;

class Demo1
{
	private String name;
	private static int count = 0;//���ж����������
	public Demo1()
	{
		count++;//�������������
		this.name = "Demo1:"+count;//�Զ����б��
	}
	public Demo1(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
}

public class javastaticpro2
{

	public static void main(String[] args)
	{
		System.out.println(new Demo1().getName());
		System.out.println(new Demo1("xx").getName());
		System.out.println(new Demo1().getName());
		System.out.println(new Demo1("ll").getName());
		System.out.println(new Demo1().getName());
		//020513_����5�£�������������_���췽��˽�л�
	}

}
