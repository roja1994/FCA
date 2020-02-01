package com.fca.pages.flipkart;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fca.genericlib.WebDriverLib;

public class FlipkartProductHomePage {
	public WebDriver driver;
	WebDriverLib wdl = new WebDriverLib();
	@FindBy(xpath = "//button[@class='_2AkmmA _29YdH8']")
	private WebElement loginCloseBTN;
	
	@FindBy(name = "q")
	private WebElement searchTB;
	
	public FlipkartProductHomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public FlipkartProductListPage enterProductName(String proName) throws InterruptedException {
		wdl.waitForElementAndClick(driver, loginCloseBTN);
		loginCloseBTN.click();
		wdl.waitForElementAndClick(driver, searchTB);
		searchTB.sendKeys(proName, Keys.ENTER);
		return new FlipkartProductListPage(driver);
	}
	
	
}
