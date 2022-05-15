package util;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.io.File;
import java.io.IOException;

public class CommonUtils {

    static AppiumDriver driver;

    public CommonUtils(AppiumDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * @param machineName
     * @return
     * @throws IOException
     */
    public Process getProcess(String machineName) throws IOException {
        String cmd = "$ANDROID_HOME/platform-tools/adb devices";
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (machineName.equalsIgnoreCase("Windows"))
            processBuilder.command("cmd.exe", "/c", cmd);
        else
            processBuilder.command("bash", "-c", cmd);
        Process process = processBuilder.start();
        return process;
    }

    /**
     * Create Screenshots
     * @param path
     * @throws IOException
     */
    public static void getScreenshot(String path) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "\\" + path + ".jpg"));
    }
}
