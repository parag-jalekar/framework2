package rahulshettyacademy.abstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrderPage;

public class AbstractComponents {
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
	this.driver=driver;	
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartHeader;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']") 
	WebElement orderHeader;
	
	public void waitForElementToAppear(By findBy) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement webelement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(webelement));
		}
		
	
	public CartPage goToCartPage() throws InterruptedException {
		Thread.sleep(3000);
		cartHeader.click();
		CartPage cartPage= new CartPage(driver);
		return cartPage;
}
	public OrderPage goToOrdersPage() throws InterruptedException {
		Thread.sleep(3000);
		orderHeader.click();
		OrderPage orderPage= new OrderPage(driver);
		return orderPage;
	}
}