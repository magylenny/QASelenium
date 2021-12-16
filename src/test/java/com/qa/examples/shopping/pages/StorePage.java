package com.qa.examples.shopping.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StorePage {
	
	private WebDriver driver;

	@FindBy(className = "cat-title")
	private WebElement category;
	
	public StorePage(WebDriver driver) {
		this.driver = driver;

		if (!driver.getTitle().equals("My account - My Store")) {
			throw new IllegalStateException("Page did not load");
		}
	}

	public void search() {
		category.click();
		
	}



}
