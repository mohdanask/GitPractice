package com.odoo.webutils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumLib 
{

	WebDriver driver;
	
	public SeleniumLib(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void scrollIntoView(WebElement ele)
	{
		String jsCode ="arguments[0].scrollIntoView(true)";
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript(jsCode, ele);
	}
	
	public void jsClick(WebElement ele)
	{
		String jsCode = "arguments[0].click()";
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript(jsCode, ele);
	}
	
	public <T>List<T> convertSetToList(Set<T> st)
	{
		List<T> lt = new ArrayList<T>(st);
		return lt;
	}
	
	public List<String> getSessionIDs(Set<String> st)
	{
		return convertSetToList(st);
	}
	
	public void enterDataJS(WebElement ele , String input)
	{
		String jsCode ="arguments[0].setAttribute('value','"+input+"')";
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript(jsCode, ele);
		
	}
	
	public int selectDate(int plusDays)
	{
		int date=LocalDate.now().plusDays(plusDays).getDayOfMonth();
		return date;
	}
	
	public String selectMonth(int plusMonths)
	{
		String monthName=LocalDate.now().plusMonths(plusMonths).getMonth().name();
		monthName=monthName.substring(0,1)+monthName.substring(1).toLowerCase();
		return monthName;
	}
	
	public int getMonthIndex(int plusMonths)
	{
		int monthIndex= LocalDate.now().plusMonths(plusMonths).getMonthValue();
		return monthIndex;
	}
	
	public void iSleep(int Seconds)
	{
		try
		{
			Thread.sleep(Seconds*1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	public void waitForElementPresent(int seconds, By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	

	public void waitForElementVisible(int seconds, By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
}
