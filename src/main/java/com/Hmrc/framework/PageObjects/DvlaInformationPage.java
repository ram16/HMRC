package com.Hmrc.framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Hmrc.framework.TestBase.TestBase;

public class DvlaInformationPage extends TestBase {

	WebDriver driver;

	@FindBy(xpath = "//a[@class='button']")
	WebElement StartButton;

	public DvlaInformationPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void ClickStartButton() {

		StartButton.click();
	}

}