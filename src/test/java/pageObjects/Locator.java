package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class Locator {

	public WebDriver ldriver;
	
	public Locator(WebDriver rdriver) {
		ldriver =rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[text()='Number']")
	@CacheLookup
	WebElement Num;
	
	
	@FindBy(xpath="//*[text()='Slider']")
	@CacheLookup
	WebElement slid;
	
	@FindBy(xpath="//*[text()='Calculation']")
	@CacheLookup
	WebElement Cal;
	
    @FindBy(xpath="//*[text()='Date']")
    @CacheLookup
    WebElement Date;
    @FindBy(xpath="//*[text()='Time']")
    @CacheLookup
    WebElement Time;
    
    @FindBy(xpath="//*[text()='Radio']")
    @CacheLookup
    WebElement Radio;
    
    @FindBy(xpath="//*[text()='Checkbox']")
    @CacheLookup
    WebElement Check;
	
    @FindBy(xpath="//*[text()='Dropdown']")
    @CacheLookup
    WebElement DD;
    
    @FindBy(xpath="//*[text()='Checkbox']")
    @CacheLookup
    WebElement start;
	
    @FindBy(xpath="(//*[@type='text'])[3]")
    @CacheLookup
    WebElement Label;
    
    @FindBy(xpath="(//*[@type='text'])[4]")
    @CacheLookup
    WebElement Variablename;
    
    
    
    


public void Number () {
	

	
}}
