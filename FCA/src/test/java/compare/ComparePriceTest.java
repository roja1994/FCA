package compare;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fca.genericlib.BaseTest;
import com.fca.genericlib.FileLibUtils;
import com.fca.pages.amazon.ProductHomePage;
import com.fca.pages.amazon.ProductListPage;
import com.fca.pages.amazon.ProductPage;
import com.fca.pages.flipkart.FlipkartProductHomePage;
import com.fca.pages.flipkart.FlipkartProductListPage;
import com.fca.pages.flipkart.FlipkartProductPage;

public class ComparePriceTest extends BaseTest{
	FileLibUtils flu = new FileLibUtils();
	@Test
	
	public void comparePriceTest() throws IOException, InterruptedException {
		String amazonUrl=flu.getDataFromPropertyFile("AmazonURL");
		String flipkartUrl=flu.getDataFromPropertyFile("FlipkartURL");
		String productName=flu.getDataFromPropertyFile("searchStr");
		String fproductName=flu.getDataFromPropertyFile("searchff");
		
		ProductHomePage php = new ProductHomePage(driver);
		php.launchURL(driver, amazonUrl);
		
		ProductListPage plp=php.enterProductName(productName);
		
		ProductPage pp=plp.clickOnProduct(productName);
		int amazonPrice = pp.getPrice(productName);

		php.launchURL(driver, flipkartUrl);
		
		FlipkartProductHomePage fphp = new FlipkartProductHomePage(driver);
		
		FlipkartProductListPage fplp=fphp.enterProductName(productName);
		
		FlipkartProductPage fpp = fplp.clickOnProduct(fproductName);
	
		int flipkartPrice = fpp.getPrice(fproductName);
		
		fpp.comparePrice(amazonPrice , flipkartPrice);
		
	
	}
}
