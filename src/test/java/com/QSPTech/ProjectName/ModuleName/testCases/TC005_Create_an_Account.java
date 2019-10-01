package com.QSPTech.ProjectName.ModuleName.testCases;

import java.io.IOException;
import java.util.Hashtable;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.QSPTech.ProjectName.ModuleName.pages.Create_An_Account;
import com.QSPTech.ProjectName.ModuleName.pages.HomePage;
import com.QSPTech.ProjectName.ModuleName.testBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class TC005_Create_an_Account extends TestBase {
	
	//@BeforeTest
	@BeforeClass
	public static void isSkip() {
		
		if(!isExecutable("TC005_Create_an_Account"))	// true 
			
			throw new SkipException("Skipping Test case as it's Run Mode is set to N");			
	}
	
	@Test (dataProvider = "Data_Collections")
	public void TC005_Create_An_Account(Hashtable <String, String> testData) throws IOException, InterruptedException  {
		
	//	test = extent.startTest("TC004_Create_an_Account");
	//   launchingBrowser();
		
        HomePage.createAnAccount(testData);
		
		Create_An_Account.enterPersonalInformation(testData);
		
		//closeBrowser();
	}
	
}
