package com.mil.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.properties.PropertiesConfiguration;
import org.apache.logging.log4j.core.config.properties.PropertiesConfigurationBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.mil.allPages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static ChromeDriver chrome;
	public static FirefoxDriver firefox;
	public static EdgeDriver ie;
	public static Properties prop;
	public LoginPage loginPage;

	
	
	// Constructor No. 1:
	public BaseTest() { // constructor to initialize the properties file in test-layer
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					"M:\\eclipse-workspace\\HRMOrangePomFactory\\src\\test\\java\\com\\mil\\configs\\configs.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Constructor No. 2:
	public BaseTest(WebDriver driver) { // constructor to initialize the page-factory objects in page-layer.
		PageFactory.initElements(driver, this);
	}

	public void initialization() {
		String browser = prop.getProperty("browserName");
		System.out.println(browser);
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Check your browser");
			break;
		}

		// driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(prop.getProperty("appUrl"));
	}
}
