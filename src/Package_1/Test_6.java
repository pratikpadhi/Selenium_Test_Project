package Package_1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test_6 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
	       WebDriver driver = new ChromeDriver();
	       driver.manage().window().maximize();
	       driver.get("https://www.irctc.co.in/nget/train-search");	
	       driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	       Thread.sleep(3000);
	       WebElement element=driver.findElement(By.xpath("//div[a[text()=' REGISTER ']]/descendant::a/span"));
	       JavascriptExecutor executor = (JavascriptExecutor)driver;
	       executor.executeScript("arguments[0].click();", element);
	     driver.findElement(By.xpath("//div[input[@title='Please select OTP only in case of Visually impaired User']]/following-sibling::div/input[@value='Login']")).click();
	     Alert a=driver.switchTo().alert();
	     System.out.println(a.getText());
	     a.accept();
	}

}
