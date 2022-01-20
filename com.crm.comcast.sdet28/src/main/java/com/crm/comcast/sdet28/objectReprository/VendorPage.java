package com.crm.comcast.sdet28.objectReprository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPage {
	public VendorPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	@FindBy(xpath="//img[@alt='Create Vendor...']")
	private WebElement createVendor;
	
	
	public WebElement getCreateVendor() {
		return createVendor;
	}
	
	public void clickOnVendorLinkText(WebDriver driver) {
		createVendor.click();
	}
}
