package sit707_week2;

/**
 * Main class for task 2.1P.
 * @author Ahsan Habib
 */
public class Main 
{
    public static void main( String[] args )
    {
        // Optional: Run the inspector to find the correct button locator
        SeleniumOperations.inspectPage();

        // Run Officeworks registration (with intentional password error)
        SeleniumOperations.officeworks_registration_page("https://www.officeworks.com.au/app/identity/create-account");
        
        // Run alternative registration page (local HTML file)
        // Use the absolute path to webpage1.html (adjust as needed)
        // Example for Windows: "file:///C:/Users/YourName/eclipse-workspace/task2_1P/webpage1.html"
        SeleniumOperations.alternative_registration_page("C:\\Users\\issac\\Desktop\\softqnt\\IssacSIT707\\task2_1P\\src\\main\\java\\sit707_week2\\webpage1.html");
    }
}