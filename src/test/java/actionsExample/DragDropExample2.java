package actionsExample;

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

public class DragDropExample2 {
	
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
		
		WebElement dragdropFrame = driver.findElement(By.xpath("//iframe[contains(@data-src,'photo-manager')]"));
		
		driver.switchTo().frame(dragdropFrame);
		
		Actions act = new Actions(driver);
		
//		WebElement img3 = driver.findElement(By.xpath("//img[contains(@src,'tatras3')]"));
//		WebElement img4 = driver.findElement(By.xpath("//img[contains(@src,'tatras4')]"));
//		WebElement trash = driver.findElement(By.cssSelector("div#trash"));
//		
//		
		//Method1
//		act.dragAndDrop(img3, trash).perform();
//		Thread.sleep(1000);
//		act.dragAndDrop(img4, trash).perform();
//		
//		A convenience method that performs click-and-hold at the location of the source element, 
//		moves to the location of the target element, then releases the mouse.
		
		
//		//Method2
//		act.clickAndHold(img3).moveToElement(trash).release().build().perform();
//		Thread.sleep(2000);
//		act.clickAndHold(img4).moveToElement(trash).release().perform();
//		
		
		
	}
	
	
	
}

