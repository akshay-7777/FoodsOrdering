package com.extended.foodsordering.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.extended.foodsordering.bean.OrderDetails;
@Repository
public interface OrderDeatilsRepository {

	public OrderDetails save(OrderDetails orderDetails);
	public List<OrderDetails> saveMultiple(List<OrderDetails> orderDetails);
	public List<OrderDetails> findAll();
	public OrderDetails findById(int id);
	public OrderDetails deleteById(int id);
	public OrderDetails update(OrderDetails orderDetails);
}
