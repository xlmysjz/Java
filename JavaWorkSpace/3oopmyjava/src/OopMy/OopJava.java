package OopMy;
class Person
{
	private String name;//��������
	private int    age;//��������
	public Person(String n,int a)//���췽��
	{
		this.name = n;
		this.age  = a;
		System.out.println("����һ�����췽��");
	}
	public void setName(String n)
	{
		name = n;
	}
	public void setAge(int a)
	{
		if(a>=0 && a<150)
		{
			age = a;
		}
		
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	
	public void tell()
	{
		System.out.println("����:"+getName()+"\t"+"����:"+getAge());
	}
};

class Student//����
{
	private String stuno;
	private String name;
	private float math;
	private float english;
	private float computer;
	public Student()//�޲ι��췽��
	{
		
	}
	public Student(String s,String n,float m,float e,float c)
	{
		this.setStuno(s);
		this.setName(n);
		this.setMath(m);
		this.setEnglis(e);
		this.setComputer(c);
	}
	public void setStuno(String s)
	{
		stuno = s;
	}
	public void setName(String n)
	{
		name = n;
	}
	public void setMath(float m)
	{
		math = m;
	}
	public void setEnglis(float e)
	{
		english = e;
	}
	public void setComputer(float c)
	{
		computer = c;
	}
	
	public String getStuno()
	{
		return stuno;
	}
	public String getName()
	{
		return name;
	}
	public float getMath()
	{
		return math;
	}
	public float getEnglis()
	{
		return english;
	}
	public float getComputer()
	{
		return computer;
	}
	public float sum()//����ɼ��ܺ�
	{
		return math+english+computer;
	}
	public float avg()//����ƽ���ɼ�
	{
		return this.sum()/3;
	}
	public float max()//�����߳ɼ�
	{
		float max = math;//����ֱ����math��һ��
		max = max>computer?max:computer;//��ѧ�ͼ�����ɼ��ĸ��߷����ĸ�
		max = max>english?max:english;//�����Ѿ�ȡ������ѧ����������߳ɼ��ٸ�Ӣ���	
		
		return max;
	}
	public float min()//�����ͳɼ�
	{
		float min = math;
		min = min<computer?min:computer;//��ѧ�ͼ�����ɼ��ĸ��ͷ����ĸ�
		min = min<english?min:english;//�����Ѿ�ȡ������ѧ����������min�ɼ��ٸ�Ӣ���	
		
		return min;
	}
};

public class OopJava
{

	public static void main(String[] args)
	{
		
		/*
		Person per = new Person("����",50);

		per.tell();
		*/
		
		Student stu = new Student("s_001","����",90.5f,89.5f,98.0f);
		System.out.println("ѧ�����Ϊ��"+stu.getStuno());
		System.out.println("ѧ������Ϊ��"+stu.getName());
		System.out.println("��ѧ�ɼ�Ϊ��"+stu.getMath());
		System.out.println("Ӣ��ɼ�Ϊ��"+stu.getEnglis());
		System.out.println("������ɼ�Ϊ��"+stu.getComputer());
		System.out.println("�����ܺ�Ϊ��"+stu.sum());
		System.out.println("ƽ���ɼ�Ϊ��"+stu.avg());
		System.out.println("��ѧ����߳ɼ�Ϊ��"+stu.max());
		System.out.println("��ѧ����ͳɼ�Ϊ��"+stu.min());
		
		
		//020506_����5�£�������������_String��
		
	}

}
