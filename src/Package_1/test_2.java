package Package_1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class test_2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
	       WebDriver driver = new ChromeDriver();
	
	       driver.navigate().to("https://en-gb.facebook.com/login/");
	       driver.findElement(By.xpath("//input[@id='email']")).sendKeys("jhakas");
			Actions act=new Actions(driver);
			act.sendKeys(Keys.HOME).perform();
			act.sendKeys(Keys.chord(Keys.SHIFT,Keys.ARROW_RIGHT)).perform();
			act.sendKeys(Keys.chord(Keys.SHIFT,Keys.ARROW_RIGHT)).perform();
			//act.sendKeys(Keys.chord(Keys.CONTROL,"a")).perform();
			act.sendKeys(Keys.chord(Keys.CONTROL,"c")).perform();
			act.sendKeys(Keys.TAB).perform();
			act.sendKeys(Keys.chord(Keys.CONTROL,"v")).perform();
			//System.out.println(driver.findElement(By.xpath("//input[@id='pass']")).getText());
			act.release();

	}

}
