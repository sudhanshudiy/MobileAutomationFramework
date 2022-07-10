package pages;

import base.Interface.ILogger;
import base.factories.DriverFactory;
import constants.DriverTypes;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class BasePage implements ILogger {

    protected AppiumDriver driver;

    public BasePage(){
       this.driver = DriverFactory.initDriver(DriverTypes.IOS);
    }

    protected boolean waitForVisibility(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, TimeUnit.MILLISECONDS.toMillis(100));
            wait.until(ExpectedConditions.visibilityOf(webElement));
            return true;
        } catch (NoSuchElementException noSuchElementException) {
            log.info(noSuchElementException.getLocalizedMessage());
        }
        return false;
    }
}
