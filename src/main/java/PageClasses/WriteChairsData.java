package PageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import BaseClasses.PageBaseClass;
import Utilities.ReadExcelDataFile;

public class WriteChairsData extends PageBaseClass {
	public void GetListOfChairs(String sheetname){
		try{
			logger.log(Status.INFO,"Write names price of item to excel sheet");
				List<WebElement> listofchairs = driver.findElements(By.xpath("//span[@class='name']"));
				List<WebElement> Color = driver.findElements(By.xpath("//*[@class='small']"));
				List<WebElement> Price = driver.findElements(By.xpath("//*[@class='price-number']"));
				List<WebElement> EmiPayment = driver.findElements(By.xpath("//*[@class='price-text']"));
				String[] NameofChairs = new String[3];
				String[] ItemDetails = new String[3];
				String[] ItemPrice = new String[3];
				String[] EmiInfo = new String[3];
		for(int i=0;i<3;i++){
			NameofChairs[i]=listofchairs.get(i).getText();
		ItemDetails[i] = Color.get(i).getText();
		ItemPrice[i] = Price.get(i).getText();
		EmiInfo[i] = EmiPayment.get(i).getText();
		}
		ReadExcelDataFile data = new ReadExcelDataFile(
				System.getProperty("user.dir") + "//ExcelSheets//UrbanLadder.xlsx");
		if (data.isSheetExist(sheetname) == false) {
			data.addSheet(sheetname);
		}
		data.addColumn(sheetname, "Chair name");
		data.addColumn(sheetname, "Chair price");
		data.addColumn(sheetname, "Chair Emi Starting");
		data.addColumn(sheetname, "Chair color");
		for (int i = 0; i < 3; i++) {
			data.setCellData(sheetname, "Chair name", i + 2, NameofChairs[i]);
			data.setCellData(sheetname, "Chair price", i + 2,ItemPrice[i]);
			data.setCellData(sheetname, "Chair Emi Starting", i + 2,EmiInfo[i]);
			data.setCellData(sheetname, "Chair color", i + 2,ItemDetails[i]);
		}
		logger.log(Status.PASS, "Data Written to excelsheet successfully");
		}
		catch(Exception e){
			reportFail(e.getMessage());
		}
				
			}

}
