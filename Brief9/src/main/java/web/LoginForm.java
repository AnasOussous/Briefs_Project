package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import DAO.AuthDAOImp;
import Model.User;

public class LoginForm extends HttpServlet {
	public AuthDAOImp authDAOImp = new AuthDAOImp();
	private static final long serialVersionUID = 1L;
       
    public LoginForm() {
        super();
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Username = request.getParameter("user");
		String Password = request.getParameter("password");
		String submitBtn = request.getParameter("submit");
		
		try {
        User us = authDAOImp.SignIn(Username,Password);
        System.out.println(us.getName_User() + us.getUsername() + us.getPsw());
        if(submitBtn.equals("login") && us!=null && us.getName_User()!=null) {
        	request.setAttribute("message", us.getName_User());
        	request.getRequestDispatcher("Task.jsp").forward(request, response);
        	
        }else if(submitBtn.equals("SignUp")) {
			us.setName_User(request.getParameter("fname"));
			us.setPrenom_User(request.getParameter("lname"));
			us.setPsw(Password);
			us.setUsername(Username);
			authDAOImp.SignUp(us);
			request.setAttribute("SMessage", "Register Done !! Please Click Login to Continue");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "Not Found User !! Click SignUp");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}}catch (Exception e) {
			System.out.println("svsvs");
		}
	}

}
