package pages;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

public class DashboardPage {
	WebDriver driver;
	static Logger log = Logger.getLogger(LoginPage.class);
	
	public DashboardPage(WebDriver driver) {
		PropertyConfigurator.configure("log4j.properties");
		log.info(": UserLogin Constructor called");
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@class, 'dropdown-toggle')]")
	public WebElement userNameDroDown;
	
	@FindBy(xpath="//div[contains(@ng-if, 'selectedLanguage ')]//following::a[text()='English']")
	public WebElement english;
	
	@FindBy(xpath="//div[contains(@ng-if, 'selectedLanguage ')]//following::div[text()='Japanese']")
	public WebElement japanese;
	
	@FindBy(xpath="//li[contains(@class, 'mactive')]//a[1]")
	public WebElement menuDashboard;
}