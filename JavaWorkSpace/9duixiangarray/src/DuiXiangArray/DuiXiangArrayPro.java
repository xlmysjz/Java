package DuiXiangArray;

class Person
{
	private String name;
	public Person(String name)//���췽����������
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;//ȡ������
	}
}
public class DuiXiangArrayPro
{

	public static void main(String[] args)
	{
		Person per[] = new Person[3];//�����������ռ��С������
		for(int x = 0;x<per.length;x++)
		{
			System.out.print(per[x]+"��");//��Ϊֻ�ǿ��ٺÿռ䣬���Զ���Ĭ��ֵ
		}
		
		System.out.println(" ");
		
		// �ֱ�Ϊ�����е�ÿ��Ԫ�ض�̬��ʼ��
		per[0] = new Person("����");//��̬ʵ����Ԫ��
		per[1] = new Person("����");
		per[2] = new Person("����");
		System.out.println("==========����ʵ����==========");
		for(int x = 0;x<per.length;x++)
		{
			System.out.print(per[x].getName()+"��");
		}
		System.out.println("  ");
		System.out.println(" ---------�ָ���---------\n");
		System.out.println(" �����Ƕ�̬��ʼ���������Ǿ�̬��ʼ��,���ŷ���������\n");
		System.out.println("---------�ָ���---------");
		// ����һ���������飬�������������󣬷ֱ�Ϊ�����е�ÿ��Ԫ�ؾ�̬��ʼ��
		Person per1[] = {new Person("����"),new Person("����"),new Person("����")};
		for(int y = 0;y<per.length;y++)
		{
			System.out.print(per[y].getName()+"��");
		}
		//020515_����5�£�������������_�ڲ���
	}

}
