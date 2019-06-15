package roughNotes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionSend {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\java\\executables\\chromedriver.exe");
		        WebDriver driver = new ChromeDriver();
		        Actions action = new Actions(driver);
		        driver.get("https://facebook.com");
		        action.click(driver.findElement(By.id("email"))).sendKeys("chirukul_999@yahoo.com"+Keys.TAB)
		        .sendKeys("Killing123"+Keys.TAB)		
		        .sendKeys(Keys.ENTER)
		        .build().perform();
		        

	}

}
