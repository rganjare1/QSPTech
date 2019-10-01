package com.QSPTech.ProjectName.ModuleName.commonMethods;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.QSPTech.ProjectName.ModuleName.testBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class commonMethods extends TestBase {

	public static void clickOnWebElement(String Xpath, String webelement) throws IOException {
		
		WebElement element = driver.findElement(By.xpath(OR.getProperty(Xpath)));
		element.click();
		test.log(LogStatus.PASS, webelement + " has been clicked");
		Reporter.log(webelement + " has been clicked");
		takeScreenShot();

	}

	public static void sendkeys(String Xpath, String data, String webelement) throws IOException {
		driver.findElement(By.xpath(OR.getProperty(Xpath))).sendKeys(data);
		test.log(LogStatus.PASS, webelement + " has been Entered");
		Reporter.log(webelement + " has been Entered");
		takeScreenShot();
	}

	public static boolean isDisplayed(String Xpath, String webelement) {
		try {
			driver.findElement(By.xpath(OR.getProperty(Xpath))).isDisplayed();
			return true;

		} catch (Exception e) {

			return false;
		}

	}

	/*
	 * public static void selectDropDownByValue(String xpath, String value) {
	 * 
	 * Select sel = new Select(driver.findElement(By.xpath(OR.getProperty(xpath))));
	 * sel.selectByValue(value); test.log(LogStatus.PASS, webelement +
	 * " has been Entered"); takeScreenShot(); Reporter.log(webelement +
	 * " has been Entered");
	 * 
	 * }
	 * 
	 * public static void selectDropDownByIndex(String xpath, int index) {
	 * 
	 * Select sel = new Select(driver.findElement(By.xpath(OR.getProperty(xpath))));
	 * sel.selectByIndex(index); test.log(LogStatus.PASS, webelement +
	 * " has been Entered"); takeScreenShot(); Reporter.log(webelement +
	 * " has been Entered");
	 * 
	 * }
	 * 
	 * public static void selectDropDownByVisibleText(String xpath, String text) {
	 * 
	 * Select sel = new Select(driver.findElement(By.xpath(OR.getProperty(xpath))));
	 * sel.selectByVisibleText(text); test.log(LogStatus.PASS, webelement +
	 * " has been Entered"); takeScreenShot(); Reporter.log(webelement +
	 * " has been Entered");
	 * 
	 * }
	 */
	
	public static void selectDropDownByValue(WebElement element, String value) throws IOException {
		 
		 Select sel = new Select(element);
		 sel.selectByValue(value); 
		 test.log(LogStatus.PASS, value +" has been Entered"); 
		 takeScreenShot();
		 Reporter.log(value + " has been Entered");
		 
		  }

}
