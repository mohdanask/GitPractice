package com.odoo.generic;

import org.openqa.selenium.WebDriver;

public class Driver 
{

private	static WebDriver wDriver;
	
	public static void setDriver(WebDriver driver)
	{
		wDriver= driver;
	}
	
	public static WebDriver getDriver()
	{
		return wDriver;
	}
}
