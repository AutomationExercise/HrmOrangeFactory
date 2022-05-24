package com.mil.allPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mil.base.BaseTest;

public class MyInfoPage extends BaseTest {

	// Page Factory
	@FindBy(xpath = "//div[@class='head']/h1")
	WebElement personalDetails;

	@FindBy(id = "personal_txtEmpFirstName")
	WebElement firstNameTxt;

	@FindBy(id = "personal_txtEmpLastName")
	WebElement lastNameTxt;

	@FindBy(id = "//li/label[@for='personal_optGender_1']")
	WebElement gender;

	@FindBy(id = "//select[@name='personal[cmbNation]']")
	WebElement nationality;

	// Constructor
	public MyInfoPage() {
		PageFactory.initElements(driver, this);
	}

	// Methods
	public boolean personalDetailsTab() {
		return personalDetails.isDisplayed();
	}

	public String getFirstNameTxt() {
		return firstNameTxt.getAttribute("value");
	}

	public String getLastNameTxt() {
		return lastNameTxt.getAttribute("value");
	}

	public String getGender() {
		return gender.getAttribute("value");
	}

	public String getNationality() {
		return nationality.getAttribute("value");
	}

}
