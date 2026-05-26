package web.service;

public class LoginService {

	public static boolean login(String username, String password, String dob) {

		if (username == null || password == null || dob == null) {
			return false;
		}

		if (username.isEmpty() || password.isEmpty() || dob.isEmpty()) {
			return false;
		}

		return "ahsan".equals(username)
				&& "ahsan_pass".equals(password)
				&& "2000-01-01".equals(dob);
	}
}