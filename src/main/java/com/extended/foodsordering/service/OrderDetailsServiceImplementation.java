package com.extended.foodsordering.service;

import java.util.InputMismatchException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.extended.foodsordering.bean.FinalResponse;
import com.extended.foodsordering.bean.OrderDetails;
import com.extended.foodsordering.repository.OrderDeatilsRepository;

@Service
public class OrderDetailsServiceImplementation implements OrderDetailsService{

	@Autowired
	private OrderDeatilsRepository orderDeatilsRepository;

	private static final Logger logger = LoggerFactory.getLogger(OrderDetailsServiceImplementation.class);
	
	@Override
	public FinalResponse orderPlaced(OrderDetails orderDetails) {
		logger.info("orderPlaced :: start method" + orderDetails);
        try {
        	orderDeatilsRepository.save(orderDetails);
        } catch (InputMismatchException e) {
            logger.error("orderPlaced " + e.getMessage());
        }	
		FinalResponse finalResponse = new FinalResponse();
		if(orderDetails!=null) {
			finalResponse.setStatus(true);
            finalResponse.setStatusCode("200");
            finalResponse.setMessage("One Record Inserted");
            return finalResponse;
        }else {
            finalResponse.setStatus(false);
            finalResponse.setStatusCode("501");
            finalResponse.setErrorMessages("Record  Not Recorded");
            return finalResponse;         
        }
	}

	@Override
	public FinalResponse multipleOrderPlaced(List<OrderDetails> orderDetails) {
		logger.info("multipleOrderPlaced :: start method" + orderDetails);
        try {
        	orderDeatilsRepository.saveMultiple(orderDetails);
        } catch (InputMismatchException e) {
            logger.error("multipleOrderPlaced " + e.getMessage());
        }	
		FinalResponse finalResponse = new FinalResponse();
		if(orderDetails!=null) {
			finalResponse.setStatus(true);
            finalResponse.setStatusCode("200");
            finalResponse.setMessage("Records Inserted");
            return finalResponse;
        }else {
            finalResponse.setStatus(false);
            finalResponse.setStatusCode("501");
            finalResponse.setErrorMessages("Records  Not Recorded");
            return finalResponse;         
        }
	}

	@Override
	public FinalResponse orderViewById(int id) {
		logger.info("orderViewById :: start method" + id);
		OrderDetails orderDetails = null;
        try {
        	orderDetails = orderDeatilsRepository.findById(id);
        } catch (InputMismatchException e) {
            logger.error("orderViewById" + e.getMessage());
        }	
		 FinalResponse finalResponse = new FinalResponse();
			if(orderDetails!=null) {
				finalResponse.setStatus(true);
	            finalResponse.setStatusCode("200");
	            finalResponse.setMessage("One Record show");
	            finalResponse.setData(orderDetails);
	            return finalResponse;
	        }else {
	            finalResponse.setStatus(false);
	            finalResponse.setStatusCode("501");
	            finalResponse.setErrorMessages("Record  Not show");
	            return finalResponse;         
	        }
	}

	@Override
	public FinalResponse viewAllOrder() {
		logger.info("viewAllOrder :: start method ");
		List<OrderDetails> orderDetails = null;
        try {
        	orderDetails = orderDeatilsRepository.findAll();
        } catch (InputMismatchException e) {
            logger.error("viewAllOrder" + e.getMessage());
        }	
		 FinalResponse finalResponse = new FinalResponse();
			if(orderDetails!=null) {
				finalResponse.setStatus(true);
	            finalResponse.setStatusCode("200");
	            finalResponse.setMessage("all Records show");
	            finalResponse.setData(orderDetails);
	            return finalResponse;
	        }else {
	            finalResponse.setStatus(false);
	            finalResponse.setStatusCode("501");
	            finalResponse.setErrorMessages("Record  Not present");
	            return finalResponse;         
	        }
	}

	@Override
	public FinalResponse deleteOrderById(int id) {
		logger.info("deleteOrderById :: start method" + id);
        try {
        	orderDeatilsRepository.deleteById(id);
        } catch (InputMismatchException e) {
            logger.error("deleteOrderById" + e.getMessage());
        }	
		
		 FinalResponse finalResponse = new FinalResponse();
			if(id>0) {
				finalResponse.setStatus(true);
	            finalResponse.setStatusCode("200");
	            finalResponse.setMessage("One Record delete");
	            return finalResponse;
	        }else {
	            finalResponse.setStatus(false);
	            finalResponse.setStatusCode("501");
	            finalResponse.setMessage("no Record deleted");
	            finalResponse.setErrorMessages("Check error id ones");
	            return finalResponse;         
	        }
	}

	@Override
	public FinalResponse updateOrder(OrderDetails orderDetails) {
		logger.info("updateOrder :: start method" + orderDetails);
        try {
        	 orderDeatilsRepository.update(orderDetails);
        } catch (InputMismatchException e) {
            logger.error("updateOrder" + e.getMessage());
        }	
		
		 FinalResponse finalResponse = new FinalResponse();
			if(orderDetails!=null) {
				finalResponse.setStatus(true);
	            finalResponse.setStatusCode("200");
	            finalResponse.setMessage("Record update");
	            return finalResponse;
	        }else {
	            finalResponse.setStatus(false);
	            finalResponse.setStatusCode("501");
	            finalResponse.setMessage("No Record update");
	            finalResponse.setErrorMessages("Check error id ones");
	            return finalResponse;         
	        }
	}
}

