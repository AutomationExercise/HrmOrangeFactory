package com.mil.allPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mil.base.BaseTest;

public class HomePage extends BaseTest{
	
	@FindBy(xpath="//a[contains(text(),'Welcome')]")
	WebElement username;
	
	@FindBy(xpath="//a[@id='menu_dashboard_index']/b")
	WebElement dashboard;
	
	@FindBy(xpath="//a[@id='menu_pim_viewMyDetails']/b")
	WebElement myInfo;
	
	public HomePage() { 
		PageFactory.initElements(driver, this); 
	}
	
	public String homePageTitle() {
		return driver.getTitle();
	}
	
	public boolean nameDisplay() {
		return username.isDisplayed();
	}
	
	public boolean dashboardTab() {
		return dashboard.isDisplayed();
	}
	
	public boolean myInfoTab() {
		return myInfo.isDisplayed();
	}
	
	public MyInfoPage myInfoTabClick() {
		myInfo.click();
		return new MyInfoPage();
	}
}
