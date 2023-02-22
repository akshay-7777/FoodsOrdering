package com.extended.foodsordering.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.extended.foodsordering.bean.Customer;
import com.extended.foodsordering.bean.FinalResponse;
import com.extended.foodsordering.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/getall")
	public FinalResponse getAllCustomerdetails(){
		return customerService.getAllCustomer();
	}
	
	@PostMapping("/save")
	public FinalResponse getInsertCustomerInfo(@RequestBody @Valid Customer customer){
		return customerService.saveCustomer(customer);
	}
	
	@DeleteMapping("/deletebyid")
	public FinalResponse getDeleteId(@RequestParam ("customerId") int id) {
		return customerService.deleteCustomer(id);
	}
	
	@PutMapping("update")
	public FinalResponse getUpdateData(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}
	
	@GetMapping("/getbyid")
	public FinalResponse getOneData(@RequestParam ("customerId") int id) {
		return customerService.getCustomerById(id);
	}
	
	@PostMapping("/savemultiple")
	public FinalResponse getInsertMultipleCustomerInfo(@RequestBody @Valid List<Customer> customer){
		return customerService.saveMultipleCustomer(customer);
	}
}
