package MyJavaStatic;

class Demo
{
	private String name;
	private static int count = 0;//���ж����������
	public Demo()
	{
		count++;
		System.out.println("������"+count+"������");
	}
	public Demo(String name)
	{
		this.name = name;
	}
}
public class javastaticpro1
{

	public static void main(String[] args)
	{
		//ʹ��static����ͳ��һ���ൽ�ײ����˶��ٸ�ʵ��������
		new Demo();
		new Demo();
		new Demo();

	}

}
