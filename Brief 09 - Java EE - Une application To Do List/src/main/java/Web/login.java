package Web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AuthDAO;
import DAO.AuthDAOImp;
import Model.User;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	User user = new User();
	public AuthDAOImp authDAOImp = new AuthDAOImp();
	private static final long serialVersionUID = 1L;
 
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;Charset=UTF-8");
		try(PrintWriter out = response.getWriter()) {
			String uss = user.setUsername(request.getParameter("username"));
			String ps = user.setPsw(request.getParameter("password"));
			
			//Boolean login = authDAOImp.SignIn(uss,ps);
			if (uss != null && ps != null) {
				if (authDAOImp.SignIn(uss,ps)) {
					request.setAttribute("message", request.getParameter("username"));
					request.getRequestDispatcher("TacheList.jsp").forward(request, response);
				} else {
					request.setAttribute("message", "Not Found User !! Click SignUp");
					request.getRequestDispatcher("Login.jsp").forward(request, response);
				}
			} else {
				out.print("Empty Username Or Password");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
