package TestCases;

import Pages.BookRide;
import Pages.LoginPage;
import Pages.SplashScreen;
import TestData.configurationData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookRideTest extends TestBase {

    SplashScreen splashScreen;
    BookRide bookRide;
    LoginPage loginPage;


    @BeforeClass
    private void initializeObjects() {
        try {
            splashScreen = new SplashScreen(driver);
            loginPage = new LoginPage(driver);
            bookRide = new BookRide(driver);

        } catch (Exception e) {
            System.out.println("ex: (( " + e + "))");
        }
    }


    @Test(priority = 0)
    public void testSplashScreen() {

        logger = report.createTest("Check the splash screen and navigate to Login Page");
        logger.assignCategory("Positive Scenario");
        logger.info("Test Case Started");

        splashScreen.pressContinue();

        logger.info("Test Case Ended");

    }


    @Test(priority = 1)
    public void testLoginPage() {

        logger = report.createTest("Login with valid credentials and navigate to Home Page");
        logger.assignCategory("Positive Scenario");
        logger.info("Test Case Started");

        loginPage.Login(configurationData.country,configurationData.phoneNumber, configurationData.password);


        logger.info("User Logged in Successfully");

    }


    @Test(priority = 2)
    public void testBookRide() {

        logger = report.createTest("Book a ride with pickup & dropoff Location");
        logger.assignCategory("Positive Scenario");
        logger.info("Test Case Started");

        Assert.assertEquals(bookRide.bookRide(configurationData.pickUpLocation, configurationData.dropOffLocation),"Trip Successfully Booked");

        logger.info("Ride Booked Successfully");

    }



}
