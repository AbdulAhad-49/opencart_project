package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
//	Element
	@FindBy(name="firstname") WebElement txtFirstName;
	@FindBy(name="lastname") WebElement txtLastName;
	@FindBy(name="email") WebElement txtEmail;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement txtPassword;
	@FindBy(xpath="//input[@name='agree']") WebElement btnPolicy;
	@FindBy(xpath="//button[@type='submit']") WebElement btnContinue;
	@FindBy(xpath="//h1[contains(text(),'Your Account Has Been Created!')]") WebElement msgConfirmation;
	
	
//	Actions 
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	public void clickPolicyBtn() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",btnPolicy );
//		btnPolicy.click();
	}
	public void clickContinueBtn() {
//		btnContinue.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",btnContinue );

	}
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		}
		catch(Exception e) {
			return (e.getMessage());
		}
	}
}
