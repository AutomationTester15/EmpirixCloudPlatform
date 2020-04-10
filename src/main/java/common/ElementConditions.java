package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementConditions {
	
	WebDriver driver;
	WebDriverWait wait;
	WebDriverWait waitForOneSec;
	
	public ElementConditions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
	}
	
	public void elementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void visibilityOfElement(WebElement element) {

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void elementClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElement() {
		try {
			Thread.currentThread().sleep(3000);

			System.out.println("thread: \n" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
