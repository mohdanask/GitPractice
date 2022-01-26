package com.odoo.webutils;


import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxCapabilities 
{

	public static FirefoxOptions getFirefoxCapabilties(String headless)
	{
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--disable-notifications");
		options.setHeadless(Boolean.parseBoolean(headless));
		return options;
	}
}
