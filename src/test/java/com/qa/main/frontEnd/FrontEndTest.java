package com.qa.main.frontEnd;

import java.util.HashMap;
import java.util.Map;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FrontEndTest {
	private static RemoteWebDriver driver;
	private static WebElement targ;
	private static ExtentReports report;
	private static ExtentTest test;
	
	@Test
	public void updateTest() throws Exception{
		test = report.startTest("Test For List update");
		test.log(LogStatus.INFO, "List updated");
		driver.get("http://localhost:9090/update.html");
		
		System.out.println("Updating List");
		targ = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/fieldset/input[1]"));
		targ.sendKeys("1");
		
		targ = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/fieldset/input[2]"));
		targ.sendKeys("TestChanged");
		
		targ = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/fieldset/button"));
		targ.click();
		
		Thread.sleep(5000);
		
		
		
	}
	
	
	@Test
	public void readByIdTest() throws Exception{
		test = report.startTest("Test For List read");
		test.log(LogStatus.INFO, "List read");
		driver.get("http://localhost:9090/read.html");
		
		
		System.out.println("Reading by List Id (1)");
		targ = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/div[1]/div/form/input"));
		targ.sendKeys("1");
		targ = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/div[1]/div/button"));
		targ.click();
		
		
		Thread.sleep(5000);
	}
	
	
	
	@Test
	public void testCreate() throws InterruptedException {
		test = report.startTest("Test For List created");
		test.log(LogStatus.INFO, "List created");
		
		driver.get("http://localhost:9090/create.html");
		
		
		targ = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/fieldset/input"));
		targ.sendKeys("Test");
		targ = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/fieldset/button"));
		targ.click();
		
		System.out.println("List Created");
		
//		targ = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/fieldset/input[1]"));
//		targ.sendKeys("Test");
//		targ = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/fieldset/input[2]"));
//		targ.sendKeys("Test");
//		targ = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/fieldset/input[3]"));
//		targ.sendKeys("1");
//		targ = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/fieldset/button"));
//		targ.click();
//		
//		System.out.println("Item Created");
		
		Thread.sleep(5000);
		
	}
	
	@Test
	public void deleteTest() {
		test = report.startTest("Test For List deleted");
		test.log(LogStatus.INFO, "List deleted");
		driver.get("http://localhost:9090/delete.html");
		System.out.println("Deleting List");
		
		targ = driver.findElement(By.xpath("/html/body/div[1]/input"));
		targ.sendKeys("1");
		targ = driver.findElement(By.xpath("/html/body/div[2]/button"));
		targ.click();
		
		
		
	}
	
	
	@BeforeAll
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\QA-TDL-Project\\QA_TDL_Project\\target\\reports\\extendreports\\endreportswebtestreport.html",
				true);
		
		driver = new ChromeDriver();
	}
	
	@AfterAll
	public static void cleanUp() {
		driver.quit();
		
		System.out.println("Driver is closed");
	}
	
	@AfterEach
	public void afterTest() {
		report.endTest(test);
	}
	
	
	
	public static ChromeOptions chromeCfg() {
	     Map<String, Object> prefs = new HashMap<String, Object>();
	     ChromeOptions cOptions = new ChromeOptions();
	      
	     // Settings
	     prefs.put("profile.default_content_setting_values.cookies", 2);
	     prefs.put("network.cookie.cookieBehavior", 2);
	     prefs.put("profile.block_third_party_cookies", true);

	     // Create ChromeOptions to disable Cookies pop-up
	     cOptions.setExperimentalOption("prefs", prefs);

	     return cOptions;
	  }

}
