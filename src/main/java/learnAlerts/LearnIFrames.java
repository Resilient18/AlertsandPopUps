package learnAlerts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class LearnIFrames {
	
	WebDriver driver;
	@Before
	public void init() { 
		
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver102.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@SuppressWarnings("deprecation")
	@Test
	public void iFramePractice() { 
		
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.linkText("java.awt")).click();
		driver.switchTo().parentFrame(); 
		// You can try without the parent frame first and then try with parent frame if it doesn't work without it. 
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("Adjustable")).click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame("classFrame");
		Assert.assertEquals("Interface Adjustable", driver.findElement(By.xpath("//h2[contains(text(), 'Interface Adjustable')]")).getText());
		driver.findElement(By.xpath("//a[contains(text(), 'JScrollBar')]")).click();
		System.out.println("Found JscrollBar");
		
	}
	

}
