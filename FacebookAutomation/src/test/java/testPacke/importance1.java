package testPacke;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class importance1 {
	 
			@BeforeClass
			public void beforeClass() {
				System.out.println("beforeClass TestClass");
			}
			@BeforeMethod
			public void beforeMethod() {
				System.out.println("beforeMethod TestClass");
			}
			@Test(priority=2)
			public void testE() {
				System.out.println("test E TestClass1");
			}
			@Test(priority=1)
			public void testF() {
			System.out.println("test F TestClass1");
			}
			
			@Test(priority=3)
				public void testG() {
				System.out.println("test G TestClass1");
			}
			}
			 

