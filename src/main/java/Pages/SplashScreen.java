package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class SplashScreen extends PageBase{

    public SplashScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }


    @FindBy(id = "continue_btn")
    MobileElement continueButton;

    public void pressContinue() {

        for (int i=0 ; i<3 ; i++) {

            waitForElement(continueButton);
            clickButton(continueButton);

        }
    }
}
