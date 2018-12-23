package com.example.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Login")
public class SignUpBeanEntity {

	
	@Column(name = "USER_ID")
	int UserId;
	
	String firstName;
	String lastName;
	@Id
	/*@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")*/
	String email;
	String password;
	String address;
	String phoneNumber;
	@Temporal(TemporalType.TIMESTAMP)
	Date lastLoginDate;
	
	public Date getLastLoignDate() {
		return lastLoginDate;
	}
	public void setLastLoignDate(Date lastLoignDate) {
		this.lastLoginDate = lastLoignDate;
	}
	@Override
	public String toString() {
		return "SignUpBeanEntity [UserId=" + UserId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", lastLoginDate=" + lastLoginDate + "]";
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
