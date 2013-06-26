package com.java.test;

import java.io.File;

import mx4j.util.Utils;

import com.broada.spring.AutoTest;

public class Test
{
	private static AutoTest auto;
	
	public static void testcase()
	{
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
		auto = new AutoTest(1);
		String userdir = System.getProperty("user.dir");
		String pf = userdir+"\\Test\\test01\\name.xls";
		String inf = userdir+"\\Test\\test01\\name.yaml";
		File pageFile = new File(pf);
		auto.loadData(pageFile, inf);
		auto.openUrl("URL");
		
		auto.click("百度提交按钮");
		auto.close();
	}
	public static void main(String[] args)
	{
		testcase();

	}

}
