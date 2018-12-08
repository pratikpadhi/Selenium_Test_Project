package Package_1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Test_1 {
	
	public static void main(String[] args) throws InterruptedException, AWTException
	
	   {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	
	       WebDriver driver = new ChromeDriver();
	
	       driver.get("https://www.flipkart.com/");
			Thread.sleep(4000);
			driver.findElement(By.xpath("//div[div[div[div[span[span[text()='Login']]]]]]/button")).click();
			Thread.sleep(2000);
			//WebElement wb=driver.findElement(By.xpath("//span[text()='Electronics']"));
			WebElement wb=driver.findElement(By.xpath("//span[text()='Help Center']"));
			Thread.sleep(2000);
			Actions act=new Actions(driver);
			act.contextClick(driver.findElement(By.xpath("//a[@href='/pages/payments']"))).perform();
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_W);
			
	
	   }


}
