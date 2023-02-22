package com.extended.foodsordering.repository;

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
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.extended.foodsordering.bean.Order;


@ExtendWith(MockitoExtension.class)
class OrderRepositoryImplementationTest {

	@Mock
	private OrderRepositoryImplementation orderRepositoryImplementation;
	
	@Test
	@DisplayName("Test case for Placed Order")
	void testPlacedOrderRepository() {
		Order order = new Order();
		order.setCustomerId(2);
		order.setEmployeeId(5);
		Date date = new Date(2022-12-20);
		order.setOrderDate(date);
		
		when(orderRepositoryImplementation.saveOrder(any(Order.class))).thenReturn(order);
        Order actual = orderRepositoryImplementation.saveOrder(order);
        assertNotNull(actual);
	}
	
	@Test
	@DisplayName("update the order")
	public void testUpdateOrderRepository() {
		Order order = new Order();
		order.setCustomerId(2);
		order.setOrderId(1);
		
		when(orderRepositoryImplementation.updateOrder(order)).thenReturn(order);
        Order actual = orderRepositoryImplementation.updateOrder(order);
        assertNotNull(actual);
	}
	
	@Test
	@DisplayName("delete the order")
	public void testDeleteOrderRepository() {
		Order order = new Order();
		order.setOrderId(1);;
			
		when(orderRepositoryImplementation.deleteOrder(anyInt())).thenReturn(order);
        Order actual = orderRepositoryImplementation.deleteOrder(anyInt());
        assertNotNull(actual);
	}
	
	@Test
	@DisplayName("Find all orders")
	public void testGetAllOrderRepository() {
		
		List<Object[]> orders = new ArrayList<>();
		 Object[] order1 = {2,5,null};
		 Object[] order2 = {3,8,null};
		 
		 orders.add(order1);
		 orders.add(order2);
		 
		 when(orderRepositoryImplementation.findAllOrder()).thenReturn(null);
	        List<Order> actual = orderRepositoryImplementation.findAllOrder();
	        assertNull(actual);
	}

}
