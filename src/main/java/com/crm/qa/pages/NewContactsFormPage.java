package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class NewContactsFormPage extends TestBase {

	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstname;

	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastname;

	@FindBy(xpath = "//input[@placeholder='Number']")
	WebElement phoneNumber;

	@FindBy(xpath = "//input[@placeholder='Email address']")
	WebElement emailaddress;

	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement saveBtn;
	

	// INITALIZING THE PAGE FACTORY
		public NewContactsFormPage() {
			PageFactory.initElements(driver, this);
		}

		public void createNewContact(String fName,String lName,String eAddress,String pNumber) {
			firstname.sendKeys(fName);
			lastname.sendKeys(lName);
			emailaddress.sendKeys(eAddress);
			phoneNumber.sendKeys(pNumber);
			saveBtn.click();
			
		}









}
