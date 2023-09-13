package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	JavascriptExecutor js=(JavascriptExecutor) driver;
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
//	Elements 
	@FindBy(name="email") WebElement txtEmail;
	@FindBy(name="password") WebElement txtPassword;
	@FindBy(xpath="//button[@type='submit']") WebElement btnLogin;
	
//	Actions
	public void setTxtEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void setTxtPassword(String password) {
		txtPassword.sendKeys(password);
	}
	public void clickLoginBtn() {
		js.executeScript("arguments[0].click();", btnLogin);
//		btnLogin.click();
	}

	
}
