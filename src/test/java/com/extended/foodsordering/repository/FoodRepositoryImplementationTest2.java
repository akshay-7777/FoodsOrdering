package com.extended.foodsordering.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.extended.foodsordering.bean.FinalResponse;
import com.extended.foodsordering.bean.Food;

@ExtendWith(MockitoExtension.class)
class FoodRepositoryImplementationTest2 {

	@Mock
	private FoodRepositoryImplementation foodRepositoryImplementation;
	
	@Test
	@DisplayName("Test case for save Repository")
	void testInsertFoodRepository() {
		Food food = new Food();
		food.setFoodType("Main course");
		food.setFoodName("Chicken");
		food.setFoodPrice(350);

		when(foodRepositoryImplementation.save(any(Food.class))).thenReturn(food);
		Food actual = foodRepositoryImplementation.save(food);
		assertNotNull(actual);
	}

	@Test
	@DisplayName("Test case for Multiple Inserting Repository")
	void testMultipleInsertFoodRepository() {
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

		when(foodRepositoryImplementation.saveAll(food)).thenReturn(food);
		List<Food> actual = foodRepositoryImplementation.saveAll(food);
		assertNotNull(actual);
	}

	@Test
	@DisplayName("update the food")
	public void testUpdateFoodRepository() {
		Food food = new Food();
		food.setFoodName("Cold drink");
		food.setFoodId(3);

		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("Record updated");

		when(foodRepositoryImplementation.update(food)).thenReturn(food);
		Food actual = foodRepositoryImplementation.update(food);

		assertNotNull(actual);
	}

	@Test
	@DisplayName("delete the food")
	public void testDeleteFoodRepository() {
		Food food = new Food();
		food.setFoodId(3);

		when(foodRepositoryImplementation.deleteById(anyInt())).thenReturn(food);
		Food actual = foodRepositoryImplementation.deleteById(anyInt());

		assertNotNull(actual);
	}

	@Test
	@DisplayName("Find food by id")
	public void testGetByIdFoodRepository() {

		Object[] food = { "Main course", "Chicken", 300 };

		when(foodRepositoryImplementation.findById(anyInt())).thenReturn(null);
		Food actual = foodRepositoryImplementation.findById(anyInt());
		assertNull(actual);
	}

	@Test
	@DisplayName("Find all foods")
	public void testGetAllFoodRepository() {

		List<Object[]> foods = new ArrayList<>();
		Object[] food1 = { "Main course", "Chicken", 300 };
		Object[] food2 = { "Drinks", "Cold drink", 50 };

		foods.add(food1);
		foods.add(food2);

		when(foodRepositoryImplementation.findAll()).thenReturn(null);
		List<Food> actual = foodRepositoryImplementation.findAll();
		assertNull(actual);
	}
}
