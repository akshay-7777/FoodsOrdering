package com.extended.foodsordering.bean;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Customer {

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerMobileNumber="
				+ customerMobileNumber + ", city=" + city + ", address=" + address + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}
	private int customerId;
	@NotNull(message = "customer name can not be empty")
	@NotBlank
	private String customerName;
	@NotNull(message = "customer mobile number should be mention")
	@NotBlank
	private String customerMobileNumber;
	@NotNull(message = "city should be mention")
	@NotBlank
	private String city;
	@NotNull(message = "Address should be mention")
	@NotBlank
	private String address;
	private Date createdDate;
	private Date updatedDate;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerMobileNumber() {
		return customerMobileNumber;
	}
	public void setCustomerMobileNumber(String customerMobileNumber) {
		this.customerMobileNumber = customerMobileNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	
	
}
