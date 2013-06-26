package mytestNGtest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import myjavatest.JavaTest;

/*
�����´� �Ҽ�-other-TestNG class ��������
 */

public class TestNGTest 
{
    private JavaTest newSum = new JavaTest();
    
    @Test(groups = {"t1","t2"})
    public void f() 
    {
	int mySum = newSum.add(1,2);
	assertEquals(3,mySum,"Right");
    }
    
    @Test(groups = {"t1","t2"})
    public void f1() 
    {
	int mySum = newSum.add(1,2);
	assertEquals(6,mySum,"Right");//���Ǵ��������
    }
    
    @Test(groups = {"t1"})
    public void f3() 
    {
	int mySum = newSum.add(6,2);
	assertEquals(8,mySum,"Right");
    }
    
    @Parameters({"TheString"})
    @Test
    public void f4(String TheString) 
    {
	System.out.println(TheString);
	assertEquals("xul",TheString,"Right");
	
    }
    
    
}
