package com.extended.foodsordering.repository;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.extended.foodsordering.bean.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class CustomerRepositoryImplementation implements CustomerRepository{

	@Autowired
	private EntityManager entitymanager;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerRepositoryImplementation.class);
	
	@Override
	@Transactional
	public Customer save(Customer customer) {
		logger.info("save :: start method "+customer);
		Query query = entitymanager.createNativeQuery("insert into FoodsOrdering.customer values(?,?,?,?,?,?,?)");
		query.setParameter(1, customer.getCustomerId());
		query.setParameter(2, customer.getCustomerName());
		query.setParameter(3, customer.getCustomerMobileNumber());
		query.setParameter(4, customer.getCity());
		query.setParameter(5, customer.getAddress());
		query.setParameter(6, customer.getCreatedDate());
		query.setParameter(7, customer.getUpdatedDate());
		try{
			query.executeUpdate();
		}catch(Exception e) {
			e.getMessage();
		}
		return customer;
	}

	@Override
	@Transactional
	public List<Customer> saveAll(List<Customer> customer) {
		logger.info("saveAll :: start method "+customer);
		for(Customer customers:customer) {
		Query query = entitymanager.createNativeQuery("insert into FoodsOrdering.customer values(?,?,?,?,?,?,?)");
		query.setParameter(1, customers.getCustomerId());
		query.setParameter(2, customers.getCustomerName());
		query.setParameter(3, customers.getCustomerMobileNumber());
		query.setParameter(4, customers.getCity());
		query.setParameter(5, customers.getAddress());
		query.setParameter(6, customers.getCreatedDate());
		query.setParameter(7, customers.getUpdatedDate());
		try {
		query.executeUpdate();
		}catch(Exception e) {
		e.getMessage();
		}
		}
		return customer;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAll() {
		logger.info("findAll :: start method ");
		Query query = entitymanager.createNativeQuery("select * from customer");
		List<Customer> customer = new ArrayList<Customer>();
		try {
		customer = query.getResultList();
		}catch(Exception e) {
			logger.info("findAll "+e.getMessage());
		}
		return customer;
	}

	@Override
	public Object findById(int id) {
		logger.info("findById :: start method "+id);
		Query query = entitymanager.createNativeQuery("select * from customer where customer.Customer_id=?");
		query.setParameter(1, id);
		Object get = new Customer();
		try {
			get = (Object)query.getSingleResult();
		}catch(Exception e) {
			logger.info("findById "+e.getMessage());
		}
		return get;
	}

	@Override
	@Transactional
	public Customer deleteById(int id) {
		logger.info("deleteById :: start method "+id);
		Customer customer = new Customer();
		Query query = entitymanager.createNativeQuery("delete from customer where customer.Customer_id=?");
		query.setParameter(1, id);
        try {
        	query.executeUpdate();
		}catch(Exception e) {
			logger.info("deleteById "+e.getMessage());
		}
		return customer;
	}

	@Override
	@Transactional
	public Customer update(Customer customer) {
		logger.info("update :: start method "+customer);
		Query query = entitymanager.createNativeQuery
		("update customer set customer_name=?, customer_mobile_number=?, city=?, address=?, created_date=?, updated_date=? where customer.Customer_id=?");
		query.setParameter(1, customer.getCustomerName());
		query.setParameter(2, customer.getCustomerMobileNumber());
		query.setParameter(3, customer.getCity());
		query.setParameter(4, customer.getAddress());
		query.setParameter(5, customer.getCreatedDate());
		query.setParameter(6, customer.getUpdatedDate());
		
		query.setParameter(7, customer.getCustomerId());
		try {
			query.executeUpdate();
		}catch(Exception e) {
			logger.info("update "+e.getMessage());
		}
		return customer;
	}

	
}
