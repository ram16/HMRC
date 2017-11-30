package com.Hmrc.framework.VechilesRegistration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Hmrc.framework.PageObjects.ConfirmVechilePage;
import com.Hmrc.framework.PageObjects.DvlaInformationPage;
import com.Hmrc.framework.PageObjects.RegisterNumberPlatePage;
import com.Hmrc.framework.PageObjects.VehicleDetailsPage;
import com.Hmrc.framework.TestBase.TestBase;
import com.Hmrc.framework.beans.VehcileDescrition;
import com.Hmrc.framework.beans.VehcileDetails;
import com.Hmrc.framework.excelHelper.ExcelReader;


public class VechileRegistrationTest extends TestBase {

	DvlaInformationPage dvlaInformationPage;
	RegisterNumberPlatePage registerNumberPlatePage;
	ConfirmVechilePage confirmVechilePage;
	VehicleDetailsPage vehicleDetailsPage;
	VehcileDescrition vechileDescrition;
	ExcelReader excelReader;
	VehcileDetails ExcelData;
	Logger log = Logger.getLogger(VechileRegistrationTest.class);
	
	
	
	
	
	@BeforeMethod
	public void setUp() throws IOException {
		log.info("****************************** Starting test cases execution  *****************************************");
		init();
	}

	@Test
	public void Test2() throws IOException {
       // Reading the Registration Number and maching to Data and Page

		dvlaInformationPage = new DvlaInformationPage(driver);
		registerNumberPlatePage = new RegisterNumberPlatePage(driver);
		confirmVechilePage = new ConfirmVechilePage(driver);
		log.info("****************************** Click on StartButton *****************************************");
        dvlaInformationPage.ClickStartButton();
		String path = "C:\\Users\\RAMU\\git\\HMRC-DVLA\\src\\main\\java\\com\\Hmrc\\framework\\TestData\\Test.xlsx";
		ExcelReader excelReader = new ExcelReader(path);
		log.info("****************************** Reading Excelsheet *****************************************");
		ArrayList<String> VeNum = excelReader.getVehecileNumber(0);
		for (int i = 0; i < VeNum.size(); i++) {
		registerNumberPlatePage.EnterVehicleNumber(VeNum.get(i));
		registerNumberPlatePage.ContinueButton();
		log.info("****************************** Taking Screenshot *****************************************");
        getScreenShot("VechileDetails");
             
		}
	}

		@AfterMethod
		public void tearDown(){
			driver.quit();
			log.info("****************************** Browser is closed *****************************************");
}
		
}