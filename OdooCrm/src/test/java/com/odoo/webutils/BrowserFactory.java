package com.odoo.webutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.odoo.generic.GenericLib;
import io.github.bonigarcia.wdm.WebDriverManager;



public class BrowserFactory
{

public static WebDriver launchBrowser(String platformName,String browserName, String headless) 
{
		
		WebDriver driver=null;
		//String platformName=System.getProperty("platform");
		
		if(platformName.equalsIgnoreCase("windows") || platformName.contains("win"))
		{
			if(browserName.equalsIgnoreCase("chrome"))
			 {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver(ChromeCapabilities.getChromeCapabilties(headless));
			 }
			
			else if(browserName.equalsIgnoreCase("ie"))
			{
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}
			
			else if(browserName.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(FirefoxCapabilities.getFirefoxCapabilties(headless));
			}
		}
		
		else if(platformName.equalsIgnoreCase("linux") || platformName.contains("ubantu"))
		{
			if(browserName.equalsIgnoreCase("chrome"))
			 {
			    WebDriverManager.chromedriver().setup();
			    driver= new ChromeDriver(ChromeCapabilities.getChromeCapabilties(headless));
			 }
			
			else if(browserName.equalsIgnoreCase("ie"))
			{
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}
			
			else if(browserName.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(FirefoxCapabilities.getFirefoxCapabilties(headless));
			}
		}
		
		else if(platformName.equalsIgnoreCase("mac"))
		{
			if(browserName.equalsIgnoreCase("chrome"))
			 {
			   WebDriverManager.chromedriver().setup();
			   driver= new ChromeDriver(ChromeCapabilities.getChromeCapabilties(headless));
		     }
			
			else if(browserName.equalsIgnoreCase("ie"))
			{
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}
			
			else if(browserName.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(FirefoxCapabilities.getFirefoxCapabilties(headless));
			
			}
		}
		return driver;
}
}
