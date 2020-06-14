package TestClasses;

import org.testng.annotations.Test;

import BaseClasses.PageBaseClass;
import PageClasses.LandingPage;
import PageClasses.ObjectSelection;
import PageClasses.SpecificationsPage;
import PageClasses.WriteChairsData;

public class SearchForChairswithoutLogin extends PageBaseClass {
	LandingPage lp;
	ObjectSelection os;
	SpecificationsPage sp;
	WriteChairsData wcd;

	@Test
	public void Searcchairswithoutlogin() {
		logger = report.createTest("Search For Chairs without Login");
		PageBaseClass pbg = new PageBaseClass();
		pbg.invokeBrowser("chrome");
		lp = pbg.OpenApplication();
		os = lp.MovetonextPage();
		sp = os.SearchForItem("Study Chairs");
		wcd = sp.writingchairswithoutlogin();
		wcd.GetListOfChairs("Chairsinformationwithoutlogin");
		Teardown();

	}

}
