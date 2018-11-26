package base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
 
public class ConfigFileReader {
	
	
	private Properties properties;
	private final String propertyFilePath= System.getProperty("user.dir") + "\\src\\test\\java\\base\\configuration.properties";
 
	
	public ConfigFileReader(){
		
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	
	public String getApplicationUrl() {
		String url = properties.getProperty("baseURL");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getBrowserType(){
		String browserType = properties.getProperty("browser");
		if(browserType!= null) return browserType;
		else throw new RuntimeException("browserType not specified in the Configuration.properties file.");		
	}
	
	public String loginUserName(){
		String username = properties.getProperty("userName");
		if(username!= null) return username;
		else throw new RuntimeException("Username not specified in the Configuration.properties file.");		
	}
	
	public String loginPassWord(){
		String password = properties.getProperty("passWord");
		if(password!= null) return password;
		else throw new RuntimeException("Password not specified in the Configuration.properties file.");		
	}
	
	public String getBrowserTypeDC() {
		String browserTypeDC = properties.getProperty("browserDC");
		if(browserTypeDC!= null) return browserTypeDC;
		else throw new RuntimeException("browserTypeDC not specified in the Configuration.properties file.");	
	}
	
}