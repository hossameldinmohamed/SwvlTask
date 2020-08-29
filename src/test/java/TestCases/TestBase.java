package TestCases;

import TestData.configurationData;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase {

    public static AppiumDriver<MobileElement> driver = null;

    public static ExtentReports report ;
    public static ExtentTest logger;

    @BeforeSuite
    protected static void launchApp() {

        platformCapabilities();

        //Extent Report Configuration
        ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/src/test/java/TestReports/Technical-Assessment "+GetCurrentTime()+".html"));
        extent.config().setTheme(Theme.DARK);
        report=new ExtentReports();
        report.attachReporter(extent);
        report.setSystemInfo("Project Name","SWVL Technical Task");
        report.setSystemInfo("Host name","Hossam Eldin Local Machine");
        report.setSystemInfo("Environemnt","Testing Environment");
        report.setSystemInfo("OS","MacOs Mojave");

    }






    private static void platformCapabilities() {

        // Set the Desired Capabilities

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", configurationData.deviceName);
        capabilities.setCapability("platformName", configurationData.platformName);
        capabilities.setCapability("platformVersion", configurationData.platformVersion);
        capabilities.setCapability("appPackage", configurationData.appPackage);
        capabilities.setCapability("appActivity", configurationData.appActivity);
        capabilities.setCapability("autoGrantPermissions", "true");  // To Grant GPS Permission
        capabilities.setCapability("automationName", configurationData.automationName);
        capabilities.setCapability("full-reset", true);
        capabilities.setCapability("unicodeKeyboard", "true");

        try {
            driver = new AppiumDriver<MobileElement>(new URL(configurationData.appiumURL_Android), capabilities);

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }


    }

    // This Method for getting current date&time to use it for naming the report
    private static String GetCurrentTime() {
        DateFormat format = new SimpleDateFormat("dd MMMM YYYY hh:mm:ss");
        Date date=new Date();
        return  format.format(date);
    }


    @AfterMethod
    public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            logger.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED " , ExtentColor.GREEN));

        }
        else {
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            logger.skip(result.getThrowable());

        }
        report.flush();

    }

    @AfterClass
    public void CloseApp() {

        driver.quit();
    }


}
