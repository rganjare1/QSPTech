package com.QSPTech.ProjectName.ModuleName.interfaceTest;

public class InternetExplorerDriver implements WebDriver{

	public void get(String URL) {

		System.out.println("InternetExplorerDriver:- Navigationg to Application URL:-" + URL);

	}
	
	public void getTitle() {

		System.out.println("InternetExplorerDriver:-getting title of the Application page ");

	}

	public void click() {

		System.out.println("InternetExplorerDriver:-Clicking on the Webelement");

	}

	public void sendkeys(String testdata) {

		System.out.println("InternetExplorerDriver:-Entering testDat in to Input field" + testdata);

	}

	@Override
	public void TakeScreenshot(String path) {
		// TODO Auto-generated method stub
		
	}

	
}
