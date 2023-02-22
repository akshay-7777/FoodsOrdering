package com.extended.foodsordering.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.extended.foodsordering.bean.Order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class OrderRepositoryImplementation implements OrderRepository{

	@Autowired
	private EntityManager entitymanager;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderRepositoryImplementation.class);
	
	@Override
	@Transactional
	public Order saveOrder(Order order) {
		logger.info("saveOrder :: start method "+order);
		Query query = entitymanager.createNativeQuery("insert into FoodsOrdering.Orders values(?,?,?,?)");
      	query.setParameter(1, order.getOrderId());
		query.setParameter(2, order.getCustomerId());
		query.setParameter(3, order.getEmployeeId());
		//Date date = new Date();
		query.setParameter(4, order.getOrderDate());
		try {
			query.executeUpdate();
		}catch(Exception e) {
			logger.info("saveOrder "+ e.getMessage());
		}
		return order;
	}

	@Override
	@Transactional
	public Order deleteOrder(int id) {
		logger.info("deleteOrder :: start method "+id);
		Order order = new Order();
		Query query = entitymanager.createNativeQuery("delete from Orders where Orders.Order_id=?");
		query.setParameter(1, id);
        try {
	    query.executeUpdate();
		}catch(Exception e) {
			logger.info("deleteOrder "+ e.getMessage());
		}
		return order;
	}

	@Override
	@Transactional
	public Order updateOrder(Order order) {
		logger.info("updateOrder :: start method "+order);
		Query query = entitymanager.createNativeQuery
				("update Orders set Customer_id=?, Employee_id=?, Order_Date=? where Orders.Order_id=?");
				query.setParameter(1, order.getCustomerId());
				query.setParameter(2, order.getEmployeeId());
				query.setParameter(3, order.getOrderDate());
				query.setParameter(4, order.getOrderId());
				try {
					query.executeUpdate();
				}catch(Exception e) {
					logger.info("updateOrder "+ e.getMessage());
				}
				return order;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findAllOrder() {
		logger.info("findAllOrder :: start method ");
		Query query = entitymanager.createNativeQuery("select * from Orders");
		List<Order> order = null;
        try {
        	order = query.getResultList();
		}catch(Exception e) {
			logger.info("findAllOrder "+ e.getMessage());
		}
		return order;
	}

}
