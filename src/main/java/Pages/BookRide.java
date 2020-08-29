package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class BookRide extends PageBase {
    public BookRide(AppiumDriver<MobileElement> driver) {
        super(driver);
    }


    @FindBy(id = "got_it_tv")
    MobileElement gotItButton;

    @FindBy(id = "where_to")
    MobileElement whereto;

    @FindBy(id = "pickup_et")
    MobileElement pickUp;

    @FindBy(id = "dropoff_et")
    MobileElement dropOff;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    MobileElement searchResult;


    @FindBy(id = "toolbar")
    MobileElement toolbar;


    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    MobileElement firstSuggestion;

    @FindBy(id = "next_btn")
    MobileElement nextButton;

    @FindBy(id = "book_btn")
    MobileElement bookButton;

    @FindBy(id = "title_tv")
    MobileElement confirmationText;

    String confirmMessage;


    public String bookRide(String pickup, String dropoff) {

        waitUntilElementClickableAndClick(gotItButton);
        waitUntilElementClickableAndClick(whereto);
        waitForElement(toolbar);
        clickOn(toolbar);


        //Add pick up location
        clickOn(pickUp);
        setText(pickUp, pickup);
        waitUntilElementClickableAndClick(searchResult);


        //Add Drop off location
        clickOn(dropOff);
        setText(dropOff, dropoff);
        waitUntilElementClickableAndClick(searchResult);

        // Choose first trip from trips suggestions
        waitForElement(firstSuggestion);
        clickOn(firstSuggestion);
        waitUntilElementClickableAndClick(nextButton);
        waitUntilElementClickableAndClick(bookButton);

        //Confirm booking
        waitUntilVisible(confirmationText);
        confirmMessage = confirmationText.getText().toString();
        return confirmMessage;


    }

}
