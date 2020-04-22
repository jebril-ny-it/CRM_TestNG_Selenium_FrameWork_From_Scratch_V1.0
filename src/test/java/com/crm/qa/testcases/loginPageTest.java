package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class loginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public loginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initalization();
		loginPage = new LoginPage();

	}

	@Test(priority = 1)
	public void loginPageTitletest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
	}

	@Test(priority = 2)
	public void crmLogoimageTest() {
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
