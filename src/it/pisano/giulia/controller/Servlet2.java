package it.pisano.giulia.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.pisano.giulia.model.Utente;
import it.pisano.giulia.model.UtenteFactory;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/home.html")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*Nel caso sia presente una sessione con un utente loggato, rende dell’html con i
		dati dell’utente. Altrimenti, se riceve i dati dell’utente in post verifica se può
		loggare l’utente (controlla se l’utente è presente in una lista e se user e password
		corrispondono), Se l’utente può loggarsi rende dell’html con i dati dell’utente e
		aggiunge l’utente alla sessione. Se l’utente non può loggarsi, reindirizza alla pagina
		«accesso_negato.html».*/
		
		//se l'utente non è loggato
		
		HttpSession session = request.getSession(false);
		UtenteFactory factory = UtenteFactory.getInstance();
		
		if(session == null) {
	    
			String username = request.getParameter("username");
			String password = request.getParameter("password"); // getParameters("id")
			
						
			if(factory.controllaCredenziali(username, password)) {
				session = request.getSession();
				session.setAttribute("username", username);
				session.setAttribute("password", password );
				
				} else {
			       response.sendRedirect("accesso_negato.html");
		       
				}

		     } 
		
		   
		
		     Utente utenteLoggato = factory.getUtente((String)session.getAttribute("username"));
		
		
		
		
	}
}
