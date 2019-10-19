package test1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Number1 {
public static WebDriver driver;

@BeforeTest
public static void Launch(){
	System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(" https://www.meripustak.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
	
	@Test(priority = 1)
	public void operations1(){
		WebElement Image = driver.findElement(By.xpath("//img[@class='img-responsive']"));
	int imagewidth = Image.getSize().getWidth();
	System.out.println("Image width is "+imagewidth+" pixels");
	
	int imagehight = Image.getSize().getHeight();
	System.out.println("Image hight is "+imagehight+ " pixels");
	}
	
	@Test(priority = 2)
	public static void operation2(){
		String icon = driver.findElement(By.xpath("//i[@class='fa fa-twitter sky_blue']")).getAttribute("href");
		System.out.println(icon);
	}
		
	@Test(priority = 3)
	public static void operation3() throws InterruptedException{
		driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart blue']")).click();
	
		//boolean expected = driver.getPageSource().contains("No Item is Added In Cart yet.Cart is Empty!!!");		
		Assert.assertTrue(driver.getPageSource().contains("No Item is Added In Cart yet.Cart is Empty!!!"));
		//System.out.println(expected);
		
		Thread.sleep(3000);
		driver.navigate().back();
		//driver.findElement(By.name("search")).sendKeys("java book");
	
		Thread.sleep(8000);
		driver.findElement(By.xpath("//a[@class='btn-23 hidden-xs ad']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart blue']")).click();
		
	if(driver.getPageSource().contains("No Item is Added In Cart yet.Cart is Empty!!!")){
		System.out.println("The message does exist");
	}else{
		System.out.println("The message doesn't exist");
	}
	
	}
		
		
		
	
	
	
	@AfterTest
	public static void logout(){
		driver.quit();
	}
}



