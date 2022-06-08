package learnAlerts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnScroll {
	
	WebDriver driver;
	
	@Before
	public void init() { 
		
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver102.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/#student");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	@Test
	public void scrollTest() throws InterruptedException { 
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("scroll Function");
		js.executeScript("scroll(0,8000);"); 
		Thread.sleep(5000);
		System.out.println("scroll Function");
		
	}

}
