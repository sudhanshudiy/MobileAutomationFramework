import Base.Factories.DriverFactory;
import Pages.KidsSignIn;
import constants.DriverTypes;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValidateLogin {

    private AppiumDriver driver;

    @BeforeClass
    public void startDriver() {
        driver = DriverFactory.initDriver(DriverTypes.IOS);
    }

    @Test(description = "Launch DIY app and verify home page", groups = "regression", alwaysRun = true)
    public void verifySingIn() {
        KidsSignIn kidsSignIn = new KidsSignIn(driver);
        kidsSignIn.setPreSignIn();
        kidsSignIn.enterDetails("fita1", "deepa55");
    }
}
