package test1;

import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import net.bytebuddy.asm.Advice.Argument;

public class Number3 {
	public static WebDriver driver;
	
	@Before
	public void launch(){
		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver-v0.25.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		//driver = new ChromeDriver();
		driver.get("https://www.premierleague.com/");
	}
	@Test
	public void operation() throws InterruptedException{
		driver.findElement(By.linkText("Tables")).click();
		Thread.sleep(4000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement element = driver.findElement(By.xpath("//td[@class='team']/a"));
		Thread.sleep(4000);
		
		//js.executeScript("arguments[0].scrollIntoView();", element);
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//div[@class='btn-primary cookies-notice-accept']"))).click().build().perform();
		Thread.sleep(4000);
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		//js.executeScript("arguments[0].scrollIntoView();", element);
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);
		a.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).click().build().perform();
		//System.out.println(driver.getCurrentUrl());
	
		Set<String> wind = driver.getWindowHandles();
		for (String handle : wind) {
			if (!handle.equals(wind)) {
				driver.switchTo().window(handle);
				Thread.sleep(3000);
				System.out.println(driver.getTitle());
				//System.out.println(wind);
			}
		}
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
						
		
		
		
		
		
	}
	@After			
	public void logout() throws InterruptedException{
		
		Thread.sleep(4000);
		driver.quit();
	}

}
