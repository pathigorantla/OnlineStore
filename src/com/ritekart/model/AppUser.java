package com.ritekart.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="appuser")
public class AppUser {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String userName;
	private String password;
	private Collection<UserRole> userRoles;
	
	
	public Collection<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Collection<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	@Override
	public String toString(){
		return "id="+Id + ", userName = " + userName + ", password = " + password;
	}
	
}
