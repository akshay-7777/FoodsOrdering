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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.extended.foodsordering.bean.Customer;
import com.extended.foodsordering.bean.FinalResponse;
import com.extended.foodsordering.controller.CustomerController;
import com.extended.foodsordering.service.CustomerService;

import jakarta.persistence.EntityManager;

@ExtendWith(MockitoExtension.class)
class CustomerRepositoryImplementationTest {

	@Mock
	private CustomerRepositoryImplementation customerRepositoryImplementation;
	
	@Test
	@DisplayName("Save the customer")
	void testSaveCustomerRepository() {
		    Customer customer = new Customer();
		    customer.setCustomerName("Vaibhav");
			customer.setCity("Nagpur");
			customer.setAddress("Ambajhari");
			customer.setCustomerMobileNumber("7689678989");
			Date date = new Date(2022-12-20);
			customer.setCreatedDate(date);
			customer.setUpdatedDate(null);

			when(customerRepositoryImplementation.save(customer)).thenReturn(customer);
	        Customer actual = customerRepositoryImplementation.save(customer);
	        assertNotNull(actual);

	}

	@Test
	@DisplayName("Save multiple customer")
	public void testSaveAllCustomerRepository() {
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

			    when(customerRepositoryImplementation.saveAll(customers)).thenReturn(customers);
		        List<Customer> actual = customerRepositoryImplementation.saveAll(customers);
		        assertNotNull(actual);
	}
	
	@Test
	@DisplayName("update the customer")
	public void testUpdateCustomerRepository() {
		    Customer customer = new Customer();
		    customer.setCustomerName("Akshay");
		    customer.setCustomerId(2);
			
			when(customerRepositoryImplementation.update(customer)).thenReturn(customer);
			Customer actual = customerRepositoryImplementation.update(customer);
			assertNotNull(actual);
	}
	
	@Test
	@DisplayName("Delete the customer")
	public void testDeleteCustomerRepository() {
		 Customer customer = new Customer();
		 customer.setCustomerId(3);
		 
		    when(customerRepositoryImplementation.deleteById(anyInt())).thenReturn(customer);
			Customer actual = customerRepositoryImplementation.deleteById(anyInt());
			assertNotNull(actual);
	}

	@Test
	@DisplayName("Find customer by id")
	public void testGetByIdCustomeeRepository() {

		 Object[] customer = {"Prasad","Nagpur","Katol","7689687989",null,null};
		
		 FinalResponse expected = new FinalResponse();
		 expected.setStatus(true);
		 expected.setStatusCode("Ok");
		 expected.setMessage("Record present");
		 expected.setData(customer);
		 
		 when(customerRepositoryImplementation.findById(anyInt())).thenReturn(customer);
		 Object actual = customerRepositoryImplementation.findById(anyInt());
		 assertNotNull(actual);
	}
	

	@Test
	@DisplayName("Find all customer")
	public void testGetAllCustomerRepository() {
		
		List<Object[]> customer= new ArrayList<>();
		 Object[] customer1 = {"Prasad","Nagpur","Katol","7689687989",null,null};
		 Object[] customer2= {"Vaibhav","Nagpur","Malkapur","7609876595",null,null};
		 
		 customer.add(customer1);
		 customer.add(customer2);
		 
		 when(customerRepositoryImplementation.findAll()).thenReturn(null);
		 List<Customer> actual = customerRepositoryImplementation.findAll();
		 assertNull(actual);
	}

}
