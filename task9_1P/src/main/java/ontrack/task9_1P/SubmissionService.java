package ontrack.task9_1P;

public class SubmissionService {

	public static boolean submitTask(
			String studentId,
			String taskName,
			String content) {

		if (studentId == null || studentId.length() != 9) {
			return false;
		}

		if (taskName == null || taskName.trim().isEmpty()) {
			return false;
		}

		if (content == null || content.trim().isEmpty()) {
			return false;
		}

		return true;
	}
}