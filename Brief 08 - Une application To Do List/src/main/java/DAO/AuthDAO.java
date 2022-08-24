package DAO;

import Model.User;

public interface AuthDAO {

    public abstract void SignIn(String username, String psw);

    public abstract void SignUp(User user);
}
