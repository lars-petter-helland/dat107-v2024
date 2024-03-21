package no.hvl.dat107.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import no.hvl.dat107.entity.Person;

public class PersonDAO {

    private EntityManagerFactory emf;

    public PersonDAO() {
        emf = Persistence.createEntityManagerFactory("PersonProsjektPU");
    }
    
    public Person finnPersonMedFNr(String fNr) {

        EntityManager em = emf.createEntityManager();

        Person person = null;
        try {
            person = em.find(Person.class, fNr);
        } finally {
            em.close();
        }
        return person;
    }

    public List<Person> finnAllePersoner() {
        
        EntityManager em = emf.createEntityManager();

        List<Person> p = null;
        try {
            TypedQuery<Person> query 
                    = em.createQuery("SELECT p FROM Person p", Person.class);
            p = query.getResultList();
            
        } finally {
            em.close();
        }
        return p;
    }

    public void lagrePerson(Person person) {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
            tx.begin();
            em.persist(person);
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }
    }

}
