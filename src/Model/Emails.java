/********************************
 * author: 	Ben Miner
 * class:	CIS 171 Java II
 * date:	October 2020
 * project:	AddressBook
 * file:	Emails.java - JPA entity 
 ********************************/
package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="email")
public class Emails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="contact_id")
	private int contact_id;
	@Column(name="email_type")
	private String emailType;
	@Column(name="email_address")
	private String emailAddress;
	/**
	 * Emails Constructor: no arguments
	 */
	public Emails() {
		super();
	}
	/**
	 * Emails Constructor: 3 arguments
	 * @param contact_id
	 * @param emailType
	 * @param emailAddress
	 */
	public Emails(int contact_id, String emailType, String emailAddress) {
		super();
		this.contact_id = contact_id;
		this.emailType = emailType;
		this.emailAddress = emailAddress;
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
	 * getEmailType
	 * @return emailType
	 */
	public String getEmailType() {
		return emailType;
	}
	/**
	 * setEmailType
	 * @param emailType
	 */
	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}
	/**
	 * getEmailAddress
	 * @return emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * setEmailAddress
	 * @param emailAddress
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	
}