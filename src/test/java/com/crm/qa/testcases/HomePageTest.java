package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}

	//TEST CAESES SHOULD ALWAYS BE INDEPENDENT;
	//BRFORE EACH TEST CASE LAUNCH THE BROWSER AND LOG IN
	//@TEST --EXECUTE TEST CASE
	//AFTER EACH TEST CASE -- CLOSE THE BROWSER
	@BeforeMethod
	public void setup() {
		initalization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
	String homePagetitle =	homePage.verifyHomePageTitle();
	Assert.assertEquals(homePagetitle, "Cogmento CRM","Home Page Title did not match");
	
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
		
	}
	
	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		contactsPage = 	homePage.clickOnContactsLink();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	



}
