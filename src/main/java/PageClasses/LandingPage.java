package PageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import BaseClasses.PageBaseClass;

public class LandingPage extends PageBaseClass{

	@FindBy(linkText="Log-in")
	public WebElement login;
	
@FindBy(xpath="//div[@id='password-credentials']//input[@id='spree_user_email']")
public WebElement usernametxt;

@FindBy(xpath="//div[@id='password-credentials']/div/div/input[@id='spree_user_password']")
public WebElement passwordtxt;	

@FindBy(xpath="//*[@id=\"login_form\"]/input[3]")
public WebElement loginbtn;

@FindBy(xpath="//*[@id='topnav_wrapper']/ul")
public WebElement topbar;

@FindBy(xpath="//*[@class='flash ulmessage error  ']")
public WebElement error;

	public void SelectLogin(){
		try{
		
			logger.log(Status.INFO, "Click on Login Button");
			ExplicitWait(login);
		login.click();
		logger.log(Status.PASS, "Login Button Clicked Succesfully");
	}
		catch(Exception e){
			reportFail(e.getMessage());
		}}
	
	public void AddCredentials(String uname,String pass){
		try{
	logger.log(Status.INFO, "Enter email and password");
		usernametxt.sendKeys(uname);
		passwordtxt.sendKeys(pass);
	logger.log(Status.PASS,"Credentials entered succesfully");
		}
		catch(Exception e){
			reportFail(e.getMessage());
			}
		}
	
	public  ObjectSelection ClickLogin(){
		try{
			logger.log(Status.INFO, "Click on login after entering credentials");
		loginbtn.click();
		logger.log(Status.PASS, "Login Button clicked successfully");
		
		}
catch(Exception e ){
reportFail(e.getMessage());
}
		return PageFactory.initElements(driver,ObjectSelection.class);	
	}
	
public ObjectSelection MovetonextPage(){
	return PageFactory.initElements(driver,ObjectSelection.class);
}	
		
		
	


}


