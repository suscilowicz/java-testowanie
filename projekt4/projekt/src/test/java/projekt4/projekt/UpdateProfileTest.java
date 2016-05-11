package projekt4.projekt;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdateProfileTest {
	private static WebDriver driver;
	WebElement element;
	
	@BeforeClass
	public static void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void editProfileCorrect() {
		driver.get("http://suscilowicz-books-at-home.herokuapp.com/login");
		LogInForm login = new LogInForm(driver);
		UpdateForm update = new UpdateForm(driver);
		login.login("example@railstutorial.org", "foobar");
		driver.findElement(By.linkText("Account")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Settings')]")).click();
		update.update("Example User", "example@railstutorial.org", "foobar", "foobar");
		driver.findElement(By.linkText("Account")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		assertTrue(true);
	}
	
	@Test
	public void editProfileCorrect2() {
		driver.get("http://suscilowicz-books-at-home.herokuapp.com/login");
		LogInForm login = new LogInForm(driver);
		UpdateForm update = new UpdateForm(driver);
		login.login("example@railstutorial.org", "foobar");
		driver.findElement(By.linkText("Account")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Settings')]")).click();
		update.update("Example User", "example@railstutorial.org", "", "");
		driver.findElement(By.linkText("Account")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		assertTrue(true);
	}
	
	@Test
	public void editProfileIncorrect() {
		driver.get("http://suscilowicz-books-at-home.herokuapp.com/login");
		LogInForm login = new LogInForm(driver);
		UpdateForm update = new UpdateForm(driver);
		login.login("example@railstutorial.org", "foobar");
		driver.findElement(By.linkText("Account")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Settings')]")).click();
		update.update("Example User", "example@railstutorial.org", "foobar", "foobarrrr");
		element = driver.findElement(By.xpath("//ul/li[1]"));
		driver.findElement(By.linkText("Account")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		assertNotNull(element);	
	}
	
	
	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}
