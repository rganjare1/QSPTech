package com.QSPTech.ProjectName.ModuleName.pages;

import java.io.IOException;
import java.util.Hashtable;

import com.QSPTech.ProjectName.ModuleName.commonMethods.commonMethods;

public class Create_An_Account {

	public static void enterPersonalInformation(Hashtable<String, String> testData) throws IOException {

		commonMethods.clickOnWebElement("Xtitle", "Title");

		commonMethods.sendkeys("XFirstName", testData.get("First_Name"), "First Name");

		commonMethods.sendkeys("Xlastname", testData.get("Last_Name"), "Last Name");

		commonMethods.sendkeys("xpwd", testData.get("Password"), "Password");

	}
}
