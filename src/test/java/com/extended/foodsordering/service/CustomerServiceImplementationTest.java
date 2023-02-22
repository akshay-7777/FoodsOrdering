package com.extended.foodsordering.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.sql.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.extended.foodsordering.bean.Customer;
import com.extended.foodsordering.bean.FinalResponse;
import com.extended.foodsordering.repository.CustomerRepositoryImplementation;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest{

	@InjectMocks
	private CustomerServiceImplementation customerServiceImplementation;
	
	@Mock
	private CustomerRepositoryImplementation customerRepository;
	
	/*@Test
	@DisplayName("Save customer test cases")
	void testInsertCustomerService() {
		 Customer customer = new Customer();
		    customer.setCustomerName("Vaibhav");
			customer.setCity("Nagpur");
			customer.setAddress("Ambajhari");
			customer.setCustomerMobileNumber("7689678989");
			Date date = new Date(2022-12-20);
			customer.setCreatedDate(date);
			customer.setUpdatedDate(null);
			
			FinalResponse expected = new FinalResponse();
			expected.setStatus(HttpStatus.OK);
			expected.setStatusCode("200");
			expected.setMessage("One Record Inserted");
			
			when(customerRepository.save(any(Customer.class))).thenReturn(customer);
	        FinalResponse actual = customerServiceImplementation.getInsertData(customer);
	        assertEquals(expected, actual);
	}*/
	/*@Test
	@DisplayName("Save the customer object to databse")
	public void testInsertCustomerService() {
		 Customer customer = new Customer();
		 customer.setCustomer_Name("Vaibhav");
			customer.setCity("Nagpur");
			customer.setAddress("Ambajhari");
			customer.setCustomer_mobile_number("7689678989");
			Date date = new Date(2022-12-20);
			customer.setCreated_date(date);
			customer.setUpdated_date(null);
			
			when(customerRepository.save(any(Customer.class))).thenReturn(customer);
			FinalResponse newcustomer = customerServiceImplementation.getInsertData(customer);
			
			assertEquals(customer, newcustomer);
	}

	@Test
	@DisplayName("Find all the customer object from databse")
	public void testFindAllCustomerService() {
		 Customer customer1 = new Customer();
		 customer1.setCustomer_Name("Akshu");
			customer1.setCity("Nagpur");
			customer1.setAddress("Narkher");
			customer1.setCustomer_mobile_number("9867546745");
			Date date1 = new Date(2022-12-20);
			customer1.setCreated_date(date1);
			customer1.setUpdated_date(null);
			
			 Customer customer2 = new Customer();
			 customer2.setCustomer_Name("Mayur");
				customer2.setCity("Nagpur");
				customer2.setAddress("Katol");
				customer2.setCustomer_mobile_number("8967896789");
				Date date2 = new Date(2022-12-15);
				customer2.setCreated_date(date2);
				customer2.setUpdated_date(null);
				
				List<Customer> customers = new ArrayList<>();
			
			when(customerRepository.findAll()).thenReturn(customers);
			FinalResponse newcustomer = customerServiceImplementation.getAllData();
			
			assertEquals(customers, newcustomer);
	}
	
	@Test
	@DisplayName("update the customer object in databse")
	public void testUpdateCustomerService() {
		 Customer customer = new Customer();
		 customer.setCustomer_Name("Mayank");
			customer.setCity("Nagpur");
			customer.setAddress("Malakapur");
			customer.setCustomer_mobile_number("7689678989");
			Date date = new Date(2022-12-20);
			customer.setCreated_date(date);
			customer.setUpdated_date(null);
			
			when(customerRepository.update(any(Customer.class))).thenReturn(customer);
			
			customer.setCustomer_Name("Prasad");
			
			FinalResponse newcustomer = customerServiceImplementation.getUpdate(customer);
			
			//assertEquals("Prasad", newcustomer.getCustomer_Name());
	}
	
	@Test
	@DisplayName("Delete the customer object to databse")
	public void testDeleteCustomerService() {
		 Customer customer = new Customer();
		 customer.setCustomer_Name("Prasad");
			customer.setCity("Nagpur");
			customer.setAddress("Ambajhari");
			customer.setCustomer_mobile_number("7689678989");
			Date date = new Date(2022-12-20);
			customer.setCreated_date(date);
			customer.setUpdated_date(null);
			
			when(customerRepository.deleteById(anyInt())).thenReturn(customer);
		
			
			customerServiceImplementation.getDelete(2);
			
			verify(customerRepository).deleteById(2);
			
	}*/
}

