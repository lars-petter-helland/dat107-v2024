package no.hvl.dat107;

import java.util.List;
import java.util.Scanner;


public class Main {

	//-------------------------------------------------------------------------
	
	/*
	 *  Hjelpeklasse for å snakke med databasen.
	 *  DAO er en forkortelse for Data Access Object,
	 *  og er et vanlig navn på slike.
	 */
	private static TodoDAO todoDAO = new TodoDAO();
	
	public static void main(String[] args) {

		/* 
		 * Databasen i utgangspunktet:
		 * 	1, 'Handle mat'
		 * 	2, 'Vaske opp'
		 *  3, 'Ta ut bosset'
		 */

		// a) Hente ut alle todos 
		List<Todo> alle = todoDAO.finnAlleTodos();
		System.out.println(alle);
		
		// b) Hente ut todo med pk=2
		Todo todo2 = todoDAO.finnTodoMedPk(2);
		System.out.println(todo2);
		
		// c.i)   Hente ut SINGLE todo med tekst="Handle mat" 
		// c.ii)  Hente ut SINGLE todo med tekst="Vaske bilen" (som ikke finnes) 
		// c.iii) Hente ut LISTE av todos med tekst="Handle mat" 
		// c.iv)  Hente ut LISTE av todos med tekst="Vaske bilen" (som ikke finnes)
		
		// d) Legge til en ny todo med pk=4
		todoDAO.lagreNyTodo(4, "Vaske klær");
		
		// e) Slette todo med pk=4
		// f) Endre tekst på todo med pk=3
		// g) Endre tekst på todo med pk=3, alternativ måte
	}
	
	//-------------------------------------------------------------------------
	
	private static Scanner scanner = new Scanner(System.in);
	
	private static void pauseOgSjekkPgAdmin(String sisteAction) {
		System.out.println("\n" + sisteAction);
		System.out.println("\nTodo-objekter i persistence context nå:");
//		todoDAO.finnAlleTodos().forEach(System.out::println);
		System.out.println("\nSjekk om det ser likt ut i PgAdmin.");
		System.out.println("\nTrykk \"ENTER\" for å fortsette programmet ...");
		scanner.nextLine();
	}
	

}
