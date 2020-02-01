package com.fca.pages.amazon;

import java.sql.Driver;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fca.genericlib.WebDriverLib;

public class ProductHomePage {
	public WebDriver driver;
	WebDriverLib wdl=new WebDriverLib(); 
	
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchTB;
	
	public WebElement getSearchTB() {
		return searchTB;
	}
	
	public ProductHomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public ProductListPage enterProductName(String searchText) throws InterruptedException {
		wdl.waitForElementAndClick(driver, searchTB);
		searchTB.sendKeys(searchText,Keys.ENTER);
		return new ProductListPage(driver);
	}

	public void launchURL(WebDriver driver, String url) {
		driver.get(url);
	}
	
}
