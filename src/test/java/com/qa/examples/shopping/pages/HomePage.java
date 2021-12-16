package com.qa.examples.shopping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;


	@FindBy(className = "login")
	private WebElement loginButton;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		
		driver.get("http://automationpractice.com/index.php");

		if (!driver.getTitle().equals("My Store")) {
			throw new IllegalStateException("Page did not load");
		}
	}

	public SignInPage clickSignIn() {
		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(loginButton));
		loginButton.click();
		
		return PageFactory.initElements(driver, SignInPage.class);
	}
}
