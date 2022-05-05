package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private AppiumDriver driver;

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(8)), this);
    }

    @FindBy(xpath = "//*[@text ='Art & Craft']")
    private WebElement nfcElement;

    @FindBy(xpath = "//XCUIElementTypeImage[@name='nav-challenges-inactive']")
    private WebElement challengesTab;

    @FindBy(xpath = "//XCUIElementTypeImage[@name='nav-notifications-inactive']")
    private WebElement activityTab;

    @FindBy(xpath = "//XCUIElementTypeImage[@name='nav-notifications-inactive']")
    private WebElement profileTab;

    public boolean isEnabled() {
        return nfcElement.isEnabled();
    }

    public void waitForVisibility(WebElement nfcElement) {
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(ExpectedConditions.visibilityOf(nfcElement));
    }

    public void clickNfc() {
        nfcElement.click();
    }


    public void waitBeforeClickingNfc() throws InterruptedException {
        waitForVisibility(nfcElement);
        isEnabled();
        clickNfc();
    }
}
