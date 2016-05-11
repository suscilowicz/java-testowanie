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

public class CRUDTest {

	private static WebDriver driver;
	WebElement element;
	
	@BeforeClass
	public static void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void booksUpdateTest(){
		driver.get("http://suscilowicz-books-at-home.herokuapp.com/login");
		LogInForm login = new LogInForm(driver);
		login.login("example@railstutorial.org", "foobar");
		driver.findElement(By.xpath("//a[contains(text(),'Books')]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Show')])[2]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
		element = driver.findElement(By.xpath("//input[@id='book_title']"));
		element.clear();
		element.sendKeys("All the King's Men");
		element = driver.findElement(By.xpath("//input[@id='book_author']"));
		element.clear();
		element.sendKeys("Wallace Nikolaus");
		
		assertNotNull(element);
		
		driver.findElement(By.xpath("//a[contains(text(),'Books')]")).click();
		
		driver.findElement(By.linkText("Account")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
	}
	
	@Test
	public void booksUpdateTest2(){
		driver.get("http://suscilowicz-books-at-home.herokuapp.com/login");
		LogInForm login = new LogInForm(driver);
		login.login("example@railstutorial.org", "foobar");
		driver.findElement(By.xpath("//a[contains(text(),'Books')]")).click();
		driver.findElement(By.xpath("//div/ul/li[4]/a")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Show')])[2]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
		element = driver.findElement(By.xpath("//input[@id='book_title']"));
		element.clear();
		element.sendKeys("This Lime Tree Bower");
		element = driver.findElement(By.xpath("//input[@id='book_author']"));
		element.clear();
		element.sendKeys("Brooks Olson");
		
		assertNotNull(element);
		
		driver.findElement(By.xpath("//a[contains(text(),'Books')]")).click();
		
		driver.findElement(By.linkText("Account")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
	}
	
	@AfterClass
	public static void cleanp() {
		driver.quit();
	}

}
