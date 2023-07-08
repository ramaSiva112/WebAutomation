package com.airtel.utilities;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class AppConfig {

    private static Properties appConfig = null;
    private static File file = null;
    private static FileInputStream fs = null;
    private static Logger applicationLogs;//;

    
    public static Properties getAppConfigInstance() throws IOException {
        applicationLogs = Log4jLogger.getLog4jInstance();
        applicationLogs.info("AppConfig--->Start the App Config file");
        try {
            if (appConfig == null) {
                appConfig = new Properties();
                file = new File(System.getProperty("user.dir") + "/src/test/resources/configuration/Config.properties");
                fs = new FileInputStream(file);
                appConfig.load(fs);
                applicationLogs.info("App Config file loaded successfully ");
            }
        } catch (Exception e) {
            applicationLogs.info("Issues with the App Config Properties File : " + e.getMessage());
            return null;
        }
        applicationLogs.info("End off the App Config file loaded successfully ");
        return appConfig;
    }
}
