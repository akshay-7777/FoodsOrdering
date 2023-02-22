package com.extended.foodsordering.repository;

import java.util.List;

import com.extended.foodsordering.bean.Order;

public interface OrderRepository {
	
	public Order saveOrder(Order order);
	public Order deleteOrder(int id);
	public Order updateOrder(Order order);
	public List<Order> findAllOrder();

}
