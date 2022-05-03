import Base.BaseTest;
import Base.Factories.DriverFactory;
import Pages.FreeTrailOption;
import Pages.ParentSignUpPage;
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
        FreeTrailOption freeTrailOption = new FreeTrailOption(driver);
        freeTrailOption.waitBeforeClickingTrailButton();
    }

    @Test(description = "Launch Singup free trail user page", groups = "regression", alwaysRun = true)
    public void verifyFreeTrail() {
        FreeTrailOption freeTrailOption = new FreeTrailOption(driver);
        freeTrailOption.waitBeforeClickingTrailButton();
    }

    @Test(description = "Launch DIY app and verify home page", groups = "regression", alwaysRun = true)
    public void SingupFreeTrail() {
        ParentSignUpPage parentSignUpPage = new ParentSignUpPage(driver);
        parentSignUpPage.enterDetails("Sudhanshu", "Singh", "sudhanshu11@gmail.com");
    }
}
