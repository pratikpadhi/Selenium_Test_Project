package Package_1;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class new_TestNg_1 extends newTestNg_2 {
	
	@BeforeMethod
	public void getMethodName(Method method) {
		logger = extent.createTest(method.getName());
	}
	@Test
	public void function_1()
	{
		System.out.println("function_1");
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
}
