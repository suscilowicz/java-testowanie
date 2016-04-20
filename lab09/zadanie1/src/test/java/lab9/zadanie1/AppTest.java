package lab9.zadanie1;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


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
	public void goodUrl(){
		driver.get("http://allegro.pl/");
		
		element = driver.findElement(By.id("main-search-text"));
		assertNotNull(element);
	}
	
	@Test
	public void badUrl(){
		driver.get("http://aalllegro.pl/");
		try {
			 WebElement element = driver.findElement(By.id("main-search-text"));
			
		} catch (NoSuchElementException e) {
			assert(true);
		}
	}
	
	@Test
	public void searchPage(){
		driver.get("http://allegro.pl/");
		driver.findElement(By.id("main-search-text")).clear();
		driver.findElement(By.id("main-search-text")).sendKeys("lenovo");
		driver.findElement(By.xpath("//input[@value='Szukaj']")).click();
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    assertNotNull(screenshot);

		try {
			FileUtils.copyFile(screenshot, new File("c:\\tmp\\selenium\\lenovo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}
	
	@Test
	public void searchPageBadSearch(){
		driver.get("http://allegro.pl/");
		driver.findElement(By.id("main-search-text")).clear();
		driver.findElement(By.id("main-search-text")).sendKeys("bbbbbbbbbbbbbbbbb");
		driver.findElement(By.xpath("//input[@value='Szukaj']")).click();
		WebElement element = driver.findElement(By.xpath("//*[contains(text(), 'Wygląda na to, że nie mamy tego, czego szukasz.')]"));
		assertNotNull(element);
	}
	
	@Test
	public void pustyKoszyk(){
		driver.get("http://allegro.pl/");
		
		driver.findElement(By.xpath("//span[@class='sprite']")).click();
		WebElement element = driver.findElement(By.xpath("//*[contains(text(), 'Twój koszyk jest pusty.')]"));
		assertNotNull(element);
		
	}
	
	
	
	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}
