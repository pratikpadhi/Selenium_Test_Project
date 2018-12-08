package Package_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNg_2 {
	@Test
	public void test()
	{
		System.out.println("This is test_)_1");
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.google.com/");
	}
	@Test
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
