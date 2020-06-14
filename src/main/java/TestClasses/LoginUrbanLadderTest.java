package TestClasses;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClasses.PageBaseClass;
import PageClasses.LandingPage;
import PageClasses.ObjectSelection;
import Utilities.TestDataProvider;

public class LoginUrbanLadderTest extends PageBaseClass {
	LandingPage lp;
	ObjectSelection os;

	@Test(dataProvider = "getData")
	public void LoginToUrbanLadder(Hashtable<String, String> data) {
		PageBaseClass pagebase = new PageBaseClass();
		logger = report.createTest("Simple Login Check with " + data.get("Comments"));
		pagebase.invokeBrowser("Chrome");
		lp = pagebase.OpenApplication();
		lp.SelectLogin();
		lp.AddCredentials(data.get("Email"), data.get("Password"));
		os = lp.ClickLogin();
		os.Logincheck(
				"Furniture Online: Buy Home Wooden Furniture Online In India At Best Price - Urban Ladder - Urban Ladder");
		Teardown();
	}

	@DataProvider
	public Object[][] getData() {
		return TestDataProvider.getTestData("UrbanLadder.xlsx", "Credentials", "TestCases");
	}

}
