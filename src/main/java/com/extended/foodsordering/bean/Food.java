package com.extended.foodsordering.bean;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Food {

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodType=" + foodType + ", foodName=" + foodName + ", foodPrice="
				+ foodPrice + "]";
	}
	private int foodId;
	@NotNull(message = "Food Type should be mention")
	@NotBlank
	private String foodType;
	@NotNull(message = "Food Name should be mention")
	@NotBlank
	private String foodName;
	private int foodPrice;
	
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}
	 
	
}
