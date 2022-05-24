package com.mil.allPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mil.base.BaseTest;

public class LoginPage extends BaseTest {

	// Page factory - OR: first we have to create object repository.
	@FindBy(name = "txtUsername")
	WebElement usernameField;

	@FindBy(id = "txtPassword")
	WebElement passwordField;

	@FindBy(id = "btnLogin")
	WebElement loginBtn;

	@FindBy(xpath = "//div[@id='divLogo']/img")
	WebElement logoHrmOrange;

	// we can create constructor at class-level to initialize the page-factory objects.
	/**
	 public LoginPage() { 
	 PageFactory.initElements(driver, this);  
	 } 
	 }
	 */
	
	// we can create constructor in parent-class to initialize the page-factory objects and then call in child class using super()
	public LoginPage(WebDriver driver) { // 
		super(driver);
	}

	// Actions or method
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean varifyLogoHrmOrange() {
		return logoHrmOrange.isDisplayed();
	}

	public HomePage login(String userName, String password) {
		usernameField.sendKeys(userName);
		passwordField.sendKeys(password);
		loginBtn.click();
		return new HomePage();
	}
}
