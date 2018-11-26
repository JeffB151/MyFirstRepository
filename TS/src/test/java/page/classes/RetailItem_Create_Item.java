package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utilities.ExplicitWait;

public class RetailItem_Create_Item {
	
	
	static WebElement element;
	static Boolean imageExists;
	static Boolean expected;
	static Boolean actual;
	
	
	public static void image_upload_Box_Click(WebDriver driver) {
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath(
				"//div[@class='form-group upload-container']/div[@ngf-drag-over-class='dragover']"), 3);
		element.click();
	}
	
	public static void upload_Button_Click(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath(
				"//div[@class='form-group upload-container']//button[@class='btn button btn-success ng-pristine ng-untouched ng-valid'][contains(text(),'Upload')]"), 3);
		element = ExplicitWait.waitForElement_Clickable(driver, By.xpath(
				"//div[@class='form-group upload-container']//button[@class='btn button btn-success ng-pristine ng-untouched ng-valid'][contains(text(),'Upload')]"), 5);
		element = driver.findElement(By.xpath(
				"//div[@class='form-group upload-container']//button[@class='btn button btn-success ng-pristine ng-untouched ng-valid'][contains(text(),'Upload')]"));
		element.click();
	}
	
	public static boolean is_Thumbnail_present(WebDriver driver) {
		ExplicitWait.waitForElement_Visible(driver, By.xpath("//img[@class='item-image-thumbnail']"), 5);
		imageExists = driver.findElements(By.xpath("//img[@class='item-image-thumbnail']")).size() != 0;
		if(imageExists == true) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void assert_Item_Image_Upload(WebDriver driver) {
		Assert.assertTrue(imageExists);
	}
	

}
