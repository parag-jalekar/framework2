package rahulshettyacademy.tests;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulshetyacademy.TestComponents.BaseTest;

public class ErrorValidationsTest extends BaseTest{

		
		@Test(groups= {"ErrorHangling"})
		public void loginErrorValidation() throws InterruptedException, IOException {
			
			
			 // login code			
			landingPage.loginApplication("parag123@gmail.com", "Parag123");
			Assert.assertEquals(landingPage.getErrorMessage(),"Incorrect email or password.");
			System.out.println(landingPage.getErrorMessage()); //to check Error message
		}//test
		@Test(groups= {"ErrorHangling"})
		public void productErrorValidation() {
			Assert.assertTrue(true);
			}//test
		
	}//class
		    
		    
		    
		    
		   
			 
	


