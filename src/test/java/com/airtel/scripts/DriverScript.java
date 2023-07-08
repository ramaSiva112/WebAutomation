package com.airtel.scripts;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.airtel.utilities.AppConfig;
import com.airtel.utilities.Keywords;
import com.airtel.utilities.Log4jLogger;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DriverScript{
	 private static Logger applicationLogs;
	 private static Properties appConfig;
	public  WebDriver driver=null;
	public  Keywords keyword=null;
	public String excelFilePath;
	public static String excelSheetName;
	public static ExtentReports extent;
	public static ExtentTest test;
	@BeforeSuite
    public void setUp() {
        try {
            applicationLogs = Log4jLogger.getLog4jInstance();
            applicationLogs.info("Test Suite Execution Started");
            appConfig = AppConfig.getAppConfigInstance();       
           
           
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	@BeforeTest
	public void startReport(){
		//ExtentReports(String filePath,Boolean replaceExisting) 
		//filepath - path of the file, in .htm or .html format - path where your report needs to generate. 
		//replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
		//True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
		//False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
		//extent.addSystemInfo("Environment","Environment Name")
		extent
                .addSystemInfo("Host Name", "SoftwareTestingMaterial")
                .addSystemInfo("Environment", "Automation Testing")
                .addSystemInfo("User Name", "Rajkumar SM");
                //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
                //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
                extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
                test = extent.startTest("passTest");
	}
	
	
	
	
    @AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			test.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			test.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
		// ending test
		//endTest(logger) : It ends the current test and prepares to create HTML report
		extent.endTest(test);
		
	}
    @BeforeClass 
    public void startDriver() throws IOException{
    	keyword.invokeBrowser();
    }
    /*@AfterClass 
    public void closeDriver(){
    	driver.quit();
    }*/
	@AfterSuite
	  public void tearDown() {
		driver.quit();
		 extent.flush();
         //Call close() at the very end of your session to clear all resources. 
         //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
         //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
         //Once this method is called, calling any Extent method will throw an error.
         //close() - To close all the operation
         extent.close();
	}
}
