package com.QSPTech.ProjectName.ModuleName.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import com.AutomationWorldByRahul.SeleniumTraining.DataCollection;
import com.AutomationWorldByRahul.SeleniumTraining.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	//public static ExcelReader excel  = new ExcelReader("E:\\Study Material\\Automation_World-Training\\workspace\\QSPTech_Batch\\src\\test\\resources\\testData\\Master_Sheet.xlsx");
	public static ExcelReader excel  = new ExcelReader(System.getProperty("user.dir") +"\\src\\test\\resources\\testData\\Master_Sheet.xlsx");
	public static String testCaseName, skip=null;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static Hashtable <String, String> testCaseRunMode = new Hashtable<String, String>();
	
	@BeforeSuite // One time Declaration .. Access across framework
	public static void LoadingFiles() throws IOException {
		
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir")+"\\src\\test\\resources\\propertiesFiles\\Config.properties");
		config.load(fis);
		System.out.println("************ Config file has been loaded ************");

		FileInputStream fis1 = new FileInputStream(
				System.getProperty("user.dir")+"\\src\\test\\resources\\propertiesFiles\\OR.properties");
		OR.load(fis1);
		System.out.println("************ OR file has been loaded ************");
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		extent = new ExtentReports(System.getProperty("user.dir")+ "\\src\\test\\resources\\execution_Report\\" +"ExecutionReport_"+timeStamp+".html");
		
		loadHashTable(testCaseRunMode, "Test_Cases", "TestCaseName", "Run_Mode");
	 }	
	
	//@BeforeMethod
	public static void launchingBrowser() {
		
		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Automation_Testing\\WorkSpace\\QSPTech-feature_dhanu\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();	// created the object of ChromeDriver and assigned to Webdriver interface	
		} else if (config.getProperty("Browser").equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Automation_Testing\\WorkSpace\\QSPTech-feature_dhanu\\src\\test\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (config.getProperty("Browser").equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Automation_Testing\\WorkSpace\\QSPTech-feature_dhanu\\src\\test\\resources\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
		test = extent.startTest(testCaseName);
		
		driver.get(config.getProperty("ApplicationURL")); // dynamic
		
		//test.log(LogStatus.INFO, config.getProperty("ApplicationURL"));	
		test.log(LogStatus.INFO, "Browser has been launched and user redirected to Application URL :-" + config.getProperty("ApplicationURL"));
	}
	
//	@AfterMethod
	public void closeBrowser(){
				
		driver.quit();
		test.log(LogStatus.INFO, "Excution has been completed for Test case:-" + testCaseName);	
	}
	
	@AfterSuite(alwaysRun = true)
	public static void writeIntoExtentReport() throws InterruptedException {		
		extent.endTest(test);
		extent.flush();		
	}
		
	public static void takeScreenShot() throws IOException {
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "\\src\\test\\resources\\screenShots\\screnshot_"+timeStamp+ ".png";
			
			File destFile = new File(reportDirectory);

			FileHandler.copy(scrFile, destFile);
			
			test.log(LogStatus.PASS, test.addScreenCapture(reportDirectory));
			
		//	Reporter.log("<a href='" + destFile + "'> <img src='" + destFile
			//		+ "' height='100' width='100'/> </a>");
	
	}
	
     public static void loadHashTable(Hashtable<String, String> testCaseRunMode, String SheetName, String KeyCol, String valueCol){
		
		int row = excel.getRowCount(SheetName);
		
		for(int i= 2; i<=row; i++) {
			
			String key = excel.getCellData(SheetName, KeyCol, i);
			
			String val = excel.getCellData(SheetName, valueCol, i);
			
			testCaseRunMode.put(key, val);		
		}
		
		System.out.println(testCaseRunMode);	
	}
	
	
	 public static boolean isExecutable(String TC_name) {
		 testCaseName = TC_name;
			if(testCaseRunMode.get(testCaseName).equalsIgnoreCase("Y")) {
				skip="No" ;
				return true;	
				} else {
		    	 skip="Yes" ;
			   return false;
		    }	
	} 
	 
	 public static void passLogStatus(String message) throws IOException {
		
		 test.log(LogStatus.PASS, message);
		 takeScreenShot();	 
	}
	
	 @DataProvider 	
	public static Object[][] Data_Collections() {
			
			DataCollection dc = new DataCollection(excel, "Test_Data", testCaseName);
			
			return dc.dataArray();
			// Hash Table		
		}	
	
	
}
