package testCases;

import org.testng.annotations.Test;

import base.BrowserSetup;
import base.Commons;
import page.classes.Currency_Currency_Setup;
import page.classes.Currency_ePOS_Exchange_Rate;
import page.classes.Dashboard;
import page.classes.Employees_ManageEmployees;
import page.classes.LoginPage;
import page.classes.Menu_Mgmt_Create_Menu;
import page.classes.Menu_Mgmt_Manage_Menu;
import page.classes.PostTrip_CreatePostTrip;
import page.classes.PostTrip_Manage_PostTrip;
import page.classes.RetailItem_Create_Item;
import page.classes.Schedules_ManageSchedules;
import page.classes.StockManager_StockDashboard;
import page.classes.StockManager_StockTakeReport;
import page.classes.TaxMgmt_Manage_Taxes;
import utilities.File_Converter;
import utilities.Is_File_Downloaded;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class FileUploadsTest {

	static WebDriver driver;
	private int LMPIndex1 = 3;   //BSL in u2 UAT
	private int LMPIndex2 = 31;  //TLS in u2 UAT

	@BeforeMethod
	public void beforeMethod() throws Exception {
		driver = BrowserSetup.initializeDC();
		LoginPage.userName(driver);
		LoginPage.passWord(driver);
		LoginPage.clickLoginButton(driver);
	}
	
	
	/*
	@Test(priority=0)
	public void Schedule_xlsx_File_Upload_Test() throws Exception {
		Is_File_Downloaded.delete_File_If_Present("scheduleUpload.xlsx");
		Dashboard.manageSchedules(driver);
		Schedules_ManageSchedules.search_ExpandButton(driver);
		Schedules_ManageSchedules.importFileDownArrow(driver);
		Schedules_ManageSchedules.downloadTemplate(driver);
		Schedules_ManageSchedules.readWriteExcel(driver);
		Schedules_ManageSchedules.importFromFileButton(driver);
		Commons.choose_File_To_Import("scheduleUpload.xlsx");
		Schedules_ManageSchedules.uploadButtonClick(driver);
		Schedules_ManageSchedules.search_ExpandButton(driver);
		Schedules_ManageSchedules.assert_Schedule_File_Upload(driver);
	}
	
	
	@Test(priority=1)
	public void Schedule_xls_File_Upload_Test() throws Exception {
		Is_File_Downloaded.delete_File_If_Present("scheduleUpload.xlsx");
		Is_File_Downloaded.delete_File_If_Present("scheduleUpload.xls");
		Dashboard.manageSchedules(driver);
		Schedules_ManageSchedules.search_ExpandButton(driver);
		Schedules_ManageSchedules.importFileDownArrow(driver);
		Schedules_ManageSchedules.downloadTemplate(driver);
		Schedules_ManageSchedules.readWriteExcel(driver);
		File_Converter.xlsx2xls("scheduleUpload.xlsx", "scheduleUpload.xls");
		Schedules_ManageSchedules.importFromFileButton(driver);
		Commons.choose_File_To_Import("scheduleUpload.xls");
		Schedules_ManageSchedules.uploadButtonClick(driver);
		Schedules_ManageSchedules.search_ExpandButton(driver);
		Schedules_ManageSchedules.assert_Schedule_File_Upload(driver);
	}
	
	
	
	@Test(priority=2)
	public void Employee_xlsx_File_Upload_Test() throws Exception {
		Is_File_Downloaded.delete_File_If_Present("employeeUpload.xlsx");
		Dashboard.manageEmployees(driver);
		Employees_ManageEmployees.import_Down_Arrow(driver);
		Employees_ManageEmployees.download_Template_Button(driver);
		Employees_ManageEmployees.search_Button_Expand(driver);
		Employees_ManageEmployees.readWriteExcel(driver);
		Employees_ManageEmployees.importFromFile_Button_Click(driver);
		Commons.choose_File_To_Import("employeeUpload.xlsx");
		Employees_ManageEmployees.upload_Button_Click(driver);
		Employees_ManageEmployees.search_Button_Expand(driver);
		Employees_ManageEmployees.assert_Employee_File_Upload(driver);
	}
	
	

	@Test(priority=3)
	public void Employee_xls_File_Upload_Test() throws Exception {
		Is_File_Downloaded.delete_File_If_Present("employeeUpload.xlsx");
		Is_File_Downloaded.delete_File_If_Present("employeeUpload.xls");
		Dashboard.manageEmployees(driver);
		Employees_ManageEmployees.import_Down_Arrow(driver);
		Employees_ManageEmployees.download_Template_Button(driver);
		Employees_ManageEmployees.search_Button_Expand(driver);
		Employees_ManageEmployees.readWriteExcel(driver);
		File_Converter.xlsx2xls("employeeUpload.xlsx", "employeeUpload.xls");
		Employees_ManageEmployees.importFromFile_Button_Click(driver);
		Commons.choose_File_To_Import("employeeUpload.xls");
		Employees_ManageEmployees.upload_Button_Click(driver);
		Employees_ManageEmployees.search_Button_Expand(driver);
		Employees_ManageEmployees.assert_Employee_File_Upload(driver);
	}
	

	
	@Test(priority=4)
	public void Menu_xlsx_File_Upload_Test() throws Exception {
		Is_File_Downloaded.delete_File_If_Present("menuUpload.xlsx");
		Dashboard.manageMenus(driver);
		Menu_Mgmt_Manage_Menu.import_File_Down_Arrow(driver);
		Menu_Mgmt_Manage_Menu.download_Template_Button(driver);
		Menu_Mgmt_Manage_Menu.create_Menu_Button_Click(driver);
		Commons.date_Picker_Search_Future_Date(driver, By.name("EffectiveStartDate"), 3);
		Commons.date_Picker_Search_Future_Date(driver, By.name("endDate"), 4);
		Menu_Mgmt_Create_Menu.addItemsButton(driver);
		Menu_Mgmt_Create_Menu.itemModal(driver, 1);
		Menu_Mgmt_Create_Menu.readWriteExcel_For_Items(driver);
		Menu_Mgmt_Create_Menu.close_Item_Modal(driver);
		Menu_Mgmt_Create_Menu.navigate_To_Manage_Menus(driver);
		Menu_Mgmt_Manage_Menu.readWriteExcel_Except_Items(driver);
		Menu_Mgmt_Manage_Menu.import_From_File_Button(driver);
		Commons.choose_File_To_Import("menuUpload.xlsx");
		Menu_Mgmt_Manage_Menu.upload_Button_Click(driver);
		Menu_Mgmt_Manage_Menu.search_Filter_Expand_Click(driver);
		Menu_Mgmt_Manage_Menu.assert_Menu_Upload(driver);
	}
	
	
	
	@Test(priority=5)
	public void Menu_xls_FIle_Upload_Test() throws Exception {
		Is_File_Downloaded.delete_File_If_Present("menuUpload.xlsx");
		Is_File_Downloaded.delete_File_If_Present("menuUpload.xls");
		Dashboard.manageMenus(driver);
		Menu_Mgmt_Manage_Menu.import_File_Down_Arrow(driver);
		Menu_Mgmt_Manage_Menu.download_Template_Button(driver);
		Menu_Mgmt_Manage_Menu.create_Menu_Button_Click(driver);
		Commons.date_Picker_Search_Future_Date(driver, By.name("EffectiveStartDate"), 3);
		Commons.date_Picker_Search_Future_Date(driver, By.name("endDate"), 4);
		Menu_Mgmt_Create_Menu.addItemsButton(driver);
		Menu_Mgmt_Create_Menu.itemModal(driver, 1);
		Menu_Mgmt_Create_Menu.readWriteExcel_For_Items(driver);
		Menu_Mgmt_Create_Menu.close_Item_Modal(driver);
		Menu_Mgmt_Create_Menu.navigate_To_Manage_Menus(driver);
		Menu_Mgmt_Manage_Menu.readWriteExcel_Except_Items(driver);
		File_Converter.xlsx2xls("menuUpload.xlsx", "menuUpload.xls");
		Menu_Mgmt_Manage_Menu.import_From_File_Button(driver);
		Commons.choose_File_To_Import("menuUpload.xls");
		Menu_Mgmt_Manage_Menu.upload_Button_Click(driver);
		Menu_Mgmt_Manage_Menu.search_Filter_Expand_Click(driver);
		Menu_Mgmt_Manage_Menu.assert_Menu_Upload(driver);
	}
	

	
	@Test(priority=6)
	public void PostTrip_xlsx_File_Upload_Test () throws Exception {
		Is_File_Downloaded.delete_File_If_Present("FileUpload-PostTripManagement.xlsx");
		Dashboard.managePostTripData(driver);
		PostTrip_Manage_PostTrip.import_From_File_Down_Arrow(driver);
		PostTrip_Manage_PostTrip.download_Template_Button(driver);
		Dashboard.navigate2Dashboard(driver);
		Dashboard.manageSchedules(driver);
		Schedules_ManageSchedules.search_ExpandButton(driver);
		Commons.date_Picker_Search_Future_Date(driver, By.name("Schedule Date From"), 2);
		Schedules_ManageSchedules.searchButton_Click(driver);
		Schedules_ManageSchedules.readWriteExcel_For_PostTrip(driver);
		Dashboard.navigate2Dashboard(driver);
		Dashboard.manageEmployees(driver);
		Employees_ManageEmployees.search_Button_Expand(driver);
		Commons.date_Picker_Search_Future_Date(driver, By.name("Effective Start Date"), 2);
		Employees_ManageEmployees.search_Button_Click(driver);
		Employees_ManageEmployees.readWriteExcel_For_PostTrips(driver);
		Dashboard.navigate2Dashboard(driver);
		Dashboard.createPostTripData(driver);
		PostTrip_CreatePostTrip.readWriteExcel_For_PostTrips(driver);
		PostTrip_CreatePostTrip.navigate2managePostTrip(driver);
		PostTrip_Manage_PostTrip.click_ImportFromFile_Button(driver);
		Commons.choose_File_To_Import("FileUpload-PostTripManagement.xlsx");
		PostTrip_Manage_PostTrip.click_Upload_Button(driver);
		PostTrip_Manage_PostTrip.expand_SearchButton(driver);
		PostTrip_Manage_PostTrip.assert_PostTrip(driver);
	}
	
	
	@Test(priority=7)
	public void PostTrip_xls_File_Upload_Test() throws Exception {
		Is_File_Downloaded.delete_File_If_Present("FileUpload-PostTripManagement.xlsx");
		Is_File_Downloaded.delete_File_If_Present("FileUpload-PostTripManagement.xls");
		Dashboard.managePostTripData(driver);
		PostTrip_Manage_PostTrip.import_From_File_Down_Arrow(driver);
		PostTrip_Manage_PostTrip.download_Template_Button(driver);
		Dashboard.navigate2Dashboard(driver);
		Dashboard.manageSchedules(driver);
		Schedules_ManageSchedules.search_ExpandButton(driver);
		Commons.date_Picker_Search_Future_Date(driver, By.name("Schedule Date From"), 2);
		Schedules_ManageSchedules.searchButton_Click(driver);
		Schedules_ManageSchedules.readWriteExcel_For_PostTrip(driver);
		Dashboard.navigate2Dashboard(driver);
		Dashboard.manageEmployees(driver);
		Employees_ManageEmployees.search_Button_Expand(driver);
		Commons.date_Picker_Search_Future_Date(driver, By.name("Effective Start Date"), 2);
		Employees_ManageEmployees.search_Button_Click(driver);
		Employees_ManageEmployees.readWriteExcel_For_PostTrips(driver);
		Dashboard.navigate2Dashboard(driver);
		Dashboard.createPostTripData(driver);
		PostTrip_CreatePostTrip.readWriteExcel_For_PostTrips(driver);
		PostTrip_CreatePostTrip.navigate2managePostTrip(driver);
		File_Converter.xlsx2xls("FileUpload-PostTripManagement.xlsx", "FileUpload-PostTripManagement.xls");
		PostTrip_Manage_PostTrip.click_ImportFromFile_Button(driver);
		Commons.choose_File_To_Import("FileUpload-PostTripManagement.xls");
		PostTrip_Manage_PostTrip.click_Upload_Button(driver);
		PostTrip_Manage_PostTrip.expand_SearchButton(driver);
		PostTrip_Manage_PostTrip.assert_PostTrip(driver);
	}
	*/
	
	@Test(priority=8)
	public void stockTake_xlsx_File_Upload_Test() throws Exception {
		Is_File_Downloaded.delete_File_If_Present("catererstationitems.csv");
		Is_File_Downloaded.delete_File_If_Present("catererstationitems.xlsx");
		Dashboard.stockDashboard(driver);
		StockManager_StockDashboard.select_LMP_Station(driver, LMPIndex1);
		StockManager_StockDashboard.export_CSV_Click(driver);
		StockManager_StockDashboard.pre_Import_Current_Count(driver);
		StockManager_StockDashboard.navigate_to_Stock_Take_Report_Page(driver);
		StockManager_StockTakeReport.select_LMP_Station(driver, LMPIndex1);
		StockManager_StockTakeReport.Check_For_Saved_StockTakes(driver);
		File_Converter.csvToXLSX("catererstationitems.csv", "catererstationitems.xlsx");
		StockManager_StockTakeReport.readWriteExcel(driver);
		StockManager_StockTakeReport.import_From_File_Button(driver);
		Commons.choose_File_To_Import("catererstationitems.xlsx");
		StockManager_StockTakeReport.upload_Button(driver);
		StockManager_StockTakeReport.select_LMP_Station(driver, LMPIndex1);
		StockManager_StockTakeReport.click_Edit_Saved_StockTake(driver);
		StockManager_StockTakeReport.review_Button(driver);
		StockManager_StockTakeReport.submit_StockTake(driver);
		StockManager_StockTakeReport.navigate_To_StockDashboard(driver);
		StockManager_StockDashboard.select_LMP_Station(driver, LMPIndex1);
		StockManager_StockDashboard.assert_CurrentCount(driver);
	}
	
	
	@Test(priority=9)
	public void stockTake_xls_File_Upload_Test() throws Exception {
		Is_File_Downloaded.delete_File_If_Present("catererstationitems.csv");
		Is_File_Downloaded.delete_File_If_Present("catererstationitems.xlsx");
		Is_File_Downloaded.delete_File_If_Present("catererstationitems.xls");
		Dashboard.stockDashboard(driver);
		StockManager_StockDashboard.select_LMP_Station(driver, LMPIndex2);
		StockManager_StockDashboard.export_CSV_Click(driver);
		StockManager_StockDashboard.pre_Import_Current_Count(driver);
		StockManager_StockDashboard.navigate_to_Stock_Take_Report_Page(driver);
		StockManager_StockTakeReport.select_LMP_Station(driver, LMPIndex2);
		StockManager_StockTakeReport.Check_For_Saved_StockTakes(driver);
		File_Converter.csvToXLSX("catererstationitems.csv", "catererstationitems.xlsx");
		StockManager_StockTakeReport.readWriteExcel(driver);
		File_Converter.xlsx2xls("catererstationitems.xlsx", "catererstationitems.xls");
		StockManager_StockTakeReport.import_From_File_Button(driver);
		Commons.choose_File_To_Import("catererstationitems.xls");
		StockManager_StockTakeReport.upload_Button(driver);
		StockManager_StockTakeReport.select_LMP_Station(driver, LMPIndex2);
		StockManager_StockTakeReport.click_Edit_Saved_StockTake(driver);
		StockManager_StockTakeReport.review_Button(driver);
		StockManager_StockTakeReport.submit_StockTake(driver);
		StockManager_StockTakeReport.navigate_To_StockDashboard(driver);
		StockManager_StockDashboard.select_LMP_Station(driver, LMPIndex2);
		StockManager_StockDashboard.assert_CurrentCount(driver);	
	}
	
	
	/*
	@Test(priority=10)
	public void exchangeRate_xlsx_File_Upload_Test() throws Exception {
		Is_File_Downloaded.delete_File_If_Present("exchangeRateUpload.xlsx");
		Dashboard.currencySetup(driver);
		Currency_Currency_Setup.get_Base_Currency(driver);
		Currency_Currency_Setup.navigate_to_ePOS_Exchange_Rate_Page(driver);
		Currency_ePOS_Exchange_Rate.import_File_Down_Arrow(driver);
		Currency_ePOS_Exchange_Rate.download_Template(driver);
		Currency_ePOS_Exchange_Rate.select_Operating_Currency(driver);
		Commons.date_Picker_Search_Future_Date(driver, By.name("Start Date"), 2);
		Currency_ePOS_Exchange_Rate.search_Button(driver);
		Currency_ePOS_Exchange_Rate.get_Exchange_Rate_First_Currency(driver);
		Currency_ePOS_Exchange_Rate.check_For_Future_Exchange_Rates(driver);
		Currency_ePOS_Exchange_Rate.navigate_to_Currency_Setup_Page(driver);
		Currency_Currency_Setup.filter_button_Expand(driver);
		Commons.date_Picker_Search_Future_Date(driver, By.name("Effective From"), 2);
		Currency_Currency_Setup.search_Button_Click(driver);
		Currency_Currency_Setup.get_Base_Currency(driver);
		Currency_Currency_Setup.accepted_Currency_Size(driver);
		Currency_Currency_Setup.readWriteExcel(driver);
		Currency_Currency_Setup.navigate_to_ePOS_Exchange_Rate_Page(driver);
		Currency_ePOS_Exchange_Rate.import_From_File_Button_Click(driver);
		Commons.choose_File_To_Import("exchangeRateUpload.xlsx");
		Currency_ePOS_Exchange_Rate.upload_Button_Click(driver);
		Currency_ePOS_Exchange_Rate.select_Operating_Currency(driver);
		Commons.date_Picker_Search_Future_Date(driver, By.name("Start Date"), 2);
		Currency_ePOS_Exchange_Rate.search_Button(driver);
		Currency_ePOS_Exchange_Rate.assert_Exchange_Rate(driver);
	}
	
	
	@Test(priority=11)
	public void exchange_Rate_xls_File_Upload_Test() throws Exception {
		Is_File_Downloaded.delete_File_If_Present("exchangeRateUpload.xlsx");
		Is_File_Downloaded.delete_File_If_Present("exchangeRateUpload.xls");
		Dashboard.currencySetup(driver);
		Currency_Currency_Setup.get_Base_Currency(driver);
		Currency_Currency_Setup.navigate_to_ePOS_Exchange_Rate_Page(driver);
		Currency_ePOS_Exchange_Rate.import_File_Down_Arrow(driver);
		Currency_ePOS_Exchange_Rate.download_Template(driver);
		Currency_ePOS_Exchange_Rate.select_Operating_Currency(driver);
		Commons.date_Picker_Search_Future_Date(driver, By.name("Start Date"), 2);
		Currency_ePOS_Exchange_Rate.search_Button(driver);
		Currency_ePOS_Exchange_Rate.get_Exchange_Rate_First_Currency(driver);
		Currency_ePOS_Exchange_Rate.check_For_Future_Exchange_Rates(driver);
		Currency_ePOS_Exchange_Rate.navigate_to_Currency_Setup_Page(driver);
		Currency_Currency_Setup.filter_button_Expand(driver);
		Commons.date_Picker_Search_Future_Date(driver, By.name("Effective From"), 2);
		Currency_Currency_Setup.search_Button_Click(driver);
		Currency_Currency_Setup.get_Base_Currency(driver);
		Currency_Currency_Setup.accepted_Currency_Size(driver);
		Currency_Currency_Setup.readWriteExcel(driver);
		Currency_Currency_Setup.navigate_to_ePOS_Exchange_Rate_Page(driver);
		File_Converter.xlsx2xls("exchangeRateUpload.xlsx", "exchangeRateUpload.xls");
		Currency_ePOS_Exchange_Rate.import_From_File_Button_Click(driver);
		Commons.choose_File_To_Import("exchangeRateUpload.xls");
		Currency_ePOS_Exchange_Rate.upload_Button_Click(driver);
		Currency_ePOS_Exchange_Rate.select_Operating_Currency(driver);
		Commons.date_Picker_Search_Future_Date(driver, By.name("Start Date"), 2);
		Currency_ePOS_Exchange_Rate.search_Button(driver);
		Currency_ePOS_Exchange_Rate.assert_Exchange_Rate(driver);
	}

	
	@Test(priority=12)
	public static void retail_Item_Image_Upload() throws Exception {
		Dashboard.createRetailItem(driver);
		RetailItem_Create_Item.image_upload_Box_Click(driver);
		Commons.choose_File_To_Import("CocaCola.jpg");
		RetailItem_Create_Item.upload_Button_Click(driver);
		RetailItem_Create_Item.is_Thumbnail_present(driver);
		RetailItem_Create_Item.assert_Item_Image_Upload(driver);
	}
	*/
	
	
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
