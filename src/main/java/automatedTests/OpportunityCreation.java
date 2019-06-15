package automatedTests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import foundation.BaseClass;
import pageObjects.OpportunityPage;

public class OpportunityCreation extends BaseClass {

	@SuppressWarnings("unused")
	@Test
	public void opportunitypage() throws InterruptedException {

		OpportunityPage opportunitypage = new OpportunityPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		ArrayList<String> arrayData3 = getData(3);
		Iterator<String> rowIterator = arrayData3.iterator();
		String rowValue = rowIterator.next();
		System.out.println("rowvalue::::" + rowValue);
		// Opportunity Page
		// To Search for the Opportunity.
		opportunitypage.searchSalesforce().sendKeys(rowValue);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		opportunitypage.searchSalesforce().sendKeys(Keys.ENTER);
		driver.findElement(By.linkText(rowValue)).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// To Click on Edit Button
		opportunitypage.clickedit().click();
		// Input value
		opportunitypage.amount().sendKeys("100");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// To Click Save
		opportunitypage.save().click();
		// Mark Stage as Complete
		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// opportunitypage.markStage().click();
		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// Click Related Tab
		opportunitypage.relatedTab().click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// Add Products
		opportunitypage.addProducts().click();
		// Add Product to the Search Box
		// Click on the Search
		Thread.sleep(5000);

		ArrayList<String> arrayData4 = getData(5);
		Loop1: for (int i = 0; i < arrayData4.size(); i++) {
			String product = arrayData4.get(i);

			driver.findElement(By.xpath("//*[@title='Add Products']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@placeholder='Search Products...']")).sendKeys(arrayData4.get(i));
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@placeholder='Search Products...']")).sendKeys(Keys.ENTER);
			Thread.sleep(10000);
			List<WebElement> tableRows = driver.findElements(By.xpath("//table/tbody/tr"));
			Loop2: for (WebElement tableRowData : tableRows) {

				if (tableRowData.findElement(By.xpath("//a[@title='" + product + "']")).isDisplayed()) {

					tableRowData.findElement(By.xpath("//tbody//tr//th//a[@title='" + product + "']//preceding::td[1]"))
							.click();
					driver.findElement(By.xpath("//button[@title='Next']")).click();
					Thread.sleep(5000);
					Actions action = new Actions(driver);
					action.doubleClick(driver.findElement(By.xpath("//tbody//tr//td[3]//span/button"))).perform();
					action.doubleClick(driver.findElement(By.xpath("//tbody//tr//td[3]//span/button"))).sendKeys("1")
							.build().perform();
					driver.findElement(By.xpath("//button[@title='Save']")).click();
					Thread.sleep(5000);
					continue Loop1;
				} else {
					System.out.println("Not success");
				}

			}

		}

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		opportunitypage.markStage().click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

}
