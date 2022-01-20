package com.crm.comcast.sdet28.objectReprository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.sdet28.GenericUtility.WebDriverUtility;

public class PurchaseInfoPage extends WebDriverUtility{
	WebDriver driver;
	
	public PurchaseInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement purchaseInfoText;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;

	public WebElement getLogoutImg() {
		return logoutImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	public WebElement getPurchaseInfo() {
		return purchaseInfoText;
	}
	public String purchaseInfoText() {
		  return purchaseInfoText.getText();
	}
	
	public void logoutImg() {
		mouseOver(driver, logoutImg);
		signOutLink.click();
	}

	
}
