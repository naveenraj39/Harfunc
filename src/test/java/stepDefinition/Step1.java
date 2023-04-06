package stepDefinition;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import pageObjects.Locator;

public class Step1{
	
	public WebDriver d;
	public WebDriverWait wait;
	
	
	
	@Given("user logged in {string}")
	public void user_logged_in(String string) {
		System.setProperty("webd.chrome.d", "/Users/naveenraj/Downloads/chromed_mac_arm64/chromed");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		d = new ChromeDriver(options);
		wait=new WebDriverWait(d, Duration.ofSeconds(10));
		d.get(string);
		d.findElement(By.xpath("//*[@type='text']")).sendKeys("alit.edc@mailinator.com");
		d.findElement(By.xpath("//*[text()='Login']")).click();
		d.findElement(By.xpath("//*[@type='password']")).sendKeys("Hello@123");
		d.findElement(By.xpath("//*[text()='Login']")).click();
		wait.until(ExpectedConditions.urlMatches("http://edc.devil.triomics.in.s3-website.ap-south-1.amazonaws.com/sites"));
	
	}
	
	@When("Enter into Site {string}")
	public void Enter_into_Site(String string) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='text']")));
		d.findElement(By.xpath("//*[@type='text']")).sendKeys("Alit Edc Pani");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Alit Edc Pani']")));
		d.findElement(By.xpath("//*[text()='Alit Edc Pani']")).click();
		
	}
	
	@Then("Enter into Study {string}")
	public void Enter_into_Study(String string) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='text']")));
		d.findElement(By.xpath("//*[@type='text']")).sendKeys("Harfunc");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Harfunc')]")));
		d.findElement(By.xpath("//*[contains(text(),'Harfunc')]")).click();
		
	} 
	
	@And("Enter into Build Form")
	public void Enter_into_Build_Form() throws Exception{
		wait.until(ExpectedConditions.urlMatches("http://edc.devil.triomics.in.s3-website.ap-south-1.amazonaws.com/studies/207Y5htBsixij5/manage/organisations"));
		d.findElement(By.xpath("//*[text()='Administration']")).click();
		d.findElement(By.xpath("//*[text()='Build']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Form Builder']")));
		d.findElement(By.xpath("//*[text()='Form Builder']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Screening']")));
		d.findElement(By.xpath("//*[text()='Screening']")).click();
		
	}
	
	@Then("Add Screening Visit")
	public void Add_Screening_Visit() throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Screening Visit']")));
		d.findElement(By.xpath("//*[text()='Screening Visit']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=' Add Event']")));
		d.findElement(By.xpath("//*[text()=' Add Event']")).click();
		d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Visit_1");
		d.findElement(By.xpath("//*[@class='MuiInputBase-input MuiFilledInput-input MuiInputBase-inputMultiline MuiFilledInput-inputMultiline']")).sendKeys("First Visit");
		d.findElement(By.xpath("(//*[@type='radio'])[2]")).click();
		d.findElement(By.xpath("(//*[@type='text'])[5]")).sendKeys("None");
		d.findElement(By.xpath("(//*[text()='Add Event'])[2]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Visit_1']")));
		d.findElement(By.xpath("//*[text()='Visit_1']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Add Group']")));
		d.findElement(By.xpath("//*[text()='Add Group']")).click();
		d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("V1");
		d.findElement(By.xpath("//*[@class='MuiInputBase-input MuiFilledInput-input MuiInputBase-inputMultiline MuiFilledInput-inputMultiline']")).sendKeys("Harfunc Group");
		d.findElement(By.xpath("(//*[text()='Add Group'])[3]")).click();
		}
	
	@And("Add Age Field")
	public void Age_Field() throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Harfunc Group']")));
		d.findElement(By.xpath("//*[@title='Harfunc Group']")).click();
		WebElement Cal = d.findElement(By.xpath("//*[text()='Number']"));
		WebElement tar = d.findElement(By.xpath("//*[text()='Drag & Drop Field Here']"));
		Actions DD = new Actions(d);
		DD.clickAndHold(Cal).moveByOffset(0, 10).moveToElement(tar, 0, -10).release().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@type='text'])[3]")));
		d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Age of participant");
		d.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("Age");
		d.findElement(By.xpath("(//*[@type='text'])[5]")).sendKeys("Years");
		d.findElement(By.xpath("//*[text()='Add new field']")).click();
		
	}
		
		@And("Add Height Field")
		public void Height_Field() throws Exception {
		Thread.sleep(3000);
		WebElement Cal = d.findElement(By.xpath("//*[text()='Slider']"));
		WebElement tar = d.findElement(By.xpath("//*[text()='Drag & Drop Field Here']"));
		Actions DD = new Actions(d);
		
		DD.clickAndHold(Cal).moveByOffset(0, 10).moveToElement(tar, 0, -10).release().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@type='text'])[3]")));
		d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Height");
		d.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("Height");
		d.findElement(By.xpath("(//*[@type='text'])[5]")).sendKeys("cm");
		d.findElement(By.xpath("//*[@placeholder='Minimum']")).sendKeys("10");
		d.findElement(By.xpath("//*[@placeholder='Maximum']")).sendKeys("300");
		d.findElement(By.xpath("(//*[@type='number'])[4]")).sendKeys("1");
		d.findElement(By.xpath("//*[text()='Build Harmonisation']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[text()='Select Resource Type']")));
		d.findElement(By.xpath("//*[text()='Select Resource Type']")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Observation']")));
		d.findElement(By.xpath("//*[text()='Observation']")).click();
		d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[2]")).click();
		d.findElement(By.xpath("//*[text()='Alit Edc Pani']")).click();
		d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Height");
		Thread.sleep(2000);
		d.findElement(By.xpath("(//*[@type='checkbox'])[1]")).click();
		d.findElement(By.xpath("(//*[text()='Observation'])[2]")).click();
		d.findElement(By.xpath("//*[text()='All']")).click();
		WebElement RT = d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[4]"));
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].scrollIntoView();", RT);
		js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", RT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@aria-haspopup='listbox'])[4]")));
		RT.click();
		js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", d.findElement(By.xpath("//*[text()='Observation.value']")));
		d.findElement(By.xpath("//*[text()='Observation.value']")).click();
		d.findElement(By.xpath("//*[text()='Add new field']")).click();
		}
		@And("Add Weight Field")
		public void Weight_Field() throws Exception {
			Thread.sleep(3000);
			WebElement Cal = d.findElement(By.xpath("//*[text()='Slider']"));
			WebElement tar = d.findElement(By.xpath("//*[text()='Drag & Drop Field Here']"));
			Actions DD = new Actions(d);
			DD.clickAndHold(Cal).moveByOffset(0, 10).moveToElement(tar, 0, -10).release().perform();
		Thread.sleep(2000);
		
		d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Weight");
		d.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("Weight");
		d.findElement(By.xpath("(//*[@type='text'])[5]")).sendKeys("kg");
		d.findElement(By.xpath("//*[@placeholder='Minimum']")).sendKeys("10");
		d.findElement(By.xpath("//*[@placeholder='Maximum']")).sendKeys("100");
		Thread.sleep(2000);
		d.findElement(By.xpath("(//*[@type='number'])[5]")).sendKeys("1");
		Thread.sleep(3000);
		
		d.findElement(By.xpath("//*[text()='Build Harmonisation']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//*[text()='Select Resource Type']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//*[text()='Observation']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[2]")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//*[text()='Alit Edc Pani']")).click();
		d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Weight");
		Thread.sleep(3000);
		d.findElement(By.xpath("(//*[@type='checkbox'])[1]")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//*[text()='Observation'])[2]")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//*[text()='All']")).click();
		Thread.sleep(3000);
		WebElement RT1 = d.findElement(By.xpath("//*[text()='Return Answer Equals to:']"));
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].scrollIntoView();", RT1);
		js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", d.findElement(By.xpath(("(//*[@aria-haspopup='listbox'])[4]"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@aria-haspopup='listbox'])[4]")));
		d.findElement(By.xpath(("(//*[@aria-haspopup='listbox'])[4]"))).click();
		Thread.sleep(2000);
		js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", d.findElement(By.xpath("//*[text()='Observation.value']")));
		d.findElement(By.xpath("//*[text()='Observation.value']")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("//*[text()='Add new field']")).click();
		Thread.sleep(3000);
		
	}
		
		@And("Add BMI")
		public void BMI() throws Exception {
			
			
			WebElement Cal = d.findElement(By.xpath("//*[text()='Calculation']"));
			WebElement tar = d.findElement(By.xpath("//*[text()='Drag & Drop Field Here']"));
			Actions DD = new Actions(d);
			DD.clickAndHold(Cal).moveByOffset(0, 10).moveToElement(tar, 0, -10).release().perform();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("BMI");
			d.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("BMI");
			d.findElement(By.xpath("(//*[@type='text'])[5]")).sendKeys("BMI");
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Select Variable']")).click();
			d.findElement(By.xpath("(//*[text()='Weight'])[5]")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='{{Weight}}']")).sendKeys("/");
			d.findElement(By.xpath("//*[text()='Select Variable']")).click();
			d.findElement(By.xpath("(//*[text()='Height'])[5]")).click();
			Thread.sleep(3000);
			
			d.findElement(By.xpath("//*[text()='Add new field']")).click();
			Thread.sleep(3000);
			
		}
		@And("Add Hba1c Fields")
		public void Add_Fields() throws Exception {
			Thread.sleep(3000);
			WebElement Cal = d.findElement(By.xpath("//*[text()='Number']"));
			WebElement tar = d.findElement(By.xpath("//*[text()='Drag & Drop Field Here']"));
			Actions DD = new Actions(d);
			DD.clickAndHold(Cal).moveByOffset(0, 10).moveToElement(tar, 0, -10).release().perform();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Highest value of HbA1C");
			d.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("Hba1c");
			d.findElement(By.xpath("(//*[@type='text'])[5]")).sendKeys("Percentage");
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Build Harmonisation']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Select Resource Type']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Observation']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[2]")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Alit Edc Pani']")).click();
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Hba1c");
			Thread.sleep(3000);
			d.findElement(By.xpath("(//*[@type='checkbox'])[1]")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[text()='Observation'])[2]")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='All']")).click();
			WebElement RT = d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[4]"));
			JavascriptExecutor js = (JavascriptExecutor) d;
			js.executeScript("arguments[0].scrollIntoView();", RT);
			js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", RT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@aria-haspopup='listbox'])[4]")));
			RT.click();
			Thread.sleep(2000);
			js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", d.findElement(By.xpath("//*[text()='Observation.value']")));
			d.findElement(By.xpath("//*[text()='Observation.value']")).click();
			Thread.sleep(3000);
			d.findElement(By.xpath("//*[text()='Add new field']")).click();
			Thread.sleep(3000);
		}
		
		@And("Add PCOS Date Fields")
		public void Add_Date_Fields() throws Exception {
			Thread.sleep(3000);
			WebElement Cal = d.findElement(By.xpath("//*[text()='Date']"));
			WebElement tar = d.findElement(By.xpath("//*[text()='Drag & Drop Field Here']"));
			Actions DD = new Actions(d);
			DD.clickAndHold(Cal).moveByOffset(0, 10).moveToElement(tar, 0, -10).release().perform();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("When was PCOS first discovered?");
			d.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("PCOS");
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Build Harmonisation']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Select Resource Type']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Condition']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[2]")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Alit Edc Pani']")).click();
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("polycystic ovarian syndrome");
			Thread.sleep(3000);
			d.findElement(By.xpath("(//*[@type='checkbox'])[1]")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[text()='Condition'])[2]")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='All']")).click();
			WebElement RT = d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[3]"));
			JavascriptExecutor js = (JavascriptExecutor) d;
			js.executeScript("arguments[0].scrollIntoView();", RT);
			js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", RT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@aria-haspopup='listbox'])[3]")));
			RT.click();
			Thread.sleep(2000);
			js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", d.findElement(By.xpath("//*[text()='Condition.issued_dt']")));
			d.findElement(By.xpath("//*[text()='Condition.issued_dt']")).click();
			Thread.sleep(3000);
			d.findElement(By.xpath("//*[text()='Add new field']")).click();
			Thread.sleep(3000);
		}
		@Then("Add Covid vaccination date")
		public void Vaccination_Date() throws Exception {
			Thread.sleep(3000);
			WebElement Cal = d.findElement(By.xpath("//*[text()='Date']"));
			WebElement tar = d.findElement(By.xpath("//*[text()='Drag & Drop Field Here']"));
			Actions DD = new Actions(d);
			DD.clickAndHold(Cal).moveByOffset(0, 10).moveToElement(tar, 0, -10).release().perform();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Last covid vaccination date?");
			d.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("Date");
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Build Harmonisation']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Select Resource Type']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Immunization']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[2]")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Alit Edc Pani']")).click();
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("covishield");
			Thread.sleep(3000);
			d.findElement(By.xpath("(//*[@type='checkbox'])[1]")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[text()='Immunization'])[2]")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='All']")).click();
			WebElement RT = d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[3]"));
			JavascriptExecutor js = (JavascriptExecutor) d;
			js.executeScript("arguments[0].scrollIntoView();", RT);
			js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", RT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@aria-haspopup='listbox'])[3]")));
			RT.click();
			Thread.sleep(2000);
			js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", d.findElement(By.xpath("//*[text()='Immunization.code']")));
			d.findElement(By.xpath("//*[text()='Immunization.code']")).click();
			Thread.sleep(3000);
			d.findElement(By.xpath("//*[text()='Add new field']")).click();
			Thread.sleep(3000);
		}
		
		@And("Add Birth Year")
		public void Birth_Year() throws Exception {
			Thread.sleep(3000);
			WebElement Cal = d.findElement(By.xpath("//*[text()='Year']"));
			WebElement tar = d.findElement(By.xpath("//*[text()='Drag & Drop Field Here']"));
			Actions DD = new Actions(d);
			DD.clickAndHold(Cal).moveByOffset(0, 10).moveToElement(tar, 0, -10).release().perform();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Birth Year?");
			d.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("Year");
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Build Harmonisation']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Select Resource Type']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Patient']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='All']")).click();
			WebElement RT = d.findElement(By.xpath("//*[@id='HARFUNC_RESOURCE_NAME']"));
			JavascriptExecutor js = (JavascriptExecutor) d;
			js.executeScript("arguments[0].scrollIntoView();", RT);
			js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", RT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@aria-haspopup='listbox'])[3]")));
			RT.click();
			Thread.sleep(2000);
			js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", d.findElement(By.xpath("//*[text()='Patient.birth_date']")));
			d.findElement(By.xpath("//*[text()='Patient.birth_date']")).click();
			Thread.sleep(3000);
			d.findElement(By.xpath("//*[text()='Add new field']")).click();
			Thread.sleep(3000);
		}
		
		
		@And("Add Option Group")
		public void Option_Group() throws Exception{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Option Groups']")));
			d.findElement(By.xpath("//*[text()='Option Groups']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()=' Add Option Groups']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[2]")).sendKeys("Gender Option Group");
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Gender");
			Thread.sleep(3000);
			d.findElement(By.xpath("//*[text()='+ Add new Option']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("Male");
			d.findElement(By.xpath("(//*[@type='text'])[5]")).sendKeys("1");
			d.findElement(By.xpath("(//*[@type='text'])[6]")).sendKeys("Male");
			Thread.sleep(3000);
			d.findElement(By.xpath("//*[text()='+ Add new Option']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[7]")).sendKeys("Female");
			d.findElement(By.xpath("(//*[@type='text'])[8]")).sendKeys("2");
			d.findElement(By.xpath("(//*[@type='text'])[9]")).sendKeys("Female");
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Add']")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Screening Visit']")));
			d.findElement(By.xpath("//*[text()='Screening Visit']")).click();
			Thread.sleep(5000);
			d.findElement(By.xpath("//*[text()='Visit_1']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='V1']")).click();
		}
		
		@Then("Add Gender Field")
		public void Gender_Field() throws Exception {
			Thread.sleep(3000);
			WebElement Cal = d.findElement(By.xpath("//*[text()='Radio']"));
			WebElement tar = d.findElement(By.xpath("//*[text()='Drag & Drop Field Here']"));
			Actions DD = new Actions(d);
			DD.clickAndHold(Cal).moveByOffset(0, 10).moveToElement(tar, 0, -10).release().perform();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Gender");
			d.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("Gender");
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[3]")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Gender Option Group']")).click();
			Thread.sleep(3000);
			d.findElement(By.xpath("//*[text()='Build Harmonisation']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Select Resource Type']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Patient']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='All']")).click();
			WebElement RT = d.findElement(By.xpath("(//*[text()='Resource Name'])[1]"));
			JavascriptExecutor js = (JavascriptExecutor) d;
			js.executeScript("arguments[0].scrollIntoView();", RT);
			js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", RT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@aria-haspopup='listbox'])[3]")));
			RT.click();
			Thread.sleep(2000);
			js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", d.findElement(By.xpath("//*[text()='Patient.gender']")));
			d.findElement(By.xpath("//*[text()='Patient.gender']")).click();
			Thread.sleep(3000);
			d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[4]")).click();
			d.findElement(By.xpath("//*[text()='Is Equal To']")).click();
			Thread.sleep(3000);
			d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[5]")).click();
			d.findElement(By.xpath("(//*[text()='Male'])[2]")).click();
			Thread.sleep(3000);
            d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[6]")).click();
            Thread.sleep(2000);
            js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", d.findElement(By.xpath("(//*[text()='Patient.gender'])[2]")));
			d.findElement(By.xpath("(//*[text()='Patient.gender'])[2]")).click();
			Thread.sleep(3000);
			d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[7]")).click();
			d.findElement(By.xpath("(//*[text()='Is Equal To'])[2]")).click();
			Thread.sleep(3000);
			d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[8]")).click();
			d.findElement(By.xpath("(//*[text()='Female'])[2]")).click();
			Thread.sleep(3000);
			d.findElement(By.xpath("//*[text()='Add new field']")).click();
			Thread.sleep(3000);
		}
		
		@And("Add Yes/No Option")
		public void Option_Yes_No() throws Exception{
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
		}
		
		@And("Does the patient has cancer?")
		public void Patient_has_Cancer() throws Exception {
			Thread.sleep(3000);
			WebElement Cal = d.findElement(By.xpath("//*[text()='Radio']"));
			WebElement tar = d.findElement(By.xpath("//*[text()='Drag & Drop Field Here']"));
			Actions DD = new Actions(d);
			DD.clickAndHold(Cal).moveByOffset(0, 10).moveToElement(tar, 0, -10).release().perform();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Does the patient has cancer?");
			d.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("Yes OR No");
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[3]")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Yes/No Option Group']")).click();
			Thread.sleep(3000);
			d.findElement(By.xpath("//*[text()='Add new field']")).click();
			Thread.sleep(3000);
		
	}
		@And("Add Discharge Summary")
		public void Discharge_Summary() throws Exception {
			
			WebElement Cal = d.findElement(By.xpath("//*[text()='Long Text']"));
			WebElement tar = d.findElement(By.xpath("//*[text()='Drag & Drop Field Here']"));
			Actions DD = new Actions(d);
			DD.clickAndHold(Cal).moveByOffset(0, 10).moveToElement(tar, 0, -10).release().perform();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Discharge Summary");
			d.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("Text");
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Add new field']")).click();
			Thread.sleep(3000);
		}
		
		@Then("Add Asthma OG")
		public void Asthma_G() throws Exception{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Option Groups']")));
			d.findElement(By.xpath("//*[text()='Option Groups']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()=' Add Option Groups']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[2]")).sendKeys("Asthma Option Group");
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Checkbox");
			Thread.sleep(3000);
			d.findElement(By.xpath("//*[text()='+ Add new Option']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("Allergic Asthma");
			d.findElement(By.xpath("(//*[@type='text'])[5]")).sendKeys("1");
			d.findElement(By.xpath("(//*[@type='text'])[6]")).sendKeys("Allergic Asthma");
			Thread.sleep(3000);
			d.findElement(By.xpath("//*[text()='+ Add new Option']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[7]")).sendKeys("Moderate Persistent Asthma");
			d.findElement(By.xpath("(//*[@type='text'])[8]")).sendKeys("2");
			d.findElement(By.xpath("(//*[@type='text'])[9]")).sendKeys("Moderate Persistent Asthma");
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='+ Add new Option']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[10]")).sendKeys("Bronchitis Asthma, Acute");
			d.findElement(By.xpath("(//*[@type='text'])[11]")).sendKeys("3");
			d.findElement(By.xpath("(//*[@type='text'])[12]")).sendKeys("Bronchitis Asthma, Acute");
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Add']")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Screening Visit']")));
			d.findElement(By.xpath("//*[text()='Screening Visit']")).click();
			Thread.sleep(5000);
			d.findElement(By.xpath("//*[text()='Visit_1']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='V1']")).click();
		}
		
		
		@And("Add What kind of Asthma the patient has?")
		public void Asthma_Kind() throws Exception {
			Thread.sleep(3000);
			WebElement Cal = d.findElement(By.xpath("//*[text()='Checkbox']"));
			WebElement tar = d.findElement(By.xpath("//*[text()='Drag & Drop Field Here']"));
			Actions DD = new Actions(d);
			DD.clickAndHold(Cal).moveByOffset(0, 10).moveToElement(tar, 0, -10).release().perform();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("What kind of Asthma the patient has?");
			d.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("Asthma");
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[3]")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Asthma Option Group']")).click();
			Thread.sleep(3000);
			d.findElement(By.xpath("//*[text()='Build Harmonisation']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Select Resource Type']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Condition']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[2]")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Alit Edc Pani']")).click();
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Asthma");
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='checkbox'])[4]")).click();
			d.findElement(By.xpath("(//*[@type='checkbox'])[5]")).click();
			d.findElement(By.xpath("(//*[@type='checkbox'])[6]")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[text()='Condition'])[2]")).click();
			d.findElement(By.xpath("(//*[text()='Condition'])[2]")).click();
			Thread.sleep(2000);
			
			d.findElement(By.xpath("//*[text()='All']")).click();
			JavascriptExecutor js = (JavascriptExecutor) d;
			
			WebElement RT = d.findElement(By.xpath("(//*[text()='Resource Name'])[1]"));
			
			js.executeScript("arguments[0].scrollIntoView();", RT);
			js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", RT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@aria-haspopup='listbox'])[3]")));
			RT.click();
			Thread.sleep(2000);
			js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", d.findElement(By.xpath("//*[text()='Condition.code']")));
			d.findElement(By.xpath("//*[text()='Condition.code']")).click();
			Thread.sleep(3000);
			d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[4]")).click();
			d.findElement(By.xpath("//*[text()='Is Equal To']")).click();
			Thread.sleep(3000);
			d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[5]")).click();
			d.findElement(By.xpath("(//*[text()='SNOMED :: 389145006'])[2]")).click();
			Thread.sleep(3000);
	        d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[6]")).click();
	        Thread.sleep(2000);
	        js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", d.findElement(By.xpath("(//*[text()='Condition.code'])[2]")));
			d.findElement(By.xpath("(//*[text()='Condition.code'])[2]")).click();
			Thread.sleep(3000);
			d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[7]")).click();
			d.findElement(By.xpath("(//*[text()='Is Equal To'])[2]")).click();
			Thread.sleep(3000);
			d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[8]")).click();
			d.findElement(By.xpath("(//*[text()='SNOMED :: 427295004'])[2]")).click();
			Thread.sleep(3000);
	        d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[9]")).click();
	        Thread.sleep(2000);
	        js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", d.findElement(By.xpath("(//*[text()='Condition.code'])[3]")));
			d.findElement(By.xpath("(//*[text()='Condition.code'])[3]")).click();
			Thread.sleep(3000);
			d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[10]")).click();
			d.findElement(By.xpath("(//*[text()='Is Equal To'])[3]")).click();
			Thread.sleep(3000);
			d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[11]")).click();
			d.findElement(By.xpath("(//*[text()='SNOMED :: 405944004'])[2]")).click();
			Thread.sleep(3000);
			d.findElement(By.xpath("//*[text()='Add new field']")).click();
			Thread.sleep(3000);
			
		}
		@Then("Add Allergy OG")
		public void Allergy_OG() throws Exception {
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Option Groups']")));
			d.findElement(By.xpath("//*[text()='Option Groups']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()=' Add Option Groups']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[2]")).sendKeys("Allergy Option Group");
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Checkbox");
			Thread.sleep(3000);
			d.findElement(By.xpath("//*[text()='+ Add new Option']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("Latex");
			d.findElement(By.xpath("(//*[@type='text'])[5]")).sendKeys("1");
			d.findElement(By.xpath("(//*[@type='text'])[6]")).sendKeys("Latex");
			Thread.sleep(3000);
			d.findElement(By.xpath("//*[text()='+ Add new Option']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[7]")).sendKeys("Peanuts");
			d.findElement(By.xpath("(//*[@type='text'])[8]")).sendKeys("2");
			d.findElement(By.xpath("(//*[@type='text'])[9]")).sendKeys("Peanuts");
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='+ Add new Option']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[10]")).sendKeys("Lactose");
			d.findElement(By.xpath("(//*[@type='text'])[11]")).sendKeys("3");
			d.findElement(By.xpath("(//*[@type='text'])[12]")).sendKeys("Lactose");
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Add']")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Screening Visit']")));
			d.findElement(By.xpath("//*[text()='Screening Visit']")).click();
			Thread.sleep(5000);
			d.findElement(By.xpath("//*[text()='Visit_1']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='V1']")).click();
		}
		
		@And("What allergies the patient has?")
		public void Allergy_type() throws Exception {
		Thread.sleep(3000);
		WebElement Cal = d.findElement(By.xpath("//*[text()='Checkbox']"));
		WebElement tar = d.findElement(By.xpath("//*[text()='Drag & Drop Field Here']"));
		Actions DD = new Actions(d);
		DD.clickAndHold(Cal).moveByOffset(0, 10).moveToElement(tar, 0, -10).release().perform();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("What allergies the patient has?");
		d.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("Allergy");
		Thread.sleep(2000);
		d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[3]")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//*[text()='Allergy Option Group']")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("//*[text()='Build Harmonisation']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//*[text()='Select Resource Type']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//*[text()='AllergyIntolerance']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[2]")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//*[text()='Alit Edc Pani']")).click();
		d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Allergy");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) d;
		
		WebElement ele = d.findElement(By.xpath("//*[text()='Lactose Allergy']//parent::div//parent::div//descendant::span[@class='MuiTouchRipple-root']"));
		
		Actions actions = new Actions(d);
		actions.moveToElement(ele).click().build().perform();
		WebElement ele2 = d.findElement(By.xpath("//*[text()='Latex Allergy']//parent::div//parent::div//descendant::span[@class='MuiTouchRipple-root']"));
		actions.moveToElement(ele2).click().build().perform();
		
		Thread.sleep(2000);
		d.findElement(By.xpath("(//*[text()='AllergyIntolerance'])[2]")).click();
		d.findElement(By.xpath("(//*[text()='AllergyIntolerance'])[2]")).click();
		Thread.sleep(2000);
		
		
        d.findElement(By.xpath("(//*[text()='AllergyIntolerance'])[1]")).click();
		Thread.sleep(1000);
		d.findElement(By.xpath("//*[text()='Condition']")).click();
		d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Peanut");
		Thread.sleep(2000);
		actions.moveToElement(d.findElement(By.xpath("//*[text()='Peanut Allergy']//parent::div//parent::div//descendant::span[@class='MuiTouchRipple-root']")))
		.click().build().perform();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//*[text()='Condition'])[2]")).click();
		d.findElement(By.xpath("(//*[text()='Condition'])[2]")).click(); 
		
		d.findElement(By.xpath("//*[text()='All']")).click();
		
		
		WebElement RT = d.findElement(By.xpath("(//*[text()='Resource Name'])[1]"));
		
		js.executeScript("arguments[0].scrollIntoView();", RT);
		js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", RT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@aria-haspopup='listbox'])[3]")));
		RT.click();
		Thread.sleep(2000);
		js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", d.findElement(By.xpath("//*[text()='Condition.code']")));
		d.findElement(By.xpath("//*[text()='Condition.code']")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[4]")).click();
		d.findElement(By.xpath("//*[text()='Is Equal To']")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[5]")).click();
		d.findElement(By.xpath("(//*[text()='RXNORM :: 1314891'])[2]")).click();
		Thread.sleep(3000);
        d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[6]")).click();
        Thread.sleep(2000);
        js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", d.findElement(By.xpath("(//*[text()='Condition.code'])[2]")));
		d.findElement(By.xpath("(//*[text()='Condition.code'])[2]")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[7]")).click();
		d.findElement(By.xpath("(//*[text()='Is Equal To'])[2]")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[8]")).click();
		d.findElement(By.xpath("(//*[text()='SNOMED :: 39937001125'])[2]")).click();
		Thread.sleep(3000);
        d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[9]")).click();
        Thread.sleep(2000);
        js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", d.findElement(By.xpath("(//*[text()='Condition.code'])[3]")));
		d.findElement(By.xpath("(//*[text()='Condition.code'])[3]")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[10]")).click();
		d.findElement(By.xpath("(//*[text()='Is Equal To'])[3]")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[11]")).click();
		d.findElement(By.xpath("(//*[text()='RXNORM :: 6211'])[2]")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("//*[text()='Add new field']")).click();
		Thread.sleep(3000);
		
}
		
		@Then("Add Metastasis Stage OG")
		public void Metastasis_Stage_OG() throws Exception {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Option Groups']")));
			d.findElement(By.xpath("//*[text()='Option Groups']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()=' Add Option Groups']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[2]")).sendKeys("Metastasis Stage OG");
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("DropDown");
			Thread.sleep(3000);
			d.findElement(By.xpath("//*[text()='+ Add new Option']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("Metastatic");
			d.findElement(By.xpath("(//*[@type='text'])[5]")).sendKeys("1");
			d.findElement(By.xpath("(//*[@type='text'])[6]")).sendKeys("M");
			Thread.sleep(3000);
			d.findElement(By.xpath("//*[text()='+ Add new Option']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[7]")).sendKeys("Non-metastatic (confirmed)");
			d.findElement(By.xpath("(//*[@type='text'])[8]")).sendKeys("2");
			d.findElement(By.xpath("(//*[@type='text'])[9]")).sendKeys("NMC");
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='+ Add new Option']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[10]")).sendKeys("Non-metastatic (unconfirmed)");
			d.findElement(By.xpath("(//*[@type='text'])[11]")).sendKeys("3");
			d.findElement(By.xpath("(//*[@type='text'])[12]")).sendKeys("NMU");
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Add']")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Screening Visit']")));
			d.findElement(By.xpath("//*[text()='Screening Visit']")).click();
			Thread.sleep(5000);
			d.findElement(By.xpath("//*[text()='Visit_1']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='V1']")).click();
		}
		@And("Metastasis at diagnosis assessment status")
		public void Metastasis_Stage() throws Exception {
			Thread.sleep(3000);
			WebElement Cal = d.findElement(By.xpath("//*[text()='Dropdown']"));
			WebElement tar = d.findElement(By.xpath("//*[text()='Drag & Drop Field Here']"));
			Actions DD = new Actions(d);
			DD.clickAndHold(Cal).moveByOffset(0, 10).moveToElement(tar, 0, -10).release().perform();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Metastasis at diagnosis assessment status");
			d.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("Metastasis");
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[3]")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Metastasis Stage OG']")).click();
			Thread.sleep(3000);
			d.findElement(By.xpath("//*[text()='Add new field']")).click();
			Thread.sleep(3000);
		}
		@And("Add Sys BPs")
		public void Sys_Bp() throws Exception {
			
			WebElement Cal = d.findElement(By.xpath("//*[text()='Number']"));
			WebElement tar = d.findElement(By.xpath("//*[text()='Drag & Drop Field Here']"));
			Actions DD = new Actions(d);
			DD.clickAndHold(Cal).moveByOffset(0, 10).moveToElement(tar, 0, -10).release().perform();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Sys. BP");
			d.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("BP");
			d.findElement(By.xpath("(//*[@type='text'])[5]")).sendKeys("Units");
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Build Harmonisation']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Select Resource Type']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Observation']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[3]")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Alit Edc Pani']")).click();
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("blood pressure");
			Thread.sleep(2000);
			
			DD.moveToElement(d.findElement(By.xpath("//*[text()='Systolic blood pressure test time']//parent::div//parent::div//descendant::span[@class='MuiTouchRipple-root']"))).click().build().perform();
			d.findElement(By.xpath("(//*[text()='Observation'])[2]")).click();
			Thread.sleep(2000);
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='All']")).click();
			WebElement RT = d.findElement(By.xpath("//*[@id='HARFUNC_RESOURCE_NAME']"));
			JavascriptExecutor js = (JavascriptExecutor) d;
			js.executeScript("arguments[0].scrollIntoView();", RT);
			js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", RT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@aria-haspopup='listbox'])[3]")));
			RT.click();
			Thread.sleep(2000);
			js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", d.findElement(By.xpath("//*[text()='Observation.value']")));
			d.findElement(By.xpath("//*[text()='Observation.value']")).click();
			Thread.sleep(3000);
			
			d.findElement(By.xpath("//*[text()='Add new field']")).click();
			Thread.sleep(3000);
			
		}
		
		@And("Add Dia BPs")
		public void Dia_Bp() throws Exception {
			
			Thread.sleep(3000);
			WebElement Cal = d.findElement(By.xpath("//*[text()='Number']"));
			WebElement tar = d.findElement(By.xpath("//*[text()='Drag & Drop Field Here']"));
			Actions DD = new Actions(d);
			DD.clickAndHold(Cal).moveByOffset(0, 10).moveToElement(tar, 0, -10).release().perform();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Dia. BP");
			d.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("DiaBP");
			d.findElement(By.xpath("(//*[@type='text'])[5]")).sendKeys("Units");
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Build Harmonisation']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Select Resource Type']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Observation']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[3]")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Alit Edc Pani']")).click();
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("blood pressure");
			Thread.sleep(2000);
			DD.moveToElement(d.findElement(By.xpath("//*[text()='Diastolic blood pressure']//parent::div//parent::div//descendant::span[@class='MuiTouchRipple-root']"))).click().build().perform();

			d.findElement(By.xpath("(//*[text()='Observation'])[2]")).click();
			Thread.sleep(2000);
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='All']")).click();
			WebElement RT = d.findElement(By.xpath("//*[@id='HARFUNC_RESOURCE_NAME']"));
			JavascriptExecutor js = (JavascriptExecutor) d;
			js.executeScript("arguments[0].scrollIntoView();", RT);
			js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", RT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@aria-haspopup='listbox'])[3]")));
			RT.click();
			Thread.sleep(2000);
			js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", d.findElement(By.xpath("//*[text()='Observation.value']")));
			d.findElement(By.xpath("//*[text()='Observation.value']")).click();
			Thread.sleep(3000);
			
			d.findElement(By.xpath("//*[text()='Add new field']")).click();
			Thread.sleep(3000);
		}
		@And("Add WBC")
		public void WBC() throws Exception {
			Thread.sleep(3000);
			WebElement Cal = d.findElement(By.xpath("//*[text()='Number']"));
			WebElement tar = d.findElement(By.xpath("//*[text()='Drag & Drop Field Here']"));
			Actions DD = new Actions(d);
			DD.clickAndHold(Cal).moveByOffset(0, 10).moveToElement(tar, 0, -10).release().perform();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("WBC");
			d.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("WBC");
			d.findElement(By.xpath("(//*[@type='text'])[5]")).sendKeys("(K/uL)");
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Build Harmonisation']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Select Resource Type']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Observation']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[3]")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Alit Edc Pani']")).click();
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("leukocyte");
			Thread.sleep(2000);
			DD.moveToElement(d.findElement(By.xpath("//*[text()='Leukocytes [#/volume] in Blood by Automated count']//parent::div//parent::div//descendant::span[@class='MuiTouchRipple-root']"))).click().build().perform();

			d.findElement(By.xpath("(//*[text()='Observation'])[2]")).click();
			Thread.sleep(2000);
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='All']")).click();
			WebElement RT = d.findElement(By.xpath("//*[@id='HARFUNC_RESOURCE_NAME']"));
			JavascriptExecutor js = (JavascriptExecutor) d;
			js.executeScript("arguments[0].scrollIntoView();", RT);
			js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", RT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@aria-haspopup='listbox'])[3]")));
			RT.click();
			Thread.sleep(2000);
			js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", d.findElement(By.xpath("//*[text()='Observation.value']")));
			d.findElement(By.xpath("//*[text()='Observation.value']")).click();
			Thread.sleep(3000);
			
			d.findElement(By.xpath("//*[text()='Add new field']")).click();
			Thread.sleep(3000);
		}
		@And("Add RBC")
		public void RBC() throws Exception {
			Thread.sleep(3000);
			WebElement Cal = d.findElement(By.xpath("//*[text()='Number']"));
			WebElement tar = d.findElement(By.xpath("//*[text()='Drag & Drop Field Here']"));
			Actions DD = new Actions(d);
			DD.clickAndHold(Cal).moveByOffset(0, 10).moveToElement(tar, 0, -10).release().perform();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("RBC");
			d.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("RBC");
			d.findElement(By.xpath("(//*[@type='text'])[5]")).sendKeys("(K/uL)");
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Build Harmonisation']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Select Resource Type']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Observation']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[3]")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Alit Edc Pani']")).click();
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("erythrocyte");
			Thread.sleep(2000);
			DD.moveToElement(d.findElement(By.xpath("//*[text()='Erythrocytes[#/volume] in Blood by Automated count']//parent::div//parent::div//descendant::span[@class='MuiTouchRipple-root']"))).click().build().perform();

			d.findElement(By.xpath("(//*[text()='Observation'])[2]")).click();
			Thread.sleep(2000);
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='All']")).click();
			WebElement RT = d.findElement(By.xpath("//*[@id='HARFUNC_RESOURCE_NAME']"));
			JavascriptExecutor js = (JavascriptExecutor) d;
			js.executeScript("arguments[0].scrollIntoView();", RT);
			js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", RT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@aria-haspopup='listbox'])[3]")));
			RT.click();
			Thread.sleep(2000);
			js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", d.findElement(By.xpath("//*[text()='Observation.value']")));
			d.findElement(By.xpath("//*[text()='Observation.value']")).click();
			Thread.sleep(3000);
			
			d.findElement(By.xpath("//*[text()='Add new field']")).click();
			Thread.sleep(3000);
		
		}
		@Then("Add Platelets")
		public void Platelets() throws Exception {
			Thread.sleep(3000);
			WebElement Cal = d.findElement(By.xpath("//*[text()='Number']"));
			WebElement tar = d.findElement(By.xpath("//*[text()='Drag & Drop Field Here']"));
			Actions DD = new Actions(d);
			DD.clickAndHold(Cal).moveByOffset(0, 10).moveToElement(tar, 0, -10).release().perform();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Platelets");
			d.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("Platelets");
			d.findElement(By.xpath("(//*[@type='text'])[5]")).sendKeys("Count");
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Build Harmonisation']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Select Resource Type']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Observation']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[3]")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='Alit Edc Pani']")).click();
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Platelets");
			Thread.sleep(2000);
			DD.moveToElement(d.findElement(By.xpath("//*[text()='Platelets [#/volume] in Blood by Automated count']//parent::div//parent::div//descendant::span[@class='MuiTouchRipple-root']"))).click().build().perform();

			d.findElement(By.xpath("(//*[text()='Observation'])[2]")).click();
			Thread.sleep(2000);
			Thread.sleep(2000);
			d.findElement(By.xpath("//*[text()='All']")).click();
			WebElement RT = d.findElement(By.xpath("//*[@id='HARFUNC_RESOURCE_NAME']"));
			JavascriptExecutor js = (JavascriptExecutor) d;
			js.executeScript("arguments[0].scrollIntoView();", RT);
			js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", RT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@aria-haspopup='listbox'])[3]")));
			RT.click();
			Thread.sleep(2000);
			js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", d.findElement(By.xpath("//*[text()='Observation.value']")));
			d.findElement(By.xpath("//*[text()='Observation.value']")).click();
			Thread.sleep(3000);
			
			d.findElement(By.xpath("//*[text()='Add new field']")).click();
			Thread.sleep(3000);
			
		}
		@And("Add Condition")
		public void Condition() throws Exception {
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Add Group']")));
			d.findElement(By.xpath("//*[text()='Add Group']")).click();
			d.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("Condition");
			d.findElement(By.xpath("//*[@id='GROUP_DESCRIPTION']")).sendKeys("Harfunc Group");
			d.findElement(By.xpath("(//*[text()='Add Group'])[3]")).click();
			
		}
}
		
		


