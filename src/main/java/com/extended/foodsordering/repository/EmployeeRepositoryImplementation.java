package com.extended.foodsordering.repository;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.extended.foodsordering.bean.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class EmployeeRepositoryImplementation implements EmployeeRepository{

	@Autowired
	private EntityManager entityManager;

	private static final Logger logger = LoggerFactory.getLogger(EmployeeRepositoryImplementation.class);
	
	@Override
	@Transactional
	public Employee saveEmployee(Employee employee) {
		logger.info("saveEmployee :: start method "+employee);
		Query query = entityManager.createNativeQuery("insert into FoodsOrdering.Employee values(?,?,?,?,?,?,?,?,?)");
		query.setParameter(1, employee.getEmployeeId());
		query.setParameter(2, employee.getFirstName());
		query.setParameter(3, employee.getLastName());
		query.setParameter(4, employee.getAge());
		query.setParameter(5, employee.getEmployeeNumber());
		query.setParameter(6, employee.getCreatdeDate());
		query.setParameter(7, employee.getUpdateDate());
		query.setParameter(8, employee.getUserName());
		query.setParameter(9, employee.getPassWord());
		try {
			query.executeUpdate();
		}catch(Exception e) {
			logger.info("saveEmployee "+ e.getMessage());
		}
		return employee;
	}

	@Override
	@Transactional
	public List<Employee> saveAllEmployee(List<Employee> employee) {
		logger.info("saveAllEmployee :: start method "+employee);
		for(Employee employees : employee) {
			Query query = entityManager.createNativeQuery("insert into FoodsOrdering.Employee values(?,?,?,?,?,?,?)");
			query.setParameter(1, employees.getEmployeeId());
			query.setParameter(2, employees.getFirstName());
			query.setParameter(3, employees.getLastName());
			query.setParameter(4, employees.getAge());
			query.setParameter(5, employees.getEmployeeNumber());
			query.setParameter(6, employees.getCreatdeDate());
			query.setParameter(7, employees.getUpdateDate());
			query.setParameter(8, employees.getUserName());
			query.setParameter(9, employees.getPassWord());
			try {
				query.executeUpdate();
			}catch(Exception e) {
				logger.info("saveAllEmployee "+ e.getMessage());
			}
		}
		return employee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findAllEmployee() {
		logger.info("findAllEmployee :: start method ");
		Query query = entityManager.createNativeQuery("select * from Employee");
		List<Object[]> employee = null;
        try {
        	employee = query.getResultList();
		}catch(Exception e) {
			logger.info("findAllEmployee "+ e.getMessage());
		}
		return employee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findEmployeeById(int id) {
		logger.info("findEmployeeById :: start method "+id);
		Query query = entityManager.createNativeQuery("select * from Employee where Employee.Employee_id=?");
		query.setParameter(1, id);
		List<Object[]> employee = null;
        try {
        	employee = query.getResultList();
		}catch(Exception e) {
			logger.info("findEmployeeById "+ e.getMessage());
		}
		return employee;
	}

	@Override
	@Transactional
	public Employee deleteEmployeeById(int id) {
		logger.info("deleteEmployeeById :: start method "+id);
		Employee employee = new Employee();
		Query query = entityManager.createNativeQuery("delete from Employee where Employee.Employee_id=?");
		query.setParameter(1, id);
        try {
        	query.executeUpdate();
		}catch(Exception e) {
			logger.info("deleteEmployeeById "+ e.getMessage());
		}
		return employee;
	}

	@Override
	@Transactional
	public Employee updateEmployee(Employee employee) {
		logger.info("updateEmployee :: start method "+employee);
		Query query = entityManager.createNativeQuery
				("update FoodsOrdering.Employee set Employee_Firstname=?, Employee_Lastname=?, Employee_age=?, Employee_number=?, created_date=?, updated_date=?, username=?, password=? where Employee.Employee_id=?");
	
		query.setParameter(1, employee.getFirstName());
		query.setParameter(2, employee.getLastName());
		query.setParameter(3, employee.getAge());
		query.setParameter(4, employee.getEmployeeNumber());
		query.setParameter(5, employee.getCreatdeDate());
		query.setParameter(6, employee.getUpdateDate());
		query.setParameter(7, employee.getUserName());
		query.setParameter(8, employee.getPassWord());
		query.setParameter(9, employee.getEmployeeId());
        try {
			query.executeUpdate();
		}catch(Exception e) {
			logger.info("updateEmployee "+ e.getMessage());
		}
		return employee;
	}
	
	@Override
	public Object loginEmployee(String username, String passWord) {
		logger.info("loginEmployee :: start method ");
		Query query =  entityManager.createNativeQuery("select * from FoodsOrdering.Employee where username=? and password=?");
		query.setParameter(1, username);
		query.setParameter(2, passWord);
		Object employee = null;
		try {
            employee = query.getSingleResult();
        } catch (Exception e) {
        	logger.info("loginEmployee "+ e.getMessage());
        }
        return employee;
	}

	

	
	@Override
	public List<Object> checkPassword() {
		logger.info("checkPassword :: start method ");
		 Query query=entityManager.createNativeQuery("select password from Employee")  ;
	        @SuppressWarnings("unchecked")
			List<Object> passWordDetails = query.getResultList();
	        return passWordDetails;
	}

	@Override
	public List<Object> checkusername() {
		logger.info("checkusername :: start method ");
		 Query query=entityManager.createNativeQuery("select password from Employee")  ;
	        @SuppressWarnings("unchecked")
			List<Object> userNameDetails = query.getResultList();
	        return userNameDetails;
	}
	
	 @Override
	    public String checkUserIsPerentByUsername(String userName) {
		 logger.info("checkUserIsPerentByUsername :: start method "+userName);
	        Query query = entityManager.createNativeQuery("select password from Employee where username=?");
	        query.setParameter(1, userName);
	        String password = null;
	        try {
	            password = (String) query.getSingleResult();
	        } catch (Exception e) {
	        	logger.info("checkUserIsPerentByUsername "+ e.getMessage());
	        }
	        return password;
	    }
	
	 @Override
		@Transactional
		public String updateOtp(int otp, Date expireDate, String userName) {
		 logger.info("updateOtp :: start method "+otp+" "+"expireDate"+" "+userName);
			 Query query = entityManager.createNativeQuery("update FoodsOrdering.Employee set otp=?, expiredate=? where username=?");
			 query.setParameter(1, otp);
			 query.setParameter(2, expireDate);
			 query.setParameter(3, userName);
		        try {
					query.executeUpdate();
				}catch(Exception e) {
					logger.info("updateOtp "+ e.getMessage());
				}
				return "update";
		}
	 
	 @Override
	    public int checkotp(String userName) {
		 logger.info("checkotp :: start method "+userName);
	        Query query = entityManager.createNativeQuery("select otp from Employee where username=?");
	        query.setParameter(1, userName);
	        int otp =0;
	        try {
	         otp = (int) query.getSingleResult();
	        
	        }catch(Exception e) {
	        	logger.info("checkotp "+ e.getMessage());
	        }
	        return otp;
	    }
	    @Override
	    public String verficationotp(int otp, String userName) {
	    	logger.info("verficationotp :: start method "+userName);
	        Query query = entityManager.createNativeQuery("select * from Employee where otp=? and username=?");
	        query.setParameter(1, otp);
	        query.setParameter(2, userName);
	        try {
	            query.getSingleResult();
	        } catch (Exception e) {
	        	logger.info("verficationotp "+ e.getMessage());
	        }
	        return "verification is done";
	    }
	    
	    @Override
	    public Object getExpireTime(String userName) {
	    	logger.info("getExpireTime :: start method "+userName);
	    	Query query = entityManager.createNativeQuery("select expiredate from Employee where userName=?");
	    	query.setParameter(1, userName);
	    	Object expireTime = query.getSingleResult();
	    	return expireTime;
	    }
	    

}
