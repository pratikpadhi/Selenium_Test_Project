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

public class Test_16 {

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
	

	
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		
		System.out.println(getExceldata("Test.xlsx","Sheet1",0,0));
		System.out.println(getExceldatanum("Test.xlsx","Sheet1",0,1));
System.out.println(countofdata("Test.xlsx","Sheet3"));
ReadExceldatanum("Test.xlsx","Sheet1",0,2,69.0);
ReadExceldata("Test.xlsx","Sheet1",0,3,"good");
System.setProperty("webdriver.chrome.driver","chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.navigate().to("http://www.newtours.demoaut.com/");

for(int i=1;i<(countofdata("Test.xlsx","Sheet3"));i++)
{
driver.findElement(By.name("userName")).sendKeys(getExceldata("Test.xlsx","Sheet3",i,0));
driver.findElement(By.xpath("//input[@name='password']")).sendKeys(getExceldata("Test.xlsx","Sheet3",i,1));
driver.findElement(By.xpath("//input[@name='login']")).click();
Thread.sleep(4000);
try
{
System.out.println(driver.findElement(By.xpath("//input[@name='login']")).isDisplayed());
ReadExceldata("Test.xlsx","Sheet3",i,2,"FAIL");
driver.navigate().back();
}catch(Exception e)
{
	ReadExceldata("Test.xlsx","Sheet3",i,2,"PASS");	
	driver.navigate().back();
}
Thread.sleep(2000);
}
	}


}
