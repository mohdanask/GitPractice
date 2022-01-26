package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.Reporter;

import com.odoo.pageobject.HomePage;

public class HomeSteps 
{
WebDriver driver;
HomePage hp;

public HomeSteps(WebDriver driver)
{
	this.driver=driver;
	hp= new HomePage();
}

public void verifyCRM()
{
	 boolean flag = driver.findElement(By.xpath(hp.crm)).isDisplayed();
	Assert.assertTrue(flag);
	Reporter.log("verified crm on homepage",true);
}

public void verifyUsername(String username)
{
	String actualValue = driver.findElement(By.xpath(hp.username)).getText();
	Assert.assertEquals(actualValue, username);
	Reporter.log("username is verified for homepage", true);
}

}
