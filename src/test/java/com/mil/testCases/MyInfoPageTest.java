package com.mil.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mil.allPages.HomePage;
import com.mil.allPages.LoginPage;
import com.mil.allPages.MyInfoPage;
import com.mil.base.BaseTest;

public class MyInfoPageTest extends BaseTest {

	LoginPage loginPage;
	HomePage homePage;
	MyInfoPage myInfoPage;

	// Initialize parent-class constructor
	public MyInfoPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		homePage = new HomePage();
		homePage.myInfoTabClick();
		myInfoPage = new MyInfoPage();
	}

	@Test(priority = 1)
	public void personalDetailsDisplayTest() {
		Assert.assertTrue(myInfoPage.personalDetailsTab(), "Personal details tab not displayed");
	}

	@Test(priority = 2, enabled = false)
	public void verifyFirstNameTest() {
		String firstName = myInfoPage.getFirstNameTxt();
		System.out.println(firstName);
		Assert.assertEquals(firstName, "Paul", "First name not matched");
	}

	@Test(priority = 3, enabled = false)
	public void verifyLastNameTest() {
		String lastName = myInfoPage.getLastNameTxt();
		System.out.println(lastName);
		Assert.assertEquals(lastName, "Collings", "Last name not matched");
	}

	@Test(priority = 4, enabled = false)
	public void verifyGenderTest() {
		String gender = myInfoPage.getGender();
		System.out.println(gender);
		Assert.assertEquals(gender, "Male", "Gender not matched");
	}

	@Test(priority = 5, enabled = false)
	public void verifyNationalityTest() {
		String nationality = myInfoPage.getNationality();
		System.out.println(nationality);
		Assert.assertEquals(nationality, "American", "Nationality not matched");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
