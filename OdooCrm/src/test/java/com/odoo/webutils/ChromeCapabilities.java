package com.odoo.webutils;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeCapabilities 
{

	public static ChromeOptions getChromeCapabilties(String headless)
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.setHeadless(Boolean.parseBoolean(headless));
		return options;
	}
}
