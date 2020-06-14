package TestClasses;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClasses.PageBaseClass;
import PageClasses.LandingPage;
import PageClasses.ObjectSelection;
import PageClasses.PriceandStorageType;
import PageClasses.SpecificationsPage;
import PageClasses.WriteChairsData;
import Utilities.TestDataProvider;

public class SearchForChairswithLogin extends PageBaseClass {

	
	LandingPage lp;
	ObjectSelection os;
	SpecificationsPage sp;
	PriceandStorageType pst;
	WriteChairsData wd;

	@Test(dataProvider = "getCredentials")
	public void Text(Hashtable<String, String> data) {
		PageBaseClass pagebase = new PageBaseClass();
		logger = report.createTest("Login and Search for chairs with " + data.get("Comments"));
		pagebase.invokeBrowser("Chrome");
		lp = pagebase.OpenApplication();
		lp.SelectLogin();
		lp.AddCredentials(data.get("Email"), data.get("Password"));
		os=lp.ClickLogin();
		os.Logincheck("Furniture Online: Buy Home Wooden Furniture Online In India At Best Price - Urban Ladder - Urban Ladder");
		sp = os.SearchForItem("Study Chairs");
	wd=sp.writingchairswithoutlogin();
		wd.GetListOfChairs("chairswithlogin");
		Teardown();
		
	}

	@DataProvider
	public Object[][] getCredentials() {
		return TestDataProvider.getTestData("UrbanLadder.xlsx", "Credentials", "TestCases");
	}

}
