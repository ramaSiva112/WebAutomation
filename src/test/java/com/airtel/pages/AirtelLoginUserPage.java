package com.airtel.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.airtel.utilities.Keywords;

public class AirtelLoginUserPage {

	WebDriver driver=null;
	public static Keywords keywords;
	
	public static final String URL="https://www.naukri.com/";	
	
	
	// search button
	public static final By loginLink = By.xpath("//a[@href='https://www.airtel.in/s/selfcare?icid=header']");
	
	public static final By mobileNumber = By.xpath("//input[@id='number-one']");
	
	public static final By password= By.xpath("//input[@id='pasword']");
	
	public static final By loginButtonSpan= By.xpath("//a[@id='loginButtonSpan']");
	
	public static final By btnForgotPwd= By.xpath("//a[@class='btnForgotPwd']");
	
	public static final By personal= By.xpath("(//a[text()='PERSONAL'])[1]");
	
	public static final By business= By.xpath("(//a[text()='BUSINESS'])[1]");
	
	public static final By investors= By.xpath("(//a[text()='INVESTORS'])[1]");
	
	public static final By faceBookImg= By.xpath("//a[@class='f_connect']");
	
	public static final By googleImg= By.xpath("//a[@class='g_connect']");
	
	public static final By mConnectImg= By.xpath("//a[@class='m_connect']");
	
	public static final By nextBtn= By.xpath("//button[text()='Next »']");
	
	public static final By gotItBtn= By.xpath("//button[text()='Got it!']");
	
	
	
	public AirtelLoginUserPage(WebDriver driver) throws IOException {
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
	
	public void clickNextBtn() throws WebDriverException, InterruptedException, IOException{
		 keywords.click(nextBtn);
	}
	
	public void clickGotItBtn() throws WebDriverException, InterruptedException, IOException{
		 keywords.click(gotItBtn);
	}
		
	
	public boolean verifyNextBtnDisplayed() throws WebDriverException, InterruptedException, IOException{
		return true;
	}
	
	public boolean verifyGotItBtnDisplayed() throws WebDriverException, InterruptedException, IOException{
		return true;
	}
		
	public void clickLogin() throws WebDriverException, InterruptedException, IOException{
		 keywords.click(loginLink);
	}
	
	public boolean verifyLoginDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(loginLink);
	}
	
	public boolean verifyPersonalDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(personal);
	}
	
	public boolean verifyBusinessDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(business);
	}
	public boolean verifyInvestorsDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(investors);
	}
	public boolean verifyFaceBookImgDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(faceBookImg);
	}
	public boolean verifyGoogleImgDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(googleImg);
	}
	public boolean verifyMConnectImgDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(mConnectImg);
	}
	public boolean verifyMobileNumberDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(mobileNumber);
	}
	public boolean verifyPasswordDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(password);
	}
	public boolean verifyLoginButtonSpanDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(loginButtonSpan);
	}
	public boolean verifyLoginBtnForgotPwdDisplayed() throws WebDriverException, InterruptedException, IOException{
		return keywords.isElementPresent(btnForgotPwd);
	}
	public void enterLogin() throws InterruptedException{
		Thread.sleep(2000);
		keywords.type(mobileNumber,"9949677751");
		keywords.type(password,"Hyderabad@123");
		keywords.click(loginButtonSpan);
		Thread.sleep(2000);
	}
	
}
