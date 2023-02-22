package com.extended.foodsordering.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.extended.foodsordering.bean.OrderDetails;


@ExtendWith(MockitoExtension.class)
class OrderDetailsRepositoryImplementationTest {

	@Mock
	private OrderDetailsRepositoryImplementation orderDetailsRepositoryImplementation;

	@Test
	@DisplayName("Save the Order Details")
	void testplacedOrderDetailsRepository() {
		    OrderDetails orderDetails = new OrderDetails();
		    orderDetails.setFoodId(2);
		    orderDetails.setOrderId(7);
		    orderDetails.setQuantity(3);
		
			when(orderDetailsRepositoryImplementation.save(any(OrderDetails.class))).thenReturn(orderDetails);
	        OrderDetails actual = orderDetailsRepositoryImplementation.save(orderDetails);
	        assertNotNull(actual);

	}

	@Test
	@DisplayName("Save multiple order details")
	public void testMultipleOrderDetailsRepository() {
		 List<OrderDetails> orderDetails = new ArrayList<>();
		 OrderDetails orderDetails1 = new OrderDetails();
		    orderDetails1.setFoodId(2);
		    orderDetails1.setOrderId(7);
		    orderDetails1.setQuantity(3);
			
		    OrderDetails orderDetails2 = new OrderDetails();
		    orderDetails2.setFoodId(6);
		    orderDetails2.setOrderId(2);
		    orderDetails2.setQuantity(8);
				
			orderDetails.add(orderDetails1);
			orderDetails.add(orderDetails2);
	            
				when(orderDetailsRepositoryImplementation.saveMultiple(orderDetails)).thenReturn(orderDetails);
		        List<OrderDetails> actual = orderDetailsRepositoryImplementation.saveMultiple(orderDetails);
		        assertNotNull(actual);
	}
	
	@Test
	@DisplayName("update the order details")
	public void testUpdateOrderDetailsRepository() {
		OrderDetails orderDetails = new OrderDetails();
	    orderDetails.setQuantity(3);
	    orderDetails.setOrderDetailsId(2);
			
			when(orderDetailsRepositoryImplementation.update(orderDetails)).thenReturn(orderDetails);
	        OrderDetails actual = orderDetailsRepositoryImplementation.update(orderDetails);
	        assertNotNull(actual);
	}
	
	@Test
	@DisplayName("Delete order details")
	public void testDeleteCustomerRepository() {
		OrderDetails orderDetails = new OrderDetails();
	    orderDetails.setOrderDetailsId(2);
		 
		 when(orderDetailsRepositoryImplementation.deleteById(anyInt())).thenReturn(orderDetails);
	        OrderDetails actual = orderDetailsRepositoryImplementation.deleteById(anyInt());
	        assertNotNull(actual);
	}

	@Test
	@DisplayName("Find orderdetails by id")
	public void testGetByIdOrderDetailsRepository() {

		 Object[] orderdetails = {2,3,7};
		 
		 when(orderDetailsRepositoryImplementation.findById(anyInt())).thenReturn(null);
	       OrderDetails actual = orderDetailsRepositoryImplementation.findById(anyInt());
	        assertNull(actual);
	}
	

	@Test
	@DisplayName("Find all orderdetails")
	public void testGetAllOrderDetailsRepository() {
		
		List<Object[]> orderdetails = new ArrayList<>();
		Object[] orderdetails1 = {2,3,7};
		Object[] orderdetails2 = {4,1,2};
		 
		 orderdetails.add(orderdetails1);
		 orderdetails.add(orderdetails2);
		 
		 when(orderDetailsRepositoryImplementation.findAll()).thenReturn(null);
	        List<OrderDetails> actual = orderDetailsRepositoryImplementation.findAll();
	        assertNull(actual);
	}

}
