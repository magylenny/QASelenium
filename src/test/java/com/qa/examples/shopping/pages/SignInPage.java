package com.qa.examples.shopping.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignInPage {

	private WebDriver driver;

	@FindBy(className = "icon-user")
	private WebElement createAccountButton;

	@FindBy(id = "email_create")
	private WebElement emailContainer;
	
	@FindBy(id = "customer_firstname")
	private WebElement firstName;
	
	@FindBy(id = "customer_lastname")
	private WebElement lastName;
	
	@FindBy(id = "passwd")
	private WebElement password;
	
	@FindBy(id = "firstname")
	private WebElement firstNameAddress;
	
	@FindBy(id = "lastname")
	private WebElement lastNameAddress;
	
	@FindBy(id = "address1")
	private WebElement address;
	
	@FindBy(id = "city")
	private WebElement city;
	
	@FindBy(id = "postcode")
	private WebElement postcode;
	
	@FindBy(id = "id_state")
	private WebElement state;
	Select stateSelect = new Select(state);
	
	@FindBy(id = "id_country")
	private WebElement country;
	Select countrySelect = new Select(country);
	
	@FindBy(id = "phone_mobile")
	private WebElement mobile;
	
	@FindBy(id = "submitAccount")
	private WebElement submitButton;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	
		if (!driver.getTitle().equals("Login - My Store")) {
			throw new IllegalStateException("Page did not load");
		}
	}

	public void createAccount(String email) {
		emailContainer.sendKeys(email);
		createAccountButton.click();

	}

	public StorePage fillDetails(String fName, String lName, String pwd, String add, String cty, String pCode, String st, String cntry, String no) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		password.sendKeys(pwd);
		firstNameAddress.sendKeys(fName);
		lastNameAddress.sendKeys(lName);
		address.sendKeys(add);
		city.sendKeys(cty);
		postcode.sendKeys(pCode);
		mobile.sendKeys(no);
		stateSelect.selectByVisibleText(st);
		countrySelect.selectByVisibleText(cntry);
		
		submitButton.click();
		
		
		return PageFactory.initElements(driver, StorePage.class);

	}

}
