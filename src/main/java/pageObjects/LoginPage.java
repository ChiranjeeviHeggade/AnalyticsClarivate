package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import foundation.BaseClass;

public class LoginPage extends BaseClass{
	
	public WebDriver driver;

	By Username = By.id("username");
	By Password = By.id("password");
	By Login = By.id("Login");
	By LeadTitle = By.xpath("//*[@id='oneHeader']/div[1]/div/span");
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement username() {
		return driver.findElement(Username);
	}

	public WebElement password() {
		return driver.findElement(Password);
	}

	public WebElement login() {
		return driver.findElement(Login);
	}
	
	public WebElement envTitle() {
		return driver.findElement(LeadTitle);
	}

}
