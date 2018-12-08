package Package_1;

import org.testng.annotations.Test;

public class TestNG_4 {
	
	@Test(enabled = false)
	public void test()
	{
		System.out.println("This is test_)_1");
		
	}
	@Test
	public void test_2()
	{
		System.out.println("This is test_)_2");
	}
	@Test(dependsOnMethods="test_2")
	public void test_3()
	{
		System.out.println("This is test_)_3");
	}
	@Test(invocationCount=5)
	public void test_4()
	{
		System.out.println("This is test_)_4");
	}
}
