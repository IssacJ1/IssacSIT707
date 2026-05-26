package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "224200457";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "ISSAC JOLY";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test
	public void testFailEmptyUsernameAndWrongPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login("", "wrongpass");
		Assert.assertTrue( status.isLoginSuccess() == false );
	}
	
	@Test
	public void testFailEmptyUsernameAndCorrectPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login("", "ahsan_pass");
		Assert.assertTrue( status.isLoginSuccess() == false );
	}
	
	@Test
	public void testFailWrongUsernameAndEmptyPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login("wronguser", "");
		Assert.assertTrue( status.isLoginSuccess() == false );
	}
	
	@Test
	public void testFailWrongUsernameAndWrongPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login("wronguser", "wrongpass");
		Assert.assertTrue( status.isLoginSuccess() == false );
	}
	
	@Test
	public void testFailWrongUsernameAndCorrectPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login("wronguser", "ahsan_pass");
		Assert.assertTrue( status.isLoginSuccess() == false );
	}
	
	@Test
	public void testFailCorrectUsernameAndEmptyPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login("ahsan", "");
		Assert.assertTrue( status.isLoginSuccess() == false );
	}
	
	@Test
	public void testFailCorrectUsernameAndWrongPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login("ahsan", "wrongpass");
		Assert.assertTrue( status.isLoginSuccess() == false );
	}
	
	@Test
	public void testSuccessCorrectUsernameAndPasswordWithEmptyValidationCode() {
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		Assert.assertTrue( status.isLoginSuccess() == true );
		boolean validateResult = LoginForm.validateCode("");
		Assert.assertTrue( validateResult == false );
	}
	
	@Test
	public void testSuccessCorrectUsernameAndPasswordWithWrongValidationCode() {
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		Assert.assertTrue( status.isLoginSuccess() == true );
		boolean validateResult = LoginForm.validateCode("wrongcode");
		Assert.assertTrue( validateResult == false );
	}
	
	@Test
	public void testSuccessCorrectUsernameAndPasswordWithCorrectValidationCode() {
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		Assert.assertTrue( status.isLoginSuccess() == true );
		boolean validateResult = LoginForm.validateCode("123456");
		Assert.assertTrue( validateResult == true );
	}
}
