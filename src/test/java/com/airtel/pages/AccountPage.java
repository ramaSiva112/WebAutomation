package com.airtel.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.airtel.utilities.Keywords;

public class AccountPage {

	WebDriver driver=null;
	public static Keywords keywords;
	
	public static final String URL="https://www.naukri.com/";	
	
	
	// search button
	public static final By accountOverView = By.xpath("//h3[text()='Account Overview']");
	
	public static final By searchOpen = By.xpath("//a[@data-ng-click='vm.searchModalOpen()']");
	
	public static final By availThanksBenefits= By.xpath("//a[text()='Avail Thanks Benefits']");
	
	public static final By paymentRecharge= By.xpath("//a[text()='PAYMENTS & RECHARGES']");
	
	public static final By orders= By.xpath("//a[text()='ORDERS']");
	
	public static final By requests= By.xpath("//a[text()='REQUESTS']");
	
	public static final By getHelp= By.xpath("//a[text()='GET HELP']");
	
	public static final By paymentDue= By.xpath("(//p[text()='Payments Due'])[1]");
	
	//public static final By privacyPolicy= By.xpath("(//a[text()='PRIVACY POLICY'])[1]");
	
	
	
	
	
	
	
	public AccountPage(WebDriver driver) throws IOException {
		this.driver = driver;
		 keywords=Keywords.getInstance();
	}
	
	/**
	 * @param data
	 * @throws InterruptedException
	 * @throws WebDriverException
	 * @throws IOException
	 */
	public void invoke() throws InterruptedException, WebDriverException, IOException{
		keywords.openUrl(URL);				
		
		}
	
	
	
	public boolean verifyAccountOverViewDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(accountOverView);
	}
	
	public boolean verifySearchOpenDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(searchOpen);
	}
	
	public boolean verifyAvailThanksBenefitsDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(availThanksBenefits);
	}
	
	public boolean verifyPaymentRechargeDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(paymentRecharge);
	}
	
	public boolean verifyOrdersDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(orders);
	}
	
	public boolean verifyRequestsDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(requests);
	}
	
	public boolean verifyGetHelpDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(getHelp);
	}
	
	public boolean verifyPaymentDueDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(paymentDue);
	}
	
	/*public boolean verifyPrivacyPolicyDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(privacyPolicy);
	}
	*/
	
	
	
}
