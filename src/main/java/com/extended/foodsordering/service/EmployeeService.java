package com.extended.foodsordering.service;

import java.util.List;

import com.extended.foodsordering.bean.Employee;
import com.extended.foodsordering.bean.FinalResponse;

public interface EmployeeService {

	public FinalResponse getInsertEmployee(Employee employee);
    public FinalResponse getInsertMultipleEmployee(List<Employee> employee);
    public FinalResponse getEmployeeById(int id) ;
    public FinalResponse getAllEmployee() ;
    public FinalResponse getDeleteEmployee(int id);
    public FinalResponse getUpdateEmployee(Employee employee);
    public FinalResponse getEmployeeLogin(Employee employee);
    public FinalResponse getValidatingToken(String Token, Employee employee);
    public FinalResponse employeeLoginByUserName(String userName, String passWord);
    public FinalResponse verificationotp(int otp, String userName);
    public FinalResponse verificationotp(int otp, String userName, String to);
    
}
