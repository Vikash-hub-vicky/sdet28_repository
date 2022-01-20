package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.sdet28.GenericUtility.BaseClass;

public class RetryClass {
 @Test(retryAnalyzer=com.crm.comcast.sdet28.GenericUtility.RetryImplementationClass.class)
 
 public void retry() {
	 Assert.assertEquals(true, false);
	 
 }
}
