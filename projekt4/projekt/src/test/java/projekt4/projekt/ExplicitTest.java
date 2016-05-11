package projekt4.projekt;

import static org.junit.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ExplicitTest {
	private static WebDriver driver;
	WebElement element;
	
	@BeforeClass
	public static void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void BooksAtHomeButtonOnNavbarTest() {
		driver.get("http://suscilowicz-books-at-home.herokuapp.com");
		WebDriverWait wait=new WebDriverWait(driver,10);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Books At Home')]")));
		assertNotNull(element);
	}
	
	@AfterClass
	public static void cleanp() {
		driver.quit();
	}

}
