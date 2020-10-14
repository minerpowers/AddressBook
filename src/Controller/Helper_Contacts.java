/********************************
 * author: 	Ben Miner
 * class:	CIS 171 Java II
 * date:	October 2020
 * project:	AddressBook
 * file:	Helper_Contacts.java
 ********************************/
package Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.Contacts;

public class Helper_Contacts {
	/**
	 * Declare: entityManagerFactory
	 */
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AddressBook");
	
	/**
	 * insertContact - add Contacts object to database
	 * @param toAdd
	 */
	public void insertContact(Contacts toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * deleteContact - remove Contacts object from database
	 * @param toDelete
	 */
	public void deleteContact(Contacts toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Contacts> query = em.createQuery("select c from ZipCode c where c.id =: selectedId", Contacts.class);
		query.setParameter("selectedId", toDelete.getId());
		query.setMaxResults(1);
		Contacts result = query.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * updateContact - update a Contacts object in the database
	 * @param toUpdate
	 */
	public void updateContact(Contacts toUpdate) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toUpdate);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * searchById - find a Contacts object using contact_id(primary key)
	 * @param toFind
	 * @return found - Contacts object
	 */
	public Contacts searchById(int toFind) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Contacts> query = em.createQuery("select c from c where c.contact_id =: selectedId", Contacts.class);
		query.setParameter("selectId", toFind);
		Contacts found = query.getSingleResult();
		em.close();
		return found;
	}
}
