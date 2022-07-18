package log4JExample;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMLoginTest {
	
	WebDriver driver;
	Logger log;
	@BeforeTest
	public void launchApp() {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		//logging
		
		log = Logger.getLogger("IBM_HRM_Login_Module");
		PropertyConfigurator.configure(".\\configFolder\\log4j.properties");
		
		
		log.info("=================================");
		log.info("chrome browser launched.");
		
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		log.info("HRM app launched. - https://opensource-demo.orangehrmlive.com/" );
	}

	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(4000);
		driver.close();

		log.info("browser closed successfully.");
	
	}
	
	@Test
	public void loginTest() throws Exception {
		
		//log.info("=====TestCase: LoginTest execution in progress");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		log.info("enter userName: Admin");
		
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		log.info("enter password: Admin");
		
		driver.findElement(By.name("Submit")).click();
		log.info("click on login button");
		
		//validation step
		Boolean verifyDashboard = driver.findElement(By.tagName("h1")).isDisplayed();
		if(verifyDashboard) {
			Assert.assertTrue(verifyDashboard);
			log.info("verifcation of Dashboard after sucessful login - passed");
		}
		else {
			
			Assert.assertTrue(verifyDashboard);
			log.info("verifcation of Dashboard after sucessful login - failed");
		}
		
		
		
	}
	
	@BeforeMethod
	public void addComment() {
		log.info("=======Test Case execution in progress..Case=====");
		
	}
	
	@AfterMethod
	public void addComment2() {
		log.info("==========Test Case execution completed===========");
		
	}
	
	@Test
	public void logout() {
		//log.info("=====TestCase: LoginTest execution in progress");
		driver.findElement(By.partialLinkText("Welcome")).click();
		log.info("click on Welcome link");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Logo")));
		
		
		driver.findElement(By.partialLinkText("Logo")).click();
		log.info("click on Logout link");
		
		//validation - getting application URL
		log.info("validation of logout passed, current application URL: " + driver.getCurrentUrl());
	}
	
	
}

