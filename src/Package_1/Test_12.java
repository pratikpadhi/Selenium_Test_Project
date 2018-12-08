package Package_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_12 {

	public static void main(String[] args) {
		File file = new File("E:\\test.properties");
		  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
	       WebDriver driver = new ChromeDriver();
			driver.get(prop.getProperty("URL"));

	       System.out.println("URL ::" + prop.getProperty("URL"));
		System.out.println("User name::" +prop.getProperty("username"));
	    System.out.println("Password::" +prop.getProperty("password"));
	}

}
