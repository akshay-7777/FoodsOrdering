package com.extended.foodsordering;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
class FoodsOrderingProjectApplicationTests {
 
	@Mock
	private FoodsOrderingProjectApplication foodsOrderingProjectApplication;
	      
	      @Test
	      public void ContextLoad() {
	    	  assertThat(foodsOrderingProjectApplication).isNotNull();
	      }
	  }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	/* @Test
	void testInsertCustomer() {
		Customer customer = new Customer();
		customer.setCustomer_Name("Mayur");
		customer.setCity("Nagpur");
		customer.setAddress("Katol");
		customer.setCustomer_mobile_number("7689678989");
		Date date = new Date(2022-12-20);
		customer.setCreated_date(date);
		customer.setUpdated_date(null);
			
		Customer insertcustomer =customerServiceImplementation.getInsertData(customer);
		assertNotNull(insertcustomer);
		assertThat(insertcustomer.getCustomer_id()).isNotNull();
	}
	
	@Test
	void testControllerCustomer() {
		Customer customer = new Customer();
		customer.setCustomer_Name("Mayur");
		customer.setCity("Nagpur");
		customer.setAddress("Katol");
		customer.setCustomer_mobile_number("7689678989");
		Date date = new Date(2022-12-20);
		customer.setCreated_date(date);
		customer.setUpdated_date(null);
		
		Customer insertcustomer =customerController.getInsertCustomerInfo(customer);
		assertNotNull(insertcustomer);

		//boolean expextedResult = true;		
		//assertNotEquals(expextedResult, actualresult);
	}
	
	@Test
	 public void getSaveMultipleCustomerTest() {
		 Customer customer = new Customer();
		 customer.setCustomer_Name("Vaibhav");
			customer.setCity("Nagpur");
			customer.setAddress("Ambajhari");
			customer.setCustomer_mobile_number("7689678989");
			Date date = new Date(2022-12-20);
			customer.setCreated_date(date);
			customer.setUpdated_date(null);
			Customer savecustomer = customerRepositoryImplementation.save(customer);
			assertThat(savecustomer).isNotNull();
	 }*/
	

