package Package_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test_5 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
	       WebDriver driver = new ChromeDriver();
	       driver.get("C:\\Users\\Pratik%20Padhi\\Desktop\\Class_Select.html");	
	      // Select sel= new Select(driver.findElement(By.id("day")));
	      // sel.selectByIndex(3);
	     //  Thread.sleep(3000);
	      // sel.deselectByIndex(3);
	     //  System.out.println(sel.isMultiple());
	       
	       WebElement element=driver.findElement(By.name("Mobdevices"));
			Select se=new Select(element);
			//Here we will take multi select dropdown to show you the difference
			se.selectByVisibleText("HTC");
			Thread.sleep(2000);
			se.selectByValue("2");
			Thread.sleep(3000);
			//se.deselectByValue("2");
			//se.deselectByIndex(2);
			//se.deselectByVisibleText("HTC");
			//se.deselectAll();
			System.out.println(se.getFirstSelectedOption().getText());

	}

}
