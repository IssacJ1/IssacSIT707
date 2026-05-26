package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

	@Test
	public void testQ1AdditionValidNumbers() {
		Assert.assertEquals(3.0, MathQuestionService.q1Addition("1", "2"), 0.001);
	}

	@Test
	public void testQ1AdditionEmptyNumber() {
		Assert.assertEquals(2.0, MathQuestionService.q1Addition("", "2"), 0.001);
	}

	@Test
	public void testQ2SubtractionValidNumbers() {
		Assert.assertEquals(3.0, MathQuestionService.q2Subtraction("5", "2"), 0.001);
	}

	@Test
	public void testQ2SubtractionEmptyNumber() {
		Assert.assertEquals(-2.0, MathQuestionService.q2Subtraction("", "2"), 0.001);
	}

	@Test
	public void testQ3MultiplicationValidNumbers() {
		Assert.assertEquals(12.0, MathQuestionService.q3Multiplication("3", "4"), 0.001);
	}

	@Test
	public void testQ3MultiplicationEmptyNumber() {
		Assert.assertEquals(0.0, MathQuestionService.q3Multiplication("", "4"), 0.001);
	}
}