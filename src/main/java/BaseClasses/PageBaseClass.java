package BaseClasses;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageClasses.LandingPage;
import Utilities.DateUtils;
import Utilities.ExtentReportManager;
import junit.framework.Assert;

public class PageBaseClass {
	public static WebDriver driver=null;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public static ExtentTest logger;

	public void invokeBrowser(String browsername) {
		try {
			if (browsername.equalsIgnoreCase("chrome")) {
			
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}
		}

		catch (Exception e) {
			reportFail(e.getMessage());
			System.out.println(e.getMessage());

		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

	}

	public LandingPage OpenApplication() {
		logger.log(Status.INFO, "Opening the Website");
		driver.get("https://www.urbanladder.com");
		logger.log(Status.PASS,"Successfully opened UrbanLadder");
		return PageFactory.initElements(driver, LandingPage.class);
	}

	public void getTitle(String expected) {
		try {
			Assert.assertEquals(driver.getTitle(), expected);
			reportPass("Expected:" + expected);
			reportPass("Actual:" + driver.getTitle());
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		takeScreenShotOnFailure();
		Assert.fail(reportString);

	}

	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}

	public void takeScreenShotOnFailure() {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(
				System.getProperty("user.dir") + "//ScreenShots//" + DateUtils.getTimeStamp() + ".png");
		try {
			FileUtils.copyFile(sourceFile, destinationFile);
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "//ScreenShots//" + DateUtils.getTimeStamp() + ".png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void SliderOptions(WebElement we,int x,int y){
	try{
		logger.log(Status.INFO, "Element to be hovered");
		Actions move = new Actions(driver);

	    move.dragAndDropBy(we,x, y).click();

	    move.build().perform();		
	reportPass("Element hovered");
	}
	catch(Exception e){
	reportFail(e.getMessage());
	}
	}
public void ExplicitWait(WebElement we){
	try{
	WebDriverWait wait  = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOf(we));
	logger.log(Status.PASS, "Wait Implemented Successfully");
	}
	catch(Exception e){
		reportFail(e.getMessage());
	}
	
}


public void veriyElementIsDisplayed(WebElement webElement){
	try {
		if(webElement.isDisplayed()){
			reportPass("Element is displayed");
		}else {
			reportFail("Element is not displayed");
		}
		
	} catch (Exception e) {
		reportFail(e.getMessage());
	}
	
	
	
}
public void verifyElementIsClickable(WebElement webelement){
	try{
		
	WebDriverWait wait  = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.elementToBeClickable(webelement));
	}
	catch(Exception e){
		reportFail(e.getMessage());
	}
}

public void MouseHover(WebElement e){
	Actions act = new Actions(driver);
	act.moveToElement(e).build().perform();
}

public String getTitle(){
	return driver.getTitle();
}

public void waitForPageLoad() {
	JavascriptExecutor js = (JavascriptExecutor) driver;

	int i = 0;
	while (i != 180) {
		String pageState = (String) js.executeScript("return document.readyState;");
		if (pageState.equals("complete")) {
			break;
		} else {
			waitLoad(1);
		}
	}

	waitLoad(2);

	i = 0;
	while (i != 180) {
		Boolean jsState = (Boolean) js.executeScript("return window.jQuery != undefined && jQuery.active == 0;");
		if (jsState) {
			break;
		} else {
			waitLoad(1);
		}
	}
}
public void waitLoad(int i) {
	try {
		Thread.sleep(i * 1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}



@AfterTest
public void FlushReport(){
	report.flush();
}

public void Teardown(){
	driver.close();
}
@AfterSuite
public void Quit(){
	driver.quit();
}

}
