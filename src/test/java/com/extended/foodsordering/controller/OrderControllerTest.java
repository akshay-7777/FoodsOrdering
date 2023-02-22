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
import com.extended.foodsordering.bean.Order;
import com.extended.foodsordering.service.OrderService;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

	@InjectMocks
	private OrderController orderController;
	
	@Mock
	private OrderService orderService;
	
	@Test
	@DisplayName("Test case for Placed Order")
	void testPlacedOrderController() {
		Order order = new Order();
		order.setCustomerId(2);
		order.setEmployeeId(5);
		Date date = new Date(2022-12-20);
		order.setOrderDate(date);
		
		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("Order placed");
		
		when(orderService.placeOrder(any(Order.class))).thenReturn(expected);
        FinalResponse actual = orderController.getOrderInfo(order);
        assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("update the order")
	public void testUpdateOrderController() {
		Order order = new Order();
		order.setCustomerId(2);
		order.setOrderId(1);
		
		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("Order updated");
		
		when(orderService.updateOrder(order)).thenReturn(expected);
		FinalResponse actual = orderController.getUpdateOrder(order);
		
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("delete the order")
	public void testDeleteOrderController() {
		Order order = new Order();
		order.setOrderId(1);;
		
		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("Order deleted");
		
		when(orderService.deleteOrder(anyInt())).thenReturn(expected);
		FinalResponse actual = orderController.getDeleteOrder(anyInt());
		
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Find all orders")
	public void testGetAllOrderController() {
		
		List<Object[]> orders = new ArrayList<>();
		 Object[] order1 = {2,5,null};
		 Object[] order2 = {3,8,null};
		 
		 orders.add(order1);
		 orders.add(order2);
		 
		 FinalResponse expected = new FinalResponse();
		 expected.setStatus(true);
		 expected.setStatusCode("Ok");
		 expected.setMessage("Records present");
		 expected.setData(orders);
		 
		 when(orderService.getAllOrder()).thenReturn(expected);
		 FinalResponse actual = orderController.getAllOrderdetails();
		 assertEquals(expected, actual);
	}

}
