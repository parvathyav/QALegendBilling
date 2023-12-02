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
import com.QALegendBilling.utilities.RandomUtility;

public class AddExpenseTest1 extends Base {
	

	LoginPage1 login;
	HomePage1 home;
	
	@Test
	public void tc_10_verifyAddExpenseCategories() {
		
		
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expusername = data.get(0).get(1);
		String exppassword = data.get(1).get(1);
		List<ArrayList<String>> userdata = ExcelUtility.excelDataReader("AddExpensePage");
		String Categoryname = userdata.get(0).get(1);
		String Categorycode = userdata.get(1).get(1);
		
		
		

		
		
		

		
	}

	

}
