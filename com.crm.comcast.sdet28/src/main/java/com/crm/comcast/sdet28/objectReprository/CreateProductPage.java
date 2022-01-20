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

public class CreateProductPage {
	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productname")
	private  WebElement ProductNameTextField;
	
	@FindBy(name="button")
	private WebElement saveButtonLink;

	//getters method
	public WebElement getProductNameTextField() {
		return ProductNameTextField;
	}

	public WebElement getSaveButtonLink() {
		return saveButtonLink;
	}
	public void createProduct(String productName) {
		ProductNameTextField.sendKeys(productName);	
		saveButtonLink.click();
	}
		
	}


