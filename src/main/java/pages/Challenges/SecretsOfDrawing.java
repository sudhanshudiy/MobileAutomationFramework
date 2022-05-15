package pages.Challenges;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SecretsOfDrawing {

    private AppiumDriver driver;

    public SecretsOfDrawing(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(8)), this);
    }

    @FindBy(xpath = "//*[@text ='View Course']")
    private WebElement secretOfDrawing;

    public boolean isEnabled() {
        return secretOfDrawing.isEnabled();
    }

    public void waitForVisibility(WebElement nfcElement) {
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(ExpectedConditions.visibilityOf(nfcElement));
    }

    public void click() {
        secretOfDrawing.click();
    }


    public void waitBeforeClicking() throws InterruptedException {
        waitForVisibility(secretOfDrawing);
        isEnabled();
        click();
    }
}
