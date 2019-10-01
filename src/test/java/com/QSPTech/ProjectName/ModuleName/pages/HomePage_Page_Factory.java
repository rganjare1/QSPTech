package com.QSPTech.ProjectName.ModuleName.pages;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.QSPTech.ProjectName.ModuleName.testBase.TestBase;

public class HomePage_Page_Factory  {
	
	WebDriver driver; // Landing Or Home page driver -- local Driver

	public HomePage_Page_Factory(WebDriver driver) { // TestBase Driver -- Global Driver
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='login']")
	WebElement Xlogin;
	
	@FindBy(xpath = "//input[@id='email_create']")
	WebElement XSignIn;

	@FindBy(xpath = "//*[@id='SubmitCreate']")
	WebElement XCreateAcntBtn;

	
  public void createAnAccount(Hashtable <String, String> testData) throws IOException {
		
		//String Actual_title = driver.getTitle();
		
		//Assert.assertEquals(Actual_title, "My Store"); // Pass or Fail
		//test.log(LogStatus.PASS, "User has been redirected to the " + Actual_title + " Application.");
	//	passLogStatus("User has been redirected to the " + Actual_title + " Application.");
		
		Xlogin.click();
	//	passLogStatus("Sign In link has been clicked");
		
		//commonMethods.clickOnWebElement("Xlogin", "Login link"); // click on Sign In link 

		//boolean result = commonMethods.isDisplayed("XCreateAcntBtn", "Create An Account button");
		
		boolean result = XCreateAcntBtn.isDisplayed();
		
		Assert.assertEquals(result, true);
	  //  passLogStatus("Create An Account section has been displayed");
			
		//commonMethods.sendkeys("XSignIn", testData.get("Email_ID"), "Email ID");
		
	    XSignIn.sendKeys(testData.get("Email_ID"));
	  //  passLogStatus("Email Address has been enterted");
	    
		//commonMethods.clickOnWebElement("XCreateAcntBtn", "Create An Account Button");
	    
	    XCreateAcntBtn.click();
	 //   passLogStatus("Create An account button has been clicked");
	    
		Assert.assertEquals(driver.getTitle(), "Login - My Store");
		
	//	passLogStatus("User has been redirected to the Login - My Store page.");
		
	}
	
}
