package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Courses {

    private AppiumDriver driver;

    public Courses(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(8)), this);
    }

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='View Course >']")
    private WebElement viewCourses;

    @FindBy(xpath = "//*[@name= 'Sign In' ]")
    private WebElement signInButton;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Start FREE Trial']")
    private WebElement presignInButton;

    @FindBy(xpath = "(//*[@name='Courses'])[1]")
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

    private void clickNfc() {
        viewCourses.click();
    }

    public void waitBeforeClickingTrailButton() {
        waitForVisibility(viewCourses);
        isEnabled();
        clickNfc();
    }

    public void nonLoggedUser() {
        isVisible();
        presignInButton.click();
    }
}
