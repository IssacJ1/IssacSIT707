package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class LoopUtilsTest {

	@Test
	public void testSumNumbersUpToFive() {
		Assert.assertEquals(15, LoopUtils.sumNumbersUpTo(5));
	}

	@Test
	public void testSumNumbersWithZeroLimit() {
		Assert.assertEquals(0, LoopUtils.sumNumbersUpTo(0));
	}

	@Test
	public void testCountEvenNumbersUpToSix() {
		Assert.assertEquals(3, LoopUtils.countEvenNumbers(6));
	}

	@Test
	public void testCountEvenNumbersWithOneLimit() {
		Assert.assertEquals(0, LoopUtils.countEvenNumbers(1));
	}
}