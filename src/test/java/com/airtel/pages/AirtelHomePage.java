package com.airtel.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.airtel.utilities.Keywords;

public class AirtelHomePage {

	WebDriver driver=null;
	public static Keywords keywords;
	
	public static final String URL="https://www.airtel.in/";
	
	public static final By headerAirtelImage = By.xpath("//img[@alt='airtel']");
	
	public static final By prePaid = By.xpath("//h3[text()='PREPAID']");
	
	public static final By postPaid= By.xpath("//h3[text()='POSTPAID']");
	
	public static final By broadBand = By.xpath("//h3[text()='BROADBAND']");
	
	public static final By dth = By.xpath("//h3[text()='DTH']");
	
	public static final By bank = By.xpath("//h3[text()='BANK']");
	
	public static final By help = By.xpath("//h3[text()='HELP']");
	
	public static final By recharge = By.xpath("//a[@href='https://www.airtel.in/prepaid-recharge/?icid=header']");
	
	public static final By xStream = By.xpath("//a[@href='https://www.airtelxstream.in?icid=header']");
	
	public static final By payBill = By.xpath("//a[text()='Pay Bill']");
	
	public static final By butNewConnection = By.xpath("//a[text()='Bill']");
	
	public static final By viewPlans = By.xpath("//a[text()='View Plans']");
	
	public static final By addMoney = By.xpath("//a[text()='Add Money']");
	
	public static final By contactUs = By.xpath("//a[text()='Contact Us']");
	
	public static final By textResume = By.xpath("//a[text()='Recharge']");
	
	public static final By btnSerchBtn = By.xpath("//a[text()='Recharge']");
	
	public static final By airtelBank = By.xpath("//a[text()='Airtel Payments Bank']");
	
	public static final By wynk = By.xpath("//a[text()='Wynk']");
	
	public static final By personal = By.xpath("//a[text()='Personal']");
	
	public static final By career = By.xpath("//a[text()='Career']");
	
	public static final By investor = By.xpath("//a[text()='Investor']");
	
	public static final By business = By.xpath("//a[text()='Business']");
	
	
	
	public AirtelHomePage(WebDriver driver) throws IOException {
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
	
	public boolean verifyHeaderImageDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(headerAirtelImage);
	}
	public boolean verifPrePaidMenuDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(prePaid);
	}
	public boolean verifyPostPaidMenuDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(postPaid);
	}
	public boolean verifyBrodBandMenuDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(broadBand);
	}
	public boolean verifyDTHMenuDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(dth);
	}
	public boolean verifyBankMenuDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(bank);
	}
	public boolean verifyHelpMenuDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(help);
	}
	public boolean clickPrepaid() throws WebDriverException, InterruptedException, IOException{
		keywords.mouseOver(prePaid);	
		Thread.sleep(1000);
		boolean value=keywords.isElementPresent(recharge);		
		return value;		
	}
	
	public boolean clickPostPaid() throws WebDriverException, InterruptedException, IOException{
		keywords.mouseOver(postPaid);	
		Thread.sleep(1000);
		boolean value=keywords.isElementPresent(payBill);		
		return value;		
	}
	
	public boolean clickBrand() throws WebDriverException, InterruptedException, IOException{
		keywords.mouseOver(broadBand);		
		Thread.sleep(1000);
		Thread.sleep(1000);
		boolean value=keywords.isElementPresent(butNewConnection);		
		return value;		
	}
	public boolean clickDTH() throws WebDriverException, InterruptedException, IOException{
		keywords.mouseOver(dth);
		Thread.sleep(1000);
		boolean value=keywords.isElementPresent(xStream);		
		return value;		
	}
	public boolean clickBank() throws WebDriverException, InterruptedException, IOException{
		keywords.mouseOver(bank);
		Thread.sleep(1000);
		boolean value=keywords.isElementPresent(addMoney);		
		return value;		
	}
	
	public boolean clickHelp() throws WebDriverException, InterruptedException, IOException{
		keywords.mouseOver(help);	
		Thread.sleep(1000);
		boolean value=keywords.isElementPresent(contactUs);		
		return value;		
	}
	
	public boolean verifyXStreamDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(xStream);
	}
	

	public boolean verifyAirtelDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(airtelBank);
	}
	
	public boolean verifyWunkDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(wynk);
	}
	
	public boolean verifyPersonalDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(personal);
	}
	
	public boolean verifyCareerDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(career);
	}
	
	public boolean verifyInvestorDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(investor);
	}
	
	public boolean verifyBusinessDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(business);
	}
}
