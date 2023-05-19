package com.example.cardapio.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardapio.entities.Food;
import com.example.cardapio.repositories.FoodRepository;

@RestController
@RequestMapping("food")
public class FoodController {
	
	@Autowired
	private FoodRepository foodRepository;

    @GetMapping
    public List<Food> getAll(){
    	
    	List<Food> foodList = foodRepository.findAll();
    	return foodList;

    }

}
