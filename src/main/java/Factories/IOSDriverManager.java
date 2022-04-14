package Factories;

import Interface.IDrivers;
import Interface.ILogger;
import Util.ConfigUtil;
import constants.Common;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class IOSDriverManager implements ILogger, IDrivers {

        private static AppiumDriver<MobileElement> iosDriver;
        private DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        private ConfigUtil configUtil = new ConfigUtil();
        private File file;
        private Properties properties;
        private static volatile IOSDriverManager iosDriverManager;

        private IOSDriverManager(){}

        public DesiredCapabilities loadDesiredCap() {
            properties = configUtil.getAllProperties(Common.CONFIG_PATH);
            File loadfile = new File("src");
            file = new File(loadfile, Common.DIY_APK);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, properties.getProperty(Common.DEVICE_NAME));
            desiredCapabilities.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, "emulator-5556");
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, Common.UIAUTOMATOR);
            desiredCapabilities.setCapability("appPackage", "com.diy.develop");
            desiredCapabilities.setCapability("appActivity", "com.diy.MainActivity");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
            return desiredCapabilities;
        }

        @Override
        public void createDriver() {
            startDriver();
        }

        @Override
        public AppiumDriver<MobileElement> startDriver() {
            if (null == iosDriver){
                try {
                    return iosDriver = new IOSDriver<MobileElement>(new URL(Common.LOCAL_HOST), loadDesiredCap());
                }catch (Exception e){
                    log.error("failed to load Android driver ....:::" + e.getMessage());
                }
            }
            return null;
        }

        @Override
        public void stopDriver() {
            if (null != iosDriver){
                iosDriver.quit();
            }
        }

        /**
         * Get instance of this class
         * @return 'this'
         */
        public static IOSDriverManager getInstance(){
            if (null == iosDriverManager){
                synchronized (IOSDriverManager.class){
                    iosDriverManager = new IOSDriverManager();
                    return iosDriverManager;
                }
            }else{
                throw new RuntimeException("Use getInstance() method to get the single instance of this class");
            }
        }

        public static void getScreenshot(String name) throws IOException {
            File file  = ((TakesScreenshot)iosDriverManager).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File(System.getProperty("user.dir")+ "\\" + name+".jpg"));
        }
}
