package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Ticket;

/**
 * Servlet implementation class OrderController
 */
@WebServlet("/Order")
public class OrderController extends TicketController implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see TicketController#TicketController()
     */
    public OrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("OrderController ran .............................");
		
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		
		Ticket ticket = (Ticket) session.getAttribute("ticket");
		
		PrintWriter pw = response.getWriter();
		
		pw.println("<h2> Your ticket </h2>");
		System.out.println(ticket.showTicket());
		pw.println("<p><pre>" + ticket.showTicket() + "</pre><p>");
		
		RequestDispatcher req = request.getRequestDispatcher("jsp/ticket.jsp");
		req.include(request, response);
		
	}

}
