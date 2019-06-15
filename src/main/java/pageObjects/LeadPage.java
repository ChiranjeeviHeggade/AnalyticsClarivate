package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import foundation.BaseClass;

public class LeadPage extends BaseClass{
	
	public WebDriver driver;
	
	public LeadPage(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * LEAD CREATION XPATH LIST
	 */
	
	By LeadTitle = By.xpath("//*[@id='oneHeader']/div[1]/div/span");
	By Leads = By.linkText("Leads");
	By NewLead = By.xpath("//div[@title='New']");
	By LeadWindow = By.xpath("//*[contains(text(),'New Lead: Lead Record Type')]");
	

	By FirstName = By.xpath("//input[@placeholder='First Name']");
	By LastName = By.xpath("//input[@placeholder='Last Name']");
	By Company = By.xpath("//span[contains(text(),'Company')]/following::input[1]");
	By Department = By.xpath("//span[contains(text(),'Department')]/following::input[1]");
	By Title = By.xpath("//span[contains(text(),'Title')]/following::input[1]");
	By Email = By.xpath("//input[@type='email']");
	By OfficePhone = By.xpath("//span[contains(text(),'Office Phone')]/following::input[1]");
	By Mobile = By.xpath("//span[contains(text(),'Mobile')]/following::input[1]");
	By Street = By.xpath("//textarea[@placeholder='Street']");
	By City = By.xpath("//input[@placeholder='City']");
	By PostalCode = By.xpath("//input[@placeholder='Zip/Postal Code']");

	By Select = By.xpath("//ul[@class='scrollable']//li[2]");

	By JobRole = By.xpath("//span[contains(text(),'Job Role')]/following::a[1]");
	By BusinessUnit = By.xpath("//span[contains(text(),'Business Unit')]/following::a[1]");
	By BusinessUnitText = By.xpath("//span[contains(text(),'Business Unit')]/following::a[contains(text(),'Life Sciences')]");
	By LeadSource = By.xpath("//span[contains(text(),'Lead Source')]/following::a[1]");
	By LeadSourceText = By.xpath("//span[contains(text(),'Lead Source')]/following::a[contains(text(),'Customer Care')]");
	By Save = By.xpath("//button[@title='Save']");
	By State = By.xpath("//span[contains(text(),'State/Province')]/following::a[1]");
	By StateList = By.xpath("//span[contains(text(),'State/Province')]/following::a[contains(text(),'Pennsylvania')]");
	By Country = By.xpath("//span[contains(text(),'Country')]/following::a[1]");
	By CountryList = By.xpath("//span[contains(text(),'Country')]/following::a[contains(text(),'United States')]");
	
	/*
	 * LEAD CONVERSION XPATH LIST
	 */

	By Convert = By.xpath("//div[@title='Convert']");
	By ConvertBtn = By.cssSelector("[class^='modal-footer'] > button:last-child");
	
	/*
	 * LEAD CREATION METHODS
	 */

	public WebElement envTitle() {
		return driver.findElement(LeadTitle);
	}
	
	public WebElement leads() {
		return driver.findElement(Leads);
	}

	public WebElement newLeadButton() {
		return driver.findElement(NewLead);
	}

	public WebElement newLeadWindow() {
		return driver.findElement(LeadWindow);
	}

	public WebElement firstName() {
		return driver.findElement(FirstName);
	}

	public WebElement lastName() {
		return driver.findElement(LastName);
	}

	public List<WebElement> company() {
		return driver.findElements(Company);
	}

	public List<WebElement> department() {
		return driver.findElements(Department);
	}

	public List<WebElement> title() {
		return driver.findElements(Title);
	}

	public WebElement email() {
		return driver.findElement(Email);
	}

	public List<WebElement> officePhone() {
		return driver.findElements(OfficePhone);
	}
	
	public WebElement mobilePhone() {
		return driver.findElement(Mobile);
	}

	public WebElement street() {
		return driver.findElement(Street);
	}

	public WebElement city() {
		return driver.findElement(City);
	}

	public WebElement postalCode() {
		return driver.findElement(PostalCode);
	}

	public WebElement jobRole() {
		return driver.findElement(JobRole);
	}

	public List<WebElement> businessUnit() {
		return driver.findElements(BusinessUnit);
	}

	public WebElement businessUnitText() {
		return driver.findElement(BusinessUnitText);
	}

	public List<WebElement> leadSource() {
		return driver.findElements(LeadSource);
	}

	public WebElement leadSourceText() {
		return driver.findElement(LeadSourceText);
	}

	public WebElement select() {
		return driver.findElement(Select);
	}
	
	public WebElement save() {
		return driver.findElement(Save);
	}
	
	public WebElement state() {
		return driver.findElement(State);
	}
	
	public WebElement stateListing() {
		return driver.findElement(StateList);
	}
	
	public List<WebElement> country() {
		return driver.findElements(Country);
	}
	
	public WebElement countryList() {
		return driver.findElement(CountryList);
	}
	
	/*
	 * LEAD CONVERSION METHODS
	 */
	
	public WebElement convertLeadBtn() {
		return driver.findElement(Convert);
	}
	
	public WebElement dclickConvertBtn() {
		return driver.findElement(ConvertBtn);
	}
	
	

}
