package com.mil.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mil.allPages.HomePage;
import com.mil.allPages.LoginPage;
import com.mil.allPages.MyInfoPage;
import com.mil.base.BaseTest;

public class HomePageTest extends BaseTest {
	LoginPage loginPage;
	HomePage homePage;
	MyInfoPage myInfoPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		homePage = new HomePage();
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTilte = homePage.homePageTitle();
		Assert.assertEquals(homePageTilte, "OrangeHRM");
	}

	@Test(priority = 2)
	public void verifyNameDisplayTest() {
		boolean nameDisplay = homePage.nameDisplay();
		Assert.assertTrue(nameDisplay, "Username is displayed");
	}

	@Test(priority = 3)
	public void verifyDashboardDisplayTest() {
		boolean dashboardTab = homePage.dashboardTab();
		Assert.assertTrue(dashboardTab, "Dashboard tab is displayed");
	}

	@Test(priority = 4)
	public void verifyMyInfoDisplayTest() {
		boolean myInfo = homePage.myInfoTab();
		Assert.assertTrue(myInfo, "MyInfo tab is displayed");
	}

	@Test
	public void clickOnMyInfoTabTest() {
		myInfoPage = homePage.myInfoTabClick();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
