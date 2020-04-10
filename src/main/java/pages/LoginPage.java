package pages;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

public class LoginPage {
	
	WebDriver driver;
	static Logger log = Logger.getLogger(LoginPage.class);
	
	public LoginPage(WebDriver driver) {
		PropertyConfigurator.configure("log4j.properties");
		log.info(": UserLogin Constructor called");
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='text']")
	public WebElement userName;
	
	@FindBy(xpath="//input[@type='password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement signIn;
}