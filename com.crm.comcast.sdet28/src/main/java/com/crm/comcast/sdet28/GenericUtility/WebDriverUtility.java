package com.crm.comcast.sdet28.GenericUtility;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.util.MultidimensionalCounter.Iterator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author VIKASH PRATAP SINGH
 *
 */

public class WebDriverUtility {
	/**
	 * It will wait for 20 seconds till the element load in DOM
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	/**
	 * This method will wait till element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForVisibilityOfElement(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will wait till element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementTobeClick(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	/**
	 * THIS METHOD IS USED TO WAIT FOR THE ELEMENT AND DO CLICK OPERATION
	 * @param element
	 * @throws Throwable
	 */
	public void waitAndClick(WebElement element) throws Throwable {
		int count=0;
		while(count<50) {
			try {
				element.click();
			}catch(Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * THIS METHOD WILL SELECT THE ELEMENT BASED ON INDEX
	 * @param element
	 * @param index
	 */
	
	public void selectOption(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * THIS METHOD WILL SELECT THE ELEMENT BASED ON VALUE
	 * @param element
	 * @param value
	 */
	public void selectOption(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
 }
	/**
	 * THIS METHOD WILL SELECT THE ELEMENT BASED ON TEXT
	 * @param text
	 * @param element
	 */
	public void selectOption(String text,WebElement element ) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	/**
	 * THIS METHOD WILL VERFIY WHETHER EXEPECTED OPTION IS PRESNT IN DROPDOWN LIST O NOT
	 * @param element
	 * @param expectedOptions
	 * @return
	 */
	public WebElement verifyTheDropDownlist(WebElement element, String expectedOptions) {
		Select select = new Select(element);
		 List<WebElement> options = select.getOptions();
		 for (WebElement ele: options) {
			 if(ele.equals(expectedOptions)) {
				 System.out.println("valu is present in dropdown");
				 return ele;
			 }else {
				 System.out.println("value is not presnt in dropdown");
				 return ele;
			 }
		 }
		
		return null;
	}
	/**
	 * THIS METHOD PERFORM MOUSE HOVER ACTION
	 * @param driver
	 * @param element
	 */
	
	public void mouseOver(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
	}
	/**
	 * THIS METHOD PERFORM RIGTH CLICK ACTION 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
}
	/**
	 * THIS METHOD USED TO  PERFORM JAVASCRIPT CLICK ON WEBELEMNT
	 * @param driver
	 * @param elemnet
	 */
	public void jsClick(WebDriver driver, WebElement element){
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click", element);
	}
	/**
	 * THIS IS USED TO SEND THE VALUE USING JAVASCRIPT EXECUTOR
	 * @param driver
	 * @param valueToEnter
	 * @param element
	 */
	public void enterDataUsingJs(WebDriver driver, String valueToEnter, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value=' "+valueToEnter+"'", element);
	}
	/**
	 * THIS WINDOW WILL SWITCH TO DIFFERENT WINDOWS USING PARTIAL TITLE
	 * @param driver
	 * @param partialWindowTitle
	 */
	
	public void switchWindow(WebDriver driver, String partialWindowTitle) {   //wrong
	Set<String> winIds = driver.getWindowHandles();
	 java.util.Iterator<String> it = winIds.iterator();
	while(it.hasNext()) {
		String winId = it.next();
		String title = driver.switchTo().window(winId).getTitle();
		if(title.contains(partialWindowTitle)) {
			break;
		}
	}
			}
			
		
	
	/**
	 * THIS METHOD IS USED TO TAKE SCREENSHOT IN THE CASE OF FAILURE
	 * @param driver
	 * @param testCaseName
	 * @return
	 */
	public String screenShot(WebDriver driver, String testCaseName) {
		JavaUtility jUtil = new JavaUtility();
		 String filePath = "./errorshot"+testCaseName+jUtil.systemDateAndTime()+".png";//wrong
		 TakesScreenshot ts = (TakesScreenshot)(driver);
		 File source =ts.getScreenshotAs(OutputType.FILE);
		 File destination = new File(filePath);
		 //File.copy(source,destination);
		 source.renameTo(destination);
		 return filePath;
		 
	}
	/**
	 * THIS METHOD WILL SWITCH THE FRAMES BASED ON THE INDEX PASSED
	 * @param driver
	 * @param index
	 */
	public void switchframes(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * THIS METHOD WILL SWITCH THE FRAMES BASED ON THE NAME OR ID PASSED
	 * @param driver
	 * @param nameOrId
	 */
	public void switchframes(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * THIS METHOD WILL SWITCH THE FRAMES BASED ON THE WEBELEMENT PASSED
	 * @param driver
	 * @param element
	 */
	public void switchframes(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * METHOD WILL ACCEPT THE ALERT
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * THIS METHOD IS CLICK ON DISMISS BUTTON IN ALERT POPUP
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
		}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	





















