package base;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserSetup {
	
	public static ConfigFileReader configFileReader = new ConfigFileReader();
	static WebDriver driver = null;
	
	
	public static WebDriver initialize() throws Exception{
		String browser = configFileReader.getBrowserType();
		if (browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
			driver = new ChromeDriver();	
		}
		else if (browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();	
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();	
		}
		driver.manage().window().maximize();
		driver.get(configFileReader.getApplicationUrl());
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		return driver;
	}
	
	public static WebDriver initializeDC() {
		String browserDC = configFileReader.getBrowserTypeDC();
		if (browserDC.equalsIgnoreCase("chromeDC")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
			
			String downloadDir = System.getProperty("user.dir") + "\\src\\test\\resources";
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadDir);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			options.setAcceptInsecureCerts(true);
			options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
			driver = new ChromeDriver(options);
			
//			DesiredCapabilities cap = DesiredCapabilities.chrome();
//			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//			cap.setCapability(ChromeOptions.CAPABILITY, options);
//			driver = new ChromeDriver(cap);
			
		}
		driver.manage().window().maximize();
		driver.get(configFileReader.getApplicationUrl());
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		return driver;
	}

}
