package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

	// constructor
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	// locators
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstName;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastName;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telephone;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement conPassowrd;
	@FindBy(xpath = "//label[normalize-space()='Yes']")
	WebElement radioButton;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement agreeButton;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement submitButton;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement ConfirmMsg;

	// actions
	JavascriptExecutor Js = (JavascriptExecutor) driver;

	public void firstName(String fname) {
		firstName.sendKeys(fname);
	}

	public void lastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void email(String mail) {
		email.sendKeys(mail);
	}

	public void phone(String num) {
		telephone.sendKeys(num);
	}

	public void password(String password1) {
		password.sendKeys(password1);
	}

	public void ConPassword(String conpassword) {
		conPassowrd.sendKeys(conpassword);
	}

	public void condition() {
		Js.executeScript("arguments[0].click()", agreeButton);
	}

	public void continueButton() {
		Js.executeScript("arguments[0].click()", submitButton);
	}

	public String confirmMsg() {
		try {
			return ConfirmMsg.getText();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
