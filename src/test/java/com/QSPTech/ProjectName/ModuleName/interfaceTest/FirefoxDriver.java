package com.QSPTech.ProjectName.ModuleName.interfaceTest;

public class FirefoxDriver implements WebDriver{

	public void get(String URL) {

		System.out.println("FirefoxDriver:- Navigationg to Application URL:-" + URL);

	}
	
	public void getTitle() {

		System.out.println("FirefoxDriver:-getting title of the Application page ");

	}

	public void click() {

		System.out.println("FirefoxDriver:-Clicking on the Webelement");

	}

	public void sendkeys(String testdata) {

		System.out.println("FirefoxDriver:-Entering testDat in to Input field" + testdata);

	}

	@Override
	public void TakeScreenshot(String path) {
		// TODO Auto-generated method stub
		
	}
	
}
