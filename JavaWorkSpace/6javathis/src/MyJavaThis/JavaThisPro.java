package MyJavaThis;

class Person
{
	private String name;
	private int age;
	public Person()
	{
		System.out.println("�¶���ʵ����");
	}
	public Person(String name)
	{
		this();//���ñ����е��޲ҹ��췽����ֻ�ܷ��ڹ��캯�������У���Ҫ��һ������������this���õĹ��췽����
		this.name = name;
		
	}
	public Person(String name,int age)
	{
		this(name);//������һ�������Ĺ��췽����ֻ�ܷ��ڹ��캯�������У���Ҫ��һ������������this���õĹ��췽����
		this.age = age;
	}
	
	public String getInfo()
	{
		return "����:"+name+",����:"+age;
	}
	public boolean compare(Person per)
	{
		//���ô˷���ʱ��������������󣺵�ǰ���󣬴���Ķ���
		Person p1 = this;//��ǰ�Ķ��󣬾ͱ�ʾper1
		Person p2 = per;//���ݽ����Ķ��󣬾ͱ�ʾper2
		if(p1 == p2)//�ж��ǲ���ͬһ�������õ�ַ�Ƚ�
		{
			return true;
		}
		if(p1.name.equals(p2.name) && p1.age==p2.age)//����1 stringʹ�� equal�Ƚϣ�int��ʹ�� == �Ƚ�
		{
			return true;//����������ͬ
		}
		else
		{
			return false;//����������ͬ
		}
	}
	public void setName(String name)//����1
	{
		this.name = name;
	}
	public void setAge(int age)//����1
	{
		this.age = age;
	}
	public String getName()//����1
	{
		return this.name;
	}
	public int getAge()//����1
	{
		return this.age;
	}
	
}
public class JavaThisPro
{

	public static void main(String[] args)
	{
		//Person per = new Person("����",30);//ʹ�� this��������
		//System.out.println(per.getInfo());
		
		//����1
		Person per1 = new Person("����",30);//������������������ȫ
		Person per2 = new Person("����",30);//������������������ȫ
		
		if(per1.compare(per2))
		{
			System.out.println("�����������");
		}
		else
		{
			System.out.println("�����������");
		}
		//020510_����5�£�������������_static�ؼ���
	}

}
