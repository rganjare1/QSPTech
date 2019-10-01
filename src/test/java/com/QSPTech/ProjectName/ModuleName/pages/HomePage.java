package com.QSPTech.ProjectName.ModuleName.pages;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.Assert;

import com.QSPTech.ProjectName.ModuleName.commonMethods.commonMethods;
import com.QSPTech.ProjectName.ModuleName.testBase.TestBase;

public class HomePage extends TestBase { // POM - page object model

	public static void createAnAccount(Hashtable <String, String> testData) throws IOException {
		
		String Actual_title = driver.getTitle();
		
		Assert.assertEquals(Actual_title, "My Store"); // Pass or Fail
		//test.log(LogStatus.PASS, "User has been redirected to the " + Actual_title + " Application.");
		passLogStatus("User has been redirected to the " + Actual_title + " Application.");
		
		commonMethods.clickOnWebElement("Xlogin", "Login link"); // click on Sign In link 

		boolean result = commonMethods.isDisplayed("XCreateAcntBtn", "Create An Account button");
		Assert.assertEquals(result, true);
	    passLogStatus("Create An Account section has been displayed");
			
		commonMethods.sendkeys("XSignIn", testData.get("Email_ID"), "Email ID");
		
		commonMethods.clickOnWebElement("XCreateAcntBtn", "Create An Account Button");
		
		Assert.assertEquals(driver.getTitle(), "Login - My Store");
		
		passLogStatus("User has been redirected to the Login - My Store page.");
		
	}
	

	public static void loginWithRegisteredCredentials() {

	}

	public static void contactCustomerCare() {

	}

}
