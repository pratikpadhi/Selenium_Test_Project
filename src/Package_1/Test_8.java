package Package_1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;



public class Test_8 {
	
	public static void screenshot(WebDriver driver){
		
		EventFiringWebDriver ed=new EventFiringWebDriver(driver);
		File scr = ed.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		File dst=new File("C:\\Screen\\"+"Test"+"____"+timeStamp+".png");
		try {
			FileUtils.copyFile(scr, dst);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
	       WebDriver driver = new ChromeDriver();
	       driver.manage().window().maximize();
	       driver.get("https://seleniummaster.com/llc/apply/");	
	       screenshot(driver);
	       String parent0=driver.getWindowHandle();
	       driver.findElement(By.xpath("//li[@id='menu-item-325']/a")).click();
	       Thread.sleep(3000);
	       Set<String> set =driver.getWindowHandles();
	       Iterator<String> itr=set.iterator();
	       String parent=itr.next();
	       String child=itr.next();
	       driver.switchTo().window(child);
	       screenshot(driver);
	       System.out.println(driver.findElement(By.xpath("//h2[@class='sectionname']")).getText());
	       System.out.println(parent0);
	       System.out.println(parent);

	}

}
