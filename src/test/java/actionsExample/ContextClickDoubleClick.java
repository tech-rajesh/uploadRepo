package actionsExample;

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

public class ContextClickDoubleClick {
	
	WebDriver driver;
	
	@BeforeTest
	public void launchApp() {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		
	}

	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(4000);
		driver.close();

	
	}
	
	@Test
	public void RightClickTest() throws Exception {
		
		WebElement rightClickButton = driver.findElement(By.xpath("//span[contains(text(),'right')]"));
		
		//rightClickButton.click();
		
		Actions act = new Actions(driver);
		act.contextClick(rightClickButton).perform();
		
		WebElement deletButton = driver.findElement(By.xpath("//span[contains(text(),'Delete')]"));
		deletButton.click();
		
		Thread.sleep(4000);
		Alert deleteAlert = driver.switchTo().alert();
		
		System.out.println(deleteAlert.getText());
		deleteAlert.accept();
		
	}
	
	
	@Test
	public void DoubleClickTest() throws Exception {
		
		WebElement doubleClickButton = driver.findElement(By.xpath("//button[contains(text(),'Double')]"));
		
		//rightClickButton.click();
		
		Actions act = new Actions(driver);
		act.doubleClick(doubleClickButton).perform();
		
				
		Thread.sleep(4000);
		Alert doubleAlert = driver.switchTo().alert();
		
		System.out.println(doubleAlert.getText());
		doubleAlert.accept();
		
	}
	
	
}

