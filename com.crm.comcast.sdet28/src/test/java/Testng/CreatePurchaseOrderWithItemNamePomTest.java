package Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.comcast.sdet28.GenericUtility.BaseClass;
import com.crm.comcast.sdet28.GenericUtility.ExcelUtility;
import com.crm.comcast.sdet28.GenericUtility.FileUtility;
import com.crm.comcast.sdet28.GenericUtility.IPathConstants;
import com.crm.comcast.sdet28.GenericUtility.JavaUtility;
import com.crm.comcast.sdet28.GenericUtility.WebDriverUtility;
import com.crm.comcast.sdet28.objectReprository.CreatePurchaseOrderPage;
import com.crm.comcast.sdet28.objectReprository.CreateProductPage;
import com.crm.comcast.sdet28.objectReprository.CreateVendorPage;
import com.crm.comcast.sdet28.objectReprository.HomePage;
import com.crm.comcast.sdet28.objectReprository.LoginPage;
import com.crm.comcast.sdet28.objectReprository.ProductInfoPage;
import com.crm.comcast.sdet28.objectReprository.ProductPage;
import com.crm.comcast.sdet28.objectReprository.PurchaseInfoPage;
import com.crm.comcast.sdet28.objectReprository.PurchaseOrderPage;
import com.crm.comcast.sdet28.objectReprository.VendorInfoPage;
import com.crm.comcast.sdet28.objectReprository.VendorPage;
/**
 * 
 * @author VIKASH PRATAP SINGH
 *
 */

    public class CreatePurchaseOrderWithItemNamePomTest extends BaseClass {
	@Test
	
    public void createPuchaseOrderFram() throws Throwable {
    // get the data from Excel sheet
    String expectedName = eUtil.getStringCellData(IPathConstants.Sheet_Name, 35, 3);
	String subject = eUtil.getStringCellData("Sheet1", 31, 2);
    String vendorName = eUtil.getStringCellData("Sheet1", 32, 2);
    String billingaddress = eUtil.getStringCellData("Sheet1", 33, 2);
	String shippingAddress = eUtil.getStringCellData("Sheet1", 34, 2);
	String itemName = eUtil.getStringCellData("Sheet1", 35, 3);
	double qty = eUtil.getNumbericalData("Sheet1", 12, 2);
	String parentWinId = eUtil.getStringCellData("Sheet1", 37, 3);// parent browser
	String venorWinId = eUtil.getStringCellData("Sheet1", 38, 3);// child browser
	String productwinid = eUtil.getStringCellData("Sheet1", 39, 3);// child browser
	
    // opening home page
	HomePage homepage = new HomePage(driver);
	homepage.clickOnProductLink();

    // click on product link
    ProductPage productpg = new ProductPage(driver);
    productpg.clickOnCreateProductImg();

    // creat a product name
    CreateProductPage createProductPg = new CreateProductPage(driver);
    createProductPg.createProduct(itemName);

    // product to vendor link
    ProductInfoPage productInPg = new ProductInfoPage(driver);
    productInPg.clickMoreLinkToGoVendorLink(driver);

    // click on vendor link
    VendorPage vendorpg = new VendorPage(driver);
    vendorpg.clickOnVendorLinkText(driver);

	// create vendor name
	CreateVendorPage createVendorPg = new CreateVendorPage(driver);
	createVendorPg.createVendorName(vendorName);

	// vendor page to more link
	VendorInfoPage vendorinfoPg = new VendorInfoPage(driver);
	vendorinfoPg.clickOnMoreLink(driver);

	// click on puchase order
	PurchaseOrderPage purcahsepg = new PurchaseOrderPage(driver);
	purcahsepg.clickOnPurchaseOrderImage(driver);

	CreatePurchaseOrderPage createPuchaseOdr = new CreatePurchaseOrderPage(driver);

	// create subject
	createPuchaseOdr.createSubject(subject);

	// create vendorplus button and clicking vendor name from child browser
	createPuchaseOdr.clickOnVendorLink(driver, parentWinId, venorWinId);

	// creating billing address
	createPuchaseOdr.createBillingAddress(billingaddress);

	// creating shipping address
	createPuchaseOdr.createShippigAddress(shippingAddress);

	// click productplus button and clicking name from child browser
	createPuchaseOdr.clickOnProductLink(driver, parentWinId, productwinid);

	// enetering quantity no.
	createPuchaseOdr.qtyProduct(qty);

	// save the purchase page
	createPuchaseOdr.saveButton();

	// get text
	PurchaseInfoPage purchaseOdrInfo = new PurchaseInfoPage(driver);
	String actualText = purchaseOdrInfo.purchaseInfoText();

	// purchase order verification
	if (actualText.contains(expectedName)) {
		System.out.println("Life Style ");
	} else {
		System.out.println("Not life style");
	}

}

}
			
	
	