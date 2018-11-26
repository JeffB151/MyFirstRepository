package testCases;

import org.testng.annotations.Test;

import base.BrowserSetup;
import base.Commons;
import page.classes.Menu_Mgmt_Create_Menu;
import page.classes.Dashboard;
import page.classes.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class CreateMenuTest {

	WebDriver driver;
	int num;
	int numOfItems = 4;
	String itemDescription = "Selenium Test Script Data";

	@BeforeMethod
	public void beforeMethod() throws Exception {	
		driver = BrowserSetup.initialize();
	}

	@Test
	public void menuCreation() throws Exception  {
		LoginPage.userName(driver);
		LoginPage.passWord(driver);
		LoginPage.clickLoginButton(driver);

		// Navigate to Create Menu page:
		Dashboard.createMenu(driver);

		// Enter Menu Code:
		Menu_Mgmt_Create_Menu.menuCode(driver);

		// Enter Menu Name:
		Menu_Mgmt_Create_Menu.menuName(driver);

		//Select Start Date (Current Date + additional argDays):
		Commons.date_Picker_Search_Future_Date(driver, By.name("EffectiveStartDate"), 5);
		
		// Select End Date:
		Commons.date_Picker_Search_Future_Date(driver, By.name("endDate"), 9);

		// Enter Item Description:
		Menu_Mgmt_Create_Menu.itemDescription(driver, itemDescription);

		// Click Add Items buttons:
		for (int i = 0; i < 3; i++) {
			Menu_Mgmt_Create_Menu.addItemsButton(driver);
		}

		// Selecting Items:
		int j = 2;
		for (int i = 1; i < numOfItems; i++) {

			// Open Item Modal:
			Menu_Mgmt_Create_Menu.itemModal(driver, i);

			// Select the item:
			Menu_Mgmt_Create_Menu.itemNameSelect(driver, j);

			// Input QTY:
			Menu_Mgmt_Create_Menu.itemQTY(driver, i);
			j++;
		}

		// Click Save button:
		//CreateMenu.saveButton(driver);
		
		//Test Case Assertion:
		Menu_Mgmt_Create_Menu.createMenuAssertion(driver);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
