package projekt4.projekt;


import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CRUDTest {

	private static WebDriver driver;
	WebElement element;
	WebElement element2;
	
	@BeforeClass
	public static void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void bookCreateTest() {
		driver.get("http://suscilowicz-books-at-home.herokuapp.com/login");
		LogInForm login = new LogInForm(driver);
		login.login("example@railstutorial.org", "foobar");
		String parentWindow = driver.getWindowHandle();
		WebElement link = driver.findElement(By.xpath("//a[contains(text(),'Books')]"));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
		Set <String> set = driver.getWindowHandles();
	    Iterator<String> it = set.iterator();
	    String parentWindowId = it.next();
	    String childWindowId = it.next();
		driver.switchTo().window(parentWindowId);
		driver.close();
	    driver.switchTo().window(childWindowId);
	    driver.findElement(By.xpath("//a[contains(text(),'Add New Book')]")).click();
	    element = driver.findElement(By.xpath(" //input[@id='book_title']"));
	    element.clear();
	    element.sendKeys("Jak zarobic i sie nie narobic");
	    element = driver.findElement(By.xpath("//input[@id='book_author']"));
	    element.clear();
	    element.sendKeys("Sebastian U.");
	    driver.findElement(By.xpath("//input[@name='commit']"));
	    driver.findElement(By.linkText("Account")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		assertTrue(true);
	}
	
	@Test
	public void bookDeleteTest(){
		driver.get("http://suscilowicz-books-at-home.herokuapp.com/login");
		LogInForm login = new LogInForm(driver);
		login.login("example@railstutorial.org", "foobar");
		driver.findElement(By.xpath("//a[contains(text(),'Books')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'3')]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Destroy')])[18]")).click();
		Alert alert = driver.switchTo().alert();
        alert.accept();
		//element = driver.findElement(By.xpath("//*[contains(text(), 'We're sorry, but something went wrong')]"));
		driver.findElement(By.className("dialog"));
		driver.navigate().back();
		driver.findElement(By.linkText("Account")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
	}
	@AfterClass
	public static void cleanp() {
		driver.quit();
	}

}
