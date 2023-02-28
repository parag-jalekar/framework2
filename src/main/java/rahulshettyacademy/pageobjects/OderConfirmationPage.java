package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractComponents.AbstractComponents;

public class OderConfirmationPage extends AbstractComponents{
	
	WebDriver driver;
	 
	public OderConfirmationPage(WebDriver driver) {
		super(driver);
		//Initialization, giving life to driver using this construction 
		this.driver=driver;
		PageFactory.initElements(driver, this); 
	}
	@FindBy(xpath ="//h1[@class='btnn action__submit ng-star-inserted']")
	WebElement confirmationMessage;
	
	public String getConfirmationMessage() {
		return confirmationMessage.getText();
		
	}
}
