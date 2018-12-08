package Package_1;

import java.awt.Color;
import java.io.File;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class newTestNg_2 {
	
	ExtentReports extent;
	ExtentTest logger;
	ExtentHtmlReporter htmlReporter;
	
	@BeforeTest
	public void setUp() throws UnknownHostException {
		extent = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"\\Report\\TestExecutionReport.html"));
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setReportName("Regression Cycle");
		htmlReporter.config().setDocumentTitle("Extent Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		
		// htmlReporter.loadXMLConfig("C:\\Users\\Pratik Padhi\\eclipse-workspace\\Selenium_Test_Project\\config\\extent-config.xml");
		extent.attachReporter(htmlReporter);
		
		// System Information
		extent.setSystemInfo("Project Name", "Test Project");
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		extent.setSystemInfo("User", System.getProperty("user.name"));
		InetAddress myHost = InetAddress.getLocalHost();
		extent.setSystemInfo("Host Name", myHost.getHostName());
	}
	
	@BeforeMethod
	public void getMethodName(Method method) {
		logger = extent.createTest(method.getName());
	}
	
	@Test
	public void function_2()
	{
		System.out.println("function_2");
	}
	@Test
	public void function_3()
	{
		System.out.println("function_3");
	}
	@AfterMethod
	public void getStatus(ITestResult result) {
		if(result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" got passed", ExtentColor.GREEN));
			
		}else if(result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" git failed due to "+result.getThrowable(), ExtentColor.RED));
		}else if(result.getStatus() == ITestResult.SKIP){
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" got skipped", ExtentColor.YELLOW));
		}
	}
	
	@AfterTest
	public void tearDown() {
		extent.flush();
	}

}
