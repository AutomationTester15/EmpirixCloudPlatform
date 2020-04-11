package base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.*;
import common.CommonMethods;
import util.WebdriverProvider;
import workflow.Dashboard;
import workflow.UserLogin;

public class TestSuiteBase extends WebdriverProvider{
	
	public UserLogin userLogin;
	public Dashboard dashboard;
	public Config config;
	public CommonMethods common;
	public static Logger log = Logger.getLogger(TestSuiteBase.class);
	

	public TestSuiteBase() {
		super();
		PropertyConfigurator.configure("log4j.properties");
		log.info(" : TestSuiteBase constructor called");
	}
	
	@BeforeSuite
	public void beforeSuite(){		
		log.info(" : TestSuiteBase - beforeSuite called");
	}
	
	@Parameters({"browser"})
	@BeforeTest
	public void beforeTest(String browser) throws Exception {
		log.info(" : TestSuiteBase - beforeTest called");
	}
	
	@AfterTest
	public void afterTest(){
		log.info(" : TestSuiteBase - afterTest called");
		driver.quit();
	}
	
	public void initTest() throws Exception{

		config = new Config();
		common = new CommonMethods(driver);
		userLogin = new UserLogin(driver, common);
		dashboard = new Dashboard(driver, common);
	}
}