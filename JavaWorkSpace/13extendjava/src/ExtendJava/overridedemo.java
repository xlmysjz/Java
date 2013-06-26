package ExtendJava;

class Person1//定义person类
{
	void print()
	{
		System.out.println("Person-->void print()");
	}
};

class Student1 extends Person1
{
	public void print()//覆写了 父类中的print方法
	{
		super.print();//是说明要从父类中查找print
		System.out.println("Student-->void print()");
	}
}
public class overridedemo
{

	
	public static void main(String[] args)
	{
		Student1 s = new Student1();
		s.print();
		//020603_【第6章：面向对象（高级）】_范例：继承的应用
	}

}
