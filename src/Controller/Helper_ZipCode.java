/********************************
 * author: 	Ben Miner
 * class:	CIS 171 Java II
 * date:	October 2020
 * project:	AddressBook
 * file:	Helper_ZipCode.java
 ********************************/
package Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.ZipCode;

public class Helper_ZipCode {
	/**
	 * entityManagerFactory
	 */
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AddressBook");
	
	/**
	 * insertZipCode - add and commit a ZipCode record to the database
	 * @param toAdd
	 */
	public void insertZipCode(ZipCode toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	/**
	 * deleteZipCode - delete a ZipCode record from the database
	 * @param toDelete
	 */
	public void deleteZipCode(ZipCode toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ZipCode> query = em.createQuery("select z from ZipCode z where z.zipCode =: selectedZip", ZipCode.class);
		query.setParameter("selectedZip", toDelete.getZipCode());
		query.setMaxResults(1);
		ZipCode result = query.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}
	/**
	 * updateZipCode - edit a ZipCode record on the database
	 * @param toUpdate
	 */
	public void updateZipCode(ZipCode toUpdate) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toUpdate);
		em.getTransaction().commit();
		em.close();
	}
	/**
	 * searchByZop - find record by matching zip code number
	 * @param findZip
	 * @return found - ZipCode object
	 */
	public ZipCode searchByZip(int findZip) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ZipCode> query = em.createQuery("select z from z where z.zipCode =: selectedZip", ZipCode.class);
		query.setParameter("selectZip", findZip);
		ZipCode found = query.getSingleResult();
		em.close();
		return found;
	}
}
