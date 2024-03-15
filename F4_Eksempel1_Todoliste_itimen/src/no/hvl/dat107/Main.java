package no.hvl.dat107;

import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	
    public static void main(String[] args) {
        
        TodolisteDAO todolisteDAO = new TodolisteDAO();

        Todo rydde = new Todo("Rydde");
        Todo vaskeOpp = new Todo("Vaske opp");
        Todo stovsuge = new Todo("Støvsuge");

        /* ----------------------------------------------------------------- */
        
        System.out.println("\n\nLager en liste [Husarbeid], legger til 3 todos og lagrer ...");
        
        Todoliste husarbeid = new Todoliste("Husarbeid");
        husarbeid.leggTil(rydde);
        husarbeid.leggTil(vaskeOpp);
        husarbeid.leggTil(stovsuge);
        
        todolisteDAO.lagreNyListe(husarbeid);
        
        System.out.println("Etter lagreNyListe():");
        System.out.println(todolisteDAO.hentListe(husarbeid.getId()));
        
        pauseOgSjekkDatabasen("\nSjekk at vi har fått oppdatert databasen riktig.");
        
        /* ----------------------------------------------------------------- */
        
        System.out.println("\n\nEndrer navn,\n  fjerner [Vaske Opp],\n  legger til "
        		+ "[Vaske vinduer],\n  endrer støvsuging-tekst til 'Gøy støvsuging'"
        		+ " og oppdaterer ...");

        Todo vaskeVinduer = new Todo("Vaske vinduer");

        husarbeid.setNavn("Gøy husarbeid");
        husarbeid.fjern(vaskeOpp);         
        husarbeid.leggTil(vaskeVinduer);   
        stovsuge.setTekst("Gøy støvsuging");
       
        todolisteDAO.oppdaterListe(husarbeid);
        
        System.out.println("Etter oppdaterListe():");
        System.out.println(todolisteDAO.hentListe(husarbeid.getId()));
        
		pauseOgSjekkDatabasen("\nSjekk at vi har fått oppdatert databasen riktig.");
        
        /* ----------------------------------------------------------------- */
        
        System.out.println("\n\nSøker opp listen på navn ...");
        
        System.out.println("Etter hentListeMedNavn(\"Gøy husarbeid\")");
        System.out.println(todolisteDAO.hentListeMedNavn("Gøy husarbeid"));
        
        /* ----------------------------------------------------------------- */
        
        System.out.println("\n\nHvis kun enveis forhold, finne todos med JPQL ...");
        
        System.out.println("Etter hentTodosIListe(husarbeid.getListeId())");
        System.out.println(todolisteDAO.hentListAvTodosFraListe(husarbeid.getId()));
       
        /* ----------------------------------------------------------------- */
        
        System.out.println("\n\nSletter listen ...");
        
        todolisteDAO.slettListe(husarbeid.getId());
        System.out.println("Etter slettListe()");
        System.out.println(todolisteDAO.hentListe(husarbeid.getId()));
        
        pauseOgSjekkDatabasen("\nSjekk at vi har fått oppdatert databasen riktig.");
        
        System.out.println("Programmet er ferdig! :)");
    }
    
    /* ----------------------------------------------------------------- */
    
	private static void pauseOgSjekkDatabasen(String prompt) {
		System.out.println(prompt);
		System.out.println("Trykk \"ENTER\" for å fortsette ...");
		scanner.nextLine();
	}
    
}






