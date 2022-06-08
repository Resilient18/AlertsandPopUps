package learnAlerts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnKeyBoardEvent {
	
WebDriver driver; 

@Before
public void init() { 
	
	System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver102.exe");
	driver = new ChromeDriver(); 
	driver.manage().deleteAllCookies();
	driver.get("https://www.techfios.com/billing/?ng=login/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
}
@Test
public void keyboardEvents() { 
	
	driver.findElement(By.xpath("//input[@id ='username']")).sendKeys("demo@techfios.com");
	driver.findElement(By.xpath("//input[@id ='password']")).sendKeys("abc123");
	Actions action = new Actions(driver);
	action.sendKeys(Keys.ENTER).build().perform();
	
}
}
