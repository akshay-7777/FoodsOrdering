package com.extended.foodsordering.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.extended.foodsordering.bean.FinalResponse;
import com.extended.foodsordering.bean.Food;
import com.extended.foodsordering.service.FoodService;

@ExtendWith(MockitoExtension.class)
public class FoodControllerTest {

	@InjectMocks
	private FoodController foodController;

	@Mock
	private FoodService foodService;

	@Test
	@DisplayName("Test case for Inserting FoodController")
	void testInsertFoodController() {
		Food food = new Food();
		food.setFoodType("Main course");
		food.setFoodName("Chicken");
		food.setFoodPrice(350);

		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("Food insert into table");

		when(foodService.insertFood(any(Food.class))).thenReturn(expected);
		FinalResponse actual = foodController.getInsertFood(food);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Test case for Multiple Inserting FoodController")
	void testMultipleInsertFoodController() {
		List<Food> food = new ArrayList<>();
		Food food1 = new Food();
		food1.setFoodType("Main course");
		food1.setFoodName("Chicken");
		food1.setFoodPrice(350);

		Food food2 = new Food();
		food2.setFoodType("Drinks");
		food2.setFoodName("Cold drink");
		food2.setFoodPrice(50);

		food.add(food1);
		food.add(food2);

		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("Food insert into table");

		when(foodService.insertMultipleFood(food)).thenReturn(expected);
		FinalResponse actual = foodController.getInsertMultipleFood(food);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("update the food")
	public void testUpdateFoodController() {
		Food food = new Food();
		food.setFoodName("Cold drink");
		food.setFoodId(3);

		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("Record updated");

		when(foodService.updateFood(food)).thenReturn(expected);
		FinalResponse actual = foodController.getUpdateFood(food);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("delete the food")
	public void testDeleteFoodController() {
		Food food = new Food();
		food.setFoodId(3);

		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("Record is deleted");

		when(foodService.deleteFood(anyInt())).thenReturn(expected);
		FinalResponse actual = foodController.getDeleteFoodById(anyInt());

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Find food by id")
	public void testGetByIdFoodController() {

		Object[] food = { "Main course", "Chicken", 300 };

		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("Ok");
		expected.setMessage("Food present");
		expected.setData(food);

		when(foodService.getFoodById(anyInt())).thenReturn(expected);
		FinalResponse actual = foodController.foodById(anyInt());
		assertEquals(expected, actual);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Find all foods")
	public void testGetAllFoodController() {

		List<Object[]> foods = new ArrayList<>();
		Object[] food1 = { "Main course", "Chicken", 300 };
		Object[] food2 = { "Drinks", "Cold drink", 50 };

		foods.add(food1);
		foods.add(food2);

		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("Ok");
		expected.setMessage("Records present");
		expected.setData(foods);

		when(foodService.getAllFood()).thenReturn(expected);
		FinalResponse actual = foodController.getAllFooddetails();
		assertEquals(expected, actual);
	}
}
