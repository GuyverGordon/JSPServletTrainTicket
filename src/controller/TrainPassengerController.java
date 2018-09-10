package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class TrainPassengerController
 */
@WebServlet("/TrainPassenger")
public class TrainPassengerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainPassengerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TrainPassengerController ran ..............................");
		
		int count = Integer.parseInt(request.getParameter("num_passengers"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println(request.getParameter("day").toString());
		
		Date date = null;
		try {
			date = sdf.parse(request.getParameter("day").toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("passengercount", count);
		session.setAttribute("date", date);
		
		request.setAttribute("count", count);
		
		RequestDispatcher req = request.getRequestDispatcher("jsp/passengerdetails.jsp");
		req.forward(request, response);
	}

}
