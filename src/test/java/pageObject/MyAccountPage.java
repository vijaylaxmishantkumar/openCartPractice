package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement textHeading;
	
	public boolean isMyAccountDisplayed() {
		try {
			return textHeading.isDisplayed(); 
		}
		catch(Exception e) {
			return false;
		}
	}
	
	@FindBy(xpath= "//div[@class='list-group']//a[text()='Logout']")
	WebElement logout;
	
	public void clickLogout() {
		logout.click();
	}
}
