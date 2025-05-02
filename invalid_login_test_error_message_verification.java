package automate_basic_web_login_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class invalid_login_test_error_message_verification {
	public static void main(String[]args) throws InterruptedException {
		// Start the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
        // Go to the login page
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
        // Enter invalid username and password
		driver.findElement(By.id("username")).sendKeys("Wronguser");
		driver.findElement(By.id("password")).sendKeys("Wrongpass");
		
		// Click the login button
		driver.findElement(By.id("submit")).click();
		
        // Wait a second (optional for slow-loading error message)
		try {Thread.sleep(1000); } catch (InterruptedException e) {}
		
        // Find and read the error message
		WebElement errorMsg = driver.findElement(By.id("error"));
		String errorText = errorMsg.getText();
		
        // Validate the error message
		if(errorText.contains("Your username is invalid!")||errorText.contains
				("Your password is invalid!")) {
			System.out.println("❌ Invalid Login Test Passed: Error displayed correctly.");
		} else {
			System.out.println("❗ Test Failed: Error message not as expected.");
		}
		//Close the Browser
		driver.quit();
	}

}
