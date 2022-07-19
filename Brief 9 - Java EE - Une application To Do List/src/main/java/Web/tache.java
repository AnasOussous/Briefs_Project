package Web;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TacheDAO;
import DAO.TacheDAOImp;
import Model.Tache;

/**
 * Servlet implementation class tache
 */
@WebServlet("/tache")
public class tache extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TacheDAO tacheDAO;

	public void init() {
		tacheDAO = new TacheDAOImp();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertTodo(request, response);
				break;
			case "/delete":
				deleteTodo(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateTodo(request, response);
				break;
			case "/list":
				TacheList(request, response);
				break;
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
				dispatcher.forward(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void TacheList(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Tache> listTodo = tacheDAO.selectAllTodos();
		request.setAttribute("listTodo", listTodo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("TacheList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("AddTache.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Tache existingTodo = tacheDAO.selectTodo(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AddTache.jsp");
		request.setAttribute("tache", existingTodo);
		dispatcher.forward(request, response);

	}

	private void insertTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		
		/*DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		LocalDate targetDate = LocalDate.parse(request.getParameter("targetDate"),df);*/
		
		String statue = request.getParameter("statue");
		Tache newTodo = new Tache(title, description, LocalDate.now(), statue);
		tacheDAO.insertTodo(newTodo);
		response.sendRedirect("list");
	}

	private void updateTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id_tache = Integer.parseInt(request.getParameter("id_tache"));
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		//DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		LocalDate deadline = LocalDate.parse(request.getParameter("deadline"));
		
		String statue = request.getParameter("statue");
		Tache updateTodo = new Tache(id_tache, title, description, deadline, statue);
		
		tacheDAO.updateTodo(updateTodo);
		
		response.sendRedirect("list");
	}

	private void deleteTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		tacheDAO.deleteTodo(id);
		response.sendRedirect("list");
	}

}
