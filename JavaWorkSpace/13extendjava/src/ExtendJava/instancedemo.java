package ExtendJava;
class MyPerson//定义person类
{
	private String name;
	private int age;
	public MyPerson()
	{
		System.out.println("父类Person中的构造");
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public String getName()
	{
		return this.name;
	}
	public int getAge()
	{
		return this.age;
	}
};

class MyStudent extends MyPerson//定义student类
{
	private String school;
	public MyStudent()
	{
		super();//默认隐藏
		System.out.println("子类Student中的构造");
	}
	public void setSchool(String school)
	{
		this.school = school;
	}
	public String getSchool()
	{
		return this.school;
	}
};
public class instancedemo
{


	public static void main(String[] args)
	{
		MyStudent stu = new MyStudent();//实例化子类对象
		stu.setName("张三");
		stu.setAge(30);
		stu.setSchool("北京大学");
		System.out.println("姓名为："+stu.getName()+",年龄："+stu.getAge()+",学校是："+stu.getSchool());
		
		//020602_【第6章：面向对象（高级）】_继承的进一步研究
		

	}

}
