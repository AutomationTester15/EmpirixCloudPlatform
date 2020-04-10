package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Config;
import base.TestSuiteBase;

public class LoginTest extends TestSuiteBase{
	
	@Parameters({ "browser" })
	@Test
	public void UserLogin(String browser) throws Exception {
		
        System.out.println("---- UserLogin order Flow test start now..........");      
        initTest(browser);
        userLogin.logIn(Config.username, Config.password);

	}
}