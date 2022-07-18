package dataDrivenTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HRMLoginTest extends BaseTest {
	
	
	@Test(dataProvider = "sampleData")
	public void verifyLoginDetailsWithIvnValid(String user, String pwd) throws Exception {
		
		
		System.out.println("User details: " + user);
		System.out.println("User details: " + pwd);
		System.out.println("==============================");
		Thread.sleep(1000);
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys(user);
		Thread.sleep(1000);
		
		driver.findElement(By.name("txtPassword"));
		driver.findElement(By.name("txtPassword")).sendKeys(pwd);
		
		
		driver.findElement(By.name("Submit")).click();
		
		
		//validation step
		Boolean verifyErrorMessage = driver.findElement(By.cssSelector("span#spanMessage")).isDisplayed();
		Assert.assertTrue(verifyErrorMessage, "validation of error message get failed.");
		Thread.sleep(2000);
		
	}
	
	
	@DataProvider(name="sampleData")
	public Object [][] testData() {
		
		Object [][] data = { {"user1","password1"},{"user2","password2"},{"user3","2423423"}}; //DB
		return data;
	}
	
	
	@DataProvider(name="regressionData")
	public Object [][] testData2() {
		
		Object [][] data = { {"regressionuser1","password1"},{"regressionuser2","password2"},{"regressionuser3","2423423"},{"regressionuser4",2423423}}; //DB
		return data;
	}
	
	

}
