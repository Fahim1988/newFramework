package ebayWebApp.webAutoApp;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.generic.Basepage;

import junit.framework.Assert;
import pages.HomePage;
import pages.LoginPage;
import utilities.DataReader;

public class testLoginPage extends Basepage {
	HomePage home;
	LoginPage login;
	String path="C:\\Users\\fahim\\eclipse-workspace\\webAutoApp\\src\\main\\resources\\login.xlsx";
	String sheetName="sheet1";
	public testLoginPage() {
		super();
	}
	
	@BeforeMethod
	public void setUP() {
		initialization();
		home=new HomePage();
		login=new LoginPage();
	}
	
	@DataProvider
	public Object[][] supplyData() throws IOException{
		Object[][]data=DataReader.xl_Reader(path, sheetName);
		return data;
	}
	
	
	
	
	@Test(dataProvider="supplyData")
	public void testSearchItem(String Username,String Pass) {
		login=home.signInPage();
		String text=driver.findElement(By.id("GREET-HELLO")).getText();
		Assert.assertEquals("Hello", text);
		login.signInProcess(Username,Pass);
		
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
	
	

}
