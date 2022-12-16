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
@WebServlet("/updatereg")
public class UpdateRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateRegistrationController() {
        super();    
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/updateregistration.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession session = request.getSession(false);
			if(session.getAttribute("email")!=null) {
				String name = request.getParameter("name");
		
				String email = request.getParameter("email");
				String mobile = request.getParameter("mobile");
				DAOService service=new DAOServiceImpl();
				service.connectDB();
				service.updateReg(name,email,mobile);
				request.setAttribute("update","Record Updated");
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/updateregistration.jsp");
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

}
