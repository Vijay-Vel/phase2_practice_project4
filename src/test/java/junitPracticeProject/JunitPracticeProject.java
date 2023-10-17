package junitPracticeProject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JunitPracticeProject {
		
		WebDriver driver;
		
		@BeforeAll
		public void startbrowser()
		{
	        driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.get("https://www.facebook.com/");
		}
		
		@ParameterizedTest(name = "CSV Source {arguments}")
		@DisplayName("Facebook Login Page")
		@CsvSource({
			"admin, ad123",
			"vijay,  vijay123",
			"facebook, facebook12",
			"tom, tom32"
		})
		public void TestfacebookLogin(String username, String password) throws InterruptedException
		{
			System.out.println(driver.getTitle());
	        WebElement e1=driver.findElement(By.xpath("//input[@id='email']"));
	
	        e1.clear();
	        e1.sendKeys(username);
			
			WebElement e2 = driver.findElement(By.xpath("//input[@id='pass']"));
			e2.clear();
			e2.sendKeys(password);
			
			Thread.sleep(1500);
		}
		
		@Test
		@DisplayName("Google Search Page")
		public void Testgooglepage() throws AWTException, InterruptedException {
			
			driver.navigate().to("https://www.google.com/");
			System.out.println(driver.getTitle());
			driver.findElement(By.xpath("//div[@class='SDkEP']/descendant::textarea")).sendKeys("Simplilearn");
			
			Robot r = new Robot();
			
			r.keyPress(KeyEvent.VK_ENTER);  
			r.keyRelease(KeyEvent.VK_ENTER); 
			
			Thread.sleep(1500);
		}
		
		
		
		@AfterAll
		public void closebrowser()
		{
			driver.close();
		}

}

