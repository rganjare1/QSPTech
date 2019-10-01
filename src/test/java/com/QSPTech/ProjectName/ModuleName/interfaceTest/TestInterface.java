package com.QSPTech.ProjectName.ModuleName.interfaceTest;

public class TestInterface {

	public static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver = new InternetExplorerDriver();

		driver = new ChromeDriver();
		// ChromeDriver driver = new ChromeDriver();
		// FirefoxDriver driver1 = new FirefoxDriver();
		// InternetExplorerDriver driver2 = new InternetExplorerDriver();

		driver.get("www.gmail.com");
		driver.getTitle();
		driver.sendkeys("Rahul");
		driver.click();
		driver.TakeScreenshot("path of the screen shot");

	}

}