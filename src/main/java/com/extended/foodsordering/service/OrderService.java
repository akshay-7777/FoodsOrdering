package com.extended.foodsordering.service;

import com.extended.foodsordering.bean.FinalResponse;
import com.extended.foodsordering.bean.Order;

public interface OrderService {

	public FinalResponse placeOrder(Order order);
	public FinalResponse deleteOrder(int id);
	public FinalResponse updateOrder(Order order);
	public FinalResponse getAllOrder();
}
