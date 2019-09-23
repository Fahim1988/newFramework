package pages;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.generic.Basepage;

import utilities.Helper;

public class HomePage extends Basepage {
	@FindBy(xpath="//input[@id='gh-btn']")
	WebElement searchButton;
	@FindBy(xpath="//input[@id='gh-ac']")
	WebElement searchBox;
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement signIn;
	@FindBy(xpath="//body[@class='desktop gh-flex']/div[@id='mainContent']/div[@class='hl-cat-nav']/ul[@class='hl-cat-nav__container']/li[3]/a[1]")
    WebElement motor;
	
	public List searchItems() {
	List<String>searchItem=new ArrayList<String>();
	searchItem.add("Iphone");
	searchItem.add("Samsung");
	searchItem.add("Bag");
	searchItem.add("Philips Electric Razor");
	return searchItem;
	}
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void searchItem() {
		List<String>searchItem=searchItems();
		for(int i=0;i<searchItem.size();i++) {
			searchBox.sendKeys(searchItem.get(i).toString());
		    searchButton.click();
		    searchBox.clear();
	} 
	}	
	public void hoveringElement() {
		Helper.HoverOverWebElement(motor);
	}
	
	public LoginPage signInPage() {
		signIn.click();
		return new LoginPage();
	}
	
	
	
	
	
	
	

}
