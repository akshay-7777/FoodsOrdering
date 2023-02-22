package com.extended.foodsordering.bean;

import java.sql.Date;

public class Order {
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", employeeId=" + employeeId
				+ ", orderDate=" + orderDate + "]";
	}
	private int orderId;
	private int customerId;
	private int employeeId;
	private Date orderDate;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	
}
