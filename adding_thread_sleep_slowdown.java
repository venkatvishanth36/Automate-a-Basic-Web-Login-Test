package automate_basic_web_login_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class adding_thread_sleep_slowdown {
	public static void main(String[]args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://practicetestautomation.com/practice-test-login/");
		Thread.sleep(2000);
		
		WebElement usernameField = driver.findElement(By.id("username"));
		usernameField.sendKeys("student");
		Thread.sleep(2000);
		
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("Password123");
		Thread.sleep(2000);
		
		WebElement loginButton = driver.findElement(By.id("submit"));
		loginButton.click();
		Thread.sleep(2000);
		
		WebElement successMessage = driver.findElement(By.className("post-title"));
		String messageText = successMessage.getText();
		
		if(messageText.contains("Logged In Successfully")) {
			System.out.println("Login Test Passed");
		} else {
			System.out.println("Login Test Failed");
		}
		
		Thread.sleep(2000);
		driver.quit();
	}

}
