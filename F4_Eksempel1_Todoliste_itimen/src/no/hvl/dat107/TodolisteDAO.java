package no.hvl.dat107;

import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class TodolisteDAO {

	private EntityManagerFactory emf;

	public TodolisteDAO() {
		emf = Persistence.createEntityManagerFactory("todosPU",
				Map.of("jakarta.persistence.jdbc.password", Passwords.DAT107_DB_PASSWORD));

	}

	public Todoliste hentListe(int id) {
		EntityManager em = emf.createEntityManager();
		try {
			return null; //TODO Fyll inn manglende kode for å hente liste

		} finally {
			em.close();
		}
	}

	public void lagreNyListe(Todoliste nyListe) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			//TODO Fyll inn manglende kode for å lagre ny liste
			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

	public void oppdaterListe(Todoliste oppdatertListe) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			//TODO Fyll inn manglende kode for å oppdatere liste
			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

	public void slettListe(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			//TODO Fyll inn manglende kode for å slette liste
			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

	public Todoliste hentListeMedNavn(String navn) {

		EntityManager em = emf.createEntityManager();
		try {

			return null; //TODO Fyll inn manglende kode for å hente liste med gitt navn
							//  Unntakshåndtering? Returnere null om ikke finnes? ...

		} finally {
			em.close();
		}
	}

	public List<Todo> hentListAvTodosFraListe(int listeid) {
		
        String queryString = "select t from Todo t " 
                + "where t.liste.id = :listeid "
                + "order by t.tekst asc";

		EntityManager em = emf.createEntityManager();
		try {

            TypedQuery<Todo> query = em.createQuery(queryString, Todo.class);
            query.setParameter("listeid", listeid);
            return query.getResultList();
 
		} finally {
			em.close();
		}
	}

}
