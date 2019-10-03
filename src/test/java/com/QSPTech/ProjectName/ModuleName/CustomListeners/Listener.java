package com.QSPTech.ProjectName.ModuleName.CustomListeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.QSPTech.ProjectName.ModuleName.testBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

/**
 * 
 * @author Rahul Ganjare
 *
 */
public class Listener extends TestBase implements ITestListener {

	public void onFinish(ITestContext arg0) {
		Reporter.log("Test is finished:" + arg0.getName());
		test.log(LogStatus.INFO, "Execution has been completed");

	}

	public void onStart(ITestContext arg0) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult arg0) {
		if (skip == "No")
		launchingBrowser();
	}

	public void onTestFailure(ITestResult result) {
		if (!result.isSuccess()) {
			String formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
			String methodName = result.getName();
			test.log(LogStatus.FAIL, "Test Case fail due to:- " + result.getThrowable());
			Reporter.log("Test case fail due to:- " + result.getThrowable());

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
						+ "\\src\\test\\resources\\screenShots\\Failed\\" + methodName + "_" + formater + ".png";
				File destFile = new File(reportDirectory);

				FileHandler.copy(scrFile, destFile);
				test.log(LogStatus.FAIL, test.addScreenCapture(reportDirectory));

			} catch (IOException e) {
				e.printStackTrace();
			}

			test.log(LogStatus.FAIL, "*** Script execution for " + testCaseName + " is Failed. *** ");
			Reporter.log("*** Script execution for " + testCaseName + " is Failed. *** ");
		}
		closeBrowser();
	}

	public void onTestSuccess(ITestResult result) {
		if (result.isSuccess()) {
			test.log(LogStatus.PASS, "*** Script execution for " + testCaseName + " is completed. *** ");
			Reporter.log("*** Script execution for " + testCaseName + " is completed. *** ");
			closeBrowser();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

		System.out.println(testCaseName + " Test case is skipped by listener as Run mode set to N");
		Reporter.log(testCaseName + " Test case is skipped by listener as Run mode set to N");
		
	   if (skip == "No") {
		Reporter.log("Test case is skipped by listener due to:-:" + result.getMethod().getMethodName());
		test.log(LogStatus.WARNING, "Test case Skipped by listener due to:- " + result.getThrowable());
		closeBrowser();
	  }
	   
	}
}
