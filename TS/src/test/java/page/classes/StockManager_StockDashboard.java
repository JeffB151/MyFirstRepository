package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilities.ExplicitWait;

public class StockManager_StockDashboard {
	
	static Select select;
	static Actions action;
	static WebElement element;
	static WebDriver driver;
	static String preImportCurrentCount;
	static String postImportCurrentCount;

	
	
	public static void select_LMP_Station(WebDriver driver, int LMPIndex) throws InterruptedException {
		Thread.sleep(300);
		element = ExplicitWait.waitForElement_Visible(driver, By.id("deliveryStation"), 3);
		select = new Select(element);	
		select.selectByIndex(LMPIndex);
	}
	
	public static void export_CSV_Click(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//span[text()='Export (CSV)']"), 5);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//span[text()='Export (CSV)']"), 3);
		element.click();
	}
	
	public static String pre_Import_Current_Count(WebDriver driver) {
		element = ExplicitWait.waitForElement_Visible(driver, By.xpath("//tr[1]/td[7]/input[1]"), 3);
		preImportCurrentCount = element.getAttribute("value");
		//System.out.println("The Pre-Import Current Count for the first item is: " + preImportCurrentCount);
		return preImportCurrentCount;
	}
	
	public static void navigate_to_Stock_Take_Report_Page(WebDriver driver) throws Exception {
		action = new Actions(driver);
		Thread.sleep(500);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//ul[@class='navbar']/li[2]"), 3);
		action.moveToElement(element).perform();
		
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//p[text()='Stock Take Report']"), 3);
		action.moveToElement(element).click().perform();
	}
	
	public static void assert_CurrentCount(WebDriver driver) {
		element = ExplicitWait.waitForElement_Visible(driver, By.xpath("//tr[1]/td[7]/input[1]"), 3);
		postImportCurrentCount = element.getAttribute("value");
		
		System.out.println("The old Current Count was: " + preImportCurrentCount);
		System.out.println("The new expected Current Count is: " + StockManager_StockTakeReport.expectedCount);
		System.out.println("The new actual Current Count is: " + postImportCurrentCount);
		
		Assert.assertEquals(StockManager_StockTakeReport.expectedCount, postImportCurrentCount);
	}
	
}
