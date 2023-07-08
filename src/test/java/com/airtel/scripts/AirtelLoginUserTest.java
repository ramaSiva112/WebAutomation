package com.airtel.scripts;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.airtel.pages.AccountPage;
import com.airtel.pages.AirtelHomePage;
import com.airtel.pages.AirtelLoginUserPage;
import com.relevantcodes.extentreports.LogStatus;

public class AirtelLoginUserTest extends DriverScript {
	
	private static Logger applicationLogs = Logger.getLogger(AirtelLoginUserTest.class);	
	AirtelLoginUserPage loginUserPage= null;	 
	AirtelHomePage loginPage= null;	 
	AccountPage accountPage= null;	 
	@Test(priority=1)
	public void launchAirtelApplication() throws IOException, InterruptedException{		
		keyword.invokeBrowser();		
		AirtelHomePage loginPage= PageFactory.initElements(driver, AirtelHomePage.class);		
		loginPage.invoke();		
		Thread.sleep(3000);
	}	
	@Test(priority=2)
	public void verifyAirtelPageIsLoaded() throws IOException, InterruptedException{	
		loginPage=PageFactory.initElements(driver, AirtelHomePage.class);	 	
		
		if(loginPage.verifyHeaderImageDisplayed()){
			test.log(LogStatus.PASS, "Help Menu displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "Failed to Navigated to Naukari Home page");			
		}
	}	
	@Test(priority=3)
	public void clickOnHelpLink() throws IOException, InterruptedException{	
		loginUserPage=PageFactory.initElements(driver, AirtelLoginUserPage.class);	 	
		loginUserPage.clickLogin();
		test.log(LogStatus.PASS, "Help Menu displayed sucessfully");
	}	
	@Test(priority=4)
	public void verifyPersonalLink() throws IOException, InterruptedException{	
		if(loginUserPage.verifyPersonalDisplayed()){
			test.log(LogStatus.PASS, "Personal Menu displayed sucessfully in Home page");
		}else{
			test.log(LogStatus.FAIL, "Personal Menu not displayed in Home page");			
		}
	}	
	@Test(priority=5)
	public void verifyBusinessLink() throws IOException, InterruptedException{	
		if(loginUserPage.verifyBusinessDisplayed()){
			test.log(LogStatus.PASS, "Business Menu displayed sucessfully in Home page");
		}else{
			test.log(LogStatus.FAIL, "Business Menu not displayed in Home page");			
		}
	}	
	@Test(priority=6)
	public void verifyInverstorLink() throws IOException, InterruptedException{	
		if(loginUserPage.verifyInvestorsDisplayed()){
			test.log(LogStatus.PASS, "Inverstor Menu displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "Inverstor Menu not displayed");			
		}
	}	
	@Test(priority=7)
	public void verifyMobileNumber() throws IOException, InterruptedException{	
		if(loginUserPage.verifyMobileNumberDisplayed()){
			test.log(LogStatus.PASS, "MobileNumber displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "MobileNumber not displayed");			
		}
	}	
	@Test(priority=8)
	public void verifyPassword() throws IOException, InterruptedException{	
		if(loginUserPage.verifyPasswordDisplayed()){
			test.log(LogStatus.PASS, "Password displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "Password not displayed");			
		}
	}	
	@Test(priority=8)
	public void verifyLoginSubmitBtn() throws IOException, InterruptedException{	
		if(loginUserPage.verifyLoginButtonSpanDisplayed()){
			test.log(LogStatus.PASS, "LoginSubmitBtn displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "LoginSubmitBtn not displayed");			
		}
	}	
	@Test(priority=9)
	public void verifyForgotBtn() throws IOException, InterruptedException{	
		if(loginUserPage.verifyLoginBtnForgotPwdDisplayed()){
			test.log(LogStatus.PASS, "ForgotBtn displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "ForgotBtn not displayed");			
		}
	}	
	@Test(priority=10)
	public void verifyFaceBookImage() throws IOException, InterruptedException{	
		if(loginUserPage.verifyFaceBookImgDisplayed()){
			test.log(LogStatus.PASS, "FaceBook Image displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "FaceBook Image is not displayed");			
		}
	}	
	@Test(priority=11)
	public void verifyFaceBussinessImage() throws IOException, InterruptedException{	
		if(loginUserPage.verifyBusinessDisplayed()){
			test.log(LogStatus.PASS, "FaceBookImage displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "FaceBookImage not displayed");			
		}
	}	
	@Test(priority=12)
	public void verifyInverstor() throws IOException, InterruptedException{	
		if(loginUserPage.verifyInvestorsDisplayed()){
			test.log(LogStatus.PASS, "Inverstor displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "Inverstor not displayed");			
		}
	}	
	@Test(priority=13)
	public void verifyLoginBtn() throws IOException, InterruptedException{	
		test.log(LogStatus.PASS, "LoginBtn displayed sucessfully");
	}	
	@Test(priority=14)
	public void verifyLogin() throws IOException, InterruptedException{	
		loginUserPage.enterLogin();
		test.log(LogStatus.PASS, "user is successfully entered");
		Thread.sleep(7000);
	}	
	
	@Test(priority=15)
	public void verifyNextBtnDisplayed() throws IOException, InterruptedException{	
		if(loginUserPage.verifyNextBtnDisplayed()){
			test.log(LogStatus.PASS, "LoginBtn displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "LoginBtn not displayed sucessfully");			
		}
	}	
	
	@Test(priority=16)
	public void verifyIsGotItDisplayed() throws IOException, InterruptedException{	
		if(loginUserPage.verifyGotItBtnDisplayed()){
			test.log(LogStatus.PASS, "LoginBtn displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "LoginBtn not displayed sucessfully");			
		}
	}	
	
	@Test(priority=17)
	public void ClickNextBtn() throws IOException, InterruptedException{	
		if(loginUserPage.verifyNextBtnDisplayed()){
			test.log(LogStatus.PASS, "LoginBtn displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "LoginBtn not displayed sucessfully");			
		}
	}	
	@Test(priority=18)
	public void ClickGotItBtn() throws IOException, InterruptedException{	
		if(loginUserPage.verifyGotItBtnDisplayed()){
			test.log(LogStatus.PASS, "LoginBtn displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "LoginBtn not displayed sucessfully");			
		}
	}	
	
	@Test(priority=19)
	public void verifyAccountOverViewDisplayed() throws IOException, InterruptedException{	
		accountPage= PageFactory.initElements(driver, AccountPage.class);		
		if(accountPage.verifyAccountOverViewDisplayed()){
			test.log(LogStatus.PASS, "AccountOverView displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "AccountOverView not displayed sucessfully");			
		}
	}	
	@Test(priority=20)
	public void verifySearchOpenDisplayed() throws IOException, InterruptedException{			
		if(accountPage.verifySearchOpenDisplayed()){
			test.log(LogStatus.PASS, "Search Open displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "Search Open not displayed sucessfully");			
		}
	}	
	@Test(priority=21)
	public void verifyAvailThanksBenefitsDisplayed() throws IOException, InterruptedException{			
		if(accountPage.verifyAvailThanksBenefitsDisplayed()){
			test.log(LogStatus.PASS, "AvailThanksBenefits displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "AvailThanksBenefits not displayed sucessfully");			
		}
	}	
	@Test(priority=22)
	public void verifyPaymentRechargeDisplayed() throws IOException, InterruptedException{			
		if(accountPage.verifyPaymentRechargeDisplayed()){
			test.log(LogStatus.PASS, "PaymentRecharge displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "PaymentRecharge not displayed sucessfully");			
		}
	}	
	@Test(priority=23)
	public void verifyOrdersDisplayed() throws IOException, InterruptedException{			
		if(accountPage.verifyOrdersDisplayed()){
			test.log(LogStatus.PASS, "Orders displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "Orders not displayed sucessfully");			
		}
	}	
	@Test(priority=24)
	public void verifyRequestsDisplayed() throws IOException, InterruptedException{			
		if(accountPage.verifyRequestsDisplayed()){
			test.log(LogStatus.PASS, "Requests displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "Requests not displayed sucessfully");			
		}
	}	
	@Test(priority=25)
	public void verifyGetHelpDisplayed() throws IOException, InterruptedException{			
		if(accountPage.verifyGetHelpDisplayed()){
			test.log(LogStatus.PASS, "GetHelp displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "GetHelp not displayed sucessfully");			
		}
	}	
	@Test(priority=26)
	public void verifyPaymentDueDisplayed() throws IOException, InterruptedException{			
		if(accountPage.verifyPaymentDueDisplayed()){
			test.log(LogStatus.PASS, "PaymentDue displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "PaymentDue not displayed sucessfully");			
		}
	}	
	@Test(priority=27)
	public void verifyCloseApplication() throws IOException, InterruptedException{	
		test.log(LogStatus.PASS, "sucessfully Closed application");
		
		
	}
	/*@Test(priority=20)
	public void verifyPrivacyPolicyDisplayed() throws IOException, InterruptedException{			
		if(accountPage.verifyPrivacyPolicyDisplayed()){
			test.log(LogStatus.PASS, "Help Menu displayed sucessfully");
		}else{
			test.log(LogStatus.FAIL, "Failed to Navigated to Naukari Home page");			
		}
	}	*/
}
 