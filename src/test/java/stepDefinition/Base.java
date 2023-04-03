package stepDefinition;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.codehaus.plexus.util.FileUtils;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;


public class Base {
	
	
	public static void main(String[]args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/naveenraj/Downloads/chromedriver_mac_arm64/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://demo.automationtesting.in/Static.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement src = driver.findElement(By.xpath("(//*[@src='original.png'])[2]"));
		WebElement des = driver.findElement(By.xpath("//*[@ID='droparea']"));
		
		Actions DD = new Actions(driver);
		DD.dragAndDrop(src, des).perform();
		
	/*	// first, get the source and target elements as JavaScript objects
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("let source = arguments[0], target = arguments[1];", src, des);

		// next, create a new action chain and perform the drag and drop action using JavaScript
		Actions action = new Actions(driver);
		action.clickAndHold(src).moveToElement(des).release().build().perform();
		js.executeScript("let evt = document.createEvent('MouseEvents');" +
		                 "evt.initMouseEvent('mouseup', true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
		                 "arguments[0].dispatchEvent(evt);", des);
		                 */
		
	}
	

}
