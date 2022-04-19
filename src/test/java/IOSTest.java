import Base.BaseTest;
import Factories.DriverFactory;
import Pages.HomePage;
import constants.DriverTypes;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IOSTest extends BaseTest {

    private AppiumDriver driver;

    @BeforeClass
    public void startDriver() {
        driver = DriverFactory.initDriver(DriverTypes.IOS);
    }

    @Test(description = "Launch DIY app and verify home page", groups = "regression", alwaysRun = true)
    public void verifyHomePage() {
       /* HomePage homePage = new HomePage(driver);
        homePage.clickNfc();*/
    }
}
