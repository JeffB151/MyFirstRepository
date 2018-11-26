package page.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utilities.ExplicitWait;

public class PostTrip_CreatePostTrip {
	
	static WebDriver driver;
	static WebElement element;
	static Select select;
	static String tailNum;
	static int postTripRows = 5;
	static Actions action;
	
	public static String get_TailNumber(WebDriver driver, int indexPosition) throws InterruptedException {
		Thread.sleep(1500);
		//ExplicitWait.waitForElement_Selectable(driver, By.name("tailNumber"), 1);
		element = driver.findElement(By.name("tailNumber"));
		select = new Select(element);
		select.selectByIndex(indexPosition);
		tailNum = select.getFirstSelectedOption().getText();
		return tailNum;
	}
	
	public static void navigate2managePostTrip(WebDriver driver) {
		action = new Actions(driver);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//li[@ng-repeat='menuItem in menuItems']/i[@class='icon-manage-menu']"), 3);
		action.moveToElement(element);
		action.perform();
		
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//ul[@class='navbar']//p[text()='Manage Post Trip Data']"), 3);
		action.moveToElement(element);
		action.click().perform();
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
				*/
				
				//Passenger Count:
				sh1.getRow(i).createCell(6).setCellValue(PostTrip_Manage_PostTrip.passenger_Count_Generator(driver));
				
				
				//Tail #:
				sh1.getRow(i).createCell(7).setCellValue(PostTrip_CreatePostTrip.get_TailNumber(driver, i));
				
				
				//Employee ID:
				//sh1.getRow(i).createCell(8).setCellValue(Employees_ManageEmployees.get_EmployeeID_For_PostTrips(driver, i));

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
