package util;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Configs;

/**
 * This class is available to be inherited by the TestSuiteBase class. It
 * initialize the webdriver in beforeTest method and quits the driver in
 * afterTest method
 *
 */

public class CoreTestLayer {

	protected WebDriver driver;
	protected WebdriverProvider webdriverProvider;
	String paramBrowser;
	static Logger log = Logger.getLogger(CoreTestLayer.class);

	static {
		PropertyConfigurator.configure("log4j.properties");
		log.info(
				" ==========================================|| EXECUTION START ||==========================================");
	}

	public CoreTestLayer() {
		log.info(" : CoreTestLayer constructor called");
	}
	
	@BeforeSuite
	public void beforeSuite_CoreTestLayer(){
		log.info(" : CoreTestLayer - beforeSuite called");
	}
	
	/**
	 * This method initialize the driver as per the string value given in testng.xml.
	 * It internally gives a call to CurtainClass.getWebDriver method.
	 * for more info check the {@link CurtainClass} getWebDriver method.
	 * 
	 * @param paramBrowser the browser name passed from the testng.xml
	 * @throws MalformedURLException if the URL given to driver instance is invalid
	 */

	@Parameters({ "browser" })
	@BeforeTest
	public void beforeTest_CoreTestLayer(String browser) throws MalformedURLException {
		log.info(" : CoreTestLayer - beforeTest called");
		Configs.initConfigs();
		webdriverProvider = new WebdriverProvider();
		driver = webdriverProvider.getWebDriverInstance(browser);
	}
	
	@AfterTest
	public void afterTest_CoreTestLayer(){
		log.info(" : CoreTestLayer - afterTest called");
	}
	
	@AfterSuite
	public void afterSuite_CoreTestLayer(){
		log.info(" : CoreTestLayer - afterSuite called");
		driver.quit();
	}

	public WebDriver getDriver(){
		return driver;
	}
	
	
}