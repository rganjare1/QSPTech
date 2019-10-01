package com.QSPTech.ProjectName.ModuleName.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertTest {

	@Test
	public static void testAssertClass() {

		// Assert.assertEquals(actual, expected);

		// Assert.assertEquals("Rahul", "Rahul1");

		// Assert.assertEquals(true, false);

		try {
			//Assert.fail("Expected text not found on webpage");
			Assert.assertEquals("Rahul", "Rahul");
			System.out.println("I am in try block");
		} 
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		
		finally {
			System.out.println("I am in Finally block and can be executed every time");
		}

		// Assert.assertTrue(condition, message);

	}

}
