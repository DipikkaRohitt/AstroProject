import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class combinResult {
	
	WebDriver driver;
	
	@Test
	public void amazonWeb() {
		System.setProperty("webdriver.chrome.driver", "D:\\Soft_testing\\Java\\Setup_and_configuration\\chrome\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		//opening browser
		driver.get("https://www.amazon.com/");
		String websiteName= driver.getTitle();
		System.out.println("Name of the website is:"+websiteName);
		
		//finding iPhone7
		driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']")).sendKeys("iPhone7");
		driver.findElement(By.xpath(".//*[@id='nav-search']/form/div[2]/div/input")).click();
		
		
		//scrolling down
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("scroll(0,400)");
		
		/* getting all results
		String p = "t";
		int i = 0;
		while(!p.equals(""))
	    {
			System.out.println(p);
	    	p = driver.findElement(By.xpath(".//*[@id='result_"+i+"']/div/div/div/div[2]/div[2]/div[1]/div[1]/a/span[2]/span")).getText();
	    	if(p==null || p=="")
	    		p = driver.findElement(By.xpath(".//*[@id='result_"+i+"']/div/div/div/div[2]/div[2]/div[1]/div/div/a/span[2]")).getText();
			System.out.println(p+" "+p.equals(""));
	    	i++;
	    }
	    */
		
		//getting product name
		driver.findElement(By.xpath(".//*[@id='rot-B01NCYY6OK']/div/a/div/img")).click();
		String productName= driver.getTitle();
		System.out.println("Name of the Product is:"+productName);
		
		//getting product price	
		String price = driver.findElement(By.xpath(".//div[@id='price']/table/tbody/tr/td/span[1]")).getText();
		System.out.println("Price of the product is:"+price);
		
		//getting product URL
		String link1=driver.getCurrentUrl();
		System.out.println("Link to the product:"+link1);
		
	}
	
	@AfterMethod
	public void ebayWeb() {
		
		//opening browser
		driver.get("https://www.ebay.com/");
		String websiteName2=driver.getTitle();
		System.out.println("Name of the Website is:"+websiteName2);
		
		//finding iPhone7
		driver.findElement(By.xpath(".//*[@id='gh-ac']")).sendKeys("iPhone7");
		driver.findElement(By.xpath(".//*[@id='gh-btn']")).click();
		
		//scrolling down
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("scroll(0,300)");
		
		//getting product name
		driver.findElement(By.xpath(".//*[@id='srp-river-results-listing1']/div/div[2]/a/h3"));
		String productName2= driver.getTitle();
		System.out.println("Name of the product is:"+productName2);
		
		String price2 = driver.findElement(By.xpath(".//*[@id='srp-river-results-listing1']/div/div[2]/div[4]/div[1]/span")).getText();
		System.out.println("Price of the product is:"+price2);
				
		
		String link2=driver.getCurrentUrl();
		System.out.println("Link to the product:"+link2);
	}

}
