package headlessExample;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

//import dataDrivenTest.BaseTest;

public class HRMLoginTest extends BaseTest {

	//WebDriver driver;
	
	@Test(priority = 1)
	public void login() throws InterruptedException {
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		
		
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		
		
		driver.findElement(By.name("Submit")).click();
		
		
		Thread.sleep(2000);
		String dashboardTest = driver.findElement(By.tagName("h1")).getText();
		System.out.println(dashboardTest);
		
		
		Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());
		
		Assert.assertEquals(dashboardTest, "dashboard");
		
	}
	
		
	@Test()
	public void verifyAppTitle() {
		
		Assert.assertTrue(driver.getTitle().contains("HRM"));
		
	}
	
}
