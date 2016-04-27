package lab10.ex3;

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


public class AppTest {

	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void goodSearch()
	{
		driver.get("http://allegro.pl");
		allegroSearch search = new allegroSearch(driver);
		search.search("lenovo");
		String title = "Lenovo - Allegro.pl - Więcej niż aukcje. Najlepsze oferty na największej platformie handlowej.";
		assertEquals(title, driver.getTitle());
	}
	
	@Test
	public void badSearch()
	{
		driver.get("http://allegro.pl");
		allegroSearch search = new allegroSearch(driver);
		search.search("bbbbbbbbbbbbbbbbb");
		WebElement element = driver.findElement(By.xpath("//*[contains(text(), 'Wygląda na to, że nie mamy tego, czego szukasz.')]"));
		assertNotNull(element);
	}
	

	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}
