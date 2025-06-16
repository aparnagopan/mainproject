package RescueWayProject;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class homePageRescueway {
	
	WebDriver driver;
	
	@BeforeSuite
	
	   public void BrowserLaunch() {
			
			driver=new ChromeDriver();
			driver.get("https://rescueway.pythonanywhere.com/");
			driver.manage().window().maximize();
		}
		
	@BeforeMethod
	
	public void loginPage() {
		
		driver.navigate().to("https://rescueway.pythonanywhere.com/");
				
	}
	
	//TC14
	@Test
	public void mouseHoveringInHomePage() throws InterruptedException {
		
		
		WebElement home= driver.findElement(By.xpath("(//a[text()='Home'])[1]"));
		Actions h1= new Actions(driver);
		h1.moveToElement(home).build().perform();
		
		Thread.sleep(10);
		
        WebElement about= driver.findElement(By.xpath("//a[text()='About']"));
		Actions h2= new Actions(driver);
		h2.moveToElement(about).build().perform();
		Thread.sleep(10);
		
        WebElement service= driver.findElement(By.xpath("//a[text()='Service']"));
		Actions h3= new Actions(driver);
		h3.moveToElement(service).build().perform();
		Thread.sleep(10);
		
        WebElement pages= driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']"));
		Actions h4= new Actions(driver);
		h4.moveToElement(pages).build().perform();
		Thread.sleep(10);
		
        WebElement contact= driver.findElement(By.xpath("//a[text()='Contact']"));
		Actions h5= new Actions(driver);
		h5.moveToElement(contact).build().perform();
		Thread.sleep(10);
		
		WebElement signin= driver.findElement(By.xpath("//a[text()='SignIn']"));
		Actions h6= new Actions(driver);
		h6.moveToElement(signin).build().perform();
		Thread.sleep(10);
		
		WebElement signup= driver.findElement(By.xpath("//a[text()='SignUp']"));
		Actions h7= new Actions(driver);
		h7.moveToElement(signup).build().perform();
		Thread.sleep(10);
		
		
	}
	//TC15
	@Test
	
	public void aboutRedirection() {
		
			
		WebElement about=driver.findElement(By.xpath("//a[text()='About']"));
		about.click();
		String currentURL1= driver.getCurrentUrl();
		
		if(currentURL1.contains("https://rescueway.pythonanywhere.com/about/")) {
			System.out.println("redirection is succesfull on clicking About button");
		}
		else {
			System.out.println("redirection is failed");
		}
	}	
	
	//TC16
	@Test
	public void serviceRedirection() {
	WebElement service=driver.findElement(By.xpath("//a[text()='Service']"));
	service.click();
	String currentURL2= driver.getCurrentUrl();
	
	if(currentURL2.contains("https://rescueway.pythonanywhere.com/service/")) {
		System.out.println("redirection is succesfull on clicking service button");
	}
	else {
		System.out.println("redirection is failed");
	}
}
	//TC17
	@Test
	
	public void fAQRedirection() {
		
	driver.findElement(By.xpath("//small[text()='FAQs']")).click();
	
	String currentURL3= driver.getCurrentUrl();
	
	if(currentURL3.equals("https://rescueway.pythonanywhere.com/")) {
		System.out.println("redirection is failed on clicking FAQS button");
	}
	else {
		System.out.println("redirection is sucessfull");
	}
}	
	//TC18
	@Test
	
	public void supportRedirection() {
	
	driver.findElement(By.xpath("//small[text()='Support']")).click();
	
	String currentURL4= driver.getCurrentUrl();
	
	if(currentURL4.equals("https://rescueway.pythonanywhere.com/")) {
		System.out.println("redirection is failed on clicking support button");
	}
	else {
		System.out.println("redirection is sucessfull");
	}
}
	//TC19
	@Test
	
	public void privacyRedirection() {
	
	driver.findElement(By.xpath("//small[text()='Privacy']")).click();
	
	String currentURL5= driver.getCurrentUrl();
	
	if(currentURL5.equals("https://rescueway.pythonanywhere.com/")) {
		System.out.println("redirection is failed on clicking privacy button");
	}
	else {
		System.out.println("redirection is sucessfull");
	}
}
	//TC20
	@Test
	
	public void policyRedirection() {

	driver.findElement(By.xpath("//small[text()='Policy']")).click();
	
	String currentURL6= driver.getCurrentUrl();
	
	if(currentURL6.equals("https://rescueway.pythonanywhere.com/")) {
		System.out.println("redirection is failed on clicking Policy button");
	}
	else {
		System.out.println("redirection is sucessfull");
	}
}
	//TC21
	@Test
	
	public void careerRedirection() {
	
	driver.findElement(By.xpath("//small[text()='Career']")).click();
	
	String currentURL7= driver.getCurrentUrl();
	
	if(currentURL7.equals("https://rescueway.pythonanywhere.com/")) {
		System.out.println("redirection is failed on clicking Career button");
	}
	else {
		System.out.println("redirection is sucessfull");
	}
}
	//TC22
	@Test

	public void requestAfreeQuote() throws IOException {
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2100)");
		
		driver.findElement(By.xpath("//input[@id='form-floating-1']")).sendKeys("Demoname");
		driver.findElement(By.xpath("//input[@id='form-floating-2']")).sendKeys("demoname@gmail.com");
		WebElement element=driver.findElement(By.xpath("//select[@id='floatingSelect']"));
		Select s1=new Select(element);
		s1.selectByValue("2");
		driver.findElement(By.xpath("//button[@class='btn btn-primary w-100 h-100']")).click();
		
		String currentURL8= driver.getCurrentUrl();
		if(currentURL8.equals("https://rescueway.pythonanywhere.com/")) {
			System.out.println("Request is failed");
		}
		else {
			System.out.println("Request is sucessfull");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File F=ts.getScreenshotAs(OutputType.FILE);
		Files.copy(F, new File("D:\\project\\requestquote.jpg"));
	
		}
	
	   }		  
		

	@AfterSuite
	public void BrowserQuit() {
		
		driver.close();
	}

}
