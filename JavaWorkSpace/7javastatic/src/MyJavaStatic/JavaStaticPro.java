package MyJavaStatic;

class Person
{
	private String name;
	private int age;
	private static String country = "A��";//ʹ��static�����������
	
	public static void setCountry(String c)//ʹ��static �����ʹ�������� Persongֱ�ӵ���
	{
		country = c;
	}
	public static String getCountry()
	{
		return country;
	}
	public Person(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	public void info()
	{
		System.out.println("������"+this.name+",���䣺"+this.age+",����"+country);
	}
}
public class JavaStaticPro
{

	public static void main(String[] args)
	{
		Person p1 = new Person("����",30);
		Person p2 = new Person("����",20);
		Person p3 = new Person("����",18);
		System.out.println("�����޸�֮ǰ");
		p1.info();
		p2.info();
		p3.info();
			
		System.out.println("�����޸�֮��");
		Person.setCountry("B��") ;//p1.setCountry("B��");Ҳ���ԣ��������ʹ�� ��һ��//���þ�̬�����޸�static��������
		p1.info();//�޸�һ�������country���ԣ������������country��������ȫ���ı䣬֤�������������ж�����ġ�
		p2.info();
		p3.info();
		//ע�⣺ʹ��static���������ܵ��÷�static�����Ի򷽷�
		
	}

}
