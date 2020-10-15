/********************************
 * author: 	Ben Miner
 * class:	CIS 171 Java II
 * date:	October 2020
 * project:	AddressBook
 * file:	ZipCode.java - JPA entity 
 ********************************/

package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="zip_location")
public class ZipCode {
	/**
	 * Variables
	 */
	@Id
	@Column(name="zip_code")
	private int zipCode;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	/**
	 * ZipCode Constructor: no arguments
	 */
	public ZipCode() {
		super();
	}
	/**
	 * zipCode Constructor: 3 arguments
	 * @param zipCode
	 * @param city
	 * @param state
	 */
	public ZipCode(int zipCode, String city, String state) {
		super();
		this.zipCode = zipCode;
		this.city = city;
		this.state = state;
	}
	/**
	 * getZipCode
	 * @return	zipCode
	 */
	public int getZipCode() {
		return zipCode;
	}
	/**
	 * setZipCode
	 * @param zipCode
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * getCity
	 * @return
	 */
	public String getCity() {
		return city;
	}
	/**
	 * setCity
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * getState
	 * @return state
	 */
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
