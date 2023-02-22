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
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.extended.foodsordering.bean.Employee;

@ExtendWith(MockitoExtension.class)
class EmployeeRepositoryImplementationTest {

	@Mock
	private EmployeeRepositoryImplementation employeeRepositoryImplementation;
	
	@Test
	@DisplayName("Save the employee")
	void testInsertEmployeeRepository() {
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
			
			when(employeeRepositoryImplementation.saveEmployee(any(Employee.class))).thenReturn(employee);
	        Employee actual = employeeRepositoryImplementation.saveEmployee(employee);
	        assertNotNull(actual);

	}

	@Test
	@DisplayName("Save multiple employee")
	public void testMultipleInsertEmployeeRepository() {
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
			    
		    when(employeeRepositoryImplementation.saveAllEmployee(employees)).thenReturn(employees);
	        List<Employee> actual = employeeRepositoryImplementation.saveAllEmployee(employees);
	        assertNotNull(actual);
	}
	
	@Test
	@DisplayName("update the employee")
	public void testUpdateEmployeeRepository() {
		    Employee employee = new Employee();
		    employee.setFirstName("Rajesh");
		    employee.setEmployeeId(2);

		    when(employeeRepositoryImplementation.updateEmployee(employee)).thenReturn(employee);
	        Employee actual = employeeRepositoryImplementation.updateEmployee(employee);
	        assertNotNull(actual);
	}
	
	@Test
	@DisplayName("Delete the employee")
	public void testDeleteEmployeeRepository() {
		Employee employee = new Employee();
	    employee.setEmployeeId(2);
		    
	    when(employeeRepositoryImplementation.deleteEmployeeById(anyInt())).thenReturn(employee);
        Employee actual = employeeRepositoryImplementation.deleteEmployeeById(anyInt());
        assertNotNull(actual);
	}

	/*@Test
	@DisplayName("Find employee by id")
	public void testGetByIdEmployeeRepository() {

		 Object[] employee = {"Rajesh","Thakre",29,"7689687989",null,null,"rajesh_tahkre","Rajesh@77"};
		
		 when(employeeRepositoryImplementation.findEmployeeById(anyInt())).then(null);
	        List<Object[]> actual = employeeRepositoryImplementation.findEmployeeById(anyInt());
	        assertNull(actual);
	}*/
	

	@Test
	@DisplayName("Find all employee")
	public void testGetAllEmployeeRepository() {
		
		List<Object[]> employees = new ArrayList<>();
		 Object[] employee1 = {"Rajesh","Thakre",29,"7689687989",null,null,"rajesh_tahkre","Rajesh@77"};
		 Object[] employee2 = {"Ramesh","Walke",33,"237783278",null,null,"ramesh_walke","Ramesh@33"};
		 
		 employees.add(employee1);
		 employees.add(employee2);
		 
		 when(employeeRepositoryImplementation.findAllEmployee()).thenReturn(employees);
	        List<Object[]> actual = employeeRepositoryImplementation.findAllEmployee();
	        assertNotNull(actual);
	}

	@Test
	@DisplayName("Login employee")
	void testLoginEmployeeRepository() {
		 Object[] employee = {"Rajesh","Thakre",29,"7689687989",null,null};
			
			when(employeeRepositoryImplementation.loginEmployee("rajesh_t", "Rajesh@77")).thenReturn(employee);
	        Object actual = employeeRepositoryImplementation.loginEmployee("rajesh_t", "Rajesh@77");
	        assertNotNull(actual);

	}
}
