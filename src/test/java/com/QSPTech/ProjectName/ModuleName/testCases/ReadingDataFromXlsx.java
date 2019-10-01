package com.QSPTech.ProjectName.ModuleName.testCases;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.AutomationWorldByRahul.SeleniumTraining.DataCollection;
import com.AutomationWorldByRahul.SeleniumTraining.ExcelReader;

public class ReadingDataFromXlsx {
	
	
	static ExcelReader excel  = new ExcelReader("E:\\Study Material\\Automation_World-Training\\Training Docs\\Master_Sheet.xlsx");
	
	@Test (dataProvider = "Data_Collections")
	public void testCase1(Hashtable <String, String> testData) {
		
		System.out.println("Getting data from xlsx using DataProvider:- " + testData.get("First_Name"));
		System.out.println("Getting data from xlsx using DataProvider:- " + testData.get("Last_Name"));
		System.out.println("Getting data from xlsx using DataProvider:- " + testData.get("Address"));
		System.out.println("Getting data from xlsx using DataProvider:- " + testData.get("Phone_Numer"));
		System.out.println("Getting data from xlsx using DataProvider:- " + testData.get("Email_ID"));
		
		
	}
	
	
	 @DataProvider 	
		public static Object[][] Data_Collections() {
			
			DataCollection dc = new DataCollection(excel, "Test_Data", "TC001_Create_an_Account2222");
			
			return dc.dataArray();
			// Hash Table		
		}	
	
	//@Test
	public void hashTable() {
		
		Hashtable<String, String > htdata = new Hashtable<String, String>(); // ArrayList, Set, HashTable
		
		//htdata.put(key, value)
		
		htdata.put("FirstName", "Rahul");
		htdata.put("FirstName1", "Dhanshree");
		htdata.put("FirstName2", "Rabiya");
		htdata.put("FirstName3", "Praveen");
		htdata.put("FirstName4", "Prashant");
		htdata.put("FirstName5", "Man-singh");
		htdata.put("FirstName6", "Nehesh");
		
	//	htdata.get(key)
		
		System.out.println(htdata.get("FirstName3"));
		System.out.println(htdata.get("FirstName2"));
		System.out.println(htdata.get("FirstName4"));
		System.out.println(htdata.get("FirstName1"));
		System.out.println(htdata.get("FirstName5"));
			
	
   }
}