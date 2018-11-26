package page.classes;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.Commons;
import utilities.ExplicitWait;

public class PostTrip_Manage_PostTrip {
	
	static Random random;
	static WebElement element;
	static WebDriver driver;
	static String passengerCount;
	
	
	
	public static void import_From_File_Down_Arrow(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//i[@class='fa fa-caret-down']"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//i[@class='fa fa-caret-down']"), 3);
		element.click();
	}
	
	public static void download_Template_Button(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//a[text()='Download Template']"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//a[text()='Download Template']"), 3);
		element.click();
	}
	
	public static void click_ImportFromFile_Button (WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//span[text()='Import From File']"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//span[text()='Import From File']"), 3);
		element.click();
	}
	
	public static void click_Upload_Button (WebDriver driver) throws InterruptedException {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//button[text()='Upload']"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//button[text()='Upload']"), 3);
		element.click();
		Thread.sleep(10000);
		driver.navigate().refresh();
	}
	
	public static String passenger_Count_Generator (WebDriver driver) {
		random = new Random();
		int count = 50 + random.nextInt(151);
		passengerCount = Integer.toString(count);
		return passengerCount;
	}
	
	public static void expand_SearchButton (WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//span[text()='Search']"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//span[text()='Search']"), 3);
		element.click();
	}
	
	public static void click_SearchButton(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.id("searchPostTripDataListId"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.id("searchPostTripDataListId"), 3);
		element.click();
	}
	
	public static void assert_PostTrip (WebDriver driver) throws Exception {
		ExplicitWait.waitForElement_Visible(driver, By.id("schedule-number"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.id("schedule-number"), 3);
		element.sendKeys(Schedules_ManageSchedules.postTripSchNum);
		String Expected = Schedules_ManageSchedules.postTripSchNum;
		System.out.println("The Expected Post Trip is: " + Expected);
		Commons.date_Picker_Search_Future_Date(driver, By.name("Schedule Date From"), 2);
		PostTrip_Manage_PostTrip.click_SearchButton(driver);
		
		//Assert:
		ExplicitWait.waitForElement_Invisible(driver, By.xpath("//p[@class='loading-more alert alert-info text-center']"), 5);
		//element = ExplicitWait.waitForElement_Visible(driver, By.xpath("//tr[1]/td[1]"), 3);
		element = driver.findElement(By.xpath("//tr[1]/td[1]"));
		element.toString();
		String Actual = element.getText();
		System.out.println("The Actual Post Trip is: " + Actual);
		Assert.assertEquals(Expected, Actual);
		
	}
	
}
