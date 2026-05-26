package web.service;

import org.junit.Assert;
import org.junit.Test;

public class LoginUnitTest {

	@Test
	public void testValidLogin() {
		Assert.assertTrue(
				LoginService.login(
						"ahsan",
						"ahsan_pass",
						"2000-01-01"));
	}

	@Test
	public void testWrongUsername() {
		Assert.assertFalse(
				LoginService.login(
						"wrong",
						"ahsan_pass",
						"2000-01-01"));
	}

	@Test
	public void testWrongPassword() {
		Assert.assertFalse(
				LoginService.login(
						"ahsan",
						"wrong_pass",
						"2000-01-01"));
	}

	@Test
	public void testWrongDob() {
		Assert.assertFalse(
				LoginService.login(
						"ahsan",
						"ahsan_pass",
						"1999-01-01"));
	}

	@Test
	public void testNullUsername() {
		Assert.assertFalse(
				LoginService.login(
						null,
						"ahsan_pass",
						"2000-01-01"));
	}

	@Test
	public void testEmptyPassword() {
		Assert.assertFalse(
				LoginService.login(
						"ahsan",
						"",
						"2000-01-01"));
	}
}