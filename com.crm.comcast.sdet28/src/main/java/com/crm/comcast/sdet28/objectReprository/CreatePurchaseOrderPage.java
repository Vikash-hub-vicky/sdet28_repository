package com.crm.comcast.sdet28.objectReprository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.sdet28.GenericUtility.WebDriverUtility;

public class CreatePurchaseOrderPage extends WebDriverUtility {
	
	public CreatePurchaseOrderPage(WebDriver driver) {
		PageFactory.initElements(driver , this);
	}
	@FindBy(name="subject")
	private WebElement subjectLinkText;
	
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement clickOnVendorImg;
	
	@FindBy(name="bill_street")
	private WebElement billingAddressLinkText;
	
	@FindBy(name="ship_street")
	private WebElement shippingAddressLinkText;
	
	@FindBy(id="searchIcon1")
	private WebElement clickOnProductImg;
	
	@FindBy(id="qty1")
	private WebElement quantityOfProdt;
	
	@FindBy(name="button")
	private WebElement saveButton;
	
	
	
	@FindBy(xpath="(//a[@href='javascript:window.close();'])[1]")
	private WebElement selectVendor;
	
	@FindBy(id="popup_product_20")
	private WebElement selectProduct;
	
	
	

	public WebElement getSubjectLinkText() {
		return subjectLinkText;
	}

	public WebElement getClickOnVendorImg() {
		return clickOnVendorImg;
	}

	public WebElement getBillingAddressLinkText() {
		return billingAddressLinkText;
	}

	public WebElement getShippingAddressLinkText() {
		return shippingAddressLinkText;
	}

	public WebElement getClickOnProductImg() {
		return clickOnProductImg;
	}

	public WebElement getGetQtyTextField() {
		return quantityOfProdt;
	}

	public WebElement getClickOnSaveLink() {
		return saveButton;
	}
	public WebElement getSelectVendor() {
		return selectVendor;
	}

	public WebElement getSelectProduct() {
		return selectProduct;
	}

	

	
	
	
	public void createSubject(String subject) {
		subjectLinkText.sendKeys(subject);
		
	}
	public void createBillingAddress(String billingaddress) {
	billingAddressLinkText.sendKeys(billingaddress);
	}
	public void createShippigAddress(String shippingaddress) {
		shippingAddressLinkText.sendKeys(shippingaddress);
}
	
	
	public void qtyProduct(double qty) {
		quantityOfProdt.sendKeys(qty+"");
	}
	public void clickOnVendorLink(WebDriver driver, String childBrowser, String parentBrowser) {
		clickOnVendorImg.click();
	switchWindow(driver ,childBrowser);
	selectVendor.click();
	switchWindow(driver , parentBrowser);
	}
	public void clickOnProductLink(WebDriver driver, String childBrowser  , String parentBrowser) {
		clickOnProductImg.click();
	switchWindow(driver ,childBrowser);
	selectProduct.click();
	switchWindow(driver,parentBrowser);
	}
	
	public void saveButton() {
		saveButton.click();	
	}

	
		
	}
	

	
		

	

