package InterfacePro;//�ӿ�
interface A// ����ӿ�A
{
	public static final String AUTHOR = "��";//ȫ�ֳ���
	public abstract void print();//���󷽷�
	public abstract String getInfo();//���󷽷�
}
//�ӿڵ�ʹ����Ҳ���������࣬������븲дȫ�����󷽷� implements�ؼ���ʵ�֣�һ���������ͬʱʵ�ֶ���ӿ�

interface B//����ӿ�B
{
	public void say();
}

class X implements A,B//X��ͬʱʵ��A��B�����ӿ�
{
	public void say()
	{
		System.out.println("hello");
	}

	
	public void print()
	{
		System.out.println("���ߣ�"+AUTHOR);
	}

	public String getInfo()
	{
		
		return "word";
	}
	
};
public class InterfaceProJava
{
	
	public static void main(String[] args)
	{
		X x = new X();//ʵ�����������
		x.say();
		x.print();

	}

}
