package practice;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionTest {
	
	@Test
	
	public void sample() {
		String expectedName ="VikashSingh";
		String actualName= "Vikash";
		
		Reporter.log("this is soft assertion", false);
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(expectedName, actualName);
		
		sa.assertAll();
		
	}

}
