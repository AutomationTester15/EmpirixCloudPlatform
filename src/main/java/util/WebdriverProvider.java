package util;

import java.net.MalformedURLException;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.log4testng.Logger;

import base.Configs;

/**
 * This class is responsible for providing the WebDriver instance on request.
 *
 */

public class WebdriverProvider {
	
	private WebDriver driver;
	
	static Logger log = Logger.getLogger(WebdriverProvider.class);
	
	public WebdriverProvider() {
		super();
		PropertyConfigurator.configure("log4j.properties");
		log.info(" : WebdriverProvider Constructor called");
	}

	/**
	 * Takes the String browserName from the testng.xml and provide the respective webdriver instance.
	 * Set the System.setProperty for driver type and locations to app.propeties driver path properties. like,
	 * ChromeDriverPath, FirefoxDriverPath.
	 * 
	 * It supports the following drivers:
	 * <ul>
	 * <li> chrome </li>
	 * <li> firefox </li>
	 * </ul>
	 * @param browserName browser name to initialize the webdriver
	 * @return WebDriver returns the driver instance of the parameter type
	 * @throws MalformedURLException if Hub URL is not valid
	 */
	
	public synchronized WebDriver getWebDriverInstance(String browserName) throws MalformedURLException {
		log.info(" : getWebDriverInstance called");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Configs.chromeDriverPath);
			DesiredCapabilities	caps = DesiredCapabilities.chrome();
			driver =new ChromeDriver(caps);
			
			driver.get("https://services.empirix.com/");
			try {
				//TODO palce a proper event check, sleep is a workaround
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
}
