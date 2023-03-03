package rahulshetyacademy.TestComponents;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;

public class BaseTest {

public WebDriver driver;
public LandingPage landingPage;
//this class contains all the common code related to tests
//initializeDriver() reads driver name from properties file and apply here
public WebDriver initializeDriver() throws IOException {
	//Selection of driver from .properties file
	//properties class used by creating its object prop--> prop.load(fis) to get property file location.
	//prop.getProperty("proertyName") _-> chose the browser
	Properties prop = new Properties();
	FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");
	prop.load(fis);
	System.out.println(prop);
	String browserName = prop.getProperty("browser");  
	System.out.println(browserName);
	//code to chose browser 
	if(browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("if statement picked up");
	}
	else if(browserName.equalsIgnoreCase("firefox")) {
		//firefox
	}
	else if(browserName.equalsIgnoreCase("edge")) {
		//System.setProperty(webdriver.edge.driver, path);
	}
	//
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	return driver;
	}

//Screenshot method
public String getScreenshot(String testcaseName) throws IOException {
	TakesScreenshot ts =(TakesScreenshot)driver;	
	File source=ts.getScreenshotAs(OutputType.FILE);
	File file = new File(System.getProperty("user.dir")+"//reports//"+testcaseName+".png");
	FileUtils.copyFile(source, file);
	return System.getProperty("user.dir")+"//reports//"+ testcaseName+".png";
	}

@BeforeMethod(alwaysRun=true) //alwaysRun--> run for every group (else it will get skip) 
	public LandingPage launchApplication() throws IOException {
		driver=initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
		//object/landing page class gobal level
		//this method launch application and returns landing page object from BaseTest to test case
		}
@AfterMethod(alwaysRun=true)
	public void tearDown() {
	driver.close();
}

	}

