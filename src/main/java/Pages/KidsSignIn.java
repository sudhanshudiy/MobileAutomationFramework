package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KidsSignIn {

    private AppiumDriver driver;

    public KidsSignIn(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(8)), this);
    }

    @FindBy(xpath = "//XCUIElementTypeTextField[@value= 'Nickname']")
    private WebElement nickName;

    @FindBy(xpath = "//XCUIElementTypeSecureTextField[@value= 'Password' ]")
    private WebElement password;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@value= 'Kid Sign In' ]")
    private WebElement pageHeader;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@value= 'Sign In' ]")
    private WebElement SignIn;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@value= 'Sign In' ]")
    private WebElement PreSignIn;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@value= 'Full access. FREE for 14 days.' ]")
    private WebElement PreSignInHeader;

    private boolean isEnabled() {
        return pageHeader.isEnabled();
    }

    private void waitForVisibility(WebElement pageHeader) {
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(pageHeader));
    }

    private void preSignInwaitForVisibility(WebElement pageHeader) {
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(pageHeader));
    }

    private void userName(String username){
        nickName.sendKeys(username);
    }

    private void setPassword(String pass){
        password.sendKeys(pass);
    }

    private void setSignIn() {
        SignIn.click();
    }

    private void waitBeforeClickingTrailButton() {
        waitForVisibility(pageHeader);
        isEnabled();
    }

    public void setPreSignIn(){
        preSignInwaitForVisibility(PreSignInHeader);
        PreSignIn.click();
    }

    public void enterDetails(String name, String password) {
        waitBeforeClickingTrailButton();
        userName(name);
        setPassword(password);
        setSignIn();
    }
}
