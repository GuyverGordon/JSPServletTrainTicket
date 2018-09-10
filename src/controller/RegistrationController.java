package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import exception.DuplicateUserNameException;
import model.User;
import service.RegistrationService;
import service.impl.RegistrationServiceImpl;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/Registration")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public RegistrationService registrationService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		registrationService = new RegistrationServiceImpl();
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		try {
			User user = new User(request.getParameter("txtusername"),
					request.getParameter("password"), request.getParameter("txtemail"));
			
			if (registrationService.addUser(user)) {
				pw.println("User successfully added!");
			} else {
				pw.println("User could not be added");
			}
			
			RequestDispatcher req = request.getRequestDispatcher("./login.html");
			req.include(request, response);
		} catch (DuplicateUserNameException e) {
			pw.println(e.getMessage());
			pw.println("<body><a href=\"jsp/registration.jsp\"> New User </a> </body>");
		} catch (Exception e) {
			pw.println(e.getMessage());
			pw.println("<a href=./jsp/registration.jsp> Back </a>");
		}
	}

}
