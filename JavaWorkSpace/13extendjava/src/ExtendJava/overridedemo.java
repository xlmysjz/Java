package ExtendJava;

class Person1//����person��
{
	void print()
	{
		System.out.println("Person-->void print()");
	}
};

class Student1 extends Person1
{
	public void print()//��д�� �����е�print����
	{
		super.print();//��˵��Ҫ�Ӹ����в���print
		System.out.println("Student-->void print()");
	}
}
public class overridedemo
{

	
	public static void main(String[] args)
	{
		Student1 s = new Student1();
		s.print();
		//020603_����6�£�������󣨸߼�����_�������̳е�Ӧ��
	}

}
