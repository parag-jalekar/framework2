package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReporterNG {
public static ExtentReports getReporterObject() {
	String path = System.getProperty("user.dir")+"//reports//.index.html"; //we deliberately make it static to use with class name in listeners
	ExtentHtmlReporter html;
	ExtentReports reports;
	ExtentTest test;
	
	html = new ExtentHtmlReporter(path);
	html.config().setReportName("Web Automation Result");
	html.config().setDocumentTitle("Test Result");
	
	reports= new ExtentReports();
	reports.attachReporter(html);
	reports.setSystemInfo("Tester", "parag Jalekar");
	return reports; // reports will be used in Listeners 
	 	
}


}
