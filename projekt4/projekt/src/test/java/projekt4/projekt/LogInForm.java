package projekt4.projekt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInForm {
	@FindBy(xpath="//input[@id='session_email']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@id='session_password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@name='commit']")
	private WebElement button;
	
	public LogInForm(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void login (String email, String password){
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		button.click();
	}

}
