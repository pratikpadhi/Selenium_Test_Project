package Package_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Test_14 {
	public static String getExceldata(String filepath,String sheetname,int rownum,int colnum) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		Row rw=sh.getRow(rownum);
	    String data=rw.getCell(colnum).getStringCellValue();
		//System.out.println("come1");
	    return data;
		}
	public static int countofdata(String filepath,String sheetname) throws EncryptedDocumentException, InvalidFormatException, IOException{
			FileInputStream fis=new FileInputStream(filepath);
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet(sheetname);
		int rowcount=	sh.getLastRowNum();
		return (rowcount+1);
	}
	public static void ReadExceldata(String filepath,String sheetname,int rownum,int colnum,String data) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		Row rw=sh.getRow(rownum);
		Cell cel=rw.createCell(colnum);
		cel.setCellType(cel.CELL_TYPE_STRING);
		FileOutputStream fos=new FileOutputStream(filepath);
		cel.setCellValue(data);
		wb.write(fos);
		wb.close();
	
	
	}
	
	public static double getExceldatanum(String filepath,String sheetname,int rownum,int colnum) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		Row rw=sh.getRow(rownum);
	    double data=rw.getCell(colnum).getNumericCellValue();
	    return data;
		}
	public static void ReadExceldatanum(String filepath,String sheetname,int rownum,int colnum,double data) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		Row rw=sh.getRow(rownum);
		Cell cel=rw.createCell(colnum);
		cel.setCellType(cel.CELL_TYPE_NUMERIC);
		FileOutputStream fos=new FileOutputStream(filepath);
		int e=(int)data;
	    cel.setCellValue(e);
		wb.write(fos);
		wb.close();
	
	
	}
	
	public static WebElement GetElement(double a1, String locatorValue,WebDriver driver)
	{
		int a=(int)a1;
		switch(a)
		{
		case 1:
			return driver.findElement(By.className(locatorValue));
		case 2:
			return driver.findElement(By.id(locatorValue));
		case 3:
			return driver.findElement(By.xpath(locatorValue));
		case 4:
			return driver.findElement(By.name(locatorValue));
		case 5:
			return driver.findElement(By.tagName(locatorValue));
		case 6:
			return driver.findElement(By.linkText(locatorValue));
		case 7:
			return driver.findElement(By.partialLinkText(locatorValue));
		case 8:
			return driver.findElement(By.cssSelector(locatorValue));
		default:
			return driver.findElement(By.id(locatorValue));
		}
	}
	
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		System.out.println(getExceldata("Test.xlsx","Sheet1",0,0));
		System.out.println(getExceldatanum("Test.xlsx","Sheet1",0,1));
System.out.println(countofdata("Test.xlsx","Sheet1"));
ReadExceldatanum("Test.xlsx","Sheet1",0,2,69.0);
ReadExceldata("Test.xlsx","Sheet1",0,3,"good");
System.setProperty("webdriver.chrome.driver","chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.navigate().to("http://www.newtours.demoaut.com/");
GetElement((getExceldatanum("Test.xlsx","Sheet1",3,0)),(getExceldata("Test.xlsx","Sheet1",3,1)),driver).sendKeys(getExceldata("Test.xlsx","Sheet1",3,2));
//driver.findElement(By.name("userName")).sendKeys("mercury");
GetElement((getExceldatanum("Test.xlsx","Sheet1",4,0)),(getExceldata("Test.xlsx","Sheet1",4,1)),driver).sendKeys(getExceldata("Test.xlsx","Sheet1",4,2));
//driver.findElement(By.xpath("//input[@name='password']")).sendKeys("mercury");
GetElement((getExceldatanum("Test.xlsx","Sheet1",5,0)),(getExceldata("Test.xlsx","Sheet1",5,1)),driver).click();

//driver.findElement(By.xpath("//input[@name='login']")).click();

	}

}
