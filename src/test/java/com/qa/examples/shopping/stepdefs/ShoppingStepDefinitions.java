package com.qa.examples.shopping.stepdefs;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.examples.shopping.pages.HomePage;
import com.qa.examples.shopping.pages.PageRepository;
import com.qa.examples.shopping.utils.WebDriverHooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingStepDefinitions {

	private WebDriver webDriver;

	private PageRepository pages;

	// constructor injection
	public ShoppingStepDefinitions(WebDriverHooks hooks) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.webDriver = new ChromeDriver();
		this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

		this.pages = new PageRepository();
		this.pages.homePage = PageFactory.initElements(this.webDriver, HomePage.class);
	}

	@Given("the user is logged in")
	public void theUserIsLoggedIn() {
		pages.signInPage = this.pages.homePage.clickSignIn();
	}

	@When("the user creates an account")
	public void theUserCreatesAnAccount() {
		this.pages.signInPage.createAccount("Test56214@Test315151525.com");
		pages.storePage = this.pages.signInPage.fillDetails("Tester", "Joe", "TesterJoe123", "1/3 Main Street", "Fairbanks", "000000", "Alaska", "United States", "047854186240");
	}

	@When("the user searches for Summer dresses")
	public void theUserEntersTheirDetails() {
		this.pages.storePage.search();
	}

	@Then("a purchase verification should appear on the screen saying {string}")
	public void aPurchaseVerificationShouldAppearOnTheScreenSaying(String string) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(string, webDriver.findElement(By.className("complete-header")).getText());
	}

}
