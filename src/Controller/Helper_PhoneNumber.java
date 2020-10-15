/********************************
 * author: 	Ben Miner
 * class:	CIS 171 Java II
 * date:	October 2020
 * project:	AddressBook
 * file:	Helper_PhoneNumber.java
 ********************************/
package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.PhoneNumber;

public class Helper_PhoneNumber {
	/**
	 * Declare: entityManagerFactory
	 */
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AddressBook");
	
	/**
	 * insertPhoneNumber - add PhoneNumber object to database
	 * @param toAdd
	 */
	public void insertPhoneNumber(PhoneNumber toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	/**
	 * deletePhoneNumber - remove PhoneNumber object form database
	 * @param toDelete
	 */
	public void deletePhoneNumber(PhoneNumber toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PhoneNumber> query = em.createQuery("select p from PhoneNumber p where p.phoneNum = :selectedNum", PhoneNumber.class);
		query.setParameter("selectedNum", toDelete.getPhoneNum());
		query.setMaxResults(1);
		PhoneNumber result = query.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	/**
	 * updatePhoneNumber - update PhoneNumber object on database
	 * @param toUpdate
	 */
	public void updatePhoneNumber(PhoneNumber toUpdate) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toUpdate);
		em.getTransaction().commit();
		em.close();
	}
	/**
	 * searchByPhoneNum - find PhoneNumber objects using PhoneNum
	 * @param toFind
	 * @return found - list of matching phone numbers
	 */
	public List<PhoneNumber> searchByPhoneNum(String toFind) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PhoneNumber> query = em.createQuery("select p from PhoneNumber p where p.phoneNum = :selectedNum", PhoneNumber.class);
		query.setParameter("selectNum", toFind);
		List<PhoneNumber> found = query.getResultList();
		em.close();
		return found;
	}
	public List<PhoneNumber> getPhoneNums(int contactID){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PhoneNumber> query = em.createQuery("select p from PhoneNumber p where p.contact_id = :selectID", PhoneNumber.class);
		query.setParameter("selectID", contactID);
		List<PhoneNumber> found = query.getResultList();
		em.close();
		return found;
	}
	
	public PhoneNumber getPhoneById(int contactID){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PhoneNumber> query = em.createQuery("select p from PhoneNumber p where p.contact_id = :selectID", PhoneNumber.class);
		query.setParameter("selectID", contactID);
		PhoneNumber found = query.getSingleResult();
		em.close();
		return found;
	}
}
