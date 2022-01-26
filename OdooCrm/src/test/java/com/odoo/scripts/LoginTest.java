package com.odoo.scripts;


import org.testng.annotations.Test;


import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;

public class LoginTest extends BaseAbstractTest  
{

	

	@Test
	public void validlogin()
	{
		ExcelUtilities eu = new ExcelUtilities(GenericLib.dir+"/testdata/datarepo.xlsx");
		String[] value = eu.readData("validLogin_ID", "Sheet1");
		lf.login(value[1], value[2]);
		hf.verifyHomePage(value[1]);
	}
}
