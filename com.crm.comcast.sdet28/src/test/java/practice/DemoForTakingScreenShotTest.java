package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.sdet28.GenericUtility.BaseClass;

@Listeners(com.crm.comcast.sdet28.GenericUtility.ListenerImpClass.class)
public class DemoForTakingScreenShotTest extends BaseClass {
	@Test
	public void sample() {
		String expectedName ="Vikash";
		String actualName="Singh";
		
		Assert.assertEquals(expectedName, actualName);
				
	}
}
