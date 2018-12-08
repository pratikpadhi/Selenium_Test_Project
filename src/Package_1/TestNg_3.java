package Package_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNg_3 {
	
	@Test(groups="smoke",priority=2)
	public void test()
	{
		System.out.println("This is test_)_1");
		
	}
	@Test(groups="smoke",priority=1)
	public void test_2()
	{
		System.out.println("This is test_)_2");
	}
	@Test
	public void test_3()
	{
		System.out.println("This is test_)_3");
	}

}
