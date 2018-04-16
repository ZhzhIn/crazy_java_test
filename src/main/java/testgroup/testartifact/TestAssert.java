package testgroup.testartifact;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestAssert {
	@BeforeSuite
	public void tesetbd(){
		System.out.println("beforesuite");
	}
	@BeforeClass
	public void testBefore(){
		System.out.println("beforeclass");
	}
	@AfterClass
	public void testAfterClass(){
		System.out.println("afterClass");
	}
	@BeforeMethod
	public void testbefor(){
		System.out.println("before method assert");
	}
	@Test
	public void testAssert(){
		 Assert.assertTrue(false); 
	}
}
