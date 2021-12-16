package com.qa.examples.shopping.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class WebDriverHooks {

	private WebDriver webDriver;
	private ScreenshotManager screenshotManager;
	
	// @Before and @After here are NOT the default JUnit annotations, they are
	// custom ones defined by Cucumber-JUnit for the purpose of hooks
	@Before("@selenium") // from io.cucumber.java
	public void setup() throws Exception {
		if (webDriver == null) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
	        webDriver = new ChromeDriver();
		}
		screenshotManager = new ScreenshotManager();
	}
	
	@After("@selenium") // only run for features and scenarios tagged with @selenium
	public void teardown() {
		webDriver.quit();
	}
	
	public WebDriver getWebDriver() {
		return this.webDriver;
	}
	
	public ScreenshotManager getScreenshotManager() {
		return this.screenshotManager;
	}
}
