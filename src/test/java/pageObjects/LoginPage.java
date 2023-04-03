package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver =rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[@type='email']")
	@CacheLookup
	WebElement textEmail;
	
	@FindBy(xpath="//*[@type='password']")
	@CacheLookup
	WebElement textPass;
	
	@FindBy(xpath="(//*[@class=\"MuiTypography-root MuiTypography-body1\"])[7]")
	@CacheLookup
	WebElement loginButton;
	
    @FindBy(xpath="//*[@role='button']")
    @CacheLookup
    WebElement Dd;
    @FindBy(xpath="//*[text()='DR.New Test2']")
    @CacheLookup
    WebElement ops;
    
    @FindBy(xpath="//*[@type='button']")
    @CacheLookup
    WebElement cli;
    
    @FindBy(xpath="(//*[@type='button'])[3]")
    @CacheLookup
    WebElement start;
	
	public void setUserName(String uname) {
		textEmail.clear();
		textEmail.sendKeys(uname);
	}
	public void setPassword(String pass) {
		textPass.clear();
		textPass.sendKeys(pass);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public void select() {
		Dd.click();
	    
	}	
	
	public void dropdown() {
		ops.click();
	}
	
	public void Get() {
		cli.click();
	}
	
	public void start() {
	
		start.click();
		
	}
	
	
}
