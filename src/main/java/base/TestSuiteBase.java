package base;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.*;

import common.CommonMethods;
import util.CoreTestLayer;
import workflow.UserLogin;

public class TestSuiteBase extends CoreTestLayer{
	
	public UserLogin userLogin;
	public Config config;
	public CommonMethods common;
	public String date;
	public static Logger log = Logger.getLogger(TestSuiteBase.class);
	

	public TestSuiteBase() {
		super();
		PropertyConfigurator.configure("log4j.properties");
		log.info(" : TestSuiteBase constructor called");
		date  = "AT_"+(new SimpleDateFormat("ddMMyyHHmmssSSS").format(new Date()));
	}
	
	@BeforeSuite
	public void beforeSuite(){		
		log.info(" : TestSuiteBase - beforeSuite called");
	}
	
	@Parameters({"browser"})
	@BeforeTest
	public void beforeTest(String browser) throws Exception {
		log.info(" : TestSuiteBase - beforeTest called");

		System.out.println("driver : " + driver);
		date  = "AT_"+(new SimpleDateFormat("ddMMyyHHmmssSSS").format(new Date()));
		System.out.println("In before test");
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
	}
}