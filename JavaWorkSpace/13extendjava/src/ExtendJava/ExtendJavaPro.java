package ExtendJava;
class Person//����person��
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

class Student extends Person//����student��
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
		Student stu = new Student();//ʵ�����������
		stu.setName("����");
		stu.setAge(30);
		stu.setSchool("������ѧ");
		System.out.println("����Ϊ��"+stu.getName()+",���䣺"+stu.getAge()+",ѧУ�ǣ�"+stu.getSchool());
		
		//020602_����6�£�������󣨸߼�����_�̳еĽ�һ���о�
		
		

	}

}
