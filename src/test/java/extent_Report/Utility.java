package extent_Report;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {

	public static String getScreenshot(WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String path = System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
		
		File destination = new File(path);
		
		try {
			FileUtils.copyFile(src, destination);
			
		} catch (IOException e) {
			System.out.println("capture failed "+ e.getMessage());
		}
		return path;
		//FileUtils.copyFile(src, new File("E:/ScreenShot/"+System.currentTimeMillis()+".png"));
		
	}
	/*public static void main(String[] args) {
		List l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		System.out.println(l);
		Collections.reverse(l);
		System.out.println(l);
	}*/
	
}

