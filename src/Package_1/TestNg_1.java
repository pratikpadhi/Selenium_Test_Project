package Package_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNg_1 {
	@BeforeMethod
	public void bfmthd()
	{
		System.out.println("Before Method");
	}

	@BeforeTest
	public void bftest()
	{
		System.out.println("Before Test");
	}

	@AfterMethod
	public void aftrmthd()
	{
		System.out.println("After Method");
	}
	@AfterTest
	public void aftrtest()
	{
		System.out.println("After Test");
	}
	
	@Test
	public void test()
	{
		System.out.println("This is test1");
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.newtours.demoaut.com/");
	}
	@Test
	public void testFail() {
		Assert.assertTrue(false);
	}
	
	@Test
	public void teSkip() {
		throw new SkipException("This test got skipped as it was not eady to be executed");
	}
	@Test
	public void test_2()
	{
		System.out.println("This is test2");
	}
	@BeforeClass
	public void bfrcls()
	{
		System.out.println("Before class");
	}
	@AfterClass
	public void aftrcls()
	{
		System.out.println("After class");
	}
}
