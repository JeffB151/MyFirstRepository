package page.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
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

public class Employees_ManageEmployees {
	
	static int rows = 3;
	static int cols = 8;

	static int startDate = 2;
	static int endDate = 3;
	static WebElement element = null;
	static Random random = new Random();
	static boolean baseStationPresent;
	static String country;
	public static String baseStation;
	static String employeeTitle;
	static List<WebElement> ele;
	static int size;
	static int value;
	static String fullBaseStation;
	static String[] split;
	static String employeeID;
	static String postTripEmpID;
	static int postTripRows = 5;

	
	public static void import_Down_Arrow(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//button[@class='btn btn-info dropdown-toggle']"), 5);
		ExplicitWait.waitForElement_Clickable(driver, By.xpath("//button[@class='btn btn-info dropdown-toggle']"), 5);
		element = driver.findElement(By.xpath("//button[@class='btn btn-info dropdown-toggle']"));
		element.click();
	}
	
	
	public static void download_Template_Button(WebDriver driver) throws InterruptedException {
		ExplicitWait.waitForElement_Visible(driver, By.linkText("Download Template"), 5);
		ExplicitWait.waitForElement_Clickable(driver, By.linkText("Download Template"), 5);
		element = driver.findElement(By.linkText("Download Template"));
		element.click();
		//ExplicitWait.waitForElement_Invisible(driver, "//ul[@class='dropdown-menu']");
		ExplicitWait.waitForElement_Invisible(driver, By.xpath("//ul[@class='dropdown-menu']"), 3);

	}
	
	
	public static void importFromFile_Button_Click (WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//span[text()='Import From File']"), 3);
		ExplicitWait.waitForElement_Clickable(driver, By.xpath("//span[text()='Import From File']"), 3);
		element = driver.findElement(By.xpath("//span[text()='Import From File']"));
		element.click();
	}
	
	public static void upload_Button_Click (WebDriver driver) throws InterruptedException {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//button[text()='Upload']"), 3);
		ExplicitWait.waitForElement_Clickable(driver, By.xpath("//button[text()='Upload']"), 3);
		element = driver.findElement(By.xpath("//button[text()='Upload']"));
		element.click();
		Thread.sleep(10000);
		driver.navigate().refresh();
	}
	
	
	public static String employee_ID_Generator(WebDriver driver) {
		String prefixID = "AutoID";
		int postID = random.nextInt(9999);
		employeeID = prefixID + postID;
		return employeeID;
	}
	
	
	public static String passcode_Generator(int length) {
		final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    StringBuilder builder = new StringBuilder(length);

	    for (int i = 0; i < length; i++) {
	        builder.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
	    }
	    return builder.toString();
	}
	
	
	public static void search_Button_Click(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.id("searchEmployeeListId"), 3);
		ExplicitWait.waitForElement_Clickable(driver, By.id("searchEmployeeListId"), 3);
		element = driver.findElement(By.id("searchEmployeeListId"));
		element.click();
	}
	
	
	private static String[] Beginning = { "Kr", "Ca", "Ra", "Mrok", "Cru", "Ray", "Bre", "Zed", "Drak", "Mor", "Jag",
			"Mer", "Jar", "Mjol", "Zork", "Mad", "Cry", "Zur", "Creo", "Azak", "Azur", "Rei", "Cro", "Mar", "Luk" };
	private static String[] Middle = { "air", "ir", "mi", "sor", "mee", "clo", "red", "cra", "ark", "arc", "miri",
			"lori", "cres", "mur", "zer", "marac", "zoir", "slamar", "salmar", "urak" };
	private static String[] End = { "d", "ed", "ark", "arc", "es", "er", "der", "tron", "med", "ure", "zur", "cred",
			"mur" };

	public static String name_Gemerator() {
		return Beginning[random.nextInt(Beginning.length)]
				+ Middle[random.nextInt(Middle.length)]
				+ End[random.nextInt(End.length)];
	}
	
	
	public static void search_Button_Expand(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//span[text()='Search']"), 3);
		ExplicitWait.waitForElement_Clickable(driver, By.xpath("//span[text()='Search']"), 3);
		element = driver.findElement(By.xpath("//span[text()='Search']"));
		element.click();
	}
	
	public static String get_Employee_Title(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.name("employeeTitle"), 3);
		ExplicitWait.waitForElement_Clickable(driver, By.name("employeeTitle"), 3);
		element = driver.findElement(By.name("employeeTitle"));
		element.click();
		
		ele = driver.findElements(By.xpath("//a[@class='ui-select-choices-row-inner']"));
		size = ele.size();
		
		value = 3 + random.nextInt(size);
		
		element = driver.findElement(By.xpath("//div[" + value + "]/a[1]/span[1]"));
		employeeTitle = element.getText();
		//System.out.println("The employee title is: " + employeeTitle);
		return employeeTitle;
	}
	
	
	public static String get_Employee_Country_4FU(WebDriver driver, int rowNum) {
		for (int i = 1; i < rows; i++) {
			ExplicitWait.waitForElement_Visible(driver, By.xpath("//tr[" + rowNum + "]/td[1]"), 3);
			ExplicitWait.waitForElement_Clickable(driver, By.xpath("//tr[" + rowNum + "]/td[1]"), 3);
			element = driver.findElement(By.xpath("//tr[" + rowNum + "]/td[1]"));
			country = element.getText();
		}
		return country;
	}
	
	public static String get_Employee_Base_Station_4FU(WebDriver driver, int rowNum) {
		for(int i = 1; i < rows; i++) {
			ExplicitWait.waitForElement_Visible(driver, By.xpath("//tr[" + rowNum + "]/td[2]"), 3);
			ExplicitWait.waitForElement_Clickable(driver, By.xpath("//tr[" + rowNum + "]/td[2]"), 3);
			element = driver.findElement(By.xpath("//tr[" + rowNum + "]/td[2]"));
			baseStation = element.getText();
		}
		return baseStation;
	}
	
	public static String get_EmployeeID_For_PostTrips (WebDriver driver, int rowPosition) {
		element = ExplicitWait.waitForElement_Visible(driver, By.xpath("//tr[" + rowPosition + "]/td[3]"), 3);
		postTripEmpID = element.getText();
		return postTripEmpID;
	}
	
	
	
	
	
	public static String get_Active_BaseStation_Based_On_Country(WebDriver driver) throws InterruptedException {
		/*  NOT USED ANYMORE.  i CAME UP WITH A BETTER SOLUTION.  ONLY KEEPING THIS HERE FOR REFERENCE PURPOSES.
		 * This code works well for companies with a lot of active base stations. (EZY)
		 * But it's not efficient for companies such as LATAM where there's limited base stations.
		 */
		
		
		do {
			//Country
			ExplicitWait.waitForElement_Visible(driver, By.xpath("//div[@on-select='onCounrtyChange()']"), 5);
			ExplicitWait.waitForElement_Clickable(driver, By.xpath("//div[@on-select='onCounrtyChange()']"), 5);
			element = driver.findElement(By.xpath("//div[@on-select='onCounrtyChange()']"));
			element.click();

			List<WebElement> ele = driver.findElements(By.xpath("//a[@class='ui-select-choices-row-inner']"));
			int size = ele.size();
			int val = 3 + random.nextInt(size-3);
			System.out.println("The value is: " + val);

			element = driver.findElement(By.xpath("//div[" + val + "]/a[1]/span[1]"));
			country = element.getText();
			System.out.println("The Country is: " + country);
			element.click();
			Thread.sleep(500);
			
			// Base Station:
			ExplicitWait.waitForElement_Visible(driver, By.id("base-station-id"), 5);
			ExplicitWait.waitForElement_Clickable(driver, By.id("base-station-id"), 5);
			element = driver.findElement(By.id("base-station-id"));
			element.click();

			baseStationPresent = driver.findElements(By.xpath(
					"//div[3]/a[1]/span[1]"))
					.size() != 0;

		
			if (baseStationPresent == true) {
				ExplicitWait.waitForElement_Visible(driver, By.xpath("//div[3]/a[1]/span[1]"), 5);
				ExplicitWait.waitForElement_Clickable(driver, By.xpath("//div[3]/a[1]/span[1]"), 5);
				element = driver.findElement(By.xpath("//div[3]/a[1]/span[1]"));
//				fullBaseStation = element.getText();
//				split = fullBaseStation.split(" ");
//				baseStation = split[0];
//				System.out.println("The base station is: " + baseStation);
				element.click();
				break;
			} else {
				System.out.println("Clearing....");
				element = driver.findElement(By.xpath("//button[text()='Clear']"));
				element.click();
			}
		} while (baseStationPresent == false);
		
		return country;
	}
	
	
	public static String get_Selected_BaseStation(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//span[@placeholder='Select Stations..']//span[1]/span[2]/span[1]"), 3);
		ExplicitWait.waitForElement_Clickable(driver, By.xpath("//span[@placeholder='Select Stations..']//span[1]/span[2]/span[1]"), 3);
		element = driver.findElement(By.xpath("//span[@placeholder='Select Stations..']//span[1]/span[2]/span[1]"));
		fullBaseStation = element.getText();
		split = fullBaseStation.split(" ");
		baseStation = split[0];
		System.out.println("The Base Station is: " + baseStation);
		
		element = driver.findElement(By.xpath("//button[text()='Clear']"));
		element.click();
		
		return baseStation;
	}
	
	
	public static void assert_Employee_File_Upload(WebDriver driver) throws Exception {
		//Employee ID field, Date Pickers:
		ExplicitWait.waitForElement_Visible(driver, By.id("employee-identifier"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.id("employee-identifier"), 3);
		element = driver.findElement(By.id("employee-identifier"));
		element.sendKeys(employeeID);
		System.out.println("The Expected Employee ID is: " + employeeID);
		Commons.date_Picker_Search_Future_Date(driver, By.name("Effective Start Date"), 2);
		Employees_ManageEmployees.search_Button_Click(driver);
		
		//Capture actual result found:
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//tr[1]/td[3]"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//tr[1]/td[3]"), 3);
		String actual = element.getText();
		System.out.println("The actual Employee ID is: " + actual);
		Assert.assertEquals(employeeID, actual);
		System.out.println("**********************************************");
	}
	
	
	
	
	
	public static void readWriteExcel(WebDriver driver) {
		try {
			// Specify the file path which you want to create or write
			File src = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\employeeUpload.xlsx");
			
			// Load the file
			FileInputStream fis = new FileInputStream(src);
			
			// load the workbook
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// get the sheet which you want to modify or create
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
			//Employee ID:
			sh1.getRow(i).createCell(0).setCellValue(Employees_ManageEmployees.employee_ID_Generator(driver));

			//Passcode:
			sh1.getRow(i).createCell(1).setCellValue(Employees_ManageEmployees.passcode_Generator(10));
			
			//Employee First Name:
			sh1.getRow(i).createCell(2).setCellValue(Employees_ManageEmployees.name_Gemerator());
			
			//Employee First Name:
			sh1.getRow(i).createCell(3).setCellValue(Employees_ManageEmployees.name_Gemerator());
			
			//Country:
			sh1.getRow(i).createCell(4).setCellValue(Employees_ManageEmployees.get_Employee_Country_4FU(driver, i));
			
			//Base Station:
			sh1.getRow(i).createCell(5).setCellValue(Employees_ManageEmployees.get_Employee_Base_Station_4FU(driver, i));

			//Employee Title:
			sh1.getRow(i).createCell(6).setCellValue(Employees_ManageEmployees.get_Employee_Title(driver));
			
			//Start Date:
			sh1.getRow(i).createCell(7).setCellValue(Commons.fileUpload_Date_yyyyMMdd(startDate));
			
			
			//End Date:
			sh1.getRow(i).createCell(8).setCellValue(Commons.fileUpload_Date_yyyyMMdd(endDate));

			
			}
			
			// here we need to specify where you want to save file
			FileOutputStream fout = new FileOutputStream(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\employeeUpload.xlsx"));

			// finally write content
			wb.write(fout);

			// close the file
			fout.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		
	}
	
	
	
	public static void readWriteExcel_For_PostTrips (WebDriver driver) {
		try {
			// Specify the file path which you want to create or write
			File src = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\FileUpload-PostTripManagement.xlsx");
			
			// Load the file
			FileInputStream fis = new FileInputStream(src);
			
			// load the workbook
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// get the sheet which you want to modify or create
			XSSFSheet sh1 = wb.getSheetAt(0);
		
			//int Cols = sh1.getRow(0).getLastCellNum();
			
			Row row = null;
			for (int r = 1; r < postTripRows; r++) {
				if (sh1.getRow(r) != null) {
					row = sh1.getRow(r);
				} else {
					row = sh1.createRow(r);
				}
			}
				
			for (int i = 1; i < postTripRows; i++) {
				/*
				//NOT USED HERE:
				//Schedule Number:
				sh1.getRow(i).createCell(0).setCellValue(Schedules_ManageSchedules.get_Schedule_Numbers_For_PostTrip(driver, i));

				//Start Date:
				sh1.getRow(i).createCell(1).setCellValue(Commons.fileUpload_Date_yyyyMMdd(2));
				
				//Departure Station:
				sh1.getRow(i).createCell(2).setCellValue(Schedules_ManageSchedules.get_DepartureStation_For_PostTrip(driver, i));
				
				//Departure Time:
				sh1.getRow(i).createCell(3).setCellValue(Commons.random_Time_Generator());
				
				//Arrival Station:
				sh1.getRow(i).createCell(4).setCellValue(Schedules_ManageSchedules.get_ArrivalStation_For_PostTrip(driver, i));
				
				//Arrival Time:
				sh1.getRow(i).createCell(5).setCellValue(Commons.random_Time_Generator());
				
				//Passenger Count:
				sh1.getRow(i).createCell(6).setCellValue();
				
				//Tail #:
				sh1.getRow(i).createCell(7).setCellValue();
				
				*/
				
				//Employee ID:
				sh1.getRow(i).createCell(8).setCellValue(Employees_ManageEmployees.get_EmployeeID_For_PostTrips(driver, i));

			}
			
			// here we need to specify where you want to save file
			FileOutputStream fout = new FileOutputStream(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\FileUpload-PostTripManagement.xlsx"));

			// finally write content
			wb.write(fout);

			// close the file
			fout.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		
	}

}
