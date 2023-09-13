package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;

public class MyAccountPage extends BasePage{
	JavascriptExecutor js=(JavascriptExecutor) driver;
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

//	Element
	@FindBy(xpath="//div[@id='content']/h2[contains(text(),'My Account')]") WebElement txtMyAcount;
	@FindBy(xpath="//aside[@id='column-right']/div/a[contains(text(),'Logout')]") WebElement lnkLogout;
//	Actions 
	public boolean isMyAccountPageExists() {
		try {
			return txtMyAcount.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}
	public void clickLogout() {
		js.executeScript("arguments[0].click();",lnkLogout );
	}
}
