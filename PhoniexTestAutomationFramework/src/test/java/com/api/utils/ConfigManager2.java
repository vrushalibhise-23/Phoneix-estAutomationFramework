package com.api.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager2 {
	
	private static Properties prop = new Properties();
	private static String path ="config/config.properties";
	private static String env;
	
	private ConfigManager2() {
		
	}
	static {
		env=System.getProperty("env","qa");
		env=env.toLowerCase().trim();
		
		switch(env) {
		case"dev" ->path ="config/config.dev.properties";
		case"qa"->path ="config/config.qa.properties";
		case"uat"->path ="config/config.uat.properties";
		default->path="config/config.properties";
		}
		
		
		
		
		InputStream input =Thread.currentThread().getContextClassLoader().getSystemResourceAsStream(path);
		
		if(input==null) {
			throw new RuntimeException("cannot find the path"+path);
		}
		
		try {
			
			prop.load(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getproperty(String key) throws IOException {
	
	
	
	
	
	return prop.getProperty("BASE_URI");
	
	
	
	
}

	
}
