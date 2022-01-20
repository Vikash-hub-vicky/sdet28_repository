package com.crm.comcast.sdet28.objectReprository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.sdet28.GenericUtility.WebDriverUtility;

public class ProductInfoPage extends WebDriverUtility{
	WebDriver driver;
	public ProductInfoPage(WebDriver driver) {
	PageFactory.initElements(driver, this);

}
	@FindBy(xpath="//img[@style='padding-left:5px']")
	private WebElement moreImg;
	
	@FindBy(name="Vendors")
	private WebElement vendorLink;

	public WebElement getMoreImg() {
		return moreImg;
	}

	public WebElement getClickOnVendorLink() {
		return vendorLink;
	}
	
	public void clickMoreLinkToGoVendorLink(WebDriver driver) {
		mouseOver(driver, moreImg);
		vendorLink.click();
	}

	
	}

