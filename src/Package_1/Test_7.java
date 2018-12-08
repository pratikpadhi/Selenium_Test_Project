package Package_1;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test_7 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
	       WebDriver driver = new ChromeDriver();
	       driver.manage().window().maximize();
	       driver.get("https://www.irctc.co.in/nget/train-search");	
	       driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	       driver.findElement(By.xpath("//div[a[text()=' REGISTER ']]/descendant::a/span")).click();
	      Thread.sleep(5000);
	       driver.findElement(By.xpath("//a[text()=' Tourism  ']")).click();
	       Actions act=new Actions(driver);
	       act.moveToElement(driver.findElement(By.xpath("//a[text()='IRCTC Tourism']"))).perform();
	       driver.findElement(By.xpath("//a[text()='Tourist Train    ']")).click();
	       Thread.sleep(5000);
	       Set<String> set =driver.getWindowHandles();
	       Iterator<String> itr=set.iterator();
	       String parent=itr.next();
	       String child=itr.next();
	       driver.switchTo().window(child);
	       driver.findElement(By.xpath("//a[@href='http://www.the-maharajas.com/']/div")).click();
	       Thread.sleep(5000);
	       Set<String> set1 =driver.getWindowHandles();
	       Iterator<String> itr1=set1.iterator();
	       itr1.next();
	       itr1.next();
	       String child2=itr1.next();
	       driver.switchTo().window(child2);
	       System.out.println(driver.findElement(By.xpath("//div[@class='book-now-wrap']/a")).getText());
	       driver.switchTo().window(parent);
	       System.out.println(driver.findElement(By.xpath("//a[text()='Home']")).getText());


	       
	}

}
