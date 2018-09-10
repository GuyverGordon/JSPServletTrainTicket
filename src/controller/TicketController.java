package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.*;

/**
 * Servlet implementation class TicketController
 */
@WebServlet("/Ticket")
public class TicketController extends TrainController {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketController() {
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
		System.out.println("TicketController ran ................................");
		HttpSession session = request.getSession();
		
		try {
			Train train = (Train) session.getAttribute("train");
			Ticket ticket = new Ticket((Date)session.getAttribute("date"), train);
			
			List<Passenger> passengers = (List<Passenger>) request.getAttribute("passengers");
			ticket.setPassengers(passengers);
			
			List<Double> fares = new ArrayList<Double>();
			for (Passenger pass : passengers) {
				fares.add(ticket.showFare(pass));
			}
			
			session.setAttribute("fares", fares);
			session.setAttribute("ticket", ticket);
			
			RequestDispatcher req = request.getRequestDispatcher("jsp/total.jsp");
			req.forward(request, response);
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
