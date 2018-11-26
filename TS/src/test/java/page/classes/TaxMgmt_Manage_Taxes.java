package page.classes;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.ExplicitWait;

public class TaxMgmt_Manage_Taxes {
	
	static WebElement element = null;
	static Random random = new Random();
	static List<WebElement> ele;
	static int size;
	static int value;
	static String country;
	static String fullBaseStation;
	static String baseStation;
	static String[] split;
	
	
	public static void expand_Search(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.id("filterTaxRatesId"), 5);
		ExplicitWait.waitForElement_Clickable(driver, By.id("filterTaxRatesId"), 5);
		element = driver.findElement(By.id("filterTaxRatesId"));
		element.click();
	}
	
	
	public static String get_Country(WebDriver driver) {
		
		//Clear
		ExplicitWait.waitForElement_Visible(driver, By.id("clearTaxRatesId"), 5);
		ExplicitWait.waitForElement_Clickable(driver, By.id("clearTaxRatesId"), 5);
		element = driver.findElement(By.id("clearTaxRatesId"));
		element.click();
		
		//Country - initial click
		ExplicitWait.waitForElement_Visible(driver, By.name("searchCountry"), 5);
		ExplicitWait.waitForElement_Clickable(driver, By.name("searchCountry"), 5);
		element = driver.findElement(By.name("searchCountry"));
		element.click();
		
		//get Country list
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//a[@class='ui-select-choices-row-inner']"), 5);
		ExplicitWait.waitForElement_Clickable(driver, By.xpath("//a[@class='ui-select-choices-row-inner']"), 5);
		ele = driver.findElements(By.xpath("//a[@class='ui-select-choices-row-inner']"));
		size = ele.size();
		System.out.println("The size is: " + size);
		
		value = 3 + random.nextInt(size);
		
		element = driver.findElement(By.xpath("//div[" + value + "]/a[1]/div[1]"));
		country = element.getText();
		element.click();
		System.out.println("The Country is: " + country);
		return country;
	}
	
	public static String get_Base_Station(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//div[@ng-model='search.stations']"), 5);
		ExplicitWait.waitForElement_Clickable(driver, By.xpath("//div[@ng-model='search.stations']"), 5);
		element = driver.findElement(By.xpath("//div[@ng-model='search.stations']"));
		element.click();
		
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//a[@class='ui-select-choices-row-inner']"), 5);
		ExplicitWait.waitForElement_Clickable(driver, By.xpath("//a[@class='ui-select-choices-row-inner']"), 5);
		ele = driver.findElements(By.xpath("//a[@class='ui-select-choices-row-inner']"));
		size = ele.size();
		System.out.println("The base station size is: " + size);
		
		value = 3 + random.nextInt(size);
		
		element = driver.findElement(By.xpath("//div[" + value + "]/a[1]/div[1]"));
		fullBaseStation = element.getText();
		split = fullBaseStation.split(" ");
		baseStation = split[0];
		System.out.println("The base station is: " + baseStation);
		return baseStation;
	}

	


}
