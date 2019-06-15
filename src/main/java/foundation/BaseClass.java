package foundation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;
import org.apache.log4j.Logger;

public class BaseClass {

	public static WebDriver driver;
	public ArrayList<String> array;
	public File outputFile;
	public String scrFolder;
	//public Logger log = LogManager.getLogger(Login.class.getName());
	public static Logger log = Logger.getLogger("devpinoyLogger");

	@BeforeSuite
	public void createFolder() {
		String scrFolder = System.getProperty("user.dir")+"/Test screenshots/" + new SimpleDateFormat("yyyy_MM_dd_HHmmss").format(Calendar.getInstance().getTime()).toString();
		//String scrFolder = "C:/ProjectElevate/Maven/Automation/Test screenshots/" + new SimpleDateFormat("yyyy_MM_dd_HHmmss").format(Calendar.getInstance().getTime()).toString();
		new File(scrFolder).mkdir();
		System.setProperty("scr.folder", scrFolder);
		
	}
	
	public WebDriver initializeDriver() throws IOException {
		String configPath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties";
		Properties property = new Properties();
		FileInputStream fileInput = new FileInputStream(configPath);
		property.load(fileInput);

		String browserName = property.getProperty("Browser");

		if (browserName.equals("Chrome")) {
			// System.setProperty("webdriver.chrome.driver",
			// property.getProperty("ChromeDriverPath"));
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\executables\\chromedriver.exe");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");

			driver = new ChromeDriver(options);

		} else {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	// ******************** CAPTURING SCREENSHOT ********************

	public void getScreenShot(String TestName, int status) throws IOException {

//		scrFolder = System.getProperty("scr.folder");
//		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scrFile,new File(scrFolder + "/" +TestName+ status +".png"));
		
		
		if(status == ITestResult.SUCCESS) {
			scrFolder = System.getProperty("scr.folder");
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,new File(scrFolder + "/" +TestName+ "_pass"+".png"));
		}
		else if(status == ITestResult.FAILURE) {
		scrFolder = System.getProperty("scr.folder");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile,new File(scrFolder + "/" +TestName+ "_fail"+ ".png"));
		}
		
		
	}

	// ********* USER DEFINED METHOD TO VALIDATE ANY WEB ELEMENT PRESENCE **********

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// ******************** EXCEL DRIVEN ********************
	// ******************** READING FROM EXCEL ********************

	public static FileInputStream fileInput;
	public static File source;
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	public static FileOutputStream fileOutput;
	XSSFRow row;
	XSSFCell cell;

	public ArrayList<String> getData(int sheetIndex) {
		ArrayList<String> array = new ArrayList<String>();

		try {

			String path = "C:\\ProjectElevate\\TestData\\TestDataDrive.xlsx";
			//String path = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\TestDataDrive.xlsx";
			source = new File(path);
			fileInput = new FileInputStream(source);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			book = new XSSFWorkbook(fileInput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = book.getSheetAt(sheetIndex);

		Iterator<Row> allRows = sheet.iterator();
		Row headerRow = allRows.next();
		Row dataRow = allRows.next();
		Iterator<Cell> dataCellValues = dataRow.cellIterator();
		while (dataCellValues.hasNext()) {

			Cell dataCellValue = dataCellValues.next();
			if (dataCellValue.getCellTypeEnum() == CellType.STRING) {
				array.add(dataCellValue.getStringCellValue());
			} else {
				array.add(NumberToTextConverter.toText(dataCellValue.getNumericCellValue()));

			}

		}
		return array;
	}

	// ******************** WRITING TO EXCEL ********************

	public static void writeToExcel(String accountName, int sheetNo) throws IOException {
		try {

			//String path = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\TestDataDrive.xlsx";
			String path = "C:\\ProjectElevate\\TestData\\TestDataDrive.xlsx";
			source = new File(path);
			fileInput = new FileInputStream(source);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book = new XSSFWorkbook(fileInput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = book.getSheetAt(sheetNo);
		sheet.getRow(1).createCell(0).setCellValue(accountName);
		fileOutput = new FileOutputStream(source);
		book.write(fileOutput);

	}

	// @AfterSuite
	// public void tearDown() {
	// if(driver!=null) {
	// driver.quit();
	// }
}
