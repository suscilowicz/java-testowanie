package lab10.ex2;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AppTest {

	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void driverSetup() {
		// ChromeDrirver, FireforxDriver, ...
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void searchInNewWindow() throws InterruptedException{
		driver.get("http://wikipedia.pl/");
		String parentWindow = driver.getWindowHandle();
		WebElement link = driver.findElement(By.xpath("//a[contains(text(),'Losuj artykuł')]"));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
		Set <String> set = driver.getWindowHandles();
	    Iterator<String> it = set.iterator();
	    String parentWindowId = it.next();
	    String childWindowId = it.next();
		driver.switchTo().window(parentWindowId);
		driver.close();
	    driver.switchTo().window(childWindowId);
		driver.findElement(By.xpath("//input[@id='searchInput']")).clear();
		driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("Uniwersytet Gdański");
		driver.findElement(By.xpath("//input[@id='searchButton']")).click();
		assertTrue(true);
	}
	
	@Test
	public void titleInNewWindow() throws InterruptedException{
		driver.get("http://wikipedia.pl/");
		String parentWindow = driver.getWindowHandle();
		WebElement link = driver.findElement(By.xpath("//a[contains(text(),'Najlepsze artykuły')]"));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
		Set <String> set = driver.getWindowHandles();
	    Iterator<String> it = set.iterator();
	    String parentWindowId = it.next();
	    String childWindowId = it.next();
		driver.switchTo().window(parentWindowId);
		driver.close();
	    driver.switchTo().window(childWindowId);
	    String title = driver.getTitle();
	    String expected = "Wikipedia:Wyróżniona zawartość Wikipedii – Wikipedia, wolna encyklopedia";
	    assertEquals(title, expected);
	}
	
	@Test
	public void backToMainPage() throws InterruptedException{
		driver.get("http://wikipedia.pl/");
		String parentWindow = driver.getWindowHandle();
		WebElement link = driver.findElement(By.xpath("//a[contains(text(),'Losuj artykuł')]"));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
		Set <String> set = driver.getWindowHandles();
	    Iterator<String> it = set.iterator();
	    String parentWindowId = it.next();
	    String childWindowId = it.next();
		driver.switchTo().window(parentWindowId);
		driver.close();
	    driver.switchTo().window(childWindowId);
	    driver.findElement(By.xpath("//div[@id='p-logo']/a")).click();
	    String title = driver.getTitle();
	    String expected = "Wikipedia, wolna encyklopedia";
	    assertEquals(title, expected);
	}
	
	
	
	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}
