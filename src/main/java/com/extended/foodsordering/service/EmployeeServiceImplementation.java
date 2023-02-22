package com.extended.foodsordering.service;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.extended.foodsordering.bean.Employee;
import com.extended.foodsordering.bean.FinalResponse;
import com.extended.foodsordering.jwttoken.JWTTokenUtil;
import com.extended.foodsordering.repository.EmployeeRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;

    @Autowired
    private JWTTokenUtil jwtTokenUtil;
    
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImplementation.class);
	
	@Override
	public FinalResponse getInsertEmployee(Employee employee) {
		logger.info("getInsertEmployee:: start method" + employee);
        try {
        	employeeRepository.saveEmployee(employee);
        } catch (InputMismatchException e) {
            logger.error("getInsertEmployee" + e.getMessage());
        }
		FinalResponse finalResponse = new FinalResponse();
		if (employee != null) {
            finalResponse.setStatus(true);
            finalResponse.setStatusCode("200");
            finalResponse.setMessage("One Record Inserted");
            return finalResponse;
        }else {
            finalResponse.setStatus(false);
            finalResponse.setStatusCode("501");
            finalResponse.setErrorMessages("Record  Not Recorded");
            return finalResponse;
            
        }
	    
	}

	@Override
	public FinalResponse getInsertMultipleEmployee(List<Employee> employee) {
		logger.info("getInsertMultipleEmployee :: start method" + employee);
        try {
        	employeeRepository.saveAllEmployee(employee);
        } catch (InputMismatchException e) {
            logger.error("getInsertMultipleEmployee" + e.getMessage());
        }
		FinalResponse finalResponse = new FinalResponse();
		if (employee != null) {
            finalResponse.setStatus(true);
            finalResponse.setStatusCode("200");
            finalResponse.setMessage("Records Inserted");
            return finalResponse;
        }else {
            finalResponse.setStatus(false);
            finalResponse.setStatusCode("501");
            finalResponse.setErrorMessages("Records  Not Recorded");
            return finalResponse;
            
        }
	}

	@Override
	public FinalResponse getEmployeeById(int id) {
		 logger.info("getEmployeeById::start method" + id);
		   FinalResponse finalResponse = new FinalResponse();   
	        try {
	        	List<Object[]> employee = employeeRepository.findEmployeeById(id);
	        	 LinkedHashMap<String, String> employees = new LinkedHashMap<>();
                 for (Object[] employeeDetails : employee) {
                	 employees.put("Employee_Id", String.valueOf(employeeDetails[0])); 
                	 employees.put("Employee_FirstName", String.valueOf(employeeDetails[1]));  
                	 employees.put("Employee_LastName", String.valueOf(employeeDetails[2]));  
                	 employees.put("Employee_Age", String.valueOf(employeeDetails[3]));  
                	 employees.put("Employee_MobileNumber", String.valueOf(employeeDetails[4]));  
                	 employees.put("Creatde-Date", String.valueOf(employeeDetails[5]));  
                	 employees.put("Updated_Date", String.valueOf(employeeDetails[6]));  
                 }
                 finalResponse.setStatus(true);
 	            finalResponse.setStatusCode("200");
 	            finalResponse.setMessage("Record present");
 	            finalResponse.setData(employees);
 	            return finalResponse;
	        } catch (InputMismatchException e) {
	            logger.error("getEmployeeById::input::employee:" + e.getMessage());
	        }
	        	finalResponse.setStatus(false);
	            finalResponse.setStatusCode("501");
	            finalResponse.setErrorMessages("Record  Not present");
	            return finalResponse;	
	}

	@Override
	public FinalResponse getAllEmployee() {
		 logger.info("getAllEmployee :: start method" + "Fetch all employee details");
			FinalResponse finalResponse = new FinalResponse();
		try {
			List<Object[]> employeeDetails = employeeRepository.findAllEmployee();
			List<Object> employeeInfo = new ArrayList<>();
			for(int i =0;i<employeeDetails.size();i++) {
				Object [] employeeDetail = employeeDetails.get(i);
				Employee employee = new Employee();
				String employeeId = String.valueOf(employeeDetail[0]);
				Integer id = Integer.valueOf(employeeId);
				employee.setEmployeeId(id);
				employee.setFirstName(String.valueOf(employeeDetail[1]));
				employee.setLastName(String.valueOf(employeeDetail[2]));
				String employeeAge = String.valueOf(employeeDetail[3]);
				Integer age = Integer.valueOf(employeeAge);
				employee.setAge(age);
				employee.setEmployeeNumber(String.valueOf(employeeDetail[4]));
				employee.setCreatdeDate(null);
				employee.setUpdateDate(null);
				employee.setUserName(String.valueOf(employeeDetail[7]));
				employee.setPassWord(String.valueOf(employeeDetail[8]));
				employeeInfo.add(i, employee);
             }
             finalResponse.setStatus(true);
             finalResponse.setStatusCode("200");
             finalResponse.setMessage("Records present");
             finalResponse.setData(employeeInfo);
             return finalResponse;
             }catch (InputMismatchException e) {
           logger.error("getAllEmployee" + e.getMessage());
       }

        	finalResponse.setStatus(false);
            finalResponse.setStatusCode("501");
            finalResponse.setErrorMessages("Records Not present");
            return finalResponse;
        
	}

	@Override
	public FinalResponse getDeleteEmployee(int id) {
		logger.info("getDeleteEmployee::start method" + id);
        try {
        	employeeRepository.deleteEmployeeById(id);
        } catch (InputMismatchException e) {
            logger.error("getUpdateEmployee" + e.getMessage());
        }
		FinalResponse finalResponse = new FinalResponse();
		 if (id > 0) {
			 finalResponse.setStatus(true);
	            finalResponse.setStatusCode("200");
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
	public FinalResponse getUpdateEmployee(Employee employee) {
		logger.info("getUpdateEmployee::start method" + employee);
        try {
        	employeeRepository.updateEmployee(employee);
        } catch (InputMismatchException e) {
            logger.error("getUpdateEmployee" + e.getMessage());
        }
		
		FinalResponse finalResponse = new FinalResponse();
		   if (employee != null) {
			   finalResponse.setStatus(true);
	            finalResponse.setStatusCode("200");
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
	
	public FinalResponse getEmployeeLogin(Employee employee) {
		logger.info("getEmployeeLogin::start method" + employee);
		  FinalResponse finalResponse = new FinalResponse();
		  Object loginInfo = employeeRepository.loginEmployee(employee.getUserName(), employee.getPassWord());
		  if(loginInfo!=null) {
			  finalResponse.setStatus(true);
	            finalResponse.setStatusCode("200");
	            finalResponse.setMessage("Record updated");
	            Object jwttoken = jwtTokenUtil.generateToken(employee);
              finalResponse.setData(jwttoken);
              return finalResponse;	
		  }else {
			  finalResponse.setStatus(false);
		        finalResponse.setStatusCode("404");
		        finalResponse.setErrorMessages("Wrong username or password");
		        return finalResponse;
		  }
	}

	@Override
	public FinalResponse getValidatingToken(String Token, Employee employee) {
		logger.info("getValidatingToken::start method" + employee);
		FinalResponse finalResponse = new FinalResponse();
        String token = Token.substring(7, Token.length());
        if (token != null) {
            try {
                boolean value = jwtTokenUtil.validateToken(token, employee);
                System.out.println(value);
                if (value == true) {
                    finalResponse.setStatus(true);
                    finalResponse.setStatusCode("200");
                    finalResponse.setMessage("token is valid");
                    return finalResponse;
                }
            } catch (Exception ex) {
                System.out.println("Token Is Invalid");
            }
        }
        finalResponse.setStatus(false);
        finalResponse.setStatusCode("500");
        finalResponse.setMessage("Token is Invalid");
        return finalResponse;
	}
	
	 final private String sid="AC3c62d5f36a8743d5d1e997d9cb8bdfed";
	    final private String auth="6f5770cb4a3da6e3fffc41c04964fd5f";
	  //  final private String number="+14097976131";
	    
	
	@Override
	 public FinalResponse employeeLoginByUserName(String userName, String passWord){
        logger.info("employeeLoginByUserName start method :: " );
        FinalResponse finalResponse = new FinalResponse();
        String passwordAuthentication = employeeRepository.checkUserIsPerentByUsername(userName);
        if (passwordAuthentication != null) {
            if (passwordAuthentication.equals(passWord)) {
                try {
                    employeeRepository.loginEmployee(userName, passWord);
                    finalResponse.setStatus(true);
                    finalResponse.setStatusCode("200");
                    finalResponse.setMessage("Login successful");
                    return finalResponse;
                } catch (InputMismatchException ex) {
                    logger.error("userLoginByMobile:: " + ex.getMessage());
                }
            } else {
                Twilio.init(sid, auth);
                Random random = new Random();
                int randomnumber = random.nextInt(1000000);
                if(randomnumber<100000) {
       			 randomnumber+=100000;
       		 }
                String otp = Integer.toString(randomnumber);
                Message.creator(new PhoneNumber("+91 9713483633"), new PhoneNumber("+14097976131"), otp).create();
                Date expireDate = new Date();
                employeeRepository.updateOtp(randomnumber, expireDate, userName);
                finalResponse.setMessage("incorrect password");
                return finalResponse;
            }
        } else {
            finalResponse.setMessage("user does not exists with this mobile number");
            return finalResponse;
        }
        return finalResponse;
    }
	
	@Override
    public FinalResponse verificationotp(int otp, String userName) {
		 logger.info("verificationotp start method :: " +otp);
		long OTP_VALID_DURATION = 1 * 60 * 1000;
        FinalResponse finalResponse = new FinalResponse();
        int otps = employeeRepository.checkotp(userName);
        if (otps != 0) {
        	 Date expireTime = (Date) employeeRepository.getExpireTime(userName);
             long currentTimeInMillis = System.currentTimeMillis();
             long otpRequestedTimeInMillis = expireTime.getTime();
            if (otps == otp) {
            	 if (otpRequestedTimeInMillis + OTP_VALID_DURATION > currentTimeInMillis) {
                 Twilio.init(sid, auth); Message.creator(new PhoneNumber("+91 9713483633"), new PhoneNumber("+14097976131"), " otp verification is done").create();
                 
                employeeRepository.verficationotp(otps, userName);
                finalResponse.setStatus(true);
                finalResponse.setStatusCode("200");
                finalResponse.setMessage(" otp verification is done");
                return finalResponse;
            } else {
                finalResponse.setStatus(false);
                finalResponse.setStatusCode("404");
                finalResponse.setMessage("Otp expired");
                return finalResponse;
            }
        }
        finalResponse.setStatus(false);
        finalResponse.setStatusCode("500");
        finalResponse.setMessage("Incorrect OTP");
        return finalResponse;
    }
        finalResponse.setStatus(false);
        finalResponse.setStatusCode("404");
        finalResponse.setMessage("user does not exits with this mobileNumber");
        return finalResponse;
    }
	//Verify in email
	@Autowired
	private JavaMailSender javaMailSender;	

	@Override
    public FinalResponse verificationotp(int otp, String userName, String to) {
		 logger.info("verificationotp start method :: " +otp);
        FinalResponse finalResponse = new FinalResponse();
        int otps = employeeRepository.checkotp(userName);
        if (otps != 0) {
            if (otps == otp) {
            	
                 SimpleMailMessage message = new SimpleMailMessage();
                 message.setFrom("akshay.nasree7.com");
                 message.setTo(to);
                 message.setSubject("verfication");
                 message.setText("otp verification is done");
                 javaMailSender.send(message);
                 
                employeeRepository.verficationotp(otps, userName);
                finalResponse.setStatus(true);
                finalResponse.setStatusCode("200");
                finalResponse.setMessage(" otp verification is done");
                return finalResponse;
            } else {
                finalResponse.setStatus(false);
                finalResponse.setStatusCode("500");
                finalResponse.setMessage(" incorrect Otp");
                return finalResponse;
            }
        }
        finalResponse.setStatus(false);
        finalResponse.setStatusCode("404");
        finalResponse.setMessage("user does not exits with this mobileNumber");
        return finalResponse;
    }
	}
