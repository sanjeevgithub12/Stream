package uday.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import uday.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
  WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
				super(driver);
				this.driver= driver;
				PageFactory.initElements( driver,this);
		// TODO Auto-generated constructor stub
	}			
		
	@FindBy(css=".action__submit ")
	WebElement submit;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="(//button[contains(@class, 'ta-item')]) [2]")
	WebElement selectcountry;
	
	By results = By.cssSelector(".ta-results");
	
	public void SelectCountry(String CountryName)
	{
		Actions a = new Actions(driver);
		a.sendKeys(country,CountryName).build().perform();
		waitForElementToAppear(results);
		selectcountry.click();
		
	}
	public ConfirmationPage submitOrder()
	{
		submit.click();
		return new ConfirmationPage(driver);
	}
	
}
