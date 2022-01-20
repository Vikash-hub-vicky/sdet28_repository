package Selfpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.comcast.sdet28.GenericUtility.IPathConstants;

public class DropDown {

	public static void main(String[] args) {
		WebDriver driver = null;
		System.getProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.opencart.com/");
		
		WebElement ele = driver.findElement(By.id("input-country"));
		
	Select select = new Select(ele);
	
	select.selectByVisibleText("Hong_kong");

	}

}
