package com.extended.foodsordering.service;

import java.util.List;

import com.extended.foodsordering.bean.FinalResponse;
import com.extended.foodsordering.bean.Food;

public interface FoodService {

	public FinalResponse insertFood(Food food);
    public FinalResponse insertMultipleFood(List<Food> food);
    public FinalResponse getFoodById(int id) ;
    public FinalResponse getAllFood() ;
    public FinalResponse deleteFood(int id);
    public FinalResponse updateFood(Food food);
}
