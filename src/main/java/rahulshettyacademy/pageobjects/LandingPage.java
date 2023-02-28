package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{

	WebDriver driver;
	 
	public LandingPage(WebDriver driver) {
		super(driver);
		//Initialization, giving life to driver using this construction 
		this.driver=driver;
		PageFactory.initElements(driver, this);  //this is for identifying driver for Page Factory Model
	}
	//WebElement userEmail= driver.findElement(By.id("userEmail"));
	
	//Page Factory model for webElements 
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPasswordEle;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(xpath="//div[@id='toast-container']")
	WebElement errorMessage;
	
	////div[@id='toast-container']
	
	public ProductCatalogue loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		userPasswordEle.sendKeys(password);
		submit.click();
		//we are creating next page object in this method itself
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
}
