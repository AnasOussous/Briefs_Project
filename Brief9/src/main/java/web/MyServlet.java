package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (name="ms", urlPatterns= {"/controlleur"})
public class MyServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String U = request.getParameter("user");
		String p = request.getParameter("password");
		request.setAttribute("user", U);
		request.setAttribute("password", p);
		
		request.getRequestDispatcher("vue.jsp").forward(request, response);
	}
	
}
