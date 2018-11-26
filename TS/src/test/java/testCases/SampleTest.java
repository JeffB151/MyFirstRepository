package testCases;

import org.testng.annotations.Test;

import base.BrowserSetup;
import page.classes.Dashboard;
import page.classes.LoginPage;
import page.classes.Schedules_CreateSchedule;
import page.classes.Schedules_ManageSchedules;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class SampleTest {
	
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		driver = BrowserSetup.initialize();
		
		LoginPage.userName(driver);
		LoginPage.passWord(driver);
		LoginPage.clickLoginButton(driver);
	
	}
	/*
	@Test(priority = 0)
	public void schedules_PastDate_EndDate_GrayedOut_Test() throws Exception {
	Dashboard.manageSchedules(driver);
	Schedules_ManageSchedules.search_ExpandButton(driver);
	Schedules_ManageSchedules.searchButton_Click(driver);
	Schedules_ManageSchedules.viewButton_ExpiredRecord(driver);
	Assert.assertEquals(Schedules_ManageSchedules.PastRecord_EndDate_GrayedOut(driver), true);
	}
	

	@Test(priority = 1)
	public void schedules_Search_Test() throws Exception {
		Dashboard.manageSchedules(driver);
		Schedules_ManageSchedules.search_ExpandButton(driver);
		Schedules_ManageSchedules.search_Number(driver, Schedules_ManageSchedules.schedule_Number_Getter(driver));
		Schedules_ManageSchedules.search_DaysOfOperation(driver);
		Schedules_ManageSchedules.startDatePicker(driver, 0);
		Schedules_ManageSchedules.searchButton_Click(driver);	
	}

	
	
	@Test
	public void schedules_Create_Schedule_Test() throws Exception {
		Dashboard.manageSchedules(driver);
		Schedules_ManageSchedules.createNewScheduleButton(driver);
		Schedules_CreateSchedule.schedule_Number_Field(driver);	
	}
	*/
	
	
	
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
