package lab10.ex1;

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
	public void searchPage(){
		driver.get("http://wikipedia.pl/");
		driver.findElement(By.xpath("//input[@id='searchInput']")).clear();
		driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("Uniwersytet Gdański");
		driver.findElement(By.xpath("//input[@id='searchButton']")).click();
		driver.findElement(By.xpath("//input[@id='asdasdasdas']")).click();
	}
	
	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}
