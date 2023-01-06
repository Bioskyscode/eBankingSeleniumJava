package com.inetbanking.utilities;

//Listener class used to generate extent report
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class Reporting extends TestListenerAdapter 
{
	public ExtentHtmlReporter html;
	public ExtentReports extent;
	public ExtentTest test;

	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "Test-Result-"+timeStamp+".html";
		// path where output is to be printed
		html = new ExtentHtmlReporter(reportName);
//		html.loadXMLConfig("./extent-config.xml");
		html.config().setDocumentTitle("Automation Report");
		html.config().setReportName("Functional Test Report");
		html.config().setTestViewChartLocation(ChartLocation.TOP);


		extent = new ExtentReports();
		extent.attachReporter(html);
		extent.setSystemInfo("OS", "Window 11");
		extent.setSystemInfo("Tester", "Biodun");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("Browser", "Firefox");
	}
	
	public void onTestSuccess (ITestResult testResult) 
	{
		test = extent.createTest(testResult.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(testResult.getName(), ExtentColor.GREEN));

	}
	
	public void onTestFailure (ITestResult testResult) 
	{
		test = extent.createTest(testResult.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(testResult.getName(), ExtentColor.RED));
		
		String screenshotPath = "./Screenshots/"+testResult.getName()+".png";
		File f = new File(screenshotPath);
		
		if(f.exists()) {
			try {
				test.fail("Screenshot is below:"+test.addScreenCaptureFromPath(screenshotPath));
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}

	}
	
	public void onTestSkip (ITestResult testResult) 
	{
		test = extent.createTest(testResult.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(testResult.getName(), ExtentColor.ORANGE));
	}
	
	public void onFinish (ITestContext testContext) 
	{
		extent.flush();
	}
	

}
