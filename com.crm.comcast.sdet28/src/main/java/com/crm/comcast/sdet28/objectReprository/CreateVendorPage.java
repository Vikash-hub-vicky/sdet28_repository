package com.crm.comcast.sdet28.objectReprository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendorPage {
	
	public CreateVendorPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="vendorname")
	private WebElement vendorName;
	
	@FindBy(name="button")
	private WebElement saveButton;
	
	public void createVendorName(String vendorname) {
	vendorName.sendKeys(vendorname);
	saveButton.click();
	}
}
