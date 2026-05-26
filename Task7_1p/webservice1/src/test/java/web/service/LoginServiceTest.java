package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceTest {

	private static final String CHROME_DRIVER_PATH = "C:/chromedriver/chromedriver.exe";
	private static final String LOGIN_PAGE_PATH = "file:///C:/Users/hassa/OneDrive/Desktop/java_%20Projects/Task7_1p/pages/login.html";

	private void sleep(long sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private WebDriver openLoginPage() {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();
		driver.navigate().to(LOGIN_PAGE_PATH);
		sleep(2);
		return driver;
	}

	private void fillLoginForm(WebDriver driver, String username, String password, String dob) {
		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys(username);

		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys(password);

		WebElement dobElement = driver.findElement(By.id("dob"));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].value='" + dob + "';", dobElement);

		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();

		sleep(2);
	}

	@Test
	public void testLoginSuccess() {
		WebDriver driver = openLoginPage();

		fillLoginForm(driver, "ahsan", "ahsan_pass", "2000-01-01");

		String title = driver.getTitle();
		System.out.println("Title: " + title);

		Assert.assertEquals("success", title);

		driver.close();
	}

	@Test
	public void testLoginFailWrongPassword() {
		WebDriver driver = openLoginPage();

		fillLoginForm(driver, "ahsan", "wrong", "2000-01-01");

		String title = driver.getTitle();
		System.out.println("Title: " + title);

		Assert.assertEquals("fail", title);

		driver.close();
	}
}