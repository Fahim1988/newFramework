package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.Basepage;

public class LoginPage extends Basepage {
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="userid")
	WebElement userName;
	@FindBy(id="pass")
	WebElement password;
	@FindBy(id="sgnBt")
	WebElement signInButton;
	
	
	public void signInProcess(String userId,String Password) {
		userName.sendKeys(userId);
		password.sendKeys(Password);
		signInButton.click();
		
	}
	
	
	
	
}
