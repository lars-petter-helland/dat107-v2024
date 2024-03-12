package no.hvl.dat107;

import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class PersonDAO {

    private EntityManagerFactory emf;
    
    public PersonDAO() {
    	emf	= Persistence.createEntityManagerFactory("personPersistenceUnit", 
		Map.of("jakarta.persistence.jdbc.password", Passwords.DAT107_DB_PASSWORD));
    }
    
    public int savePerson(Person p) {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(p); 	// Lagrer en ny person i databasen.
            				// Databasen genererer en ny id og setter denne i objektet. 
            tx.commit();
        
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        return p.getId();
    }
    
    public Person retrievePerson(int id) {

        EntityManager em = emf.createEntityManager();

        Person p = null;
        try {
            p = em.find(Person.class, id);
            
        } finally {
            em.close();
        }
        
        return p;
    }
    
    public List<Person> retrieveAllePersoner() {

        EntityManager em = emf.createEntityManager();

        List<Person> personer = null;
        try {
            String queryString = "select p from Person p order by p.id";
            TypedQuery<Person> query = em.createQuery(queryString, Person.class);
            personer = query.getResultList();
            
        } finally {
            em.close();
        }
        return personer;
    }
    
    public void updatePerson(Person p) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            
            // Ved oppdatering av eksisterende entiteter er det to ulike alternativer
            
            // 1 - Gjøre en merge. Da vil raden i databasen oppdateres med dataene i p.
            //		Merk at p fremdeles er "detatched", mens returobjektet q er en 
            //		"managed" kopi av p. 
            Person q = em.merge(p);
            
            // 2 - Vi kan alternativt hente en "managed" person r (som har p sin id)
            // 		fra databasen ved å gjøre en find.
            Person r = em.find(Person.class, p.getId());

            // 		Endringer vi gjør på q og r vil føre til endring i databasen.
            // 		Endringer vi gjør på p vil IKKE føre til endringer ...
            
            em.getTransaction().commit();
        
        } catch (Throwable e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public void deletePerson(Person p) {
        
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            
            // Ved sletting må personen som skal slettes være "managed"!
            Person q = em.find(Person.class, p.getId());
            em.remove(q);
            
            em.getTransaction().commit();
        
        } catch (Throwable e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
