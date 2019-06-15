package automatedTests;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import foundation.BaseClass;
import pageObjects.LeadPage;

public class LeadCreationAndConversion extends BaseClass {
	LeadPage leadPage;
	Random random = new Random();
	String dateTimeStamp;

	@BeforeTest
	public void getDateAndTime() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		dateTimeStamp = dateFormat.format(date);
	}

	@Test
	public void createLeadConvertLead() throws IOException, InterruptedException {

		leadPage = new LeadPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		leadPage.leads().click();
		Thread.sleep(6000);
		leadPage.newLeadButton().click();

		Thread.sleep(10000);
		boolean newLeadWindow = leadPage.newLeadWindow().isDisplayed();

		if (newLeadWindow) {
			System.out.println("New Lead Window is succesfully displayed");
			ArrayList<String> arrayData2 = getData(1);

			long randomTenDigitNumber = (long) (Math.random() * 100000 + 9990000000L);
			String newRandomTenDigitNumber = Long.toString(randomTenDigitNumber);
			leadPage.firstName().sendKeys(arrayData2.get(0));

			String lastName = arrayData2.get(1);
			leadPage.lastName().sendKeys(lastName + dateTimeStamp);

			/* APPENDING RANDOM DIGITS TO COMPANY NAME TO AVOID DUPLICATE */
			String companyName = arrayData2.get(2);
			String newCompanyName = companyName + dateTimeStamp;
			String opportunityName = newCompanyName +"-";
			// System.out.println("New Company Name:"+newCompanyName);
			
			writeToExcel(newCompanyName, 2);
			writeToExcel(opportunityName,3);
			
			leadPage.company().get(1).sendKeys(newCompanyName);

			leadPage.department().get(1).sendKeys(arrayData2.get(3));
			leadPage.title().get(1).sendKeys(arrayData2.get(4));

			leadPage.email().sendKeys(arrayData2.get(5));

			/* ENTERING 10 RANDOM DIGITS TO OFFICE PHONE */
			// String officePhone = arrayData2.get(6);
			leadPage.officePhone().get(1).sendKeys(newRandomTenDigitNumber);

			/* ENTERING 10 RANDOM DIGITS TO MOBILE PHONE */;
			leadPage.mobilePhone().sendKeys(newRandomTenDigitNumber);

			leadPage.street().sendKeys(arrayData2.get(8));
			leadPage.city().sendKeys(arrayData2.get(9));
			leadPage.postalCode().sendKeys(arrayData2.get(10));

			leadPage.jobRole().click();
			leadPage.select().click();

			leadPage.businessUnit().get(1).click();
			leadPage.businessUnitText().click();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			leadPage.country().get(1).click();
			leadPage.countryList().click();

			leadPage.state().click();
			leadPage.stateListing().click();

			leadPage.leadSource().get(0).click();
			leadPage.leadSourceText().click();

			leadPage.save().click();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Fetching Account name from Lead page during runtime
			// String accountName = driver.findElement(By.cssSelector("div >
			// span[title='Company'] + div")).getText();

		} else {
			System.out.println("New Lead Window is not displayed");
		}

		/* LEAD CONVERSION BEGINS NOW */

		leadPage.convertLeadBtn().click();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//span[contains(text(),'Account Name')]/following::input[1]")).sendKeys(Keys.TAB);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		for (int i = 0; i < 3; i++) {
			if (isElementPresent(By.cssSelector("[class^='modal-footer'] > button:last-child"))) {
				leadPage.dclickConvertBtn().click();
			}
		}

		//Boolean GoToLeads = driver.findElement(By.xpath("//button[contains(.,'Go to Leads')]")).isDisplayed();

		
	   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Go to Leads')]")));
		

	}

	 @AfterTest
	 public void tearDown() {
	 driver.close();
	 }

}
