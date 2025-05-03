package automate_basic_web_login_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class headless_mode {
	public static void main(String[]args) throws InterruptedException{
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--disable-gpu");
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://practicetestautomation.com/practice-test-login/");
		Thread.sleep(2000);
		
		driver.findElement(By.id("username")).sendKeys("student");
		Thread.sleep(1000);
		
		driver.findElement(By.id("password")).sendKeys("Password123");
		Thread.sleep(1000);
		
		driver.findElement(By.id("submit")).click();
		Thread.sleep(1000);
		
		WebElement successMessage = driver.findElement(By.className("post-title"));
		String messageText = successMessage.getText();
		
		if(messageText.contains("Logged In Successfully")) {
			System.out.println("Login Test Passed");
		}else {
			System.out.println("Login Test Failed");
		}
		driver.quit();
	}

}
