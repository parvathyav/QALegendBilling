package com.QALegendBilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QALegendBilling.automationcore.Base;
import com.QALegendBilling.constants.ErrorMessages;
import com.QALegendBilling.pages.AddUserPage1;
import com.QALegendBilling.pages.HomePage1;
import com.QALegendBilling.pages.LoginPage1;
import com.QALegendBilling.pages.UserPage1;
import com.QALegendBilling.utilities.ExcelUtility;
import com.QALegendBilling.utilities.RandomUtility;

public class HomeTest1 extends Base {
	
	LoginPage1 login;
	HomePage1 home;
	AddUserPage1 adduser;
	UserPage1 user;

	@Test(priority = 1, enabled = true, description = "tc_003 verify userNavigationBacktoLoginpage", groups = { "Regression" })
	public void tc_003_verifyuserNavigationBacktoLoginpage() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expusername = data.get(0).get(1);
		String exppassword = data.get(1).get(1);
		String expLoginPageTitle = data.get(2).get(1);
		login = new LoginPage1(driver);
		
		login.enterUsername(expusername);
		login.enterUserPassword(exppassword);
		home = login.clickonLoginButton();
		home.clickonSignoutButton();
		
		String actLoginPageTitle = login.getLoginPageTitle();
		Assert.assertEquals(actLoginPageTitle, expLoginPageTitle, ErrorMessages.INVALID_EMAIL_ID);
	}

	@Test(priority = 5, enabled = true, description = "tc_003 verify UserManagementtabs ", groups = { "Smoke" })
	public void tc_004_verifyUserManagementtabs() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expusername = data.get(0).get(1);
		String exppassword = data.get(1).get(1);
		login = new LoginPage1(driver);

		login.enterUsername(expusername);
		login.enterUserPassword(exppassword);
		home = login.clickonLoginButton();
		home.clickonUserManagement();
		Boolean userStatus = home.checkUsersMenuIsDisplayed();
		Boolean roleStatus = home.checkRolesMenuIsDisplayed();
		Boolean scaStatus = home.checkSCAMenuIsDisplayed();
		Assert.assertTrue(userStatus, ErrorMessages.USER_MENU_NOT_FOUND);
		Assert.assertTrue(roleStatus, ErrorMessages.ROLES_MENU_NOT_FOUND);
		Assert.assertTrue(scaStatus, ErrorMessages.SCA_MENU_NOT_FOUND);

	}
	@Test(priority = 6, enabled = true, description = "tc_003 verify UserSearchwithvaliddata ", groups = { "Smoke" })
	public void tc_005_verifyUserSearchwithvaliddata()
	{
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expusername = data.get(0).get(1);
		String exppassword = data.get(1).get(1);
		List<ArrayList<String>> userdata = ExcelUtility.excelDataReader("AddUserPage");
		String expPrefix = userdata.get(0).get(1);
		String expscpercent = userdata.get(1).get(1);
		String fName = RandomUtility.getfName();
		String lName = RandomUtility.getlName();
		String uName = fName + lName;
		String password = fName + "@123";
		String confirmPassword = password;
		String eMail = RandomUtility.getRandomEmail();
		login = new LoginPage1(driver);
		login.enterUsername(expusername);
		login.enterUserPassword(exppassword);
		home = login.clickonLoginButton();
		home.clickonUserManagement();	
		user = home.clickonUserMgUsers();
		
		adduser.enterPrefix(expPrefix);
		adduser.enterFirstName(fName);
		adduser.enterLastName(lName);
		adduser.enterEmail(eMail);
		adduser.enterUsername(uName);
		adduser.enterPassword(password);
		adduser.enterConfirmPassword(confirmPassword);
		
		adduser.enterSCPercent(expscpercent);
		user = adduser.clickonSaveButton();
	    user.searchuser(uName);
		String acttableUserName = user.getusername();
		Assert.assertEquals(acttableUserName, uName,ErrorMessages.USERNAME_NOT_FOUND);
	}

}
