package learnAlerts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearnAlertsPopUps {

	WebDriver driver; 
	
	@Before
	public void init() { 
		
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver102.exe");
		driver = new ChromeDriver(); 
		driver.manage().deleteAllCookies();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
	}
	@Test
	public void alertPopUpCheck() throws InterruptedException { 
		
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/input[2]")).click();
		//Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
		
		
		System.out.println("===== " + driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
	}
	
	
}
