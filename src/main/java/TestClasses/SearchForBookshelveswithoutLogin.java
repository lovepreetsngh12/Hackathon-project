package TestClasses;

import org.testng.annotations.Test;

import BaseClasses.PageBaseClass;
import PageClasses.LandingPage;
import PageClasses.ObjectSelection;
import PageClasses.PriceandStorageType;
import PageClasses.SpecificationsPage;
import PageClasses.WriteBookshelvesData;

public class SearchForBookshelveswithoutLogin extends PageBaseClass {
	LandingPage lp;
	ObjectSelection os;
	WriteBookshelvesData wcd;
	SpecificationsPage sp;
	PriceandStorageType pst;

	@Test
	public void Searchwithoutlogin() {
		logger = report.createTest("Search For Bookshelves without Login");
		PageBaseClass pbg = new PageBaseClass();
		pbg.invokeBrowser("chrome");
		lp = pbg.OpenApplication();
		os = lp.MovetonextPage();
		sp = os.SearchForItem("Bookshelf");
		pst = sp.ChooseCategory();
		pst.ClickPriceTag();
		pst.SelectPricemin();
		pst.SelectPricemax();
		wcd = pst.StorageType();
		wcd.GetListOfBookshelves("bookshelfwithoutlogin");
		Teardown();
	}

}
