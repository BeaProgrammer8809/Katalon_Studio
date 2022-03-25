package practice_Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SpicejetTest {
@Test
	public  void spicejetTest() {
		
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement origin = driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']"));
		origin.click();
		
		driver.findElement(By.xpath("//div[text()='Bengaluru']")).click();
		
		driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']")).click();
		WebElement dest = driver.findElement(By.xpath("//div[text()='Delhi']"));
		Actions act=new Actions(driver);
		act.moveToElement(dest).click().perform();
		
		driver.findElement(By.xpath("(//div[text()='25'])[1]")).click();
		
		
		
	}
}
