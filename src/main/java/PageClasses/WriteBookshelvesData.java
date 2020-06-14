package PageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import BaseClasses.PageBaseClass;
import Utilities.ReadExcelDataFile;

public class WriteBookshelvesData extends PageBaseClass {


	
	public void GetListOfBookshelves(String sheetname){
try{
	logger.log(Status.INFO,"Write names price of item to excel sheet");
		List<WebElement> listofbookshelves = driver.findElements(By.xpath("//span[@class='name']"));
		List<WebElement> Description = driver.findElements(By.xpath("//*[@class='small']"));
		List<WebElement> Price = driver.findElements(By.xpath("//*[@class='price-number']"));
		List<WebElement> EmiPayment = driver.findElements(By.xpath("//*[@class='price-text']"));
		String[] NameofBookshelves = new String[5];
		String[] ItemDetails = new String[5];
		String[] ItemPrice = new String[5];
		String[] EmiInfo = new String[5];
for(int i=0;i<5;i++){
	NameofBookshelves[i]=listofbookshelves.get(i).getText();
ItemDetails[i] = Description.get(i).getText();
ItemPrice[i] = Price.get(i).getText();
EmiInfo[i] = EmiPayment.get(i).getText();
}
ReadExcelDataFile data = new ReadExcelDataFile(
		System.getProperty("user.dir") + "//ExcelSheets//UrbanLadder.xlsx");
if (data.isSheetExist(sheetname) == false) {
	data.addSheet(sheetname);
}
data.addColumn(sheetname, "Bookshelf name");
data.addColumn(sheetname, "Bookshelf price");
data.addColumn(sheetname, "Bookshelf Emi Starting");
data.addColumn(sheetname, "Bookshelf Description");
for (int i = 0; i < 5; i++) {
	data.setCellData(sheetname, "Bookshelf name", i + 2, NameofBookshelves[i]);
	data.setCellData(sheetname, "Bookshelf price", i + 2,ItemPrice[i]);
	data.setCellData(sheetname, "Bookshelf Emi Starting", i + 2,EmiInfo[i]);
	data.setCellData(sheetname, "Bookshelf Description", i + 2,ItemDetails[i]);
}
logger.log(Status.PASS, "Data Written to excelsheet successfully");
}
catch(Exception e){
	reportFail(e.getMessage());
}
		
	}
}
