package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	FileInputStream fis;
	Properties pro;
	
	public ReadConfig()
	{
		File source = new File("./Configuration/config.properties");
		
		try {
			
			fis = new FileInputStream(source);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception exceptionObject)
		{
			System.out.println("Exception is" + exceptionObject.getMessage());
		}
	}
	
	public String getApplicationURL ()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername ()
	{
		String username = pro.getProperty("username");
		return username;
	}
	
	public String getPassword ()
	{
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromepath ()
	{
		String chrome = pro.getProperty("chromepath");
		return chrome;
	}
	
	public String getfirefoxpath ()
	{
		String firefox = pro.getProperty("firefoxpath");
		return firefox;
	}
	
//	public String getCustomerUsername ()
//	{
//		String customerusername = pro.getProperty("customerusername");
//		return customerusername;
//	}

}
