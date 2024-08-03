package com.Fitpeo.utlities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties prop;

	public ConfigDataProvider() {
		File file=new File("./src/test/resources/config/config.properties");
		System.out.println();
		try {
			
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			
				prop.load(fis);
			
			}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getBrowser() {
		return prop.getProperty("browser");
	}

	public String getUrl() {
		return prop.getProperty("url");
	}
	
	public String getHomePageTitle() {
		return prop.getProperty("homePage-Title");
	}
	
}
