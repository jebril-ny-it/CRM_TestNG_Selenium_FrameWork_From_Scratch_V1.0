package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	// @CacheLookup = creating a space in our memory for the element instead
	// of going to the DOM to search for the element will be faster to excecute!!!
	// not dependiable if page needs to reload

	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
	WebElement contacslabel;

	@FindBy(xpath = "//div[@class='item']//a")
	WebElement newContactsBtn;

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

	// INITALIZAING THE PAGE OBJECT MODEL
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactslabel() {
		return contacslabel.isDisplayed();
	}

	public void selectContactsByName(String name) {
		String befor_xpath = "//html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[";
		String after_xpath = "]/td[2]";

		for (int i = 1; i <= 1; i++) {
			String nameList = driver.findElement(By.xpath(befor_xpath + i + after_xpath)).getText();
			System.out.println(name);
			if (nameList.contains(name)) // i=4{
				driver.findElement(
						By.xpath("//html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[" + i
								+ "]/td[1]"))
						.click();
		}

	}

	public void clickOnNewContactLink() {
		newContactsBtn.click();
	}

	public void createNewContact(String fName, String lName, String eAddress, String pNumber) {
		firstname.sendKeys(fName);
		lastname.sendKeys(lName);
		emailaddress.sendKeys(eAddress);
		phoneNumber.sendKeys(pNumber);
		saveBtn.click();

	}

//	public NewContactsFormPage clickOnNewContactLink() {
//	newContactsBtn.click();
//	return new NewContactsFormPage();
//
//}

}
