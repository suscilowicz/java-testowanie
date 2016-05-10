package projekt4.projekt;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInTest {
	private static WebDriver driver;
	WebElement element;
	static String driverPath = "IE driver path";
	
	@BeforeClass
	public static void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void logInButton(){
		driver.get("http://suscilowicz-books-at-home.herokuapp.com");
		element = driver.findElement(By.xpath("//a[contains(text(),'Log in')]"));
		assertNotNull(element);
	}
	
	@Test
	public void logInCorrect(){
		driver.get("http://suscilowicz-books-at-home.herokuapp.com/login");
		LogInForm login = new LogInForm(driver);
		login.login("example@railstutorial.org", "foobar");
		element = driver.findElement(By.linkText("Account"));
		assertNotNull(element);
		
	}
	@AfterClass
	public static void cleanp() {
		driver.quit();
	}

}
