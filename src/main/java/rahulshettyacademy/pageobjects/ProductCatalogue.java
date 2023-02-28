package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.abstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{

	WebDriver driver;
	 
	public ProductCatalogue(WebDriver driver) {
		super(driver);  // need to be done in every child class 
		//Initialization, giving life to driver using this construction 
		this.driver=driver;
		PageFactory.initElements(driver, this);  //this is for identifying driver for Page Factory Model
	}
	//WebElement userEmail= driver.findElement(By.id("userEmail"));
	
	//Page Factory model for webElements 
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	
	By productBy= By.cssSelector(".mb-3"); // by.location created to use further
	By addToCart= By.className("fa-shopping-cart"); // by.location of add to cart button to use further
	By toastMessage = By.className("fa-shopping-cart"); //by.location of toast "added to cart"
	
	//Creating the action methods
	public List<WebElement> getProductList(){
		waitForElementToAppear(productBy); // method from abstract class to wait for products to be loaded/
		return products;
		}
	
	public WebElement getProductByName(String productName){

		WebElement prod = null;
		for(WebElement w:products) {
			
			if (w.findElement(By.cssSelector("b")).getText().equals(productName)) {				
				prod=w;
				break;
	        }			
		}
		return prod;	
	}
	
	
	public void addProductToCart(String productName) {
		WebElement prod = getProductByName(productName);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("fa-shopping-cart")));
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage); // wating for to
	}
	}
