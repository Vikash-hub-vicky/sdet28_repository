package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionTest {//HARD ASSERTION
 @Test
 public void demo() {
	 System.out.println("launch the browser");
	 System.out.println("login to application");
	 System.out.println("create orgainzation");
	 
	 int a=10;
	 int b =30;
	 Assert.assertEquals(a, b);
	 
	 int[] arr= {1,2,3,4,4};
	 int[] arr1= {1,2,3,4};
	 
	 Assert.assertEquals(arr, arr1);
	 Assert.assertEquals(false, true);
	 
	 String expectedName ="VikashSingh"; String actualName= "Vikash";
	 
	 Assert.assertEquals(expectedName, actualName);//assertion failed
	 
	 
	 System.out.println("logout from application");
	 System.out.println("quit the browser");
	 System.out.println("quit the browser11");
	 
	 
	 
	 
	 
 }
}
