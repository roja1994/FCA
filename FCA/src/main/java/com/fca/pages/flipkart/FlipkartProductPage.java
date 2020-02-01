package com.fca.pages.flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.fca.genericlib.WebDriverLib;

public class FlipkartProductPage {
	
	public WebDriver driver;
	WebDriverLib wdl = new WebDriverLib();


	public FlipkartProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}


	public Integer getPrice(String productName) throws InterruptedException {

		WebElement price=driver.findElement(By.xpath("//span[contains(text(),'"+productName+"')]/../../../div[3]/div[1]/div/div"));
		wdl.waitForElementAndClick(driver, price);
		String prc = price.getText();
		wdl.switchToParentWindow(driver);
		return wdl.convertStringToInteger(prc);
	}

	public void comparePrice(int amazonPrice, int flipkartPrice) {
		if(amazonPrice > flipkartPrice) {
			System.out.println("FlipKart Price is efficient");
		}
		else
		System.out.println("Amazon Price is efficient");
	}
}