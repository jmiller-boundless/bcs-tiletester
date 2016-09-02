package com.boundlessgeo.bcs.tiletester.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	 
 
    public static String connection_url;
	
	public static final Properties prop = new Properties();
	static{
		InputStream input = null;
		try {

			input = new FileInputStream("config.properties");

			// load a properties file
			prop.load(input);
			connection_url = "jdbc:postgresql://" + prop.getProperty("DATABASE_SERVER") + "/" + prop.getProperty("DATABASE_NAME");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	
}