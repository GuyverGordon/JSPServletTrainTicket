package controller;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


import model.Train;

/**
 * Servlet implementation class TrainListController
 */
@WebServlet("/TrainTable")
public class TrainListController extends TrainController implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see TrainController#TrainController()
     */
    public TrainListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TrainListController ran ......................");
		try {
			List<Train> trains = trainService.getTrains(request.getParameter("place"));
			
			if (trains == null || trains.isEmpty()) {
				PrintWriter pw = response.getWriter();
				pw.println("There are no available trains");
			} else {
				request.setAttribute("trains", trains);
			}
			
			RequestDispatcher req = request.getRequestDispatcher("jsp/traintable.jsp");
			req.forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
