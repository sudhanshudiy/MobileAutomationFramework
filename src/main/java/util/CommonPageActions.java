package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import pages.Freemium.PaywallScreen;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class CommonPageActions {

    /**
     * Touch Actions Func
     * @param driver
     * @param x  height
     * @param y  width
     * @param timeOut
     */
    public void TouchActions(AppiumDriver driver, int x, int y, int timeOut) {
        new TouchAction(driver)
                .press(point(x, y))
                .waitAction(waitOptions(ofSeconds(timeOut)))
                .release()
                .perform();
    }

    public void tapWithCoordinates(AppiumDriver driver, int x, int y, int timeout){
        new TouchAction(driver).tap(new PointOption().withCoordinates(x, y)).perform();
    }

    /**
     * Touch Actions Func
     * @param driver
     */
    public void singleTapAction(AppiumDriver driver, WebElement element) {
        new TouchActions(driver)
                .singleTap(element)
                .perform();
    }

    /**
     * Touch Actions Func
     * @param driver
     */
    public void singleTapActionWithCoordinates(AppiumDriver driver, WebElement element) {
        new TouchActions(driver)
                .singleTap(element)
                .perform();
    }

    /**
     * @param locator
     * @return
     */
    public ExpectedCondition<Boolean> elementFoundAndClicked(By locator) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                WebElement element = driver.findElement(locator);
                element.click();
                return true;
            }
        };
    }


    public static void paywallScreen(AppiumDriver driver) {
        PaywallScreen paywallScreen = new PaywallScreen(driver);
        paywallScreen.verifyScreenAndClose();
    }

    public static void datePickerWheelScrollAction(AppiumDriver driver) {
        /*direction = "previous"; // "previous" or "next";
        offset = "0.15";
        HashMap<String, Object> params = new HashMap<>();
        params.put("order", direction);
        params.put("offset", offset);
        params.put("element", (pickerWheeIElement.get(0)).getId());
        driver.executeScript("mobile: selectPickerWheelValue", params);*/
    }
}
