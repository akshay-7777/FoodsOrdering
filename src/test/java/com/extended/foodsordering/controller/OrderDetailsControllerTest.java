package com.extended.foodsordering.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;


import com.extended.foodsordering.bean.FinalResponse;
import com.extended.foodsordering.bean.OrderDetails;
import com.extended.foodsordering.service.OrderDetailsService;


@ExtendWith(MockitoExtension.class)
class OrderDetailsControllerTest {

	@Mock
	private OrderDetailsService orderDetailsService;
	
	@InjectMocks
	private OrderDetailsController orderDetailsController;
	
	@Test
	@DisplayName("Save the Order Details")
	void testplacedOrderDetailsController() {
		    OrderDetails orderDetails = new OrderDetails();
		    orderDetails.setFoodId(2);
		    orderDetails.setOrderId(7);
		    orderDetails.setQuantity(3);
			
			FinalResponse expected = new FinalResponse();
			expected.setStatus(true);
			expected.setStatusCode("200");
			expected.setMessage("One Record Inserted");
			
			when(orderDetailsService.orderPlaced(any(OrderDetails.class))).thenReturn(expected);
	        FinalResponse actual = orderDetailsController.placedOrderDetailsInfo(orderDetails);
	        assertEquals(expected, actual);

	}

	@Test
	@DisplayName("Save multiple order details")
	public void testMultipleOrderDetailsController() {
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
			    
				FinalResponse expected = new FinalResponse();
				expected.setStatus(true);
				expected.setStatusCode("Ok");
				expected.setMessage("Records inserted");
	            
				when(orderDetailsService.multipleOrderPlaced(orderDetails)).thenReturn(expected);
		        FinalResponse actual = orderDetailsController.getInsertMultipleCustomerInfo(orderDetails);
		        assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("update the order details")
	public void testUpdateOrderDetailsController() {
		OrderDetails orderDetails = new OrderDetails();
	    orderDetails.setQuantity(3);
	    orderDetails.setOrderDetailsId(2);

			FinalResponse expected = new FinalResponse();
			expected.setStatus(true);
			expected.setStatusCode("Ok");
			expected.setMessage("Record updated");
			
			when(orderDetailsService.updateOrder(orderDetails)).thenReturn(expected);
	        FinalResponse actual = orderDetailsController.getUpdateData(orderDetails);
	        assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Delete order details")
	public void testDeleteCustomerController() {
		OrderDetails orderDetails = new OrderDetails();
	    orderDetails.setOrderDetailsId(2);
		    
		 FinalResponse expected = new FinalResponse();
		 expected.setStatus(true);
		 expected.setStatusCode("Ok");
		 expected.setMessage("One Record deleted");
		 
		 when(orderDetailsService.deleteOrderById(anyInt())).thenReturn(expected);
	        FinalResponse actual = orderDetailsController.getDeleteId(anyInt());
	        assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Find orderdetails by id")
	public void testGetByIdOrderDetailsController() {

		 Object[] orderdetails = {2,3,7};
		
		 FinalResponse expected = new FinalResponse();
		 expected.setStatus(true);
		 expected.setStatusCode("Ok");
		 expected.setMessage("One Record show");
		 expected.setData(orderdetails);
		 
		 when(orderDetailsService.orderViewById(anyInt())).thenReturn(expected);
	        FinalResponse actual = orderDetailsController.getOrderDetails(anyInt());
	        assertEquals(expected, actual);
	}
	

	@Test
	@DisplayName("Find all orderdetails")
	public void testGetAllOrderDetailsController() {
		
		List<Object[]> orderdetails = new ArrayList<>();
		Object[] orderdetails1 = {2,3,7};
		Object[] orderdetails2 = {4,1,2};
		 
		 orderdetails.add(orderdetails1);
		 orderdetails.add(orderdetails2);
		 
		 FinalResponse expected = new FinalResponse();
		 expected.setStatus(true);
		 expected.setStatusCode("Ok");
		 expected.setMessage("all Records show");
		 expected.setData(orderdetails);
		 
		 when(orderDetailsService.viewAllOrder()).thenReturn(expected);
	        FinalResponse actual = orderDetailsController.allOrderdetails();
	        assertEquals(expected, actual);
	}

}
