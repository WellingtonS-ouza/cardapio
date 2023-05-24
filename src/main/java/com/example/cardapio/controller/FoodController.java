package com.example.cardapio.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardapio.DTO.FoodDTO;
import com.example.cardapio.entities.Food;
import com.example.cardapio.repositories.FoodRepository;


@RestController
@RequestMapping(value ="/food")
public class FoodController {
	
	@Autowired
	private FoodRepository repository;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public void saveFood(@RequestBody FoodDTO data) {
		Food foodData = new Food(data);	
		repository.save(foodData);
		return;
		
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")	
    @GetMapping
    public List<FoodDTO> getAll(){
    	
    	List<Food> foodList = repository.findAll();
    	List<FoodDTO> dto = foodList.stream().map(x-> new FoodDTO(x)).toList();
    	return dto;

    }

}
