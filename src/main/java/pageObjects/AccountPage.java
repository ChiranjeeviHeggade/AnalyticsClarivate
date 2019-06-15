package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	public WebDriver driver;
	public String rowValue;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * ACCOUNT XPATH LIST
	 */

	By SearchSalesforce = By.xpath("//input[@title='Search Salesforce']");
	By EditButton = By.xpath("//div[@title='Edit']");
	By Prospect = By.xpath("//span[contains(text(),'Account Status')]/following::a[contains(text(),'Prospect')]");
	By Mastered = By.xpath("//ul[@class='scrollable']//li[3]/a[@title='Mastered']");
	By DunsNumber = By.xpath("//span[contains(text(),'D-U-N-S Number')]/../following-sibling::input[1]");
	By TaxVatNumber = By.xpath("//span[contains(text(),'Tax/VAT Number')]/../following-sibling::input[1]");
	By DBRatingDate = By.xpath("//span[contains(text(),'D&B Rating Date')]/../following-sibling::input[1]");
	By DBRating = By.xpath("//span[contains(text(),'D&B Rating')]/../following-sibling::input[1]");
	By AnnualRDBudget = By.xpath("//span[contains(text(),'Annual R&D Budget')]/../following-sibling::input[1]");
	By AnnualRevenue = By.xpath("//span[contains(text(),'Annual Revenue')]/../following-sibling::input[1]");
	By NAICSCode = By.xpath("//span[contains(text(),'NAICS Code')]/../following-sibling::input[1]");
	By FedGovBudget = By.xpath("//span[contains(text(),'Fed Gov Budget')]/../following-sibling::input[1]");
	By NAICSDescription = By.xpath("//span[contains(text(),'NAICS Description')]/../following-sibling::input[1]");
	By TickerSymbol = By.xpath("//span[contains(text(),'Ticker Symbol')]/../following-sibling::input[1]");
	By SICCode = By.xpath("//span[contains(text(),'SIC Code')]/../following-sibling::input[1]");
	By Employees = By.xpath("//span[contains(text(),'Employees')]/../following-sibling::input[1]");
	By SICDescription = By.xpath("//span[contains(text(),'SIC Description')]/../following-sibling::input[1]");
	By RelatedParty = By.xpath("//span[contains(text(),'Related Party')]/../following-sibling::input[1]");
	By GSTID = By.xpath("//span[contains(text(),'GST ID')]/../following-sibling::input[1]");
	By PANNumber = By.xpath("//span[contains(text(),'PAN Number')]/../following-sibling::input[1]");

	/*
	 * CREDIT INFORMATION XPATH LIST
	 */

	By CreditStatusClick = By.xpath("//span[* = 'Credit Status']//following::a[1]");
	By CreditStatusApproved = By.xpath("//span[* = 'Credit Status']/following::a[contains(text(),'Approved')]");
	By Portfolio = By.xpath("//span[* = 'Portfolio']//following::a[1]");
	By Asiapac = By.xpath("//span[* = 'Portfolio']/following::a[contains(text(),'ASIAPAC')]");
	
	
	By Account = By.xpath("//span[contains(text(),'GST Liable')]/following::a[contains(text(),'None')]");
    By AccountType = By.xpath("//span[contains(text(),'GST Liable')]/following::a[contains(text(),'Standard')]");
    By Vertical = By.xpath("//span[contains(text(),'E-commerce Operator')]/following::a[contains(text(),'None')]");
    By SubVertical = By.xpath("//span[contains(text(),'E-commerce Operator')]/following::a[contains(text(),'Academic')]");
    By CustomerLegalEntity = By.xpath("//span[contains(text(),'Customer Legal Entity')]/../following-sibling::input[1]");
    By ParentValue = By.xpath("//span[contains(text(),'GST Liable')]/following::a[contains(text(),'Validation Pending')]");
    By UltimateParentValue = By.xpath("//span[contains(text(),'GST Liable')]/following::a[contains(text(),'Yes')]");
    By Save = By.xpath("//button[@title='Save']");
    
    By MasteredValue = By.xpath("//ul[@role='list']//li[3]/div/div");
    //By MasteredValue = By.cssSelector("ul[role='list'] > li:nth-child(3) > div > div");
    

	
	public WebElement searchSalesforce() {
		return driver.findElement(SearchSalesforce);
	}

	public WebElement clickEdit() {
		return driver.findElement(EditButton);
	}

	/*
	 * CONVERTING AN ACCOUNT STATUS FROM 'PROSPECT' TO 'MASTERED'
	 */

	public WebElement prospect() {
		return driver.findElement(Prospect);
	}

	public WebElement mastered() {
		return driver.findElement(Mastered);
	}

	/*
	 * ENTERING DATA TO ALL THE BELOW MANDATORY FIELDS MANAGED BY 'MASTER DATA'
	 * D-U-N-S Number, 
	 * Tax/VAT Number, 
	 * D&B Rating, 
	 * Annual R&D Budget, 
	 * Annual Revenue,
	 * NAICS Code, 
	 * Fed Gov Budget, 
	 * NAICS Description, 
	 * Ticker Symbol, 
	 * SIC Code, 
	 * Employees,
	 * SIC Description, 
	 * Related Party, 
	 * GST ID,
	 * PAN Number
	 */

	public WebElement dunsNumber() {
		return driver.findElement(DunsNumber);
	}

	public WebElement taxVatNumber() {
		return driver.findElement(TaxVatNumber);
	}

	public WebElement dbrating() {
		return driver.findElement(DBRating);
	}

	public WebElement annualRDBudget() {
		return driver.findElement(AnnualRDBudget);
	}

	public WebElement annualRevenue() {
		return driver.findElement(AnnualRevenue);
	}

	public WebElement naicsCode() {
		return driver.findElement(NAICSCode);
	}

	public WebElement fedGovBudget() {
		return driver.findElement(FedGovBudget);
	}

	public WebElement naicsDescription() {
		return driver.findElement(NAICSDescription);
	}

	public WebElement tickerSymbol() {
		return driver.findElement(TickerSymbol);
	}

	public WebElement sicCode() {
		return driver.findElement(SICCode);
	}

	public WebElement employees() {
		return driver.findElement(Employees);
	}

	public WebElement sicDescription() {
		return driver.findElement(SICDescription);
	}

	public WebElement relatedParty() {
		return driver.findElement(RelatedParty);
	}

	public WebElement gstID() {
		return driver.findElement(GSTID);
	}

	public WebElement panNumber() {
		return driver.findElement(PANNumber);
	}

	/*
	 * ENTERING DATA TO ALL BELOW MANDATORY 'CREDIT INFORMTION' FIELDS
	 */

	public WebElement creditStatusClick() {
		return driver.findElement(CreditStatusClick);
	}

	public WebElement creditStatusApproved() {
		return driver.findElement(CreditStatusApproved);
	}

	public WebElement portfolioClick() {
		return driver.findElement(Portfolio);
	}

	public WebElement portfolioValue() {
		return driver.findElement(Asiapac);
	}
	
	/*
	 * ENTERING DATA TO ALL THE MANDATORY FIELDS
	 */
	
	public WebElement account() {
        return driver.findElement(Account);
    }
    
    public WebElement accountType() {
        return driver.findElement(AccountType);
    }
    
    public WebElement vertical() {
        return driver.findElement(Vertical);
    }
    
    public WebElement subVertical() {
        return driver.findElement(SubVertical);
    }
    
    public WebElement customerLegalEntity() {
        return driver.findElement(CustomerLegalEntity);
    }

    public WebElement parentValue() {
        return driver.findElement(ParentValue);
    }
    
    public WebElement ultimateParentValue() {
        return driver.findElement(UltimateParentValue);
    }
    
    public WebElement save() {
    	return driver.findElement(Save);
    }
    
    public WebElement masteredValue() {
    	return driver.findElement(MasteredValue);
    }
	
	

}
