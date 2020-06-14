package PageClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import BaseClasses.PageBaseClass;

public class ObjectSelection extends PageBaseClass{
	
	
	@FindBy(id="search")
	public WebElement Searchbox;
	
	
	@FindBy(xpath="//*[@id='search-results']/div[1]/h2")
public WebElement searchresult;
	
	public void Logincheck(String title){
		waitForPageLoad();
		String tt=getTitle();
		if(tt.equalsIgnoreCase(title)){
			logger.log(Status.PASS, "Page Login successfull");
		}
		else{
			reportFail("Username or email is incorrect");
		}
	
	}
	
	
	public SpecificationsPage SearchForItem(String sitem){
		try{
			logger.log(Status.INFO, "Search for "+sitem+" on urban ladder site");
			ExplicitWait(Searchbox);
		Searchbox.sendKeys(sitem);
		Searchbox.sendKeys(Keys.ENTER);
		ExplicitWait(searchresult);
		logger.log(Status.PASS,"Search successfull");
		}
		catch(Exception e){
			reportFail(e.getMessage());
		}
return PageFactory.initElements(driver,SpecificationsPage.class);
	}
}
