package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactsFormPage;
import com.crm.qa.util.TestUtil;

public class ContactspageTest extends TestBase {

	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	NewContactsFormPage newcontactpage;

	String sheetName = "contacts";

	public ContactspageTest() {
		super();
	}

	// TEST CAESES SHOULD ALWAYS BE INDEPENDENT;
	// BRFORE EACH TEST CASE LAUNCH THE BROWSER AND LOG IN
	// @TEST --EXECUTE TEST CASE
	// AFTER EACH TEST CASE -- CLOSE THE BROWSER

	@BeforeMethod
	public void setup() {
		initalization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		newcontactpage = new NewContactsFormPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
	}

	@Test(priority = 1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactsPage.verifyContactslabel(), "## CONTACT LABEL IS NOT VISIABLE ##");
	}

	@Test(priority = 2)
	public void selectContactsTest() {
		contactsPage.selectContactsByName("Iqra Khan");
	}

	@Test(priority = 3)
	public void selectMultipleContactsTest() {
		contactsPage.selectContactsByName("Iqra Khan");
		contactsPage.selectContactsByName("Ahmad Mohammad");

	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void validateCreateNewcontact(String emailaddress, String firstname, String lastname, String phonenumber) {
		homePage.clickOnContactsLink();
		driver.navigate().refresh();
		contactsPage.clickOnNewContactLink();
		driver.navigate().refresh();
		//driver.navigate().refresh();
		contactsPage.createNewContact(firstname, lastname, emailaddress, phonenumber);
		driver.navigate().refresh();
		//driver.navigate().refresh();
		//driver.navigate().refresh();
		



	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
