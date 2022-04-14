package Util;

import Interface.ILogger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigUtil implements ILogger {

    Map<String, String> propMap = new HashMap<>();

    /**
     * Load properties from config.properties file as a Map
     * @return
     */
    public Map<String, String> getProperties(String... properties) {
        try (InputStream input = ConfigUtil.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                log.info("Sorry, unable to find config.properties");
                return null;
            }
            prop.load(input);
            for (String args: properties) {
                propMap.put(args, prop.getProperty(args));
            }
            return propMap;
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
        return null;
    }

    /**
     * Load All properties from Desired path
     * @param filePath
     * @return Properties
     */
    public Properties getAllProperties(String filePath) {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream(filePath)) {
            prop.load(input);
        }catch (IOException e){
            log.error(e.getMessage());
        }
        return prop;
    }
}
