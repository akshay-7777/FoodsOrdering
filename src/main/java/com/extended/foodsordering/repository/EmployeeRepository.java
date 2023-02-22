package com.extended.foodsordering.repository;

import java.util.*;

import com.extended.foodsordering.bean.Employee;
public interface EmployeeRepository {

	public Employee saveEmployee(Employee employee);
	public List<Employee> saveAllEmployee(List<Employee> employee);
	public List<Object[]> findAllEmployee();
	public List<Object[]> findEmployeeById(int id);
	public Employee deleteEmployeeById(int id);
	public Employee updateEmployee(Employee employee);
	public Object loginEmployee(String username, String passWord);
	
	public List<Object> checkPassword();
	public List<Object> checkusername();
	
	public String checkUserIsPerentByUsername(String userName); 
	public String updateOtp(int otp, Date expireDate, String userName);
	public int checkotp(String userName);
	public String verficationotp(int otp, String userName);
	public Object getExpireTime(String userName);
}
