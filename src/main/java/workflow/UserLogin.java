package workflow;

import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

import common.CommonMethods;
import pages.LoginPage;

public class UserLogin extends LoginPage {

	public WebDriver driver;
	public CommonMethods common;
	public static Logger log = Logger.getLogger(UserLogin.class);

	public UserLogin(WebDriver driver, CommonMethods common) {
		super(driver);
		this.driver = driver;
		this.common = common;
	}

	public void logIn(String user, String pwd) {
		common.fnvisibledElementSendKeys(userName, user);
		common.fnvisibledElementSendKeys(password, pwd);
		common.fnVisibledElementClick(signIn);

		log.info("User logged in to Ion Web : " + user);
	}
}
