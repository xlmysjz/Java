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

class Operate//����ֻ�ǵ��þ������֤�Ĳ���
{
	private String info[];//����һ���������ԣ�������֤ȫ������
	public Operate(String info[])
	{
		this.info = info;//ͨ�����췽��ȡ��ȫ��������
	}
	
	public String login()
	{
		Check check = new Check();//ʵ����Check�������ڼ����Ϣ
		this.isExit();//�ж�����Ĳ����Ƿ���ȷ
		String str = null;
		String name = this.info[0];//ȡ������
		String password = this.info[1];//ȡ������
		if(check.validate(name, password))//��¼��֤
		{
			str = "��ӭ"+name+"����";
		}
		else
		{
			str = "�û��������벻��ȷ";
		}
		return str;
		
	}
	public void isExit()
	{
		if(this.info.length !=2)
		{
			System.out.println("����Ĳ�������ȷ��ϵͳ�˳�");
			System.out.println("��ʽ��java loginDemo �û��� ����");
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
		//020517_����5�£�������������_ʵ�����⡪��������1��

	}

}
