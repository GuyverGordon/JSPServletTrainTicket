package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Ticket;

/**
 * Servlet implementation class DownloadController
 */
@WebServlet("/Download")
public class DownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadController() {
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
		
		System.out.println("DownloadController ran ............................");
		
		HttpSession session = request.getSession();
		Ticket ticket = (Ticket) session.getAttribute("ticket");
		String str = ticket.writeTicket();
		
		String[] location = str.split(" ");
		
		
		request.setAttribute("url", location[0].substring(1));
		request.setAttribute("filename", location[1].substring(1));
		request.setAttribute("path", str);
		
		RequestDispatcher req = request.getRequestDispatcher("jsp/finish.jsp");
		req.forward(request, response);
	}

}
