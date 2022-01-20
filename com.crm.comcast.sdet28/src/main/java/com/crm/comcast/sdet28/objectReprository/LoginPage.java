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

public class LoginPage {
	
	//ELEMENT INITIALIZATION
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	//ELEMNET IDENTIFICATION OR DECLARTION
	@FindBy(name="user_name")
	private WebElement usernameTextField;

	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginTextField;

	//GETTERS METHOD
	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginTextField() {
		return loginTextField;
	}
	/**
	 * BUSSINES LOGIC FOR LOGIN ACTION
	 * @param username
	 * @param password
	 */
	public void loginToApplication(String username, String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginTextField.click();
		
	}


	
	
}
