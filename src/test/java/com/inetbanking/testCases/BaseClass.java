package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {

	static {
		init();
	}
	ReadConfig read = new ReadConfig();

	public String baseURL = read.getApplicationURL();
	public String username = read.getUsername();
	public String password = read.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass
	public void setup (String br) throws InterruptedException
	{
		System.out.println("Opening browser");
		logger = Logger.getLogger(BaseClass.class);
		
		if (br.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",read.getChromepath());
			driver = new ChromeDriver();

			
		}
		else if (br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",read.getfirefoxpath());
			driver = new FirefoxDriver();

		}
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		logger.info("URL is opened");
		System.out.println("*******URL is opened*******");
		driver.manage().window().maximize();
		driver.switchTo().frame("gdpr-consent-notice");
		System.out.println("********We are switch to the iframe*******");
		Thread.sleep(3000);
		WebElement acceptButton = driver.findElement(By.id("save"));
		acceptButton.click();
		driver.switchTo().defaultContent();
		System.out.println("********Back to Login page*******");
	
	}

	@AfterClass
	public void tearDown()
	{
//		driver.quit();
		System.out.println("Test completed");
	}
	
	public static void init() {
		PropertyConfigurator.configure("log4j.properties");
	}
	
	public void captureScreen (WebDriver driver, String tname) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File ("./Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}
