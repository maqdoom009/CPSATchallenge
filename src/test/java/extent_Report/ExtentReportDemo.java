package extent_Report;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemo {

	@Test
	public void loginTest() throws IOException
	{
		System.out.println("login to amazon");
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/automation.html");
		
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		ExtentTest logger = extent.createTest("loginTest");
		
		logger.log(Status.INFO, "login to amazon");
		
		logger.log(Status.PASS, "title verified");
		
		extent.flush();
	
		ExtentTest logger2 = extent.createTest("logOff Test");
		
		
		logger2.log(Status.FAIL, "title verified");
		
		logger2.fail("Failed because of some issues", MediaEntityBuilder.createScreenCaptureFromPath("C:/Users/Md Junaid/Desktop/IMG_2253.jpg").build());
        
	    logger2.pass("After fixing the issues", MediaEntityBuilder.createScreenCaptureFromPath("C:/Users/Md Junaid/Desktop/IMG_2253.jpg").build());
 
		
		extent.flush();
	
	}
	
}
