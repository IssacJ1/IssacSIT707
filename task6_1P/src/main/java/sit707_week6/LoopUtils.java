package sit707_week6;

public class LoopUtils {

	public static int sumNumbersUpTo(int limit) {
		int sum = 0;
		for (int i = 1; i <= limit; i++) {
			sum = sum + i;
		}
		return sum;
	}

	public static int countEvenNumbers(int limit) {
		int count = 0;
		for (int i = 1; i <= limit; i++) {
			if (i % 2 == 0) {
				count++;
			}
		}
		return count;
	}
}