package com.airtel.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class InvokeWebDriver {

    private static final Logger applicationLogs = Logger.getLogger(InvokeWebDriver.class);
    private static Properties appConfig;
    private static File file;
    private static WebDriver driver = null;

	private InvokeWebDriver() {}

    public static WebDriver getWebDriverInstance() throws IOException {

        appConfig = AppConfig.getAppConfigInstance();
        //applicationLogs = Log4jLogger.getLog4jInstance();
        applicationLogs.info("InvokeWebDriver-->>getWebDriverInstance start ");
        applicationLogs.info("InvokeWebDriver-->>getWebDriverInstance  " + driver);
        try {
            if (driver == null) {

                if (appConfig.getProperty("browser").equals("firefox")) {
                    driver = new FirefoxDriver();
                }else  if (appConfig.getProperty("browser").equals("chrome")) {
                	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\anishwar\\chromedriver.exe");
                	 driver = new ChromeDriver();
                	 
                }
            }

        } catch (Exception e) {            
            applicationLogs.error("InvokeWebDriver-->>Web driver invocation unsuccessful : " + e.getMessage());
            return null;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        applicationLogs.info("InvokeWebDriver-->>getWebDriverInstance start ");
       
       
      
        
        return driver;
    }

}
