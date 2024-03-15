package uday.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import uday.pageObjectModel.LandingPage;
import uday.pageObjectModel.ProductCatalogue;
import uday.pageObjectModel.CartPage;
import uday.pageObjectModel.CheckoutPage;
import uday.pageObjectModel.ConfirmationPage;

public class SubmitOrderTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String productName = "ZARA COAT 3";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
				
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		ProductCatalogue productCatalogue = landingPage.LoginApplication("anshika@gmail.com", "Iamking@000");
		
		List<WebElement> products = productCatalogue.getProductList(); 
		productCatalogue.addProductToCart(productName);
		
		CartPage cartPage =productCatalogue.gotoCartpage();
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
	
	    CheckoutPage checkoutPage =	cartPage.goToCheckout();
		checkoutPage.SelectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		
		
		
		
		
		String confirmMessage = confirmationPage.getConfirmationMessage();
//		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println(confirmMessage);
		Thread.sleep(3000);
		driver.close();
		
				
//		Page Object Model, also known as POM, is a design pattern in Selenium
//		that creates an object repository for storing all web elements. 
//		It helps reduce code duplication and improves test case maintenance. 
//		In Page Object Model, consider each web page of an application as a class file. 
		
		
//		WHAT IS OBJECT...
//		In Selenium WebDriver context, objects would typically be the locators used to uniquely identify web elements.
//		 The major advantage of using object repository is the segregation of objects from test cases.
	}

}
