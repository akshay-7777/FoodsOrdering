package com.extended.foodsordering.repository;

import java.util.List;

import com.extended.foodsordering.bean.Food;

public interface FoodRepository {

	public Food save(Food food);
	public List<Food> saveAll(List<Food> food);
	public List<Food> findAll();
	public Food findById(int id);
	public Food deleteById(int id);
	public Food update(Food Food);
}
