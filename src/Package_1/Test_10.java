package Package_1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_10 {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
	       WebDriver driver = new ChromeDriver();
	       driver.manage().window().maximize();
	       driver.get("https://files.fm/");
	       driver.findElement(By.xpath("//span[text()=' Upload & Share Files']")).click();
	       Thread.sleep(6000);
	       Runtime.getRuntime().exec("E:\\Upload.exe");
	}

}
