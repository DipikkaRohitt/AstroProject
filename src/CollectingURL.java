import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CollectingURL
{
 
   public static List<String> errorList = new ArrayList<String>();
   ExecutorService executor;
   ChromeDriver driver;
  
   @Test
   public void URLCheckTest()
   {
 
       int MYTHREADS = 30;
       executor = Executors.newFixedThreadPool(MYTHREADS);
       System.setProperty("webdriver.chrome.driver", "D:\\Soft_testing\\Java\\Setup_and_configuration\\chrome\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
       driver.navigate().to("http://www.astro.com.my/");
       List<WebElement> list = driver.findElements(By.xpath(".//a[@href!='']"));
 
       for (int i = 0; i < list.size(); i++) {
           WebElement element = list.get(i);
           Runnable worker = new MyRunnable(element);
           executor.execute(worker);
       }
       executor.shutdown();
 
       while (!executor.isTerminated()) {
       }
       if(errorList.size()>0) {
           for (String link: errorList
                ) {
               System.out.println("Url = "+link);
           }
           Assert.assertTrue(false);
       }
 
   }
 
   private static void sendGet(WebElement element) throws Exception{
       String href = element.getAttribute("href");
 
           URL url = new URL(href);
           HttpURLConnection connection = (HttpURLConnection)url.openConnection();
           connection.setRequestMethod("GET");
           connection.connect();

           int code = connection.getResponseCode();
           System.out.println("Response code of the object is "+code);
           if(code!=200)
               errorList.add(href);
           
   }
 
 
   public static class MyRunnable implements Runnable {
       private final WebElement hrefEl;
 
       MyRunnable(WebElement el) {
           this.hrefEl = el;
       }
 
       @Override
       public void run() {
 
           try {
			sendGet(hrefEl);
		} catch (Exception e) {
			e.printStackTrace();
		}
       }
   }
   
 
}
