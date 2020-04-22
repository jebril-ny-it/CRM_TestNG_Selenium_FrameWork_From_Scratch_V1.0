package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//PAGE FACTORY - O.R
	@FindBy(xpath="//span[contains(text(),'Log In')]")
	WebElement hpLogin;
	
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement loginbtn;
	
	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	
	@FindBy(xpath =	"//div[@class='rd-navbar-panel']//a[@class='brand-name']")
	WebElement crmLogo;
	
	//INITALIZING THE PAGE FACTORY
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	//ACTIONS
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMImage() {
	return	crmLogo.isDisplayed();

	}
	
	public HomePage login(String un,String pwd) {
		hpLogin.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		return new HomePage();
	}
	
	
	
	
}
