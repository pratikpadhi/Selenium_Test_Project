package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizationUsingDataProvider {
	WebDriver driver;
	
	@Parameters({"browser"})
	@BeforeMethod
	public void setUp(String browser){
		if(browser.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		driver = new ChromeDriver();
	}else if(browser.equals("firefox")){
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
		driver.get("http://newtours.demoaut.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
@Test(dataProvider="DataProviderForLogin")	
public void login(String username,String password, String expTitle){
		
		// Enter UserName
		highlightElement(driver.findElement(By.name("userName")));
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("userName")).sendKeys(username);
		
		// Enter Password
		highlightElement(driver.findElement(By.name("password")));
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		
		// Click on 'SignIn'
		WebElement login = driver.findElement(By.name("login"));
		highlightElement(login);
		login.click();
		
		// Verify Whether Login is Successful or not
		Assert.assertEquals(driver.getTitle().trim(), expTitle);
			
	}

@DataProvider(name="DataProviderForLogin")
public Object[][] loginDataProvider(){
	Object[][] loginData = new Object[4][3];
	
	loginData[0][0] = "^^&%(*";
			loginData[0][1] = "mercury";
					loginData[0][2] = "Sign-on: Mercury Tours";
	
					loginData[1][0] = "mercury";
						loginData[1][1] = "admin";
							loginData[1][2] = "Sign-on: Mercury Tours";
							
							loginData[2][0] = "admin";
								loginData[2][1] = "admin";
									loginData[2][2] = "Sign-on: Mercury Tours";

								loginData[3][0] = "mercury";
									loginData[3][1] = "mercury";
										loginData[3][2] = "Find a Flight: Mercury Tours:";

return loginData;

}

@Test
public void testFaile() {
	Assert.assertTrue(false);
}

@Test
public void testSkip() {
	throw new SkipException("This test got skipped as it was not ready to be executed");
}

private void highlightElement(WebElement element){
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].setAttribute('style','background:yellow; border: 2px solid red;');", element);
}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}