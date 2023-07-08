package com.airtel.utilities;

// FileName: 			Keywords.Java
// Author:   			Ramalakshmi
// Date of Creation: 	20-10-2013
// Description: 		This class file extends the DriverScript class.
//						This class file is having various methods (keywords) defined in it.
//						Each method is declared as Public Static -- So that it is available to all classes in the project
//						and each methods returns a string value (either pass or fail) which is used in representing report.

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;

import com.airtel.utilities.InvokeWebDriver;




public class Keywords {

	private static Logger applicationLogs = Logger.getLogger(Keywords.class);	
	private static Keywords keywordInstance = null;
	public static WebDriver driver;		
	private String object;	
	
	
	
	public static Keywords getInstance() throws IOException {
		if (keywordInstance == null) {
			keywordInstance = new Keywords();
		}
		return keywordInstance;
	}
	public static void invokeBrowser() throws IOException {		
		driver = InvokeWebDriver.getWebDriverInstance();
	}
	public void openUrl(String url)  {
		
		driver.get(url);
	}

		
	/**
	 * @return
	 */
	public String click(By byPath) {
		applicationLogs.info("Executing click keyword -->Start");
		try {
			applicationLogs.info("Clicking the object :");
			WebElement element = getObject(byPath);
			Thread.sleep(500);
			element.click();			
			applicationLogs.info("Click " + byPath
					+ " Successfull");
		} catch (Exception e) {
			applicationLogs.error("Error while clicking the object - "
					+ byPath);
			applicationLogs.error("Error message : " + e.getMessage());
			return "Fail";
		}
		applicationLogs.info("Executing click keyword -->End");
		return "PASS";
	}

	// 3. switch to frame based on frame id (
	public String switchFrame(String frameName) {
		applicationLogs.info("Executing switchFrame keyword -->Start");
		try {

			driver.switchTo().frame(frameName);
			applicationLogs.info("Switched to frame "
					+ frameName + " Successfully");
		} catch (Exception e) {
			applicationLogs.error("Error while switching to frame -"
					+ frameName);
			applicationLogs.error("Error Message : " + e.getMessage());
			return "Fail";
		}
		applicationLogs.info("Executing switchFrame keyword -->End");
		return "PASS";
	}

	// 4. verify the text present in a text box.
	public String verifyText(By byPath) throws InterruptedException, WebDriverException,
			IOException {
		applicationLogs.info("Executing verifyText keyword -->Start");
		String actual = getObject(byPath).getAttribute("value");
		applicationLogs.info("getObject(object)-->" + getObject(byPath));
		applicationLogs.info("actual-->" + actual);	
		applicationLogs.info("Executing verifyText keyword -->End");
		return "PASS";
	}

	// 5. verify text present in a label
	public String verifyLabel(By byPath) throws InterruptedException,
			WebDriverException, IOException {
		applicationLogs.info("Executing verifyLabel keyword -->Start");
		String expected = null;
		String actual = null;

		try {
		
			actual = getObject(byPath).getText();			
		} catch (Exception e) {
			// report error
			applicationLogs.error("Error: Expected text" + expected
					+ " Actual text " + actual);
			applicationLogs.error("Error message : " + e.getMessage());
			return "Fail";
		}
		applicationLogs.info("Executing verifyLabel keyword -->End");
		return "PASS";
	}

	// 5. verify text present in a label
	public String verifyLogin(By byPath) throws InterruptedException,
			WebDriverException, IOException {
		applicationLogs.info("Executing verifyLogin keyword -->Start");
		String expected = null;
		String actual = null;
		try {			
			actual = getObject(byPath).getText();			
			
		} catch (Exception e) {
			// report error
			applicationLogs.error("Error: Expected text" + expected
					+ " Actual text " + actual);
			applicationLogs.error("Error message : " + e.getMessage());
			return "Fail";
		}
		// return "Pass";
		return actual;
	}

	// 6. select a text in a combobox
	public String select(By byPath,String data) {
		applicationLogs.info("Executing select keyword-->Start");
		try {
			new Select(getObject(byPath)).selectByVisibleText(data);			
			applicationLogs.info(data + " selected from the object " + object);
		} catch (Exception e) {			
			applicationLogs.error("Error while selecting " + data
					+ " from the object " + object);
			applicationLogs.error("Error message : " + e.getMessage());
			return "Fail";
		}
		applicationLogs.info("Executing select keyword-->End");
		return "PASS";
	}

	// 7. enter text into a text box filed
	public String type(By byPath,String data) {
		applicationLogs.info("Executing type keyword-->Start");
		try {
		
			getObject(byPath).clear();
			getObject(byPath).sendKeys(data);
			// Thread.sleep(500);
			applicationLogs.info(data + " entered into the textbox " + object);
		} catch (Exception e) {
			// report error
			applicationLogs.error("Error while entering " + data
					+ " into textbox " + object);
			applicationLogs.error("Error Message : " + e.getMessage());
			return "Fail";
		}
		applicationLogs.info("Executing type keyword-->End");
		return "PASS";
	}
	public String setAttribute(By byPath,String data) {
		applicationLogs.info("Executing type keyword-->Start");
		try {
			WebElement element=getObject(byPath);
			 JavascriptExecutor js = (JavascriptExecutor)driver;	
			js.executeScript("arguments[0].setAttribute('value', '" + data +"')", element);
			/*getObject(byPath).setAttribute("value", "your value");
			getObject(byPath).sendKeys(data);*/
			// Thread.sleep(500);
			applicationLogs.info(data + " entered into the textbox " + object);
		} catch (Exception e) {
			// report error
			applicationLogs.error("Error while entering " + data
					+ " into textbox " + object);
			applicationLogs.error("Error Message : " + e.getMessage());
			return "Fail";
		}
		applicationLogs.info("Executing type keyword-->End");
		return "PASS";
	}

	public String getObjectValue(By byPath)  {
		applicationLogs.info("Executing getObjectValue keyword-->Start");
		try {
			String value = null;
			try {
				
				value = getObject(byPath).getAttribute("value");
				if (value == null) {
					value = getObject(byPath).getText();
				} else if (value.trim().isEmpty()) {
					value = getObject(byPath).getText();
				}
				applicationLogs
						.info("getObjectValue getObjectValue ***************>>>"
								+ value);

			} catch (WebDriverException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
			applicationLogs.info("Executing getObjectValue keyword-->End");
			return value;
		} catch (Exception e) {
			
		}
		return object;
	}

	
	public void closeApplication() {
		applicationLogs.info("Closing the Application/Browser");		
		driver.quit();		
	}

	public WebElement getObject(By byPath) throws InterruptedException,
			WebDriverException, IOException {
		applicationLogs.info("Executing getObject keyword-->Start");
		WebElement element = null;		
		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		try {	
			fwait.until(ExpectedConditions.visibilityOfElementLocated(byPath));
			element = driver.findElement(byPath);			
		} catch (Exception e) {			
			e.printStackTrace();
			return null;
		}
		applicationLogs.info("Executing getObject keyword-->End");
		return element;
	}

	public void takeScreenShot(String filePath) throws WebDriverException,
			IOException {
		applicationLogs.info("Executing takeScreenShot keyword-->Start");
		try {
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(scrFile, new File(filePath));
			Thread.sleep(500);
			applicationLogs.info("Executing takeScreenShot keyword-->End");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			applicationLogs.error("Error message : " + e.getMessage());
		}

	}

	public String waitForProcess() {
		applicationLogs.info("Executing waitForProcess keyword-->Start");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return "PASS";
	}

	public String explictWait() {
		applicationLogs.info("Executing explictWait keyword-->Start");
		try {
			WebElement myDynamicElement = (new WebDriverWait(driver, 45))
					.until(ExpectedConditions.visibilityOfElementLocated(By
							.xpath(object)));
			applicationLogs.info("Executing explictWait keyword-->End");
			return "PASS";
		} catch (Exception e) {
			return "PASS";
		}
		
	}
		
	public String getAttributeValue(Document document, String xpath,
			String attribute) throws Exception {
		applicationLogs.info("Executing getAttributeValue keyword-->Start");
		XPath xPath = XPathFactory.newInstance().newXPath();
		XPathExpression xPathExpression = xPath.compile(xpath + "/" + "@"
				+ attribute);
		String attributeValue = ""
				+ xPathExpression.evaluate(document, XPathConstants.STRING);
		
		applicationLogs.info("Executing getAttributeValue keyword-->End");
		return "PASS";

	}
	public String skipPanel(By byPath) throws WebDriverException, InterruptedException,
			IOException {
		applicationLogs.info("Executing skipPanel keyword-->Start");
		WebElement obj = getObject(byPath);

		if (driver.findElements(By.xpath(object)).size() > 0) {
			getObject(byPath).click();
			return "PASS";
		}
		applicationLogs.info("Executing skipPanel keyword-->End");
		return "Fail";
	}
	

	public boolean isEnable(By byPath,String data) throws WebDriverException, InterruptedException,
			IOException {
		applicationLogs.info("Executing isEnable keyword-->Start");
		boolean isEnable= false;
		WebElement obj = getObject(byPath);
		if (data.equalsIgnoreCase("Enabled")) {
			if (obj.isEnabled()) {
				isEnable = true;

			}
		} else if (data.equalsIgnoreCase("Disabled")) {
			if (!obj.isEnabled()) {
				isEnable = false;

			}
		}
		applicationLogs.info("Executing isEnable keyword-->End");
		return isEnable;
	}

	public boolean isChecked(By byPath,String data) throws WebDriverException, InterruptedException,
			IOException {
		applicationLogs.info("Executing isChecked keyword-->Start");
		boolean isEnable = false;
		WebElement obj = getObject(byPath);

		if (data.equalsIgnoreCase("Checked")) {
			if (obj.isSelected()) {
				isEnable = true;

			}
		} else if (data.equalsIgnoreCase("UnChecked")) {
			if (!obj.isSelected()) {
				isEnable = true;

			}
		}
		applicationLogs.info("Executing isChecked keyword-->End");
		return isEnable;
	}

	public boolean isElementPresent(By byPath) throws WebDriverException, InterruptedException, IOException  {
		applicationLogs.info("Executing isElementPresent keyword-->Start");
		boolean isEnable = false;
		WebElement obj = getObject(byPath);
		if (obj.isDisplayed()) {
			isEnable = true;
		}
		applicationLogs.info("Executing isElementPresent keyword-->End");
		return isEnable;
	}
	

	public void skip() {
		applicationLogs.info("Executing skip keyword-->Start");
		String xyz = driver.findElement(By.cssSelector("span.steptitle"))
				.getText();
		String title = "Work In Progress";
		if (xyz.equalsIgnoreCase(title)) {
			driver.findElement(By.name("newapp")).click();
		}
		applicationLogs.info("Executing skip keyword-->End");
	}

	

	public void keyHandling(By byPath) {
		applicationLogs.info("Executing keyHandling keyword-->Start");
		try {
			getObject(byPath).sendKeys(Keys.TAB);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		applicationLogs.info("Executing keyHandling keyword-->End");
	}

	

	public String retrieveValueFromSelectBox(By byPath) throws WebDriverException,
			InterruptedException, IOException {
		applicationLogs.info("Executing retrieveValueFromSelectBox keyword-->Start");
		Select comboBox = new Select(getObject(byPath));
		String selectedComboValue = comboBox.getFirstSelectedOption().getText();
		applicationLogs.info("Executing retrieveValueFromSelectBox keyword-->End");
		return selectedComboValue;
	}
	

	public String getSelectedValue(By byPath)  {
		applicationLogs.info("Executing getSelectedValue keyword-->Start");
		Select selectBox = null;
		String value = "";
		try {
			selectBox = new Select(getObject(byPath));
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		value = selectBox.getFirstSelectedOption().getText();	
		
		applicationLogs.info("Executing getSelectedValue keyword-->End");
		return value;

	}

	public String getCurrentDate() {
		applicationLogs.info("Executing getCurrentDate keyword-->Start");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String currentDate = dateFormat.format(date);		
		applicationLogs.info("Executing getCurrentDate keyword-->End");
		return currentDate;
	}

	public String verifyListBoxValues(By byPath,String data) {
		applicationLogs.info("Executing verifyListBoxValues keyword-->Start");
		String comboResult[] = data.split(";");
		boolean flag = false;
		Select selectBox = null;
		String value = "";
		try {
			selectBox = new Select(getObject(byPath));
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.util.List<WebElement> list = selectBox.getOptions();
		return value;

		
		
	}
	
	public String selectOptionText(By byPath,String data)  {
		applicationLogs.info("Executing verifyListBoxValues keyword-->Start");
		String comboResult[] = data.split(";");
		boolean flag = false;
		Select selectBox = null;
		String value = "";
		try {
			selectBox = new Select(getObject(byPath));
			selectBox.selectByVisibleText(data);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.util.List<WebElement> list = selectBox.getOptions();
		if(null!=data && Integer.parseInt(data)<list.size()){
		value=list.get(Integer.parseInt(data)).getText();
		}
		return "PASS";
		
	}
	public void selectByPartOfVisibleText(String byPath,String data) throws WebDriverException, InterruptedException, IOException {
		 //Select selectBox = new Select(getObject(byPath));
		 driver.findElement(By.xpath("//select[@id = '"+byPath+"']/option[contains(text(), '"+data+"')]")).click();
	    /*List<WebElement> optionElements = driver.findElements(byPath);

	    for (WebElement optionElement: optionElements) {
	        if (optionElement.getText().contains(data)) {
	        	System.out.println(optionElement.getText());
	            String optionIndex = optionElement.getAttribute("index");
	            selectBox.selectByIndex(Integer.parseInt(optionIndex));
	            break;
	        }
	    }
*/
	    Thread.sleep(300);
	}
	/*public String selectOptionValue(By byPath,String data)  {
		applicationLogs.info("Executing verifyListBoxValues keyword-->Start");
		String comboResult[] = data.split(";");
		boolean flag = false;
		Select selectBox = null;
		String value = "";
		try {
			selectBox = new Select(getObject(byPath));
			selectBox.selectByVisibleValue(data);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.util.List<WebElement> list = selectBox.getOptions();
		if(null!=data && Integer.parseInt(data)<list.size()){
		value=list.get(Integer.parseInt(data)).getText();
		}
		return "PASS";
		
	}*/

	public void swithToAlert(String data) throws InterruptedException {
		applicationLogs.info("Executing swithToAlert keyword-->Start");
		Alert alert = driver.switchTo().alert();
		applicationLogs.info("data" + alert.getText().toString());
		if (data.equalsIgnoreCase("OK")) {
			alert.accept();
		} else {
			alert.dismiss();
		}
		applicationLogs.info("Executing swithToAlert keyword-->End");
	}

	public void selectGridRows(By byPath,String data) throws Exception {
		applicationLogs.info("Executing VerifyGridRows keyword-->Start");
		WebElement table = getObject(byPath);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int count = 0;
		String givenData = data;
		boolean flag = false;
		for (int i = 0; i < rows.size(); i++) {
			List<WebElement> row = rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < row.size(); j++) {
				if (!givenData.trim().isEmpty()
						&& !givenData.trim().equalsIgnoreCase("null")) {
					if (!row.get(j).getText().trim()
							.equalsIgnoreCase(givenData.trim())) {	
						Actions action=new Actions(driver);
						action.moveToElement(row.get(i)).build().perform();
						
						flag = true;
						break;
					} else {
						
						applicationLogs.info("match row.get(j).getText()------->>"
										+ row.get(j).getText());
						applicationLogs.info(" match givenData[count]------->>"
								+ givenData.trim());
						System.out.println("match row.get(j).getText()------->>"
								+ row.get(j).getText());
						System.out.println(" match givenData[count]------->>"
						+ givenData.trim());	
						
					}
				}
				count++;
			}if (flag) {
				break;
			} 
		}
		applicationLogs.info("Executing VerifyGridRows keyword-->End");
		System.out.println("Faggggggggggggg"
				+ flag);
		
	}
	public String verifyImage(By byPath,String data) throws WebDriverException,
    InterruptedException, IOException {
        String value = null;       
        applicationLogs.info("Executing VerifyDataPresent keyword");
        value = getObject(byPath).getAttribute("src");        
        if(value.contains(data)){
            return "PASS";
        }else{
            return "FAIL";
        }
	}
	public void navigate(String url){
		driver.navigate().to(url);
	}
	
	public String mouseOver(By byPath){
		Actions action = new Actions(driver);
		try {
			WebElement element = getObject(byPath);			
			action.moveToElement(element).build().perform();
			action.click().build().perform();
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "PASS";
		
	}
	public String moveByOffset(By byPath) {		
		try {
			WebElement element = getObject(byPath);			
			new Actions(driver).clickAndHold(element).moveByOffset(100,800).perform();
			//new Actions(driver).m
			 Point coordinates = element.getLocation();
			  Robot robot;
			  robot = new Robot();			
			  robot.mouseMove(coordinates.getX(),coordinates.getY()+220);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "PASS";
		
	}
	
	public String verifySelectedValue(By byPath,String data) throws Exception {
		applicationLogs.info("Executing VerifySelectedValue keyword-->Start");
		String result;
		if(getSelectedValue(byPath).equalsIgnoreCase(data)){
		result = "PASS";
		}
		else
		result = "FAIL";
		applicationLogs.info("Executing verifySelectedValue keyword-->End");
		return result;
		}
	public void enterKeys(By byPath){
		WebElement element;
		try {
			element = getObject(byPath);
			element.sendKeys(Keys.TAB);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	public void explicitWait(By by){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void keysTab(By byPath){
		WebElement element;
		try {
			element = getObject(byPath);
			element.sendKeys(Keys.TAB);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public boolean getGridData(String by){
		boolean flag=false;
		List<WebElement> trEle=driver.findElements(By.xpath(by));
		
		for(int i=1;i<trEle.size();i++){
			List<WebElement> tdEle=driver.findElements(By.xpath(by+"[@id='market1_trip_1']["+i+"]/td[4]/a"));
			if(tdEle.size()>0){
			String result=tdEle.get(0).getText();
			System.out.println(result);
			if(result.equals("Nonstop")){
				flag=true;
				WebElement price=driver.findElement(By.xpath(by+"[@id='market1_trip_1']["+i+"]/td[7]/div/label/input"));
				System.out.println("price-->"+price.getAttribute("value"));
				break;					
				}
			}else{/*
				 List<WebElement> gridData=driver.findElements(By.xpath("//div[@id='calendarMarket1']//table[@class='availabilityCalendar']//tbody[@class='calendar_days']/tr/td"));
				 if(gridData.size()>0){
					 for(int k=1;k<gridData.size();k++){
						 String ele=gridData.get(k).getAttribute("class");
						 if(!ele.equals("na not_available")){
							 gridData.get(k).findElement(By.tagName("a")).click();
							 break;		
						 }
						 
					 }
				 }
				
			 
				break;
			*/
				break;}
		}
		
		return flag;		
	}
	

	public void executeJavaScript(By by){
		WebElement element = driver.findElement(by);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	public void getWindowHandlers(String mainWindow){
		Set<String> allWindowHandles = driver.getWindowHandles();		 
		for(String handle : allWindowHandles)
		{
			if(mainWindow!=handle){
				driver.switchTo().window(handle);
				break;
				//System.out.println("Window handle - > " + handle);
			}
		}
	}
}
