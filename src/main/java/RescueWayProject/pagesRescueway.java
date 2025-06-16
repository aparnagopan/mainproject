package RescueWayProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class pagesRescueway {
	
	WebDriver driver;
	
	@BeforeSuite
	
	public void websiteLogin() {
		
		driver =new ChromeDriver();
		driver.get("https://rescueway.pythonanywhere.com/login/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("loginEmail")).sendKeys("admin123@gmail.com");
		driver.findElement(By.id("loginPassword")).sendKeys("admin123");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		WebElement button= driver.findElement(By.xpath("//button[@type='submit' and text()='Login']"));
		button.click();
		
	}
	
	//TC23
	@Test
	
	public void reportDisaster() throws InterruptedException {
		
		driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle'])[1]")).click();
		
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(5));
				
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Report Disaster']")));
		
		driver.findElement(By.xpath("//a[text()='Report Disaster']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Report a Disaster']")));
		
		WebElement select1=driver.findElement(By.xpath("//select[@id='type']"));
		Select s1=new Select(select1);
		s1.selectByValue("Fire");
		 
		 driver.findElement(By.xpath("//input[@placeholder='Enter the disaster name']")).sendKeys("demodisaster");
		 
		 JavascriptExecutor Js=(JavascriptExecutor)driver;
		 Js.executeScript("window.scroll(0,700)");
		  
		 WebElement location=driver.findElement(By.xpath("//button[text()='Use Current Location']"));
		
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", location);
		 Thread.sleep(500); 
		 location.click();
		 
		 WebElement datefield= driver.findElement(By.xpath("//input[@id='date']"));
		
		 Js.executeScript(("arguments[0].value='2025-06-11 15:30';"), datefield);
		 driver.findElement(By.id("description")).sendKeys("this is a demo for automation");
		
		 Js.executeScript("window.scroll(0,1000)");
		 
		 WebElement status=driver.findElement(By.xpath("//select[@id='status']"));
		 Select s2=new Select(status);
		 s2.selectByValue("Resolved");
		 
		 driver.findElement(By.xpath("//button[text()='Submit Report']")).click();
		 
		 String currentURL=driver.getCurrentUrl();
		 

			if(currentURL.contains("https://rescueway.pythonanywhere.com/disaster_list/")) {
				System.out.println("sucessfully Reported disaster Form");
			}
			else {
				System.out.println("Reporting disaster form is failed");
			}
		
		
				

	}
	
	//TC24
	@Test
	
	public void createAlert() {
		
       		
		driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle'])[1]")).click();
		
		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Create Alert']")));
		
		driver.findElement(By.xpath("//a[text()='Report Disaster']")).click();
		
		WebElement selectdisaster= driver.findElement(By.xpath("//select[@name='disaster_id']"));
		Select s1= new Select(selectdisaster);
		s1.selectByValue("6");
		
		driver.findElement(By.xpath("//textarea[@name='alert_message']")).sendKeys("demo alert create");
		driver.findElement(By.xpath("//button[text()='Create Alert']")).click();
		
		String currentURL=driver.getCurrentUrl();
		
		if(currentURL.equals("https://rescueway.pythonanywhere.com/alerts/")) {
			
			System.out.println("alert is created succesfully");
		}
		else {
			System.out.println("alert is not created");
		}
		
	}
	
	//TC25
	@Test
	 
	public void startNewCampaign() {
		

		driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle'])[1]")).click();
		
		WebDriverWait Wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Campaign']")));
		driver.findElement(By.xpath("//a[text()='Campaign']")).click();
		
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Start a New Fundraising Campaign']")));
		
		driver.findElement(By.xpath("//input[@id='title']")).sendKeys("Demo");
		driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("checking the demo");
		driver.findElement(By.xpath("//input[@id='goal_amount']")).sendKeys("123000");
		
		driver.findElement(By.xpath("//input[@id='end_date']")).sendKeys("23-MAR-2025");
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click(); 
		
		String currentURL=driver.getCurrentUrl();
		
		if(currentURL.equals("https://rescueway.pythonanywhere.com/campaign_list/")) {
			
			System.out.println("New Campaign is submitted succesfully");
		}
		else {
			System.out.println("New Campaign is not Submitted");
		}
		
		}
	
		

	@AfterSuite
	public void BrowserQuit() {
		
		driver.close();
	}

}
