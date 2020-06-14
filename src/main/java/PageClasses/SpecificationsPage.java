package PageClasses;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import BaseClasses.PageBaseClass;

public class SpecificationsPage extends PageBaseClass {

	@FindBy(xpath = "(//*[@class='gname'])[1]")
	public WebElement Category;

	@FindBy(xpath = "//*[@id='filters_primary_category_Bookshelves']")
	public WebElement Bookshelves;

		
		
	
	public PriceandStorageType ChooseCategory() {
	try{
		logger.log(Status.INFO, "Select bookshelves in categories");
		ExplicitWait(Category);
		Category.click();
		Bookshelves.click();
		logger.log(Status.PASS, "Category bookshelves selected successfully");
	}
	catch(Exception e){
		reportFail(e.getMessage());
	}
		return PageFactory.initElements(driver, PriceandStorageType.class);
	}
	
		
	public WriteBookshelvesData  writingshelveswithoutlogin(){
		return PageFactory.initElements(driver, WriteBookshelvesData.class);
	}
	
	public WriteChairsData  writingchairswithoutlogin(){
		return PageFactory.initElements(driver, WriteChairsData.class);
	}
	
	

}
