package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActivityPage {

    private AppiumDriver driver;

    public ActivityPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(8)), this);
    }

    @FindBy(xpath = "//*[@name= 'capture camera']")
    private WebElement cameraButton;

    @FindBy(xpath = "//*[@name= 'capture library' ]")
    private WebElement libraryButton;

    @FindBy(xpath = "//*[@name= 'postcamera' ]")
    private WebElement postCamera;

    @FindBy(xpath = "//*[@name= 'My Feed' ]")
    private WebElement myFeed;

    @FindBy(xpath = "//*[@name= 'Community' ]")
    private WebElement community;

    @FindBy(xpath = "//*[@name= 'What's New' ]")
    private WebElement whatNew;

    @FindBy(xpath = "//*[@name= 'All' ]")
    private WebElement allButton;

    @FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Activity'])[1]")
    private WebElement pageHeader;


    private boolean isEnabled() {
        return pageHeader.isEnabled();
    }

    private boolean isVisible() {
        return pageHeader.isDisplayed();
    }

    private void waitForVisibility(WebElement nfcElement) {
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(ExpectedConditions.visibilityOf(nfcElement));
    }

    private void click(WebElement webElement) {
        webElement.click();
    }

    public void verifyPageAndPost() {
       isVisible();
       click(postCamera);
       cameraButton.click();
    }
}
