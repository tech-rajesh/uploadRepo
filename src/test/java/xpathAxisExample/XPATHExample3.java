package xpathAxisExample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XPATHExample3 {
	
	WebDriver driver;
	
	@BeforeTest
	public void launchApp() {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		
	}

	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(4000);
		driver.close();

	
	}
	
	@Test
	public void XPATHDemoTest() throws Exception {
		
		WebElement chk_Helen  = driver.findElement(By.xpath("//td[text()='Helen Bennett']//preceding-sibling::td//child::input"));
		chk_Helen.click();
		
		WebElement chk_YoshiTannamuri	  = driver.findElement(By.xpath("//td[text()='Yoshi Tannamuri']//preceding-sibling::td//child::input"));
		chk_YoshiTannamuri.click();
		
	}
	
	
	
	
	
}

