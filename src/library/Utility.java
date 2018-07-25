package library;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	
	public static void captureScreenshot(WebDriver driver, String screenshotname) {
		
		try {

			TakesScreenshot ts= ((TakesScreenshot)driver);
			
			File _sourse=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(_sourse, new File("./screenshots/"+ screenshotname+".png"));
			System.out.println("Screenshot taken");
			
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot - "+ e.getMessage());
			
		}
	}

}
