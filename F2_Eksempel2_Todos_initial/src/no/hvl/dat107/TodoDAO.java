package no.hvl.dat107;

import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TodoDAO {
	
	private EntityManagerFactory emf 
			= Persistence.createEntityManagerFactory("todoPersistenceUnit", 
			Map.of("jakarta.persistence.jdbc.password", Passwords.DAT107_DB_PASSWORD));
	
	/* --------------------------------------------------------------------- */

	public Object/*???*/ finnAlleTodos(/*???*/) {
		
		EntityManager em = emf.createEntityManager();
		
		try {
			/*???*/
			return null /*???*/; 

		} finally {
			em.close();
		}
	}

	/* --------------------------------------------------------------------- */

	public Object/*???*/ finnTodoMedPk(/*???*/) {
		
		EntityManager em = emf.createEntityManager();

		try {
			/*???*/
			return null /*???*/; 

		} finally {
			em.close();
		}
	}

	/* --------------------------------------------------------------------- */

	public Object/*???*/ finnTodoMedTekst(/*???*/) {
		EntityManager em = emf.createEntityManager();
		
		try {
			/*???*/
			return null /*???*/; 
			
		} finally {
			em.close();
		}
	}
	
	/* --------------------------------------------------------------------- */

	public Object/*???*/  finnTodosMedTekst(/*???*/) {
		EntityManager em = emf.createEntityManager();
		
		try {
			/*???*/
			return null /*???*/; 
		
		} finally {
			em.close();
		}
	}

	/* --------------------------------------------------------------------- */

	public Object/*???*/ lagreNyTodo(/*???*/) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			
			/*???*/
			
			tx.commit();
			
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
		
		return null /*???*/; 
	}

	/* --------------------------------------------------------------------- */

	public Object/*???*/ slettTodoMedPk(/*???*/) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			
			/*???*/
			
			tx.commit();
			
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
		
		return null /*???*/; 
	}

	/* --------------------------------------------------------------------- */

	public Object/*???*/ oppdaterTodo(/*???*/) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			
			/*???*/
			
			tx.commit();
			
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
		
		return null /*???*/; 
	}

	/* --------------------------------------------------------------------- */

	public Object/*???*/ oppdaterTekst(/*???*/) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			
			/*???*/
			
			tx.commit();
			
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
		
		return null /*???*/; 
	}
}
