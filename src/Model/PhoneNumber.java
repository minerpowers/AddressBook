/********************************
 * author: 	Ben Miner
 * class:	CIS 171 Java II
 * date:	October 2020
 * project:	AddressBook
 * file:	PhoneNumber.java - JPA entity 
 ********************************/
package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="phone_numbers")
public class PhoneNumber {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="contact_id")
	private int contact_id;
	@Column(name="phone_type")
	private String phoneType;
	@Column(name="phone_num")
	private String phoneNum;
	
	/**
	 * PhoneNumber - no argument constructor
	 */
	public PhoneNumber() {
		super();
	}
	/**
	 * PhoneNumber - 3 argument constructor
	 * @param contact_id
	 * @param phoneType
	 * @param phoneNum
	 */
	public PhoneNumber(int contact_id, String phoneType, String phoneNum) {
		super();
		this.contact_id = contact_id;
		this.phoneType = phoneType;
		this.phoneNum = phoneNum;
	}
	/**
	 * getContact_id
	 * @return contact_id
	 */
	public int getContact_id() {
		return contact_id;
	}
	/**
	 * setContact_id
	 * @param contact_id
	 */
	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}
	/**
	 * getPhoneType
	 * @return phoneType
	 */
	public String getPhoneType() {
		return phoneType;
	}
	/**
	 * setPhoneType
	 * @param phoneType
	 */
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	/**
	 * getPhoneNum
	 * @return phoneNum
	 */
	public String getPhoneNum() {
		return phoneNum;
	}
	/**
	 * setPhoneNum
	 * @param phoneNum
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
}
