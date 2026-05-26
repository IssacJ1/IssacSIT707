package ontrack.task9_1P;

import static org.junit.Assert.*;
import org.junit.Test;

public class SubmissionServiceTest {

	@Test
	public void testValidSubmission() {
		assertTrue(
			SubmissionService.submitTask(
				"224200457",
				"Task 9.1P",
				"My submission"));
	}

	@Test
	public void testInvalidStudentIdTooShort() {
		assertFalse(
			SubmissionService.submitTask(
				"12345",
				"Task 9.1P",
				"My submission"));
	}

	@Test
	public void testNullStudentId() {
		assertFalse(
			SubmissionService.submitTask(
				null,
				"Task 9.1P",
				"My submission"));
	}

	@Test
	public void testEmptyTaskName() {
		assertFalse(
			SubmissionService.submitTask(
				"224200457",
				"",
				"My submission"));
	}

	@Test
	public void testEmptySubmissionContent() {
		assertFalse(
			SubmissionService.submitTask(
				"224200457",
				"Task 9.1P",
				""));
	}

	@Test
	public void testNullSubmissionContent() {
		assertFalse(
			SubmissionService.submitTask(
				"224200457",
				"Task 9.1P",
				null));
	}
}