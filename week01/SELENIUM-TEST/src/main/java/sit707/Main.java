package sit707;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {
        // Fix: Removed the extra '4' from the folder name to match your screenshot
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\issac\\Desktop\\softqnt\\New folder_2\\chromedriver-win64\\chromedriver.exe");

        // Initialize the driver
        WebDriver driver = new ChromeDriver();
        
        // Print driver object to console to confirm initialization
        System.out.println("Driver initialized: " + driver);

        // Navigate to Google
        driver.get("https://www.google.com");

        // Wait for 5 seconds to see the result
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser window
        driver.quit(); // Use .quit() instead of .close() to shut down the driver fully
    }
}