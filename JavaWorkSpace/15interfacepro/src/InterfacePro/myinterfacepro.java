package InterfacePro;
//�ӿ��еĳ��󷽷����Բ����� abstract �����������еĳ��󷽷�������abstract�ؼ���
//һ����ֻ�ܼ̳�һ�����࣬���ǿ���ͬʱʵ�ֶ���ӿ�
//һ���ӿڿ���ͬʱ�̳ж���ӿڣ���ʵ�ֽӿڵĶ�̳�
//�ӿںͳ�����һ������������������
//һ�����������ʵ�ֶ���ӿڣ�����һ���ӿڲ��ܼ̳�һ��������
interface A1// ����ӿ�A
{
	public static final String AUTHOR = "��";//ȫ�ֳ���
	public  abstract void printA();//���󷽷�
}

interface B1// ����ӿ�A
{
	public  void printB();//���󷽷�
}

interface C1 extends A1,B1//һ���ӿڿ���ͬʱ�̳ж���ӿ�
{
	public void printC();
}

class X1 implements C1
{


	public void printA()
	{
		System.out.println("A hello");
		
	}
	
	public void printB()
	{
		System.out.println("B haha");
		
	}
	
	public void printC()
	{
		System.out.println("C wowo");
		
	}

}

public class myinterfacepro
{

	public static void main(String[] args)
	{
		X1 x1 = new X1();//ʵ�����������
		x1.printA();
		x1.printB();
		x1.printC();
		
		//020607_����6�£�������󣨸߼�����_����Ķ�̬��
	}

}
