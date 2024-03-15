package uday.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import uday.AbstractComponents.AbstractComponent;

public  class LandingPage extends AbstractComponent {
	//parent is the abstractcomponent child is landingpage.
	WebDriver  driver;
	
	public LandingPage(WebDriver driver) //arguments // constructor only catch the variables.
	{
//initialization the instance variable to as a local variable
		
//Instance variables in Java are non-static variables, which are defined in a class outside any method, constructor or a block.
		
//Static: Static members have a global scope and can be accessed from anywhere within the program, 
//even without creating an instance of the class. 
//Non-Static: Non-static members have a local scope and can be accessed only through an instance of the class. 
//They are not accessible without creating an object.		
		
//Each instantiated object of the class has a separate copy or instance of that variable.
		
//	An instance variable belongs to a class.
		
		super(driver);   // you can send driver or any  variable from child to parent by using "super keyword." -
// - it fall in parent(Abstract) by caught the constructer.
		
		this.driver = driver;//this. keyword is refers to the current class variable.
		
		PageFactory.initElements( driver,this);  // initelements method.
		
		// before you touch anything in the class this method is the first thing execute.(Landing Page.)
	}

	//PageFactory should only focus on elements on objects.
	
	@FindBy(id="userEmail")  
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement Passwordele;
	
	@FindBy(id="login")
	WebElement Submit;
	
	public ProductCatalogue LoginApplication(String Email, String Password)
	{
		userEmail.sendKeys(Email);
		Passwordele.sendKeys(Password);
		Submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue ;
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
}
