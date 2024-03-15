package uday.pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import uday.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver  driver;
	
	public ProductCatalogue(WebDriver driver) {
	//initialization the instance variable to as a local variable
		super(driver);
		this.driver = driver;
		PageFactory.initElements( driver,this);
		
		
	}
	//	List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List<WebElement>products;
	
	@FindBy(css=".ng-animating")  // pagefactory initelements is exclusive for driver.findelement construction.
    WebElement spinner;
	
	
	By productsby = By.cssSelector(".mb-3");
	By addToCart =  By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	public List<WebElement> getProductList()
	{
		 waitForElementToAppear(productsby);  // in this case you just have  "By" element.
		return products;
	}
	
	public WebElement getproductByName(String productName)
	{
		WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
		
	}
	 public void addProductToCart(String productName) throws InterruptedException
	 {
		 WebElement prod = getproductByName(productName);
		 prod.findElement(addToCart).click();
		 waitForElementToAppear(toastMessage);
		 waitForElementToDisappear(spinner);
		 	 
	 }
//	 constructor....
//	 when the object of the class created it automatically calls the constructor and also to initialize WebElements.(Page Objects) 
//	 declared in the page class using PageFactory.
	 
	 
//	 What is the use of @FindBy annotation?
//			 The @FindBy annotation is used to locate and initialize the web elements within page object classes in Selenium. 
//	 It provides a declarative approach to define elements using different locator strategies such as id, class name, etc.
	 
	 
//	What is an Object Repository in Selenium? 
	 
//	 An object repository is a centralized storage of locators in the form of objects.
	 
//	 What is the purpose of object repository?
//	 The Object Repository ensures the management, reusability, and reliability of UI elements
//	 by capturing them as objects in a DOM-like repository, sharable across projects. 
//   It allows for creating and reusing code inside and across automation projects.
	 

	 
//	 What is difference between FindBy and findElement?
		
//	FindBy is used to support PageObject pattern through PageFactory while findElement is normal way of locating a web element. 
//  If we do not initialise page objects using PageFactory, 
//  @FindBy will throw NullPointerException which is not the case with findElement() or findElements() methods.
	 
//	 What is the difference between find by and find all?
	 
//	The @FindBys annotation is used in case elements need to match all of the given criteria. 
//	 The @FindAll annotation is used in case elements need to match at least one of the given criteria.

}