package GouZhaoPrivate;

class Singleton
{
	private static Singleton instance = new Singleton();//����˽�л��Ĺ��췽���������ڲ����������ʵ��������
	public static Singleton getInstance()
	{
		return instance;
	}
	private Singleton()//�����췽������˽�л���װ
	{
			
	}
	public void print()
	{
		System.out.println("hello word");
	}
}

public class JavaGouZhaoPrivate
{

	
	public static void main(String[] args)
	{
		//Singleton s1 = new Singleton();//���󣬱�˽�л����췽���� Singleton�࣬�������ⲿֱ��ʵ����
		Singleton s2 = null;
		s2 = Singleton.getInstance();//ȡ��ʵ��������
		s2.print();//���÷���
		//020514_����5�£�������������_��������
		
		
	}

}
