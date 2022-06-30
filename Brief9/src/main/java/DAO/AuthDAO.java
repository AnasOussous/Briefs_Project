package DAO;

import model.User;

public interface AuthDAO {
	public abstract User SignIn(String username, String psw);

    public abstract void SignUp(User user);
}
