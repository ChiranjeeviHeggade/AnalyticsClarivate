package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import foundation.BaseClass;

public class OpportunityPage extends BaseClass{
	public WebDriver driver;
	public String rowValue;

	public OpportunityPage(WebDriver driver) {
		this.driver = driver;
	}

		// Opportunity Page
		//To Search
		By SearchSalesforce = By.xpath("//input[@title='Search Salesforce']");
		
		// To Click on Edit Button
		By ClickEdit = By.xpath("//button[@title='Edit Amount']");
		// Input value
		By Amount = By.xpath("//span[contains(text(),'Amount')]/../following-sibling::input[1]");
		//Mark Stage as Complete
		By MarkStage = By.xpath("//button//span[text()='Mark Stage as Complete']");
		//To Click Save
		By Save = By.xpath("//button[@title='Save']");
		//Click Related Tab
		By RelatedTab = By.xpath("//span[text()='Related']");
		//Add Products
		By AddProducts = By.xpath("//*[@title='Add Products']");
		//Add Product to the Search Box
		By SearchProduct = By.xpath("//input[@placeholder='Search Products...']");
		//Click on the SEarch 
		By SearchEnter = By.xpath("");

		
		public WebElement searchSalesforce() {
			return driver.findElement(SearchSalesforce);
		}
		
		public WebElement clickedit() {
			return driver.findElement(ClickEdit);
		}
		
		public WebElement amount() {
			return driver.findElement(Amount);
		}
		
		public WebElement markStage() {
			return driver.findElement(MarkStage);
		}
		
		public WebElement relatedTab() {
			return driver.findElement(RelatedTab);
		}
		
		public WebElement addProducts() {
			return driver.findElement(AddProducts);
		}
		
		public WebElement searchProduct() {
			return driver.findElement(SearchProduct);
		}
		
		public WebElement searchEnter() {
			return driver.findElement(SearchEnter);
		}
		
		public WebElement save() {
			return driver.findElement(Save);
		}

}
