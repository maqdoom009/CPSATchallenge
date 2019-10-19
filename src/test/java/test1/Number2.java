package test1;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Number2 {
	public static WebDriver driver;
	@Before
	public void launch(){
		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver-v0.25.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(" https://www.cii.in/OnlineRegistration.aspx");
	}
	
	
		@Test
		public void operation1() throws InterruptedException{
			WebElement Attendee = driver.findElement(By.name("drpAttendee"));
			Select s = new Select(Attendee);
			s.selectByIndex(3);
		Thread.sleep(4000);
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='header']/div/table/tbody/tr"));
		int rowsize = rows.size();
		
		System.out.println("number of rows = "+rowsize);
		Assert.assertTrue(true);
		
		WebElement title1 = driver.findElement(By.id("Gridview1_ctl02_drpTitle"));
		new Select(title1).selectByVisibleText("Admiral");
		Thread.sleep(2000);
		
		WebElement title2 = driver.findElement(By.id("Gridview1_ctl03_drpTitle"));
		new Select(title2).selectByValue("CA");
		Thread.sleep(2000);
		
		WebElement title3 = driver.findElement(By.id("Gridview1_ctl04_drpTitle"));
		new Select(title3).selectByIndex(18);
		Thread.sleep(2000);
		
		List<WebElement>alltitles = driver.findElements(By.id("Gridview1_ctl04_drpTitle"));
		int count = alltitles.size();
		for (WebElement titletext : alltitles) {
			System.out.println(titletext.getText());
			
		}
		
		}
		@After
		public void close(){
			driver.quit();
		
	}

}
