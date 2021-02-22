package com.qa.main.frontEnd;

import java.util.HashMap;
import java.util.Map;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FrontEndTest {
	private static RemoteWebDriver driver;
	private static WebElement targ;
	
	@Test
	public void updateTest() throws Exception{
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
		
		driver = new ChromeDriver();
	}
	
	@AfterAll
	public static void cleanUp() {
		driver.quit();
		
		System.out.println("Driver is closed");
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
