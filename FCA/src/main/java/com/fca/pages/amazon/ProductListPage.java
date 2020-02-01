package com.fca.pages.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.fca.genericlib.WebDriverLib;

public class ProductListPage {
	public WebDriver driver;
	WebDriverLib wdl = new WebDriverLib();
	
	
	public ProductListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public ProductPage clickOnProduct(String productName) {
		WebElement productTXT=driver.findElement(By.xpath("(//span[contains(text(),'"+productName+"')])[3]"));
		wdl.waitForElementToBeClickable(driver, productTXT);
		productTXT.click();
		wdl.switchToChildWindow(driver);
		return new ProductPage(driver); 
	}
	
}
