package com.QSPTech.ProjectName.ModuleName.interfaceTest;

public class ChromeDriver implements WebDriver{

	public void get(String URL) {

		System.out.println("ChromeDriver:- Navigationg to Application URL for Chrome Driver:-" + URL);

	}
	
	public void getTitle() {

		System.out.println("ChromeDriver:-getting title of the Application page ");

	}

	public void click() {

		System.out.println("ChromeDriver:-Clicking on the Webelement");

	}

	public void sendkeys(String testdata) {

		System.out.println("ChromeDriver:-Entering testDat in to Input field" + testdata); // optional

	}

	public void TakeScreenshot(String path) {
		// TODO Auto-generated method stub
		
	}

}
