package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginAccountPage extends BasePage {
	
	public LoginAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Username;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement LoginButton;
	
	JavascriptExecutor Js = (JavascriptExecutor) driver;
	
	public void setUsername(String username) {
		Username.sendKeys(username);
	}
	
	public void setPassword(String password) {
		Password.sendKeys(password);
	}
	
	public void clickLoginButton() {
		Js.executeScript("arguments[0].click()", LoginButton);
	}

}
