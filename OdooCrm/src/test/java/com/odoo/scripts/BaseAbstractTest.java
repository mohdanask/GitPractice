package com.odoo.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.odoo.feature.HomeFeature;
import com.odoo.feature.LoginFeature;
import com.odoo.generic.Driver;
import com.odoo.webutils.MyTestListener;

public abstract class BaseAbstractTest 
{
public static EventFiringWebDriver driver;
//declare Feature classes
LoginFeature lf;
HomeFeature hf;
@BeforeClass
public void setUp()
{
	driver =new EventFiringWebDriver(Driver.getDriver());
	driver.register(new MyTestListener());
	driver.manage().window().maximize();
	
	//initialize Feature classes
	lf = new LoginFeature(driver);
	hf= new HomeFeature(driver);
}

@BeforeMethod
public void preCondition()
{
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get(System.getProperty("url"));
}
}
