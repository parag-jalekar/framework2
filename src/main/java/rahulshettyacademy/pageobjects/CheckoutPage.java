package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents{
	WebDriver driver;
	 
	public CheckoutPage(WebDriver driver) {
		super(driver);
		//Initialization, giving life to driver using this construction 
		this.driver=driver;
		PageFactory.initElements(driver, this);  //this is for identifying driver for Page Factory Model
	}
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countryInput;
	
	@FindBy(xpath="//a[contains(.,'Place Order')]")
	WebElement submit;
	
	@FindBy(xpath="//button[contains(@class, 'ta-item')][2]")
	WebElement selectCountry;
	
	public void selectCountry(String countryName) {
		Actions act= new Actions(driver);
		act.sendKeys(countryInput, countryName).build().perform();
		waitForElementToAppear(By.xpath("//span[@class= 'ng-star-inserted']/i"));
		selectCountry.click();
		//driver.findElement(By.xpath("//button[2]/span[@class='ng-star-inserted']")).click();
		// //button[2]/span[@class='ng-star-inserted']
		// //button[contains(@class, 'ta-item')][2]
	}
	
	public OderConfirmationPage submitOrder() {
		submit.click();
		return new OderConfirmationPage(driver);
	}
} 

