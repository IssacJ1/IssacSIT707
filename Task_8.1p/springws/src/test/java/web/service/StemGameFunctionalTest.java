package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StemGameFunctionalTest {

	private static final String CHROME_DRIVER_PATH = "C:/chromedriver/chromedriver.exe";
	private static final String BASE_URL = "http://localhost:8080/login";

	private void sleep(long sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testFullStemGameSequence() {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);

		WebDriver driver = new ChromeDriver();
		driver.navigate().to(BASE_URL);
		sleep(1);

		driver.findElement(By.id("username")).sendKeys("ahsan");
		driver.findElement(By.id("passwd")).sendKeys("ahsan_pass");
		driver.findElement(By.id("dob")).sendKeys("2000-01-01");
		driver.findElement(By.cssSelector("[type=submit]")).submit();
		sleep(1);

		Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));

		driver.findElement(By.id("number1")).sendKeys("1");
		driver.findElement(By.id("number2")).sendKeys("2");
		driver.findElement(By.id("result")).sendKeys("3");
		driver.findElement(By.cssSelector("[type=submit]")).submit();
		sleep(1);

		Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));

		driver.findElement(By.id("number1")).sendKeys("5");
		driver.findElement(By.id("number2")).sendKeys("2");
		driver.findElement(By.id("result")).sendKeys("3");
		driver.findElement(By.cssSelector("[type=submit]")).submit();
		sleep(1);

		Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));

		driver.findElement(By.id("number1")).sendKeys("3");
		driver.findElement(By.id("number2")).sendKeys("4");
		driver.findElement(By.id("result")).sendKeys("12");
		driver.findElement(By.cssSelector("[type=submit]")).submit();
		sleep(1);

		driver.close();
	}
}