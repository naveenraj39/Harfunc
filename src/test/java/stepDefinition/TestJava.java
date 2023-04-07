package stepDefinition;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestJava {

	public static void main(String []args) throws Exception {
            String StudyDetails = "/Users/naveenraj/Downloads/temp.txt";
		    Scanner scan = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Enter Studyname");

		    String sname = scan.nextLine(); 
		    
		    String path = System.getProperty(StudyDetails);
	      
	        try {
	            FileWriter fw = new FileWriter(StudyDetails, true);
	            fw.write("\n"+sname);
	            fw.close();
	        }
	        catch(IOException e) {
	        }
	}}
	
		    
		/*    FileWriter FW = new FileWriter(StudyDetails);
		    
			  FileOutputStream BW = new FileOutputStream("/Users/naveenraj/Downloads/temp.txt");
			  byte[] array = sname.getBytes();
			  BufferedWriter bw = new BufferedWriter(FW);
			  bw.newLine();
			  
	          // Writes byte to the file
	          BW.write(array);
	         

	          BW.close(); */
	          
	   /*       try {
	        	    BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/naveenraj/Downloads/temp.txt"));
	        	        
	        	        writer.newLine();
	        	        writer.write(sname);
	        	        writer.flush();
	        	        writer.close();
	        	} catch (IOException ex) {
	        	    System.out.println("File could not be created");
	        	} */
	          
	     /*     String Content = "put here the data to be wriiten";
	          try
	              {
	              FileWriter fw = new FileWriter(StudyDetails);
	              BufferedWriter bw = new BufferedWriter(fw);
	              bw.append(Content);
	              bw.append("hiiiii");
	              bw.close();
	              fw.close();
	              }
	          catch(Exception e)
	             {
	              System.out.println(e);
	             } 
/*
		    
System.setProperty("webdriver.chrome.driver", "/Users/naveenraj/Downloads/chromedriver_mac_arm64/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver d = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
		wait=new WebDriverWait(d, Duration.ofSeconds(10));
		d.get("http://edc.devil.triomics.in.s3-website.ap-south-1.amazonaws.com/login");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='text']")));
		d.findElement(By.xpath("//*[@type='text']")).sendKeys("alit.edc@mailinator.com");
		d.findElement(By.xpath("//*[text()='Login']")).click();
		d.findElement(By.xpath("//*[@type='password']")).sendKeys("Hello@123");
		d.findElement(By.xpath("//*[text()='Login']")).click();
		wait.until(ExpectedConditions.urlMatches("http://edc.devil.triomics.in.s3-website.ap-south-1.amazonaws.com/sites"));
	

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='text']")));
		d.findElement(By.xpath("//*[@type='text']")).sendKeys("Alit Edc Pani");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Alit Edc Pani']")));
		d.findElement(By.xpath("//*[text()='Alit Edc Pani']")).click();
		wait.until(ExpectedConditions.urlMatches("http://edc.devil.triomics.in.s3-website.ap-south-1.amazonaws.com/studies"));
		Thread.sleep(2000);
		d.findElement(By.xpath("//*[text()='+ New Study']")).click();
		Thread.sleep(2000); 
		
	/*
		
		File src = new File("/Users/naveenraj/Downloads/rSDV.xlsx");
		FileInputStream file = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFCell cell = sheet.getRow(0).getCell(0);
		String sname = cell.toString();  */
		
	/*	d.findElement(By.xpath("(//*[@type='text'])[2]")).sendKeys(sname);
		d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys(sname);
		d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[1]")).click();
		d.findElement(By.xpath("//*[text()='Phase I']")).click();
		Thread.sleep(1000);
		d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[2]")).click();
		d.findElement(By.xpath("//*[text()='Both Remote and In-Person']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[3]")).click();
		d.findElement(By.xpath("//*[text()='Double Blinded']")).click();
		Thread.sleep(2000); */
//		d.findElement(By.xpath("//*[text()='Create']")).click();
		
		
		
		
		
		
		
		
		
		
	
		
		
		
	

	
		/* wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='text']")));
		d.findElement(By.xpath("//*[@type='text']")).sendKeys("Harfunc");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Harfunc')]")));
		d.findElement(By.xpath("//*[contains(text(),'Harfunc')]")).click(); 
		
	
		wait.until(ExpectedConditions.urlMatches("http://edc.devil.triomics.in.s3-website.ap-south-1.amazonaws.com/studies/207Y5htBsixij5/manage/organisations"));
		d.findElement(By.xpath("//*[text()='Administration']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//*[text()='Build']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Form Builder']")));
		d.findElement(By.xpath("//*[text()='Form Builder']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//*[text()='Screening']")).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Screening Visit']")));
		d.findElement(By.xpath("//*[text()='Screening Visit']")).click();
		Thread.sleep(5000);
		d.findElement(By.xpath("//*[text()='Visit_1']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//*[text()='V1']")).click();
		Thread.sleep(3000);
		
		//Adding OG
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Add Group']")));
		d.findElement(By.xpath("//*[text()='Add Group']")).click();
		d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Condition");
		d.findElement(By.xpath("//*[@id='GROUP_DESCRIPTION']")).sendKeys("Harfunc Group");
		d.findElement(By.xpath("(//*[text()='Add Group'])[3]")).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Option Groups']")));
		d.findElement(By.xpath("//*[text()='Option Groups']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//*[text()=' Add Option Groups']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//*[@type='text'])[2]")).sendKeys("Yes/No Option Group");
		d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Radio");
		Thread.sleep(3000);
		d.findElement(By.xpath("//*[text()='+ Add new Option']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("Yes");
		d.findElement(By.xpath("(//*[@type='text'])[5]")).sendKeys("1");
		d.findElement(By.xpath("(//*[@type='text'])[6]")).sendKeys("Yes");
		Thread.sleep(3000);
		d.findElement(By.xpath("//*[text()='+ Add new Option']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//*[@type='text'])[7]")).sendKeys("No");
		d.findElement(By.xpath("(//*[@type='text'])[8]")).sendKeys("0");
		d.findElement(By.xpath("(//*[@type='text'])[9]")).sendKeys("No");
		Thread.sleep(2000);
		d.findElement(By.xpath("//*[text()='Add']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Screening Visit']")));
		d.findElement(By.xpath("//*[text()='Screening Visit']")).click();
		Thread.sleep(5000);
		d.findElement(By.xpath("//*[text()='Visit_1']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//*[text()='V1']")).click();
*/
		
		
      
		
	
		
		
	
		
	
		
		
		
		
	
		
	
	


