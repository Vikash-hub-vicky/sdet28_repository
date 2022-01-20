package Selfpractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertiesTest {

	public static void main(String[] args) throws Throwable {
		 FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
		 
		 Properties p = new Properties();
		 p.load(fis);
		 String browser = p.getProperty("browser");
		 String url = p.getProperty("url");
		 String username = p.getProperty("username");
		 String password = p.getProperty("password");
		 
		 System.out.println(browser);
		 System.out.println(url);
		 System.out.println(username);
		 System.out.println(password);
		 
         WebDriver driver= new ChromeDriver();
         driver.get(url);		 
		 driver.findElement(By.name("user_name")).sendKeys(username);
		 driver.findElement(By.name("user_password")).sendKeys(password);
		 driver.findElement(By.id("submitButton")).click();
	 
	 
		
		 
		 
		 
	}

}
