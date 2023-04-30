package pages;


import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Steps;
import utils.ReportLog;

public class Product extends PageObject {

	@Steps
	ReportLog report;


	@FindBy(xpath = "//button[@aria-label='pickup']")
	WebElementFacade pickUpButton;

	@FindBy(xpath = "//button[text()='Yes']")
	WebElementFacade confirmLocation;

	@FindBy(xpath ="//span[@class = 'cart-item-count__text']")
	WebElementFacade noOfItemsInCart;		

	List <WebElementFacade> productDetails;


	public List<WebElementFacade> getListOfProducts() {

		//	product list -  //span[@class= 'product-name product-name--product-tile']
		//	product brand list -  //span[@class= 'product-name product-name--product-tile']/span[@class= 'product-name__item product-name__item--brand']
		//	product name list -  //span[@class= 'product-name product-name--product-tile']/span[@class= 'product-name__item product-name__item--name']
		//	product quantity list -  //span[@class= 'product-name product-name--product-tile']/span[@class= 'product-name__item product-name__item--package-size']

		String productListXpath = "//span[@class= 'product-name product-name--product-tile']/span[@class= 'product-name__item product-name__item--name']";
		productDetails = findAll(By.xpath(productListXpath));
		System.out.println("Total products are  " + productDetails.size());
		for (int i=0; i<productDetails.size(); i++) {
			System.out.println(productDetails.get(i).getText());	
		}
		return productDetails;
	}


	public void increaseQuantity() {

		report.LOG("Email address is entered");
	}

	public void decreaseQuantity() {

		report.LOG("Email address is entered");
	}

	public void AddToCart(String expectedProduct) {

		List<WebElementFacade> listOfProductName = getListOfProducts();
		String beforeXpath  = "//button[@aria-label= 'Add to cart, ";
		String afterXpath = "']";
		String actualProduct;

		for (int i=0; i<listOfProductName.size(); i++) {

			actualProduct= listOfProductName.get(i).getText();

			if (expectedProduct.equalsIgnoreCase(actualProduct)) {

				Assert.assertEquals(expectedProduct,actualProduct);
				waitABit(1000);
				getDriver().findElement(By.xpath(beforeXpath + actualProduct + afterXpath)).click();
				String xpath = 	getDriver().findElement(By.xpath(beforeXpath + actualProduct + afterXpath)).getText();
				System.out.println(xpath);
				report.LOG(expectedProduct + " product found");
				System.out.println(expectedProduct + " product found");
				break;
			} else report.LOG("Requested product not found");		
		}

		//		waitABit(1000);
		//		pickUpButton.click();
		//		System.out.println("pickup clicked");
		//		waitABit(3000);
		//		confirmLocation.click();
		//		System.out.println("pickup clicked");
		//		waitABit(3000);
		//
		if (pickUpButton.isDisplayed()) {
			pickUpButton.click();
			System.out.println("pickup clicked");
			waitABit(2000);
		}

		if (confirmLocation.isDisplayed()) {
			confirmLocation.click();
			System.out.println("pickup clicked");
			waitABit(2000);
		}
		waitABit(15000);
		Assert.assertEquals("1", noOfItemsInCart.getText());
		report.LOG("No. of product in cart is " + noOfItemsInCart.getText());
	}

}
