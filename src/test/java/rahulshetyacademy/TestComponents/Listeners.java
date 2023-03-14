package rahulshetyacademy.TestComponents;

import java.io.IOException;
import java.lang.reflect.Field;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import rahulshettyacademy.resources.ExtentReporterNG;

// This is listeners code but make sure to "add <listeners> block in testng.xml"

public class Listeners extends BaseTest implements ITestListener { //extending to BaseTest because it contains Screenshot method
	ExtentReports reports = ExtentReporterNG.getReporterObject(); // we have to bring this report object from extentReport code
	ExtentTest test;
	ThreadLocal<ExtentTest> local= new ThreadLocal<ExtentTest>(); //object to make test Thread Local
	
    @Override //  OnTestStarts we are setting entry of test in reports 
    public void onTestStart(ITestResult result) { //result holds all information about method
    	test=reports.createTest(result.getMethod().getMethodName()); //TestEntry created. we use result to get method and methodName
    	local.set(test); //unique thread id assigned captured and saved it in map. now test-->local.get()
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    //test.log(Status.PASS,"Test Pass");  
    	local.get().log(Status.PASS,"Test Pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Method to execute when a test method fails
    //test.log(Status.FAIL,"Test Fail");
    	test.log(Status.FAIL,"Test Fail");
    //test.fail(result.getThrowable());
    	local.get().fail(result.getThrowable());//we are failing you because you reach this block and get the error message
// local.get() ---->test
    	 try { // this code is to activate the driver, result has all the details of test hence we can extract driver from it.
    	        driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }
  //Question:ans: I can not get Test Method to get the driver because fields are associated with class level and not method level.

 //following code is to call getScreenshot method which receives method name and return screenshot file path
    	String filePath = null;
    	try {
			filePath=getScreenshot(result.getMethod().getMethodName()); // filePath veritable will not be recognized hence we have to declare it outside 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    			try {
					//test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    				local.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Method to execute when a test method is skipped
    }

    @Override
    public void onStart(ITestContext context) {
        // Method to execute when a test suite starts
    }

    @Override
    public void onFinish(ITestContext context) {
        // Method to execute when a test suite finishes
    	reports.flush(); // generate final report
    }
}