package MyYingyongAndChandi;
class Demo
{
	int temp = 30;//��һ������
	
}
class Demo3
{
	String str3 = "hello";//����������
}

class Person//һ��һ��ϵ
{
	private String name;//�˵�����
	private int age;//�˵�����
	private Book book;//һ������һ����
	
	private Person child;//��һ���һ��һ��ϵ��һ������һ����
	
	public Person(String name,int age)
	{
		this.setName(name);
		this.setAge(age);
	}
	
	public void setName(String n)
	{
		name = n;
	}
	public void setAge(int a)
	{
		age = a;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	
	public void setBook(Book b)
	{
		book = b;
	}
	
	public Book getBook()
	{
		return book;
	}
	
	public void setChild(Person c)//��һ������һ��һ��ϵ
	{
		child = c;
	}
	public Person getChild()
	{
		return child;
	}
	
};
class Book//һ��һ��ϵ
{
	private String title;//��ı���
	private float price;//��ļ۸�
	private Person person;//һ��������һ����
	
	public Book(String title,float price)
	{
		this.setTitle(title);
		this.setPrice(price);
	}
	
	public void setTitle(String str)
	{
		title = str;
	}
	public void setPrice(float p)
	{
		price = p;
	}
	public String getTitle()
	{
		return title;
	}
	public float getPrice()
	{
		return price;
	}
	
	public void setPerson(Person p)
	{
		person = p;
	}
	public Person getPerson()
	{
		return person;
	}

};

public class JavaYingyongAndChandi
{
	
	public static void fun1(Demo d2)//��һ������
	{
		d2.temp = 1000;
	}
	
	public static void fun2(String str2)//�ڶ�������
	{
		str2 = "word";
	}
	public static void fun3(Demo3 d3)//����������
	{
		d3.str3 = "MLDN";
	}
	
	public static void main(String[] args)
	{
		/* //��һ������
		Demo d1 = new Demo();//ʵ����Demo���������temp=30
		d1.temp = 50;//�޸�temp���Ե�����
		System.out.println("fun1()��������ǰ��temp��ֵΪ��"+d1.temp);
		fun1(d1);
		System.out.println("fun1()��������֮��temp��ֵΪ��"+d1.temp);
		*/
		
		/*//�ڶ�������
		String str1 = "hello";
		System.out.println("fun()2��������ǰ��ֵΪ��"+str1);
		fun2(str1);
		System.out.println("fun()2��������֮���ֵΪ��"+str1);
		*/
		
		/*//����������
		Demo3 d = new Demo3();//ʵ����Demo���������temp=30
		d.str3 = "word";//�޸�temp���Ե�����
		System.out.println("fun()3��������ǰ��str3��ֵΪ��"+d.str3);
		fun3(d);
		System.out.println("fun()3��������֮��str3��ֵΪ��"+d.str3);
		*/
		
		//һ��һ��ϵ
		Person per = new Person("����",30);
		Book bk = new Book("java�̳�",80.5f);
		per.setBook(bk);//�������������Ĺ�ϵ��һ������һ����
		bk.setPerson(per);//�������������Ĺ�ϵ��һ��������һ���ˣ�
		System.out.println("�����ҵ��飬������"+per.getName()+",����"+per.getAge()+",����:"+
		                   per.getBook().getTitle()+",�۸�"+per.getBook().getPrice());//����ͨ�����ҵ���
		System.out.println("�����ҵ��ˣ�������"+bk.getTitle()+",�۸�"+bk.getPrice()+",������"+
		                   bk.getPerson().getName()+",���䣺"+bk.getPerson().getAge());//ͨ�����ҵ�������
		
		//ͨ�����ҵ����ӣ����ҵ�����ӵ�е���
		Person child = new Person("С��",10);
		Book b = new Book("һǧ��һҹ",100.5f);
		child.setBook(b);//���ö����Ĺ�ϵ��һ��������һ����
		per.setChild(child);//���ö����Ĺ�ϵ,һ������һ������
		b.setPerson(child);//���ö����Ĺ�ϵ��һ��������һ������
		
		System.out.println(per.getName()+"�ĺ���"+",�����ǣ�"+per.getChild().getName()+
							",�����ǣ�"+per.getChild().getAge()+",�����ǣ�"+per.getChild().getBook().getTitle()+
							",��ļ۸��ǣ�"+per.getChild().getBook().getPrice());
		
		//020509_����5�£�������������_this�ؼ���
		
	}

}
