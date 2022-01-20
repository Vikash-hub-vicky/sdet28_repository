package com.crm.comcast.sdet28.objectReprository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.sdet28.GenericUtility.WebDriverUtility;

public class VendorInfoPage extends WebDriverUtility {
	WebDriver driver;

	public VendorInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//img[@style='padding-left:5px']")
	private WebElement moreImg;
	
	
	@FindBy(name="Purchase Order")
	private WebElement clickOnPurchaseText;

	public WebElement getMoreImg() {
		return moreImg;
	}


	public WebElement getClickOnPurchaseText() {
		return clickOnPurchaseText;
	}
	
	public void clickOnMoreLink(WebDriver driver) {
		mouseOver(driver, moreImg);
		clickOnPurchaseText.click();
		
	}
}