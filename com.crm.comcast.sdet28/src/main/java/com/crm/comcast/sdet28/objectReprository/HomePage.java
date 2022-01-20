package com.crm.comcast.sdet28.objectReprository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.sdet28.GenericUtility.WebDriverUtility;
/**
 * 
 * @author VIKASH PRATAP SINGH
 *
 */

public class HomePage extends WebDriverUtility {
	//initialization of elements
	WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver;
	}
	//declaration the element
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(xpath="//img[@style='padding-left:5px']")
	private WebElement moreImg;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	

	//getters method
		
	
	public WebElement getOrganizationLink() {
		return organizationLink;
	}
	public WebElement getProductLink() {
		return productLink;
	}
	public WebElement getMoreImg() {
		return moreImg;
	}
	public WebElement getLogoutImg() {
		return logoutImg;
	}
	public WebElement getSignOutLink() {
		return signOutLink;
	}
/**
 * this method will click on organization link
 */
	public void  clickOnOrganizationLink() {
	organizationLink.click();
}
	
	/**
	 * this method will click on product link
	 */
	public void clickOnProductLink() {
		productLink.click();
	}
	
	/**
	 * this method will click on logout action
	 */
	public void logoutImg() {
		mouseOver(driver, logoutImg);
		signOutLink.click();
	}
	

	}
	
	

	

