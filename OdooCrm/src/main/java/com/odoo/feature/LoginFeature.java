package com.odoo.feature;

import org.openqa.selenium.WebDriver;


import com.odoo.steps.LoginSteps;

public class LoginFeature
{
//we all
LoginSteps ls;

	public LoginFeature(WebDriver driver)
	{
		ls=new LoginSteps(driver);
	  
	}
	
	
	public void login(String username, String password)
	{
		ls.enterUserName(username);
		ls.enterPassword(password);
		ls.clickLoginButton();
	}
	
	
}
