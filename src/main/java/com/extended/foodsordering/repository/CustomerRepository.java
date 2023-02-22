package com.extended.foodsordering.repository;

import java.util.List;

import com.extended.foodsordering.bean.Customer;

public interface CustomerRepository {

	public Customer save(Customer customer);
	public List<Customer> saveAll(List<Customer> customer);
	public List<Customer> findAll();
	public Object findById(int id);
	public Customer deleteById(int id);
	public Customer update(Customer customer);
	
}
