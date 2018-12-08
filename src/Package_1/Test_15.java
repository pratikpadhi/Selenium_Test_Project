package Package_1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_15 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.navigate().to("http://www.newtours.demoaut.com/");
		Thread.sleep(5000);
		List<WebElement> link=driver.findElements(By.xpath("//table[@border='1']/tbody/tr/td/a[@href]"));
		System.out.println(link.size());
		for(int i=0;i<(link.size());i++)
		{
		driver.findElement(By.xpath("//table[@border='1']/tbody/tr/td["+(i+1)+"]/a[@href]")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		}
		List<WebElement> link1=driver.findElements(By.xpath("//table[@border='2']/tbody/tr/descendant::a"));
		System.out.println(link1.size());
		for(int i=0;i<(link1.size());i++)
		{
		driver.findElement(By.xpath("//table[@border='2']/tbody/tr["+(i+1)+"]/descendant::a")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		}

	}
	}


