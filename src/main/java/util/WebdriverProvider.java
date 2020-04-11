package util;

import java.net.MalformedURLException;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

import base.Configs;

/**
 * This class is responsible for providing the WebDriver instance on request.
 *
 */

public class WebdriverProvider {
	
	protected WebDriver driver;
	String paramBrowser;
	
	static Logger log = Logger.getLogger(WebdriverProvider.class);
	
	public WebdriverProvider() {
		super();
		PropertyConfigurator.configure("log4j.properties");
		log.info(" : WebdriverProvider Constructor called");
	}
	
	@BeforeSuite
	public void beforeSuite_WebdriverProvider(){
		log.info(" : WebdriverProvider - beforeSuite called");
	}
	
	@Parameters({ "browser" })
	@BeforeTest
	public void beforeTest_WebdriverProvider(String browser) throws MalformedURLException {
		log.info(" : WebdriverProvider - beforeTest called");
		Configs.initConfigs();
		driver = getWebDriverInstance(browser);
	}
	
	@AfterTest
	public void afterTest_WebdriverProvider(){
		log.info(" : WebdriverProvider - afterTest called");
	}
	
	@AfterSuite
	public void afterSuite_WebdriverProvider(){
		log.info(" : WebdriverProvider - afterSuite called");
		//driver.quit();
	}
	
	public synchronized WebDriver getWebDriverInstance(String browserName) throws MalformedURLException {
		log.info(" : getWebDriverInstance called");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Configs.chromeDriverPath);
			DesiredCapabilities	caps = DesiredCapabilities.chrome();
			driver =new ChromeDriver(caps);
			driver.manage().window().maximize();
			driver.get("https://services.empirix.com/");
			
			log.info(" : Initialized the chrome driver");
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", Configs.firefoxDriverPath);
			DesiredCapabilities	caps = DesiredCapabilities.firefox();

			driver=new FirefoxDriver(caps);
			driver.get("https://services.empirix.com/");		
			log.info(" : Initialized the firefox driver");
		}
		return driver;
	}

	public WebDriver getDriver(){
		return driver;
	}
}
