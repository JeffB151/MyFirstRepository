package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.ConfigFileReader;
import utilities.ExplicitWait;

public class LoginPage {
	
	public static ConfigFileReader configFileReader = new ConfigFileReader();
	public static WebElement element;
	
	
	//Username
	public static void userName(WebDriver driver) {
		ExplicitWait.waitForElement_Clickable(driver, By.id("username"), 5);
		element = driver.findElement(By.name("username"));
		element.clear();
		element.sendKeys(configFileReader.loginUserName());
	}
	
	//Password
	public static void passWord(WebDriver driver) {
		ExplicitWait.waitForElement_Clickable(driver, By.id("password"), 5);
		element = driver.findElement(By.name("password"));
		element.clear();
		element.sendKeys(configFileReader.loginPassWord());
	}
	
	//Remember Password Checkbox
	public static void rememberPasswordCheckBox(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@type='checkbox']"));
		element.click();
	}
	
	//Login Button
	public static void clickLoginButton(WebDriver driver) {
		ExplicitWait.waitForElement_Clickable(driver, By.xpath("//button[text()='Login!']"), 5);
		element = driver.findElement(By.xpath("//button[text()='Login!']"));
		element.click();
	}

}
