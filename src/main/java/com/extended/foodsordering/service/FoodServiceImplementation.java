package com.extended.foodsordering.service;

import java.util.InputMismatchException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.extended.foodsordering.bean.FinalResponse;
import com.extended.foodsordering.bean.Food;
import com.extended.foodsordering.repository.FoodRepository;

@Service
public class FoodServiceImplementation implements FoodService{

	@Autowired
	private FoodRepository foodRepository;

	private static final Logger logger = LoggerFactory.getLogger(FoodServiceImplementation.class);
	
	@Override
	public FinalResponse insertFood(Food food) {
		logger.info("insertFood :: start method  " + food);
        try {
        	foodRepository.save(food);
        } catch (InputMismatchException e) {
            logger.error("insertFood" + e.getMessage());
        }
		FinalResponse finalResponse = new FinalResponse();
		if(food!=null) {
			finalResponse.setStatus(true);
			finalResponse.setStatusCode("200");
			finalResponse.setMessage("Food insert into table");
			return finalResponse;
		}else {
			finalResponse.setStatus(false);
            finalResponse.setStatusCode("501");
            finalResponse.setErrorMessages("food  Not inserted");
            return finalResponse;
		}
	}

	@Override
	public FinalResponse insertMultipleFood(List<Food> food) {
		logger.info("insertMultipleFood :: start method" + food);
        try {
        	foodRepository.saveAll(food);
        } catch (InputMismatchException e) {
            logger.error("insertMultipleFood " + e.getMessage());
        }
		FinalResponse finalResponse = new FinalResponse();
		if(food!=null) {
			finalResponse.setStatus(true);
			finalResponse.setStatusCode("200");
			finalResponse.setMessage("Food insert into table");
			return finalResponse;
		}else {
			finalResponse.setStatus(false);
            finalResponse.setStatusCode("501");
            finalResponse.setErrorMessages("food  Not inserted");
            return finalResponse;
		}
	}

	@Override
	public FinalResponse getFoodById(int id) {
		logger.info("getFoodById :: start method" + id);
		 Food food = null;
	        try {
	        	food = foodRepository.findById(id);
	        } catch (InputMismatchException e) {
	            logger.error("getFoodById" + e.getMessage());
	        }
		FinalResponse finalResponse = new FinalResponse();
		if(food!=null) {
			finalResponse.setStatus(true);
			finalResponse.setStatusCode("200");
			finalResponse.setMessage("Food present");
			finalResponse.setData(food);
			return finalResponse;
		}else {
			finalResponse.setStatus(false);
            finalResponse.setStatusCode("501");
            finalResponse.setErrorMessages("food  Not present");
            return finalResponse;
		}
	}

	@Override
	public FinalResponse getAllFood() {
		logger.info("getAllFood :: start method");
		List<Food>  food = null;
	        try {
	        	food = foodRepository.findAll();
	        } catch (InputMismatchException e) {
	            logger.error("getAllFood" + e.getMessage());
	        }	
		FinalResponse finalResponse = new FinalResponse();
		if(food!=null) {
			finalResponse.setStatus(true);
			finalResponse.setStatusCode("200");
			finalResponse.setMessage("Foods present");
			finalResponse.setData(food);
			return finalResponse;
		}else {
			finalResponse.setStatus(false);
            finalResponse.setStatusCode("501");
            finalResponse.setErrorMessages("food  Not present");
            return finalResponse;
		}
	}

	@Override
	public FinalResponse deleteFood(int id) {
		logger.info("deleteFood :: start method" + id);
        try {
        		foodRepository.deleteById(id);
        } catch (InputMismatchException e) {
            logger.error("deleteFood" + e.getMessage());
        }
	
		FinalResponse finalResponse = new FinalResponse();
		if(id>0) {
			finalResponse.setStatus(true);
			finalResponse.setStatusCode("200");
			finalResponse.setMessage("Record is deleted");
			return finalResponse;
		}else {
			finalResponse.setStatus(false);
            finalResponse.setStatusCode("501");
            finalResponse.setMessage("Record not delete");
            finalResponse.setErrorMessages("chech error id ones");
            return finalResponse;
		}
	}

	@Override
	public FinalResponse updateFood(Food food) {
		logger.info("updateFood:: start method" + food);
        try {
        	foodRepository.update(food);
        } catch (InputMismatchException e) {
            logger.error("updateFood" + e.getMessage());
        }	
		FinalResponse finalResponse = new FinalResponse();
		if(food!=null) {
			finalResponse.setStatus(true);
			finalResponse.setStatusCode("200");
			finalResponse.setMessage("Record updated");
			return finalResponse;
		}else {
			finalResponse.setStatus(false);
            finalResponse.setStatusCode("501");
            finalResponse.setMessage("Record not updated");
            finalResponse.setErrorMessages("chech error id ones");
            return finalResponse;
		}
	}
}


