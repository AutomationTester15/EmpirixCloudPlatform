package common;

import java.io.File;
import java.util.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class CommonMethods {
	WebDriver driver;
	WebElement element;
	ElementConditions elementCondition;

	public CommonMethods(WebDriver driver) {
		this.driver = driver;
		elementCondition = new ElementConditions(driver);
	}

	public boolean fnWait(String strTime) {
		try {
			int iSleepWait = Integer.parseInt(strTime);
			Thread.currentThread().sleep(iSleepWait);
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	public boolean fnVisibledElementClick(WebElement element) {
		boolean bReturn = false;

		if (element != null) {
			System.out.println("Verifying if " + element + " is visible");
			elementCondition.visibilityOfElement(element);
			element.click();
			bReturn = true;
		}

		return bReturn;
	}

	public boolean fnvisibledElementWithoutClick(WebElement element) {
		boolean bReturn = false;

		if (element != null) {
			System.out.println("Verifying if " + element + " is visible");
			elementCondition.elementClickable(element);
		}
		return bReturn;
	}

	public String fnvisibledElementGetText(WebElement element) {
		String getText = null;

		if (element != null) {
			System.out.println("Verifying if " + element + " is visible");
			elementCondition.visibilityOfElement(element);

			getText = element.getText();
		}
		return getText;
	}

	public String fnvisibledElementGetValue(WebElement element, String attributeName) {
		String getValue = "abc";
		try {
			if (element != null) {
				System.out.println("Verifying if " + element + " is visible");
				// elementCondition.visibilityOfElement(element);

				getValue = element.getAttribute(attributeName);

			}
		} catch (NoSuchElementException e) {
			getValue = element.getAttribute("value");

		} catch (UnreachableBrowserException e) {
			getValue = null;
		} catch (WebDriverException e) {
			try {
				Thread.currentThread().sleep(3000);

				element.click();
			} catch (WebDriverException ex) {
				Thread.currentThread().sleep(6000);
				element.click();
			}

			getValue = element.getAttribute("value");

		} catch (Exception e) {
			System.out.println("getvalue0:" + getValue);
			getValue = null;

		} finally {
			return getValue;
		}
	}

	public boolean fnclickableElementClick(WebElement element) {
		boolean bReturn = false;

		if (element != null) {
			System.out.println("Verifying if " + element + " is clickable");
			elementCondition.elementToBeClickable(element);
			element.click();
			bReturn = true;
		}
		return bReturn;
	}

	public boolean fnvisibledElementSendKeys(WebElement element, String textValue) {
		boolean bReturn = false;

		if (element != null) {
			System.out.println("Verifying if " + element + " is clickable");
			try {
				Thread.currentThread().sleep(300);
			} catch (Exception e) {

			}
			element.clear();
			element.sendKeys(textValue);

			bReturn = true;
		}
		return bReturn;
	}

	public boolean fnvisibledElementSendTwoKeys(WebElement element1, String textValue, WebElement element2) {
		boolean bReturn = false;
		try {
			if (element1 != null) {
				System.out.println("inside sendKeys ...");
				elementCondition.visibilityOfElement(element1);
				System.out.println("Verifying if " + element1 + " is clickable");
				element1.clear();
				// element2.click();
				element1.sendKeys(textValue);
				System.out.println("AFTER sendkeys ");
				bReturn = true;
			}
		} catch (NoSuchElementException e) {
			bReturn = false;
		} catch (UnreachableBrowserException e) {
			bReturn = false;
		} catch (WebDriverException e) {
			bReturn = false;
		} catch (Exception e) {
			bReturn = false;
		} finally {
			return bReturn;
		}
	}

	public boolean fnvisibledElementSendKeys(WebElement element, File textValue) {
		boolean bReturn = false;
		try {
			if (element != null) {
				elementCondition.visibilityOfElement(element);
				element.clear();
				System.out.println("Image absolute path" + textValue.getAbsolutePath());
				element.sendKeys(textValue.getAbsolutePath());
				bReturn = true;
			}
		} catch (NoSuchElementException e) {
			bReturn = false;
		} catch (UnreachableBrowserException e) {
			bReturn = false;
		} catch (WebDriverException e) {
			bReturn = false;
		} catch (Exception e) {
			bReturn = false;
		} finally {
			return bReturn;
		}
	}

	public boolean fnwebElementClick(WebElement element) {
		boolean bReturn = false;
		try {
			if (element != null) {
				System.out.println("Verifying if " + element + " is visible");
				Thread.currentThread().sleep(5000);
				element.click();
				bReturn = true;
			}
		} catch (NoSuchElementException e) {
			bReturn = true;
		} catch (UnreachableBrowserException e) {
			bReturn = false;
		} catch (WebDriverException e) {
			bReturn = true;
		} catch (Exception e) {
			bReturn = false;
		} finally {
			return bReturn;
		}
	}

	public boolean fnwebElementClear(WebElement element) {
		boolean bReturn = false;
		try {
			if (element != null) {
				System.out.println("Verifying if " + element + " is visible");
				Thread.currentThread().sleep(5000);
				element.clear();
				bReturn = true;
			}
		} catch (NoSuchElementException e) {
			bReturn = true;
		} catch (UnreachableBrowserException e) {
			bReturn = false;
		} catch (WebDriverException e) {
			bReturn = true;
		} catch (Exception e) {
			bReturn = false;
		} finally {
			return bReturn;
		}
	}

	public boolean fnWebAlertHandling() {

		boolean bReturn = false;

		try {
			driver.switchTo().alert().accept();
			bReturn = true;
		} catch (UnhandledAlertException e) {
			System.out.println("is in unhandled alert catch");
			driver.switchTo().alert().accept();
			bReturn = true;
		} finally {
			return bReturn;
		}

	}
}
