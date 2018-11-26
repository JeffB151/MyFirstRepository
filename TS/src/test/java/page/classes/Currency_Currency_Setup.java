package page.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.Commons;
import utilities.ExplicitWait;

public class Currency_Currency_Setup {
	
	static WebDriver driver;
	static WebElement element;
	static String fullText;
	static String splitText[];
	static String baseCurrency;
	static Actions action;
	static boolean currencyExists;
	static int count;
	static int i;
	static String currency;
	static int OpCurrencySize;
	static String opCurrency;
	static String OpCurrencyChecked;
	static int opCount;
	static int size;
	static int row;
	static Random random;
	static DecimalFormat df;
	static String exchangeRate;

	
	
	public static void filter_button_Expand(WebDriver driver) {
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//span[text()='Filter']"), 3);
		element.click();
	}
	
	public static void search_Button_Click (WebDriver driver) {
		element = ExplicitWait.waitForElement_Clickable(driver, By.id("searchDetailedCompanyCurrencyId"), 3);
		element.click();
	}
	
	
	public static String get_Base_Currency(WebDriver driver) {
		ExplicitWait.waitForElement_Invisible(driver, By.xpath("//p[text()='Loading Data']"), 3);
		element = driver.findElement(By.xpath("//div[@class='panel-heading text-right ng-binding']"));
		fullText = element.getText();
		splitText = fullText.split(" ");
		baseCurrency = splitText[2];
		//System.out.println("The Base Currency is: " + baseCurrency);
		return baseCurrency;
	}
	

	public static void navigate_to_ePOS_Exchange_Rate_Page(WebDriver driver) {
		action = new Actions(driver);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//ul[@class='navbar']/li[2]"), 3);
		action.moveToElement(element).perform();
		
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath("//ul[@class='navbar']//p[text()='ePOS Exchange Rate']"), 3);
		action.moveToElement(element).click().perform();
		ExplicitWait.waitForElement_Invisible(driver, By.xpath("//p[text()='Loading Data']"), 3);
	}
	
	public static int accepted_Currency_Size(WebDriver driver) {
		i = 0;
		currencyExists = driver.findElements(By.id("currencyId-" + i + "")).size() != 0;

		while (currencyExists == true) {
			i++;
			currencyExists = driver.findElements(By.id("currencyId-" + i + "")).size() != 0;
		}
		size = i+1;
		System.out.println("The Accepted Currency row size is: " + size);
		return size;
	}
	
	public static int operating_Currency_Size(WebDriver driver) {
		i = 0;
		currencyExists = driver.findElements(By.id("currency-" + i + "")).size() != 0;
		
		while (currencyExists == true) {
			element = driver.findElement(By.xpath("//div[@id='currency-" + i + "']//div[@class='checkbox']//input"));
			OpCurrencyChecked = element.getAttribute("aria-checked");
			
			if (OpCurrencyChecked.equals("true")) {
				element = driver.findElement(By.xpath("//select[@id='currencyId-" + i + "']/option[@selected='selected'][2]"));
				currency = element.getText();
				//System.out.println("The Operating Currency is: " + currency);
				OpCurrencySize = opCount++;
			}
			i++;
			currencyExists = driver.findElements(By.id("currency-" + i + "")).size() != 0;
			
		}
		System.out.println("The Operating Currency size is: " + OpCurrencySize);
		return OpCurrencySize;
	}
	

	
	public static String get_Available_Accepted_Currency (WebDriver driver, int rowNum) {
		row = rowNum - 1;
		element = driver.findElement(By.xpath("//select[@id='currencyId-" + row + "']/option[@selected='selected'][2]"));
		currency = element.getText();
		return currency;
	}
	
	/*
	public static String get_Available_Accepted_Currencies(WebDriver driver) {
		i = 0;
		currencyExists = driver.findElements(By.id("currencyId-"+i+"")).size() != 0;
		
		while(currencyExists == true) {
			element = driver.findElement(By.xpath("//select[@id='currencyId-" +i+ "']/option[@selected='selected'][2]"));
			currency = element.getText();
			count = i++;
			currencyExists = driver.findElements(By.id("currencyId-"+i+"")).size() != 0;
			System.out.println("Currency " + i + " is: " + currency);
		}
		System.out.println("The Currency size is: " + count);
		return currency;
	}
	*/
	

	
	
	public static void readWriteExcel (WebDriver driver) {
		try {
			// Specify the file path which you want to create or write
			File src = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\exchangeRateUpload.xlsx");
			
			// Load the file
			FileInputStream fis = new FileInputStream(src);
			
			// load the workbook
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// get the sheet which you want to modify or create
			XSSFSheet sh1 = wb.getSheetAt(0);
		
			//int Cols = sh1.getRow(0).getLastCellNum();
			
			Row row = null;
			for (int r = 1; r < Currency_Currency_Setup.size; r++) {
				if (sh1.getRow(r) != null) {
					row = sh1.getRow(r);
				} else {
					row = sh1.createRow(r);
				}
			}
				
			for (int i = 1; i < Currency_Currency_Setup.size; i++) {
				
				//Operating Currency:
				sh1.getRow(i).createCell(0).setCellValue(Currency_Currency_Setup.baseCurrency);

				//Accepted Currency:
				sh1.getRow(i).createCell(1).setCellValue(Currency_Currency_Setup.get_Available_Accepted_Currency(driver, i));
				
				//Start Date:
				sh1.getRow(i).createCell(2).setCellValue(Commons.fileUpload_Date_yyyyMMdd(2));
				
				//End Date:
				sh1.getRow(i).createCell(3).setCellValue(Commons.fileUpload_Date_yyyyMMdd(3));
				
				//Exchange Rate:
				
				if(Currency_Currency_Setup.baseCurrency.equals(Currency_Currency_Setup.get_Available_Accepted_Currency(driver, i))) {
					sh1.getRow(i).createCell(4).setCellValue("1.0000");
				}else {
					df = new DecimalFormat("#.####");
					double rangeMin = 0.0001;
					double randeMax = 10.0000;
					random = new Random();
					
					double val = rangeMin + (randeMax - rangeMin) * random.nextDouble();
					exchangeRate = df.format(val);
					
					sh1.getRow(i).createCell(4).setCellValue(exchangeRate);
				}
				
			}
			
			//////////////////////////////////////////////////
			/*
			 * The Template file has 2 example rows.  If the desired company only uses one currency,
			 * we must remove that 2nd example row from the template.
			 */
			if (Currency_Currency_Setup.size < 3) {
				System.out.println("Removing the 2nd row.");
				sh1.shiftRows(3, 3, -1);
			}

			/////////////////////////////////////////////////
			
			
			// here we need to specify where you want to save file
			FileOutputStream fout = new FileOutputStream(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\exchangeRateUpload.xlsx"));

			// finally write content
			wb.write(fout);

			// close the file
			fout.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		
	}
	
}
