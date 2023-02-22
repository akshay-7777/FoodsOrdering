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

import com.extended.foodsordering.bean.FinalResponse;
import com.extended.foodsordering.bean.Food;
import com.extended.foodsordering.service.FoodService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/food")
public class FoodController {

	@Autowired
	private FoodService foodService;
	
	@GetMapping("/getall")
	public FinalResponse getAllFooddetails(){
		return foodService.getAllFood();
	}
	
	@PostMapping("/save")
	public FinalResponse getInsertFood(@RequestBody @Valid Food food){
		return foodService.insertFood(food);
	}
	
	@DeleteMapping("/deletebyid")
	public FinalResponse getDeleteFoodById(@RequestParam ("foodId") int id) {
		return foodService.deleteFood(id);
	}
	
	@PutMapping("update")
	public FinalResponse getUpdateFood(@RequestBody Food food) {
		return foodService.updateFood(food);
	}
	
	@GetMapping("/getbyid")
	public FinalResponse foodById(@RequestParam ("foodId") int id) {
		return foodService.getFoodById(id);
	}
	
	@PostMapping("/savemultiple")
	public FinalResponse getInsertMultipleFood(@RequestBody @Valid List<Food> food){
		return foodService.insertMultipleFood(food);
	}
}
