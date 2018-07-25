import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
//import org.testng.annotations.*;
//import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import library.Utility;

public class astroTest {
	
	WebDriver driver;
	
	@Test
	public void timingsAstro() {
		System.setProperty("webdriver.chrome.driver", "D:\\Soft_testing\\Java\\Setup_and_configuration\\chrome\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		long startTime = 0;
		long endTime = 0;
		long totalTime = 0;
		
		driver.get("http://www.astro.com.my/");
		Utility.captureScreenshot(driver, "astro1");
		
		//for capturing screenshot of pop up
		Utility.captureScreenshot(driver, "astro2"); 
		
		//returning on home page and taken screenshot
		startTime = System.currentTimeMillis();
		
		driver.findElement(By.xpath(".//*[@id='STO-Pop']/section/div[1]/img")).click();
		Utility.captureScreenshot(driver, "astro3");
		
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Total Time for returing home page: " + totalTime + " milliseconds"); //printing response time
		
		//As per HINT, I am checking footer element loaded or not. If loaded means full site loaded.
		//startTime = System.currentTimeMillis();
		
		WebElement LoginButton = driver.findElement(By.id("acm_footer"));
	    if( LoginButton.equals(null))
	     System.out.println("Cant find Login Button");

	       Wait<WebDriver> wait = new WebDriverWait(driver, 5);
	        // Wait for search to complete
	    wait.until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver webDriver) {
	                System.out.println("Searching...");
	                return webDriver.findElement(By.id("acm_footer")) !=
	null;
	            }
	        });

	    System.out.println("Footer Element Loaded: "+LoginButton.getTagName());
		System.out.println("Website Loaded Successfully");
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Total Time to Load full website: " + totalTime + "	milliseconds"); //printing response time
		Utility.captureScreenshot(driver, "SiteLoaded");
				
	}
	
	//@AfterMethod
	/*public void TearDown(ITestResult result) {
		if(ITestResult.FAILURE==result.getStatus());
		{
			//System.out.println(result.getName());
			Utility.captureScreenshot(driver, result.getName());
		}
		
		
	}*/

}

