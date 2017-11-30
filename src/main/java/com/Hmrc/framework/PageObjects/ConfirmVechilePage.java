package com.Hmrc.framework.PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Hmrc.framework.TestBase.TestBase;
import com.Hmrc.framework.beans.VehcileDetails;

public class ConfirmVechilePage extends TestBase {

	// Page Factory & Page object Design Pattern

	WebDriver driver;

	@FindBy(className = "//div/h1[@class='heading-medium error-summary-heading']")

	WebElement ErrorMessage;

	@FindBy(id = "//input[@id='Correct_True']")
	WebElement YesRadioButton;

	@FindBy(id = ".//input[@id='Correct_False']")
	WebElement NoRadioButton;

	@FindBy(className = "//button[@class = 'button']")

	WebElement ContinueButton;

	@FindBy(css = "#pr3 .list-summary-item")
	WebElement Color;

	private String confirmDetails;

	public ConfirmVechilePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void ClickOnYes() {

		YesRadioButton.isEnabled();
		ContinueButton.click();
	}

	public RegisterNumberPlatePage ClickOnNo() {

		NoRadioButton.click();
		ContinueButton.click();
		return new RegisterNumberPlatePage(driver);

	}

	public VehcileDetails getColor() {

		VehcileDetails vehicle = new VehcileDetails();
		waitForVisibility(Color);
		List<WebElement> elements = driver.findElements(By.className("#pr3 .list-summary-item"));
		for (int i = 0; i < elements.size(); i++) {
			List<WebElement> span = elements.get(i).findElements(By.tagName("Span"));
			if (span.get(0).getText().equalsIgnoreCase("Colour")) {
				vehicle.setColor(span.get(1).getText());
			} else if (span.get(0).getText().equalsIgnoreCase("Make")) {
				vehicle.setColor(span.get(1).getText());
			}
		}

		return vehicle;
	}

}
