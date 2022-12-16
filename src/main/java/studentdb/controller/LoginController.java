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

@WebServlet("/logfrom")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
     }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
    	RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("psw");
		
		DAOService service=new DAOServiceImpl();
		service.connectDB();
		boolean status = service.verfiyCredentials(email,password);
		
		if(status == true) {
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/newregistration.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("Error", "Invaild username/password"+email);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
