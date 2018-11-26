package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.ExplicitWait;

public class Dashboard {
	
	//WebDriver driver;
	public static WebElement element = null;
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void navigate2Dashboard(WebDriver driver) {
		//Navigate to Dashboard
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//a[@class='navbar-brand']"), 5);
		ExplicitWait.waitForElement_Clickable(driver, By.xpath("//a[@class='navbar-brand']"), 5);
		element = driver.findElement(By.xpath("//a[@class='navbar-brand']"));
		element.click();
	}
	
	
	
	//easyjet header link
	public static void easjetHeaderLink(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[@class='hidden-xs ng-binding']"));
		element.click();
	}
	
	//Switch User Link
	public static void userSettingsLink(WebDriver driver) {
		element = driver.findElement(By.cssSelector(".fa.fa-user"));
	}
	
	//Logout Button
	public static void logOutButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@ng-click='logout()']"));
		element.click();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	////////////////////Cash Management/////////////////////////////////////////////////////////////////////////////
	
	//Daily Exchange Rate
	public static void dailyExchangeRate(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/exchange-rates']"));
		element.click();
	}
	
	//Manage Cash Bag
	public static void manageCashBag(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/cash-bag-list']"));
		element.click();
	}
	
	//Cash Bag Submission
	public static void cashBagSubmission(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/cash-bag-submission']"));
		element.click();
	}
	
	
	
	
	////////////////////Company Management/////////////////////////////////////////////////////////////////////////////
	
	//Manage Companies
	public static void manageCompanies(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/company-list']"));
		element.click();
	}
	
	//Create Company
	public static void createCompany(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/company-create']"));
		element.click();
	}
	
	
	
	
	////////////////////Currency & Exchange Rate Management/////////////////////////////////////////////////////////////////////////////
	
	//Currency Setup
	public static void currencySetup(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//h3[text()='Currency & Exchange Rate Management']"), 3);
		ExplicitWait.waitForElement_Clickable(driver, By.xpath("//h3[text()='Currency & Exchange Rate Management']"), 3);
		element = driver.findElement(By.xpath("//a[@href='/#/currency-edit']"));
		element.click();
	}
	
	//ePOS Exchange Rate
	public static void ePosExchangeRate(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//a[@href='/#/company-exchange-rate-edit']"), 5);
		ExplicitWait.waitForElement_Clickable(driver, By.xpath("//a[@href='/#/company-exchange-rate-edit']"), 5);
		element = driver.findElement(By.xpath("//a[@href='/#/company-exchange-rate-edit']"));
		element.click();
	}
	
	
	
	
	//////////////////// Discount Management/////////////////////////////////////////////////////////////////////////////

	// Manage Discounts
	public static void manageDiscounts(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/discounts']"));
		element.click();
	}

	// Create Discount
	public static void createDiscount(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/discounts/create']"));
		element.click();
	}
	
	
	
	
	////////////////////Employee Commission/////////////////////////////////////////////////////////////////////////////
	
	//Employee Commission
	public static void employeeCommission(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/employee-commission-list']"));
		element.click();
	}
	
	//Commission Data Table
	public static void commissionDataTable(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/commission-data-table']"));
		element.click();
	}
	
	
	
	
	////////////////////Employee Management/////////////////////////////////////////////////////////////////////////////
	
	//Manage Employees
	public static void manageEmployees(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//a[@href='/#/employees']"), 5);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//a[@href='/#/employees']"), 5);
		element.click();
	}
	
	//Create Employee
	public static void createEmployee(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//a[@href='/#/employee/create']"), 5);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//a[@href='/#/employee/create']"), 5);
		element.click();
	}
	
	
	
	
	
	////////////////////Employee Messages/////////////////////////////////////////////////////////////////////////////
	
	//Manage Messages
	public static void manageEmployeeMessages(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/employee-messages']"));
		element.click();
	}
	
	//Create Message
	public static void createEmployeeMessage(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/employee-message/create']"));
		element.click();
	}
	
	
	
	
	
	////////////////////Excise Duty/////////////////////////////////////////////////////////////////////////////
	public static void manageExciseDuty(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/excise-duty-list']"));
		element.click();
	}
	
	//Retail Item Excise Duty Relationships
	public static void exciseDutyRelationships(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/excise-duty-relationship-list']"));
		element.click();
	}
	
	
	
	
	////////////////////Menu Assignment/////////////////////////////////////////////////////////////////////////////
	public static void menuAssignments(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/menu-assignment-list']"));
		element.click();
	}
	
	//Manage Rules
	public static void manageMenuRules(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/menu-rules']"));
		element.click();
	}
	
	
	
	////////////////////Menu-Catering Station Relationship/////////////////////////////////////////////////////////////////////////////
	
	//Manage Relationships
	public static void manageRelationships(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/menu-relationship-list']"));
		element.click();
	}
	
	//Create Relationship
	public static void createRelationship(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/menu-relationship-create']"));
		element.click();
	}
	
	
	
	////////////////////Menu Management/////////////////////////////////////////////////////////////////////////////
	
	//Manage Menus
	public static void manageMenus(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//a[@href='/#/menu-list']"), 5);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//a[@href='/#/menu-list']"), 5);
		element.click();
	}
	
	//Create Menu
	public static void createMenu(WebDriver driver) {
		//element = driver.findElement(By.xpath("//div[text()='Create Menu']"));
		element = driver.findElement(By.xpath("//a[@href='/#/menu/create']"));
		element.click();
	}
	
	
	
	////////////////////Post Trip Data/////////////////////////////////////////////////////////////////////////////
	
	//Manage Post Trip Data
	public static void managePostTripData(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//a[@href='/#/post-trip-data-list']"), 3);
		ExplicitWait.waitForElement_Clickable(driver, By.xpath("//a[@href='/#/post-trip-data-list']"), 3);
		element = driver.findElement(By.xpath("//a[@href='/#/post-trip-data-list']"));
		element.click();
	}
	
	public static void createPostTripData(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//a[@href='/#/post-trip-data/create']"), 5);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//a[@href='/#/post-trip-data/create']"), 5);
		element.click();
	}

	
	
	
	////////////////////Promotion Management/////////////////////////////////////////////////////////////////////////////
	
	//Manage Promotions
	public static void managePromotions(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/promotions']"));
		element.click();
	}
	
	//Create Promotion
	public static void createPromotion(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/promotions/create']"));
		element.click();
	}
	
	//Promotion Category
	public static void promotionCategory(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/promotion-category-list']"));
		element.click();
	}
	
	//Promotion Catalog
	public static void promotionCatalog(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/promotion-catalog-list']"));
		element.click();
	}
	
	
	
	
	////////////////////Receipt Rule/////////////////////////////////////////////////////////////////////////////
	
	//Manage Receipt Rules
	public static void manageReceiptRules(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/receipt-rules']"));
		element.click();
	}
	
	
	
	
	////////////////////Reconciliation/////////////////////////////////////////////////////////////////////////////
	
	//Reconciliation Dashboard
	public static void reconciliationDashboard(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/reconciliation-dashboard']"));
		element.click();
	}
	
	//Relate ePOS Created Store
	public static void relateEposCreatedStore(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/manual-ecs']"));
		element.click();
	}
	
	
	
	
	////////////////////Reports/////////////////////////////////////////////////////////////////////////////
	
	//Reports
	public static void reports(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/reports']"));
		element.click();
	}
	
	//Queue
	public static void Queue(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/reports/queue']"));
		element.click();
	}
	
	//Scheduled Reports
	public static void scheduledReports(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/reports/scheduled-reports']"));
		element.click();
	}
	
	
	
	
	////////////////////Retail Item Management/////////////////////////////////////////////////////////////////////////////
	
	//Manage Items
	public static void manageRetailItems(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/item-list']"));
		element.click();
	}
	
	//Create Item
	public static void createRetailItem(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//a[@href='/#/item-create']"), 10);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//a[@href='/#/item-create']"), 10);
		element.click();
		ExplicitWait.waitForElement_Invisible(driver, By.id("loading"), 7);
	}
	
	//Manage Categories
	public static void manageRetailCategories(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/item-list']/parent::div/parent::div//div[3]"));
		element.click();
	}
	
	
	
	
	
	////////////////////Schedule Management/////////////////////////////////////////////////////////////////////////////
	
	//Manage Schedules
	public static void manageSchedules(WebDriver driver) throws Exception {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//a[@href='/#/schedules']"), 3);
		ExplicitWait.waitForElement_Clickable(driver, By.xpath("//a[@href='/#/schedules']"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//a[@href='/#/schedules']"), 5);
		element.click();
		Thread.sleep(2000);
	}
	
	
	
	
	////////////////////StockOwner Item Management/////////////////////////////////////////////////////////////////////////////
	
	//Manage Items
	public static void stockOwnerItemManagement(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/stock-owner-item-list']"));
		element.click();
	}
	
	//Create Item
	public static void stockOwnerCreateItem(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/stock-owner-item-create']"));
		element.click();
	}
	
	//Manage Categories
	public static void stockOwnerManageCategories(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/stock-owner-item-list']/parent::div/parent::div/div[3]"));
		element.click();
	}
	
	
	
	

	////////////////////Stock Manager/////////////////////////////////////////////////////////////////////////////
	
	//Stock Dashboard
	public static void stockDashboard(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//a[@href='/#/stock-dashboard']"), 3);
		ExplicitWait.waitForElement_Clickable(driver, By.xpath("//a[@href='/#/stock-dashboard']"), 3);
		element = driver.findElement(By.xpath("//a[@href='/#/stock-dashboard']"));
		element.click();
	}
	
	//Stock Take Report
	public static void stockTakeReport(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//a[@href='/#/stock-take-report']"), 3);
		ExplicitWait.waitForElement_Clickable(driver, By.xpath("//a[@href='/#/stock-take-report']"), 3);
		element = driver.findElement(By.xpath("//a[@href='/#/stock-take-report']"));
		element.click();
	}
	
	//Manage Goods Received
	public static void manageGoodsReceived(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/manage-goods-received']"));
		element.click();
	}
	
	//Create Delivery Note
	public static void createDeliveryNote(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/lmp-delivery-note/create']"));
		element.click();
	}
	
	
	
	
	////////////////////Manage Store Number/////////////////////////////////////////////////////////////////////////////
	
	//Store Number Create
	public static void storeNumberCreate(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/store-number']"));
		element.click();
	}
	
	

	
	
	////////////////////Station Operations/////////////////////////////////////////////////////////////////////////////
	
	//Store Dispatch
	public static void storeDispatch(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/store-instance-create/dispatch']"));
		element.click();
	}
	
	//Store Instance Dashboard
	public static void storeInstanceDashboard(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/store-instance-dashboard']"));
		element.click();
	}
	
	
	
	
	////////////////////Survey Management/////////////////////////////////////////////////////////////////////////////
	
	//Survey
	public static void survey(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/survey']"));
		element.click();
	}
	
	//Survey Catalog
	public static void surveyCatalog(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/survey-catalog']"));
		element.click();
	}
	
	//Survey Question
	public static void surveyQuestions(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/survey-questions']"));
		element.click();
	}
	
	
	
	
	
	////////////////////Tax Management/////////////////////////////////////////////////////////////////////////////
	public static void manageTaxes(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/tax-rates']"));
		element.click();
	}
	
	
	
	
	////////////////////Transaction Retrieval/////////////////////////////////////////////////////////////////////////////

	//Manage Transactions
	public static void manageTransactions(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/#/transactions']"));
		element.click();
	}

}
