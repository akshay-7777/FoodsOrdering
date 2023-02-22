package com.extended.foodsordering.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.extended.foodsordering.bean.Customer;
import com.extended.foodsordering.bean.FinalResponse;
import com.extended.foodsordering.repository.CustomerRepository;

@Service
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImplementation.class);

	@Override
	public FinalResponse saveCustomer(Customer customer) {
		logger.info("saveCustomer:: start Method" + customer);
		FinalResponse finalResponse = new FinalResponse();
		try {
			customerRepository.save(customer);
		} catch (InputMismatchException e) {
			logger.error("saveCustomer" + e.getMessage());
		}
		if (customer != null) {
			finalResponse.setStatus(true);
			finalResponse.setStatusCode("200");
			finalResponse.setMessage("One Record Inserted");
			return finalResponse;
		} else {
			finalResponse.setStatus(false);
			finalResponse.setStatusCode("501");
			finalResponse.setErrorMessages("Record  Not Recorded");
			return finalResponse;
		}

	}

	@Override
	public FinalResponse saveMultipleCustomer(List<Customer> customer) {
		logger.info("SaveMultipleCustomerRecord :: start method" + customer);
		try {
			customerRepository.saveAll(customer);
		} catch (InputMismatchException e) {
			logger.error("saveMultipleCustomer" + e.getMessage());
		}
		FinalResponse finalResponse = new FinalResponse();
		if (customer != null) {
			finalResponse.setStatus(true);
			finalResponse.setStatusCode("Ok");
			finalResponse.setMessage("Records inserted");
			return finalResponse;
		} else {
			finalResponse.setStatus(false);
			finalResponse.setStatusCode("501");
			finalResponse.setErrorMessages("Record  Not Recorded");
			return finalResponse;
		}

	}

	@Override
	public FinalResponse getCustomerById(int id) {
		logger.info("getCustomerById:: start method = " + id);
		Object customer = new Object();
		FinalResponse finalResponse = new FinalResponse();
		
			try {
				customer = customerRepository.findById(id);
			}catch (InputMismatchException e) {
					logger.error("getCustomerById" + e.getMessage());
				}
				if (customer != null) {
				finalResponse.setStatus(true);
				finalResponse.setStatusCode("Ok");
				finalResponse.setMessage("Record present");
				finalResponse.setData(customer);
				return finalResponse;
			}else {
				finalResponse.setStatus(true);
				finalResponse.setStatus(false);
				finalResponse.setStatusCode("501");
				finalResponse.setErrorMessages("Record  Not present");
				return finalResponse;
               }
				}

	@Override
	public FinalResponse getAllCustomer() {
		logger.info("getAllCustomer :: start method" + "Fetch all customer details");
		List<Customer> customers = new ArrayList<>();
		try {
			customers = customerRepository.findAll();
		} catch (InputMismatchException e) {
			logger.error("getAllCustomer" + e.getMessage());
		}
		FinalResponse finalResponse = new FinalResponse();
		if (customers != null) {
			finalResponse.setStatus(true);
			finalResponse.setStatusCode("Ok");
			finalResponse.setMessage("Records present");
			finalResponse.setData(customers);
			return finalResponse;
		} else {
			finalResponse.setStatus(false);
			finalResponse.setStatusCode("501");
			finalResponse.setErrorMessages("Records Not present");
			return finalResponse;
		}

	}

	@Override
	public FinalResponse deleteCustomer(int id) {
		logger.info("deleteCustomer:: start method" + id);
		try {
			customerRepository.deleteById(id);
		} catch (InputMismatchException e) {
			logger.error("deleteCustomer" + e.getMessage());
		}
		FinalResponse finalResponse = new FinalResponse();
		if (id > 0) {
			finalResponse.setStatus(true);
			finalResponse.setStatusCode("Ok");
			finalResponse.setMessage("Record deleted");
			return finalResponse;
		} else {
			finalResponse.setStatus(false);
			finalResponse.setStatusCode("501");
			finalResponse.setMessage("Record  Not deleted");
			finalResponse.setErrorMessages("Check error id ones");
			return finalResponse;
		}
	}

	@Override
	public FinalResponse updateCustomer(Customer customer) {
		logger.info("updateCustomer:: statrt method" + customer);
		try {
			customerRepository.update(customer);
		} catch (InputMismatchException e) {
			logger.error("updateCustomer" + e.getMessage());
		}
		FinalResponse finalResponse = new FinalResponse();
		if (customer != null) {
			finalResponse.setStatus(true);
			finalResponse.setStatusCode("Ok");
			finalResponse.setMessage("Record updated");
			return finalResponse;
		} else {
			finalResponse.setStatus(false);
			finalResponse.setStatusCode("501");
			finalResponse.setMessage("Record  Not updated");
			finalResponse.setErrorMessages("Check error id ones");
			return finalResponse;
		}
	}
}
