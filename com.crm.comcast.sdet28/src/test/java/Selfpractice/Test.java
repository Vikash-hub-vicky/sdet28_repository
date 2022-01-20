package Selfpractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws Throwable {
		 FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
			Properties p = new Properties();
			p.load(fis);
			String browser = p.getProperty("browser");
			String url = p.getProperty("url");
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			
			FileInputStream fis1= new FileInputStream("./src/test/resources/VtigerTestData.xlsx");
			Workbook workbook = WorkbookFactory.create(fis1);
			Sheet sheet = workbook.getSheet("Sheet1");
			Row row = sheet.getRow(6);
			Cell cell = row.getCell(2);
			String subject = cell.getStringCellValue();
			Row row1 = sheet.getRow(7);
			Cell cell1 = row.getCell(2);
			String VendorName= cell.getStringCellValue();
			Row row2 = sheet.getRow(8);
			Cell cell2 = row.getCell(2);
			String ItemName= cell.getStringCellValue();
			Row row3 = sheet.getRow(9);
			Cell cell3 = row.getCell(2);
			String BillingAddress= cell.getStringCellValue();
			Row row4 = sheet.getRow(10);
			Cell cell4 = row.getCell(2);
			String ShippingAddress= cell.getStringCellValue();
			Row row5 = sheet.getRow(11);
			Cell cell5 = row.getCell(2);
			String Qty= cell.getStringCellValue();
			
			
			WebDriver driver=null;
			if(browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
				driver = new ChromeDriver();
			}
			else {
				System.out.println("browser is not supported");
				}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(url);
			driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("javascript:;")).click();                                      //move
			driver.findElement(By.id("Purchase Order")).click();              
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			driver.findElement(By.name("subject")).sendKeys(subject);
			driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
			
			driver.switchTo().frame(0);//popup
			//driver.findElement(By.).
			driver.findElement(By.name("bill_street")).sendKeys(BillingAddress);
			driver.findElement(By.name("ship_street")).sendKeys(ShippingAddress);
			driver.findElement(By.name("button")).click();
			
			 
			 

	}

}
