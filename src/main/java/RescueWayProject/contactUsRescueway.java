package RescueWayProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class contactUsRescueway {
	
	WebDriver driver;

 @BeforeSuite

 public void browserLaunch() {
	 
			
			driver=new ChromeDriver();
			driver.get("https://rescueway.pythonanywhere.com/");
			driver.manage().window().maximize();

}
 
 @BeforeMethod
  public void loginPage() {
		
		driver.navigate().to("https://rescueway.pythonanywhere.com/contact/");
		
  }
 
 
 //TC26
	@Test
	
 public void contactRescueway() throws InterruptedException {
		

		driver=new ChromeDriver();
		driver.get("https://rescueway.pythonanywhere.com/");
		driver.manage().window().maximize();
		driver.navigate().to("https://rescueway.pythonanywhere.com/contact/");
		
		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='display-5 mb-4']")));
		
		driver.findElement(By.id("form-floating-1")).sendKeys("demo");
		driver.findElement(By.id("form-floating-2")).sendKeys("demo123@gmail.com");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,800)");
		
		
		driver.findElement(By.id("form-floating-3")).sendKeys("sample demo");
		driver.findElement(By.id("form-floating-4")).sendKeys("this is a sample for the demo");
				
		String beforeSubmiturl = driver.getCurrentUrl();
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		Thread.sleep(3000); 

		String afterSubmiturl = driver.getCurrentUrl();

		if (!beforeSubmiturl.equals(afterSubmiturl)) {
		    System.out.println("Contact form submitted (URL changed)");
		} else {
		    System.out.println("No URL change. submission status uncertain");
		}
		

    }
	
	@AfterSuite
	public void BrowserQuit() {
		
		driver.close();
	}

	
}
