package hrmLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataDrivenTest.BaseTest;

public class HRMLoginTest extends BaseTest {

	//WebDriver driver;
	
	@Test(priority = 1)
	public void login() {
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		
		
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		
		
		driver.findElement(By.name("Submit")).click();
		
	}
	
	//@Test(priority = 3, retryAnalyzer = RetryLogicExample.class)
	@Test(priority = 3)
	public void logout() throws Exception {
		
		driver.findElement(By.partialLinkText("Welcome")).click();
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.partialLinkText("Logo"))));
		
		driver.findElement(By.partialLinkText("Logo")).click();
		
	}
	
	@Test()
	public void verifyAppTitle() {
		
		Assert.assertTrue(driver.getTitle().contains("HRM"));
		
	}
	
}
