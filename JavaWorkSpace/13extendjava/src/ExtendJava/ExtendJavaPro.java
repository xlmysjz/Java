package ExtendJava;
class Person//定义person类
{
	private String name;
	private int age;
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

class Student extends Person//定义student类
{
	private String school;
	
	public void setSchool(String school)
	{
		this.school = school;
	}
	public String getSchool()
	{
		return this.school;
	}
};
public class ExtendJavaPro
{

	public static void main(String[] args)
	{
		Student stu = new Student();//实例化子类对象
		stu.setName("张三");
		stu.setAge(30);
		stu.setSchool("北京大学");
		System.out.println("姓名为："+stu.getName()+",年龄："+stu.getAge()+",学校是："+stu.getSchool());
		
		//020602_【第6章：面向对象（高级）】_继承的进一步研究
		
		

	}

}
