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

public class XPATHExample4 {
	
	WebDriver driver;
	
	@BeforeTest
	public void launchApp() {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
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
		
		WebElement lnk_Automotive_SeeMore  = driver.findElement(By.xpath("//h2[contains(text(),'Automotive essentials')]//parent::div//following-sibling::div[contains(@class,'foo')]//child::a[text()='See more']"));
		lnk_Automotive_SeeMore.click();
		
		Thread.sleep(6000);
		//validation Step
		//System.out.println("Title: " + driver.getTitle());
		//sAssert.assertTrue(driver.getTitle().contains("Motorbike"));
		
		//Thread.sleep(6000);
		//driver.navigate().back(); 		//navigate back in hostory ---- amazon home page
		driver.navigate().back();
		
		
		Thread.sleep(4000);
		WebElement lnk_premiumquality_SeeMore  = driver.findElement(By.xpath("//h2[contains(text(),'premium quality')]//parent::div//following-sibling::div[contains(@class,'foo')]//child::a[text()='See more']"));
		lnk_premiumquality_SeeMore.click();
		
		Thread.sleep(6000);
		//validation Step
		System.out.println("Title: " + driver.getTitle());
		Assert.assertTrue(driver.getPageSource().contains("Stay safe & protected"));
		
	}
	
	
	
	
	
}

