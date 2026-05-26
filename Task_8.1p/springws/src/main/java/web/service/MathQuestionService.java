package web.service;

public class MathQuestionService {

	public static double q1Addition(String number1, String number2) {
		return parseAnswer(number1) + parseAnswer(number2);
	}

	public static double q2Subtraction(String number1, String number2) {
		return parseAnswer(number1) - parseAnswer(number2);
	}

	public static double q3Multiplication(String number1, String number2) {
		return parseAnswer(number1) * parseAnswer(number2);
	}

	public static double parseAnswer(String value) {
		if (value == null || value.trim().isEmpty()) {
			return 0;
		}
		return Double.valueOf(value);
	}
}