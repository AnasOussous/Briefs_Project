package Web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AuthDAOImp;
import Model.User;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AuthDAOImp authDAOImp;

	public void init() {
		authDAOImp = new AuthDAOImp();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		signup(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("SignUp.jsp");
	}

	private void signup(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = new User();
		user.setPrenom_User(firstName);
		user.setName_User(lastName);
		user.setUsername(username);
		user.setPsw(password);

		try {
			int result = authDAOImp.SignUp(user);
			if(result == 1) {
				request.setAttribute("NOTIFICATION", "User Registered Successfully!");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("SignUp.jsp");
		dispatcher.forward(request, response);
	}

}
