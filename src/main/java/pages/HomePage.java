package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.generic.Basepage;

public class HomePage extends Basepage {
	@FindBy(xpath="//input[@id='gh-btn']")
	WebElement searchButton;
	@FindBy(xpath="//input[@id='gh-ac']")
	WebElement searchBox;
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement signIn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void searchItem() {
		searchBox.sendKeys("IPHONE");
		searchButton.click();
	}
	public LoginPage signInPage() {
		signIn.click();
		return new LoginPage();
	}
	
	
	
	
	
	
	

}
