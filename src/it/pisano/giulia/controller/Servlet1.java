package it.pisano.giulia.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/login.html")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
				
		if(request.getSession(false) != null) {
			response.sendRedirect("home.html");
		}
		else {
			
			response.getWriter().println("<html><head></head><body><form action = \"home.html\"method = \"post\">"
			+ "<label for = \"username\" >User</label>" 
			+ "<input type = \"username\" name=\"username\"> "
			+ " <label for = \"password\">Password</label>"
			+ "<input type = \"password\" name=\"password\"> "
			+ "<button type = \"submit\">Login!</button> </form></body></html>");
			
			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
