package rahulshettyacademy.tests;


import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v108.runtime.model.WebDriverValue;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.abstractComponents.AbstractComponents;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OderConfirmationPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshetyacademy.TestComponents.BaseTest;

public class StandAloneTest extends BaseTest{

	String productName="ZARA COAT 3";
		@Test
		public void submitOrder() throws InterruptedException, IOException {
			
			
			 // login code			
			ProductCatalogue productCatalogue=landingPage.loginApplication("parag123@gmail.com", "Parag@123");
			// on product catalog page
			 //adding in cart
			productCatalogue.addProductToCart(productName);	
			
			AbstractComponents abstractComponents = new AbstractComponents(driver); //created object of class
			//go to cart page
			CartPage cartPage = abstractComponents.goToCartPage(); 
			//Verify product showing in cart page
			
			Boolean match = cartPage.verifyProductDisplay(productName);
		    Assert.assertTrue(match);
			//click on checkout
		    CheckoutPage checkoutPage= cartPage.goToCheckout();
		    
		    checkoutPage.selectCountry("India");
		    OderConfirmationPage OderConfirmationPage=checkoutPage.submitOrder();
			
		    //verifying confirmation message
		    String confirmMessage= OderConfirmationPage.getConfirmationMessage();
		    Assert.assertEquals(confirmMessage,  "THANKYOU FOR THE ORDER.");	
		  
		   
		}//test
		

		@Test//(dependsOnMethods={"submitOrder"})
		public void orderHistoryTest() throws InterruptedException, IOException {
			ProductCatalogue productCatalogue=landingPage.loginApplication("parag123@gmail.com", "Parag@123");
			OrderPage orderPage=(OrderPage) productCatalogue.goToOrdersPage();
			Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
		}
	}//class
		    
		    
		    
		    
		   
			 
	


