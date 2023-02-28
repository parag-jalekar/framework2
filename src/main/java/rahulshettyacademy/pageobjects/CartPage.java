package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{

	WebDriver driver;
	 
	public CartPage(WebDriver driver) {
		super(driver);
		//Initialization, giving life to driver using this construction 
		this.driver=driver;
		PageFactory.initElements(driver, this);  //this is for identifying driver for Page Factory Model
	}
	//WebElement userEmail= driver.findElement(By.id("userEmail"));
	
	//Page Factory model for webElements 
	@FindBy(xpath ="//li[@class='totalRow']/button")
	WebElement checkoutEle;
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> cartProducts;
	
	public boolean verifyProductDisplay(String productName) {
		boolean match= false;
		for(WebElement cp: cartProducts) {
			if(cp.getText().equalsIgnoreCase(productName)) {
				match = true;				
			}
		}
		return match;
	}
	
	public CheckoutPage goToCheckout() {
		checkoutEle.click();
		return new CheckoutPage(driver);
	}
	
	
}
