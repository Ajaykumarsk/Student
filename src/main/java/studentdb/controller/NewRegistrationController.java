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
@WebServlet("/newreg")
public class NewRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public NewRegistrationController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/newregistration.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession session = request.getSession(false);
			if(session.getAttribute("email")!=null) {
				String name = request.getParameter("name");
				String fathername = request.getParameter("fname");
				String mothername = request.getParameter("mname");
				String gender = request.getParameter("gender");
				String email = request.getParameter("email");
				String mobile = request.getParameter("mobile");
				String course = request.getParameter("course");
				
				DAOService service=new DAOServiceImpl();
				service.connectDB();
				service.saveRegistration(name,fathername,mothername,gender,email,mobile,course);
				
				request.setAttribute("msg", "Record Saved");
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/newregistration.jsp");
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

