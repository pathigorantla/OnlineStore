package com.ritekart.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="userrole")
public class UserRole {
	
	private String userName;
	private String userRole;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	@Override
	public String toString(){
		return "userName = " + userName + " , useRole = " + userRole;
	}
}
