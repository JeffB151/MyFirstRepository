package page.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utilities.ExplicitWait;

public class StockManager_StockTakeReport {
	
	static WebDriver driver;
	static WebElement element;
	static Select select;
	static boolean savedStock;
	static int rows;
	static Random random = new Random();
	static int ranCount;
	static Actions action;
	static String expectedCount;
	static String qty = "100";
	
	
	
	public static void select_LMP_Station (WebDriver driver, int LMPIndex) throws Exception {
		Thread.sleep(1000);
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//select[@ng-model='catererStationId']"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//select[@ng-model='catererStationId']"), 3);
		select = new Select(element);
		Thread.sleep(200);
		select.selectByIndex(LMPIndex);	
		ExplicitWait.waitForElement_Invisible(driver, By.xpath("//p[@class='loading-more alert alert-info text-center']"), 3);
	}
	
	public static void Check_For_Saved_StockTakes(WebDriver driver) {
		ExplicitWait.waitForElement_Clickable(driver, By.xpath("//tr[1]/td[6]//i[@class='fa fa-file']"), 3);
		savedStock = driver.findElements(By.xpath("//button[@class='btn btn-danger btn-xs']")).size() != 0;
		
		if(savedStock == true) {
			//Click Delete button:
			element = driver.findElement(By.xpath("//button[@class='btn btn-danger btn-xs']"));
			element.click();
			
			//Are you sure Pop-up:
			element = ExplicitWait.waitForElement_Visible(driver, By.xpath("//div[@id='delete-record']//button[@ng-click='deleteRecord()']"), 3);
			element.click();
		}
	}
	
	public static void import_From_File_Button(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//span[text()='Import From File']"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//span[text()='Import From File']"), 3);
		element.click();
	}
	
	public static void upload_Button(WebDriver driver) throws Exception {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//button[text()='Upload']"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//button[text()='Upload']"), 3);
		element.click();
		Thread.sleep(10000);
		driver.navigate().refresh();
	}
	
	public static void click_Edit_Saved_StockTake(WebDriver driver) throws Exception {
		//Thread.sleep(1000);
		ExplicitWait.waitForElement_Invisible(driver, By.xpath("//p[text()='Loading Items']"), 5);
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//a[@class='btn btn-primary btn-xs']"), 5);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//a[@class='btn btn-primary btn-xs']"), 3);
		element.click();
	}
	
	public static void review_Button(WebDriver driver) {
		ExplicitWait.waitForElement_Invisible(driver, By.xpath("//p[text()='Loading Items']"), 5);
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//span[text()='Review']"), 5);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//span[text()='Review']"), 3);
		element.click();
	}
	
	public static void submit_StockTake(WebDriver driver) throws Exception {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//span[text()='Submit']"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//span[text()='Submit']"), 3);
		element.click();
		Thread.sleep(10000);
	}
	
	public static void navigate_To_StockDashboard(WebDriver driver) {
		action = new Actions(driver);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//ul[@class='navbar']/li[1]"), 3);
		action.moveToElement(element).perform();
		
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//p[text()='Stock Dashboard']"), 3);
		action.moveToElement(element).click().perform();
	}
	
	
	
	public static void readWriteExcel(WebDriver driver) {
		try {
			// Specify the file path which you want to create or write
			//File src = new File("C:\\Users\\Jeff15\\Downloads\\catererstationitems.xlsx");
			File src = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\catererstationitems.xlsx");
			
			// Load the file
			FileInputStream fis = new FileInputStream(src);
			
			// load the workbook
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// get the sheet which you want to modify or create
			XSSFSheet sh1 = wb.getSheetAt(0);
			
			//Shift rows up 1
			sh1.shiftRows(1, sh1.getLastRowNum(), -1);
		
			//Row count
			rows = sh1.getPhysicalNumberOfRows();
			
			//int Cols = sh1.getRow(0).getLastCellNum();
			
			ranCount = 50 + random.nextInt(201);
			
			
			
			Row row = null;
			for (int r = 1; r < rows; r++) {
				if (sh1.getRow(r) != null) {
					row = sh1.getRow(r);
				} else {
					row = sh1.createRow(r);
				}
			}
				
			for (int i = 1; i < rows; i++) {
			//set new QTY:
			//sh1.getRow(i).createCell(2).setCellValue(ranCount);     // Random QTY for each item
				
			//OR
				
			sh1.getRow(i).createCell(2).setCellValue(qty);    // Fixed QTY for all items.
			
			//expectedCount = String.valueOf(ranCount);   // For Random QTY
			expectedCount = String.valueOf(qty);  // For Fixed QTY
			}
			
			// here we need to specify where you want to save file
			FileOutputStream fout = new FileOutputStream(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\catererstationitems.xlsx"));

			// finally write content
			wb.write(fout);

			// close the file
			fout.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}

}
