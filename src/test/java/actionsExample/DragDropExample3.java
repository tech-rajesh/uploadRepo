package actionsExample;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragDropExample3 {
	
	WebDriver driver;
	
	@BeforeTest
	public void launchApp() {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		
	}

	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(4000);
		driver.close();

	
	}
	
	@Test
	public void DragDropTest() throws Exception {
		
		
		//take a screenshot
		
//		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		
//		File target = new File("./screenshot/Application_dateNow.png");
//		
//		FileUtils.copyFile(screenshotFile, target);
	
		
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File screenshotCaptured = ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(screenshotCaptured, new File("./screenshot/Result.png"));
		
		
		
	}
	
	
	
}

