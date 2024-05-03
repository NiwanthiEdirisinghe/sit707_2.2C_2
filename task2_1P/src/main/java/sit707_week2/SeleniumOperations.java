package sit707_week2;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation
 * https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Niwanthi Edirisinghe\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();

		System.out.println("Driver info: " + driver);

		sleep(2);

		// Load a webpage in chromium browser.
		driver.get(url);

	        // Find the element with id "firstname"
	        WebElement element = driver.findElement(By.id("firstname"));
	        System.out.println("Found element: " + element);
	
	        // Send first name
	        element.sendKeys("Ahsan");
	
	        // Use relative locator to find the last name input field
	        WebElement lastNameElement = driver.findElement(RelativeLocator
	                .with(By.tagName("input"))
	                .below(element));
	        lastNameElement.sendKeys("Perera");
	
	        // Use relative locator to find the phone number input field
	        WebElement phoneNumberElement = driver.findElement(RelativeLocator
	                .with(By.tagName("input"))
	                .below(lastNameElement));
	        phoneNumberElement.sendKeys("04578945698");
	
	        // Use relative locator to find the email input field
	        WebElement emailElement = driver.findElement(RelativeLocator
	                .with(By.tagName("input"))
	                .below(phoneNumberElement));
	        emailElement.sendKeys("ahsan@google.com");
	
	        // Use relative locator to find the password input field
	        WebElement passwordElement = driver.findElement(RelativeLocator
	                .with(By.tagName("input"))
	                .below(emailElement));
	        passwordElement.sendKeys("Abc@125k");
	
	        // Use relative locator to find the confirm password input field
	        WebElement confirmPasswordElement = driver.findElement(RelativeLocator
	                .with(By.tagName("input"))
	                .below(passwordElement));
	        confirmPasswordElement.sendKeys("Abc@125k");
	
	        // Find the personal button relative to the confirmPasswordElement
	        WebElement personalButton = driver.findElement(RelativeLocator
	                .with(By.tagName("button"))
	                .below(confirmPasswordElement));
	        personalButton.click();
	
	        // Find the create account button relative to the confirm password element
	        WebElement createAccountButton = driver.findElement(RelativeLocator
	                .with(By.tagName("button"))
	                .below(personalButton));
	        createAccountButton.click();

		/*
		 * Take screenshot using selenium API.
		 */
		takeScreenshot(driver, "registration_page");

		// Sleep a while
		sleep(5);

		// close chrome driver
		driver.close();
	}

	
	public static void takeScreenshot(WebDriver driver, String screenshotName) {
		try {
			// Convert WebDriver instance to TakesScreenshot
			TakesScreenshot ts = (TakesScreenshot) driver;

			// Capture screenshot as File object
			File source = ts.getScreenshotAs(OutputType.FILE);

			// Define the destination path
			String destinationPath = "C:\\Users\\Niwanthi Edirisinghe\\Desktop\\Deakin Assigments\\T1 2024\\SIT707\\"
					+ screenshotName + ".png";

			// Copy file to the destination
			FileUtils.copyFile(source, new File(destinationPath));

			System.out.println("Screenshot taken and saved at: " + destinationPath);
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot: " + e.getMessage());
		}
	}

}
