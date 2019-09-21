package com.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utilities.Helper;


public class Basepage {
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports report;
	public static ExtentReports reportInfo;
	public static ExtentTest loggerr;
	String path="C:\\Users\\fahim\\eclipse-workspace\\WebAutoApp\\src\\main\\resources\\config.properties";
public Basepage() {
	try {
		prop=new Properties();
		FileInputStream ip=new FileInputStream(path);
		prop.load(ip);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@BeforeSuite
public void reporter() {
	
	ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports_ebay"+Helper.getCurrentDate()+".html"));
						report=new ExtentReports();
						report.attachReporter(extent);
						extent.config().setReportName("Round 2 testing");
						report.setSystemInfo("SQA", "FAHIM AHMED");
						report.setSystemInfo("Environment", "QA");
						report.setSystemInfo("APP NAME", "ebay");
	
}



public void initialization() {
	String browserName=prop.getProperty("browser");
	if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fahim\\eclipse-workspace\\WebAutoApp\\driver\\chromedriver.exe");
		//WebDriver driver= new HtmlUnitDriver();
		//ChromeOptions chromeOptions=new ChromeOptions();
		//chromeOptions.addArguments("window-size=1400,800");
		//chromeOptions.addArguments("headless");
		driver=new ChromeDriver();
	}else if(browserName.equals("firefox")){
		System.setProperty("www.gecko.driver", "C:\\Users\\fahim\\eclipse-workspace\\WebAutoApp\\driver\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	
}

}
