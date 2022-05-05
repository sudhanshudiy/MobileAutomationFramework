package util;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class CommonUtils {

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
     * @param name
     * @throws IOException
     */
    public static void getScreenshot(String name, AppiumDriver driver) throws IOException {
        File file  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(System.getProperty("user.dir")+ "\\" + name+".jpg"));
    }
}
