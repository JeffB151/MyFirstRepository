package base;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.ExplicitWait;

public class Commons {
	
	static Random random = new Random();
	static WebElement element;
	static int Date;
	static int HH;
	static int mm;
	static String joinedTime;
	

	public static String fileUpload_Date_yyyyMMdd(int addDays) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		// cal.roll(Calendar.DATE, true);
		cal.add(Calendar.DATE, addDays); // Adds days to the current date
		
		String date2 = dateFormat.format(cal.getTime());
		String newDate = date2.toString();
		//System.out.println("Date: " + newDate);
		return newDate;
	}
	
	
	public static String random_Time_Generator() {
		HH = 1 + random.nextInt(23);
		mm = 10 + random.nextInt(49);
		joinedTime = HH + ":" + mm;
		return joinedTime;
	}
	
	public static String random_Time_Generator_4Digits() {
		HH = 10 + random.nextInt(13);
		mm = 10 + random.nextInt(49);
		joinedTime = HH + ":" + mm;
		return joinedTime;
	}
	
	
	public static void choose_File_To_Import(String fileName) throws Exception {
		StringSelection ss = new StringSelection(System.getProperty("user.dir") + "\\src\\test\\resources\\" + fileName);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null); //Equivalent of CTRL C to copy.
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
public static int date_Picker_Search_Future_Date(WebDriver driver, By locator, int addDays) throws Exception {
		
		//ExplicitWait.waitForElement_Invisible(driver, ".//*[@id='loading']/div/div/div");
		ExplicitWait.waitForElement_Invisible(driver, By.id("loading"), 1);
		element = ExplicitWait.waitForElement_Clickable(driver, locator, 1);
		element.click();
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		// cal.roll(Calendar.DATE, true);
		cal.add(Calendar.DATE, addDays); // Adds days to the current date

		String newDate = dateFormat.format(cal.getTime());
		//System.out.println("Date: " + newDate);
		// Splits out the dd for the new date
		String dateSplit[] = newDate.split("/");
		//System.out.println("DateSplit: " + dateSplit[0]);

		// Convert string to int
		String ddNumber = dateSplit[0];
		int result = Integer.parseInt(ddNumber);
		//System.out.println("Start Date Result: " + result);

		List<WebElement> allDates = driver.findElements(By.tagName("td"));

		for(WebElement ele : allDates) {
			String classAtt = ele.getAttribute("class");
			//System.out.println("The Class Attribute is: " + classAtt);
			if (classAtt.equals("day") || classAtt.equals("new day")) {
				String  D = ele.getText();
				Date = Integer.parseInt(D);
				if (Date == result) {
					ele.click();
					break;
				}
			}
		}
		return Date;
	}

}
