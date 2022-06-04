package testPacke;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class importance {
@BeforeClass
public void beforeClass() {
	System.out.println("beforeClass TestClass");
}
@BeforeMethod
public void beforeMethod() {
	System.out.println("beforeMethod TestClass");
}
@Test(priority=2)
public void testB() {
	System.out.println("test B TestClass1");
}
@Test(priority=1)
public void testA() {
	System.out.println("test A TestClass1");
}
@Test(priority=3)
	public void testC() {
		System.out.println("test C TestClass1");
}
	@Test(priority=4)
	public void testD() {
		System.out.println("test D TestClass1");
}
}
 