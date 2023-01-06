package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass 
{
	
	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		System.out.println("****Starting test...****");
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("username provided");

		lp.setPassword(password);
		logger.info("password provided");
		
		Thread.sleep(3000);//u may delete it

		lp.clickSubmit();
		logger.info("press login button");
		
		System.out.println("****Login successfully****");
		
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Guru99 Bank Manager HomePage";
		
		if (ActualTitle.equals(ExpectedTitle))
		{
			Assert.assertEquals(true, true);
			logger.info("Login Test passed");
			Thread.sleep(3000);//u may delete it
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertEquals(true, false);
			logger.info("Login Test failed");
		}
	}

}
