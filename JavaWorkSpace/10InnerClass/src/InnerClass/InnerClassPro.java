package InnerClass;
class Outer
{
	private static String info = "Hello Word";//�����ⲿ���˽������
	
	static class Inner//�����ڲ���
	{
		public void print()//�����ڲ���ķ���
		{
			System.out.println(info);//ֱ�ӷ����ⲿ���˽������
		}
		
	}
	
	public void fun()
	{
		new Inner().print();//ͨ���ڲ����ʵ����������÷���
		
	}

}
public class InnerClassPro
{

	
	public static void main(String[] args)
	{
		new Outer().fun();//�����ⲿ���fun()����
		
		/*
		Outer out = new Outer();// �ⲿ��ʵ��������
		Outer.Inner in =out.new Inner();//ʵ�����ڲ���
		in.print();//�����ڲ���ķ���
		*/
		
		//020516_����5�£�������������_ʵ�����⡪ϵͳ��½
	}

}
