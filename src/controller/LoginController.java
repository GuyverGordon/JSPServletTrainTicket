package controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import service.LoginService;
import service.impl.LoginServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public LoginService loginservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		loginservice = new LoginServiceImpl();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("LoginController ran ......................");
		
		PrintWriter pw = response.getWriter();
		
		try {
			response.setContentType("text/html");
			String username = request.getParameter("txtusername");
			String password = request.getParameter("password");
			
			HttpSession session = request.getSession();
			
			if (loginservice.loginValidate(username, password)) {
				session.setAttribute("username", username);
				response.sendRedirect("./TrainList");
			} else {
				session.setAttribute("username", "");
				pw.println("Invalid user");
				pw.println("<a href='login.html'> Back </a>");
			}
			
		} catch (Exception e) {
			RequestDispatcher req = request.getRequestDispatcher("login.html");
			req.forward(request, response);
		}
		
	}
}
