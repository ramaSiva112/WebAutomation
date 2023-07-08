package com.airtel.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.IOException;

public class Log4jLogger {

    private static Logger logger = null;

    private Log4jLogger() {
        // TODO Auto-generated constructor stub
    }

    public static Logger getLog4jInstance() throws IOException {

        try {
            if (logger == null) {
                File log4jfile = new File("src/test/resources/log4j.properties");
                PropertyConfigurator.configure(log4jfile.getAbsolutePath());
                //PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resource\\log4j.properties");
                logger = Logger.getLogger(" Service Automation ");
            }
        } catch (Exception e) {
            //logger.debug("Issues with the Log4j Config Properties File : " + e.getMessage());
            return null;
        }
        return logger;
    }
}
