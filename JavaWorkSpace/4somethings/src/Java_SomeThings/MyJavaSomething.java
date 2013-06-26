package Java_SomeThings;


public class MyJavaSomething
{
	

	public static void main(String[] args)
	{
		/*
		String name = "张三";//直接赋值
		System.out.println("名称是："+name);
		*/
		
		//String name = new String("李四");//实例化string
		//System.out.println("名称是："+name);
		
		/*
		//比较两个 string 是否相等
		String str1 = "hello";//直接赋值
		String str2 = new String("hello");//通过new实例化赋值
		String str3 = str2;//传递引用
		
		System.out.println("str1等于str2："+(str1 == str2));//判断的是地址空间是否相等
		System.out.println("str1等于str3："+(str1 == str3));//判断的是地址空间是否相等
		System.out.println("str2等于str3："+(str2 == str3));//判断的是地址空间是否相等
		
		System.out.println("str1 equals str2："+(str1.equals(str2)));//判断其地址内容是否相等使用 equals
		System.out.println("str1 equals str3："+(str1.equals(str3)));//判断其地址内容是否相等使用 equals
		System.out.println("str2 equals str3："+(str2.equals(str3)));//判断其地址内容是否相等使用 equals
		
		//System.out.println("hello".equals("hello"));//这样直接调用equals也可以
		
		
		//直接赋值比较两个 string 是否相等
		String str1 = "hello";//直接赋值
		String str2 = "hello";//直接赋值
		String str3 = "hello";//直接赋值
		System.out.println("str1等于str2："+(str1 == str2));//判断的是地址空间是否相等
		System.out.println("str1等于str3："+(str1 == str3));//判断的是地址空间是否相等
		System.out.println("str2等于str3："+(str2 == str3));//判断的是地址空间是否相等
		//以上三个 string 对象的内存地址都一样
		*/
		//020507_【第5章：面向对象基础】_String类的常用方法
		
		/*
		//将字符串变为字符数组
		String str1 = "hello";
		char c[] = str1.toCharArray();//将一个字符串变为字符数组
		for(int i = 0;i<c.length;i++)
		{
			System.out.print(c[i]+"、");
		}
		System.out.println("===================");
		String str2 = new String(c);//将全部的字符数组变为String
		String str3 = new String(c,0,3);//从0开始，将部分（三个）字符数组变为字符串
		System.out.println(str2);
		System.out.println(str3);
		*/
		
		/*
		//从字符串中取出指定位置的字符
		String str4 = "hello";
		System.out.println(str4.charAt(3));//取出字符串中第4个字符
		*/
		
		/*
		//字符串与byte数组的转换
		String str5 = "hello";
		byte b[] = str5.getBytes();//将字符串变为byte数组
		System.out.println(new String(b));//将全部的byte变为字符串
		System.out.println(new String(b,1,3));//将部分byte数组变为字符串
		*/
		
		//取得一个字符创的长度.length()
		//String str6 = "hello word";
		//System.out.println("srt6的长度为："+str6.length());
		
		/*
		//查找指定的字符串是否存在index of,给出的是一个字符串的具体位置，如果没有返回-1
		String str7 = "abcdefcg";
		System.out.println(str7.indexOf('c'));//查找c在数组里第几个位置
		System.out.println(str7.indexOf('c',3));//从第4个位置开始查找
		System.out.println(str7.indexOf('x'));//查不到时返回-1
		*/
		
		//去掉空格 trim，只能去掉 左右两边的，不能去掉中间的
		//String str8 = "    hello     ";
		//System.out.println(str8.trim());//去掉左右两边的空格
		
		/*
		//字符截取substring
		String str9 = "hello word";
		System.out.println(str9.substring(6));//从第7个位置开始截取
		System.out.println(str9.substring(0,5));//截取0-5位置的内容
		*/
		
		/*
		//拆分字符串 split
		String str10 = "hello word";
		String s[] = str10.split(" ");//按照空格进行拆分
		for(int i = 0;i<s.length;i++)
		{
			System.out.println(s[i]);
		}
		*/
		
		
		//大小写转换
		//String str11 = "hello word";
		//System.out.println(str11.toUpperCase());//小写转换为大写
		//System.out.println("HELLO".toLowerCase());//大写转小写
		
		/*
		//判断是否以指定的字符串开头或结尾
		System.out.println("hello".startsWith("he"));//判断是否以h开头，是则返回 true
		System.out.println("hello".endsWith("lo"));//判断是否以o结尾，是则返回 true
		System.out.println("hello".endsWith("t"));//不正确时返回 false
		String str12 = "**hello";
		if(str12.startsWith("**"))
		{
			System.out.println("是以**开头");
		}
		else
		{
			System.out.println("不，不是以**开头");
		}
		*/
		
		/*
		//不区分和区分大小写的比较
		String str13 = "HELLO";
		String str14 = "hello";
		System.out.println("str13和str14相等吗？："+str13.equals(str14));//区分大小写的比较
		System.out.println("str13和str14相等吗？："+str13.equalsIgnoreCase(str14));//不区分大小写的比较
		*/
		
		//字符串的替换操作
		String str15 = "Hello";
		String newStr = str15.replace("l","T");//进行替换操作
		System.out.println(newStr);
		//020508_【第5章：面向对象基础】_引用传递及其应用
		
	}

}
