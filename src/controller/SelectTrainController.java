package controller;

import java.io.*;
import java.sql.SQLException;
import java.text.NumberFormat;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.Train;

/**
 * Servlet implementation class SelectTrainController
 */
@WebServlet("/SelectTrain")
public class SelectTrainController extends TrainController implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see TrainController#TrainController()
     */
    public SelectTrainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SelectTrainController ran .................................");
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		
		try {
			Train train = trainService.getTrain(Integer.parseInt(request.getParameter("trainid")));
			pw.println(train.getTrainName() + " -- From: " + train.getSource() + " -- To: " + train.getDestination() 
				+ " -- Price: " + nf.format(train.getTicketPrice()) + "\n\n");
			
			HttpSession session = request.getSession();
			session.setAttribute("train", train);
			
			RequestDispatcher req = request.getRequestDispatcher("jsp/details.jsp");
			req.include(request, response);
			
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
