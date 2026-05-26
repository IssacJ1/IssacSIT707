package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {
	
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
	public void testEvenNumberIsEven() {
		Assert.assertTrue(WeatherAndMathUtils.isEven(4));
	}
	
	@Test
	public void testOddNumberIsNotEven() {
		Assert.assertFalse(WeatherAndMathUtils.isEven(5));
	}
	
	@Test
	public void testPrimeSpecialCaseOne() {
		Assert.assertTrue(WeatherAndMathUtils.isPrime(1));
	}
	
	@Test
	public void testPrimeOddNumber() {
		Assert.assertTrue(WeatherAndMathUtils.isPrime(7));
	}
	
	@Test
	public void testPrimeEvenNumberReturnsFalse() {
		Assert.assertFalse(WeatherAndMathUtils.isPrime(4));
	}
	
	@Test
	public void testCancelWeatherAdviceByDangerousWind() {
		Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
	}
	
	@Test
	public void testCancelWeatherAdviceByDangerousRain() {
		Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(10.0, 6.1));
	}
	
	@Test
	public void testCancelWeatherAdviceByWindAndRainCombination() {
		Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(45.1, 4.1));
	}
	
	@Test
	public void testWarnWeatherAdviceByConcerningWind() {
		Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(45.1, 0.0));
	}
	
	@Test
	public void testWarnWeatherAdviceByConcerningRain() {
		Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(10.0, 4.1));
	}
	
	@Test
	public void testAllClearWeatherAdvice() {
		Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(20.0, 2.0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidNegativeWeatherInput() {
		WeatherAndMathUtils.weatherAdvice(-1.0, 2.0);
	}
}