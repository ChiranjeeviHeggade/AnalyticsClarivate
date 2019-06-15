package automatedTests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import foundation.BaseClass;
import pageObjects.LoginPage;

public class Login extends BaseClass {

	@Test
	public void login() throws IOException {

		driver = initializeDriver();
		log.info("WebDriver is initialized");
		ArrayList<String> arrayData1 = getData(0); // EXCEL SHEET#
		driver.get(arrayData1.get(1));
		log.info("Salesforce 'Home Page' is displayed");
		LoginPage loginPage = new LoginPage(driver);

		loginPage.username().sendKeys(arrayData1.get(2));
		loginPage.password().sendKeys(arrayData1.get(3));
		loginPage.login().click();
		log.info("User successfully logged in...");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		Assert.assertEquals("Sandbox: qa", loginPage.envTitle().getText());
		log.info("User logged into a valid environment");
	}

}
