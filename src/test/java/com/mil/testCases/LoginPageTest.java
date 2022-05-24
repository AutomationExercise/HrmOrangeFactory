package com.mil.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mil.allPages.HomePage;
import com.mil.allPages.LoginPage;
import com.mil.base.BaseTest;
import com.mil.testData.TestDataProvider;

public class LoginPageTest extends BaseTest {
	LoginPage loginPage;
	HomePage homePage;
	public Logger log;

	public LoginPageTest() {
		super(); // call to parent-class constructor to initialize the properties file
	}

	@BeforeClass
	public void setLogger() { // creating Logger class object.
		log = LogManager.getLogger("LoginPageTest");
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage(driver);
	}

	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, "OrangeHRM");
		log.info("Login page title is verified");
	}

	@Test(priority = 2)
	public void validateLogoHrmOrange() {
		boolean logoHrmOrange = loginPage.varifyLogoHrmOrange();
		Assert.assertTrue(logoHrmOrange);
		log.info("Login page logo is verified");
	}

	@Test(priority = 3, dataProvider = "provideTestData", dataProviderClass = TestDataProvider.class)
	public void verifylogin(String userName, String password) {
		homePage = loginPage.login(userName, password);
		// homePage = loginPage.login(prop.getProperty("userName"),
		// prop.getProperty("password"));
		log.info("Logged into page");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
