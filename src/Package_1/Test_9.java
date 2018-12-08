package Package_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_9 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
	       WebDriver driver = new ChromeDriver();
	       driver.manage().window().maximize();
	       driver.get("http://demo.guru99.com/test/guru99home/");
	       driver.switchTo().frame("a077aa5e");
	       driver.findElement(By.xpath("//a/img[@src='Jmeter720.png']")).click();
	       //driver.switchTo().defaultContent();
	       driver.switchTo().parentFrame();
	       System.out.println(driver.findElement(By.xpath("//div[@id='site-name']/a[@style='font-weight: 500;']")).getText());

	}

}
