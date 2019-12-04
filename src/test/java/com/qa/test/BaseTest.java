package com.qa.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	protected WebDriver driver;
	protected WebDriverWait wait;

	@BeforeTest
	public void Setup(ITestContext ctx) throws MalformedURLException {

		String host = "localhost";
		DesiredCapabilities dc;

		if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
			dc = DesiredCapabilities.firefox();
		} else {
			dc = DesiredCapabilities.chrome();
		}
		if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("chrome")) {
			dc = DesiredCapabilities.chrome();
		}
		if (System.getProperty("HUB_HOST") != null) {
			host = System.getProperty("HUB_HOST");
		}

		String testName = ctx.getCurrentXmlTest().getName();
		String completeURL = "http://" + host + ":4444/wd/hub";
		dc.setCapability("name", testName);
		this.driver = new RemoteWebDriver(new URL(completeURL), dc);
	}

	@AfterTest
	public void tearDown() {
		this.driver.quit();
	}

}
