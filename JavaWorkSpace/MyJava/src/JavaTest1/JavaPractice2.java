package JavaTest1;
class Person
{
	private String name;
	private int age;
	public void tell()
	{
		System.out.println("姓名："+name+",年龄："+age);
	}
	public Person(String s,int a)
	{
		this.setAge(a);
		this.setName(s);
	}
	public String getName()
	{
		return name;
	}
	public void  setName(String n)
	{
			name = n;
	}
	
	public int getAge()
	{
		return age;
	}
	public void setAge(int a)
	{
		if(a >= 0 && a < 126)
		{
			age = a;
		}
		//103
	}
}
public class JavaPractice2
{

	
	public static void main(String[] args)
	{
		Person per = new Person("张三",40);
		per.tell();
		//118
		String str1 = "hello word";
		String str2 = "HELLO WORD";
		System.out.println("直接比较："+str1.equals(str2));
		System.out.println("忽略大小写进行比较："+str1.equalsIgnoreCase(str2));
		//127
	}

}
