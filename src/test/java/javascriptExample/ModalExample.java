package javascriptExample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ModalExample {
	
	WebDriver driver;
	
	@BeforeTest
	public void launchApp() {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("http://www.uitestpractice.com/Students/Switchto");
		
	}

	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(4000);
		driver.close();

	
	}
	
	@Test
	public void Test1() throws Exception {
		
		WebElement btnModal = driver.findElement(By.xpath("//button[contains(text(),'modal')]"));
		
		
		//javascript - 
		
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		JS.executeScript("arguments[0].click();", btnModal);
		
		
		
		
		
		
		//btnModal.click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
		
		
	}
	
	
	
}

