package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.Passenger;

/**
 * Servlet implementation class PassengerController
 */
@WebServlet("/Passenger")
public class PassengerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassengerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PassengerController ran .................................");
		
		HttpSession session = request.getSession();
		
		int count = (int)session.getAttribute("passengercount");
		List<Passenger> passengers = new ArrayList<Passenger>();
		
		for(int i = 1; i <= count; i++) {
			String name = request.getParameter("namepassenger" + i);
			int age = Integer.parseInt(request.getParameter("agepassenger" + i));
			char gender = request.getParameter("genderpassenger" + i).charAt(0);
			
			passengers.add(new Passenger(name, age, gender));
		}
		
		request.setAttribute("passengers", passengers);
		
		RequestDispatcher req = request.getRequestDispatcher("./Ticket");
		req.forward(request, response);
		
	}

}
