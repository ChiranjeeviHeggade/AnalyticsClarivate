package roughNotes;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import foundation.BaseClass;
import pageObjects.LeadPage;
import resources.MonitoringMail;
import resources.TestConfig;

public class RoughClass extends BaseClass {

	static LeadPage leadPage = new LeadPage(driver);

	public static void main(String[] args) throws InterruptedException, IOException, AWTException {

		System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.get("https://inmarsat--Test.cs29.my.salesforce.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("chiranjeevi.heggademsp@inmarsat.com.test");
		driver.findElement(By.id("password")).sendKeys("Salesman@2019");
		driver.findElement(By.id("Login")).click();

		Thread.sleep(20000);

		driver.findElement(By.xpath("//input[@title='Search Salesforce']")).sendKeys("Regression_18.50-");
		driver.findElement(By.xpath("//input[@title='Search Salesforce']")).sendKeys(Keys.ENTER);
		Thread.sleep(20000);

		driver.findElement(By.linkText("Regression_18.50-")).click();
		Thread.sleep(5000);

		// Opportunity Page
		// To Click on Edit Button
		driver.findElement(By.xpath("//button[@title='Edit Amount']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(text(),'Amount')]/../following-sibling::input[1]")).sendKeys("123");
		driver.findElement(By.xpath("//button//span[text()='Mark Stage as Complete']")).click();
		driver.findElement(By.xpath("//span[text()='Related']")).click();
		driver.findElement(By.xpath("//*[@title='Add Products']")).click();
		driver.findElement(By.xpath("//*[@title='Search Products']")).sendKeys("METADRUG");
		driver.findElement(By.xpath("//*[@title='Search Products']")).sendKeys(Keys.ENTER);
		
		
		// String messageBody = "CLICK ON THE LINK TO SEE THE EXTENT REPORT - "+
		// "http://"+InetAddress.getLocalHost().getHostAddress()+":8080/job/LeadCreation/ExtentReports";
		// System.out.println(messageBody);
		// *[@id="3884:0"]/div[1]/div[3]/button

	}

}
