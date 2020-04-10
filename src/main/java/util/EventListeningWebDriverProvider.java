package util;

import java.net.MalformedURLException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

public class EventListeningWebDriverProvider {
	
	WebDriver driver;
	static Logger log = Logger.getLogger(EventListeningWebDriverProvider.class);
	
	public EventListeningWebDriverProvider() 
	{
		PropertyConfigurator.configure("log4j.properties");
		log.debug(" : constructor called");
	}
	
	public WebDriver getEventListenerWebDriver(String browser) throws MalformedURLException
	{
		WebdriverProvider oWebdriverProvider = new WebdriverProvider();
		driver=oWebdriverProvider.getWebDriverInstance(browser);
		log.debug(" : getEventListenerWebDriver called");
		return  driver;
	}
}