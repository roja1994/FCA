package com.fca.genericlib;

public interface IAutoConstant {
	//Driver executables for chrome browser
	String CHROME_KEY = "webdriver.chrome.driver";
	String CHROME_VALUE = "./src/main/resources/chromedriver.exe";
	//Driver executable for firefox browser
	String GECKO_KEY = "webdriver.gecko.driver";
	String GECKO_VALUE = "./src/main/resources/driver/geckodriver.exe";
		
	int ETO = 20;
	int ITO = 20;
	
	String AMAZON_URL="https://www.amazon.in/";
	String FLIPKART_URL="https://www.flipkart.com/";
}
