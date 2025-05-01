package automate_basic_web_login_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_test {
	public static void main(String[]args) {
		
		// Initialize WebDriver
		WebDriver driver = new ChromeDriver();
		// Maximize the browser window
		driver.manage().window().maximize();
		// Open a website with a login form
		driver.get("https://practicetestautomation.com/practice-test-login/");
		// Find the username input field and enter text
		WebElement usernameField = driver.findElement(By.id("username"));
		usernameField.sendKeys("student");
		// Find the password input field and enter text
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("Password123");
		// Find and click the login button
		WebElement loginButton = driver.findElement(By.id("submit"));
		loginButton.click();
		// Validate successful login by checking for a success message
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
