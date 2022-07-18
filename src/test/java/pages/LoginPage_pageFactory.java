package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage_pageFactory {

	WebDriver driver;
	public LoginPage_pageFactory(WebDriver driver) {
		
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Identification
	
//	By txt_email = By.name("Email");
//	By txt_password = By.cssSelector("input#Password");
//	By btn_Login = By.xpath("//button[text()='Log in']");
//	By btn_clear = By.xpath("//button[text()='Log in']");
	
	
	@FindBy(name = "Email")
	WebElement txt_email;
	
	@FindBy(css  = "input#Password")
	WebElement txt_password;
	
	
	@FindBy(how = How.CSS, using ="input#Password")
	WebElement txt_password1;
	
	
	@FindBy(xpath =  "//button[text()='Log in']")
	WebElement btn_Login;
	
	
	
	
	@FindBy(name =  "RememberMe")
	WebElement chk_RememberMe;
	
	//Methods/Actions
	
	
	public void enterUserName(String email) {
		txt_email.clear();
		txt_email.sendKeys(email);
	}
	
	
	public void enterPassword(String pwd) throws Exception {
		Thread.sleep(2000);
		txt_password1.clear();
		Thread.sleep(2000);
		txt_password.sendKeys(pwd);
	}
	
	public void clickLoginButton() {
		btn_Login.click();
		
	}
	
	public void clickRememberMeCheckbox() {
		chk_RememberMe.click();
		
	}
	
	public void verifyApplicationTitle(String expectedTitle) {
		
		Assert.assertEquals(driver.getTitle(), expectedTitle);
	}
	

}
