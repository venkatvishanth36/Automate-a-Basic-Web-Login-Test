package automate_basic_web_login_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;

public class Screenshot_after_action {
	public static void main(String[]args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
		WebElement usernameField = driver.findElement(By.id("username"));
		usernameField.sendKeys("student");
		
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("Password123");
		
		WebElement loginButton = driver.findElement(By.id("submit"));
		loginButton.click();
		
		// 📸 Take screenshot after login click
		takeScreenshot(driver, "after_login");
		
		WebElement successMessage = driver.findElement(By.className("post-title"));
		String messageText = successMessage.getText();
		
		if(messageText.contains("Logged In Successfully")) {
			System.out.println("Login Test Passed!!");
		} else {
			System.out.println("Login Test Failed");
		}
		driver.quit();
		
	}
	// 📸 Screenshot method
	public static void takeScreenshot(WebDriver driver, String fileName) {
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(screenshot, new File("C:\\Users\\venka\\eclipse-workspace\\Project\\src\\automate_basic_web_login_test\\" + fileName + ".png"));
			System.out.println("📸 Screenshot saved as: " + fileName + ".png");
		} catch (IOException e) {
			System.out.println("❌ Failed to save screenshot: " + e.getMessage());
		}
		
	}

}
