package projekt4.projekt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateForm {
	@FindBy(xpath="//input[@id='user_name']")
	private WebElement nameField;
	
	@FindBy(xpath="//input[@id='user_email']")
	private WebElement emailField;

	@FindBy(xpath="//input[@id='user_password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@id='user_password_confirmation']")
	private WebElement passwordConfirmationField;
	
	@FindBy(xpath="//input[@name='commit']")
	private WebElement button;
	
	public UpdateForm(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void update(String name, String email, String password, String passwordConfirmation) {
		nameField.clear();
		emailField.clear();
		nameField.sendKeys(name);
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		passwordConfirmationField.sendKeys(passwordConfirmation);
		button.click();
	}
}
