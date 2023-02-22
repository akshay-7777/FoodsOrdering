package com.extended.foodsordering.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.extended.foodsordering.bean.OrderDetails;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class OrderDetailsRepositoryImplementation implements OrderDeatilsRepository{

	@Autowired
	private EntityManager entityManager;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderDetailsRepositoryImplementation.class);

	@Override
	@Transactional
	public OrderDetails save(OrderDetails orderDetails) {
		logger.info("save :: start method "+orderDetails);
		Query query =entityManager.createNativeQuery("insert into FoodsOrdering.OrderDetails values (?,?,?,?)");
		query.setParameter(1, orderDetails.getOrderDetailsId());
		query.setParameter(2, orderDetails.getOrderId());
		query.setParameter(3, orderDetails.getFoodId());
		query.setParameter(4, orderDetails.getQuantity());
		try {
			query.executeUpdate();	
		}catch(Exception e) {
			logger.info("save "+ e.getMessage());
		}
		return orderDetails;
	}

	@Override
	@Transactional
	public List<OrderDetails> saveMultiple(List<OrderDetails> orderDetails) {
		logger.info("saveMultiple :: start method "+orderDetails);
		for(OrderDetails orderDetail : orderDetails) {
			Query query =entityManager.createNativeQuery("insert into FoodsOrdering.OrderDetails values (?,?,?,?)");
			query.setParameter(1, orderDetail.getOrderDetailsId());
			query.setParameter(2, orderDetail.getOrderId());
			query.setParameter(3, orderDetail.getFoodId());
			query.setParameter(4, orderDetail.getQuantity());
			try {
				query.executeUpdate();	
			}catch(Exception e) {
				logger.info("saveMultiple "+ e.getMessage());
			}
		}
		return orderDetails;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetails> findAll() {
		logger.info("findAll :: start method ");
		Query query = entityManager.createNativeQuery("select * from OrderDetails");
		List<OrderDetails> orderDetails = null;
		try {
			 orderDetails = query.getResultList();	
		}catch(Exception e) {
			logger.info("findAll "+ e.getMessage());
		}
		return orderDetails;
	}

	@Override
	public OrderDetails findById(int id) {
		logger.info("findById :: start method "+id);
		Query query = entityManager.createNativeQuery("select * from OrderDetails where OrderDetails.OrderDetails_id=?");
		query.setParameter(1, id);
		OrderDetails get = null;
		try {
			get = (OrderDetails) query.getSingleResult();	
		}catch(Exception e) {
			logger.info("findById "+ e.getMessage());
		}
		return get;
	}

	@Override
	@Transactional
	public OrderDetails deleteById(int id) {
		logger.info("deleteById :: start method "+id);
		OrderDetails orderDetails = new OrderDetails();
		Query query = entityManager.createNativeQuery("delete from OrderDetails where OrderDetails.OrderDetails_id=?");
		query.setParameter(1, id);
		try {
			query.executeUpdate();	
		}catch(Exception e) {
			logger.info("deleteById "+ e.getMessage());
		}
		return orderDetails;
	}

	@Override
	@Transactional
	public OrderDetails update(OrderDetails orderDetails) {
		logger.info("update :: start method "+orderDetails);
		Query query =entityManager.createNativeQuery
				("update set OrderDetails Order_id=?, Food_id=?, Quantity=? where OrderDetails.OrderDetails_id=?");
		query.setParameter(1, orderDetails.getOrderId());
		query.setParameter(2, orderDetails.getFoodId());
		query.setParameter(3, orderDetails.getQuantity());
		
		query.setParameter(4, orderDetails.getOrderDetailsId());
		try {
			query.executeUpdate();	
		}catch(Exception e) {
			logger.info("update "+ e.getMessage());
		}
		return orderDetails;
	}
	
	
}
