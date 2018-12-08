package Package_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test_4 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
	       WebDriver driver = new ChromeDriver();
	       driver.get("http://demo.guru99.com/test/drag_drop.html");					
	       WebElement From=driver.findElement(By.xpath("//li[@id='credit2']/a"));	
	        WebElement To=driver.findElement(By.xpath("//ol[@id='bank']/li"));					
	         Actions act=new Actions(driver);					
	         act.clickAndHold(From).moveToElement(To).click().build().perform();

	}

}
