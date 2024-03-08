package no.hvl.dat107;

import java.util.List;

public class MainPersonCRUDeksempel {
	
	private static PersonCRUD personCrud = new PersonCRUDmedJPA();
	
	public static void main(String[] args) {

		/* Eksempeldatabasen vår ser slik ut:
		 *  
		 * id		navn
		 * ----------------------
		 * 1001	'Per Viskeler'
		 * 1002	'Atle Patle'
		 * 1003	'Donald Duck'
		 */
		skrivUt("Utgangspunkt");
		
		personCrud.lagrePerson(new Person(1004, "Mikke"));
		skrivUt("Har lagt til Mikke");
		
		personCrud.oppdaterPerson(1004, "Mikke Mus");
		skrivUt("Har endret navn til Mikke Mus");
		
		personCrud.slettPerson(1001);
		skrivUt("Har slettet person med id 1001");
		
		personCrud.lagrePerson(new Person(1001, "Per Viskeler"));
		personCrud.slettPerson(1004);
		skrivUt("Har tilbakestilt db");
	}

	private static void skrivUt(String tekst) {
		List<Person> personer = personCrud.hentAllePersoner();
		System.out.println("\n--- "+ tekst +" ---");
		personer.forEach(System.out::println);		
	}

}
