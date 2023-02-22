package com.extended.foodsordering.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
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
class CustomerServiceImplementationTest2 {


	@InjectMocks
	private CustomerServiceImplementation customerServiceImplementation;
	
	@Mock
	private CustomerRepositoryImplementation customerRepositoryImplementation;
	
	@Test
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
			expected.setStatus(true);
			expected.setStatusCode("200");
			expected.setMessage("One Record Inserted");
			
			when(customerRepositoryImplementation.save(any(Customer.class))).thenReturn(customer);
	        FinalResponse actual = customerServiceImplementation.saveCustomer(customer);
	        assertThat(actual).isNotEqualTo(expected);
	}


   /* @Test 
    void getAllPerson(){
        customerServiceImplementation.getAllData();
        verify(customerRepositoryImplementation).findAll();
    }*/
}
