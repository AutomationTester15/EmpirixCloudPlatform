package testScripts;

import org.testng.annotations.Test;

import base.Config;
import base.TestSuiteBase;

public class Tests extends TestSuiteBase{
	
	@Test
	public void UserLogin() throws Exception {
		
        initTest();
        userLogin.logIn(Config.username, Config.password);
	}
	
	@Test(dependsOnMethods = { "UserLogin" })
	public void verifySwitchLanguages() throws Exception {
		initTest();
		dashboard.changeLangaugeToEnglish();
		//dashboard.changeLangaugeToJapanese();
	}
}