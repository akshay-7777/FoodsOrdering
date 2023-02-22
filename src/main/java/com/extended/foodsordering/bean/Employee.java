package com.extended.foodsordering.bean;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Employee {
	
	private int employeeId;
	@NotNull(message = "firstname should be mention")
	@NotBlank
	private String firstName;
	@NotNull(message = "lastname should be mention")
	@NotBlank
	private String lastName;
	private int age;
	@NotNull(message = "Employee number should be mention")
	@NotBlank
	private String employeeNumber;
	private Date creatdeDate;
	private Date updateDate;
	
	private String userName;
	private String passWord;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public Date getCreatdeDate() {
		return creatdeDate;
	}
	public void setCreatdeDate(Date creatdeDate) {
		this.creatdeDate = creatdeDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	public Employee(String username, String password) {
		this.setUserName(username);
		this.setPassWord(password);
	}
	
	public Employee() {
		
	}
	

}
