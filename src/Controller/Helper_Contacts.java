/********************************
 * author: 	Ben Miner
 * class:	CIS 171 Java II
 * date:	October 2020
 * project:	AddressBook
 * file:	Helper_Contacts.java
 ********************************/
package Controller;

import java.util.List;

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
		Contacts result = em.find(Contacts.class, toDelete.getId());
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
	public Contacts searchById(Integer toFind) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Contacts found = em.find(Contacts.class, toFind);
		em.close();
		return found;
	}
	/**
	 * searchByName - find record by matching fist and last name
	 * @param toFind
	 * @return found - Contact object
	 */
	public Contacts searchByName(Contacts toFind) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Contacts> query = em.createQuery("select c from Contacts c where c.firstName =:first_name and c.lastName =:last_name", Contacts.class);
		query.setParameter("first_name", toFind.getFirstName());
		query.setParameter("last_name", toFind.getLastName());
		query.setMaxResults(1);
		Contacts found = query.getSingleResult();
		em.close();
		return found;
	}
	public List<Contacts> getAllContacts(){
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Contacts> query = em.createQuery("select c from Contacts c", Contacts.class);
		List<Contacts> allContacts = query.getResultList();
		return allContacts;
	}
}
