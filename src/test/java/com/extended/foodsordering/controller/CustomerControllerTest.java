package com.extended.foodsordering.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.extended.foodsordering.bean.Customer;
import com.extended.foodsordering.bean.FinalResponse;
import com.extended.foodsordering.service.CustomerService;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

	@Mock
	private CustomerService customerService;
	
	@InjectMocks
	private CustomerController customerController;
	
	@Test
	@DisplayName("Save the customer")
	void testInsertCustomerController() {
		    Customer customer = new Customer();
		    customer.setCustomerName("Vaibhav");
			customer.setCity("Nagpur");
			customer.setAddress("Ambajhari");
			customer.setCustomerMobileNumber("7689678989");
			Date date = new Date(2022-12-20);
			customer.setCreatedDate(date);
			customer.setUpdatedDate(null);
			
			FinalResponse expected = new FinalResponse();
			expected.setStatus(true);
			expected.setStatusCode("200");
			expected.setMessage("One Record Inserted");
			
			when(customerService.saveCustomer(any(Customer.class))).thenReturn(expected);
	        FinalResponse actual = customerController.getInsertCustomerInfo(customer);
	        assertEquals(expected, actual);

	}

	@Test
	@DisplayName("Save multiple customer")
	public void testMultipleInsertCustomerController() {
		 List<Customer> customers = new ArrayList<>();
		 Customer customer1 = new Customer();
		 customer1.setCustomerName("Mayur");
			customer1.setCity("Nagpur");
			customer1.setAddress("Malakapur");
			customer1.setCustomerMobileNumber("8967897681");
			Date date1 = new Date(2022-12-25);
			customer1.setCreatedDate(date1);
			customer1.setUpdatedDate(null);
			
			 Customer customer2 = new Customer();
			 customer2.setCustomerName("Prasad");
				customer2.setCity("Nagpur");
				customer2.setAddress("Katol");
				customer2.setCustomerMobileNumber("7689678989");
				Date date2 = new Date(2022-12-15);
				customer2.setCreatedDate(date2);
				customer2.setUpdatedDate(null);
				
				customers.add(customer1);	
			    customers.add(customer2);
			    
				FinalResponse expected = new FinalResponse();
				expected.setStatus(true);
				expected.setStatusCode("Ok");
				expected.setMessage("Records inserted");
	            
				when(customerService.saveMultipleCustomer(customers)).thenReturn(expected);
		        FinalResponse actual = customerController.getInsertMultipleCustomerInfo(customers);
		        assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("update the customer")
	public void testUpdateCustomerController() {
		    Customer customer = new Customer();
		    customer.setCustomerName("Akshay");
		    customer.setCustomerId(2);

			FinalResponse expected = new FinalResponse();
			expected.setStatus(true);
			expected.setStatusCode("Ok");
			expected.setMessage("Record updated");
			
			when(customerService.updateCustomer(customer)).thenReturn(expected);
			FinalResponse actual = customerController.getUpdateData(customer);
			assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Delete the customer")
	public void testDeleteCustomerController() {
		 Customer customer = new Customer();
		 customer.setCustomerId(3);
		    
		 FinalResponse expected = new FinalResponse();
		 expected.setStatus(true);
		 expected.setStatusCode("Ok");
		 expected.setMessage("Record deleted");
		 
		 when(customerService.deleteCustomer(anyInt())).thenReturn(expected);
			FinalResponse actual = customerController.getDeleteId(anyInt());
			assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Find customer by id")
	public void testGetByIdCustomerController() {

		 Object[] customer = {"Prasad","Nagpur","Katol","7689687989",null,null};
		
		 FinalResponse expected = new FinalResponse();
		 expected.setStatus(true);
		 expected.setStatusCode("Ok");
		 expected.setMessage("Record present");
		 expected.setData(customer);
		 
		 when(customerService.getCustomerById(anyInt())).thenReturn(expected);
		 FinalResponse actual = customerController.getOneData(anyInt());
		 assertEquals(expected, actual);
	}
	

	@Test
	@DisplayName("Find all customer")
	public void testGetAllCustomerController() {
		
		List<Object[]> customer= new ArrayList<>();
		 Object[] customer1 = {"Prasad","Nagpur","Katol","7689687989",null,null};
		 Object[] customer2= {"Vaibhav","Nagpur","Malkapur","7609876595",null,null};
		 
		 customer.add(customer1);
		 customer.add(customer2);
		 
		 FinalResponse expected = new FinalResponse();
		 expected.setStatus(true);
		 expected.setStatusCode("Ok");
		 expected.setMessage("Records present");
		 expected.setData(customer);
		 
		 when(customerService.getAllCustomer()).thenReturn(expected);
		 FinalResponse actual = customerController.getAllCustomerdetails();
		 assertEquals(expected, actual);
	}
}
