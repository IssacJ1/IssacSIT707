package sit707_week2;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inspects the Officeworks registration page and prints details of buttons
	 * and any element containing "Create account" to help find the correct locator.
	 */
	public static void inspectPage() {
		// Update this path to your chromedriver location
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\issac\\\\Desktop\\\\softqnt\\\\New folder_2\\\\chromedriver-win64\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get("https://www.officeworks.com.au/app/identity/create-account");
		
		// Wait for the firstname field to be present (indicates the form is loaded)
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname")));
		
		// ----- Find all buttons -----
		System.out.println("\n===== ALL BUTTONS ON THE PAGE =====\n");
		List<WebElement> buttons = driver.findElements(By.tagName("button"));
		if (buttons.isEmpty()) {
			System.out.println("No <button> elements found.");
		} else {
			for (int i = 0; i < buttons.size(); i++) {
				WebElement btn = buttons.get(i);
				System.out.println("Button #" + (i+1) + ":");
				System.out.println("  Outer HTML: " + btn.getAttribute("outerHTML"));
				System.out.println("  Text: " + btn.getText());
				System.out.println("  Value (if input): " + btn.getAttribute("value"));
				System.out.println("  Type: " + btn.getAttribute("type"));
				System.out.println("  Class: " + btn.getAttribute("class"));
				System.out.println("  ID: " + btn.getAttribute("id"));
				System.out.println("  data-testid: " + btn.getAttribute("data-testid"));
				System.out.println();
			}
		}
		
		// ----- Find any element containing "Create account" text -----
		System.out.println("===== ELEMENTS CONTAINING 'Create account' TEXT =====\n");
		List<WebElement> elementsWithText = driver.findElements(By.xpath("//*[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'create account')]"));
		if (elementsWithText.isEmpty()) {
			System.out.println("No element found with text containing 'create account'.");
		} else {
			for (int i = 0; i < elementsWithText.size(); i++) {
				WebElement elem = elementsWithText.get(i);
				System.out.println("Element #" + (i+1) + ":");
				System.out.println("  Tag: " + elem.getTagName());
				System.out.println("  Outer HTML: " + elem.getAttribute("outerHTML"));
				System.out.println("  Text: " + elem.getText());
				System.out.println();
			}
		}
		
		driver.quit();
	}

	/**
	 * Automates the Officeworks registration page.
	 * Fills all fields, uses a weak password to trigger validation errors,
	 * then takes a screenshot (does NOT submit the form).
	 * 
	 * @param url the URL of the registration page
	 */
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		// !!! CHANGE THIS TO YOUR OWN CHROMEDRIVER PATH !!!
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\issac\\\\Desktop\\\\softqnt\\\\New folder_2\\\\chromedriver-win64\\\\chromedriver.exe");

		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		System.out.println("Driver info: " + driver);

		WebDriverWait wait = new WebDriverWait(driver, 10);

		// Load the webpage
		driver.get(url);

		// Wait for the first input field to be present
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname")));

		// ----- Fill in the registration form -----
		
		// First name
		WebElement firstName = driver.findElement(By.id("firstname"));
		firstName.clear();
		firstName.sendKeys("Ahsan");

		// Last name
		WebElement lastName = driver.findElement(By.id("lastname"));
		lastName.clear();
		lastName.sendKeys("Habib");

		// Email
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("ahsan.habib@example.com");

		// Password – use a weak password so the form fails validation
		WebElement password = driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys("123");  // too short, will trigger error

		// Confirm password
		WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));
		confirmPassword.clear();
		confirmPassword.sendKeys("123");

		// Allow time for validation messages to appear
		sleep(2);

		// ----- Take screenshot of the page (showing validation errors) -----
		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("officeworks_registration.png"));
			System.out.println("Screenshot saved: officeworks_registration.png");
		} catch (IOException e) {
			System.err.println("Failed to capture screenshot: " + e.getMessage());
		}

		// Sleep a while before closing
		sleep(2);

		// close chrome driver
		driver.close();
	}

	/**
	 * Automates the alternative registration page (webpage1.html).
	 * Fills the form, submits, and takes a screenshot.
	 * 
	 * @param url the URL of the alternative registration page
	 */
	public static void alternative_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		// !!! CHANGE THIS TO YOUR OWN CHROMEDRIVER PATH !!!
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\issac\\\\Desktop\\\\softqnt\\\\New folder_2\\\\chromedriver-win64\\\\chromedriver.exe");

		// Step 2: Open browser and navigate to the page
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.get(url);
		sleep(2);

		// Wait for the first name field
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fname")));

		// ----- Fill the form -----

		// First name
		WebElement firstName = driver.findElement(By.id("fname"));
		firstName.clear();
		firstName.sendKeys("John");

		// Last name
		WebElement lastName = driver.findElement(By.id("lname"));
		lastName.clear();
		lastName.sendKeys("Doe");

		// Gender radio buttons – select Male (value 'm')
		WebElement maleRadio = driver.findElement(By.xpath("//input[@value='m']"));
		if (!maleRadio.isSelected()) {
			maleRadio.click();
		}

		// Newsletter checkbox – check it
		WebElement newsletter = driver.findElement(By.name("newsletter"));
		if (!newsletter.isSelected()) {
			newsletter.click();
		}

		// ----- Submit the form -----
		WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
		submitButton.click();

		// Allow time for submission (optional)
		sleep(2);

		// ----- Take screenshot after submission -----
		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("alternative_registration.png"));
			System.out.println("Screenshot saved: alternative_registration.png");
		} catch (IOException e) {
			System.err.println("Failed to capture screenshot: " + e.getMessage());
		}

		// Sleep a while before closing
		sleep(2);

		// close browser
		driver.close();
	}
}