package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateOrganizationsTest {
	@Test
	
		
		@BeforeClass
		public void bc() {
			System.out.println("launch the browser");
			
		}
	@AfterClass
		public void ac() {
			System.out.println("quit the browser");
	}
@BeforeMethod
public void bm() {
	System.out.println("login to browser");
}
    @AfterMethod
    public void am() {
    	System.out.println("logout the browser");
    }


	@Test(priority =1)
	public void org() {
		System.err.println("navigate the organization");
		System.err.println("create orgn");
		System.err.println("verify orgn");
	}
	@Test(priority =2)
	public void contact() {
		System.err.println("navigate the contact");
		System.err.println("create contact");
		System.err.println("verify contact");
	}

@Test(priority =2)
public void product() {
	System.err.println("navigate the product");
	System.err.println("create product");
	System.err.println("verify product");
}
}
	
	
	
	
	