package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utilities.ExplicitWait;

public class Currency_ePOS_Exchange_Rate {

	static WebDriver driver;
	static WebElement element;
	static Select select;
	static String OpCurrency;
	static String value;
	static boolean currencyExists;
	static boolean ExchangeRateExists;
	static boolean deleteButtonExists;
	static int count;
	static int i;
	static String currency;
	static Actions action;
	static String beforeExchangeRate;
	static String baseCurrency;
	static String afterExchangeRate;
	
	
	public static void navigate_to_Currency_Setup_Page(WebDriver driver) throws Exception {
		action = new Actions(driver);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//ul[@class='navbar']/li[1]"), 3);
		action.moveToElement(element).perform();

		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//ul[@class='navbar']//p[text()='Currency Setup']"), 3);
		action.moveToElement(element).click().perform();
		ExplicitWait.waitForElement_Invisible(driver, By.xpath("//p[text()='Loading Data']"), 3);
	}
	
	
	public static String select_Operating_Currency (WebDriver driver) throws Exception {
		ExplicitWait.waitForElement_Clickable(driver, By.id("search-operating-currency"), 3);
		element = driver.findElement(By.id("search-operating-currency"));
		select = new Select(element);
		select.selectByVisibleText(Currency_Currency_Setup.baseCurrency);
		OpCurrency = Currency_Currency_Setup.baseCurrency;
		//System.out.println("OpCurrency: " + OpCurrency);
		return OpCurrency;
	}
	
	
	public static void search_Button (WebDriver driver) throws Exception {
		element = ExplicitWait.waitForElement_Clickable(driver, By.id("searchCompanyExchangeRateId"), 3);
		element.click();
	}
	
	public static void import_File_Down_Arrow(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//i[@class='fa fa-caret-down']"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//i[@class='fa fa-caret-down']"), 3);
		element.click();
	}
	
	public static void download_Template (WebDriver driver) throws Exception {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//a[text()='Download Template']"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//a[text()='Download Template']"), 3);
		element.click();
	}
	
	public static int accepted_Currency_Size (WebDriver driver) {
		i = 0;
		currencyExists = driver.findElements(By.id("exchange-rate-"+i+"")).size() != 0;
		
		while(currencyExists == true) {
			count = i++;
			currencyExists = driver.findElements(By.id("exchange-rate-"+i+"")).size() != 0;
		}
		System.out.println("The Accepted Currency size is: " + count);
		return count;
	}
	
	
	public static void check_For_Future_Exchange_Rates(WebDriver driver) {
		int i = 0;
		ExchangeRateExists = driver.findElements(By.id("exchange-rate-0")).size() != 0;

		while (ExchangeRateExists == true) {
			deleteButtonExists = driver.findElements(By.xpath("//tr[@id='exchange-rate-" + i + "']/td[@ng-show='isCRUD']/button[@class='btn btn-danger btn-xs']")).size() != 0;
			
			if (deleteButtonExists == true) {
				element = driver.findElement(By.xpath("//tr[@id='exchange-rate-" + i + "']/td[@ng-show='isCRUD']/button[@class='btn btn-danger btn-xs']"));
				element.click();

				// Pop-Up:
				ExplicitWait.waitForElement_Invisible(driver, By.xpath("//p[text()='Loading Data']"), 3);
				element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//button[@ng-click='deleteCompanyExchangeRate()']"), 3);
				element.click();

				//Reset i to 0:
				i = 0;
				ExchangeRateExists = driver.findElements(By.id("exchange-rate-" + i + "")).size() != 0;
			}else {
				i++;
				ExchangeRateExists = driver.findElements(By.id("exchange-rate-" + i + "")).size() != 0;
			}
		}
	}

	
	
	
	public static String get_Exchange_Rate_First_Currency (WebDriver driver) throws Exception {
		element = ExplicitWait.waitForElement_Visible(driver, By.xpath("//tr[1]/td[4]/div[1]/input[1]"), 3);
		beforeExchangeRate = element.getAttribute("value");
		System.out.println("The Previous exchange rate was: " + beforeExchangeRate);
		return beforeExchangeRate;
	}
	
	public static void import_From_File_Button_Click(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//span[text()='Import From File']"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//span[text()='Import From File']"), 3);
		element.click();
	}
	
	public static void upload_Button_Click (WebDriver driver) throws Exception {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//button[text()='Upload']"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//button[text()='Upload']"), 3);
		element.click();
		Thread.sleep(10000);
		driver.navigate().refresh();
	}
	
	public static void assert_Exchange_Rate (WebDriver driver) {
		element = ExplicitWait.waitForElement_Visible(driver, By.xpath("//tr[1]/td[4]/div[1]/input[1]"), 3);
		afterExchangeRate = element.getAttribute("value");
		System.out.println("The new exchange rate is: " + afterExchangeRate);
		
		if (beforeExchangeRate.equals("1.0000")) {
			/*
			 * For companies with only one currency.
			 */
			Assert.assertEquals(beforeExchangeRate, afterExchangeRate);
		}else {
			/*
			 * For companies with multiple currencies.
			 */
			Assert.assertNotEquals(beforeExchangeRate, afterExchangeRate);
		}
	
	}
	
	
}
