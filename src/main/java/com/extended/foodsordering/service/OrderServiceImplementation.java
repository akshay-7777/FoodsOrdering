package com.extended.foodsordering.service;

import java.util.InputMismatchException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.extended.foodsordering.bean.FinalResponse;
import com.extended.foodsordering.bean.Order;
import com.extended.foodsordering.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImplementation implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImplementation.class);
	@Override
	@Transactional
	public FinalResponse placeOrder(Order order) {
		logger.info("placeOrder :: start method" + order);
        try {
        	orderRepository.saveOrder(order);
        } catch (InputMismatchException e) {
            logger.error("placeOrder" + e.getMessage());
        }	
		FinalResponse finalResponse =  new FinalResponse();
		if(order!=null) {
			  finalResponse.setStatus(true);
	            finalResponse.setStatusCode("200");
	            finalResponse.setMessage("Order placed");
	            return finalResponse;
	        }else {
	            finalResponse.setStatus(false);
	            finalResponse.setStatusCode("501");
	            finalResponse.setErrorMessages("Order not placed");
	            return finalResponse;
	        }
	}

	@Override
	@Transactional
	public FinalResponse deleteOrder(int id) {
		logger.info("deleteOrder :: start method"+ id);
        try {
        	orderRepository.deleteOrder(id);
        } catch (InputMismatchException e) {
            logger.error("deleteOrder" + e.getMessage());
        }			
		FinalResponse finalResponse = new FinalResponse();
		if (id > 0) {
			 finalResponse.setStatus(true);
	            finalResponse.setStatusCode("Ok");
	            finalResponse.setMessage("Order deleted");
	            return finalResponse;
	        } else {
	        	finalResponse.setStatus(false);
	            finalResponse.setStatusCode("501");
	            finalResponse.setMessage("Order  Not deleted");
	            finalResponse.setErrorMessages("Check error id ones");
	            return finalResponse;
	        }
	}

	@Override
	@Transactional
	public FinalResponse updateOrder(Order order) {
		logger.info("updateOrder :: start method " + order);
        try {
        	orderRepository.updateOrder(order);
        } catch (InputMismatchException e) {
            logger.error("updateOrder" + e.getMessage());
        }	
		FinalResponse finalResponse = new FinalResponse();
		   if (order != null) {
			   finalResponse.setStatus(true);
	            finalResponse.setStatusCode("Ok");
	            finalResponse.setMessage("Order updated");
	            return finalResponse;
	        } else {
	        	finalResponse.setStatus(false);
	            finalResponse.setStatusCode("501");
	            finalResponse.setMessage("Order  Not updated");
	            finalResponse.setErrorMessages("Check error id ones");
	            return finalResponse;
	        }
	}

	@Override
	public FinalResponse getAllOrder() {
		logger.info("getAllOrder :: start method");
		List<Order> order = null;
        try {
        	order = orderRepository.findAllOrder();
        } catch (InputMismatchException e) {
            logger.error("getAllOrder" + e.getMessage());
        }		
		FinalResponse finalResponse = new FinalResponse();
		if (order != null) {
			finalResponse.setStatus(true);
            finalResponse.setStatusCode("Ok");
            finalResponse.setMessage("Records present");
            finalResponse.setData(order);
            return finalResponse;
        } else {
        	finalResponse.setStatus(false);
            finalResponse.setStatusCode("501");
            finalResponse.setErrorMessages("Records Not present");
            return finalResponse;
        }
	}

}
