package RescueWayProject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.google.common.io.Files;
import org.openqa.selenium.TakesScreenshot;


public class LoginRescueway {
	
	WebDriver driver;
	
	@BeforeSuite
	
   public void BrowserLaunch() {
		
		driver=new ChromeDriver();
		driver.get("https://rescueway.pythonanywhere.com/");
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	
	public void loginPage() {
		
		driver.navigate().to("https://rescueway.pythonanywhere.com/login/");
				
	}
	//TC01
	@Test
	public void validUsernameAndValidPasswordLogin() {
		
		driver.findElement(By.id("loginEmail")).sendKeys("admin123@gmail.com");
		driver.findElement(By.id("loginPassword")).sendKeys("admin123");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		WebElement button= driver.findElement(By.xpath("//button[@class='btn btn-secondary w-100']"));
		button.click();
			
	}

	//TC02
	@Test
	public void invalidUsernameAndInvalidPasswordLogin() {
		
		driver.findElement(By.id("loginEmail")).sendKeys("adm12@gmail.com");
		driver.findElement(By.id("loginPassword")).sendKeys("acvbgfr");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		
		WebElement button= driver.findElement(By.xpath("//button[@class='btn btn-secondary w-100']"));
		button.click();
	}
	//TC03
	@Test
	public void validUsernameAndInvalidPasswordLogin() {
		
		driver.findElement(By.id("loginEmail")).sendKeys("admin123@gmail.com");
		driver.findElement(By.id("loginPassword")).sendKeys("acfdvre");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		
		WebElement button= driver.findElement(By.xpath("//button[@class='btn btn-secondary w-100']"));
		button.click();
	}
	//TC04
	@Test
	public void invalidUsernameAndValidPasswordLogin() {
		
		driver.findElement(By.id("loginEmail")).sendKeys("avcvdr123@gmail.com");
		driver.findElement(By.id("loginPassword")).sendKeys("admin123");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		
		WebElement button= driver.findElement(By.xpath("//button[@class='btn btn-secondary w-100']"));
		button.click();
	}	
	//TC05	
	@Test
	public void emptyUsernameAndPasswordLogin() {
		
		driver.findElement(By.id("loginEmail")).sendKeys("");
		driver.findElement(By.id("loginPassword")).sendKeys("");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		
		WebElement button= driver.findElement(By.xpath("//button[@class='btn btn-secondary w-100']"));
		button.click();
	}
	//TC06
	@Test
	public void caseDifferentUsernameAndvalidPasswordLogin() {
		
		driver.findElement(By.id("loginEmail")).sendKeys("ADMIN123@gmail.com");
		driver.findElement(By.id("loginPassword")).sendKeys("admin123");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		
		WebElement button= driver.findElement(By.xpath("//button[@class='btn btn-secondary w-100']"));
		button.click();

}
	//TC07
	@Test
   public void validUsernameAndCaseDifferentPasswordLogin() {
		
		driver.findElement(By.id("loginEmail")).sendKeys("admin123@gmail.com");
		driver.findElement(By.id("loginPassword")).sendKeys("ADMIN123");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		
		WebElement button= driver.findElement(By.xpath("//button[@class='btn btn-secondary w-100']"));
		button.click();
}
	//TC08
	@Test
   public void forgotPasswordField() throws IOException {
	   driver.navigate().to("https://rescueway.pythonanywhere.com/login/");
	   
	   JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		
		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(10));
		
	   driver.findElement(By.xpath("//a[text()='Forgot Password?']")).click();
	   
	   w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control']")));
	   driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("admin123@gmail.com");
	   
	  driver.findElement(By.xpath("//button[text()='Send OTP']")).click();
	  
	  TakesScreenshot ts =(TakesScreenshot) driver;
	  File f = ts.getScreenshotAs(OutputType.FILE);
	  Files.copy(f, new File("D:\\project\\forgotpassword.jpg"));
   }
	
	@AfterSuite
	public void BrowserQuit() {
		
		driver.close();
	}


}
