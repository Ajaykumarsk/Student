package studentdb.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import studentdb.model.DAOService;
import studentdb.model.DAOServiceImpl;

import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/readreg")
public class ReadRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ReadRegistration() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession session = request.getSession(false);
			if(session.getAttribute("email")!=null) {
				DAOService service= new DAOServiceImpl();
				service.connectDB();
				ResultSet result = service.getAllReg();
				request.setAttribute("res", result);
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/readregistration.jsp");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		}catch (Exception e) {
			request.setAttribute("Error", "Invaild username/password");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/readregistration.jsp");
		rd.forward(request, response);
	}
}
