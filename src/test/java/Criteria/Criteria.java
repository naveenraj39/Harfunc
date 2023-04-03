package Criteria;

import java.io.*;
import org.apache.poi.*;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Criteria {
	
	
	public static void main (String[]args) throws Exception {
		
		
		File src = new File("/Users/naveenraj/Downloads/names.xlsx");
		FileInputStream file = new FileInputStream(src);
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row1 = sheet.getRow(1);
		Cell cell2 = row1.getCell(1);
		System.out.println(sheet.getRow(1).getCell(0));
		XSSFCell url = sheet.getRow(1).getCell(0);
		String url1 = url.toString();
		
		

		System.setProperty("webdriver.chrome.driver", "/Users/naveenraj/Downloads/chromedriver_mac_arm64/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get(url1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//*[text()='Criteria']"));
		
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		
		
		  String TestFile = "/Users/naveenraj/Downloads/temp.txt";
		  File FC = new File(TestFile);
		  FC.createNewFile();
		  
		  String text = driver.findElement(By.xpath("//*[text()='Criteria']//following-sibling::div")).getText();
			
			System.out.println(text);
		  
		  FileWriter FW = new FileWriter(TestFile);
		  FileOutputStream BW = new FileOutputStream("/Users/naveenraj/Downloads/temp.txt");
		  byte[] array = text.getBytes();

          // Writes byte to the file
          BW.write(array);

          BW.close();
		  
		  
		
	}

}
