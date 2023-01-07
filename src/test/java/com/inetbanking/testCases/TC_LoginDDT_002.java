package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		
		System.out.println("*******Starting Test case*******");
		
		lp.setUserName(user);
		logger.info("Username provided");
		lp.setPassword(pwd);
		logger.info("Password provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if (isAlertPresent()==true)
		{
			logger.info("Login failed...");
			Assert.assertTrue(false);
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); //to close alert
			driver.switchTo().defaultContent(); //to return to the default page
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); //to close logout alert
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent() //user defined method to check if alert is present or not.
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch (NoAlertPresentException e)
		{
			return false;
		}
	}
	
	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData1.xlsx";
		
		int rowCount = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String[rowCount][colCount];
		
		for (int i=1;i<=rowCount;i++)
		{
			for (int j=0;j<colCount;j++)
			{
				logindata[i-1][j]= XLUtils.getCellData(path, "Sheet1", i, j);
				
			}
		}
		return logindata;
	}
}