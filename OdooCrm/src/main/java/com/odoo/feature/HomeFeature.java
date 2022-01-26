package com.odoo.feature;

import org.openqa.selenium.WebDriver;

import com.odoo.steps.HomeSteps;


public class HomeFeature
{
//anas
	HomeSteps hs;
	public HomeFeature(WebDriver driver)
	{
		
	    hs=new HomeSteps(driver);
	}
	
	
	public void verifyHomePage(String username)
	{
		hs.verifyCRM();
		hs.verifyUsername(username);
	}
}
