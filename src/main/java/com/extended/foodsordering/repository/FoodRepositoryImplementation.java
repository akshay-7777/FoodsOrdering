package com.extended.foodsordering.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.extended.foodsordering.bean.Food;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class FoodRepositoryImplementation implements FoodRepository{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public Food save(Food food) {
		Query query = entityManager.createNativeQuery("insert into FoodsOrdering.Food values (?,?,?,?)");
		query.setParameter(1, food.getFoodId());
		query.setParameter(2, food.getFoodType());
		query.setParameter(3, food.getFoodName());
		query.setParameter(4, food.getFoodPrice());
		try {
			query.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return food;
	}

	@Override
	@Transactional
	public List<Food> saveAll(List<Food> food) {
		for(Food foods:food) {
			Query query = entityManager.createNativeQuery("insert into FoodsOrdering.Food values (?,?,?,?)");
			query.setParameter(1, foods.getFoodId());
			query.setParameter(2, foods.getFoodType());
			query.setParameter(3, foods.getFoodName());
			query.setParameter(4, foods.getFoodPrice());
			try {
				 query.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return food;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Food> findAll() {
		Query query = entityManager.createNativeQuery("select * from Food");
		List<Food> food = null;
        try {
        	food = query.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return food;
	}

	@Override
	public Food findById(int id) {
		Query query = entityManager.createNativeQuery("select * from Food where Food.Food_id=?");
		query.setParameter(1, id);
		Food get = null;	
        try {
        	get = (Food)query.getSingleResult();	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return get;
	}

	@Override
	@Transactional
	public Food deleteById(int id) {
		Food food = new Food();
		Query query = entityManager.createNativeQuery("delete from Food where Food.Food_id=?");
		query.setParameter(1, id);
        try {
        	query.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return food;
	}

	@Override
	@Transactional
	public Food update(Food food) {
		Query query = entityManager.createNativeQuery
				("update Food set Food_Type=?, Food_name=?, Food_price=? where Food.Food_id=?");
		query.setParameter(1, food.getFoodType());
		query.setParameter(2, food.getFoodName());
		query.setParameter(3, food.getFoodPrice());
		
		query.setParameter(4, food.getFoodId());
        try {
        	query.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return food;

	}

}
