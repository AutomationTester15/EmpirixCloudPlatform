package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Config;
import base.TestSuiteBase;

public class LoginTest extends TestSuiteBase{
	
	@Test
	public void UserLogin() throws Exception {
		
        System.out.println("---- UserLogin order Flow test start now..........");      
        initTest();
        userLogin.logIn(Config.username, Config.password);

	}
}