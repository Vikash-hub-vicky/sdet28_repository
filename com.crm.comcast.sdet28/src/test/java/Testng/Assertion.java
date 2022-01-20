package Testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion {
	//@Test
	public void math() {
		int a=20;
		int b=30;
		int sum=a+b;
		Assert.assertEquals(sum, 60,"Addition is not correct");
	}
       @Test
       public void StringComparison() {
    	   String fisrtName="Vikash",  secondName= "Singh" ;
    	   
    	   Assert.assertEquals(fisrtName, "Singh","Name is not correct");//3rd string will be only print if the expected is wrong 
    	   
	
       }
}
