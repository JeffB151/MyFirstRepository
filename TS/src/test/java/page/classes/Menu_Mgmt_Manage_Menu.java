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
import org.testng.Assert;

import base.Commons;
import utilities.ExplicitWait;

public class Menu_Mgmt_Manage_Menu {
	
	static Random random = new Random();
	static WebElement element;
	static String menuIdPre;
	static int menuIdPost = 1000 + random.nextInt(9000);
	static String menuID;
	static String menuNamePre;
	static String menuName;
	static String searchMenuCode;
	static int itemQTY;
	static int startDate = 3;
	static int endDate = 4;
	static int rows = 5;
	
	
	
	
	public static void import_File_Down_Arrow (WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//i[@class='fa fa-caret-down']"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//i[@class='fa fa-caret-down']"), 3);
		element.click();
	}
	
	public static void import_From_File_Button (WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//span[text()='Import From File']"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//span[text()='Import From File']"), 3);
		element.click();
	}
	
	public static void upload_Button_Click (WebDriver driver) throws InterruptedException {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//button[text()='Upload']"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//button[text()='Upload']"), 3);
		element.click();
		Thread.sleep(10000);
		driver.navigate().refresh();
	}
	
	public static void download_Template_Button (WebDriver driver) throws Exception {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//a[text()='Download Template']"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//a[text()='Download Template']"), 3);
		element.click();
		Thread.sleep(1000);
	}
	
	public static void search_Filter_Expand_Click (WebDriver driver) {
		ExplicitWait.waitForElement_Invisible(driver, By.xpath("//p[@class='loading-more alert alert-info text-center']"), 3);
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//span[text()='Filter']"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//span[text()='Filter']"), 3);
		element.click();
	}
	
	public static void create_Menu_Button_Click (WebDriver driver) throws Exception {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//span[text()='Create Menu']"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//span[text()='Create Menu']"), 3);
		element.click();
		Thread.sleep(1000);
		ExplicitWait.waitForElement_Invisible(driver, By.id("loading"), 3);
	}
	
	public static void click_Search_Button (WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.id("searchMenuListId"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.id("searchMenuListId"), 3);
		element.click();
	}
	
	public static void enter_Menu_Code (WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.id("item-code"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.id("item-code"), 3);
		element.sendKeys(menuID);
	}
	

	public static String get_Menu_Code_After_Search (WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//tr[1]/td[1]"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//tr[1]/td[1]"), 3);
		searchMenuCode = element.getText();
		return searchMenuCode;
	}
	
	public static void assert_Menu_Upload (WebDriver driver) throws Exception {
		//Search:
		Menu_Mgmt_Manage_Menu.enter_Menu_Code(driver);
		ExplicitWait.waitForElement_Visible(driver, By.name("Effective From *"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.name("Effective From *"), 3);
		Commons.date_Picker_Search_Future_Date(driver, By.name("Effective From *"), startDate);
		Commons.date_Picker_Search_Future_Date(driver, By.name("Effective To *"), endDate);
		Menu_Mgmt_Manage_Menu.click_Search_Button(driver);
		System.out.println("Expected Menu Code: " + menuID);
		
		//Assert:
		Menu_Mgmt_Manage_Menu.get_Menu_Code_After_Search(driver);
		System.out.println("Actual Menu Code: "+ searchMenuCode);
		Assert.assertEquals(menuID, searchMenuCode);
		System.out.println("**********************************************");
	}
	
	
	///////////////////////////// Menu Upload Methods://///////////////////////
	public static String menu_Code_Generator (WebDriver driver) {
		menuIdPre = "AutoMenuID";
		menuID = menuIdPre + menuIdPost;
		return menuID;
	}
	
	public static String menu_Name_Generator (WebDriver driver) {
		menuNamePre = "Automation Menu";
		menuName = menuNamePre + " " + menuIdPost;
		return menuName;
	}
	
	public static int item_QTY_Generator (WebDriver driver) {
		itemQTY = random.nextInt(101);
		return itemQTY;
	}
	
	
	
	
	
	
	public static void readWriteExcel_Except_Items (WebDriver driver) {
		try {
			// Specify the file path which you want to create or write
			File src = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\menuUpload.xlsx");
			
			// Load the file
			FileInputStream fis = new FileInputStream(src);
			
			// Load the workbook
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Get the sheet which you want to modify or create
			XSSFSheet sh1 = wb.getSheetAt(0);
		
			//int Cols = sh1.getRow(0).getLastCellNum();
			
			Row row = null;
			for (int r = 1; r < rows; r++) {
				if (sh1.getRow(r) != null) {
					row = sh1.getRow(r);
				} else {
					row = sh1.createRow(r);
				}
			}
				
			for (int i = 1; i < rows; i++) {
			//Menu Code:
			sh1.getRow(i).createCell(0).setCellValue(Menu_Mgmt_Manage_Menu.menu_Code_Generator(driver));

			//Menu Name:
			sh1.getRow(i).createCell(1).setCellValue(Menu_Mgmt_Manage_Menu.menu_Name_Generator(driver));
			
			//Menu Start Date:
			sh1.getRow(i).createCell(2).setCellValue(Commons.fileUpload_Date_yyyyMMdd(2));
			
			//Menu End Date:
			sh1.getRow(i).createCell(3).setCellValue(Commons.fileUpload_Date_yyyyMMdd(3));
			
			//Item Code: Called from other method in Create Menu page.
	
			//Item Name: Called from other method in Create Menu page.
			
			//Item QTY:
			sh1.getRow(i).createCell(6).setCellValue(Menu_Mgmt_Manage_Menu.item_QTY_Generator(driver));
			
			}
			
			// here we need to specify where you want to save file
			FileOutputStream fout = new FileOutputStream(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\menuUpload.xlsx"));

			// finally write content
			wb.write(fout);

			// close the file
			fout.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}

}
