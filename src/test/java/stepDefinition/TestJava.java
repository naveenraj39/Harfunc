package stepDefinition;

import java.time.Duration;

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
	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='text']")));
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
		

		
		
      
		
	
		
		
	
		
	
		
		
		
		
	
		
	}
	
}

