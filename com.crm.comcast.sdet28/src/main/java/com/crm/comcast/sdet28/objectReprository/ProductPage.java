package com.crm.comcast.sdet28.objectReprository;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author VIKASH PRATAP SINGH
 *
 */

public class ProductPage {
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createProductImg;
	
	//getters method
	public WebElement getCreateProductImg() {
		return createProductImg;
	}
	/**
	 * this method will click on create product
	 */
	public void clickOnCreateProductImg() {
		createProductImg.click();
	}
	
	
	
}
