package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.Train;
import service.TrainService;
import service.impl.TrainServiceImpl;

/**
 * Servlet implementation class TrainController
 */
@WebServlet("/TrainList")
public class TrainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public TrainService trainService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		trainService = new TrainServiceImpl();
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TrainController ran ......................");
		
		try {
			List<Train> trains = trainService.getAllTrains();
			Set<String> sources = new TreeSet<String>();
			
			for (Train train : trains) {
				sources.add(train.getSource());
			}
			
			request.setAttribute("sources", sources);
			
			RequestDispatcher req = request.getRequestDispatcher("jsp/trains.jsp");
			req.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
