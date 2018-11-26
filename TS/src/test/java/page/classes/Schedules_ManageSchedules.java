package page.classes;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.Commons;
import utilities.ExplicitWait;

public class Schedules_ManageSchedules {
	
	
	static WebElement element = null;
	static String searchDepTimeFrom = "10:05";
	static String searchDepTimeTo = "13:34";
	static String searchArrTimeFrom = "14:42";
	static String searchArrTimeTo = "21:22";
	
	static Random ran = new Random();
	static String daysOfOp;
	
	static int rows = 2;
	static int cols = 18;
	static int startDate = 2;
	//static int endDate;
	static int ranSchNum;
	public static String postTripSchNum;
	static String postTripDepStation;
	static String postTripArrStation;
	static int postTripRows = 5;


	
	
	
	public static void createNewScheduleButton (WebDriver driver) {
		element = driver.findElement(By.xpath("//span[text()='Create Schedule']"));
		element.click();
		//ExplicitWait.Wait_Until_ElementInVisible(driver, "//p[text()='Loading Data']");
		ExplicitWait.waitForElement_Invisible(driver, By.id("loading"), 3);
	}
	
	public static void importFromFileButton (WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//span[text()='Import From File']"), 3);
		ExplicitWait.waitForElement_Clickable(driver, By.xpath("//span[text()='Import From File']"), 3);
		element = driver.findElement(By.xpath("//span[text()='Import From File']"));
		element.click();
	}
	
	public static void importFileDownArrow (WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//excel-upload[@class='excel-upload ng-isolate-scope']//i[@class='fa fa-caret-down']"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//excel-upload[@class='excel-upload ng-isolate-scope']//i[@class='fa fa-caret-down']"), 3);
		//element = driver.findElement(By.xpath("//excel-upload[@class='excel-upload ng-isolate-scope']//i[@class='fa fa-caret-down']"));
		element.click();
	}
	
	public static void downloadTemplate (WebDriver driver) throws Exception {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//a[text()='Download Template']"), 5);
		ExplicitWait.waitForElement_Clickable(driver, By.xpath("//a[text()='Download Template']"), 5);
		element = driver.findElement(By.xpath("//a[text()='Download Template']"));
		element.click();
		Thread.sleep(1000);
	}
	
	public static void templateHelp (WebDriver driver) {
		element = driver.findElement(By.xpath("//a[text()='Template Help']"));
		element.click();
	}
	
	public static void uploadButtonClick(WebDriver driver) throws Exception {
		element = driver.findElement(By.xpath("//button[text()='Upload']"));
		element.click();
		Thread.sleep(10000);
		driver.navigate().refresh();
	}
	
	
	public static void hideShowColumnsButton (WebDriver driver) {
		element = driver.findElement(By.id("single-button"));
		element.click();
	}
	
	public static void blockTimeCheckBox (WebDriver driver) {
		element = driver.findElement(By.xpath("//a[text()=' Block Time']"));
		element.click();
	}
	
	public static void groundTimeCheckBox (WebDriver driver) {
		element = driver.findElement(By.xpath("//a[text()=' Ground Time']"));
		element.click();
	}
	
	public static void previousFlightCheckBox (WebDriver driver) {
		element = driver.findElement(By.xpath("//a[text()=' Previous Flight']"));
		element.click();
	}
	
	public static void nextFlightCheckBox (WebDriver driver) {
		element = driver.findElement(By.xpath("//a[text()=' Next Flight']"));
		element.click();
	}
	
	public static void search_ExpandButton (WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//span[text()='Search']"), 3);
		ExplicitWait.waitForElement_Clickable(driver, By.xpath("//span[text()='Search']"), 3);
		element = driver.findElement(By.xpath("//span[text()='Search']"));
		element.click();
	}
	
	public static String get_First_Schedule_Number_On_Page(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//tr[1]/td[1]"), 5);
		String schNum = driver.findElement(By.xpath("//tr[1]/td[1]")).getText();
		return schNum;
	}
	
	public static String search_Schedule_Number (WebDriver driver, String schNumber) {
		element = driver.findElement(By.id("schedule-number"));
		element.sendKeys(schNumber);
		return schNumber;
	}
	
	public static String get_Schedule_Numbers_For_PostTrip(WebDriver driver, int rowPosition) {
		element = ExplicitWait.waitForElement_Visible(driver, By.xpath("//tr[" + rowPosition + "]/td[1]"), 3);
		postTripSchNum = element.getText();
		return postTripSchNum;
	}
	
	public static String get_DepartureStation_For_PostTrip(WebDriver driver, int rowPosition) {
		element = ExplicitWait.waitForElement_Visible(driver, By.xpath("//tr[" + rowPosition + "]/td[3]"), 3);
		postTripDepStation = element.getText();
		return postTripDepStation;
	}
	
	public static String get_ArrivalStation_For_PostTrip(WebDriver driver, int rowPosition) {
		element = ExplicitWait.waitForElement_Visible(driver, By.xpath("//tr[" + rowPosition + "]/td[6]"), 3);
		postTripArrStation = element.getText();
		return postTripArrStation;
	}
	
	
	
	
	
	public static void search_DaysOfOperation (WebDriver driver) throws Exception {
		for(int i = 0; i < 4; i++) {
			ExplicitWait.waitForElement_Visible(driver, By.xpath("//div[@id='days-of-operation']/div"), 3);
			ExplicitWait.waitForElement_Clickable(driver, By.xpath("//div[@id='days-of-operation']/div"), 3);
			element = driver.findElement(By.xpath("//div[@id='days-of-operation']/div"));
			element.click();
			element = driver.findElement(By.id("ui-select-choices-row-0-0"));
			element.click();
		}
	}
	
	/*
	public static void startDatePicker(WebDriver driver, int addDays) throws Exception {
		
		//ExplicitWait.Wait_Until_ElementInVisible(driver, ".//*[@id='loading']/div/div/div");
		ExplicitWait.waitForElement_Invisible(driver, By.id("loading"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.name("Schedule Date From"), 3);
		element.click();
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		// cal.roll(Calendar.DATE, true);
		cal.add(Calendar.DATE, addDays); // Adds days to the current date

		String newDate = dateFormat.format(cal.getTime());
		System.out.println("Date: " + newDate);
		// Splits out the dd for the new date
		String dateSplit[] = newDate.split("/");
		System.out.println("DateSplit: " + dateSplit[0]);

		// Convert string to int
		String ddNumber = dateSplit[0];
		int result = Integer.parseInt(ddNumber);
		System.out.println("Start Date Result: " + result);

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
	*/
	

	
	public static void search_AircraftType (WebDriver driver) {
		element = driver.findElement(By.id("aircraft-type"));
		element.click();
		element = driver.findElement(By.id("ui-select-choices-row-1-0"));
		element.click();
	}
	
	public static void search_DepartureStation (WebDriver driver) {
		for (int i = 0; i < 3; i++) {
			element = driver.findElement(By.id("departure-station"));
			element.click();
			element = driver.findElement(By.id("ui-select-choices-row-2-0"));
			element.click();
		}
	}
	
	public static String get_Random_Station (WebDriver driver) {
		//ExplicitWait.waitForElement_Visible(driver, By.id("departure-station"), 5);
		//ExplicitWait.waitForElement_Clickable(driver, By.id("departure_station"), 5);
		element = driver.findElement(By.id("departure-station"));
		element.click();
		
		List<WebElement> LMPs = driver.findElements(By.xpath("//a[@class='ui-select-choices-row-inner']"));
		int size = LMPs.size();

		int val = ran.nextInt(size);
		
		
		element = driver.findElement(By.xpath("//div[@id='ui-select-choices-row-2-" + val + "']"));
		String stationFull = element.getText();
		
		String[] stationSplit = stationFull.split(" ");
		String Station = stationSplit[0];
		
		//System.out.println("The Station is: " + Station);
		return Station;
	}
	
	
	
	
	public static String get_Arrival_Station (WebDriver driver) {
		element = driver.findElement(By.xpath("//tr[1]/td[6]"));
		String arrStation = element.getText();
		return arrStation;
	}
	
	
	
	public static void search_DepartureTimeFrom (WebDriver driver) {
		element = driver.findElement(By.id("departure-time-from"));
		element.sendKeys(searchDepTimeFrom);
	}
	
	public static void search_DepartureTimeTo (WebDriver driver) {
		element = driver.findElement(By.id("departure-time-to"));
		element.sendKeys(searchDepTimeTo);
	}
	
	public static void search_ArrivalStation (WebDriver driver) {
		for (int i = 0; i < 3; i++) {
			element = driver.findElement(By.id("arrival-station"));
			element.click();
			element = driver.findElement(By.id("ui-select-choices-row-3-4"));
			element.click();
		}
	}
	
	public static void search_ArrivalTimeFrom (WebDriver driver) {
		element = driver.findElement(By.id("arrival-time-from"));
		element.sendKeys(searchArrTimeFrom);
	}
	
	public static void search_ArrivalTimeTo (WebDriver driver) {
		element = driver.findElement(By.id("arrival-time-to"));
		element.sendKeys(searchArrTimeTo);
	}
	
	public static void searchButton_Click (WebDriver driver) throws Exception {
		ExplicitWait.waitForElement_Clickable(driver, By.id("searchScheduleListId"), 3);
		Thread.sleep(1000);
		element = driver.findElement(By.id("searchScheduleListId"));
		element.click();
		//ExplicitWait.Wait_Until_ElementInVisible(driver, "//p[@class='loading-more alert alert-info text-center']");
		ExplicitWait.waitForElement_Invisible(driver, By.xpath("//p[@class='loading-more alert alert-info text-center']"), 3);
	}
	
	public static void clearButton_Click (WebDriver driver) {
		element = driver.findElement(By.id("clearScheduleListId"));
		element.click();
	}
	
	public static String daysOfOp_Random_Genderator() {
		int day = 1 + ran.nextInt(7);

		if (day == 1) {
			daysOfOp = "1";
		} else if (day == 2) {
			daysOfOp = "1,2";
		} else if (day == 3) {
			daysOfOp = "1,2,3";
		} else if (day == 4) {
			daysOfOp = "1,2,3,4";
		} else if (day == 5) {
			daysOfOp = "1,2,3,4,5";
		} else if (day == 6) {
			daysOfOp = "1,2,3,4,5,6";
		} else if (day == 7) {
			daysOfOp = "1,2,3,4,5,6,7";
		}
		return daysOfOp;
	}
	
	
	public static void editButton_ActiveRecord(WebDriver driver) throws Exception {

		// Get Current System Date
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date systemDate = new Date();
		System.out.println(dateFormat.format(systemDate));

		//Get Row Size
		List<WebElement> rowSize = driver.findElements(By.tagName("tr"));
		System.out.println("Row Size is: " + rowSize.size());
		
		int i = 1;
		for (WebElement rows : rowSize) {
			// Locate Effective From Date
			element = driver.findElement(By.xpath("//tr[" + i + "]/td[9]"));
			String effFrom = element.getText();
			Date effectiveFrom = dateFormat.parse(effFrom);
			System.out.println("Effective From Date: " + effectiveFrom);

			// Locate Effective To Date
			element = driver.findElement(By.xpath("//tr[" + i + "]/td[10]"));
			String effTo = element.getText();
			Date effectiveTo = dateFormat.parse(effTo);
			System.out.println("Effective To Date: " + effectiveTo);

			if ((systemDate.after(effectiveFrom) || (systemDate.equals(effectiveFrom))) && ((systemDate.before(effectiveTo) || (systemDate.equals(effectiveTo))))) {
				element = driver.findElement(By.xpath("//tr[" + i + "]//td[22]//button[2]"));
				element.click();
				break;
			} else {
				i++;
				System.out.println("Failed to locate an active record.");
			}

		}

	}
	
	public static void deleteButton_FutureRecord(WebDriver driver) throws Exception {

		// Get Current System Date
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date systemDate = new Date();
		System.out.println(dateFormat.format(systemDate));

		// Get Row Size
		List<WebElement> rowSize = driver.findElements(By.tagName("tr"));
		System.out.println("Row Size is: " + rowSize.size());

		int i = 1;
		for (WebElement rows : rowSize) {
			// Locate Effective From Date
			element = driver.findElement(By.xpath("//tr[" + i + "]/td[9]"));
			String effFrom = element.getText();
			Date effectiveFrom = dateFormat.parse(effFrom);
			System.out.println("Effective From Date: " + effectiveFrom);

			// Locate Effective To Date
			element = driver.findElement(By.xpath("//tr[" + i + "]/td[10]"));
			String effTo = element.getText();
			Date effectiveTo = dateFormat.parse(effTo);
			System.out.println("Effective To Date: " + effectiveTo);

			if (systemDate.before(effectiveFrom)) {
				element = driver.findElement(By.xpath("//tr[" + i + "]/td[22]/button[3]"));
				element.click();

				// Modal window Cancel or Delete:
				element = driver.findElement(By.xpath("//div[@id='delete-record']//button[@data-dismiss='modal']"));    	   //Cancel Button
				//element = driver.findElement(By.xpath("//div[@id='delete-record']//button[@ng-click='deleteRecord()']"));    //Delete Button
				element.click();
				break;

			} else {
				i++;
			}

		}

	}
	
	
	public static void viewButton_ExpiredRecord(WebDriver driver) throws Exception {
		// Get Current System Date
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date systemDate = new Date();
		System.out.println(dateFormat.format(systemDate));

		// Get Row Size
		List<WebElement> rowSize = driver.findElements(By.tagName("tr"));
		System.out.println("Row Size is: " + rowSize.size());

		int i = 1;
		for (WebElement rows : rowSize) {
			// Locate Effective From Date
			element = driver.findElement(By.xpath("//tr[" + i + "]/td[9]"));
			String effFrom = element.getText();
			Date effectiveFrom = dateFormat.parse(effFrom);
			System.out.println("Effective From Date: " + effectiveFrom);

			// Locate Effective To Date
			element = driver.findElement(By.xpath("//tr[" + i + "]/td[10]"));
			String effTo = element.getText();
			Date effectiveTo = dateFormat.parse(effTo);
			System.out.println("Effective To Date: " + effectiveTo);

			if (systemDate.after(effectiveTo)) {
				element = driver.findElement(By.xpath("//tr[" + i + "]/td[22]/button[1]"));
				element.click();
				break;
			} else {
				i++;
			}

		}

	}
	
	
	public static boolean PastRecord_EndDate_GrayedOut (WebDriver driver) {
		boolean disabled = driver.findElements(By.xpath("//date-picker-field[@name='EffectiveTo']/fieldset[@disabled='disabled']")).size() != 0;
		System.out.println("End Date is: " + disabled);
		return disabled;
	}
	
	public static int random_Schedule_Number_Generator (WebDriver driver) {
		ranSchNum = 1000 + ran.nextInt(8999);
		return ranSchNum;
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
 
	public static void readWriteExcel(WebDriver driver) {
		try {
			// Specify the file path which you want to create or write
			File src = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\scheduleUpload.xlsx");
			
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
			//Schedule Number
			sh1.getRow(i).createCell(0).setCellValue(Schedules_ManageSchedules.random_Schedule_Number_Generator(driver));

			//Aircraft Type
			sh1.getRow(i).createCell(1).setCellValue("");
			
			//Tail Number
			sh1.getRow(i).createCell(2).setCellValue("");
			
			//Seat Config
			sh1.getRow(i).createCell(3).setCellValue("");
			
			//Departure Station
			sh1.getRow(i).createCell(4).setCellValue(Schedules_ManageSchedules.get_Random_Station(driver));
			
			//Departure Time
			sh1.getRow(i).createCell(5).setCellValue(Commons.random_Time_Generator());

			//Arrival Station
			sh1.getRow(i).createCell(6).setCellValue(Schedules_ManageSchedules.get_Random_Station(driver));
			
			//Arrival Time
			sh1.getRow(i).createCell(7).setCellValue(Commons.random_Time_Generator());
			
			//Days Of Operation
			sh1.getRow(i).createCell(8).setCellValue(Schedules_ManageSchedules.daysOfOp_Random_Genderator());
			
			//Block Time
			sh1.getRow(i).createCell(9).setCellValue("");
			
			//Ground Time
			sh1.getRow(i).createCell(10).setCellValue("");
			
			//Trip Distance
			sh1.getRow(i).createCell(11).setCellValue("");
			
			//Trip Distance - Miles(mi) or Kilometer(km)
			sh1.getRow(i).createCell(12).setCellValue("");
			
			//Previous Number
			sh1.getRow(i).createCell(13).setCellValue("");
			
			//Next Number
			sh1.getRow(i).createCell(14).setCellValue("");
			
			//First Trip of Day
			sh1.getRow(i).createCell(15).setCellValue("");
			
			//Last Trip of Day
			sh1.getRow(i).createCell(16).setCellValue("");
			
			//Start Date
			sh1.getRow(i).createCell(17).setCellValue(Commons.fileUpload_Date_yyyyMMdd(2));
			
			//End Date
			sh1.getRow(i).createCell(18).setCellValue(Commons.fileUpload_Date_yyyyMMdd(3));
			
			}
			
			// here we need to specify where you want to save file
			FileOutputStream fout = new FileOutputStream(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\scheduleUpload.xlsx"));

			// finally write content
			wb.write(fout);

			// close the file
			fout.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}

	
	//////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	public static void assert_Schedule_File_Upload (WebDriver driver) throws Exception {
		ExplicitWait.waitForElement_Visible(driver, By.id("schedule-number"), 3);
		element = driver.findElement(By.id("schedule-number"));
		element.sendKeys(String.valueOf(ranSchNum));
		//System.out.println("Vericfication: The schedule number is: " + ranSchNum);
		//Schedules_ManageSchedules.startDatePicker(driver, startDate);
		Commons.date_Picker_Search_Future_Date(driver, By.name("Schedule Date From"), startDate);
		Schedules_ManageSchedules.searchButton_Click(driver);
		ExplicitWait.waitForElement_Invisible(driver, By.xpath("//p[text()='Loading Data']"),10);
		
		String ScheduleString = Schedules_ManageSchedules.get_First_Schedule_Number_On_Page(driver);
		int actual = Integer.parseInt(ScheduleString);
		System.out.println("The Expected schedule Number is: " + ranSchNum);
		System.out.println("The Actual schedule Number is: " + actual);
		Assert.assertEquals(ranSchNum, actual);

		

	}
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	
	public static void readWriteExcel_For_PostTrip (WebDriver driver) {
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
			//Schedule Number:
			sh1.getRow(i).createCell(0).setCellValue(Schedules_ManageSchedules.get_Schedule_Numbers_For_PostTrip(driver, i));

			//Start Date:
			sh1.getRow(i).createCell(1).setCellValue(Commons.fileUpload_Date_yyyyMMdd(2));
			
			//Departure Station:
			sh1.getRow(i).createCell(2).setCellValue(Schedules_ManageSchedules.get_DepartureStation_For_PostTrip(driver, i));
			
			//Departure Time:
			sh1.getRow(i).createCell(3).setCellValue(Commons.random_Time_Generator_4Digits());
			
			//Arrival Station:
			sh1.getRow(i).createCell(4).setCellValue(Schedules_ManageSchedules.get_ArrivalStation_For_PostTrip(driver, i));
			
			//Arrival Time:
			sh1.getRow(i).createCell(5).setCellValue(Commons.random_Time_Generator_4Digits());

			//NOT IMPLEMENTED ON THIS SCREEN******************************
			//Passenger Count:
			//sh1.getRow(i).createCell(6).setCellValue();
			
			//Tail #:
			//sh1.getRow(i).createCell(7).setCellValue();
			
			//Employee ID:
			//sh1.getRow(i).createCell(8).setCellValue();
			//*************************************************************
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
