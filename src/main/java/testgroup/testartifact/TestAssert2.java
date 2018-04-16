package testgroup.testartifact;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestAssert2 {
	@BeforeSuite
	public void tesetbd(){
		System.out.println("beforesuite2");
	}
	@BeforeClass
	public void testBefore(){
		System.out.println("before class2");
	}
	@AfterClass
	public void testAfterClass(){
		System.out.println("afterClass2");
	}
	@BeforeMethod
	public void testbefor(){
		System.out.println("before method assert2");
	}
	@Test
	public void testAssert(){
		 Assert.assertTrue(false); 
	}
}