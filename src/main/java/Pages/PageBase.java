package Pages;



import io.appium.java_client.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class PageBase {

	protected static AppiumDriver<MobileElement> driver;




	public PageBase(AppiumDriver<MobileElement> driver) {
		PageBase.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}



	// Wait for Next button to be visible.
	public boolean waitUntilVisible(MobileElement element) {

		// Wait for Element to be visible.
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
			// element found, return true
			return true;
		} catch (Exception e) {
			// Element not found, return false
			return false;
		}

	}

	// Wait for Next button to be clickable.
	public boolean waitUntilElementClickableAndClick(MobileElement element) {

		// Wait for Element to be visible.
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			element = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			return true;
		} catch (Exception e) {
			// Element not found, return false
			return false;
		}

	}



	// Method to Click Buttons
	protected void clickButton(MobileElement button) {
		button.click();

	}



	// Method to send Keys
	protected void setText(MobileElement textElement, String value) {

		waitUntilVisible(textElement);
		textElement.sendKeys(value);
	}


	//////////////// Actions ////////////////

	protected void clickOn(MobileElement element) {

		(element).click();
	}



	protected void waitForElement(MobileElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {
			System.out.println(e);
		}
	}





}
