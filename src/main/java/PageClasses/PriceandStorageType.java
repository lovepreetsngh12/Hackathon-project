package PageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import BaseClasses.PageBaseClass;

public class PriceandStorageType extends PageBaseClass {
	
	@FindBy(xpath="//div[@class='noUi-handle noUi-handle-lower']")
	public WebElement minslide;
	
	@FindBy(xpath="//div[@class='noUi-handle noUi-handle-upper']")
	public WebElement maxslide;
	
	@FindBy(xpath = "(//*[@class='gname'])[2]")
	public WebElement Price;
	
	@FindBy(xpath = "(//*[@class='gname'])[3]")
	public WebElement Storage;

	@FindBy(xpath="//*[@id='filters_storage_type_Open']")
	public WebElement Storagetype;

	@FindBy(xpath="//*[@id='search-results']/div[2]/div[2]/div/ul/li[2]")
	public WebElement Open;


	public void ClickPriceTag(){
		try{
			logger.log(Status.INFO, "Click to put price mark upto 15000");
ExplicitWait(Price);
MouseHover(Price);
ExplicitWait(minslide);
logger.log(Status.PASS, "Price selected succesfully");
	}
		catch(Exception e){
			reportFail(e.getMessage());
		}}
	
	public void SelectPricemin(){
		try{
			logger.log(Status.INFO, "Select minimum price on slider");
		ExplicitWait(minslide);
		verifyElementIsClickable(minslide);
		SliderOptions(minslide,0,0);
		logger.log(Status.PASS,"Minimum Price selected succesfully");
		}catch(Exception e){
		reportFail(e.getMessage());
		}
		
	}

	public void SelectPricemax(){
		try{
			logger.log(Status.INFO, "Select maximum price on slider");

		ExplicitWait(maxslide);
		verifyElementIsClickable(maxslide);
		SliderOptions(maxslide,-206,0);
		logger.log(Status.PASS,"Maximum Price selected succesfully");
		}catch(Exception e){
		reportFail(e.getMessage());
		}
		
	}
	
	public WriteBookshelvesData StorageType(){
		try{
			logger.log(Status.INFO, "Set the storage type for item");
verifyElementIsClickable(Storage);
Storage.click();
Storagetype.click();
veriyElementIsDisplayed(Open);
logger.log(Status.PASS,"Storage set succesfully");
	
	}
		catch(Exception e){
			reportFail(e.getMessage());
			}
		return PageFactory.initElements(driver, WriteBookshelvesData.class);
	}
 public WriteChairsData chairs(){
	 return PageFactory.initElements(driver, WriteChairsData.class);
 }


}
