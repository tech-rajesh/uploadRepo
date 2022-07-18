package actionsExample;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PayTMFrameExample {
	
	WebDriver driver;
	
	@BeforeTest
	public void launchApp() {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://paytm.com/");
		
	}

	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(4000);
		driver.close();

	
	}
	
	@Test
	public void payTMTest() throws Exception {
		
		driver.findElement(By.xpath("//span[text()='Sign In']")).click();
		
		Thread.sleep(4000);
		
		
		//WebElement myFrame = driver.findElement(By.tagName("iframe"));
		WebElement myFrame = driver.findElement(By.xpath("//iframe[contains(@src,'login')]"));
		
		
		//handle frame
		//driver.switchTo().frame(0);
		driver.switchTo().frame(myFrame);
		
		//Thread.sleep(4000);
		
		driver.findElement(By.xpath("//span[contains(text(),'Watch')]")).click();
		
		String heading = driver.findElement(By.cssSelector(".heading")).getText();
		System.out.println(heading);
		Assert.assertTrue(heading.contains("Paytm Web account"));
		
	}
	
	
	@AfterMethod
	public void getScreeshot() throws Exception {
		System.out.println("Caturing screenshot............");
		Thread.sleep(4000);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File target = new File("./screenshot/Application_dateNow.png");
		
		FileUtils.copyFile(screenshotFile, target);
	}
	
	
}

