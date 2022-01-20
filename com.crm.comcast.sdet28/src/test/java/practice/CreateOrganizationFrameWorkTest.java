package practice;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.comcast.sdet28.GenericUtility.ExcelUtility;
import com.crm.comcast.sdet28.GenericUtility.FileUtility;

import com.crm.comcast.sdet28.GenericUtility.IPathConstants;
import com.crm.comcast.sdet28.GenericUtility.JavaUtility;
import com.crm.comcast.sdet28.GenericUtility.WebDriverUtility;

public class CreateOrganizationFrameWorkTest {

	public static void main(String[] args) throws Throwable {
		
		//CREATE OBJECT FOR UTILITIES
		FileUtility fUtil = new FileUtility();
		JavaUtility jUtil = new JavaUtility();
		ExcelUtility eUtil= new ExcelUtility();
		WebDriverUtility wUtil= new WebDriverUtility();
		
		//GET THE DATA FROM PROPERTY FILE
		String browserName = fUtil.getPropertyFileData("browser");
		String url = fUtil.getPropertyFileData("url");
		String username = fUtil.getPropertyFileData("username");
		String password = fUtil.getPropertyFileData("password");
		
		//GERERATE RANDOM NUMBER
		int randomNumber = jUtil.getRandomNumber();
		
		//GET THE DATA FROM EXCEL SHEET
		String organizationName = eUtil.getStringCellData("sheet1", 1, 2);
		organizationName= organizationName+randomNumber;
		
		//HOW TO USE BROWSER VALUE AND LAUNCH THE BROWSER
		WebDriver driver = null;
		if(browserName.equalsIgnoreCase("chrome")){
		
		System.setProperty(IPathConstants.CHROME_KEY, IPathConstants.CHROME_PATH	);
		 driver = new ChromeDriver();
		}
		else if (browserName.equals("firefox")) {
		
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
		
		// create organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(organizationName);
		driver.findElement(By.name("button")).click();
		
		//organization name verification
		String actualOrgName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actualOrgName.contains(organizationName))
		{
			System.out.println("Oranization is created");
		}
		else 
		{
			System.out.println("Oranization is not created");
		}
		
		//logout action
		WebElement profileImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseOver(driver, profileImg);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}

	}


