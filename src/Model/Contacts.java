/********************************
 * author: 	Ben Miner
 * class:	CIS 171 Java II
 * date:	October 2020
 * project:	AddressBook
 * file:	Contacts.java - JPA entity 
 ********************************/
package Model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="contact")
public class Contacts {
	/**
	 * variables
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="contact_id")
	private int id;
	@Column(name="date_reated")
	@Temporal(TemporalType.DATE)
	private Date created;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="street")
	private String streetAddress;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable(name="phone_numbers",
				inverseJoinColumns= {@JoinColumn(name="contact_id", referencedColumnName="contact_id", unique=true)})
	private List<PhoneNumber> phoneList;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable(name="phone_numbers",
				inverseJoinColumns= {@JoinColumn(name="contact_id", referencedColumnName="contact_id", unique=true)})
	private List<Emails> emailList;
	@Column(name="zip")
	@ManyToOne(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinColumn(name="zip", referencedColumnName="zip_code")
	private ZipCode zipCode;
	/**
	 * Contacts: no argument constructor
	 */
	public Contacts() {
		super();
	}
	/**
	 * Contacts: 6 argument constructor
	 * @param firstName
	 * @param lastName
	 * @param streetAddress
	 * @param phoneList
	 * @param emailList
	 * @param zipCode
	 */
	public Contacts(String firstName, String lastName, String streetAddress, List<PhoneNumber> phoneList,
			List<Emails> emailList, ZipCode zipCode) {
		super();
		this.created = new Date();
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.phoneList = phoneList;
		this.emailList = emailList;
		this.zipCode = zipCode;
	}
	/**
	 * getId
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * setId
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * getCreated
	 * @return created
	 */
	public Date getCreated() {
		return created;
	}
	/**
	 * setCreated
	 * @param created
	 */
	public void setCreated(Date created) {
		this.created = new Date();
	}
	/**
	 * getFirstName
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * setFirstName
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * getLastName
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * setLastName
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * getStreetAdress
	 * @return streetAddress
	 */
	public String getStreetAddress() {
		return streetAddress;
	}
	/**
	 * setStreetAddress
	 * @param streetAddress
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	/**
	 * getPhoneList
	 * @return phoneList
	 */
	public List<PhoneNumber> getPhoneList() {
		return phoneList;
	}
	/**
	 * setPhoneList
	 * @param phoneList
	 */
	public void setPhoneList(List<PhoneNumber> phoneList) {
		this.phoneList = phoneList;
	}
	/**
	 * getEmailList
	 * @return emailList
	 */
	public List<Emails> getEmailList() {
		return emailList;
	}
	/**
	 * setEmailList
	 * @param emailList
	 */
	public void setEmailList(List<Emails> emailList) {
		this.emailList = emailList;
	}
	/**
	 * getZipCode
	 * @return zipCode
	 */
	public ZipCode getZipCode() {
		return zipCode;
	}
	/**
	 * setZipCode
	 * @param zipCode
	 */
	public void setZipCode(ZipCode zipCode) {
		this.zipCode = zipCode;
	}
	
	
}
