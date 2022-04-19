package Base;

import Interface.ILogger;
import Util.ConfigUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BaseTest implements ILogger {

    AppiumServiceBuilder appiumServiceBuilder;
    Map<String,String> map = new HashMap<>();
    private static AppiumDriverLocalService server;
    Gson gson;
    AppiumDriver driver;

    @BeforeClass
    public void initAppium() throws IOException {
        appiumServiceBuilder = new AppiumServiceBuilder();
        appiumServiceBuilder.usingAnyFreePort();
        appiumServiceBuilder.usingDriverExecutable(new File("/usr/local/bin/node"));
        appiumServiceBuilder.withAppiumJS(new File("/usr/local/bin/appium"));
        map.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
        appiumServiceBuilder.withEnvironment(map);
        server = AppiumDriverLocalService.buildService(appiumServiceBuilder);

        if (!server.isRunning()) {
            server.start();
        }
        /*gson = new GsonBuilder().setPrettyPrinting().create();
        InputStream inputStream = BaseTest.class.getClassLoader().getResourceAsStream("device_config.json");
        System.out.println("Building Desired properties as defined in :: 'device_config.json' ::" +
                gson.toJson(inputStream));*/
    }

        @AfterClass
    public static void stopAppiumServer() {
        server.stop();
    }
}
