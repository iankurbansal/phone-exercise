
package com.phone.exercise.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.tomcat.jni.Library;
/**
 * 
 * @author Ankur Bansal
 * Phone pojo calss
 *
 */
@Entity
public class Phone {

	@Id
	@GeneratedValue private UUID phoneId; 
	private String phoneName; 
	private PhoneModel phoneModel;
	private String phoneNumber;
	@ManyToOne
    @JoinColumn(name="user_id")
    private User user;


	public UUID getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(UUID phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneName() {
		return phoneName;
	}

	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}

	public PhoneModel getPhoneModel() {
		return phoneModel;
	}

	public void setPhoneModel(PhoneModel phoneModel) {
		this.phoneModel = phoneModel;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((phoneId == null) ? 0 : phoneId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		if (phoneId == null) {
			if (other.phoneId != null)
				return false;
		} else if (!phoneId.equals(other.phoneId))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "Phone [phoneId=" + phoneId + ", phoneName=" + phoneName + ", phoneModel=" + phoneModel
				+ ", phoneNumber=" + phoneNumber + ", user=" + user + "]";
	} }
