package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	
	static WebDriver driver;
	static WebElement element;
	
//	public ExplicitWait(WebDriver driver) {
//		//driver = driver;
//	}
	
	public static WebElement waitForElement_Visible(WebDriver driver, By locator, int timeout) {  //locator example = By.name("menuCode")
		WebElement element = null;
		try {
			//System.out.println("Waiting for max:: " + timeout + " seconds for element to be available");
			
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element = wait.until(
					ExpectedConditions.visibilityOfElementLocated(locator));
			//System.out.println("Element appeared on the web page");	
		} catch(Exception e) {
			System.out.println(locator + " not appeared on the web page - Visibility Wait");
		}
		return element;
	}
	
	
	public static WebElement waitForElement_Clickable(WebDriver driver, By locator, int timeout) {
		WebElement element = null;
		try {
			//System.out.println("Waiting for max:: " + timeout + " seconds for element to be available");
			
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element = wait.until(
					ExpectedConditions.elementToBeClickable(locator));
			//System.out.println("Element appeared on the web page");	
		} catch(Exception e) {
			System.out.println(locator + " not appeared on the web page - Clickable Wait");
		}
		return element;
	}
	
//	Example of it used in a test case:
//	element = ExplicitWait.waitForElement_Clickable(driver, By.name("EffectiveStartDate"), 3);
//	element.click();
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	public static Boolean waitForElement_Selectable(WebDriver driver, By locator, int timeout) {
		Boolean element = null;

		try {
			//System.out.println("Waiting for max:: " + timeout + " seconds for element to be available");
			
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element = wait.until(
					ExpectedConditions.elementSelectionStateToBe(locator, true));
			//System.out.println("Element appeared on the web page");	
		} catch(Exception e) {
			System.out.println(locator + " not appeared on the web page - Selectable Wait");
		}
		return element;
	}
	
	
	
	public static Boolean waitForElement_Invisible(WebDriver driver, By locator, int timeout) {
		Boolean element = null;
		try {		
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element = wait.until(
					ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch(Exception e) {
			System.out.println(locator + " not appeared on the web page - Invisible Wait");
		}
		return element;
	}
	
	
	

	public static void waitForAttributeChanged(WebDriver driver, By locator, String attr, String initialValue, int timeout) {
	    WebDriverWait wait = new WebDriverWait(driver, timeout);

	    wait.until(new ExpectedCondition<Boolean>() {           
	        private By locator;
	        private String attr;
	        private String initialValue;

	        private ExpectedCondition<Boolean> init( By locator, String attr, String initialValue ) {
	            this.locator = locator;
	            this.attr = attr;
	            this.initialValue = initialValue;
	            return this;
	        }

	        public Boolean apply(WebDriver driver) {
	            WebElement button = driver.findElement(this.locator);
	            String enabled = button.getAttribute(this.attr);
	            System.out.println("The attribute is: " + enabled);
	            if(enabled.equals(this.initialValue)) 
	                return false;
	            else
	                return true;
	        }
	    }.init(locator, attr, initialValue));
	}
	

}
