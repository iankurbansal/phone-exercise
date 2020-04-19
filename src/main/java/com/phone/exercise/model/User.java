package com.phone.exercise.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/**
 * 
 * @author Ankur Bansal
 * User pojo class
 *
 */
@Entity
public class User {
	@Id
	@GeneratedValue
	private UUID userId;
	private String userName;
	private String password;
	private String emailAddress;
	private String preferredPhoneNumber;
	@OneToMany (orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "user")
	private List<Phone> phones;

	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPreferredPhoneNumber() {
		return preferredPhoneNumber;
	}
	public void setPreferredPhoneNumber(String preferredPhoneNumber) {
		this.preferredPhoneNumber = preferredPhoneNumber;
	}
	public List<Phone> getPhones() {
		return phones;
	}
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	public void addPhone(Phone phone) {
		if(!phones.contains(phone)) {
			phones.add(phone);
		}
	}
	public void removePhone(Phone phone) {
		if(phones.contains(phone)) {
			phones.remove(phone);	
		}
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", emailAddress="
				+ emailAddress + ", preferredPhoneNumber=" + preferredPhoneNumber + ", phones=" + phones + "]";
	}

}
