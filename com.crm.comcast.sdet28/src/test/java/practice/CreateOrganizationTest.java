package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

class CreateOrganizationTest {

	public static void main(String[] args) throws IOException {
		//get the data from property file
		FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
		Properties property = new Properties();
		property.load(fis);
		String browserName = property.getProperty("browser");
		String url = property.getProperty("url");
		String username = property.getProperty("username");
		String password = property.getProperty("password");
		
		//how to use browser value and the launch the browser
		
		WebDriver driver = null;
		if(browserName.equals("chrome")){
		
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		 driver = new ChromeDriver();
		}
		else if (browserName.equals("firefox")) {
		
		System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");	
		 driver = new FirefoxDriver();
		}
		else {
			System.out.println("browser is not supported");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("Selenium5");
		driver.findElement(By.name("button")).click();
		
		// get text 
		String actualOrgName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actualOrgName.contains("Selenium5"))
		{
			System.out.println("Oranization is created");
		}
		else 
		{
			System.out.println("Oranization is not created");
		}
		//Using mouse over for signout
		
		WebElement profileImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(profileImg).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
	
}
		
		
		
		

	


