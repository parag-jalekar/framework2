package rahulshettyacademy.tests;


import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v108.runtime.model.WebDriverValue;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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

	
		@Test (dataProvider="getDataFromExcel")
		public void submitOrder(String email, String password, String productName) throws InterruptedException, IOException {
			
			
			 // login code			
			ProductCatalogue productCatalogue=landingPage.loginApplication(email, password);
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
		

		@Test(/*dependsOnMethods={"submitOrder"} */dataProvider="getDataFromExcel")
		public void orderHistoryTest(String email, String password, String productName) throws InterruptedException, IOException {
			ProductCatalogue productCatalogue=landingPage.loginApplication(email, password);
			OrderPage orderPage=(OrderPage) productCatalogue.goToOrdersPage();
			Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
			
		}
		
		
		@DataProvider(name="getData")
		public Object[][] getData() {
		    return new Object[][]{
				{"parag123@gmail.com", "Parag@123", "ZARA COAT 3"},
				{"parag1234@gmail.com", "Parag@1234", "ZARA COAT 3"}
				};
			
		}
		@DataProvider(name="getDataFromExcel")
		public Object[][] getDataFromExcel() throws IOException {
			// TODO Auto-generated method stub
		
				FileInputStream fis = new FileInputStream("D:\\eclipse-java-2020-09-R-win32-x86_64\\Automation\\SeleniumFrameworkDesign\\datasetLogin.xlsx");
				XSSFWorkbook wb;
				XSSFSheet sheet;
				XSSFRow row;
				XSSFCell cell = null;
				
				 wb= new XSSFWorkbook(fis);
				sheet=wb.getSheetAt(0);
				int rowCount=sheet.getPhysicalNumberOfRows();//rowcount=3
				row=sheet.getRow(0); // created to get cell number in next line 
				int colCount = row.getLastCellNum();//calcount=3 //no direct method to find number of cells, hence we create row and then row.metod
				Object data[][]= new Object[rowCount-1][colCount]; //[2][3]
				for(int i = 1; i<rowCount; i++) {
					row=sheet.getRow(i); 
					for(int j = 0; j<colCount; j++) {
						 data[i-1][j]=row.getCell(j).getStringCellValue();
						
						System.out.println(row.getCell(j).getStringCellValue() );
						
					}
				}
				return data;
				
			}
		
 	}//class
		    
		    
		    
		    
		   
			 
	


