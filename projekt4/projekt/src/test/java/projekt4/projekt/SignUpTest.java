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
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.UUID;

import projekt4.projekt.SignUpForm;

public class SignUpTest {

	private static WebDriver driver;
	WebElement element;
	
	@BeforeClass
	public static void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void signUpButton() {
		driver.get("http://suscilowicz-books-at-home.herokuapp.com");
		element = driver.findElement(By.xpath("//a[contains(text(),'Sign up now!')]"));
		assertNotNull(element);
	}
	
	@Test
	public void signUpCorrectTest() {
		driver.get("http://suscilowicz-books-at-home.herokuapp.com/signup");
		SignUpForm form = new SignUpForm(driver);
		form.registration("Michal", UUID.randomUUID().toString() + "@gmail.com", "password", "password");
		assertTrue(true);
	}
	
	@Test
	public void signUpIncorrec1Test() {
		driver.get("http://suscilowicz-books-at-home.herokuapp.com/signup");
		SignUpForm form = new SignUpForm(driver);
		form.registration("Michal", "s.uscilowicz@gmail.com", "password", "password");
		element = driver.findElement(By.xpath("//ul/li[1]"));
		assertNotNull(element);
	}
	
	@Test
	public void signUpIncorrec2Test() {
		driver.get("http://suscilowicz-books-at-home.herokuapp.com/signup");
		SignUpForm form = new SignUpForm(driver);
		form.registration("Michal",  UUID.randomUUID().toString() + "@gmail.com", "password", "password1");
		element = driver.findElement(By.xpath("//ul/li[1]")); 
		assertNotNull(element);
	}
	
	
	
	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}