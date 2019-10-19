package test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ReadingExcel {
	WebDriver driver;
	FileInputStream fi;
	File f;
	XSSFWorkbook wb;
	XSSFSheet sh;

	@Test
	public void test() throws IOException{
		f = new File("D:\\GitHub_Samples\\CPSATchallenge\\WoodlandData.xlsx");
		fi = new FileInputStream(f);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheetAt(0);
		
		int rowcount = sh.getLastRowNum();
		for (int i = 1; i < rowcount+1; i++) {
			System.out.println(sh.getRow(i).getCell(0).getStringCellValue());
		}
	}
}
