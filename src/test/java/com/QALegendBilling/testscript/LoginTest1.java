package com.QALegendBilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QALegendBilling.automationcore.Base;
import com.QALegendBilling.constants.ErrorMessages;
import com.QALegendBilling.pages.HomePage1;
import com.QALegendBilling.pages.LoginPage1;
import com.QALegendBilling.utilities.ExcelUtility;

public class LoginTest1 extends Base {

	LoginPage1 login;
	HomePage1 home;

	@Test(priority = 1, enabled = true, description = "tc_001 verifyLoginPage", groups = { "Sanity" })
	public void tc_001_verifyLoginPage_Credentials() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expusername = data.get(0).get(1);
		String exppassword = data.get(1).get(1);
		login = new LoginPage1(driver);
		login.enterUsername(expusername);
		login.enterUserPassword(exppassword);
		home = login.clickonLoginButton();
		String actualuserAccountName = home.getUserAccountName();
		List<ArrayList<String>> data1 = ExcelUtility.excelDataReader("HomePage");
		String expuserAccountName = data1.get(0).get(1);
		Assert.assertEquals(actualuserAccountName, expuserAccountName, ErrorMessages.INVALID_EMAIL_ID);
	}
	
	

}
