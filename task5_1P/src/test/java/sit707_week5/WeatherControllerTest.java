package sit707_week5;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherControllerTest {

    private static WeatherController wController;
    private static double[] temperatures;

    @BeforeClass
    public static void setUp() {

        // Arrange
        wController = WeatherController.getInstance();

        int nHours = wController.getTotalHours();
        temperatures = new double[nHours];

        for (int i = 0; i < nHours; i++) {
            temperatures[i] = wController.getTemperatureForHour(i + 1);
        }
    }

    @AfterClass
    public static void tearDown() {

        // After
        wController.close();
    }

    @Test
    public void testStudentIdentity() {

        String studentId = "224200457";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {

        String studentName = "Issac";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testTemperatureMin() {

        System.out.println("+++ testTemperatureMin +++");

        // Arrange
        double minTemperature = 1000;

        // Act
        for (double temperatureVal : temperatures) {
            if (minTemperature > temperatureVal) {
                minTemperature = temperatureVal;
            }
        }

        // Assert
        Assert.assertEquals(minTemperature,
                wController.getTemperatureMinFromCache(), 0.001);
    }

    @Test
    public void testTemperatureMax() {

        System.out.println("+++ testTemperatureMax +++");

        // Arrange
        double maxTemperature = -1;

        // Act
        for (double temperatureVal : temperatures) {
            if (maxTemperature < temperatureVal) {
                maxTemperature = temperatureVal;
            }
        }

        // Assert
        Assert.assertEquals(maxTemperature,
                wController.getTemperatureMaxFromCache(), 0.001);
    }

    @Test
    public void testTemperatureAverage() {

        System.out.println("+++ testTemperatureAverage +++");

        // Arrange
        double sumTemp = 0;

        // Act
        for (double temperatureVal : temperatures) {
            sumTemp += temperatureVal;
        }

        double averageTemp = sumTemp / temperatures.length;

        // Assert
        Assert.assertEquals(averageTemp,
                wController.getTemperatureAverageFromCache(), 0.001);
    }

    @Test
    public void testTemperaturePersist() {

        /*
         * Remove below comments ONLY for 5.3C task.
         */
    }
}