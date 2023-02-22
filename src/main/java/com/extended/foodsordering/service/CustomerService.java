package com.extended.foodsordering.service;

import java.util.List;

import com.extended.foodsordering.bean.Customer;
import com.extended.foodsordering.bean.FinalResponse;

public interface CustomerService {
	
	public FinalResponse saveCustomer(Customer customer);
    public FinalResponse saveMultipleCustomer(List<Customer> customer);
    public FinalResponse getCustomerById(int id) ;
    public FinalResponse getAllCustomer() ;
    public FinalResponse deleteCustomer(int id);
    public FinalResponse updateCustomer(Customer customer);
	

}
