package Package_1;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;





public class TestNg_5 {
	private static	Logger logger=Logger.getLogger(TestNg_5.class.getName());

	@BeforeClass
	public void test0()
	{
		  PropertyConfigurator.configure("log4j.properties");
		  BasicConfigurator.configure();
	}
	
	@Test
	public void test()
	{
		System.out.println("This is test_)_1");
		logger.info("This is test_)_1");
	}
	@Test
	public void test_2()
	{
		System.out.println("This is test_)_2");
		logger.warn("This is test_)_2");
	}
	@Test
	public void test_3()
	{
		System.out.println("This is test_)_3");
		logger.error("This is test_)_3");
	}
	@Test
	public void test_4()
	{
		System.out.println("This is test_)_4");
		logger.debug("This is test_)_4");
	}
	
}
