package com.odoo.webutils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;
import com.odoo.generic.Driver;
import com.odoo.generic.GenericLib;

public class MyTestListener implements ITestListener,WebDriverEventListener
{
	public Logger log;
	public static int executionCount,passCount,failCount,skipCount=0;
	public static long startTime,stopTime=0;

	@Override
	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		log.info("Finding webelement using Locator:"+by);
		
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onException(Throwable t, WebDriver arg1) {
		log.fatal(t.getMessage());
		
	}

	@Override
	public void onTestStart(ITestResult result) 
	{
		executionCount++;
		log.info(result.getName()+" script execution starts");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		passCount++;
		log.info(result.getName()+"script is passed");
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		failCount++;
		log.error(result.getName()+"Script is failed");
		TakesScreenshot ts=(TakesScreenshot)Driver.getDriver();
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(GenericLib.dir+"/screenshots/"+result.getName()+".png");
		try {
			Files.copy(srcFile, destFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		log.info("screenshot has been taken");
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		skipCount++;
		log.warn(result.getName()+" script is skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
	}

	@Override
	public void onStart(ITestContext context)
	{
		startTime=System.currentTimeMillis();
	PropertyConfigurator.configure("log4j.properties");
	log= Logger.getLogger("MyTestListener");
	log.info("framework execution starts");
	String platformName=System.getProperty("platform");
	String browserName=System.getProperty("browser");
	String headless=System.getProperty("headless");
	WebDriver driver = BrowserFactory.launchBrowser(platformName, browserName, headless);
	RemoteWebDriver rwd = (RemoteWebDriver)driver;
	String browserVersion = rwd.getCapabilities().getVersion();
	Driver.setDriver(driver);
	//to be continued
	}

	@Override
	public void onFinish(ITestContext context) {
		
		Driver.getDriver().quit();
		log.info("Framework execution ends");
		stopTime=System.currentTimeMillis();
		double totalTime = (stopTime-startTime)/1000;
		log.info("Framework total execution time : "+totalTime+"seconds");
		log.info("Total scripts executed : "+executionCount);
		log.info("Total script passed : "+passCount);
		log.info("Total script failed : "+failCount);
		log.info("total script skipped : "+skipCount);
	}

}
