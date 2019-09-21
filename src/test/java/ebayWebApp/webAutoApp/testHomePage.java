package ebayWebApp.webAutoApp;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.generic.Basepage;

import pages.HomePage;


public class testHomePage extends Basepage{
		public HomePage home;
	public testHomePage() {
		super();
	}
	
	
	@BeforeMethod
	public void setUP() {
		initialization();
		home=new HomePage();  
	}
	@Test
	public void testSearchItem() {
		
		home.searchItem();
		
	}
	@AfterMethod
	public void tearDown() {
		//driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
}
