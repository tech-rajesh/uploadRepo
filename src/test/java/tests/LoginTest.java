package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseTest{

	
	@Test
	public void verifyLoginFeature() throws Exception {
		
		//login application
		lp.enterUserName("admin@yourstore.com");
		lp.enterPassword("admin");
		lp.clickRememberMeCheckbox();
		Thread.sleep(3000);
		lp.clickLoginButton();
		
		//validation step
		lp.verifyApplicationTitle("Dashboard / nopCommerce administration");
		
	}
	
}
