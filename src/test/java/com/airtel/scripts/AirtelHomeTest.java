package com.airtel.scripts;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.airtel.pages.AirtelHomePage;
import com.relevantcodes.extentreports.LogStatus;

public class AirtelHomeTest extends DriverScript {
	
	private static Logger applicationLogs = Logger.getLogger(AirtelHomeTest.class);	
	AirtelHomePage loginPage= null;	 
	
	@Test(priority=1)
	public void launchAirtelApplication() throws IOException, InterruptedException{		
		keyword.invokeBrowser();		
		AirtelHomePage loginPage= PageFactory.initElements(driver, AirtelHomePage.class);		
		loginPage.invoke();		
		Thread.sleep(5000);
	}	
	@Test(priority=2)
	public void verifyAirtelPageIsLoaded() throws IOException, InterruptedException{	
		loginPage=PageFactory.initElements(driver, AirtelHomePage.class);	 	
		
		if(loginPage.verifyHeaderImageDisplayed()){
			test.log(LogStatus.PASS, "Airtel page displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "Airtel page is not displayed");			
		}
	}	
	
	@Test(priority=3)
	public void verifyPrepaidMenuDisplayed() throws IOException, InterruptedException{			
		
		if(loginPage.verifPrePaidMenuDisplayed()){
			test.log(LogStatus.PASS, "PrePaid Menu displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "PrePaid Menu is not displayed sucessfully");			
		}
		
		
		
		if(loginPage.verifyPostPaidMenuDisplayed()){
			test.log(LogStatus.PASS, "PostPaid Menu displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "PostPaid Menu is not displayed sucessfully");			
		}
	}	
	@Test(priority=3)
	public void verifyJobsSubMenu() throws IOException, InterruptedException{	
			
		if(loginPage.verifyBrodBandMenuDisplayed()){
			test.log(LogStatus.PASS, "BridBand Menu displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "BridBand Menu is not displayed sucessfully");			
		}
	}
	@Test(priority=4)
	public void verifyDTHSubMenu() throws IOException, InterruptedException{	
			Thread.sleep(1000);
			if(loginPage.verifyDTHMenuDisplayed()){
				test.log(LogStatus.PASS, "DTH Menu displayed sucessfully");
			}else{
				test.log(LogStatus.FAIL, "DTH Menu is not displayed sucessfully");			
			}
	}
	@Test(priority=5)
	public void verifyBankSubMenuDisplayed() throws IOException, InterruptedException{	
		Thread.sleep(1000);
		if(loginPage.verifyBankMenuDisplayed()){
			test.log(LogStatus.PASS, "Bank Menu displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "Bank Menu is not displayed sucessfully");			
		}
	}
	@Test(priority=5)
	public void verifyHelpSubMenu() throws IOException, InterruptedException{	
		Thread.sleep(1000);
		if(loginPage.verifyHelpMenuDisplayed()){
			test.log(LogStatus.PASS, "Help Menu displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "Help Menu is not displayed");			
		}
	}
	@Test(priority=6)
	public void clickPrepaidMenu() throws IOException, InterruptedException{	
		Thread.sleep(1000);
		if(loginPage.clickPrepaid()){
			test.log(LogStatus.PASS, "Prepaid Menu displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "Prepaid Menu is not displayed");			
		}
	}
	@Test(priority=7)
	public void clickPostPaidMenu() throws IOException, InterruptedException{	
		Thread.sleep(1000);
		if(loginPage.clickPostPaid()){
			test.log(LogStatus.PASS, "PostPaid Menu displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "PostPaid Menu is not displayed");			
		}
	}
	@Test(priority=8)
	public void clickBroadBandMenu() throws IOException, InterruptedException{	
		Thread.sleep(1000);
		if(loginPage.clickBrand()){
			test.log(LogStatus.PASS, "BroadBand Menu displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "BroadBand Menu is not displayed sucessfully");			
		}
	}
	@Test(priority=9)
	public void clickDTHMenu() throws IOException, InterruptedException{	
		Thread.sleep(1000);
		if(loginPage.clickDTH()){
			test.log(LogStatus.PASS, "DTH Menu displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "DTH Menu is not displayed");			
		}
	}
	@Test(priority=10)
	public void clickBankMenu() throws IOException, InterruptedException{	
		Thread.sleep(1000);
		if(loginPage.clickBank()){
			test.log(LogStatus.PASS, "Bank Menu displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "Bank Menu is not displayed");			
		}
	}
	@Test(priority=11)
	public void clickHelpMenu() throws IOException, InterruptedException{	
		Thread.sleep(1000);
		if(loginPage.clickHelp()){
			test.log(LogStatus.PASS, "Help Menu displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "Help Menu is not displayed sucessfully");			
		}
	}
	
	@Test(priority=13)
	public void verifyXStreamSubMenu() throws IOException, InterruptedException{	
		Thread.sleep(1000);
		if(loginPage.verifyXStreamDisplayed()){
			test.log(LogStatus.PASS, "XStream Menu displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "XStream Menu is not displayed");			
		}
	}
	
	@Test(priority=14)
	public void verifyAirtelPaymentSubMenu() throws IOException, InterruptedException{	
		Thread.sleep(1000);
		if(loginPage.verifyAirtelDisplayed()){
			test.log(LogStatus.PASS, "Airtel Payment sub Menu displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "Airtel Payment sub Menu  is not displayed");			
		}
	}
	
	@Test(priority=15)
	public void verifyAWynkMenu() throws IOException, InterruptedException{	
		Thread.sleep(1000);
		if(loginPage.verifyWunkDisplayed()){
			test.log(LogStatus.PASS, "Awynk Menu displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "Awynk Menu is not displayed");			
		}
	}
	
	@Test(priority=16)
	public void verifyPersonalMenu() throws IOException, InterruptedException{	
		Thread.sleep(1000);
		if(loginPage.verifyPersonalDisplayed()){
			test.log(LogStatus.PASS, "Personal Menu displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "Personal Menu is not displayed");			
		}
	}
	
	@Test(priority=17)
	public void verifyCareerMenu() throws IOException, InterruptedException{	
		Thread.sleep(1000);
		if(loginPage.verifyCareerDisplayed()){
			test.log(LogStatus.PASS, "Career Menu displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "Career Menu is not displayed");			
		}
	}
	
	@Test(priority=18)
	public void verifyBusinessMenu() throws IOException, InterruptedException{	
		Thread.sleep(1000);
		if(loginPage.verifyBusinessDisplayed()){
			test.log(LogStatus.PASS, "Business Menu displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "Business Menu is not displayed");			
		}
	}
	
	@Test(priority=19)
	public void verifyInvestorMenu() throws IOException, InterruptedException{	
		Thread.sleep(1000);
		if(loginPage.verifyInvestorDisplayed()){
			test.log(LogStatus.PASS, "Investor Menu displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "Investor Menu is not displayed");			
		}
	}
	@Test(priority=20)
	public void verifyRecharge() throws IOException, InterruptedException{	
		Thread.sleep(1000);
		if(loginPage.verifyCareerDisplayed()){
			test.log(LogStatus.PASS, "Recharge Menu displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "Recharge Menu is not displayed");			
		}
	}
	@Test(priority=21)
	public void verifyTCloseApplication() throws IOException, InterruptedException{	
		test.log(LogStatus.PASS, "Application close sucessfully");	
		
				
	}
	
	
}
 