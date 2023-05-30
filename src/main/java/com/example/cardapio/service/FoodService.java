package com.example.cardapio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cardapio.DTO.FoodDTO;
import com.example.cardapio.entities.Food;
import com.example.cardapio.repositories.FoodRepository;

@Service
public class FoodService {
	
	@Autowired
	private FoodRepository repo;
	
	public List<Food> findAll() {
		return repo.findAll();
	}
	
	public Food insert(Food obj) {
		return repo.save(obj);
	}
	
	public Food fromDTO(FoodDTO objDTO) {
		return new Food(objDTO.getId(), objDTO.getTitle(),objDTO.getImage(), objDTO.getPrice());
	}

}
