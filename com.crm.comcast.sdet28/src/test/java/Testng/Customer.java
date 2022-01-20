package Testng;

import org.testng.annotations.Test;

public class Customer {
	@Test(groups = {"smokeTest"})
	public void customerTest1() {
		System.out.println("This is smoke");
	}
@Test(groups = {"regressonTest"})
public void cutomerTest2() {
	System.out.println("This is reggression");
}
@Test(groups = {"smokeTest"})
public void customerTest3() {
	System.out.println("This is smoke");
}
@Test(groups = {"regressonTest"})
public void cutomerTest4() {
System.out.println("This is reggression");
}
}
