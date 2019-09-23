package utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.generic.Basepage;


public class Helper extends Basepage{

	
	public static String getCurrentDate() {
		DateFormat data=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return data.format(currentDate);
	} 
	
	public static String getScreenShot(WebDriver driver){
		
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			String path=System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
			try {FileUtils.copyFile(src, new File(path));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		
		return path;
		
	}
	
	public static void HoverOverWebElement(WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
