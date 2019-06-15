package automatedTests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import foundation.BaseClass;
import pageObjects.AccountPage;

public class AccountCreation extends BaseClass {

	@Test
	public void accountCreation() {

		AccountPage accountPage = new AccountPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		ArrayList<String> arrayData3 = getData(2);
		ArrayList<String> arrayData5 = getData(4);
		Iterator<String> rowIterator = arrayData3.iterator();
		String rowValue = rowIterator.next();

		accountPage.searchSalesforce().sendKeys(rowValue);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		accountPage.searchSalesforce().sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.linkText(rowValue)).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		accountPage.clickEdit().click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		accountPage.prospect().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		accountPage.mastered().click();

		accountPage.account().click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		accountPage.accountType().click();

		accountPage.vertical().click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		accountPage.subVertical().click();

		accountPage.parentValue().click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		accountPage.ultimateParentValue().click();

		accountPage.customerLegalEntity().sendKeys(arrayData5.get(14));

		accountPage.dunsNumber().sendKeys(arrayData5.get(0));
		accountPage.taxVatNumber().sendKeys(arrayData5.get(1));
		accountPage.dbrating().sendKeys(arrayData5.get(2));
		accountPage.annualRDBudget().sendKeys(arrayData5.get(3));
		accountPage.annualRevenue().sendKeys(arrayData5.get(4));
		accountPage.naicsCode().sendKeys(arrayData5.get(5));
		accountPage.fedGovBudget().sendKeys(arrayData5.get(6));
		accountPage.naicsDescription().sendKeys(arrayData5.get(7));
		accountPage.tickerSymbol().sendKeys(arrayData5.get(8));
		accountPage.sicCode().sendKeys(arrayData5.get(9));
		accountPage.employees().sendKeys(arrayData5.get(10));
		accountPage.sicDescription().sendKeys(arrayData5.get(11));
		accountPage.relatedParty().click();
		accountPage.gstID().sendKeys(arrayData5.get(12));
		accountPage.panNumber().sendKeys(arrayData5.get(13));

		accountPage.creditStatusClick().click();
		accountPage.creditStatusApproved().click();
		accountPage.portfolioClick().click();
		accountPage.portfolioValue().click();
		
		accountPage.save().click();
		
		wait.until(ExpectedConditions.textToBePresentInElement(accountPage.masteredValue(), "Mastered"));
		
		String value = accountPage.masteredValue().getText();
		
		if(value.matches("Mastered")) {
			log.debug("Master Account is created succesfully");
		}else {
			System.out.println("Master Account failed to create");
		}
		
	}
	
	@AfterTest
	 public void tearDown() {
	 driver.close();
	 }
}
