package Package_1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_13 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
	       WebDriver driver = new ChromeDriver();
	       driver.manage().window().maximize();
	       driver.navigate().to("http://www.newtours.demoaut.com/");
	       WebElement wb=driver.findElement(By.linkText("Car Rentals"));
	       JavascriptExecutor executor = (JavascriptExecutor)driver;
	       executor.executeScript("arguments[0].click();", wb);
	       driver.navigate().back();
	       executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    
	}

}
