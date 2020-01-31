package compare;

import java.io.IOException;

import org.testng.annotations.Test;

import com.fca.genericlib.BaseTest;
import com.fca.genericlib.FileLibUtils;
import com.fca.pages.amazon.HomePage;

public class CompareAmazonAndFlipkart extends BaseTest{
	FileLibUtils flu = new FileLibUtils();
	@Test
	
	public void compareTest() throws IOException {
		HomePage hp = new HomePage(driver);
		hp.launchURL(driver, flu.getDataFromPropertyFile("AmazonURL"));
		hp.enterDetails("iPhone XR (64GB) - Yellow");
	}
}
