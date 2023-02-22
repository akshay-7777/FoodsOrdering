package com.extended.foodsordering.controller;

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
import com.extended.foodsordering.bean.Employee;
import com.extended.foodsordering.bean.FinalResponse;
import com.extended.foodsordering.service.CustomerService;
import com.extended.foodsordering.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

	@Mock
	private EmployeeService employeeService;
	
	@InjectMocks
	private EmployeeController employeeController;
	
	@Test
	@DisplayName("Save the employee")
	void testInsertEmployeeController() {
		    Employee employee = new Employee();
		    employee.setFirstName("Rajesh");
		    employee.setLastName("Thakre");
		    employee.setAge(27);
		    employee.setEmployeeNumber("6879678989");
		    Date date = new Date(2022-12-10);
		    employee.setCreatdeDate(date);
		    employee.setUpdateDate(date);
		    employee.setUserName("rajesh_t");
		    employee.setPassWord("Rajesh@77");
			
			FinalResponse expected = new FinalResponse();
			expected.setStatus(true);
			expected.setStatusCode("200");
			expected.setMessage("One Record Inserted");
			
			when(employeeService.getInsertEmployee(any(Employee.class))).thenReturn(expected);
	        FinalResponse actual = employeeController.getSaveEmployeeinfo(employee);
	        assertEquals(expected, actual);

	}

	@Test
	@DisplayName("Save multiple employee")
	public void testMultipleInsertEmployeeController() {
		 List<Employee> employees = new ArrayList<>();
		    Employee employee1 = new Employee();
		    employee1.setFirstName("Rajesh");
		    employee1.setLastName("Thakre");
		    employee1.setAge(27);
		    employee1.setEmployeeNumber("6879678989");
		    Date date1 = new Date(2022-12-10);
		    employee1.setCreatdeDate(date1);
		    employee1.setUpdateDate(null);
		    employee1.setUserName("rajesh_t");
		    employee1.setPassWord("Rajesh@77");
			
		    Employee employee2 = new Employee();
		    employee2.setFirstName("Rajesh");
		    employee2.setLastName("Thakre");
		    employee2.setAge(27);
		    employee2.setEmployeeNumber("6879678989");
		    Date date2 = new Date(2022-12-10);
		    employee2.setCreatdeDate(date2);
		    employee2.setUpdateDate(null);
		    employee2.setUserName("rajesh_t");
		    employee2.setPassWord("Rajesh@77");
				
		    employees.add(employee1);	
		    employees.add(employee2);
			    
				FinalResponse expected = new FinalResponse();
				expected.setStatus(true);
				expected.setStatusCode("Ok");
				expected.setMessage("Records inserted");
	            
				when(employeeService.getInsertMultipleEmployee(employees)).thenReturn(expected);
		        FinalResponse actual = employeeController.getSaveMultipleEmployeeInfo(employees);
		        assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("update the customer")
	public void testUpdateEmployeeController() {
		    Employee employee = new Employee();
		    employee.setFirstName("Rajesh");
		    employee.setEmployeeId(2);

			FinalResponse expected = new FinalResponse();
			expected.setStatus(true);
			expected.setStatusCode("Ok");
			expected.setMessage("Record updated");
			
			when(employeeService.getUpdateEmployee(employee)).thenReturn(expected);
	        FinalResponse actual = employeeController.getUpdateEmployee(employee);
	        assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Delete the employee")
	public void testDeleteEmployeeController() {
		Employee employee = new Employee();
	    employee.setEmployeeId(2);
		    
		 FinalResponse expected = new FinalResponse();
		 expected.setStatus(true);
		 expected.setStatusCode("Ok");
		 expected.setMessage("Record deleted");
		 
		 when(employeeService.getDeleteEmployee(anyInt())).thenReturn(expected);
	        FinalResponse actual = employeeController.getDeleteEmployee(anyInt());
	        assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Find employee by id")
	public void testGetByIdEmployeeController() {

		 Object[] employee = {"Rajesh","Thakre",29,"7689687989",null,null,"rajesh_tahkre","Rajesh@77"};
		
		 FinalResponse expected = new FinalResponse();
		 expected.setStatus(true);
		 expected.setStatusCode("Ok");
		 expected.setMessage("Record present");
		 expected.setData(employee);
		 
		 when(employeeService.getEmployeeById(anyInt())).thenReturn(expected);
	        FinalResponse actual = employeeController.getEmployeeById(anyInt());
	        assertEquals(expected, actual);
	}
	

	@Test
	@DisplayName("Find all employee")
	public void testGetAllEmployeeController() {
		
		List<Object[]> employees = new ArrayList<>();
		 Object[] employee1 = {"Rajesh","Thakre",29,"7689687989",null,null,"rajesh_tahkre","Rajesh@77"};
		 Object[] employee2 = {"Ramesh","Walke",33,"237783278",null,null,"ramesh_walke","Ramesh@33"};
		 
		 employees.add(employee1);
		 employees.add(employee2);
		 
		 FinalResponse expected = new FinalResponse();
		 expected.setStatus(true);
		 expected.setStatusCode("Ok");
		 expected.setMessage("Records present");
		 expected.setData(employees);
		 
		 when(employeeService.getAllEmployee()).thenReturn(expected);
	        FinalResponse actual = employeeController.getAllEmployeeDetails();
	        assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Login employee")
	public void testGetLoginEmployeeController() {
		
		    Employee employee = new Employee();
		    employee.setFirstName("Rajesh");
		    employee.setLastName("Thakre");
		    employee.setAge(27);
		    employee.setEmployeeNumber("6879678989");
		    Date date = new Date(2022-12-10);
		    employee.setCreatdeDate(date);
		    employee.setUpdateDate(date);
			
			FinalResponse expected = new FinalResponse();
			expected.setStatus(true);
			expected.setStatusCode("200");
			expected.setMessage("Employee Login Is Successfully..");
			
			when(employeeService.getEmployeeLogin(employee)).thenReturn(expected);
	        FinalResponse actual = employeeController.getLoginEmployee(employee);
	        assertEquals(expected, actual);

	}
}
