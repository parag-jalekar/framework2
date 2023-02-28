package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents{

	WebDriver driver;
	 
	public OrderPage(WebDriver driver) {
		super(driver);
		//Initialization, giving life to driver using this construction 
		this.driver=driver;
		PageFactory.initElements(driver, this);  //this is for identifying driver for Page Factory Model
	}
	
	
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> productsNames;
	
	public boolean verifyOrderDisplay(String productName) {
		boolean match= false;
		for(WebElement op: productsNames) {
			if(op.getText().equalsIgnoreCase(productName)) {
				match = true;				
			}
		}
		return match;
	}
	
	
	
	
}
