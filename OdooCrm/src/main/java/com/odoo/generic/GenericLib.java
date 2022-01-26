package com.odoo.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GenericLib 
{

	public static String dir= System.getProperty("user.dir");
	public static String os= System.getProperty("os.name");
	
	public static String getValue(String filepath, String key)
	{
		String value = null;
		try
		{
			Properties prop = new Properties();
		    prop.load(new FileInputStream(new File(filepath)));
            value = prop.getProperty(key);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return value;
		}
	
	public static void storeProperties(Properties prop, String filepath)
	{
		try 
		{
		 prop.store(new FileOutputStream(new File(filepath)), "writing properties file");
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
