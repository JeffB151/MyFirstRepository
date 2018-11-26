package page.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import base.Commons;
import utilities.ExplicitWait;

public class Menu_Mgmt_Create_Menu {
	
	public static WebElement element = null;
	public static List<WebElement> listElement = null;
	static Actions action;
	static int num;
	static String itemID;
	static String itemName;
	static Random ran;
	static int rows = 5;
	
	//Menu Code (Not for File Upload)
	public static WebElement menuCode(WebDriver driver) {
		String menuCodeRan1 = RandomStringUtils.randomAlphanumeric(10);
		element = driver.findElement(By.name("menuCode"));
		element.sendKeys(menuCodeRan1);
		return element;
	}
	
	//Menu Name (Not for FU)
	public static WebElement menuName(WebDriver driver) {
		String menuNameRan = RandomStringUtils.randomAlphanumeric(10);
		element = driver.findElement(By.name("menuName"));
		element.sendKeys(menuNameRan);
		return element;
	}
	
	/*
	//Start Date Picker Enable
	public static void startDatePicker(WebDriver driver, int addDays) throws Exception {
		Thread.sleep(1000);
		//ExplicitWait.waitForElement_Invisible(driver, ".//*[@id='loading']/div/div/div");
		ExplicitWait.waitForElement_Invisible(driver, By.id("loading"), 3);
		ExplicitWait.waitForElement_Visible(driver, By.name("EffectiveStartDate"), 5);
		element = ExplicitWait.waitForElement_Clickable(driver, By.name("EffectiveStartDate"), 5);
		element.click();
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		// cal.roll(Calendar.DATE, true);
		cal.add(Calendar.DATE, addDays); // Adds days to the current date

		String newDate = dateFormat.format(cal.getTime());
		//System.out.println("Date: " + newDate);
		// Splits out the dd for the new date
		String dateSplit[] = newDate.split("/");
		//System.out.println("DateSplit: " + dateSplit[0]);

		// Convert string to int
		String ddNumber = dateSplit[0];
		int result = Integer.parseInt(ddNumber);
		//System.out.println("Start Date Result: " + result);

		List<WebElement> allDates = driver.findElements(By.tagName("td"));

		for(WebElement ele : allDates) {
			String classAtt = ele.getAttribute("class");
			//System.out.println("The Class Attribute is: " + classAtt);
			if (classAtt.equals("day") || classAtt.equals("new day")) {
				String D = ele.getText();
				int Date = Integer.parseInt(D);
				if (Date == result) {
					ele.click();
					break;
				}
			}
		}
	}
	
	
	// End Date Picker - Get all days
	public static void endDatePicker(WebDriver driver, int addDays) throws Exception {
		element = ExplicitWait.waitForElement_Clickable(driver, By.name("endDate"), 3);
		element.click();
		
		DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(new Date());
		// cal.roll(Calendar.DATE, true);
		cal2.add(Calendar.DATE, addDays); // Adds days to the current date

		String newDate2 = dateFormat2.format(cal2.getTime());
		//System.out.println("Date: " + newDate2);
		// Splits out the dd for the new date
		String dateSplit2[] = newDate2.split("/");
		//System.out.println("DateSplit: " + dateSplit2[0]);

		// Convert string to int
		String ddNumber2 = dateSplit2[0];
		int result2 = Integer.parseInt(ddNumber2);
		//System.out.println("End Date Result: " + result2);
		
		List<WebElement> allDates2 = driver.findElements(By.tagName("td"));

		for (WebElement ele : allDates2) {
			String classAtt = ele.getAttribute("class");
			if (classAtt.equals("day") || classAtt.equals("new day")) {
				String D = ele.getText();
				int Date = Integer.parseInt(D);
				if (Date == result2) {
					ele.click();
					break;
				}
			}
		}
	}
	*/
	
	//Item Description
	public static WebElement itemDescription(WebDriver driver, String itemDescArg) {
		element = driver.findElement(By.name("menuDescription"));
		element.sendKeys(itemDescArg);
		return element;
	}
	
	//Add Items button
	public static void addItemsButton(WebDriver driver) {
		//ExplicitWait.waitForElement_Invisible(driver, ".//*[@id='loading']/div/div/div");
		ExplicitWait.waitForElement_Invisible(driver, By.id("loading"), 3);
		element = driver.findElement(By.xpath("//button[contains(@ng-click, 'addItem()')]"));
		element.click();
	}
	
	//Modal window click
	public static void itemModal(WebDriver driver, int iArg) {   // 1 = Item Name, 2 = Item Category
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//tr[" + iArg + "]//td[3]//div[1]//div[1]//button[1]"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//tr[" + iArg + "]//td[3]//div[1]//div[1]//button[1]"), 3);
		element.click();
	}
	
	public static void itemNameSelect (WebDriver driver, int itemNum) {
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//tr["+ itemNum +"]//td[3]/a[1]"), 3);
		element.click();
	}
	
	//Item QTY Field
	public static WebElement itemQTY(WebDriver driver, int QTY) {
		ran = new Random();
		num = 1 + ran.nextInt(150);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//tbody/tr[" + QTY +"]/td[4]//input"), 3);
		element.sendKeys(String.valueOf(num));
		return element;
	}
	
	public static void close_Item_Modal (WebDriver driver) {
		//ExplicitWait.waitForElement_Visible(driver, By.xpath("//button[text()='Close']"), 5);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//div[@id='master-items']//button[text()='Close']"), 3);
		element.click();
	}
	
	//Delete Row button
	public static void deleteRowButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//i[@class='fa fa-trash']"));
		element.click();
	}
	
	//Save Button
	public static void saveButton(WebDriver driver) {
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//span[@class='glyphicon glyphicon-check']"), 3);
		element.click();
	}
	
	//Back Button
	public static void backButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='#/menu-list']"));
		element.click();
	}
	
	//Assertion
	public static void createMenuAssertion(WebDriver driver) {
		ExplicitWait.waitForElement_Clickable(driver, By.xpath("//h2[contains(text(), 'Menu Management')]"), 10);
		String actual = driver.findElement(By.tagName("h2")).getText();
		Assert.assertEquals(actual, "Menu Management");	
	}
	
	public static void editButton_ActiveRecord (WebDriver driver) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date currentDate = new Date();
		System.out.println(dateFormat.format(currentDate));
	}
	
	public static void navigate_To_Manage_Menus (WebDriver driver) {
		action = new Actions(driver);
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//i[@class='icon-manage-menu']"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//i[@class='icon-manage-menu']"), 3);
		action.moveToElement(element);
		action.perform();
		
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//p[text()='Manage Menus']"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//p[text()='Manage Menus']"), 3);
		action.moveToElement(element).click().perform();
	}
	
	
	
	public static String get_Existing_Item_ID_4FU (WebDriver driver, int itemIdPosition) {
			ExplicitWait.waitForElement_Visible(driver, By.xpath("//div[@id='master-items']//tbody//tr[" + itemIdPosition + "]//td[2]"), 3);
			element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//div[@id='master-items']//tbody//tr[" + itemIdPosition + "]//td[2]"), 3);
			itemID = element.getText();
		return itemID;
	}
	
	public static String get_Existing_Item_Name_4FU (WebDriver driver, int itemNamePosition) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//div[@id='master-items']//tbody//tr[" + itemNamePosition + "]//td[1]"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//div[@id='master-items']//tbody//tr[" + itemNamePosition + "]//td[1]"), 3);
		itemName = element.getText();
		return itemName;
	}
	
	
	public static void readWriteExcel_For_Items(WebDriver driver) {
		try {
			// Specify the file path which you want to create or write
			File src = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\menuUpload.xlsx");

			// Load the file
			FileInputStream fis = new FileInputStream(src);

			// load the workbook
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// get the sheet which you want to modify or create
			XSSFSheet sh1 = wb.getSheetAt(0);

			// int Cols = sh1.getRow(0).getLastCellNum();

			Row row = null;
			for (int r = 1; r < rows; r++) {
				if (sh1.getRow(r) != null) {
					row = sh1.getRow(r);
				} else {
					row = sh1.createRow(r);
				}
			}

			for (int i = 1; i < rows; i++) {
				// Item ID:
				sh1.getRow(i).createCell(4).setCellValue(Menu_Mgmt_Create_Menu.get_Existing_Item_ID_4FU(driver, i + 1));

				// Item Name:
				sh1.getRow(i).createCell(5).setCellValue(Menu_Mgmt_Create_Menu.get_Existing_Item_Name_4FU(driver, i + 1));

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
