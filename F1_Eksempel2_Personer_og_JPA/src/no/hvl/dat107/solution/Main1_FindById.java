package no.hvl.dat107.solution;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main1_FindById {
	
	private static EntityManagerFactory emf;
	static {
		emf = Persistence.createEntityManagerFactory("personPersistenceUnit");
	}
	
	/* ------------------------------------------------------------------- */

    public static void main(String[] args) {
    	
        Person p = finnPersonMedId(1001);
        System.out.println(p);
    }

    private static Person finnPersonMedId(int id) {

		System.out.println("Kobler til database...");
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Person.class, id);
        } finally {
            em.close();
        }
    }
}
