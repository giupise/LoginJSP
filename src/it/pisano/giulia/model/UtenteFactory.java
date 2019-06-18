package it.pisano.giulia.model;

import java.util.ArrayList;

public class UtenteFactory {
	
	private static UtenteFactory singleton;
	private ArrayList<Utente> listaUtenti;
	
	//String nome, String cognome, String email, String password, String gener
	
	private UtenteFactory() {
		listaUtenti = new ArrayList<Utente>();
		listaUtenti.add(new Utente("Giulia", "Pisano", "giupise","giulia.pisano@hotmail", "ciaociao", "F"));
		listaUtenti.add(new Utente("Giuli", "Pisi","pisi", "giuli.pisi@hotmail", "ciao", "F"));
		listaUtenti.add(new Utente("Giulio", "Pisano", "giuleo", "giulio.pisano@hotmail", "ciaopa", "F"));
		
	}
	
	public static UtenteFactory getInstance() {
		if (singleton == null) {
			singleton = new UtenteFactory();
			
			
		}
	    
		return singleton;
		
		
	}
	
	public Utente controllaCredenziali(String username, String password) {
		if (username != null && password != null) {
			for (Utente utente : listaUtenti) {
				if(username.equals(utente.getUsername()) && password.equals(utente.getPassword())) {
					return utente;
			
				}
			}
		} 
		return null;
		
	}
	
	public Utente getUtente(String username) {
		for(Utente utente : listaUtenti) {
			if(utente.getUsername().equals(username)) {
				return utente;
			}
		} 
		return null;
	}
	

}
