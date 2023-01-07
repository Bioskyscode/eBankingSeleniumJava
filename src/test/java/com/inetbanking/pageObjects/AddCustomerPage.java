package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
//	@FindBy(how = How.LINK_TEXT, using = "New Customer")
//	@CacheLookup
//	WebElement lnkAddNewCustomer;
	
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")
	@CacheLookup
	WebElement txtCustomerName;
	
//	@FindBy(how = How.NAME, using = "name")
//	@CacheLookup
//	WebElement txtCustomerName;
	
	
//	@FindBy(how = How.NAME, using = "rad1")
//	@CacheLookup
//	WebElement rdGender;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")
	@CacheLookup
	WebElement rdGender;
	
	
//	@FindBy(how = How.ID_OR_NAME, using = "dob")
//	@CacheLookup
//	WebElement txtdob;
	@FindBy(id = "dob")
	@CacheLookup
	WebElement txtdob;
	
//	@FindBy(how = How.NAME, using = "addr")
//	@CacheLookup
//	WebElement txtaddress;
	@FindBy(name = "addr")
	@CacheLookup
	WebElement txtaddress;
	
//	@FindBy(how = How.NAME, using = "city")
//	@CacheLookup
//	WebElement txtcity;
	@FindBy(name = "city")
	@CacheLookup
	WebElement txtcity;
	
//	@FindBy(how = How.NAME, using = "state")
//	@CacheLookup
//	WebElement txtstate;
	@FindBy(name = "state")
	@CacheLookup
	WebElement txtstate;
	
//	@FindBy(how = How.NAME, using = "pinno")
//	@CacheLookup
//	WebElement txtpinno;
	@FindBy(name = "pinno")
	@CacheLookup
	WebElement txtpinno;
	
	
//	@FindBy(how = How.NAME, using = "telephoneno")
//	@CacheLookup
//	WebElement txttelephoneno;
	@FindBy(name = "telephoneno")
	@CacheLookup
	WebElement txttelephoneno;
	
//	@FindBy(how = How.NAME, using = "emailid")
//	@CacheLookup
//	WebElement txtemailid;
	@FindBy(name = "emailid")
	@CacheLookup
	WebElement txtemailid;
	
//	@FindBy(how = How.NAME, using = "password")
//	@CacheLookup
//	WebElement txtpassword;
	@FindBy(name = "password")
	@CacheLookup
	WebElement txtpassword;
	
//	@FindBy(how = How.NAME, using = "sub")
//	@CacheLookup
//	WebElement btnSubmit;
	@FindBy(name  = "sub")
	@CacheLookup
	WebElement btnSubmit;
	
	
	public void clickAddNewCustomer () {
		lnkAddNewCustomer.click();
	}
	
	public void custNam (String cnam) {
		txtCustomerName.sendKeys(cnam);
	}
	
	public void custGender (String cgender) {
		rdGender.sendKeys(cgender);
	}
	
	public void custdob (String mm, String dd, String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void custAddress (String caddress) {
		txtaddress.sendKeys(caddress);
	}
	
	public void custCity (String ccity) {
		txtcity.sendKeys(ccity);
	}

	public void custState (String cstate) {
		txtstate.sendKeys(cstate);
	}
	
	public void custPinno (String cpinno) {
		txtpinno.sendKeys(cpinno);
	}
	
	public void custTelephoneno (String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);
	}
	
	public void custEmailid (String cemailid) {
		txtemailid.sendKeys(cemailid);
	}
	
	public void custPassword (String cpassword) {
		txtpassword.sendKeys(cpassword);
	}
	
	public void custSubmit () {
		btnSubmit.click();
	}
}
