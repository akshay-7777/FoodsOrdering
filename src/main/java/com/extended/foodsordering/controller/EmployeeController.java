package com.extended.foodsordering.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.extended.foodsordering.bean.Employee;
import com.extended.foodsordering.bean.FinalResponse;
import com.extended.foodsordering.service.EmployeeService;
//import com.extended.foodsordering.utility.EMailSender;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	//@Autowired
	//private EMailSender eMailSender;

	@PostMapping("/save")
	public FinalResponse getSaveEmployeeinfo(@RequestBody @Valid Employee employee) {
	//	eMailSender.sendEmail("akshay.nasree7@gmail.com", "Insert Successful", "Your data is insert into table");
		return employeeService.getInsertEmployee(employee);
	}

	@DeleteMapping("/deletebyid")
	public FinalResponse getDeleteEmployee(@RequestParam("employeeId") int id) {
		return employeeService.getDeleteEmployee(id);
	}

	@PutMapping("update")
	public FinalResponse getUpdateEmployee(@RequestBody Employee employee) {
		return employeeService.getUpdateEmployee(employee);
	}

	@GetMapping("/getbyid")
	public FinalResponse getEmployeeById(@RequestParam("employeeId") int id) {
		return employeeService.getEmployeeById(id);
	}

	@PostMapping("/savemultiple")
	public FinalResponse getSaveMultipleEmployeeInfo(@RequestBody @Valid List<Employee> employee) {
		return employeeService.getInsertMultipleEmployee(employee);
	}

	@RequestMapping("/getall")
	public FinalResponse getAllEmployeeDetails() {
		return employeeService.getAllEmployee();
	}

	@PostMapping("/login")
	public FinalResponse getLoginEmployee(@RequestBody Employee employee) {
		return employeeService.getEmployeeLogin(employee);
	}

	@GetMapping("/checkToken")
	public FinalResponse getCheckToken(@RequestHeader("Authorization") String Token, @RequestBody Employee employee) {
		System.out.println(Token);
		return employeeService.getValidatingToken(Token, employee);
	}

	@GetMapping("/loginbyusername")
	public FinalResponse employeeLoginByUserName(@RequestParam ("username") String userName, @RequestParam("password") String passWord) {
		return employeeService.employeeLoginByUserName(userName, passWord);
	}

	@GetMapping("/verifyotp")
	public FinalResponse verificationOtp1(@RequestParam("otp") int otp, @RequestParam("username") String userName) {
		return employeeService.verificationotp(otp, userName);
	}
	 	
}





