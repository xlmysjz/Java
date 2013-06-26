package SystemLogin;

class Check
{
	public boolean validate(String name,String password)
	{
		if(name.equals("xulmm") && password.equals("cvww"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
};

class Operate//本类只是调用具体的验证的操作
{
	private String info[];//定义一个数组属性，用于验证全部属性
	public Operate(String info[])
	{
		this.info = info;//通过构造方法取得全部的输入
	}
	
	public String login()
	{
		Check check = new Check();//实例化Check对象，用于检查信息
		this.isExit();//判断输入的参数是否正确
		String str = null;
		String name = this.info[0];//取出姓名
		String password = this.info[1];//取出密码
		if(check.validate(name, password))//登录验证
		{
			str = "欢迎"+name+"光临";
		}
		else
		{
			str = "用户名和密码不正确";
		}
		return str;
		
	}
	public void isExit()
	{
		if(this.info.length !=2)
		{
			System.out.println("输入的参数不正确，系统退出");
			System.out.println("格式：java loginDemo 用户名 密码");
			System.exit(1);
		}
	}
};

public class SystemLoginProNew 
{
	public static void main(String[] args) 
	{
		Operate oper = new Operate(args);
		System.out.println(oper.login());
		//020517_〖第5章：面向对象基础〗_实例讲解—单向链表（1）

	}

}
