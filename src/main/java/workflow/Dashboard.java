package workflow;

import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;
import org.testng.Assert;
import common.CommonMethods;
import pages.DashboardPage;

public class Dashboard extends DashboardPage {

	public WebDriver driver;
	public CommonMethods common;
	public static Logger log = Logger.getLogger(UserLogin.class);

	public Dashboard(WebDriver driver, CommonMethods common) {
		super(driver);
		this.driver = driver;
		this.common = common;
	}

	public void changeLangaugeToEnglish() {
		common.fnvisibledElementWithoutClick(userNameDroDown);
		common.fnVisibledElementClick(userNameDroDown);
		common.fnVisibledElementClick(english);
		common.fnWebAlertHandling();
		Assert.assertEquals(common.fnvisibledElementGetText(menuDashboard), "Dashboard");
	}

	public void changeLangaugeToJapanese() {
		common.fnWait("5");
		common.fnvisibledElementWithoutClick(userNameDroDown);
		common.fnVisibledElementClick(userNameDroDown);
		common.fnVisibledElementClick(japanese);
		common.fnWebAlertHandling();
		
		Assert.assertEquals(common.fnvisibledElementGetText(menuDashboard), "ダッシュボード");
	}
}