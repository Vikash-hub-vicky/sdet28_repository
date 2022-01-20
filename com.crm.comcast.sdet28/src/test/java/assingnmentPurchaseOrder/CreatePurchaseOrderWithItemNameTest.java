package assingnmentPurchaseOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.crm.comcast.sdet28.GenericUtility.ExcelUtility;
import com.crm.comcast.sdet28.GenericUtility.FileUtility;
import com.crm.comcast.sdet28.GenericUtility.IPathConstants;
import com.crm.comcast.sdet28.GenericUtility.JavaUtility;
import com.crm.comcast.sdet28.GenericUtility.WebDriverUtility;
/**
 * 
 * @author VIKASH PRATAP SINGH
 *
 */

public class CreatePurchaseOrderWithItemNameTest {

	public static void main(String[] args) throws Throwable {
		
		//CREATE OBJECT FOR UTILITIES
		JavaUtility jUtil = new JavaUtility();
		ExcelUtility eUtil = new ExcelUtility();
		FileUtility fUtil = new FileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
	
	    //GET THE DATA FROM PROPERTY FILE
		
		String browser = fUtil.getPropertyFileData("browser");
		String url = fUtil.getPropertyFileData("url");
		String username = fUtil.getPropertyFileData("username");
		String password = fUtil.getPropertyFileData("password");
		
		
		
		
		//HOW TO USE BROWSER VALUE AND LAUNCH THE BROWSER
				WebDriver driver = null;
				
				if(browser.equalsIgnoreCase("chrome")){
				
				System.setProperty(IPathConstants.CHROME_KEY, IPathConstants.CHROME_PATH	);
				 driver = new ChromeDriver();
				}
				else if (browser.equals("firefox")) {
				
				System.setProperty(IPathConstants.FIREFOX_KEY,IPathConstants.FIREFOX_PATH);	
				 driver = new FirefoxDriver();
				}
				else {
					System.out.println("browser is not supported");
				}
				
				driver.manage().window().maximize();
				wUtil.waitForPageLoad(driver);
				 
				//login to application
				driver.get(url);
				driver.findElement(By.name("user_name")).sendKeys(username);
				driver.findElement(By.name("user_password")).sendKeys(password);
				driver.findElement(By.id("submitButton")).click();
				
				WebElement purchaseOrder = driver.findElement(By.xpath("(//a[@href='javascript:;'])[1]"));
				wUtil.mouseOver(driver, purchaseOrder);
				driver.findElement(By.name("Purchase Order")).click();
				driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
				
				//GET THE DATA FROM EXCEL FILE
				String expectedName = eUtil.getStringCellData(IPathConstants.Sheet_Name, 30, 3);
				String subject = eUtil.getStringCellData("Sheet1", 7, 2);
				driver.findElement(By.name("subject")).sendKeys(subject);		  
				driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
				
				String partialWindow = "Vendors&action";
				wUtil.switchWindow(driver, partialWindow);
				String vendorName = eUtil.getStringCellData("Sheet1", 8, 2);
				driver.findElement(By.id("search_txt")).sendKeys(vendorName);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.xpath("(//a[@href='javascript:window.close();'])[1]")).click();
				
				wUtil.switchWindow(driver, "PurchaseOrder&action");
				
				 String BillingAddress = eUtil.getStringCellData("Sheet1", 9, 2);
					driver.findElement(By.name("bill_street")).sendKeys(BillingAddress);
					String ShippingAddress = eUtil.getStringCellData("Sheet1", 10, 2);
					driver.findElement(By.name("ship_street")).sendKeys(ShippingAddress);
					driver.findElement(By.id("searchIcon1")).click();
					
					String partialWindow1 = "Products&action";
					wUtil.switchWindow(driver, partialWindow1);
					String itemName = eUtil.getStringCellData("Sheet1", 11, 2);
					driver.findElement(By.id("search_txt")).sendKeys(itemName);
					driver.findElement(By.name("search")).click();
					driver.findElement(By.id("popup_product_20")).click();
					
					wUtil.switchWindow(driver, "PurchaseOrder&action");
					
					String qty = eUtil.getStringCellData("Sheet1", 12, 2);
					driver.findElement(By.id("qty1")).sendKeys(qty);
					
					driver.findElement(By.name("button")).click();
				
					//organization name verification
					String actualText = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
					if(expectedName.contains(actualText))
					{			
						System.out.println("Item order is created");
					}
					
					else 
					{
						System.out.println("Item  is not created");
					}
					
					//logout action
					WebElement profileImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
					wUtil.mouseOver(driver, profileImg);
					driver.findElement(By.linkText("Sign Out")).click();
					driver.quit();
	}
	
	
}

	
	
	