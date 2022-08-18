package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import dao.EtudiantImp;
import entities.Etudiant;


public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EtudiantImp etd = new EtudiantImp();
       
    
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		this.getServletContext().getRequestDispatcher("/WEB-INF/jsps/login.jsp").forward(request, response);
		
		String action = request.getServletPath();
		System.out.println(action);
		
		try {
			switch (action) {
			case "/list":
				listTask(request, response);
				break;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	private void listTask(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {

//		List<Etudiant> etudiant = etd.SelectAll(etudiant);
//		request.setAttribute("listEmployees", listEmployees);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/space.jsp");
	//	dispatcher.forward(request, response);
	}
}
