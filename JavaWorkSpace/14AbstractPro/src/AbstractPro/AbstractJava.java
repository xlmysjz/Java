package AbstractPro;

import java.util.Random;
//�ӿ��еĳ��󷽷����Բ����� abstract �����������еĳ��󷽷�������abstract�ؼ���

abstract class A
{
	public static final String FLAG="xu";//ȫ�ֳ���
	private String name="��";//����һ����ͨ������
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	public abstract void print();//������󷽷�
};
class B extends A //��������������࣬������븲д�������ȫ�����󷽷�
{
	public void print()
	{
		System.out.println("FLAG = "+FLAG);
		System.out.println("���� = "+super.getName());
	}

}

public class AbstractJava
{
	
	public static void main(String[] args)
	{
		B b = new B();
		b.print();
		//020609_����6�£�������󣨸߼�����_��������ӿڵ�Ӧ��

		
		
	}

}
