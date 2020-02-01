package com.fca.pages.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.fca.genericlib.WebDriverLib;

public class ProductPage {
	public WebDriver driver;
	WebDriverLib wdl = new WebDriverLib();
	
	
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public Integer getPrice(String productName) throws InterruptedException {

		WebElement price=driver.findElement(By.xpath("//span[contains(text(),'"+productName+"')]/../../../../div[12]/div/table/tbody/tr[2]/td[2]/span[1]"));
		wdl.waitForElementAndClick(driver, price);
		String prc = price.getText();
		wdl.switchToParentWindow(driver);
		return wdl.convertStringToInteger(prc);

	}
}
