package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddCustomerPage {

	WebDriver driver;
	public AddCustomerPage(WebDriver driver) {
		
		
		this.driver= driver;
		
	}
	
	//Identification
	
	By txt_email = By.name("Email");
	By txt_password = By.cssSelector("input#Password");
	By btn_Login = By.tagName("button");
	
	
	//Methods/Actions
	
	
	public void enterUserName(String email) {
		driver.findElement(txt_email).clear();
		driver.findElement(txt_email).sendKeys(email);
	}
	
	
	public void enterPassword(String pwd) {
		driver.findElement(txt_password).clear();
		driver.findElement(txt_password).sendKeys(pwd);
	}
	
	public void clickLoginButton() {
		driver.findElement(btn_Login).click();
		
	}
	
	public void verifyApplicationTitle(String expectedTitle) {
		
		Assert.assertEquals(driver.getTitle(), expectedTitle);
	}
	

}
