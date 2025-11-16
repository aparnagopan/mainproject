package vertexStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LandingPageTest {
	WebDriver driver;
	
	@BeforeSuite
	
	public void browserLaunch() {
		
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://study.vertexstudys.com/index");		
	}
	
	@BeforeMethod
	public void home() {
		driver.get("https://study.vertexstudys.com/index");	
	}
	
  @Test
  public void contactButton() throws InterruptedException {
	  
	 WebElement button= driver.findElement(By.xpath("//span[text()='Contact']"));
	 button.click();
	 Thread.sleep(20);
	 String currentUrl=driver.getCurrentUrl();
	 String contactUrl="https://study.vertexstudys.com/pages/contact";
	 if (currentUrl.equals(contactUrl)) {
		 System.out.println("Contact Button has navigated correctly");
	 }
		 
		 else 
			 System.out.println("Contact button is not navigated to the correct Webpage");  
		 
}

  
@Test
public void registerButton() throws InterruptedException {
	
	WebElement button= driver.findElement(By.xpath("//a[@href='pages/register.php']"));
	 button.click();
	 Thread.sleep(20);
	 String currentUrl=driver.getCurrentUrl();
	 String registerUrl="https://study.vertexstudys.com/pages/register";
	 if (currentUrl.equals(registerUrl)) {
		 System.out.println("Register Button has navigated correctly");
	 }
		 
		 else 
			 System.out.println("Register button is not navigated to the correct Webpage");  
		 
}

@Test
public void loginButton() throws InterruptedException {
	
	WebElement button=driver.findElement(By.xpath("//a[@href='pages/login.php']"));
	button.click();
	
	Thread.sleep(20);
	
	String currentUrl=driver.getCurrentUrl();
	String loginUrl="https://study.vertexstudys.com/pages/login";
	if (currentUrl.equals(loginUrl)) {
		System.out.println("Login Button has navigated correctly");
	 }
		 
	else 
		System.out.println("Login button is not navigated to the correct Webpage");  
		 
}
@Test
public void hoverOverButton() {
	
}

@AfterSuite

public void quitBrowser() {
	
	driver.quit();
}
}

