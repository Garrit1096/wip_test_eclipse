package services;

public class LoginService {
	
	public boolean authenticate(String userId, String password) {
		if(password == null || password.equals("") || userId == null || userId.equals(""))
		{
			return false;
		}
		return true;
	}

}
