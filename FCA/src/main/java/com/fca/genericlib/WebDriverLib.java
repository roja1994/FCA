package com.fca.genericlib;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverLib implements IAutoConstant{
	
	public void select(WebElement element, String option) {
		Select sec = new Select(element);
		sec.selectByVisibleText(option);
	}
	
	public void select(WebElement element, int index) {
		Select sec = new Select(element);
		sec.selectByIndex(index);
	}
	
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, ETO);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementToBeClickable(WebDriver driver, By locator) {
		WebDriverWait wait=new WebDriverWait(driver, ETO);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void waitForpresenceOfAllElementsLocatedBy(WebDriver driver, By locator) {
		WebDriverWait wait=new WebDriverWait(driver, ETO);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public void waitForPageTitle(WebDriver driver, String title) {
		WebDriverWait wait=new WebDriverWait(driver, ETO);
		wait.until(ExpectedConditions.titleIs(title));
	}

	public void waitForElementAndClick(WebDriver driver, WebElement element) throws InterruptedException {
		int count=0;
		while(count<=20) {
			try {
				waitForElementToBeClickable(driver,element);
				break;
			}catch(Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	public int randomNumber() {;
		Random randomNum = new Random();
		return randomNum.nextInt(10000);
	}
	public static String parentWindowID;
	public static String childWindowID;

	public void switchToChildWindow(WebDriver driver) {
		Set<String> wh = driver.getWindowHandles();
		Iterator<String> ite = wh.iterator();
		parentWindowID = ite.next();
		childWindowID = ite.next();
		
		driver.switchTo().window(childWindowID);
 	}

	public void switchToParentWindow(WebDriver driver) {
		driver.switchTo().window(parentWindowID);
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void moveToElement(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
}