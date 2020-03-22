package extent_Report;

import java.io.IOException;

import org.apache.bcel.verifier.exc.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemo2 
{
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;

	@BeforeTest
	public void setup()
	{
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/automation2.html");
		
		extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		logger = extent.createTest("login test");
	}
	
	@Test
	public void loginTest()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://google.com/");
		System.out.println("title is : "+driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("badebhai"));
	}
	
	@AfterTest
	public void tearDown(ITestResult result) throws IOException
	{
		if (result.getStatus()==ITestResult.FAILURE) {
		String temp = extent_Report.Utility.getScreenshot(driver);
		logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		extent.flush();
		driver.quit();
		
	}
}
