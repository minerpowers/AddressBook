/********************************
 * author: 	Ben Miner
 * class:	CIS 171 Java II
 * date:	October 2020
 * project:	AddressBook
 * file:	Helper_Emails.java
 ********************************/
package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.Emails;

public class Helper_Emails {
	/**
	 * Declare: entityManagerFactory
	 */
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AddressBook");
	
	/**
	 * insertEmail - add Emails object to database
	 * @param toAdd
	 */
	public void insertEmail(Emails toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	/**
	 * deleteEmail - delete Emails object from database
	 * @param toDelete
	 */
	public void deleteEmail(Emails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Emails> query = em.createQuery("select e from ZipCode e where e.emailAddress =: selectedEmail", Emails.class);
		query.setParameter("selectedEmail", toDelete.getEmailAddress());
		query.setMaxResults(1);
		Emails result = query.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	/**
	 * updateEmail - update an existing Emails object on the database
	 * @param toUpdate
	 */
	public void updateEmail(Emails toUpdate) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toUpdate);
		em.getTransaction().commit();
		em.close();
	}
	/**
	 * searchByContact_id - find object using contact_id
	 * @param toFind
	 * @return found - list of matching Emails object
	 */
	public List<Emails> searchByContact_id(int toFind) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Emails> query = em.createQuery("select e from e where e.contact_id =: selectedId", Emails.class);
		query.setParameter("selectId", toFind);
		List<Emails> found = query.getResultList();
		em.close();
		return found;
	}
}
