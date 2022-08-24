package DAO;

import Model.User;

public interface AuthDAO {
	public abstract boolean SignIn(String username, String psw);

    public abstract int SignUp(User user) throws ClassNotFoundException;
}
