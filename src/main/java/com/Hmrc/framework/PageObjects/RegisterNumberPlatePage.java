package com.Hmrc.framework.PageObjects;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Hmrc.framework.TestBase.TestBase;
import com.Hmrc.framework.excelHelper.ExcelReader;

public class RegisterNumberPlatePage extends TestBase {
	
        
         
	
	WebDriver driver;
	
	
	@FindBy(xpath = "//button[@class ='button']")
	 @CacheLookup
	WebElement ContinueButton;
	
	@FindBy(xpath = "//input[@id='Vrm']")
	 @CacheLookup
	WebElement vehicleNumber;
	
	
	
	@FindBy(xpath = "//div/h1[@class='heading-medium error-summary-heading']")
	 @CacheLookup
	WebElement ErrorMessage;
	
	
	
	public RegisterNumberPlatePage(WebDriver driver) {

		
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	
	public void EnterVehicleNumberClear(){
		
		  vehicleNumber.clear();
	}
		  public void EnterVehicleNumber(String veNum){
				
			 
		  vehicleNumber.sendKeys(veNum);
		  
		 
		
			
		
	}
	public void ContinueButton(){
		
		ContinueButton.click();
		  
		 
		
			
		
	}
	


	}
