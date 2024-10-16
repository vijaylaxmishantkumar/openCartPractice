package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	//constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	@FindBy(xpath = "//span[normalize-space()='My Account']") WebElement myAccount;
	@FindBy(xpath = "//a[normalize-space()='Register']") WebElement register;
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement login;
	
	JavascriptExecutor Js = (JavascriptExecutor) driver;
	
	//actions
	public void clickMyAccount() {
		myAccount.click();
	}
	
	public void clickRegister() {
		Js.executeScript("arguments[0].click()", register);
	}
	
	public void clickLogin() {
		Js.executeScript("arguments[0].click()", login);
	}
}
