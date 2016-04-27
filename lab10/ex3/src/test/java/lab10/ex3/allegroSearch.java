package lab10.ex3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class allegroSearch {

	@FindBy(id="main-search-text")
	private WebElement searchField;
	
	@FindBy(xpath="//input[@value='Szukaj']")
	private WebElement searchButton;
	
	public allegroSearch(WebDriver driver) {
	  PageFactory.initElements(driver, this);
	}

	public void search(String search) {
	  searchField.sendKeys(search);
	  searchButton.click();
	}
	
}
