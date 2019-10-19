package test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Number6 {
	WebDriver driver;
	FileInputStream fi;
	File f;
	XSSFWorkbook wb;
	XSSFSheet sh;
	
	@BeforeTest
	public void Lauch() {
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(" https://www.woodlandworldwide.com/");
		
		
	}
	@Test
	public void testdata() throws IOException, InterruptedException {
		f = new File("D:\\GitHub_Samples\\CPSATchallenge\\WoodlandData.xlsx");
		fi = new FileInputStream(f);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheetAt(0);
		
		int rowcount = sh.getLastRowNum();
		for (int i = 1; i < rowcount+1; i++){
		
		driver.findElement(By.xpath("//form[@id='searchForm']/div")).click();
		driver.findElement(By.xpath("//div[@class='searchDiv zoomIn animated']")).sendKeys(sh.getRow(i).getCell(0).getStringCellValue());
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		driver.findElement(By.xpath("//label[@class='spirit-bg radio1']")).click();

		
		//		System.out.println(rowcount);
	}
	}
	
	@AfterTest
	public void Logout(){
		driver.quit();
	}

}
