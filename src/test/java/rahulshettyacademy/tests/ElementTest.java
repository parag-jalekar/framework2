package rahulshettyacademy.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//waits
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.get("https://rahulshettyacademy.com/client");
		//driver.manage().window().maximize();
		
		//Login code
		WebElement username= driver.findElement(By.id("userEmail"));
		username.sendKeys("parag123@gmail.com");
		
		WebElement password = driver.findElement(By.id("userPassword"));
			password.sendKeys("Parag@123");
		
		WebElement submit = driver.findElement(By.id("login"));  	
			submit.click();
		//	
              List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
			
			//products.stream().filter(products->products.getText().equals("ZARA COAT 3"));
			
			for(WebElement w:products) {
				if (w.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")) {
					System.out.println("got the element ");
					//wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("fa-shopping-cart")));
					w.findElement(By.className("fa-shopping-cart")).click();
					break;

	}

}
	}
	}
//Login code
/*
WebElement username= driver.findElement(By.id("userEmail"));
username.sendKeys("parag123@gmail.com");

WebElement password = driver.findElement(By.id("userPassword"));
	password.sendKeys("Parag@123");

WebElement submit = driver.findElement(By.id("login"));  	
	submit.click();
*/
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));	
// List<WebElement> products = driver.findElements(By.cssSelector(".mb-3")); //on 

//products.stream().filter(products->products.getText().equals("ZARA COAT 3"));...unused.
/*
for(WebElement w:products) {
	if (w.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")) {
		System.out.println("got the element ");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("fa-shopping-cart")));
		w.findElement(By.className("fa-shopping-cart")).click();
		break;
		
	}
	*/
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
	
	//System.out.println(driver.findElement(By.id("toast-container")).getText());
/*		
	
}
Thread.sleep(5000);
driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

//Get list of products in cart
List<WebElement> cartProduct = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
////div[@class='cartSection'] this catches webelement and /h takes us inside to visible text.

for(WebElement cp: cartProduct) {
	if(cp.getText().equalsIgnoreCase("zara coat 3")) {
		System.out.println("zara coat 3 is added in cart and test passed");
		Assert.assertTrue(true);
	}
}
//locating checkout button and clicking on it
WebElement checkpoutButton = driver.findElement(By.xpath("//li[@class='totalRow']/button"));
checkpoutButton.click();
	
//loacting inpur box and entering country name using action class for practice

WebElement countryInput = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
Actions act= new Actions(driver);
act.sendKeys(countryInput, "india").build().perform();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class= 'ng-star-inserted']/i")));

driver.findElement(By.xpath("//button[contains(@class, 'ta-item')][2]")).click();
WebElement placeOrderButton = driver.findElement(By.xpath("//a[contains(text(),'Place Order')]"));
//WebElement placeOrderButton = driver.findElement(By.xpath("//a[contains(text(),'Apply Coupon')]"));
//WebElement placeOrderButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Place Order')]")));

System.out.println( placeOrderButton.isDisplayed());
System.out.println(placeOrderButton.isEnabled());
wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
//placeOrderButton.click();
act.scrollToElement(placeOrderButton).build().perform();
driver.findElement(By.cssSelector(".action_submit")).click();
driver.findElement(By.xpath("//a[contains(.,'Place Order')]")).click();

Point point = placeOrderButton.getLocation();

// Calculate the new location to move the mouse to
int x = (int) (point.getX() + 5);
int y = (int) (point.getY() + 5);


act.moveByOffset(x, y).click().build().perform();
//clicking on submit button 135.703*20
//driver.findElement(By.cssSelector(".action_submit")).click();
//checking success message
driver.navigate().to("https://rahulshettyacademy.com/client/dashboard/thanks?prop=%5B%2263f601a0568c3e9fb11de86c%22%5D");
String confirmMessage = driver.findElement(By.xpath("//h1[@class='btnn action__submit ng-star-inserted']")).getText();
Assert.assertEquals(confirmMessage, "THANKYOU FOR THE ORDER.");


Thread.sleep(2000);
driver.close();
//parag123@gmail.com   Parag@123 //div[@class='cartSection'] zara coat 3 
//li[@class='totalRow']/button
//span[@class= 'ng-star-inserted']/i
//button[contains(@class, 'ta-item')][2]
//btnn action__submit ng-star-inserted
////h1[@class='btnn action__submit ng-star-inserted'] successful message
 */
