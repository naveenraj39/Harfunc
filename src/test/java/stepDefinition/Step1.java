package stepDefinition;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class Step1{
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	
	@Given("user logged in {string}")
	public void user_logged_in(String string) {
		System.setProperty("webdriver.chrome.driver", "/Users/naveenraj/Downloads/chromedriver_mac_arm64/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("http://edc.devil.triomics.in.s3-website.ap-south-1.amazonaws.com/login");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='text']")));
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("alit.edc@mailinator.com");
		driver.findElement(By.xpath("//*[text()='Login']")).click();
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Hello@123");
		driver.findElement(By.xpath("//*[text()='Login']")).click();
		wait.until(ExpectedConditions.urlMatches("http://edc.devil.triomics.in.s3-website.ap-south-1.amazonaws.com/sites"));
		
	}
	
	@When("Enter into Site {string}")
	public void Enter_into_Site(String string) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='text']")));
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Alit Edc Pani");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Alit Edc Pani']")));
		driver.findElement(By.xpath("//*[text()='Alit Edc Pani']")).click();
		wait.until(ExpectedConditions.urlMatches("http://edc.devil.triomics.in.s3-website.ap-south-1.amazonaws.com/studies"));
	}
	
	@Then("Enter into Study {string}")
	public void Enter_into_Study(String string) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='text']")));
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Harfunc");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Harfunc')]")));
		driver.findElement(By.xpath("//*[contains(text(),'Harfunc')]")).click();
		
	} 
	
	@And("Enter into Build Form")
	public void Enter_into_Build_Form() throws Exception{
		wait.until(ExpectedConditions.urlMatches("http://edc.devil.triomics.in.s3-website.ap-south-1.amazonaws.com/studies/207Y5htBsixij5/manage/organisations"));
		driver.findElement(By.xpath("//*[text()='Administration']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Build']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Form Builder']")));
		driver.findElement(By.xpath("//*[text()='Form Builder']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Screening']")).click();
		Thread.sleep(2000);
		
	}
	
	@Then("Add Screening Visit")
	public void Add_Screening_Visit() throws Exception {
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
		
		}
	
	@And("Build Screening Form")
	public void Build_Screening_Form() throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[text()='Harfunc Group'])[1]")).click();
		Thread.sleep(5000);
		WebElement Cal = driver.findElement(By.xpath("//*[text()='Calculation']"));
		WebElement tar1 = driver.findElement(By.xpath("//*[text()='Drag & Drop Field Here']"));
		Actions DD = new Actions(driver);
		DD.clickAndHold(Cal).moveByOffset(0, 10).moveToElement(tar1, 0, -10).release().perform();

	}
	
}
