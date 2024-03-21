package no.hvl.dat107;

import java.util.List;

import no.hvl.dat107.dao.PersonDAO;
import no.hvl.dat107.entity.Ansatt;
import no.hvl.dat107.entity.Person;
import no.hvl.dat107.entity.Student;

public class Main {

    public static void main(String[] args) {
        
        PersonDAO personDAO = new PersonDAO();
        
        System.out.println();
        System.out.println("Søk på 3 individuelle personer med find:");
        System.out.println(personDAO.finnPersonMedFNr("12345678901"));
        System.out.println(personDAO.finnPersonMedFNr("23456789012"));
        System.out.println(personDAO.finnPersonMedFNr("34567890123"));
        
        List<Person> personer = personDAO.finnAllePersoner();
        System.out.println();     
        System.out.println("Alle personer:");
        personer.forEach(System.out::println);

        Student larsPetter = new Student("81223344558", "Lars-Petter", "Helland", "Informatikk");
        System.out.println();
        System.out.println("Ny Student i main:");
        System.out.println(larsPetter);

        Ansatt petterLars = new Ansatt("86554433223", "Petter-Lars", "Olsen", "Rektor");
        System.out.println();
        System.out.println("Ny Ansatt i main:");
        System.out.println(petterLars);
        
        //Får duplicate key violation andre gang selvfølgelig ...
        personDAO.lagrePerson(larsPetter);
        personDAO.lagrePerson(petterLars);
        System.out.println();
        System.out.println("Lagt inn disse 2 og søkt dem opp igjen med find:");
        System.out.println(personDAO.finnPersonMedFNr("81223344558"));
        System.out.println(personDAO.finnPersonMedFNr("86554433223"));
        
        personer = personDAO.finnAllePersoner();
        System.out.println();     
        System.out.println("Alle personer:");
        personer.forEach(System.out::println);
        
    }

}
