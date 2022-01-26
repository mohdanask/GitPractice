package com.odoo.feature;

import org.openqa.selenium.WebDriver;

import com.odoo.steps.HomeSteps;


public class HomeFeature
{

	HomeSteps hs;
	public HomeFeature(WebDriver driver)
	{
		//Hello
	    hs=new HomeSteps(driver);
	}
	//hello2
	
	//hgggggggjbnnjkiijjjjkjkjkjkiuusdiz
	public void verifyHomePage(String username)
	{
		hs.verifyCRM();
		hs.verifyUsername(username);
	}
	
	
	public void verifyHomePage3(String username)
	{
		hs.verifyCRM();
		hs.verifyUsername(username);
		////fggggggggggggggggggggggggggggggggbmjjbutkujyggggggggggg
	}
	
}
