package com.Hmrc.framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Hmrc.framework.TestBase.TestBase;

public class VehicleDetailsPage extends TestBase{
	
	WebDriver driver;
	
	public VehicleDetailsPage(WebDriver driver){
		
		this.driver= driver;
		
		PageFactory.initElements(driver, this);
		
		
		
		
	}
	
	

}
