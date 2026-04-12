package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Issac Joly
 * @studentId 224200457
 */
public class DateUtilTest {

	@Test
	public void testStudentIdentity() {
		String studentId = "224200457";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Issac Joly";
		Assert.assertNotNull("Student name is null", studentName);
	}

	/*
	 * =====================
	 * JANUARY 2024 TESTS
	 * =====================
	 */

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}

	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}

	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}

	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		// January min boundary: min+1
		DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("january1ShouldIncrementToJanuary2 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}

	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		// January min boundary: min-1 (should go to previous year December)
		DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("january1ShouldDecrementToDecember31 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
	}

	@Test
	public void testMinPlus1January2ShouldIncrementToJanuary3() {
		DateUtil date = new DateUtil(2, 1, 2024);
        System.out.println("january2ShouldIncrementToJanuary3 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(3, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}

	@Test
	public void testMinPlus1January2ShouldDecrementToJanuary1() {
		DateUtil date = new DateUtil(2, 1, 2024);
        System.out.println("january2ShouldDecrementToJanuary1 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}

	@Test
	public void testMaxMinus1January30ShouldIncrementToJanuary31() {
		DateUtil date = new DateUtil(30, 1, 2024);
        System.out.println("january30ShouldIncrementToJanuary31 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}

	@Test
	public void testMaxMinus1January30ShouldDecrementToJanuary29() {
		DateUtil date = new DateUtil(30, 1, 2024);
        System.out.println("january30ShouldDecrementToJanuary29 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}

	/*
	 * =====================
	 * FEBRUARY 2024 TESTS (Leap Year - 29 days)
	 * =====================
	 */

	@Test
	public void testMaxFebruary29ShouldIncrementToMarch1() {
		// February max boundary (leap year): max+1
		DateUtil date = new DateUtil(29, 2, 2024);
        System.out.println("february29ShouldIncrementToMarch1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
	}

	@Test
	public void testMaxFebruary29ShouldDecrementToFebruary28() {
		// February max boundary (leap year): max-1
		DateUtil date = new DateUtil(29, 2, 2024);
        System.out.println("february29ShouldDecrementToFebruary28 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(28, date.getDay());
        Assert.assertEquals(2, date.getMonth());
	}

	@Test
	public void testNominalFebruary() {
		DateUtil date = new DateUtil(15, 2, 2024);
        System.out.println("testFebruaryNominal > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(2, date.getMonth());
	}

	@Test
	public void testMinFebruary1ShouldIncrementToFebruary2() {
		DateUtil date = new DateUtil(1, 2, 2024);
        System.out.println("february1ShouldIncrementToFebruary2 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(2, date.getMonth());
	}

	@Test
	public void testMinFebruary1ShouldDecrementToJanuary31() {
		DateUtil date = new DateUtil(1, 2, 2024);
        System.out.println("february1ShouldDecrementToJanuary31 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}

	@Test
	public void testMinPlus1February2ShouldIncrementToFebruary3() {
		DateUtil date = new DateUtil(2, 2, 2024);
        System.out.println("february2ShouldIncrementToFebruary3 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(3, date.getDay());
        Assert.assertEquals(2, date.getMonth());
	}

	@Test
	public void testMinPlus1February2ShouldDecrementToFebruary1() {
		DateUtil date = new DateUtil(2, 2, 2024);
        System.out.println("february2ShouldDecrementToFebruary1 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(2, date.getMonth());
	}

	@Test
	public void testMaxMinus1February28ShouldIncrementToFebruary29() {
		// Leap year: Feb 28 -> Feb 29
		DateUtil date = new DateUtil(28, 2, 2024);
        System.out.println("february28ShouldIncrementToFebruary29 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
	}

	@Test
	public void testMaxMinus1February28ShouldDecrementToFebruary27() {
		DateUtil date = new DateUtil(28, 2, 2024);
        System.out.println("february28ShouldDecrementToFebruary27 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(27, date.getDay());
        Assert.assertEquals(2, date.getMonth());
	}

	/*
	 * FEBRUARY LEAP YEAR SPECIAL TESTS
	 */

	@Test
	public void testLeapYearFebruary29Exists() {
		// Verify Feb 29 is valid in leap year 2024
		DateUtil date = new DateUtil(29, 2, 2024);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}

	@Test
	public void testLeapYearFebruary29IncrementToMarch1() {
		DateUtil date = new DateUtil(29, 2, 2024);
        System.out.println("leapYearFeb29IncrementToMarch1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
	}

	/*
	 * =====================
	 * MARCH 2024 TESTS (31 days)
	 * =====================
	 */

	@Test
	public void testMaxMarch31ShouldIncrementToApril1() {
		DateUtil date = new DateUtil(31, 3, 2024);
        System.out.println("march31ShouldIncrementToApril1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(4, date.getMonth());
	}

	@Test
	public void testMaxMarch31ShouldDecrementToMarch30() {
		DateUtil date = new DateUtil(31, 3, 2024);
        System.out.println("march31ShouldDecrementToMarch30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(3, date.getMonth());
	}

	@Test
	public void testNominalMarch() {
		DateUtil date = new DateUtil(15, 3, 2024);
        System.out.println("testMarchNominal > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(3, date.getMonth());
	}

	@Test
	public void testMinMarch1ShouldIncrementToMarch2() {
		DateUtil date = new DateUtil(1, 3, 2024);
        System.out.println("march1ShouldIncrementToMarch2 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(3, date.getMonth());
	}

	@Test
	public void testMinMarch1ShouldDecrementToFebruary29() {
		// 2024 is leap year, so Feb has 29 days
		DateUtil date = new DateUtil(1, 3, 2024);
        System.out.println("march1ShouldDecrementToFebruary29 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
	}

	@Test
	public void testMinPlus1March2ShouldIncrementToMarch3() {
		DateUtil date = new DateUtil(2, 3, 2024);
        date.increment();
        Assert.assertEquals(3, date.getDay());
        Assert.assertEquals(3, date.getMonth());
	}

	@Test
	public void testMinPlus1March2ShouldDecrementToMarch1() {
		DateUtil date = new DateUtil(2, 3, 2024);
        date.decrement();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
	}

	@Test
	public void testMaxMinus1March30ShouldIncrementToMarch31() {
		DateUtil date = new DateUtil(30, 3, 2024);
        date.increment();
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(3, date.getMonth());
	}

	@Test
	public void testMaxMinus1March30ShouldDecrementToMarch29() {
		DateUtil date = new DateUtil(30, 3, 2024);
        date.decrement();
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(3, date.getMonth());
	}

	/*
	 * =====================
	 * APRIL 2024 TESTS (30 days)
	 * =====================
	 */

	@Test
	public void testMaxApril30ShouldIncrementToMay1() {
		DateUtil date = new DateUtil(30, 4, 2024);
        System.out.println("april30ShouldIncrementToMay1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(5, date.getMonth());
	}

	@Test
	public void testMaxApril30ShouldDecrementToApril29() {
		DateUtil date = new DateUtil(30, 4, 2024);
        System.out.println("april30ShouldDecrementToApril29 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(4, date.getMonth());
	}

	@Test
	public void testNominalApril() {
		DateUtil date = new DateUtil(15, 4, 2024);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(4, date.getMonth());
	}

	@Test
	public void testMinApril1ShouldIncrementToApril2() {
		DateUtil date = new DateUtil(1, 4, 2024);
        date.increment();
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(4, date.getMonth());
	}

	@Test
	public void testMinApril1ShouldDecrementToMarch31() {
		DateUtil date = new DateUtil(1, 4, 2024);
        date.decrement();
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(3, date.getMonth());
	}

	@Test
	public void testMinPlus1April2ShouldIncrementToApril3() {
		DateUtil date = new DateUtil(2, 4, 2024);
        date.increment();
        Assert.assertEquals(3, date.getDay());
        Assert.assertEquals(4, date.getMonth());
	}

	@Test
	public void testMinPlus1April2ShouldDecrementToApril1() {
		DateUtil date = new DateUtil(2, 4, 2024);
        date.decrement();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(4, date.getMonth());
	}

	@Test
	public void testMaxMinus1April29ShouldIncrementToApril30() {
		DateUtil date = new DateUtil(29, 4, 2024);
        date.increment();
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(4, date.getMonth());
	}

	@Test
	public void testMaxMinus1April29ShouldDecrementToApril28() {
		DateUtil date = new DateUtil(29, 4, 2024);
        date.decrement();
        Assert.assertEquals(28, date.getDay());
        Assert.assertEquals(4, date.getMonth());
	}

	/*
	 * =====================
	 * MAY 2024 TESTS (31 days)
	 * =====================
	 */

	@Test
	public void testMaxMay31ShouldIncrementToJune1() {
		DateUtil date = new DateUtil(31, 5, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(6, date.getMonth());
	}

	@Test
	public void testMaxMay31ShouldDecrementToMay30() {
		DateUtil date = new DateUtil(31, 5, 2024);
        date.decrement();
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(5, date.getMonth());
	}

	@Test
	public void testNominalMay() {
		DateUtil date = new DateUtil(15, 5, 2024);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(5, date.getMonth());
	}

	@Test
	public void testMinMay1ShouldIncrementToMay2() {
		DateUtil date = new DateUtil(1, 5, 2024);
        date.increment();
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(5, date.getMonth());
	}

	@Test
	public void testMinMay1ShouldDecrementToApril30() {
		DateUtil date = new DateUtil(1, 5, 2024);
        date.decrement();
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(4, date.getMonth());
	}

	@Test
	public void testMinPlus1May2ShouldIncrementToMay3() {
		DateUtil date = new DateUtil(2, 5, 2024);
        date.increment();
        Assert.assertEquals(3, date.getDay());
        Assert.assertEquals(5, date.getMonth());
	}

	@Test
	public void testMinPlus1May2ShouldDecrementToMay1() {
		DateUtil date = new DateUtil(2, 5, 2024);
        date.decrement();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(5, date.getMonth());
	}

	@Test
	public void testMaxMinus1May30ShouldIncrementToMay31() {
		DateUtil date = new DateUtil(30, 5, 2024);
        date.increment();
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(5, date.getMonth());
	}

	@Test
	public void testMaxMinus1May30ShouldDecrementToMay29() {
		DateUtil date = new DateUtil(30, 5, 2024);
        date.decrement();
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(5, date.getMonth());
	}

	/*
	 * =====================
	 * JUNE 2024 TESTS (30 days)
	 * =====================
	 */

	@Test
	public void testMaxJune30ShouldIncrementToJuly1() {
		DateUtil date = new DateUtil(30, 6, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(7, date.getMonth());
	}

	@Test
	public void testMaxJune30ShouldDecrementToJune29() {
		DateUtil date = new DateUtil(30, 6, 2024);
        date.decrement();
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(6, date.getMonth());
	}

	@Test
	public void testNominalJune() {
		DateUtil date = new DateUtil(15, 6, 2024);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
	}

	@Test
	public void testMinJune1ShouldIncrementToJune2() {
		DateUtil date = new DateUtil(1, 6, 2024);
        date.increment();
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(6, date.getMonth());
	}

	@Test
	public void testMinJune1ShouldDecrementToMay31() {
		DateUtil date = new DateUtil(1, 6, 2024);
        date.decrement();
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(5, date.getMonth());
	}

	@Test
	public void testMinPlus1June2ShouldIncrementToJune3() {
		DateUtil date = new DateUtil(2, 6, 2024);
        date.increment();
        Assert.assertEquals(3, date.getDay());
        Assert.assertEquals(6, date.getMonth());
	}

	@Test
	public void testMinPlus1June2ShouldDecrementToJune1() {
		DateUtil date = new DateUtil(2, 6, 2024);
        date.decrement();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(6, date.getMonth());
	}

	@Test
	public void testMaxMinus1June29ShouldIncrementToJune30() {
		DateUtil date = new DateUtil(29, 6, 2024);
        date.increment();
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(6, date.getMonth());
	}

	@Test
	public void testMaxMinus1June29ShouldDecrementToJune28() {
		DateUtil date = new DateUtil(29, 6, 2024);
        date.decrement();
        Assert.assertEquals(28, date.getDay());
        Assert.assertEquals(6, date.getMonth());
	}

	/*
	 * =====================
	 * JULY 2024 TESTS (31 days)
	 * =====================
	 */

	@Test
	public void testMaxJuly31ShouldIncrementToAugust1() {
		DateUtil date = new DateUtil(31, 7, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(8, date.getMonth());
	}

	@Test
	public void testMaxJuly31ShouldDecrementToJuly30() {
		DateUtil date = new DateUtil(31, 7, 2024);
        date.decrement();
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(7, date.getMonth());
	}

	@Test
	public void testNominalJuly() {
		DateUtil date = new DateUtil(15, 7, 2024);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(7, date.getMonth());
	}

	@Test
	public void testMinJuly1ShouldIncrementToJuly2() {
		DateUtil date = new DateUtil(1, 7, 2024);
        date.increment();
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(7, date.getMonth());
	}

	@Test
	public void testMinJuly1ShouldDecrementToJune30() {
		DateUtil date = new DateUtil(1, 7, 2024);
        date.decrement();
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(6, date.getMonth());
	}

	@Test
	public void testMinPlus1July2ShouldIncrementToJuly3() {
		DateUtil date = new DateUtil(2, 7, 2024);
        date.increment();
        Assert.assertEquals(3, date.getDay());
        Assert.assertEquals(7, date.getMonth());
	}

	@Test
	public void testMinPlus1July2ShouldDecrementToJuly1() {
		DateUtil date = new DateUtil(2, 7, 2024);
        date.decrement();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(7, date.getMonth());
	}

	@Test
	public void testMaxMinus1July30ShouldIncrementToJuly31() {
		DateUtil date = new DateUtil(30, 7, 2024);
        date.increment();
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(7, date.getMonth());
	}

	@Test
	public void testMaxMinus1July30ShouldDecrementToJuly29() {
		DateUtil date = new DateUtil(30, 7, 2024);
        date.decrement();
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(7, date.getMonth());
	}

	/*
	 * =====================
	 * AUGUST 2024 TESTS (31 days)
	 * =====================
	 */

	@Test
	public void testMaxAugust31ShouldIncrementToSeptember1() {
		DateUtil date = new DateUtil(31, 8, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(9, date.getMonth());
	}

	@Test
	public void testMaxAugust31ShouldDecrementToAugust30() {
		DateUtil date = new DateUtil(31, 8, 2024);
        date.decrement();
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(8, date.getMonth());
	}

	@Test
	public void testNominalAugust() {
		DateUtil date = new DateUtil(15, 8, 2024);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(8, date.getMonth());
	}

	@Test
	public void testMinAugust1ShouldIncrementToAugust2() {
		DateUtil date = new DateUtil(1, 8, 2024);
        date.increment();
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(8, date.getMonth());
	}

	@Test
	public void testMinAugust1ShouldDecrementToJuly31() {
		DateUtil date = new DateUtil(1, 8, 2024);
        date.decrement();
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(7, date.getMonth());
	}

	@Test
	public void testMinPlus1August2ShouldIncrementToAugust3() {
		DateUtil date = new DateUtil(2, 8, 2024);
        date.increment();
        Assert.assertEquals(3, date.getDay());
        Assert.assertEquals(8, date.getMonth());
	}

	@Test
	public void testMinPlus1August2ShouldDecrementToAugust1() {
		DateUtil date = new DateUtil(2, 8, 2024);
        date.decrement();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(8, date.getMonth());
	}

	@Test
	public void testMaxMinus1August30ShouldIncrementToAugust31() {
		DateUtil date = new DateUtil(30, 8, 2024);
        date.increment();
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(8, date.getMonth());
	}

	@Test
	public void testMaxMinus1August30ShouldDecrementToAugust29() {
		DateUtil date = new DateUtil(30, 8, 2024);
        date.decrement();
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(8, date.getMonth());
	}

	/*
	 * =====================
	 * SEPTEMBER 2024 TESTS (30 days)
	 * =====================
	 */

	@Test
	public void testMaxSeptember30ShouldIncrementToOctober1() {
		DateUtil date = new DateUtil(30, 9, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(10, date.getMonth());
	}

	@Test
	public void testMaxSeptember30ShouldDecrementToSeptember29() {
		DateUtil date = new DateUtil(30, 9, 2024);
        date.decrement();
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(9, date.getMonth());
	}

	@Test
	public void testNominalSeptember() {
		DateUtil date = new DateUtil(15, 9, 2024);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(9, date.getMonth());
	}

	@Test
	public void testMinSeptember1ShouldIncrementToSeptember2() {
		DateUtil date = new DateUtil(1, 9, 2024);
        date.increment();
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(9, date.getMonth());
	}

	@Test
	public void testMinSeptember1ShouldDecrementToAugust31() {
		DateUtil date = new DateUtil(1, 9, 2024);
        date.decrement();
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(8, date.getMonth());
	}

	@Test
	public void testMinPlus1September2ShouldIncrementToSeptember3() {
		DateUtil date = new DateUtil(2, 9, 2024);
        date.increment();
        Assert.assertEquals(3, date.getDay());
        Assert.assertEquals(9, date.getMonth());
	}

	@Test
	public void testMinPlus1September2ShouldDecrementToSeptember1() {
		DateUtil date = new DateUtil(2, 9, 2024);
        date.decrement();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(9, date.getMonth());
	}

	@Test
	public void testMaxMinus1September29ShouldIncrementToSeptember30() {
		DateUtil date = new DateUtil(29, 9, 2024);
        date.increment();
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(9, date.getMonth());
	}

	@Test
	public void testMaxMinus1September29ShouldDecrementToSeptember28() {
		DateUtil date = new DateUtil(29, 9, 2024);
        date.decrement();
        Assert.assertEquals(28, date.getDay());
        Assert.assertEquals(9, date.getMonth());
	}

	/*
	 * =====================
	 * OCTOBER 2024 TESTS (31 days)
	 * =====================
	 */

	@Test
	public void testMaxOctober31ShouldIncrementToNovember1() {
		DateUtil date = new DateUtil(31, 10, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(11, date.getMonth());
	}

	@Test
	public void testMaxOctober31ShouldDecrementToOctober30() {
		DateUtil date = new DateUtil(31, 10, 2024);
        date.decrement();
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(10, date.getMonth());
	}

	@Test
	public void testNominalOctober() {
		DateUtil date = new DateUtil(15, 10, 2024);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(10, date.getMonth());
	}

	@Test
	public void testMinOctober1ShouldIncrementToOctober2() {
		DateUtil date = new DateUtil(1, 10, 2024);
        date.increment();
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(10, date.getMonth());
	}

	@Test
	public void testMinOctober1ShouldDecrementToSeptember30() {
		DateUtil date = new DateUtil(1, 10, 2024);
        date.decrement();
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(9, date.getMonth());
	}

	@Test
	public void testMinPlus1October2ShouldIncrementToOctober3() {
		DateUtil date = new DateUtil(2, 10, 2024);
        date.increment();
        Assert.assertEquals(3, date.getDay());
        Assert.assertEquals(10, date.getMonth());
	}

	@Test
	public void testMinPlus1October2ShouldDecrementToOctober1() {
		DateUtil date = new DateUtil(2, 10, 2024);
        date.decrement();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(10, date.getMonth());
	}

	@Test
	public void testMaxMinus1October30ShouldIncrementToOctober31() {
		DateUtil date = new DateUtil(30, 10, 2024);
        date.increment();
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(10, date.getMonth());
	}

	@Test
	public void testMaxMinus1October30ShouldDecrementToOctober29() {
		DateUtil date = new DateUtil(30, 10, 2024);
        date.decrement();
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(10, date.getMonth());
	}

	/*
	 * =====================
	 * NOVEMBER 2024 TESTS (30 days)
	 * =====================
	 */

	@Test
	public void testMaxNovember30ShouldIncrementToDecember1() {
		DateUtil date = new DateUtil(30, 11, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(12, date.getMonth());
	}

	@Test
	public void testMaxNovember30ShouldDecrementToNovember29() {
		DateUtil date = new DateUtil(30, 11, 2024);
        date.decrement();
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(11, date.getMonth());
	}

	@Test
	public void testNominalNovember() {
		DateUtil date = new DateUtil(15, 11, 2024);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(11, date.getMonth());
	}

	@Test
	public void testMinNovember1ShouldIncrementToNovember2() {
		DateUtil date = new DateUtil(1, 11, 2024);
        date.increment();
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(11, date.getMonth());
	}

	@Test
	public void testMinNovember1ShouldDecrementToOctober31() {
		DateUtil date = new DateUtil(1, 11, 2024);
        date.decrement();
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(10, date.getMonth());
	}

	@Test
	public void testMinPlus1November2ShouldIncrementToNovember3() {
		DateUtil date = new DateUtil(2, 11, 2024);
        date.increment();
        Assert.assertEquals(3, date.getDay());
        Assert.assertEquals(11, date.getMonth());
	}

	@Test
	public void testMinPlus1November2ShouldDecrementToNovember1() {
		DateUtil date = new DateUtil(2, 11, 2024);
        date.decrement();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(11, date.getMonth());
	}

	@Test
	public void testMaxMinus1November29ShouldIncrementToNovember30() {
		DateUtil date = new DateUtil(29, 11, 2024);
        date.increment();
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(11, date.getMonth());
	}

	@Test
	public void testMaxMinus1November29ShouldDecrementToNovember28() {
		DateUtil date = new DateUtil(29, 11, 2024);
        date.decrement();
        Assert.assertEquals(28, date.getDay());
        Assert.assertEquals(11, date.getMonth());
	}

	/*
	 * =====================
	 * DECEMBER 2024 TESTS (31 days)
	 * =====================
	 */

	@Test
	public void testMaxDecember31ShouldIncrementToJanuary1NextYear() {
		// December max: should roll over to January 1, 2025
		DateUtil date = new DateUtil(31, 12, 2024);
        System.out.println("december31ShouldIncrementToJanuary1NextYear > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2025, date.getYear());
	}

	@Test
	public void testMaxDecember31ShouldDecrementToDecember30() {
		DateUtil date = new DateUtil(31, 12, 2024);
        System.out.println("december31ShouldDecrementToDecember30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(12, date.getMonth());
	}

	@Test
	public void testNominalDecember() {
		DateUtil date = new DateUtil(15, 12, 2024);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(12, date.getMonth());
	}

	@Test
	public void testMinDecember1ShouldIncrementToDecember2() {
		DateUtil date = new DateUtil(1, 12, 2024);
        date.increment();
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(12, date.getMonth());
	}

	@Test
	public void testMinDecember1ShouldDecrementToNovember30() {
		DateUtil date = new DateUtil(1, 12, 2024);
        date.decrement();
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(11, date.getMonth());
	}

	@Test
	public void testMinPlus1December2ShouldIncrementToDecember3() {
		DateUtil date = new DateUtil(2, 12, 2024);
        date.increment();
        Assert.assertEquals(3, date.getDay());
        Assert.assertEquals(12, date.getMonth());
	}

	@Test
	public void testMinPlus1December2ShouldDecrementToDecember1() {
		DateUtil date = new DateUtil(2, 12, 2024);
        date.decrement();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(12, date.getMonth());
	}

	@Test
	public void testMaxMinus1December30ShouldIncrementToDecember31() {
		DateUtil date = new DateUtil(30, 12, 2024);
        date.increment();
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
	}

	@Test
	public void testMaxMinus1December30ShouldDecrementToDecember29() {
		DateUtil date = new DateUtil(30, 12, 2024);
        date.decrement();
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(12, date.getMonth());
	}
}
