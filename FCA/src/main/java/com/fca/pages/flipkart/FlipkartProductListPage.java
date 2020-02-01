package com.fca.pages.flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.fca.genericlib.WebDriverLib;
import com.fca.pages.amazon.ProductPage;

public class FlipkartProductListPage {
	public WebDriver driver;
	WebDriverLib wdl = new WebDriverLib();
	
	
	public FlipkartProductListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public FlipkartProductPage clickOnProduct(String productName) {
		WebElement productTXT=driver.findElement(By.xpath("//div[contains(text(),'"+productName+"')]"));
		wdl.waitForElementToBeClickable(driver, productTXT);
		productTXT.click();
		wdl.switchToChildWindow(driver);
		return new FlipkartProductPage(driver); 
	}
	
}
