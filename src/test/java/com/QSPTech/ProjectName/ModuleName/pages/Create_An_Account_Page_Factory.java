package com.QSPTech.ProjectName.ModuleName.pages;

import java.io.IOException;
import java.util.Hashtable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QSPTech.ProjectName.ModuleName.testBase.TestBase;

public class Create_An_Account_Page_Factory extends TestBase{
		
		WebDriver driver; // Landing Or Home page driver -- local Driver

		public Create_An_Account_Page_Factory(WebDriver driver) { // TestBase Driver -- Global Driver
			this.driver = driver;
			// This initElements method will create all WebElements
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath = "//*[@id='id_gender1']")
		WebElement title;
		
		@FindBy(xpath = "//*[@id='customer_firstname']")
		WebElement FirstName;
		
		@FindBy(xpath = "//*[@id='customer_lastname']")
		WebElement Last_Name;

		@FindBy(xpath = "//*[@id='passwd']")
		WebElement Password;
		
		@FindBy(xpath = "//*[@id='passwd']")
		WebElement dropDown;

	public void enterPersonalInformation(Hashtable<String, String> testData) throws IOException {

		//commonMethods.clickOnWebElement("Xtitle", "Title");
		
		title.click();
		passLogStatus("Title has been selected");
		
		//commonMethods.sendkeys("XFirstName", testData.get("First_Name"), "First Name");
		
		FirstName.sendKeys(testData.get("First_Name"));
	    passLogStatus("First_Name has been enterted");

		//commonMethods.sendkeys("Xlastname", testData.get("Last_Name"), "Last Name");

	    Last_Name.sendKeys(testData.get("Last_Name"));
	    passLogStatus("Last_Name has been enterted");
	    
	//	commonMethods.sendkeys("xpwd", testData.get("Password"), "Password");

	    Password.sendKeys(testData.get("Password"));
	    passLogStatus("Password has been enterted");
	    
	 //   commonMethods.selectDropDownByValue(dropDown, "QSPTech");
	    
	}
}
