package Java_SomeThings;


public class MyJavaSomething
{
	

	public static void main(String[] args)
	{
		/*
		String name = "����";//ֱ�Ӹ�ֵ
		System.out.println("�����ǣ�"+name);
		*/
		
		//String name = new String("����");//ʵ����string
		//System.out.println("�����ǣ�"+name);
		
		/*
		//�Ƚ����� string �Ƿ����
		String str1 = "hello";//ֱ�Ӹ�ֵ
		String str2 = new String("hello");//ͨ��newʵ������ֵ
		String str3 = str2;//��������
		
		System.out.println("str1����str2��"+(str1 == str2));//�жϵ��ǵ�ַ�ռ��Ƿ����
		System.out.println("str1����str3��"+(str1 == str3));//�жϵ��ǵ�ַ�ռ��Ƿ����
		System.out.println("str2����str3��"+(str2 == str3));//�жϵ��ǵ�ַ�ռ��Ƿ����
		
		System.out.println("str1 equals str2��"+(str1.equals(str2)));//�ж����ַ�����Ƿ����ʹ�� equals
		System.out.println("str1 equals str3��"+(str1.equals(str3)));//�ж����ַ�����Ƿ����ʹ�� equals
		System.out.println("str2 equals str3��"+(str2.equals(str3)));//�ж����ַ�����Ƿ����ʹ�� equals
		
		//System.out.println("hello".equals("hello"));//����ֱ�ӵ���equalsҲ����
		
		
		//ֱ�Ӹ�ֵ�Ƚ����� string �Ƿ����
		String str1 = "hello";//ֱ�Ӹ�ֵ
		String str2 = "hello";//ֱ�Ӹ�ֵ
		String str3 = "hello";//ֱ�Ӹ�ֵ
		System.out.println("str1����str2��"+(str1 == str2));//�жϵ��ǵ�ַ�ռ��Ƿ����
		System.out.println("str1����str3��"+(str1 == str3));//�жϵ��ǵ�ַ�ռ��Ƿ����
		System.out.println("str2����str3��"+(str2 == str3));//�жϵ��ǵ�ַ�ռ��Ƿ����
		//�������� string ������ڴ��ַ��һ��
		*/
		//020507_����5�£�������������_String��ĳ��÷���
		
		/*
		//���ַ�����Ϊ�ַ�����
		String str1 = "hello";
		char c[] = str1.toCharArray();//��һ���ַ�����Ϊ�ַ�����
		for(int i = 0;i<c.length;i++)
		{
			System.out.print(c[i]+"��");
		}
		System.out.println("===================");
		String str2 = new String(c);//��ȫ�����ַ������ΪString
		String str3 = new String(c,0,3);//��0��ʼ�������֣��������ַ������Ϊ�ַ���
		System.out.println(str2);
		System.out.println(str3);
		*/
		
		/*
		//���ַ�����ȡ��ָ��λ�õ��ַ�
		String str4 = "hello";
		System.out.println(str4.charAt(3));//ȡ���ַ����е�4���ַ�
		*/
		
		/*
		//�ַ�����byte�����ת��
		String str5 = "hello";
		byte b[] = str5.getBytes();//���ַ�����Ϊbyte����
		System.out.println(new String(b));//��ȫ����byte��Ϊ�ַ���
		System.out.println(new String(b,1,3));//������byte�����Ϊ�ַ���
		*/
		
		//ȡ��һ���ַ����ĳ���.length()
		//String str6 = "hello word";
		//System.out.println("srt6�ĳ���Ϊ��"+str6.length());
		
		/*
		//����ָ�����ַ����Ƿ����index of,��������һ���ַ����ľ���λ�ã����û�з���-1
		String str7 = "abcdefcg";
		System.out.println(str7.indexOf('c'));//����c��������ڼ���λ��
		System.out.println(str7.indexOf('c',3));//�ӵ�4��λ�ÿ�ʼ����
		System.out.println(str7.indexOf('x'));//�鲻��ʱ����-1
		*/
		
		//ȥ���ո� trim��ֻ��ȥ�� �������ߵģ�����ȥ���м��
		//String str8 = "    hello     ";
		//System.out.println(str8.trim());//ȥ���������ߵĿո�
		
		/*
		//�ַ���ȡsubstring
		String str9 = "hello word";
		System.out.println(str9.substring(6));//�ӵ�7��λ�ÿ�ʼ��ȡ
		System.out.println(str9.substring(0,5));//��ȡ0-5λ�õ�����
		*/
		
		/*
		//����ַ��� split
		String str10 = "hello word";
		String s[] = str10.split(" ");//���տո���в��
		for(int i = 0;i<s.length;i++)
		{
			System.out.println(s[i]);
		}
		*/
		
		
		//��Сдת��
		//String str11 = "hello word";
		//System.out.println(str11.toUpperCase());//Сдת��Ϊ��д
		//System.out.println("HELLO".toLowerCase());//��дתСд
		
		/*
		//�ж��Ƿ���ָ�����ַ�����ͷ���β
		System.out.println("hello".startsWith("he"));//�ж��Ƿ���h��ͷ�����򷵻� true
		System.out.println("hello".endsWith("lo"));//�ж��Ƿ���o��β�����򷵻� true
		System.out.println("hello".endsWith("t"));//����ȷʱ���� false
		String str12 = "**hello";
		if(str12.startsWith("**"))
		{
			System.out.println("����**��ͷ");
		}
		else
		{
			System.out.println("����������**��ͷ");
		}
		*/
		
		/*
		//�����ֺ����ִ�Сд�ıȽ�
		String str13 = "HELLO";
		String str14 = "hello";
		System.out.println("str13��str14����𣿣�"+str13.equals(str14));//���ִ�Сд�ıȽ�
		System.out.println("str13��str14����𣿣�"+str13.equalsIgnoreCase(str14));//�����ִ�Сд�ıȽ�
		*/
		
		//�ַ������滻����
		String str15 = "Hello";
		String newStr = str15.replace("l","T");//�����滻����
		System.out.println(newStr);
		//020508_����5�£�������������_���ô��ݼ���Ӧ��
		
	}

}
