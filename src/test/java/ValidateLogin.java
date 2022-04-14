import Factories.Base.BaseTest;
import Factories.DriverFactory;
import Pages.LoginPage;
import constants.DriverTypes;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValidateLogin extends BaseTest {

    private AppiumDriver androidDriver;

    @BeforeClass
    public void startDriver() {
        androidDriver = DriverFactory.initDriver(DriverTypes.ANDROID);
    }

    @Test(description = "Launch DIY app and verify home page", groups = "regression", alwaysRun = true)
    public void verifyHomePage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(androidDriver);
        loginPage.login("","");

    }
}
