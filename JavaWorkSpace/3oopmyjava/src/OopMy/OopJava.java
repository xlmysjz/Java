package OopMy;
class Person
{
	private String name;//姓名属性
	private int    age;//年龄属性
	public Person(String n,int a)//构造方法
	{
		this.name = n;
		this.age  = a;
		System.out.println("这是一个构造方法");
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
		System.out.println("姓名:"+getName()+"\t"+"年龄:"+getAge());
	}
};

class Student//例子
{
	private String stuno;
	private String name;
	private float math;
	private float english;
	private float computer;
	public Student()//无参构造方法
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
	public float sum()//计算成绩总和
	{
		return math+english+computer;
	}
	public float avg()//计算平均成绩
	{
		return this.sum()/3;
	}
	public float max()//求出最高成绩
	{
		float max = math;//这里直接用math试一下
		max = max>computer?max:computer;//数学和计算机成绩哪个高返回哪个
		max = max>english?max:english;//上面已经取出了数学或计算机的最高成绩再跟英语比	
		
		return max;
	}
	public float min()//求出最低成绩
	{
		float min = math;
		min = min<computer?min:computer;//数学和计算机成绩哪个低返回哪个
		min = min<english?min:english;//上面已经取出了数学或计算机的最min成绩再跟英语比	
		
		return min;
	}
};

public class OopJava
{

	public static void main(String[] args)
	{
		
		/*
		Person per = new Person("张三",50);

		per.tell();
		*/
		
		Student stu = new Student("s_001","王五",90.5f,89.5f,98.0f);
		System.out.println("学生编号为："+stu.getStuno());
		System.out.println("学生姓名为："+stu.getName());
		System.out.println("数学成绩为："+stu.getMath());
		System.out.println("英语成绩为："+stu.getEnglis());
		System.out.println("计算机成绩为："+stu.getComputer());
		System.out.println("分数总和为："+stu.sum());
		System.out.println("平均成绩为："+stu.avg());
		System.out.println("该学生最高成绩为："+stu.max());
		System.out.println("该学生最低成绩为："+stu.min());
		
		
		//020506_【第5章：面向对象基础】_String类
		
	}

}
