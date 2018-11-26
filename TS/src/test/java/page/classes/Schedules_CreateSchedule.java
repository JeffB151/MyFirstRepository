package page.classes;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Schedules_CreateSchedule {
	
	static WebElement element = null;
	public static String scheduleNumerOutput;
	
	public static void schedule_Number_Field (WebDriver driver) {
		Random random = new Random();
		int ranNum = 1100 + random.nextInt(9999);
		element = driver.findElement(By.id("schedule-number"));
		scheduleNumerOutput = String.valueOf(ranNum);
		System.out.println("The Schedule Number is: " + scheduleNumerOutput);
	}
	
	

}
