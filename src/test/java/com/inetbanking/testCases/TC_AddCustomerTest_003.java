package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;


public class TC_AddCustomerTest_003 extends BaseClass
{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		System.out.println("****Starting test case...****");
		lp.setUserName(username);
		logger.info("username is provided");
		lp.setPassword(password);
		logger.info("password is provided");
//		Thread.sleep(3000);
		lp.clickSubmit();
		
//		Thread.sleep(3000);
	
		AddCustomerPage ac = new AddCustomerPage(driver);
		ac.clickAddNewCustomer();
		
		logger.info("providing customer details ...");
//		Thread.sleep(5000);
		
		ac.custNam("Lucas");
		ac.custGender("male");
		ac.custdob("10", "27", "1993");
//		Thread.sleep(3000);
		ac.custAddress("England");
		ac.custCity("Bolton");
		ac.custState("London");
		ac.custPinno("4001135");
		ac.custTelephoneno("2012347893");
		ac.custEmailid(randomString()+ "@gmail.com");
		ac.custPassword("abcd12");
//		Thread.sleep(3000);
		ac.custSubmit();
		
		Thread.sleep(3000);
		
		logger.info("Validation started ...");
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if (res==true) {
			Assert.assertTrue(true);
			logger.info("Test case passed...");
		}
		else
		{
			logger.info("Test case failed ...");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	
	public String randomString () {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
//	public String randomNumber () {
//		String generatedInt = RandomStringUtils.randomAlphanumeric(4);
//		return generatedInt;
//	}
}

