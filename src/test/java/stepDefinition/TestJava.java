package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("http://edc.devil.triomics.in.s3-website.ap-south-1.amazonaws.com/login");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='text']")));
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("alit.edc@mailinator.com");
		driver.findElement(By.xpath("//*[text()='Login']")).click();
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Hello@123");
		driver.findElement(By.xpath("//*[text()='Login']")).click();
		wait.until(ExpectedConditions.urlMatches("http://edc.devil.triomics.in.s3-website.ap-south-1.amazonaws.com/sites"));
	

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='text']")));
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Alit Edc Pani");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Alit Edc Pani']")));
		driver.findElement(By.xpath("//*[text()='Alit Edc Pani']")).click();
		wait.until(ExpectedConditions.urlMatches("http://edc.devil.triomics.in.s3-website.ap-south-1.amazonaws.com/studies"));
	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='text']")));
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Harfunc");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Harfunc')]")));
		driver.findElement(By.xpath("//*[contains(text(),'Harfunc')]")).click();
		
	
		wait.until(ExpectedConditions.urlMatches("http://edc.devil.triomics.in.s3-website.ap-south-1.amazonaws.com/studies/207Y5htBsixij5/manage/organisations"));
		driver.findElement(By.xpath("//*[text()='Administration']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Build']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Form Builder']")));
		driver.findElement(By.xpath("//*[text()='Form Builder']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Screening']")).click();
		Thread.sleep(2000);
		
	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Screening Visit']")));
		driver.findElement(By.xpath("//*[text()='Screening Visit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()=' Add Event']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@type='text'])[3]")));
		driver.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Visit_1");
		driver.findElement(By.xpath("//*[@class='MuiInputBase-input MuiFilledInput-input MuiInputBase-inputMultiline MuiFilledInput-inputMultiline']")).sendKeys("First Visit");
		driver.findElement(By.xpath("(//*[@type='radio'])[2]")).click();
		driver.findElement(By.xpath("(//*[@type='text'])[5]")).sendKeys("None");
		driver.findElement(By.xpath("(//*[text()='Add Event'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Visit_1']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Add Group']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("V1");
		driver.findElement(By.xpath("//*[@class='MuiInputBase-input MuiFilledInput-input MuiInputBase-inputMultiline MuiFilledInput-inputMultiline']")).sendKeys("Harfunc Group");
		driver.findElement(By.xpath("(//*[text()='Add Group'])[3]")).click();
		
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[text()='Harfunc Group'])[1]")).click();
		Thread.sleep(5000);
		WebElement src = driver.findElement(By.xpath("//*[text()='Calculation']"));
		WebElement tar = driver.findElement(By.xpath("//*[text()='Drag & Drop Field Here']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// create a custom drag event on the source element
	/*	js.executeScript("var event = new MouseEvent('dragstart', { 'bubbles': true, 'cancelable': true });" +
		        "arguments[0].dispatchEvent(event);", src);

		// wait for the onDragStart event to fire on the source element
		
		wait.until(ExpectedConditions.attributeToBe(src, "data-rbd-draggable-id", "1"));

		// move the mouse to the target element and create a custom drop event on the target element
		js.executeScript("var event = new MouseEvent('drop', { 'bubbles': true, 'cancelable': true });" +
		        "arguments[0].dispatchEvent(event);" +
		        "event = new MouseEvent('dragend', { 'bubbles': true, 'cancelable': true });" +
		        "arguments[1].dispatchEvent(event);", tar, src);

		// wait for the onDragEnd event to fire on the source element
		wait.until(ExpectedConditions.attributeToBe(src, "data-rbd-draggable-id", "1"));
		*/
		
		Actions actions = new Actions(driver);
		
		actions
			.clickAndHold(src)
			.moveByOffset(0, 10)
			.moveToElement(tar, 0, -10)
			.release().build().perform();
	}
	
}

