package Pages;

import Factories.DriverFactory;
import constants.DriverTypes;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePage {

    private AppiumDriver androidDriver;

    @BeforeClass(description = "Initializing Android driver")
    public void startDriver() {
        androidDriver = DriverFactory.initDriver(DriverTypes.ANDROID);
    }

    @Test(description = "Launch DIY app and verify home page", groups = "regression", alwaysRun = true)
    public void verifyHomePage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(androidDriver);
    }

    @AfterClass(description = "Close Session")
    public void cleanUp(){
        androidDriver.quit();
    }
}
