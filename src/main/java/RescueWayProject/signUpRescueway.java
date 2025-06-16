package RescueWayProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class signUpRescueway {
	
	WebDriver driver;
	
	@BeforeSuite
	   public void BrowserLaunch() {
			
			driver=new ChromeDriver();
			driver.get("https://rescueway.pythonanywhere.com/");
			driver.manage().window().maximize();
		}
	
		//TC09
		@Test

		public void signupFromHomepage() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[text()='SignUp']")).click();
		
		Thread.sleep(20);
		
		String currentURL=driver.getCurrentUrl();
		
		if (currentURL.contains("https://rescueway.pythonanywhere.com/signup/")) {
		    System.out.println("Redirection successful to SignUp page from Home Page button.");
		} else {
		    System.out.println("Redirection failed to SignUp page from Home Page button . Current URL: " + currentURL);
		}
		}
		
		//TC10
		@Test
		public void signupFromLoginpage() {
			
			driver .navigate().to("https://rescueway.pythonanywhere.com/login/");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)");
			driver.findElement(By.xpath("//a[text()='Sign up here']")).click();
			
			String currentURL=driver.getCurrentUrl();
			
			if (currentURL.contains("https://rescueway.pythonanywhere.com/signup/")) {
			    System.out.println("Redirection successful to SignUp page.");
			} else {
			    System.out.println("Redirection failed. Current URL: " + currentURL);
			}
			
		}
			//TC11
			@Test
		public void Validsignupfill() {
			
			driver.navigate().to("https://rescueway.pythonanywhere.com/signup/");
		
			driver.findElement(By.name("full_name")).sendKeys("Entridemo");
			driver.findElement(By.name("email")).sendKeys("entridemo@gmail.com");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)");
			
			driver.findElement(By.name("phone_number")).sendKeys("23456754");
			driver.findElement(By.name("password")).sendKeys("entridemo123");
			driver.findElement(By.name("confirm_password")).sendKeys("entridemo123");
			driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
			
			String currentURL=driver.getCurrentUrl();
			
			if (currentURL.contains("https://rescueway.pythonanywhere.com/login/")) {
			    System.out.println("signup is succesfull");
			} else {
			    System.out.println("signup failed "+ currentURL);
			}
			
			
		}
			//TC12
			@Test
		public void signupWithMismatchPasswords() {
			
			driver.navigate().to("https://rescueway.pythonanywhere.com/signup/");
			
			driver.findElement(By.name("full_name")).sendKeys("demo");
			driver.findElement(By.name("email")).sendKeys("demo@gmail.com");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)");
			
			driver.findElement(By.name("phone_number")).sendKeys("2345456754");
			driver.findElement(By.name("password")).sendKeys("demo123");
			driver.findElement(By.name("confirm_password")).sendKeys("demo9876");
			driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
			
			String currentURL=driver.getCurrentUrl();
			
			if (currentURL.contains("https://rescueway.pythonanywhere.com/login/")) {
			    System.out.println("signup is succesfull");
			} else {
			    System.out.println("signup failed "+currentURL);
			}
			
			
		}
			//TC13
			@Test
		public void signupWithEmptyFields() {
			
			driver.navigate().to("https://rescueway.pythonanywhere.com/signup/");
						
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)");
			
			driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
			
			String currentURL=driver.getCurrentUrl();
			
			if (currentURL.contains("https://rescueway.pythonanywhere.com/login/")) {
			    System.out.println("signup is succesfull");
			} else {
			    System.out.println("signup failed "+currentURL);
			}
			
			
		}
			
		@AfterSuite
		 public void BrowserQuit() {
				
				driver.close();
			}

	
}
