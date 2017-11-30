package com.Hmrc.framework.TestBase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Hmrc.framework.VechilesRegistration.VechileRegistrationTest;

@SuppressWarnings({ "unused", "unused", "unused" })
public class TestBase {

	public static WebDriver driver;
	WebDriverWait wait;
	String Url = "https://www.gov.uk/get-vehicle-information-from-dvla";
	String browser = "chrome";
	Logger log = Logger.getLogger(VechileRegistrationTest.class);

	public void init() {

		selectBrowser(browser);		getUrl(Url);
	}

	public void selectBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			log.info("launching chrome broswer");
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");

			driver = new FirefoxDriver();
			log.info("launching firefox broswer");

		}
	}

	public void getUrl(String Url) {

		driver.get(Url);

		driver.manage().window().maximize();
		log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");

	}

	public WebElement waitForClickability(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}

	public void waitForVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void sendKeys(WebElement element, String str) {
		waitForVisibility(element);
		element.clear();
		element.sendKeys(str);
	}

	public void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}

	public void getScreenShot(String fileName) throws IOException {
		File outputFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(outputFile, new File(System.getProperty("user.dir")
				+ "//src//main//java//com//Hmrc//framework//ScreenShots//" + fileName + ".jpg"));
	}

	public void teardown() {
		driver.quit();
	}

}
