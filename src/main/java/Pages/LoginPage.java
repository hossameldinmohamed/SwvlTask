package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(id = "hint")
    MobileElement hintText;

    @FindBy(id = "arrow_image_view")
    MobileElement countriesList;

    @FindBy(id = "search_et")
    MobileElement searchText;

    @FindBy(id = "country_name_text_view")
    MobileElement searchResult;

    @FindBy(id = "phone_edit_text")
    MobileElement mobileNumber;

    @FindBy(id = "next_btn")
    MobileElement nextButton;

    @FindBy(id = "password_edit_text")
    MobileElement passwordText;




    public void Login( String country , String mobilenumber, String password) {

        waitUntilElementClickableAndClick(hintText);

        //Search for country in countries list
        waitForElement(countriesList);
        clickOn(countriesList);
        waitForElement(searchText);
        setText(searchText,country);
        clickOn(searchResult);

        // Enter Mobile number and password then click on login button
        waitForElement(mobileNumber);
        setText(mobileNumber, mobilenumber);
        waitUntilElementClickableAndClick(nextButton);
        waitForElement(passwordText);
        setText(passwordText, password);
        waitUntilElementClickableAndClick(nextButton);


    }
}
