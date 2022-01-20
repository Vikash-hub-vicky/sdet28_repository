package com.crm.comcast.sdet28.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.comcast.sdet28.objectReprository.HomePage;
import com.crm.comcast.sdet28.objectReprository.LoginPage;
/**
 * 
 * @author VIKASH PRATAP SINGH
 *
 */

    public class BaseClass {
	public WebDriver driver;
	//generic utility
	public static WebDriver sdriver;
	public FileUtility fUtil = new FileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public JavaUtility jUtil = new JavaUtility();
	public ExcelUtility eUtil = new ExcelUtility();
	
	@BeforeSuite(groups = {"smoke","regression"})
	public void confidBs() {
	//connection to DB
	System.out.println("conect to DB");
		}
	@Parameters("browser")
	@BeforeClass(groups = {"smoke","regression"})
	public void configBc() throws Throwable {
			
	//getting the data from property file
	String browser= fUtil.getPropertyFileData("browser");
	String url = fUtil.getPropertyFileData("url");
	
	//launch the browser
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
		sdriver = driver;	
	driver.manage().window().maximize();
	wUtil.waitForPageLoad(driver);
	driver.get(url);
		
	}
	@BeforeMethod(groups = {"smoke","regression"})
	public void configBm() throws Throwable {
	//getting the data from file utility
    String username = fUtil.getPropertyFileData("username");
	String password = fUtil.getPropertyFileData("password");
	
	//login the app
	LoginPage login = new LoginPage(driver);
	login.loginToApplication(username,password);
		
		
	}
	@AfterMethod(groups = {"smoke","regression"})
	public void configAm() {
	//logout
	HomePage homepage = new HomePage(driver);
	homepage.logoutImg();
	}
	@AfterClass(groups = {"smoke","regression"})
	public void configAc() {
	//close the browser
	driver.quit();
		
	}
	@AfterSuite(groups = {"smoke","regression"})
	public void configAs() {
	//close the DataBase
	System.out.println("disconnect from DB");
		
	}
	
	
	
	
	
	
	
	
	
	

}
