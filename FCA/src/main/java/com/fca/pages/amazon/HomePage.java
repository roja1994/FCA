package com.fca.pages.amazon;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	} 
	
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchTB;
	
	public WebElement getSearchTB() {
		return searchTB;
	}
	
	public void enterDetails(String searchText) {
		searchTB.sendKeys(searchText);
	}

	public void launchURL(WebDriver driver, String url) {
		driver.get(url);
	}
	
}
